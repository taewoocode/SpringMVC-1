package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println( "HelloServlet.service" );
        System.out.println( "req = " + req );
        System.out.println( "resp = " + resp );

        String username = req.getParameter( "username" );
        System.out.println( "username = " + username );

        //단순문자 보내기
        resp.setContentType( "text/plain" );

        //인코딩 정보를 알려줘야 한다.
        resp.setCharacterEncoding( "utf-8" );

        resp.getWriter().write( "hello " + username );

    }
}
