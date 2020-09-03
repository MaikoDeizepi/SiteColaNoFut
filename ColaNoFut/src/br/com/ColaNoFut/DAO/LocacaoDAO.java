/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ColaNoFut.DAO;

import br.com.ColaNoFut.BD.ConexaoBD;
import br.com.ColaNoFut.Bean.Locacao;
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
public class LocacaoDAO {
    
    private final Connection c;
    public LocacaoDAO ()throws SQLException, ClassNotFoundException{
        this.c = ConexaoBD.getConexao();
        
    }
    
    
    
    public Locacao altera(Locacao locacao) throws SQLException{
        String sql = "UPDATE `locacao` SET  `idlocatario` = ?, `idlocador` = ?, `obs` = ? WHERE `locacao`.`idlocacao` = ?";
        
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,locacao.getIdlocatario());
        stmt.setInt(2,locacao.getIdLocador());
        stmt.setString(3,locacao.getObs());
        stmt.setInt(4,locacao.getIdLocadLocat());
        

        // executa
        stmt.execute();
        stmt.close();
        return locacao;
    }

    public Locacao exclui(Locacao locacao) throws SQLException{
        String sql = "DELETE FROM `locacao` WHERE `locacao`.`idlocacao` = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,locacao.getIdLocadLocat());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return locacao;
    }


    public Locacao inseri(Locacao locacao) throws SQLException{
        ;
        String sql = "INSERT INTO `locacao` (`idlocatario`, `idlocador`, `obs`) VALUES ( ?, ?, ?);";

        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        
        
        stmt.setInt(1,locacao.getIdlocatario());
        stmt.setInt(2,locacao.getIdLocador());
        stmt.setString(3,locacao.getObs());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            locacao.setIdLocadLocat(id);
        }
        stmt.close();
        c.close();
        return locacao;

    }
    
    public Locacao busca(Locacao locacao) throws SQLException{
        String sql = "SELECT * FROM locacao WHERE idlocacao = ?";
        
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,locacao.getIdLocadLocat());
            // executa
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                // criando o objeto Usuario
                locacao.setIdLocadLocat(rs.getInt(1));
                locacao.setIdlocatario(rs.getInt(2));
                locacao.setIdLocador(rs.getInt(3));
                locacao.setObs(rs.getString(4));
                // adiciona o usu à lista de usus
            }
        return locacao;
    }
    
    public List<Locacao> lista(Locacao locacao) throws SQLException{

        List<Locacao> locacaos = new ArrayList<>();
        
        String sql = "SELECT * FROM `locacao` WHERE `obs` LIKE ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1, "%"+locacao.getObs()+"%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Locacao loc = new Locacao(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4)
            );
            // adiciona o usu à lista de usus
            locacaos.add(loc);
        }
        
        rs.close();
        stmt.close();
        return locacaos;
    }
}
