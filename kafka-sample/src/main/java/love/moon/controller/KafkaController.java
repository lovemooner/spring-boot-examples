package love.moon.controller;

import lombok.extern.slf4j.Slf4j;
import love.moon.dto.MessageDTO;
import love.moon.service.impl.KafkaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @auther lovemooner
 * @date 2020/2/29 23:47
 * @describe
 */
@RestController
@RequestMapping("/kafka")
@Slf4j
public class KafkaController {

    @Autowired
    private KafkaServiceImpl service;

    @GetMapping("/test")
    public String send(){
        return "ok";
    }

    @GetMapping("/send1")
    public String send(@RequestBody MessageDTO dto) {
        service.send(dto);
        return "OK";
    }

    @GetMapping("/send2")
    public String send2(@RequestBody MessageDTO dto) {
        service.sendWithCallback(dto);
        return "OK";
    }
}
