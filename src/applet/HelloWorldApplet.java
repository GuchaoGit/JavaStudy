package applet;

import java.applet.Applet;
import java.awt.*;


/**
 * @Author guc
 * @Date 2019/11/22 9:14
 * @Description Applet程序
 */
public class HelloWorldApplet extends Applet {
    @Override
    public void paint(Graphics g) {
        g.drawString("Hello World", 25, 50);
    }
}
