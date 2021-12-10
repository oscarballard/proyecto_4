/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conn;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author OSCAR
 */
public  class mysql_connect implements IConn{
	// Proporties
	private String hostname;
	private String port;
	private String username;
	private String password;
	private String database;
	
	private java.sql.Connection connection;
	
	// Constructors
	public mysql_connect()
	{
		this.hostname = "localhost";
		this.port = "3306";
		this.username = "";
		this.password = "";
	}
	
	public mysql_connect(String username, String password, String database)
	{
		this.hostname = "localhost";
		this.port = "3306";
		this.username = username;
		this.password = password;
		this.database = database;
	}
	
	public mysql_connect(String hostname, String username, String password, String database)
	{
		this.hostname = hostname;
		this.port = "3306";
		this.username = username;
		this.password = password;
		this.database = database;
	}
	
	public mysql_connect(String hostname, String port, String username, String password, String database)
	{
		this.hostname = hostname;
		this.port = port;
		this.username = username;
		this.password = password;
		this.database = database;
	}
	
	// Functions
        @Override
	public void connect()
	{
		String url = "jdbc:mysql://"+this.hostname+":"+this.port+"/"+this.database;
                System.out.println(url);                
                System.out.println(this.hostname);
                System.out.println(this.port);
                System.out.println(this.database);
                System.out.println(this.password);



		try 
		{
			this.connection = DriverManager.getConnection(url, this.username, this.password);
                        System.out.println("conexion establecida");
		} catch(SQLException ex)
		{
			this.connection = null;
                        System.out.println(ex);                        
                        System.out.println("Error en la conexion");

		}
	}
	
        @Override
	public void disconnect()
	{
		try {
			this.connection.close();
		} catch (SQLException e) {
			this.connection = null;
		}
		this.connection = null;
	}
	

	

	
	public int updateQuery(String query) throws SQLException
	{
		if(this.isConnected())
			this.connect();
		
		Statement sm = this.connection.createStatement();
		
		return sm.executeUpdate(query);
	}
	
	// Getters and setters
        @Override
	public String getHostname()
	{
		return this.hostname;
	}
	
        @Override
	public void setHostname(String hostname)
	{
		this.hostname = hostname;
	}
	
        @Override
	public String getPort()
	{
		return this.port;
	}
	
        @Override
	public void setPort(String port)
	{
		this.port = port;
	}
	@Override

	public String getUsername()
	{
		return this.username;
	}
	
        @Override
	public void setUsername(String username)
	{
		this.username = username;
	}
	
        @Override
	public String getPassword()
	{
		return this.password;
	}
	
        @Override
	public void setPassword(String password)
	{
		this.password = password;
	}
	
        @Override
	public String getDatabase()
	{
		return this.database;
	}
	
        @Override
	public void setDatabase(String database)
	{
		this.database = database;
	}
	
        @Override
	public java.sql.Connection getConnection()
	{
		return this.connection;
	}
	
        @Override
	public boolean isConnected()
	{
		try {
			return this.connection != null && !this.connection.isClosed();
		} catch (SQLException e) {
			return false;
		}
	}

    @Override
    public ResultSet preparedStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet query() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int updateQuery() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PreparedStatement preparedStatement(String query) {
        if(!this.isConnected()){
            this.connect();
        }
        PreparedStatement ps = null;
            try {
                ps = this.connection.prepareStatement(query);
                ps.execute();

            } catch (SQLException ex) {
                System.out.println(ex);
            }
	return null;
    }

    @Override
    public ResultSet query(String query) 
    {
	if(!this.isConnected())
            this.connect();
		
        Statement sm = null;
            try {
                sm = this.connection.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(mysql_connect.class.getName()).log(Level.SEVERE, null, ex);
            }
		
            try {
                return sm.executeQuery(query);
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            return null;
    }

}
