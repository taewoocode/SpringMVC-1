package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelandView;

import java.util.Map;

public interface ControllerV3 {

    ModelandView process(Map<String, String> paramMap);
}
