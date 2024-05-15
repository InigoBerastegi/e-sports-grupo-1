package Controlador.ControladorBD;

import Modelo.Usuario;
import Vista.VentanaInicioSesion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ControladorTablaUsuario {
    private Connection con;
    private VentanaInicioSesion vsesion;
    public ControladorTablaUsuario(Connection con) {
        this.con = con;
    }


    public Usuario buscarUsuario(String nombre  ) throws Exception {
        Usuario user =null;

        String plantilla = "SELECT nombre, contrasena, tipo FROM usuario WHERE lower(nombre)=?";

        PreparedStatement buscarUsuario  = con.prepareStatement(plantilla);
        buscarUsuario.setString(1, nombre);
        ResultSet rs = buscarUsuario.executeQuery();

        if (rs.next()) {
            user.setNombre(rs.getString("nombre"));
            user.setContrasena(rs.getString("contrasena"));
            user.setTipo(rs.getString("tipo"));
            System.out.println(user.getNombre());
        }

        buscarUsuario.close();

        return user;
    }


}
