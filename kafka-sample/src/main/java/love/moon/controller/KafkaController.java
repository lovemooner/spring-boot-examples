package love.moon.controller;

import lombok.extern.slf4j.Slf4j;
import love.moon.dto.MessageDTO;
import love.moon.service.impl.KafkaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping()
    public String send(@RequestBody MessageDTO dto) {
        service.send(dto);
        return "OK";
    }
}
