package love.moon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther lovemooner
 * @date 2019/12/23 15:41
 * @describe
 */
@Service
public class ServiceA {


    private ServiceB serviceB;

    @Autowired
    public ServiceA(ServiceB serviceB){
          this.serviceB=serviceB;
    }
}
