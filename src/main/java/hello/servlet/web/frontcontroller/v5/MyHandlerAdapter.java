package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelandView;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public interface MyHandlerAdapter {

    boolean supports(Object handler);

    ModelandView handler(HttpServletRequest request, HttpServletRequest request1, Object handler) throws ServletException, IOException;
}
