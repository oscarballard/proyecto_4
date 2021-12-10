/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conn;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author OSCAR
 */
public interface IConn {
    
    void connect();
    void disconnect();
    ResultSet preparedStatement();
    ResultSet query();
    int updateQuery();
    public String getHostname();
    public void setHostname(String hostname);
    public String getPort();
    public void setPort(String port);
    public String getUsername();
    public void setUsername(String username);
    public String getPassword();
    public void setPassword(String password);
    public String getDatabase();
    public void setDatabase(String database);
    public java.sql.Connection getConnection();
    public boolean isConnected();

    public PreparedStatement preparedStatement(String query);

    public ResultSet query(String query);


}


