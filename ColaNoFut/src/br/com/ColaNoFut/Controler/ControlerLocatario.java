/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ColaNoFut.Controler;

import br.com.ColaNoFut.Bean.Locatario;
import br.com.ColaNoFut.DAO.LocatarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MAIKOVITORDEIZEPISIL
 */
public class ControlerLocatario {
    
    public static LocatarioDAO locatarioDAO;

    public static Locatario inserirNome(Locatario locatario) throws SQLException, ClassNotFoundException{
        locatarioDAO = new LocatarioDAO();
        return locatarioDAO.salvar(locatario);
    }

    public static Locatario alterarNome(Locatario locatario) throws SQLException, ClassNotFoundException{
        locatarioDAO = new LocatarioDAO();
        return locatarioDAO.atualizar(locatario);
    }
    public static Locatario buscaLocatario(Locatario locatario) throws SQLException, ClassNotFoundException{
        locatarioDAO = new LocatarioDAO();
        return locatarioDAO.busca(locatario);
    }
    
     public List<Locatario> listarLocatario(Locatario loc) throws SQLException, ClassNotFoundException {
        List<Locatario>  locs = new ArrayList(); ;
        LocatarioDAO locDao = new LocatarioDAO();
        locs = locDao.lista(loc);
        return locs;
    }
     public List<Locatario> listarLocatarios() throws SQLException, ClassNotFoundException {
        List<Locatario>  locs = new ArrayList(); ;
        LocatarioDAO locDao = new LocatarioDAO();
        locs = locDao.listas();
        return locs;
    }

    public static Locatario excluirNome(Locatario locatario) throws SQLException, ClassNotFoundException{
        locatarioDAO = new LocatarioDAO();
        return locatarioDAO.deletar(locatario);
    }
//    public static List<Locatario> consultarNome(Locatario locatario){
//        List<Locatario> locatarioList = new ArrayList<>();
//        locatarioList = locatarioDAO.consultar(locatario);
//        for (Locatario lista : locatarioList){
//            System.out.println(lista);
//        }
//        return locatarioList;
//    }

    public static List<Locatario> consultarporNome(Locatario locatario) {
        List<Locatario> locatarioList = new ArrayList<>();
        locatarioList = locatarioDAO.procuraPorNome(locatario);
        for (Locatario lista : locatarioList) {
            System.out.println(lista);
        }
        return locatarioList;
    }

        public static Locatario buscarPorId (Locatario locatario) throws SQLException, ClassNotFoundException{
            locatarioDAO = new LocatarioDAO();
            return locatarioDAO.procuraPorId(locatario);
        }
}
