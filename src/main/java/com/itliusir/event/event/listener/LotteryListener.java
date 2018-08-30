package com.itliusir.event.event.listener;

import com.itliusir.event.entity.User;
import com.itliusir.event.event.UserRegisterEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 抽奖监听
 *
 * @author liugang
 * @since 2018-08-28
 */
@Slf4j
@Component
@Order(3)
public class LotteryListener implements ApplicationListener<UserRegisterEvent> {

    @Override
    public void onApplicationEvent(UserRegisterEvent event) {
        log.info("LotteryListener---线程:{}---抽奖ing....", Thread.currentThread());
        User user = event.getUser();
        log.info("手机号为:{}的用户:{}抽中了一台18款MBP", user.getMobile(), user.getName());
    }
}
