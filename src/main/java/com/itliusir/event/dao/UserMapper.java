package com.itliusir.event.dao;

import com.itliusir.event.entity.Coupon;
import com.itliusir.event.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 模拟持久层
 *
 * @author liugang
 * @since 2018-08-28
 */
@Repository
public class UserMapper {

    private Map<String, User> userMap = new ConcurrentHashMap<>();


    public void saveUser(User user) throws Exception {
        userMap.put(user.getId(), user);
    }

    public User getUser(String userId) throws Exception {
        return userMap.get(userId);
    }

}
