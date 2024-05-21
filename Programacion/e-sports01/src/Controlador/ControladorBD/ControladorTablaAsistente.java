package Controlador.ControladorBD;

import java.sql.Connection;

public class ControladorTablaAsistente {
    private Connection con;
    public ControladorTablaAsistente(Connection con) {
        this.con = con;
    }
}
