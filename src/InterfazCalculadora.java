import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazCalculadora extends JPanel{

    private JPanel panelBotones;
    private Controlador controlador;

    public InterfazCalculadora() {
        controlador = new Controlador();
        panelBotones = new JPanel(new GridLayout(4,4));
        addBoton("7");
        addBoton("8");
        addBoton("9");
        addBoton("+");
        addBoton("4");
        addBoton("5");
        addBoton("6");
        addBoton("-");
        addBoton("1");
        addBoton("2");
        addBoton("3");
        addBoton("*");
        addBoton("0");
        addBoton(".");
        addBoton("/");
        addBoton("=");
        this.setLayout(new BorderLayout());
        this.add(panelBotones,BorderLayout.CENTER);



    }

    private void addBoton(String mensaje) {
        JButton boton = new JButton(mensaje);
        panelBotones.add(boton);
        boton.addActionListener(controlador);
    }

    class Controlador implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            System.out.println("Boton pulsado: " + boton.getText());
        }
    }


}
