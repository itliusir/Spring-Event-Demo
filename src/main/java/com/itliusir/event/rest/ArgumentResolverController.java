package com.itliusir.event.rest;

import com.itliusir.event.biz.UserBiz;
import com.itliusir.event.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 测试参数解析器
 *
 * @author liugang
 * @since 2018-08-29
 */
@RestController
public class ArgumentResolverController {

    @GetMapping("/userInfo")
    public User getUser(User user) {
        return user;
    }
}

@Configuration
class ApplicationWebMvcConfigurer extends WebMvcConfigurerAdapter {

    @Autowired
    private UserHandlerMethodArgumentResolver userHandlerMethodArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(userHandlerMethodArgumentResolver);
    }
}

@Component
class UserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private UserBiz userBiz;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().equals(User.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        return userBiz.getUser(request.getHeader("userId"));
    }
}
