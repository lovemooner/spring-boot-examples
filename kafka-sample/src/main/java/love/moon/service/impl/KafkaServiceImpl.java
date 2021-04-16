package love.moon.service.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import love.moon.dto.MessageDTO;
import love.moon.service.KafkaService;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
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
@Slf4j
@Component
public class KafkaServiceImpl implements KafkaService {

    @Autowired(required = false)
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${spring.kafka.topics.my-topic}")
    private String topic;

    public void send(MessageDTO dto) {
        ListenableFuture<SendResult<String, Object>> listenableFuture = kafkaTemplate.send(topic, JSONObject.toJSONString(dto));
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

    @Autowired(required = false)
    private KafkaConsumer<String, String> consumer;

    @Override
    public void sendWithCallback(MessageDTO dto) {
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(1000);
            if (records.isEmpty()) {
                log.debug("record is empty");
                continue;
            }
            //do process
            System.out.println("do process");
            consumer.commitAsync((offsets, exception) -> {
                System.out.printf("Callback, offset: %s, exception %s%n", offsets, exception);
            });
        }


    }

}
