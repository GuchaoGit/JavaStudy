package annotation;

/**
 * @Author guc
 * @Date 2020/4/9 14:30
 * @Description 使用注解
 */
public class PasswordUtils {

    @UseCase.UseCases(id = "47", description = "验证密码是否有效", names = {"name1", "name2"})
    public boolean validatePassword(String password) {
        System.out.println("待验证密码：" + password);
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCase.UseCases(id = "48", names = {"name3", "name4"})
    public String encryptPassword(String password) {
        System.out.println("待加密密码：" + password);
        return new StringBuilder(password).reverse().toString();
    }
}

