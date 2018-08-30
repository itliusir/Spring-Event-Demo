package com.itliusir.event.event;

import com.itliusir.event.entity.User;
import org.springframework.context.ApplicationEvent;

/**
 * 用户注册事件
 *
 * @author liugang
 * @since 2018-08-28
 */
public class UserRegisterEvent extends ApplicationEvent {

    private static final long serialVersionUID = -4829855648590354032L;

    /**
     * Create a new ApplicationEvent.
     *
     * @param user the object on which the event initially occurred (never {@code null})
     */
    public UserRegisterEvent(User user) {
        super(user);
    }

    public User getUser() {
        return (User) source;
    }
}
