package love.moon.native1.demo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import love.moon.util.JsonUtil;
import love.moon.util.ThreadPoolUtils;
import org.apache.kafka.clients.producer.*;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author : ndong
 * date : 2020/12/25 14:58
 * desc :
 */
@Slf4j
public class ProducerDemo100 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new ProducerDemo100().produce();
    }

    private final Producer<String, String> kafkaProducer;

    private ProducerDemo100() {
        kafkaProducer = createKafkaProducer();
    }

    private Producer<String, String> createKafkaProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", KafkaConstants.BOOTSTRAP_SERVERS);
        props.put("acks", "all");
        props.put("retries", 3);
        props.put("batch.size", 16384);
        props.put("linger.ms", 100);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> kafkaProducer = new KafkaProducer<>(props);
        return kafkaProducer;
    }

    void produce() throws ExecutionException, InterruptedException {
        Gps gps = new Gps();
        gps.setDesc("async");
        gps.setDevGbId("32050000031121000129");
        gps.setLatitude("26.083906");
        gps.setLongitude("119.323099");
        gps.setTimestamp(System.currentTimeMillis());
        gps.setUserCode("320381199710241010");
        String gpsStr = JsonUtil.objectToJson(gps);
//        send(gpsStr);
//        syncSend(gpsStr);
            ThreadPoolUtils.getInstance().excute(() -> {
                while (true) {
                    asyncSend(gpsStr);
                    try {
                        Thread.sleep(1000l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });


//        System.out.println("done");

    }

    /**
     * fire-and-forget：只发不管结果。发送失败生产者自动尝试重发，可能丢消息
     *
     * @param msg
     * @throws ExecutionException
     * @throws InterruptedException
     */
    void send(String msg) {
        //new ProducerRecord时可指定partition和key
        ProducerRecord record = new ProducerRecord<>(KafkaConstants.TOPIC, msg);
        //send不阻塞，future.get阻塞
        kafkaProducer.send(record);
        log.info("send down,fire-and-forget");
    }

    /**
     * Synchronous send：调用send返回的Future，可用get()判断消息发送成功与否。
     *
     * @param msg
     * @throws ExecutionException
     * @throws InterruptedException
     */
    void syncSend(String msg) throws ExecutionException, InterruptedException {
        ProducerRecord record = new ProducerRecord<>(KafkaConstants.TOPIC, msg);
        Future<RecordMetadata> future = kafkaProducer.send(record);
        System.out.println(future.isDone());
        RecordMetadata metadata = future.get();
        log.info("syncSend down,meta:{}", JsonUtil.objectToJson(metadata));
    }

    /**
     * Asynchronous send：send提供了回调方法，接收到broker结果后回调此方法
     *
     * @param msg
     */
    void asyncSend(String msg) {
        ProducerRecord record = new ProducerRecord<>(KafkaConstants.TOPIC, msg);
        kafkaProducer.send(record, new DemoProducerCallback());
    }

    class DemoProducerCallback implements Callback {
        @Override
        public void onCompletion(RecordMetadata recordMetadata, Exception e) {
            log.info("asyncSend send Callback,meta:{}", JsonUtil.objectToJson(recordMetadata));
            if (e != null) {
                log.error(e.getMessage(), e);
            }
        }
    }

    @Data
    class Gps {
        private String devGbId;
        private String latitude;
        private String longitude;
        private Long timestamp;
        private String userCode;
        private String desc;
    }

}
