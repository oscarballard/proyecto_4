/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author OSCAR
 */
import conn.IConn;
import conn.mysql_connect;
public class conn_fabric {
    
    public static IConn get_conn(String motor){
        
        if(motor == null){
            return new Conn_vacia();
        }else if(motor.equalsIgnoreCase("mysql")){
            return new mysql_connect("db4free.net","estuditlafinal","itla123.","almacenitlafinal") {};
        }
        return new Conn_vacia();
    }
}
