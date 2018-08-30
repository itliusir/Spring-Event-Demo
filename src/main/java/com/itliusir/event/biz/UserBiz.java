package com.itliusir.event.biz;

import com.itliusir.event.entity.Coupon;
import com.itliusir.event.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户接口
 *
 * @author liugang
 * @since 2018-08-28
 */
public interface UserBiz {

    /**
     * 注册
     *
     * @param user
     * @throws Exception
     * @author liugang 2018-08-28 15:06
     */
    void register(User user) throws Exception;

    /**
     * 查询当前用户信息
     *
     * @param userId
     * @return User
     * @throws Exception
     * @author liugang 2018-08-28 15:06
     */
    User getUser(String userId) throws Exception;

    /**
     * 查询当前用户拥有卡券信息
     *
     * @param userId
     * @return List<Coupon>
     * @throws Exception
     * @author liugang 2018-08-28 15:06
     */
    List<Coupon> getCoupon(String userId) throws Exception;
}
