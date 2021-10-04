import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazCalculadora extends JPanel {

    private JPanel panelBotones;
    private Controlador controlador;
    private JLabel pantalla;

    public InterfazCalculadora() {
        controlador = new Controlador();
        panelBotones = new JPanel(new GridLayout(4, 4));
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
        this.add(panelBotones, BorderLayout.CENTER);
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

        private String calcularResultado(String op1, String op2, String operando){

            int resultado = 0;

            if(operando.equalsIgnoreCase("+")){
                resultado = Integer.parseInt(op1) + Integer.parseInt(op2);
            } else if(operando.equalsIgnoreCase("-")){
                resultado = Integer.parseInt(op1) - Integer.parseInt(op2);
            } else if(operando.equalsIgnoreCase("*")){
                resultado = Integer.parseInt(op1) * Integer.parseInt(op2);
            } else if(operando.equalsIgnoreCase("/")){
                resultado = Integer.parseInt(op1) / Integer.parseInt(op2);
            }

            return Integer.toString(resultado);
        }




    @Override
    public void actionPerformed(ActionEvent e) {
        JButton boton = (JButton) e.getSource();

        switch (this.estado) {

            case ESTADO_INICIAL:
                if ("123456789".contains(boton.getText())) {
                    this.operando1 = boton.getText();
                    this.estado = LEYENDO_OPERANDO_1;
                    pantalla.setText(this.operando1);
                }
                break;
            case LEYENDO_OPERANDO_1:
                if ("0123456789".contains(boton.getText())) {
                    this.operando1 += boton.getText();
                    pantalla.setText(this.operando1);
                    this.estado = LEYENDO_OPERANDO_1;
                } else if ("+-*/".contains(boton.getText())) {
                    this.estado = OPERADOR_LEIDO;
                    this.operador = boton.getText();
                    pantalla.setText("0");
                }
                break;
            case OPERADOR_LEIDO:
                if ("+-*/".contains(boton.getText())) {
                    this.operador = boton.getText();
                    pantalla.setText("0");
                } else if ("123456789".contains(boton.getText())) {
                    this.estado = LEYENDO_OPERANDO_2;
                    this.operando2 = boton.getText();
                    pantalla.setText(operando2);
                }
                break;
            case LEYENDO_OPERANDO_2:
                if ("0123456789".contains(boton.getText())) {
                    this.operando2 += boton.getText();
                    pantalla.setText(this.operando2);
                    this.estado = LEYENDO_OPERANDO_1;
                } else if ("=".contains(boton.getText())) {
                    String resultado = calcularResultado(operando1, operando2, operador);
                    pantalla.setText(resultado);
                    this.estado = ESTADO_INICIAL;
                }
                break;

        }
    }
}

}
