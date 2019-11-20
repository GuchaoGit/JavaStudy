package bean;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * @Author guc
 * @Date 2019/11/20 14:12
 * @Description append拼接时不添加StreamHeader
 * 解决读取时报
 * .StreamCorruptedException: invalid type code: AC
 */
public class MyObjectOutputStream extends ObjectOutputStream {
    public MyObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    protected MyObjectOutputStream() throws IOException, SecurityException {
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        //不写StreamHeader
    }
}
