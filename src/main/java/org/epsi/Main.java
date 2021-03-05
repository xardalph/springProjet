package org.epsi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext myApplicationContext = new AnnotationConfigApplicationContext("org.epsi");
        injected ttt=myApplicationContext.getBean(injected.class);
        System.out.println("hello world!");
        System.out.println(ttt.depend.test);
    }
}
