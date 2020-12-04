package love.moon.native1.demo;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;
import java.util.concurrent.Future;

public class KafkaProducerDemo {
    private final Producer<String, String> kafkaProducer;

    private KafkaProducerDemo() {
        kafkaProducer = createKafkaProducer();
    }

    private Producer<String, String> createKafkaProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", KafkaConstants.BOOTSTRAP_SERVERS);
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> kafkaProducer = new KafkaProducer<>(props);
        return kafkaProducer;
    }

    void produce() {
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String key = "key" + i;
            String data = "hello kafka message:" + key;
//            Future<RecordMetadata> future=  kafkaProducer.send(new ProducerRecord<>(KafkaConstants.TOPIC,1, key, data));
            Future<RecordMetadata> future=  kafkaProducer.send(new ProducerRecord<>(KafkaConstants.TOPIC, key, data));
            System.out.println("producer:"+data);
        }
    }

    public static void main(String[] args) {
        new KafkaProducerDemo().produce();
    }
}
