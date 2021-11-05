
package br.com.william.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectionManager {
    
    private static final String URL = "jdbc:mysql://localhost/agenda";
    private static final String USER = "root";
    private static final String PASS = "asd";
    
    public static Connection geraConnection(){
        Connection connection;
        
        try{
            connection = DriverManager.getConnection(URL, USER, PASS);
        }catch(SQLException e){
            System.out.println("Erro ao criar conexao");
            throw new RuntimeException(e);
        }
        
        return connection;
    }
    
    
    public static void fecha(Connection connection, PreparedStatement pr, ResultSet rs){
        fechaResultSet(rs);
        fecha(connection, pr);
    }
    
    public static void fecha(Connection connection, PreparedStatement pr){
        fechaPreparedStament(pr);
        fechaConnection(connection);
    }
            
    public static void fechaConnection(Connection connection){        
        try{
            if(connection!=null)
                connection.close();
        }catch(SQLException e){
            System.out.println("Erro ao fechar conexao");
            throw new RuntimeException(e);
        }
    }
    
    private static void fechaPreparedStament(PreparedStatement ps){        
        try{
            if(ps!=null)
                ps.close();
        }catch(SQLException e){
            System.out.println("Erro ao fechar conexao");
            throw new RuntimeException(e);
        }
    }
    
    
    private static void fechaResultSet(ResultSet rs){        
        try{
            if(rs!=null)
                rs.close();
        }catch(SQLException e){
            System.out.println("Erro ao fechar conexao");
            throw new RuntimeException(e);
        }
    }    
    
}
