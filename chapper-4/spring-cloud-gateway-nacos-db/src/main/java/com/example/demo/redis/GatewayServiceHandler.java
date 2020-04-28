package com.example.demo.redis;

import com.example.demo.model.GatewayRoute;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.net.URI;
import java.util.*;

/**
 * 描述：
 *
 * @author ay
 * @since 2020-04-27
 */
@Service
public class GatewayServiceHandler implements ApplicationEventPublisherAware, CommandLineRunner {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Resource
    private RedisRouteDefinitionRepository redisRouteDefinitionRepository;

    private ApplicationEventPublisher publisher;

    @Override
    public void run(String... args) throws Exception {
        this.loadRouteConfig();
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public String loadRouteConfig() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from gateway_route");
        List<GatewayRoute> gatewayRoutes = getGatewayRouteList(list);
        gatewayRoutes.forEach(gatewayRoute -> {
            RouteDefinition definition = handleData(gatewayRoute);
            redisRouteDefinitionRepository.save(Mono.just(definition)).subscribe();

        });
        this.publisher.publishEvent(new RefreshRoutesEvent(this));
        System.out.println("=======网关配置信息===加载完成======");
        return "success";
    }


    private RouteDefinition handleData(GatewayRoute gatewayRoute){
        RouteDefinition definition = new RouteDefinition();
        Map<String, String> predicateParams = new HashMap<>(8);
        PredicateDefinition predicate = new PredicateDefinition();

        FilterDefinition filterDefinition = new FilterDefinition();
        Map<String, String> filterParams = new HashMap<>(8);

        URI uri = null;
        if(gatewayRoute.getUri().startsWith("http")){
            //http地址
            uri = UriComponentsBuilder.fromHttpUrl(gatewayRoute.getUri()).build().toUri();
        }else{
            //注册中心
            uri = UriComponentsBuilder.fromUriString("lb://"+gatewayRoute.getUri()).build().toUri();
        }
        definition.setId(gatewayRoute.getServiceId());
        // 名称是固定的，spring gateway会根据名称找对应的PredicateFactory
        predicate.setName("Path");
        predicateParams.put("pattern", gatewayRoute.getPredicates() == null? "": gatewayRoute.getPredicates().toString());
        predicate.setArgs(predicateParams);

        // 名称是固定的, 路径去前缀
        filterDefinition.setName("StripPrefix");
        //filterParams.put("_genkey_0", gatewayRoute.getFilters() == null? "" : gatewayRoute.getFilters().toString());
        filterDefinition.setArgs(filterParams);

        definition.setPredicates(Arrays.asList(predicate));
        definition.setFilters(Arrays.asList(filterDefinition));
        definition.setUri(uri);
        definition.setOrder(Integer.parseInt(gatewayRoute.getOrder()));

        return definition;
    }


    public List<GatewayRoute> getGatewayRouteList(List<Map<String, Object>> list){

        List<GatewayRoute> gatewayRouteList = new ArrayList<>();
        for(Map<String, Object> map: list){
            GatewayRoute gatewayRoute = new GatewayRoute();
            gatewayRoute.setId(Long.valueOf(map.get("id") == null?"" : map.get("id").toString()));
            gatewayRoute.setServiceId(map.get("service_id") == null?"" : map.get("service_id").toString());
            gatewayRoute.setUri(map.get("url") == null? "": map.get("url").toString());
            gatewayRoute.setPredicates(map.get("predicates") == null? "": map.get("predicates").toString());
            gatewayRoute.setOrder(map.get("order") == null? "": map.get("order").toString());
            gatewayRoute.setFilters(map.get("filters") == null? "" : map.get("filters").toString());
            gatewayRoute.setCreatorId(map.get("creator_id") == null? "" : map.get("creator_id").toString());
            gatewayRoute.setUpdateId(map.get("update_id") == null? "": map.get("update_id").toString());
            gatewayRoute.setCreateDate(new Date());
            gatewayRoute.setUpdateDate(new Date());
            gatewayRoute.setRemarks(map.get("remarks") == null? "" : map.get("remarks").toString());
            gatewayRoute.setDelFlag(map.get("del_flag") == null? "" : map.get("del_flag").toString());
            gatewayRouteList.add(gatewayRoute);
        }
        return gatewayRouteList;
    }
}
