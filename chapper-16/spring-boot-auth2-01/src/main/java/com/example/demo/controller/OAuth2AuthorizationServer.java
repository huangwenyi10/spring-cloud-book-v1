package com.example.demo.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import javax.annotation.Resource;

/**
 * 认证服务器
 * @author ay
 * @since 2020-10-19
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                // 允许表单认证
                .allowFormAuthenticationForClients();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()
                .withClient("ay-client").secret(passwordEncoder.encode("123456"))
                //4种授权方式：,"",
                //"authorization_code":授权码模式
                //"client_credentials":客户端模式
                //"password":密码模式
                //"implicit":简化模式
                //"refresh_token":通过以上授权获得的刷新令牌来获取新的令牌
                .authorizedGrantTypes("authorization_code", "refresh_token")
                .authorities("READ_ONLY_CLIENT")
                .scopes("read_user_info")
                .resourceIds("oauth2-resource")
                //重定向url
                .redirectUris("http://localhost:18087/login")
                .accessTokenValiditySeconds(1200)
                .refreshTokenValiditySeconds(240000);
    }
}