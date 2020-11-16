package com.ay.oauth2.client;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 描述：TestController
 * @author ay
 * @since 2020-10-25
 */
@RestController
public class TestController {

    @Resource
    OAuth2RestTemplate restTemplate;

    @GetMapping("/protectPage")
    public ModelAndView securedPage(OAuth2Authentication authentication) {
        return new ModelAndView("protectPage")
                .addObject("authentication", authentication);
    }

    @GetMapping("/getUserName")
    public String getUserName() {
        ResponseEntity<String> responseEntity =
                restTemplate.getForEntity("http://localhost:8081/user/name", String.class);
        return responseEntity.getBody();
    }
}
