import javax.swing.*;
import java.applet.Applet;
import java.awt.*;

public class CalculadoraApplet extends JApplet {
    private InterfazCalculadora ventanaCalculadora = new InterfazCalculadora();

    public void init(){
        this.setLayout(new BorderLayout());
        add(ventanaCalculadora, BorderLayout.CENTER);

    }
}
