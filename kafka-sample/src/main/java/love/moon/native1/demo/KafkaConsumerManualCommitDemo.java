package love.moon.native1.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * @author : ndong
 * date : 2021/1/7 10:14
 * desc :
 */
public class KafkaConsumerManualCommitDemo {

    private final KafkaConsumer<String, String> consumer;

    private KafkaConsumerManualCommitDemo() {
        Properties props = new Properties();
        props.put("bootstrap.servers", KafkaConstants.BOOTSTRAP_SERVERS);
        props.put("group.id", "group-test1");
//        props.put("concurrency", "3");
        props.put("enable.auto.commit", false);
        props.put("auto.offset.reset", "latest");
        props.put("max.poll.records", 10);
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumer = new KafkaConsumer<>(props);
    }

    void consume() {
        consumer.subscribe(Arrays.asList(KafkaConstants.TOPIC));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records)
                System.out.printf("consumer: offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
        }
    }

    public static void main(String[] args) {
        new KafkaConsumerManualCommitDemo().consume();
    }
}
