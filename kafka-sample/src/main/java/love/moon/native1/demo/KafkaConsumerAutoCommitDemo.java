package love.moon.native1.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class KafkaConsumerAutoCommitDemo {
    private final KafkaConsumer<String, String> consumer;

    private KafkaConsumerAutoCommitDemo() {
        Properties props = new Properties();
        props.put("bootstrap.servers", KafkaConstants.BOOTSTRAP_SERVERS);
        props.put("group.id", "group-test1");
        props.put("concurrency", "3");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "2000");
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
        new KafkaConsumerAutoCommitDemo().consume();
    }
}

