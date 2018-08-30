package com.itliusir.event.dao;

import com.itliusir.event.entity.Coupon;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Repository
public class CouponMapper {

    private Map<String, List<Coupon>> couponMap = new ConcurrentHashMap<>();

    public void sendCoupon(String userId) throws Exception {
        List<Coupon> coupons = new ArrayList<>(16);
        Coupon coupon = new Coupon();
        coupon.setId("test1");
        coupon.setAmount(1);
        coupon.setMoney(100.00);
        coupon.setName("199-100满减");
        coupon.setType(0);
        coupons.add(coupon);

        Coupon coupon1 = new Coupon();
        coupon1.setId("test2");
        coupon1.setAmount(1);
        coupon1.setMoney(50.00);
        coupon1.setName("149-50满减");
        coupon1.setType(0);
        coupons.add(coupon1);

        couponMap.put(userId, coupons);
        log.info("已发放新人券:{},{}", coupon.getName(), coupon1.getName());
    }

    public List<Coupon> getCoupon(String userId) throws Exception {
        return couponMap.get(userId);
    }
}
