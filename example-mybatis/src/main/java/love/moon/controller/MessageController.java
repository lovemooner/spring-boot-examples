//package love.moon.controller;
//
//import lombok.extern.slf4j.Slf4j;
//import love.moon.dto.PushMessageDTO;
//import love.moon.dto.PushResultDTO;
//import love.moon.pojo.UpsProps;
//import love.moon.util.JsonUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.UUID;
//
///**
// * @auther dongnan
// * @date 2019/6/17 10:44
// * @describe
// */
//@Slf4j
//@RestController
//@RequestMapping("/kedaservices/v3")
//public class MessageController {
//
//    @Value("${ups.server.ip:null}")
//    private String PUSH_SERVER_URL;
//
//    @Autowired
//    private UpsProps upsProps;
//
//    @PostMapping("/upsserver/send")
//    public PushResultDTO message(@RequestBody PushMessageDTO message) {
//        log.info(JsonUtil.objectToJson(message));
//        PushResultDTO resultDTO = new PushResultDTO();
//        resultDTO.setResult(0);
//        resultDTO.setMessageId(UUID.randomUUID().toString());
//        resultDTO.setDesc("success");
//        return resultDTO;
//    }
//}
