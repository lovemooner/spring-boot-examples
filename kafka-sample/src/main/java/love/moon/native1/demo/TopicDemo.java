package love.moon.native1.demo;

import kafka.admin.AdminUtils;
import kafka.admin.RackAwareMode;
import kafka.utils.ZkUtils;
import org.apache.kafka.common.security.JaasUtils;
import org.junit.Test;

import java.util.Properties;

/**
 * @author : ndong
 * date : 2020/11/30 16:13
 * desc :
 */
public class TopicDemo {

    @Test
   public void create() {
        ZkUtils zkUtils = ZkUtils.apply("192.168.6.100:2181", 30000, 30000, JaasUtils.isZkSecurityEnabled());
        try {
            // 创建一个单分区单副本名为t1的topic
            AdminUtils.createTopic(zkUtils, "test1", 3, 1, new Properties(), RackAwareMode.Enforced$.MODULE$);
        } catch (Exception e) {
            zkUtils.close();
        }

        System.out.println("end");
    }

}
