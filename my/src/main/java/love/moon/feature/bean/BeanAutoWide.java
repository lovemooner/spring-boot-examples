package love.moon.feature.bean;

import lombok.Data;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dongnan
 * @date 2020/6/16 13:38
 */
public class BeanAutoWide {

    private static Map<String, Object> cacheMap = new HashMap<>(2);

    public static void main(String[] args) {
        // 假装扫描出来的对象
        Class[] classes = {A.class, B.class};
        for (Class aClass : classes) {
            getBean(aClass);
        }
    }

    /**
     * 解决循环依赖
     * @param beanClass
     * @param <T>
     * @return
     */
    @SneakyThrows
    private static <T> T getBean(Class<T> beanClass) {
        String beanName = beanClass.getSimpleName().toLowerCase();
        if (cacheMap.containsKey(beanName)) {
            return (T) cacheMap.get(beanName);
        }
        Object object = beanClass.getDeclaredConstructor().newInstance();
        cacheMap.put(beanName, object);
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            // 获取需要注入字段的class
            Class<?> fieldClass = field.getType();
            String fieldBeanName = fieldClass.getSimpleName().toLowerCase();
            // 如果缓存没有 继续创建
            field.set(object, cacheMap.containsKey(fieldBeanName)
                    ? cacheMap.get(fieldBeanName) : getBean(fieldClass));
        }
        return (T) object;
    }

    @Data
    public class A {
        private B b;
    }

    @Data
    public class B {
        private A a;
    }
}
