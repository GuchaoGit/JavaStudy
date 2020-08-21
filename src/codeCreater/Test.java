package codeCreater;

/**
 * @Author: guc
 * @Description: 测试生成工具
 * @Date: 2020/8/14 15:24
 * @Version: 1.0
 */
public class Test {

    public static void main(String[] args) {
        try {
            ACodeCreator.init("G:\\YFWork\\YFCode\\");
            ACodeCreator.createCode("FE8E729202764877BF59AF0715D196B4", 280);
        } catch (AccessTokenException e) {
            e.printStackTrace();
        } catch (ACodeCreateException e) {
            e.printStackTrace();
        }
    }
}
