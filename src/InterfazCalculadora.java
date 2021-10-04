import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazCalculadora extends JPanel{

    private JPanel panelBotones;
    private Controlador controlador;
    private JLabel pantalla;

    public InterfazCalculadora() {
        controlador = new Controlador();
        panelBotones = new JPanel(new GridLayout(4,4));
        pantalla = new JLabel("0", JLabel.RIGHT);

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
        this.add(pantalla, BorderLayout.NORTH);





    }

    private void addBoton(String mensaje) {
        JButton boton = new JButton(mensaje);
        panelBotones.add(boton);
        boton.addActionListener(controlador);
    }

    class Controlador implements ActionListener {

        private int estado;
        private String operador;
        static final int ESTADO_INICIAL = 0;
        static final int LEYENDO_OPERANDO_1 = 1;
        static final int LEYENDO_OPERANDO_2 = 2;
        static final int OPERADOR_LEIDO = 3;
        private String operando1;
        private String operando2;

        public Controlador() {
            this.estado = ESTADO_INICIAL;
            this.operador = "";
            this.operando1 = null;
            this.operando2 = null;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton) e.getSource();
            pantalla.setText(boton.getText());
        }
    }

}
