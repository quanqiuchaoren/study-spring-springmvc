package cn.lhy.springMVC.ExceptionHandler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 处理异常处理的类：加上@ControllerAdvice注解
 * 把这个处理ArithmeticException异常的方法定义在ExceptionHandlerController里面：
 *      1.如果把异常处理的方法，放到某个具体的Controller中，那只能处理该类中的方法
 *      2.可以在本类中定义多个方法，用于处理异常
 *      3.优先使用ModelAndView来把异常信息注入到请求域里面去
 *      4.其次选择用model把错误信息注入到请求域里面去
 *
 * 除了使用异常信息类来处理异常，还可以直接在SpringMVC.xml文件里面配置一个类
 */
//@ControllerAdvice
public class RuntimeExceptionHandler {

    @ExceptionHandler({ArithmeticException.class})
    public String handleArithmeticException(ArithmeticException exception, Model model) {
        System.out.println("===发生了数学异常" + exception.getMessage());
        model.addAttribute("exception", exception.getMessage());
        return "exceptionHandle/error";
    }

    @ExceptionHandler({RuntimeException.class})
    public ModelAndView handleRuntimeException(RuntimeException exception) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("exceptionHandle/error");
        modelAndView.addObject("exception", exception);
        System.out.println("===发生了运行时异常" + exception.getMessage());
        return modelAndView;
    }

    @ExceptionHandler({Exception.class})
    public String handleException(Exception exception, Model model) {
        System.out.println("===发生了异常" + exception.getMessage());
        model.addAttribute("exception", exception.getMessage());
        return "exceptionHandle/error";
    }
}
