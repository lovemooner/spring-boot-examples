package love.moon.common;

import lombok.Data;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.AbstractMessageListenerContainer;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther lovemooner
 * @date 2020/3/1 0:23
 * @describe
 */
@Configuration
public class KafkaConsumerConfiguration {

    @Autowired
    private KafkaProperties properties;

    @Bean
    public NewTopic initialTopic() {
        return new NewTopic("native-demo",3, (short) 1 );
//        return new NewTopic("news-sample3",3, (short) 1 );
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> ContainerFactory1() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(getCommonProperties()));
        factory.setBatchListener(true);
        factory.setConcurrency(properties.getConcurrency());
        factory.getContainerProperties().setPollTimeout(properties.getPollTimeout());
        return factory;
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> ContainerFactory2() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(getCommonProperties()));
        factory.setBatchListener(true);
        factory.setConcurrency(properties.getConcurrency());
        factory.getContainerProperties().setPollTimeout(properties.getPollTimeout());
        factory.getContainerProperties().setAckMode(AbstractMessageListenerContainer.AckMode.MANUAL);
        return factory;
    }


    public Map<String, Object> getCommonProperties() {
        Map<String, Object> map = new HashMap<>();
        map.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
        map.put(ConsumerConfig.CLIENT_ID_CONFIG, "consumer-test");
        map.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, properties.isEnableAutoCommit());
        map.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, properties.getAutoCommitIntervalMs());
        map.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, properties.getAutoOffsetReset());
        map.put(ConsumerConfig.GROUP_ID_CONFIG, properties.getGroupId());
        map.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, properties.getSessionTimeoutMs());
        map.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, properties.getKeySerializer());
        map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, properties.getValueSerializer());
        map.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, properties.getMaxPollIntervalMs());
        map.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, properties.getMaxPollRecords());
        return map;
    }

    @Data
    @Component
    @ConfigurationProperties(prefix = "spring.kafka.consumer")
    class KafkaProperties {
        @Value("${spring.kafka.bootstrap-servers}")
        private String bootstrapServers;
        private String groupId;
        //group内客户端数量
        private int concurrency;
        private String autoOffsetReset;
        private String sessionTimeoutMs;
        private boolean enableAutoCommit;
        private String autoCommitIntervalMs;
        private String  maxPollIntervalMs; //一次拉取消息数量
        private String maxPollRecords; //一次拉取消息数量
        private long pollTimeout;
        private String keySerializer;
        private String valueSerializer;
        private String ackMode;
    }
}
