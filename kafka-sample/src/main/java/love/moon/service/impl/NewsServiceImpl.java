package love.moon.service.impl;

import com.alibaba.fastjson.JSONObject;
import love.moon.dto.NewsDTO;
import love.moon.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;

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
        ListenableFuture<SendResult<String, Object>>  listenableFuture= kafkaTemplate.send(topic, JSONObject.toJSONString(newsDTO));
        //发送成功回调
        SuccessCallback<SendResult<String, Object>> successCallback = result -> {

            System.out.println("成功");//成功业务逻辑
        };
        //发送失败回调
        FailureCallback failureCallback = ex -> {
            System.out.println("消息发送失败");
            ex.printStackTrace();
            //失败业务逻辑
            throw new RuntimeException(ex);
        };
        listenableFuture.addCallback(successCallback, failureCallback);

    }

}
