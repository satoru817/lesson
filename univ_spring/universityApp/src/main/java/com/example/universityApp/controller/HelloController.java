package com.example.universityApp.controller;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Controller
public class HelloController {
    private final RequestMappingHandlerMapping handlerMapping;

    public HelloController(RequestMappingHandlerMapping handlerMapping) {
        this.handlerMapping = handlerMapping;
        System.out.println("======= url mapping");
        Map<RequestMappingInfo, HandlerMethod> handlerMethodMap = this.handlerMapping.getHandlerMethods();
        for( Map.Entry<RequestMappingInfo, HandlerMethod> mapItem : handlerMethodMap.entrySet() ) {
            RequestMappingInfo key = mapItem.getKey();
            HandlerMethod value = mapItem.getValue();

            System.out.println("======= " + (key.getPatternsCondition() != null? key.getPatternsCondition() : key.getPathPatternsCondition())  + " :: " + value);
        }
    }
}
