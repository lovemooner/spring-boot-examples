package love.moon.feature.bean.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class BeanPostPrcessor100 implements BeanPostProcessor, Ordered {

    /**
     * Bean 实例化之前进行的处理
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if("beanLifeCycleImpl".equals(beanName)){
            System.out.println("LifeCycle: BeanPostProcessor.postProcessBeforeInitialization" );
        }
        return bean;
    }

    /**
     * Bean 实例化之后进行的处理
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if("beanLifeCycleImpl".equals(beanName)){
            System.out.println("LifeCycle: BeanPostProcessor.postProcessAfterInitialization");
        }
        return bean;
    }

    @Override
    public int getOrder() {
        return 10;
    }
}
