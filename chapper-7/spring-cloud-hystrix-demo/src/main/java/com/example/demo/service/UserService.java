package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

/**
 * 描述：
 *
 * @author ay
 * @since 2020/9/13
 */
public interface UserService {

    String getUserCache(Long id);

    String removeCache(Long id);

    User getUserById(Long id);

    List<User> getUserByIds(List<Long> ids);
}
