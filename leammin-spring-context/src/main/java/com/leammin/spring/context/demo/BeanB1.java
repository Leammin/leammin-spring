package com.leammin.spring.context.demo;

import org.springframework.stereotype.Component;

@Component
public class BeanB1 implements InterfaceB {
    @Override
    public String str() {
        return "BeanB1";
    }
}
