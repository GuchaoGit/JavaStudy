package bean;

/**
 * @Author guc
 * @Date 2019/11/15 10:27
 * @Description 饮料
 */
public class FreshJuice {
    public enum FreshJuiceSize {
        SMALL(300), MEDIUM(400), LARGE(500);
        private int size;

        FreshJuiceSize(int size) {
            this.size = size;
        }

        int getSize() {
            return size;
        }
    }
    public FreshJuiceSize size;
}
