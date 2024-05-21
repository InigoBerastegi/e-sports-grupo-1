package Vista;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class VentanaClasificacion extends JFrame{
    private JComboBox cbbClasificacion;
    private JTextArea txaClasificacion;
    private JPanel pPrincipal;
    private JPanel panel2;
    private JLabel equipo1;
    private JLabel equipo2;
    private JLabel equipo3;
    private JLabel equipo4;
    private JLabel equipo5;
    private JLabel equipo6;
    private JLabel equipo7;
    private JLabel equipo8;
    private JLabel equipo9;
    private JLabel equipo10;
    private JLabel jornada1;
    private JLabel jornada2;
    private JLabel jornada3;
    private JLabel jornada4;
    private JLabel jornada5;
    private JLabel jornada6;
    private JLabel jornada7;
    private JLabel jornada8;
    private JLabel jornada9;
    private JLabel jornada10;
    private JLabel puntos1;
    private JLabel puntos2;
    private JLabel puntos3;
    private JLabel puntos4;
    private JLabel puntos5;
    private JLabel puntos6;
    private JLabel puntos7;
    private JLabel puntos8;
    private JLabel puntos9;
    private JLabel puntos10;
    private JButton bVolver;
    private JButton bInicio;

    public VentanaClasificacion() {
        setContentPane(pPrincipal);
        setLocationRelativeTo(null);
        setSize(1920, 1080);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        redondearPanel(panel2, 30);
    }

    private void redondearPanel(JPanel panel, int cornerRadius) {
        panel.setOpaque(false);
        panel.setBorder(new redondear(cornerRadius));
    }

    // Clase para crear un borde redondeado
    class redondear implements Border {
        private int radius;

        public redondear(int radius) {
            this.radius = radius;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(radius, radius, radius, radius);
        }

        @Override
        public boolean isBorderOpaque() {
            return true;
        }

        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.black);
            g2d.draw(new RoundRectangle2D.Double(x, y, width -1, height -1, radius, radius));
            g2d.dispose();
        }
    }

    public JComboBox getCbbClasificacion() {
        return cbbClasificacion;
    }

    public void setCbbClasificacion(JComboBox cbbClasificacion) {
        this.cbbClasificacion = cbbClasificacion;
    }

    public JTextArea getTxaClasificacion() {
        return txaClasificacion;
    }

    public void setTxaClasificacion(JTextArea txaClasificacion) {
        this.txaClasificacion = txaClasificacion;
    }

    public JPanel getpPrincipal() {
        return pPrincipal;
    }

    public void setpPrincipal(JPanel pPrincipal) {
        this.pPrincipal = pPrincipal;
    }


}
