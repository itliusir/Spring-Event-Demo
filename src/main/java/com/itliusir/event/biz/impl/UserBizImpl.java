package com.itliusir.event.biz.impl;

import com.itliusir.event.biz.UserBiz;
import com.itliusir.event.dao.CouponMapper;
import com.itliusir.event.dao.UserMapper;
import com.itliusir.event.entity.Coupon;
import com.itliusir.event.entity.User;
import com.itliusir.event.event.UserRegisterEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户业务处理类
 *
 * @author liugang
 * @since 2018-08-28
 */
@Slf4j
@Service
public class UserBizImpl implements UserBiz {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CouponMapper couponMapper;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Override
    public void register(User user) throws Exception {
        //注册
        log.info("Event---注册....");
        userMapper.saveUser(user);
        log.info("SendRegisterEvent---线程:{}---注册成功", Thread.currentThread());
        publisher.publishEvent(new UserRegisterEvent(user));
    }

    @Override
    public User getUser(String userId) throws Exception {
        return userMapper.getUser(userId);
    }

    @Override
    public List<Coupon> getCoupon(String userId) throws Exception {
        return couponMapper.getCoupon(userId);
    }
}
