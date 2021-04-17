package com.leammin.spring.context;

import com.leammin.spring.context.demo.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class ApplicationContextTest {

    @Test
    public void testSimpleLoad() throws IOException {
        ApplicationContext bf = new ClassPathXmlApplicationContext("beanDemoTest.xml");
        MyTestBean myTestBean = (MyTestBean) bf.getBean("abc");
        Assertions.assertThat(myTestBean).isNotNull()
                .extracting(MyTestBean::getTestStr).isEqualTo("test");
    }


    @Test
    public void testAutowire() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanA.class);
        context.register(BeanB1.class);
        context.register(BeanB2.class);
        context.refresh();
        BeanA bean = context.getBean(BeanA.class);
//        InterfaceB bean = context.getBean(InterfaceB.class);
        System.out.println(bean.str());
    }

    @Test
    public void testConfig() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        context.register(BeanA.class);
        context.register(TestConfig.class);
        context.refresh();
        MyTestBean bean = context.getBean(MyTestBean.class);
    }
}
