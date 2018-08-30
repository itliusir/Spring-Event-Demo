package com.itliusir.event.event.listener;

import com.itliusir.event.dao.CouponMapper;
import com.itliusir.event.event.UserRegisterEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Coupon事件监听
 *
 * @author liugang
 * @since 2018-08-28
 */
@Slf4j
@Component
@Order(2)
public class CouponListener implements ApplicationListener<UserRegisterEvent> {

    @Autowired
    private CouponMapper couponMapper;

    @Override
    public void onApplicationEvent(UserRegisterEvent event) {
        try {
            log.info("CouponListener---线程:{}---发放新人券....", Thread.currentThread());
            couponMapper.sendCoupon(event.getUser().getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
