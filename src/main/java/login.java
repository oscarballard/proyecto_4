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

public class login {
    
    private static login instancia;    
    private  String user;
    private  String pass;


    private  login(){
        
        this.user = "";
        this.pass = "";
    }
    
    
    public static login getInstancia(){
    
        if(instancia == null){
        
            instancia = new login();
        }
        return instancia;
    }
    
    
    public void lg(){
        System.out.println(this.user);        
        System.out.println(this.pass);

        conn_fabric conn = new conn_fabric("mysql");
        
       
        
        
    }
    
    //setter
    
    public void set_lg(String user,String pass){
        
        this.user = user;
        this.pass = pass;
    }
            
}
