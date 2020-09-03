/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ColaNoFut.DAO;

import br.com.ColaNoFut.BD.ConexaoBD;
import br.com.ColaNoFut.Bean.Locatario;
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
public class LocatarioDAO {
    
     private final Connection c;
    public LocatarioDAO ()throws SQLException, ClassNotFoundException{
        this.c = ConexaoBD.getConexao();
        
    }
    
    public static Locatario salvar(Locatario locatario) {
        String sql = "INSERT INTO `colanofut`.`locatario` (`cpf`, `rg`, `nome`, `telefone`) VALUES ( ?, ?, ?, ?);";
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, locatario.getCpf());
            ps.setString(2, locatario.getRg());
            ps.setString(3, locatario.getNome());
            ps.setString(4, locatario.getTelefone());
            ps.executeUpdate();
            System.out.println("Registro Inserido com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locatario;
    }

    public static Locatario deletar(Locatario locatario) {
        String sql = "DELETE FROM `colanofut`.`locatario` WHERE (`id_locatario` = ?);";
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, locatario.getId_locatario());
            ps.executeUpdate();
            System.out.println("Registro Excluido com sucesso");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locatario;
    }
     public static List<Locatario> lista(Locatario locatario) throws SQLException{
        List<Locatario>locadors = new ArrayList<>();
        String sql = "SELECT * FROM colanofut.locatario where nome like ?;";
        Connection conn = ConexaoBD.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql); 
        ps.setString(1, "%"+locatario.getNome()+"%");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Locatario loc = new Locatario(
            rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
            locadors.add(loc);
        }

        return locadors;
    }
     public static List<Locatario> listas() throws SQLException{
        List<Locatario>locadors = new ArrayList<>();
        String sql = "SELECT * FROM colanofut.locatario;";
        Connection conn = ConexaoBD.getConexao();
        PreparedStatement ps = conn.prepareStatement(sql); 
    
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Locatario loc = new Locatario(
            rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
            locadors.add(loc);
        }
        rs.close();
        ps.close();
        return locadors;
    }
    
     public Locatario busca(Locatario locatario) throws SQLException{
        String sql = "select * from locatario WHERE id_locatario = ?";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,locatario.getId_locatario());
            // executa
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                // criando o objeto Usuario
                locatario.setId_locatario(rs.getInt(1));
                locatario.setCpf(rs.getString(2));
                locatario.setRg(rs.getString(3));
                locatario.setNome(rs.getString(4));
                locatario.setTelefone(rs.getString(5));
                // adiciona o usu à lista de usus
            }
            stmt.close();
            c.close();
        return locatario;
    }

    public static Locatario atualizar(Locatario locatario) {
        String sql = "UPDATE `colanofut`.`locatario` SET  `cpf` = ?, `rg` = ?, `nome` = ?, `telefone` = ? WHERE (`id_locatario` = ?);";
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, locatario.getCpf());
            ps.setString(2, locatario.getRg());
            ps.setString(3, locatario.getNome());
            ps.setString(4, locatario.getTelefone());
            ps.setInt(5, locatario.getId_locatario());
            ps.executeUpdate();
            System.out.println("Registro Atualizado com sucesso");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locatario;
    }

    public static List<Locatario> consultar(Locatario locatario) {
        String sql = "SELECT * FROM colanofut.locatario where nome =?;";
        List<Locatario> locatarioList = new ArrayList<>();
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                locatarioList.add(new Locatario(rs.getInt("id_locatario"), rs.getString("cpf"), rs.getString("rg"), rs.getString("nome"), rs.getString("telefone")));

            }
            return locatarioList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }




    /*###############################################################################################################################*/

    public static Locatario procuraPorId(Locatario id) {
        String sql = "SELECT id_locatario,cpf,rg,nome,telefone FROM colanofut.locatario where id_locatario like ?";
        Locatario locatario = null;
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, "%" + id + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
              locatario= new Locatario(rs.getInt("id_locatario"), rs.getString("cpf"), rs.getString("rg"), rs.getString("nome"), rs.getString("telefone"));

            }
            ConexaoBD.getConexao().close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locatario;
    }

    public static List<Locatario> procuraPorCPF(String cpf) {
        String sql = "SELECT id_locatario,cpf,rg,nome,telefone FROM colanofut.locatario where cpf like ?";
        List<Locatario> locatarioList = new ArrayList<>();
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, "%" + cpf + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                locatarioList.add(new Locatario(rs.getInt("id_locatario"), rs.getString("cpf"), rs.getString("rg"), rs.getString("nome"), rs.getString("telefone")));
            }
            ConexaoBD.getConexao().close();
            return locatarioList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Locatario> procuraPorRg(String rg) {
        String sql = "SELECT id_locatario,cpf,rg,nome,telefone FROM colanofut.locatario where rg like ?";
        List<Locatario> locatarioList = new ArrayList<>();
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, "%" + rg + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                locatarioList.add(new Locatario(rs.getInt("id_locatario"), rs.getString("cpf"), rs.getString("rg"), rs.getString("nome"), rs.getString("telefone")));
            }
            ConexaoBD.getConexao().close();
            return locatarioList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Locatario> procuraPorNome(Locatario locatario) {
        String sql = "SELECT id_locatario,cpf,rg,nome,telefone FROM colanofut.locatario where nome like ?";
        List<Locatario> locatarioList = new ArrayList<>();
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, "%" + locatario.getNome() + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                locatarioList.add(new Locatario(rs.getInt("id_locatario"), rs.getString("cpf"), rs.getString("rg"), rs.getString("nome"), rs.getString("telefone")));
            }
            ConexaoBD.getConexao().close();
            return locatarioList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Locatario> procuraPorTel(String telefone) {
        String sql = "SELECT id_locatario,cpf,rg,nome,telefone FROM colanofut.locatario where telefone like ?";
        List<Locatario> locatarioList = new ArrayList<>();
        try (Connection conn = ConexaoBD.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setString(1, "%" + telefone + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                locatarioList.add(new Locatario(rs.getInt("id_locatario"), rs.getString("cpf"), rs.getString("rg"), rs.getString("nome"), rs.getString("telefone")));
            }
            ConexaoBD.getConexao().close();
            return locatarioList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
