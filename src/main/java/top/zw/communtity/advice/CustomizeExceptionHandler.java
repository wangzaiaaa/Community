package top.zw.communtity.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.zw.communtity.exception.CustomizeException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CustomizeExceptionHandler {
    @ExceptionHandler(Exception.class)
    ModelAndView handle(HttpServletRequest request, Throwable e, Model model){
        if(e instanceof CustomizeException){
            model.addAttribute("message",e.getMessage());
        }else{
            model.addAttribute("message","服务不可用");
        }
        return new ModelAndView("error");
    }

}
