//package love.moon.listener;
//
//import com.alibaba.fastjson.JSONObject;
//import lombok.extern.slf4j.Slf4j;
//import love.moon.util.JsonUtil;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.support.Acknowledgment;
//import org.springframework.stereotype.Component;
//
//import java.util.Iterator;
//import java.util.List;
//
///**
// * @auther lovemooner
// * @date 2020/3/1 0:13
// * @describe
// */
//@Slf4j
//@Component
//public class ConsumerManualCommitSample {
//
//    @KafkaListener(
//            id = "group-consumer-2", topics = {"${spring.kafka.topics.my-topic}"},
//            containerFactory = "ContainerFactory2"
//    )
//    public void doListener(List<ConsumerRecord<String, String>> records,Acknowledgment ack) {
//        Iterator<ConsumerRecord<String, String>> iterator= records.iterator();
//        while (iterator.hasNext()){
//            ConsumerRecord<String, String> record= iterator.next();
//            System.out.println(JsonUtil.objectToJson(record));
//        }
//        ack.acknowledge();
//    }
//
//}
