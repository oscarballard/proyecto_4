/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author OSCAR
 */
import conn.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class login {

    private static login instancia;
    private String user;
    private String pass;

    private login() {

        this.user = "";
        this.pass = "";
    }

    public static login getInstancia() {

        if (instancia == null) {

            instancia = new login();
        }
        return instancia;
    }

    public void lg() throws SQLException {
        System.out.println(this.user);
        System.out.println(this.pass);
        String usuario = null;
        String contra = null;

        IConn conn = conn_fabric.get_conn("mysql");

        ResultSet rs = null;
        String query = "";
        try {

            query = "SELECT UserName,Password FROM usuarios where (UserName = '" + this.user + "') and (Password = '" + this.pass + "')";
            rs = conn.query(query);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        while (rs.next()) {

            usuario = rs.getString("UserName");
            contra = rs.getString("Password");
        }

        if (usuario.toString().trim().equals(this.user.toString().trim()) && contra.toString().trim().equals(this.pass.toString().trim())) {
            
            inicio inicio = new inicio();
            inicio.setVisible(true);
            lg lg = new lg();
            lg.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Favor revisar el usuario y contraseña");
        }

    }

    //setter
    public void set_lg(String user, String pass) {

        this.user = user;
        this.pass = pass;
    }

}
