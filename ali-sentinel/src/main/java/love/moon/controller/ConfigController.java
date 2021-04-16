package love.moon.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.*;

/**
 * @author : ndong
 * date : 2021/4/16 14:44
 * desc :
 */
@RestController
@RequestMapping("/config")
public class ConfigController {

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    @NacosValue(value = "${str}", autoRefreshed = true)
    private String str;

    @GetMapping("/get")
    public String get() {
        return str;
    }
}
