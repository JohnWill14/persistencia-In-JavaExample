
package br.com.william.jdbc.crud;

import br.com.william.jdbc.connection.ConnectionManager;
import br.com.william.jdbc.model.Contato;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoCrud {
    

    public ContatoCrud() {
        super();
    }   
    
    
    public void salvar(Contato contato){
     Connection connection = ConnectionManager.geraConnection();
     PreparedStatement ps = null;
     String sql = "insert into contato(nome, telefone, email, dt_cad, obs) values(?, ?, ?, ?, ?)";
    
     try{
         ps = connection.prepareStatement(sql);
         
         ps.setString(1, contato.getNome());
         ps.setString(2, contato.getTelefone());
         ps.setString(3, contato.getEmail());
         ps.setDate(4, contato.getDataCadastro());
         ps.setString(5, contato.getObservacao());
         
         ps.execute();
         
     }catch(SQLException e){
         System.out.println("erro ao inserir contato - "+ e.getMessage());
     }finally{
         
         ConnectionManager.fecha(connection, ps);
     }
    }
    
    public void atualizar(Contato contato){
     Connection connection = ConnectionManager.geraConnection();
     PreparedStatement ps = null;
     String sql = "update contato set nome = ?, telefone = ?, email = ?, dt_cad = ?, obs = ? where codigo = ?";
     
     try{
         ps = connection.prepareStatement(sql);
         
         ps.setString(1, contato.getNome());
         ps.setString(2, contato.getTelefone());
         ps.setString(3, contato.getEmail());
         ps.setDate(4, contato.getDataCadastro());
         ps.setString(5, contato.getObservacao());
         ps.setInt(6, contato.getCodigo());
         
         ps.executeUpdate();
         
     }catch(SQLException e){
         System.out.println("erro ao atualizar contato - "+ e.getMessage());
     }finally{
         ConnectionManager.fecha(connection, ps);
     }  
    }
    
    public void excluir(Contato contato){
     Connection connection = ConnectionManager.geraConnection();
     PreparedStatement ps = null;
     String sql = "delete from contato where codigo = ?";
     
     
     try{
         ps = connection.prepareStatement(sql);
         
         ps.setInt(1, contato.getCodigo());
         
         ps.executeUpdate();
         
     }catch(SQLException e){
         System.out.println("erro ao excluir contato - "+ e.getMessage());
     }finally{
         ConnectionManager.fecha(connection, ps);
     }  
    }
    
    public Contato buscaContato(String name){
         List<Contato> contatos =listaTodosOsContato();
         
         return contatos.stream()
                 .filter(c -> c.getNome().equals(name))
                 .findFirst()
                 .orElse(null);
    }
    
    
    public List<Contato> listaTodosOsContato(){
        
     Connection connection = ConnectionManager.geraConnection();     
     String sql = "select * from contato";
     Contato contato;
     PreparedStatement ps = null;
     ResultSet rs = null;
     
     List<Contato> contatos = new ArrayList<>();
     
     try{
        ps = connection.prepareStatement(sql);
        rs = ps.executeQuery();
         while(rs.next()){
             contato = new Contato();
             
             contato.setCodigo(rs.getInt("codigo"));
             contato.setNome(rs.getString("nome"));
             contato.setEmail(rs.getString("email"));
             contato.setTelefone(rs.getString("telefone"));
             contato.setDataCadastro(rs.getDate("dt_cad"));
             contato.setObservacao(rs.getString("obs"));
             
             contatos.add(contato);
         }
         
     }catch(SQLException e){
         System.out.println("erro ao listar contato - "+ e.getMessage());
     }finally{
        ConnectionManager.fecha(connection, ps, rs);
         
        return contatos;
     }
    }
    
    
    
    public static void main(String[] args) {
        ContatoCrud crud = new ContatoCrud();
        
        
        Contato c = crud.buscaContato("yuyu");
        System.out.println(c);
        
    }
    
    
}
