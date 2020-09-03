/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ColaNoFut.DAO;

import br.com.ColaNoFut.BD.ConexaoBD;
import br.com.ColaNoFut.Bean.Locador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MAIKOVITORDEIZEPISIL
 */
public class LocadorDAO {
     private final Connection c;
    public LocadorDAO ()throws SQLException, ClassNotFoundException{
        this.c = ConexaoBD.getConexao();
        
    }
    
    public static Locador salvar(Locador locador) {
        String sql = "INSERT INTO `colanofut`.`locador` (`cnpj`, `nome_proprietario`, `nome_espaco`, `telefone`) VALUES ( ?, ?, ?, ?);";
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, locador.getCnpj());
            ps.setString(2, locador.getNome_proprietario());
            ps.setString(3, locador.getNome_espaco());
            ps.setString(4, locador.getTelefone());
            ps.executeUpdate();
            System.out.println("Registro Inserido com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locador;
    }

    public static Locador deletar(Locador locador) {
        String sql = "DELETE FROM `colanofut`.`locador` WHERE (`id_locador` = ?);";
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, locador.getId_locador());
            ps.executeUpdate();
            System.out.println("Registro Excluido com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locador;
    }
    

    public static Locador atualizar(Locador locador) {
        String sql = "UPDATE `colanofut`.`locador` SET  `cnpj` = ?, `nome_proprietario` = ?, `nome_espaco` = ?, `telefone` = ? WHERE (`id_locador` = ?);";
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, locador.getCnpj());
            ps.setString(2, locador.getNome_proprietario());
            ps.setString(3, locador.getNome_espaco());
            ps.setString(4, locador.getTelefone());
            ps.setInt(5, locador.getId_locador());
            ps.executeUpdate();
            System.out.println("Registro Atualizado com sucesso");

        } catch (SQLException e) {
        }
        return locador;
    }
    
     public Locador busca(Locador locador) throws SQLException{
        String sql = "select * from locador WHERE id_locador = ?";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,locador.getId_locador());
            // executa
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                // criando o objeto Usuario
                locador.setId_locador(rs.getInt(1));
                locador.setCnpj(rs.getString(2));
                locador.setNome_proprietario(rs.getString(3));
                locador.setNome_espaco(rs.getString(4));
                locador.setTelefone(rs.getString(5));
                // adiciona o usu à lista de usus
            }
            stmt.close();
            c.close();
        return locador;
    }
    public static Locador buscarporNome(Locador locador) throws SQLException{
        String sql = "SELECT * FROM colanofut.locador where nome_proprietario like ?;";
        Connection conn = ConexaoBD.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql); 
        ps.setString(1, locador.getNome_proprietario());
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Locador loc = new Locador();
            locador.setId_locador(rs.getInt(1));
            locador.setCnpj(rs.getString(2));
            locador.setNome_espaco(rs.getString(3));
            locador.setNome_proprietario(rs.getString(4));
            locador.setTelefone(rs.getString(5));
        }

        return locador;
    }
    public static List<Locador> lista(Locador locador) throws SQLException{
        List<Locador>locadors = new ArrayList<>();
        String sql = "SELECT * FROM colanofut.locador where nome_proprietario like ?;";
        Connection conn = ConexaoBD.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql); 
        ps.setString(1, "%"+locador.getNome_proprietario()+"%");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Locador loc = new Locador(
            rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
            locadors.add(loc);
        }

        return locadors;
    }
    
    public static List<Locador> listas() throws SQLException{
        List<Locador>locadors = new ArrayList<>();
        String sql = "SELECT * FROM colanofut.locador;";
        Connection conn = ConexaoBD.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql); 
    
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Locador loc = new Locador(
            rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
            locadors.add(loc);
        }
        rs.close();
        ps.close();
        return locadors;
    }
    public static List<Locador> procuraPorNome(Locador locador) {
        String sql = "SELECT * FROM colanofut.locador where nome_proprietario like ?;";
        List<Locador> locadorList = new ArrayList<>();
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql))
              {
                  ps.setString(1,"%"+locador.getNome_proprietario()+"%");
                  ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                locadorList.add(new Locador(rs.getInt("id_locador"), rs.getString("cnpj"), rs.getString("nome_proprietario"), rs.getString("nome_espaco"), rs.getString("telefone")));

            }
            return locadorList;
        } catch (SQLException e) {
        }
        return null;
    }


    /*###############################################################################################################################*/

    public static Locador procuraPorId(Locador locador) {
        String sql = "SELECT * FROM colanofut.locador where id_locador =?";
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setInt(1,locador.getId_locador());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                new Locador(rs.getInt("id_locador"), rs.getString("cnpj"), rs.getString("nome_proprietario"), rs.getString("nome_espaco"), rs.getString("telefone"));
            }
            ConexaoBD.getConexao().close();
            return locador;
        } catch (SQLException e) {
        }
        return locador;
    }

    public static List<Locador> procuraPorCNPJ(String cnpj) {
        String sql = "SELECT id_locador,cnpj,nome_proprietario,nome_espaco,telefone FROM colanofut.locador where cnpj like ?";
        List<Locador> locadorList = new ArrayList<>();
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, "%" + cnpj + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                locadorList.add(new Locador(rs.getInt("id_locador"), rs.getString("cnpj"), rs.getString("nome_proprietario"), rs.getString("nome_espaco"), rs.getString("telefone")));

            }
            ConexaoBD.getConexao().close();
            return locadorList;

        } catch (SQLException e) {
        }
        return null;
    }

    public static List<Locador> procuraPorNomeProp(String nome_proprietario) {
        String sql = "SELECT id_locador,cnpj,nome_proprietario,nome_espaco,telefone FROM colanofut.locador where nome_proprietario like ?";
        List<Locador> locadorList = new ArrayList<>();
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, "%" + nome_proprietario + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                locadorList.add(new Locador(rs.getInt("id_locador"), rs.getString("cnpj"), rs.getString("nome_proprietario"), rs.getString("nome_espaco"), rs.getString("telefone")));

            }
            ConexaoBD.getConexao().close();
            return locadorList;

        } catch (SQLException e) {
        }
        return null;
    }

    public static List<Locador> procuraPorNomeEspa(String nome_espaco) {
        String sql = "SELECT id_locador,cnpj,nome_proprietario,nome_espaco,telefone FROM colanofut.locador where nome_espaco like ?";
        List<Locador> locadorList = new ArrayList<>();
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, "%" + nome_espaco + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                locadorList.add(new Locador(rs.getInt("id_locador"), rs.getString("cnpj"), rs.getString("nome_proprietario"), rs.getString("nome_espaco"), rs.getString("telefone")));

            }
            ConexaoBD.getConexao().close();
            return locadorList;

        } catch (SQLException e) {
        }
        return null;
    }

    public static List<Locador> procuraPorTel(String telefone) {
        String sql = "SELECT id_locador,cnpj,nome_proprietario,nome_espaco,telefone FROM colanofut.locador where telefone like ?";
        List<Locador> locadorList = new ArrayList<>();
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, "%" + telefone + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                locadorList.add(new Locador(rs.getInt("id_locador"), rs.getString("cnpj"), rs.getString("nome_proprietario"), rs.getString("nome_espaco"), rs.getString("telefone")));

            }
            ConexaoBD.getConexao().close();
            return locadorList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
