package love.moon.service.impl;

import com.alibaba.fastjson.JSONObject;
import love.moon.dto.NewsDTO;
import love.moon.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

/**
 * @auther lovemooner
 * @date 2020/2/29 23:40
 * @describe
 */
@Component
public class NewsServiceImpl implements NewsService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${spring.kafka.topics.topic-news}")
    private String topic;

    public void send(NewsDTO newsDTO){
        ListenableFuture  result= kafkaTemplate.send(topic, JSONObject.toJSONString(newsDTO));
    }

}
