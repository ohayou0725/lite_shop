package com.ohayou.liteshop.async.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author liyan
 * @date 2021/2/1 下午9:16
 */
public class UserRegisterEvent extends ApplicationEvent {
    private Long userId;


    public UserRegisterEvent(Object source) {
        super(source);
    }

    public UserRegisterEvent(Object source,Long userId) {
        super(source);
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
