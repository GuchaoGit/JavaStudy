package bean;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @Author guc
 * @Date 2019/11/26 14:16
 * @Description Java 8 Stream
 */
public class StreamTest implements ITest {

    @Override
    public void test() {
        System.out.println("+++++++++++++++++++Java 8 Stream+++++++++++++++++");
        Random random = new Random();
        random.ints(1, 10).limit(6).forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        String list = Arrays.toString(squaresList.toArray());
        System.out.println(list);
    }
}
