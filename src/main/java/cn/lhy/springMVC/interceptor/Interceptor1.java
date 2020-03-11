package cn.lhy.springMVC.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 拦截器1
 */
public class Interceptor1 implements HandlerInterceptor {
    /**
     * preHandle()是在所有控制器之前调用
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("interceptor1.preHandle()");
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (user == null){
            String loginPath = request.getContextPath() + "/interceptor/toLogin";
            response.sendRedirect(loginPath);
            /**
             * 当第一个拦截器返回true时，继续调用下一个拦截器
             * 当第一个拦截器返回false时，后面的拦截器不执行，且本类中的postHanle()和afterCompletion()都不执行
             */
            return false;
        }
        return true;
    }

    /**
     * postHandle是在Controller类方法执行完之后的瞬间，渲染视图前执行
     * 可以做ModelAndView的处理
     * Interceptor1的preHandle返回true时，Interceptor1的postHandle执行
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        System.out.println("interceptor1.postHandle()");
    }

    /**
     * 整个请求处理完毕之后的回调方法，即在视图渲染完毕时回调，可以在其中做性能监控
     * 类似于try...catch...finally中，finally里面的代码块
     * Interceptor1的preHandle返回true时，Interceptor1的postHandle执行
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("interceptor1.afterCompletion()");
    }
}
