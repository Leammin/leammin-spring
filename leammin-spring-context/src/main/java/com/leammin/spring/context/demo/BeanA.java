package com.leammin.spring.context.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanA {
    @Autowired
    private InterfaceB b;

    public String str() {
        return b.str();
    }
}
