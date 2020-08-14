package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: guc
 * @Description: 常用工具
 * @Date: 2020/7/9 10:11
 * @Version: 1.0
 */
public class UsefulUtil {
    public static void main(String[] args) {
        Map<String, String> params = hashMapOf(new KeyValue<>("param1", "参数一"), new KeyValue<>("param2", "参数二"));
        System.out.println(params);
    }

    public static <T> List<T> mutableListOf(T... values) {
        List<T> list = new ArrayList<>();
        if (values != null) {
            for (T v : values) {
                list.add(v);
            }
        }
        return list;
    }

    public static <K, V> Map<K, V> hashMapOf(KeyValue<K, V>... values) {
        Map<K, V> map = new HashMap<>();
        if (values != null) {
            for (KeyValue<K, V> value : values) {
                map.put(value.getKey(), value.getValue());
            }
        }
        return map;
    }

    public static class KeyValue<K, V> {
        private K key;
        private V value;

        public KeyValue(K k, V v) {
            key = k;
            value = v;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
