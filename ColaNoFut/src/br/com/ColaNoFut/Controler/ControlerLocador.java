/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ColaNoFut.Controler;

import br.com.ColaNoFut.Bean.Locador;
import br.com.ColaNoFut.DAO.LocadorDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MAIKOVITORDEIZEPISIL
 */
public class ControlerLocador {
    public static LocadorDAO locadorDAO;

    public static Locador inserirNome(Locador locador) throws SQLException, ClassNotFoundException {
        locadorDAO = new LocadorDAO();
        return LocadorDAO.salvar(locador);
    }

    public Locador alterarNome(Locador locador) throws SQLException, ClassNotFoundException {
        LocadorDAO usuDao = new LocadorDAO();
        locador = usuDao.atualizar(locador);
        return locador;
    }
    

    public static Locador excluirNome(Locador locador) throws SQLException, ClassNotFoundException {
        if (locador == null | locador.getId_locador() == null) {
            System.out.println("Não é possível localizar o registro");
            return null;
        }
        locadorDAO = new LocadorDAO();
        return LocadorDAO.deletar(locador);
    }
    
   
    public Locador buscarLocador(Locador locador) throws SQLException, ClassNotFoundException {
        LocadorDAO locdao = new LocadorDAO();
        locador = locdao.busca(locador);
        return locador;
    }
    
     public List<Locador> listarLocador(Locador locador) throws SQLException, ClassNotFoundException {
        List<Locador>  locs ;
        LocadorDAO locDao = new LocadorDAO();
        locs = locDao.lista(locador);
        return locs;
    }
    
     public List<Locador> listarLocadors() throws SQLException, ClassNotFoundException {
        List<Locador>  locs ;
        LocadorDAO locDao = new LocadorDAO();
        locs = locDao.listas();
        return locs;
    }
    
     
    

    public static Locador buscarPorId(Locador locador) throws SQLException, ClassNotFoundException {
        if (locador == null | locador.getId_locador() == null) {
            System.out.println("Não é possível localizar o registro");
            return null;
        }
        locadorDAO = new LocadorDAO();
        return LocadorDAO.procuraPorId(locador);
    }

}
