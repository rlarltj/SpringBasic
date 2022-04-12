package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ContainerTest {
    
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


    @Test
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String name : beanDefinitionNames) {
            Object bean = ac.getBean(name);
            System.out.println("bean = " + bean);
        }
    }
    @Test
    void findBean() {
        String[] names = ac.getBeanDefinitionNames();

        for (String name : names) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(name);

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(name);
                System.out.println(bean);
            }
        }

    }
}
