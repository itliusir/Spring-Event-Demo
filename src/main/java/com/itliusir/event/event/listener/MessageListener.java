package com.itliusir.event.event.listener;

import com.itliusir.event.entity.User;
import com.itliusir.event.event.UserRegisterEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 发短信监听
 *
 * @author liugang
 * @since 2018-08-28
 */
@Slf4j
@Component
@Order(1)
public class MessageListener implements ApplicationListener<UserRegisterEvent> {

    @Override
    public void onApplicationEvent(UserRegisterEvent event) {
        log.info("MessageListener---线程:{}---发信息....", Thread.currentThread());
        User user = event.getUser();
        log.info("给手机号为:{} 的 {}先生发信息....", user.getMobile(), user.getName());
    }
}
