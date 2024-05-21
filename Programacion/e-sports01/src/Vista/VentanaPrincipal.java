package Vista;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class VentanaPrincipal extends JFrame{
    private JPanel panel1;
    private JButton bClasificacion;
    private JButton bUltJornada;
    private JButton bCerrar;
    private JButton bEditar;
    private JButton bCerrarSesion;
    private JButton bCerrarInsc;
    private JButton bSalir;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JPanel p4;

    private JButton bConsulta;
    private JButton bPerfil;
    private JPanel panel2;
    private JLabel jlTipo;
    private JPanel pInsertResultados;
    private JPanel pVerResultados;
    private JPanel pVerClasificacion;
    private JButton bInsertResultados;
    private JButton bVerResultados;
    private JTextField tfRelleno;


    private JButton btPerfil;


    public VentanaPrincipal() {
        setContentPane(panel1);
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        redondearPanel(panel2, 30);
    }
    /*
    public void initComponets()
    {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        // Panel 1: 15% alto, 10% ancho

        p1.setBackground(Color.RED);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.weightx = 0.1;
        gbc.weighty = 0.15;
        panel1.add(p1, gbc);

        // Panel 2: 15% alto, 90% ancho

        p2.setBackground(Color.GREEN);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 0.9;
        gbc.weighty = 0.15;
        panel1.add(p2, gbc);

        // Panel 3: 85% alto, 10% ancho

        p3.setBackground(Color.BLUE);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 2;
        gbc.weightx = 0.1;
        gbc.weighty = 0.85;
        panel1.add(p3, gbc);

        // Panel 4: 15% alto, 90% ancho

        p4.setBackground(Color.YELLOW);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 0.9;
        gbc.weighty = 0.15;
        panel1.add(p4, gbc);

    }
     */

    // Método para establecer las esquinas redondeadas de un JButton
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
            g2d.draw(new RoundRectangle2D.Double(x+29, y, 761, height - 1, radius, radius));
            g2d.dispose();
        }
    }

    public JPanel getpInsertResultados() {
        return pInsertResultados;
    }

    public void setpInsertResultados(JPanel pInsertResultados) {
        this.pInsertResultados = pInsertResultados;
    }

    public JPanel getpVerResultados() {
        return pVerResultados;
    }

    public void setpVerResultados(JPanel pVerResultados) {
        this.pVerResultados = pVerResultados;
    }

    public JPanel getpVerClasificacion() {
        return pVerClasificacion;
    }

    public void setpVerClasificacion(JPanel pVerClasificacion) {
        this.pVerClasificacion = pVerClasificacion;
    }

    public JButton getbInsertResultados() {
        return bInsertResultados;
    }

    public void setbInsertResultados(JButton bInsertResultados) {
        this.bInsertResultados = bInsertResultados;
    }

    public JButton getbVerResultados() {
        return bVerResultados;
    }

    public void setbVerResultados(JButton bVerResultados) {
        this.bVerResultados = bVerResultados;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JButton getbClasificacion() {
        return bClasificacion;
    }

    public void setbClasificacion(JButton bClasificacion) {
        this.bClasificacion = bClasificacion;
    }

    public JButton getbUltJornada() {
        return bUltJornada;
    }

    public void setbUltJornada(JButton bUltJornada) {
        this.bUltJornada = bUltJornada;
    }

    public JButton getbCerrar() {
        return bCerrar;
    }

    public void setbCerrar(JButton bCerrar) {
        this.bCerrar = bCerrar;
    }

    public JButton getbEditar() {
        return bEditar;
    }

    public void setbEditar(JButton bEditar) {
        this.bEditar = bEditar;
    }

    public JButton getCERRARSESIONButton() {
        return bCerrarSesion;
    }

    public void setCERRARSESIONButton(JButton CERRARSESIONButton) {
        this.bCerrarSesion = CERRARSESIONButton;
    }

    public JButton getSALIRButton() {
        return bSalir;
    }

    public void setSALIRButton(JButton SALIRButton) {
        this.bSalir = SALIRButton;
    }

    public JPanel getP1() {
        return p1;
    }

    public void setP1(JPanel p1) {
        this.p1 = p1;
    }

    public JPanel getP2() {
        return p2;
    }

    public void setP2(JPanel p2) {
        this.p2 = p2;
    }

    public JPanel getP3() {
        return p3;
    }

    public void setP3(JPanel p3) {
        this.p3 = p3;
    }

    public JPanel getP4() {
        return p4;
    }

    public void setP4(JPanel p4) {
        this.p4 = p4;
    }

    public JButton getbConsulta() {
        return bConsulta;
    }

    public void setbConsulta(JButton bConsulta) {
        this.bConsulta = bConsulta;
    }

    public JButton getbPerfil() {
        return bPerfil;
    }

    public void setbPerfil(JButton bPerfil) {
        this.bPerfil = bPerfil;
    }

    public JButton getbCerrarSesion() {
        return bCerrarSesion;
    }

    public void setbCerrarSesion(JButton bCerrarSesion) {
        this.bCerrarSesion = bCerrarSesion;
    }

    public JButton getbCerrarInsc() {
        return bCerrarInsc;
    }

    public void setbCerrarInsc(JButton bCerrarInsc) {
        this.bCerrarInsc = bCerrarInsc;
    }

    public JButton getbSalir() {
        return bSalir;
    }

    public void setbSalir(JButton bSalir) {
        this.bSalir = bSalir;
    }

    public JTextField getTfRelleno() {
        return tfRelleno;
    }

    public void setTfRelleno(JTextField tfRelleno) {
        this.tfRelleno = tfRelleno;
    }

    public JButton getBtPerfil() {
        return btPerfil;
    }

    public void setBtPerfil(JButton btPerfil) {
        this.btPerfil = btPerfil;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JLabel getJlTipo() {
        return jlTipo;
    }

    public void setJlTipo(JLabel jlTipo) {
        this.jlTipo = jlTipo;
    }

    public void addeditar(ActionListener al) {
        bEditar.addActionListener(al);
    }
    public void addcerrarInsc(ActionListener al) {
        bCerrarInsc.addActionListener(al);
    }

    public void addClasificacion(ActionListener al) {
        bClasificacion.addActionListener(al);
    }
    public void addInsertResultados(ActionListener al) {
        bInsertResultados.addActionListener(al);
    }
    public void addVerResultados(ActionListener al) {
        bVerResultados.addActionListener(al);
    }
    public void addPerfil(ActionListener al) {
    }
    public void botonPerfil(ActionListener al){
        btPerfil.addActionListener(al);
    }
    public void mostrarMensaje(String m){
        JOptionPane.showMessageDialog(null, m);
    }


}
