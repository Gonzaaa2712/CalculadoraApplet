import javax.swing.*;
import java.awt.*;

public class InterfazCalculadora extends JPanel{

    private JPanel panelBotones;

    public InterfazCalculadora() {
        panelBotones = new JPanel(new GridLayout(4,4));
        addBoton("7");
        addBoton("8");
        addBoton("9");
        addBoton("+");

        this.setLayout(new BorderLayout());
        this.add(panelBotones,BorderLayout.CENTER);



    }

    private void addBoton(String mensaje) {
        JButton boton = new JButton(mensaje);
        panelBotones.add(boton);
    }
}
