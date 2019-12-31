/**
 * @Author guc
 * @Date 2019/12/31 15:47
 * @Description 异常
 */
public class Human {
    public static void main(String[] args)
            throws Exception {
        try {
            try {
                throw new Sneeze();
            } catch (Annoyance a) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        } catch (Sneeze s) {
            System.out.println("Caught Sneeze");
            return;
        } finally {
            System.out.println("Hello World!");
        }
    }

}

class Annoyance extends Exception {
}

class Sneeze extends Annoyance {
}