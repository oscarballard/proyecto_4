/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import conn.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OSCAR
 */
public class crud {
    
    private String tbl;
    private String[] campos;    
    private IConn dbcon;
    private String query;

    
    crud (IConn dbcon, String tbl){
        
        this.dbcon = dbcon;
        this.tbl = tbl;        
        this.query = "";

    }
    
    public void insert(String []params,String []values){
        
        this.query = "INSERT INTO "+this.tbl+" ("; 
        if(params != null && values != null && params.length == values.length){
            for(String x: params){
                this.query += x+",";
            }
            this.query = this.query.substring(0,this.query.length() - 1);
            this.query += ") values (";
            for(String x: values){
                this.query += "'"+x+"',";
            }
            this.query = this.query.substring(0,this.query.length() - 1);
            this.query += ");";
        }

            PreparedStatement ps = null;
            ps = this.dbcon.preparedStatement(this.query);
    }



}
