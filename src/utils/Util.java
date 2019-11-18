package utils;

/**
 * @Author guc
 * @Date 2019/11/18 16:12
 * @Description TODO
 */
public class Util {
    /**
     * typeName... parameterName 可变参数
     *
     * @param numbers 参数
     * @return 最大值
     */
    public static double getMax(double... numbers) {
        if (numbers.length == 0) {
            return 0;
        }
        double max = numbers[0];
        for (double num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
