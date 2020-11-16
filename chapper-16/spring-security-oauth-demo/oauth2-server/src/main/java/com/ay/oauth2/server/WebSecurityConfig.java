package com.ay.oauth2.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * 描述：WebSecurityConfig
 * @author ay
 * @since 2020-10-25
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private DataSource dataSource;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                //配置使用BCryptPasswordEncoder哈希来保存用户的密码
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //开放/login（用于登陆）和/oauth/authorize（用于换授权码）路径
                .antMatchers("/login", "/oauth/authorize")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                //设置/login使用表单验证进行登录。
                .formLogin().loginPage("/login");
    }
}
