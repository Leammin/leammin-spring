package com.leammin.spring.beans;

import com.leammin.spring.beans.demo.MyTestBean;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class BeanFactoryTest {

    @Test
    public void testSimpleLoad() throws IOException {
        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanDemoTest.xml"));
        MyTestBean myTestBean = (MyTestBean) bf.getBean("abc");
        Assertions.assertThat(myTestBean).isNotNull()
                .extracting(MyTestBean::getTestStr).isEqualTo("test");
    }

    @Test
    public void testCircleByConstructor() {
        Assertions.assertThatExceptionOfType(BeanCreationException.class)
                .isThrownBy(() -> {
                    try {
                        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanCircleTest.xml"));
                        bf.getBean("testA");
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw e;
                    }
                });
    }

    @Test
    public void testPrototypeCircleByConstructor() {
        Assertions.assertThatExceptionOfType(BeanCreationException.class)
                .isThrownBy(() -> {
                    try {
                        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("beanPrototypeCircleTest.xml"));
                        bf.getBean("testA");
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw e;
                    }
                });
    }
}
