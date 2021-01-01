package com.example.demo.password;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 自定义密码加密，使用明文匹配
 * @author ay
 * @since 2020-10-16
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}