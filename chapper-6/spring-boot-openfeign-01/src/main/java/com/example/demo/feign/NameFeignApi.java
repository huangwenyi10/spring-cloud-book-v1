package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

//参考
//【1】https://www.leiue.com/difference-between-feign-and-ribbon
/**
 * 描述
 * @author ay
 * @since 2020-04-20
 */
@FeignClient("openfeign")
interface NameFeignApi {

	@RequestMapping("/test/name")
	String getName();

}