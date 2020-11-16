package com.ay.oauth2.userservice;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * 描述：UserController
 * @author ay
 * @since 2020-10-25
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private TokenStore tokenStore;

    /***
     * 描述：获取登录用户名（读权限或写权限可访问）
     * @param authentication
     * @return
     */
    @PreAuthorize("hasAuthority('READ') or hasAuthority('WRITE')")
    @GetMapping("name")
    public String getName(OAuth2Authentication authentication) {
        return authentication.getName();
    }

    /**
     * 描述：获取用户信息（读权限或写权限可访问）
     *
     * @param authentication
     * @return
     */
    @PreAuthorize("hasAuthority('READ') or hasAuthority('WRITE')")
    @GetMapping
    public OAuth2Authentication read(OAuth2Authentication authentication) {
        return authentication;
    }

    /**
     * 描述：获取访问令牌中的额外信息（只有写权限可以访问）
     * @param authentication
     * @return
     */
    @PreAuthorize("hasAuthority('WRITE')")
    @PostMapping
    public Object write(OAuth2Authentication authentication) {
        OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
        OAuth2AccessToken accessToken = tokenStore.readAccessToken(details.getTokenValue());
        return accessToken.getAdditionalInformation().getOrDefault("userDetails", null);
    }
}
