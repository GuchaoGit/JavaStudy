package bean;

/**
 * @Author guc
 * @Date 2019/11/25 14:44
 * @Description 绘制图形
 */
public class DrawGraph implements ITest {

    @Override
    public void test() {
        draw99();
    }

    private void draw99() {
        System.out.println("+++++++++++++++++++99乘法表+++++++++++++++++");
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "×" + i + "=" + i * j + "\t");// \t 跳到下一个TAB位置
            }
            System.out.println();
        }

        for (int i = 9; i > 0; i--) {
            for (int j = 1, k = 10 - i; j <= i; j++, k++) {
                System.out.print(j + "×" + k + "=" + k * j + "\t");// \t 跳到下一个TAB位置
            }
            System.out.println();
        }
    }

}
