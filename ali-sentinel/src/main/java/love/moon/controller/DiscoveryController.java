package love.moon.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : ndong
 * date : 2021/4/16 13:31
 * desc :
 */
@RestController
@RequestMapping("/discovery")
public class DiscoveryController {

    @NacosInjected
    private NamingService namingService;

    @GetMapping("/get")
    @ResponseBody
    public List<Instance> get(@RequestParam String serviceName) throws NacosException {
        System.out.println(namingService.getServerStatus());
        return namingService.getAllInstances(serviceName);
    }
}
