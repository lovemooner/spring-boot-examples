package love.moon.feature.bean.lifecycle;

import lombok.Data;
import love.moon.annotation.Annotation100;
import love.moon.service.UserService;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Data
public class BeanLifeCycleImpl  implements BeanNameAware,
        InitializingBean, DisposableBean,BeanLifeCycle {

    private String age;

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService){
        System.out.println("LifeCycle: 依赖注入");
        this.userService=userService;
    }

    public BeanLifeCycleImpl() {
        System.out.println("LifeCycle: bean instance, 调用构造器");
    }

//    @PostConstruct // 作用同init-method=init，afterPropertiesSet
//    public void init() {
//        System.out.println("LifeCycle: PostConstruct/init-method");
//    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("LifeCycle: InitializingBean.afterPropertiesSet");
    }

    @PreDestroy    // 不用实现接入DisposableBean，不侵入业务类。等同于destory。
    public void destory(){
        System.out.println("LifeCycle: PreDestroy 调用销毁化方法....");
    }

    @Override
    public void destroy()  {
        System.out.println("LifeCycle: destroy 调用销毁化方法....");
    }

    @Annotation100(confirmMethod = "confirmMethod", cancelMethod = "cancelMethod")
    public void doTest(){
        System.out.println("doTest");
    }


    @Override
    public void setBeanName(String name) {
        System.out.println("LifeCycle: setBeanName");
    }
}
