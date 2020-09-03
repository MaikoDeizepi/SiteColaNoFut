/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ColaNoFut.DAO;

import br.com.ColaNoFut.BD.ConexaoBD;
import br.com.ColaNoFut.Bean.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MAIKOVITORDEIZEPISIL
 */
public class UsuarioDAO {
    
    private final Connection c;
    public UsuarioDAO ()throws SQLException, ClassNotFoundException{
        this.c = ConexaoBD.getConexao();
        
    }
      
    public Usuario busca(Usuario usu) throws SQLException{
        String sql = "select * from usuarios WHERE id = ?";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,usu.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                // criando o objeto Usuario
                usu.setId(rs.getInt(1));
                usu.setNome(rs.getString(2));
                usu.setLogin(rs.getString(3));
                usu.setSenha(rs.getString(4));
                usu.setStatus(rs.getString(5));
                usu.setTipo(rs.getString(6));
                // adiciona o usu à lista de usus
            }
        return usu;
    }
    
    public Usuario altera(Usuario usu) throws SQLException{
        String sql = "UPDATE usuarios SET nome = ?, login = ?, senha = ?, status = ?, tipo = ? WHERE id = ?";
        // seta os valores
        try ( // prepared statement para inserção
                PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,usu.getNome());
            stmt.setString(2,usu.getLogin());
            stmt.setString(3,usu.getSenha());
            stmt.setString(4,usu.getStatus());
            stmt.setString(5,usu.getTipo());
            stmt.setInt(6,usu.getId());
            
            // executa
            stmt.execute();
        }
        return usu;
    }

    public Usuario exclui(Usuario usu) throws SQLException{
        String sql = "delete from usuarios WHERE id = ?";
        // seta os valores
        try ( // prepared statement para inserção
                PreparedStatement stmt = c.prepareStatement(sql)) {
            // seta os valores
            stmt.setInt(1,usu.getId());
            // executa
            stmt.execute();
        }
        c.close();
        return usu;
    }
    
    public Usuario validaLogin(Usuario usu) throws SQLException{
        // cria o select para ser executado no banco de dados 
        String sql = "select * from usuarios WHERE login = ? AND senha = ?";
        // seta os valores
        try ( // prepared statement para seleção
                PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,usu.getLogin());
            stmt.setString(2,usu.getSenha());
            // executa
            ResultSet rs = stmt.executeQuery();
            // percorrendo o rs
            while (rs.next()) {
                // criando o objeto Usuario
                usu.setId(rs.getInt(1));
                usu.setNome(rs.getString(2));
                usu.setLogin(rs.getString(3));
                usu.setSenha(rs.getString(4));
                usu.setStatus(rs.getString(5));
                usu.setTipo(rs.getString(6));
                // adiciona o usu à lista de usus
            }
        }
        return usu;
    }
    
    public List<Usuario> lista(Usuario usuEnt) throws SQLException{
         // usus: array armazena a lista de registros

        List<Usuario> usus = new ArrayList<>();
        
        String sql = "select * from usuarios where nome like ?";
        // seta os valores
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            // seta os valores
            stmt.setString(1,"%" + usuEnt.getNome() + "%");
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    // criando o objeto Usuario
                    Usuario usu = new Usuario(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6)
                    );
                    // adiciona o usu à lista de usus
                    usus.add(usu);
                }
            }
        }
        return usus;
        
    }
    
    public List<Usuario> listaTodos() throws SQLException{
         // usus: array armazena a lista de registros

        List<Usuario> usus = new ArrayList<>();
        
        String sql = "select * from usuarios";
        try (PreparedStatement stmt = this.c.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                // criando o objeto Usuario
                Usuario usu = new Usuario(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)
                );
                // adiciona o usu à lista de usus
                usus.add(usu);
            }
            
            rs.close();
        }
        return usus;
        
    }
    
    public Usuario inseri(Usuario usu) throws SQLException{
        String sql = "insert into usuarios" + " (nome, login, senha, status, tipo)" + " values (?,?,?,?,?)";
    
        // seta os valores
        try ( // prepared statement para inserção
                PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
            // seta os valores
            stmt.setString(1,usu.getNome());
            stmt.setString(2,usu.getLogin());
            stmt.setString(3,usu.getSenha());
            stmt.setString(4,usu.getStatus());
            stmt.setString(5,usu.getTipo());
            
            // executa
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                usu.setId(id);
            }
        }
        return usu;
    }
    
}
