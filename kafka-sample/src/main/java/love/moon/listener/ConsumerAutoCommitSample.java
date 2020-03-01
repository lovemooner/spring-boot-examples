package love.moon.listener;

import lombok.extern.slf4j.Slf4j;
import love.moon.util.JsonUtil;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

/**
 * @auther lovemooner
 * @date 2020/3/1 16:55
 * @describe
 */
@Slf4j
@Component
public class ConsumerAutoCommitSample {

    @KafkaListener(
            id = "group-consumer-1", topics = {"${spring.kafka.topics.topic-news}"},
            containerFactory = "ContainerFactory1"
    )
    public void doListener(List<ConsumerRecord<String, String>> records) {
        Iterator<ConsumerRecord<String, String>> iterator= records.iterator();
        while (iterator.hasNext()){
            ConsumerRecord<String, String> record= iterator.next();
            System.out.println(JsonUtil.objectToJson(record));
        }
    }
}
