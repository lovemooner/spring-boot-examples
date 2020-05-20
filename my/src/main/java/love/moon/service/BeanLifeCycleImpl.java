package love.moon.service;

import love.moon.annotation.Annotation100;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class BeanLifeCycleImpl  implements InitializingBean,BeanLifeCycle {


    public BeanLifeCycleImpl() {
        System.out.println("beanLifeCycleImpl Construtor");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("beanLifeCycleImpl InitializingBean--afterPropertiesSet");
    }

    @PostConstruct // 等同与init-method=init
    public void init() {
        System.out.println("beanLifeCycleImpl  PostConstruct/init-method");
    }

    @PreDestroy    // 等同于destory-method
    public void destory(){
        System.out.println("beanLifeCycleImpl 调用销毁化方法....");
    }

    @Annotation100(confirmMethod = "confirmMethod", cancelMethod = "cancelMethod")
    public void doTest(){
        System.out.println("doTest");

    }


}
