package cn.lhy.springMVC.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器2
 */
public class Interceptor2 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("interceptor2.preHandle()");
        /**
         * 当第二个拦截器的preHandle()返回true时，按照正常流程执行
         * 当第二个拦截器的preHandle()返回false时，第二个拦截器的postHandle()和afterCompletion()不执行，
         *      直接回调第一个拦截器的afterCompletion()，进行拦截器后处理
         */
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("interceptor2.postHandle()");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("interceptor2.afterCompletion()");
    }
}
