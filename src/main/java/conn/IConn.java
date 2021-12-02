/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conn;

import javax.sql.DataSource;

/**
 *
 * @author OSCAR
 */
public interface IConn {
    
    DataSource get_conn();
    void close();    
    void get_data_source();
}


