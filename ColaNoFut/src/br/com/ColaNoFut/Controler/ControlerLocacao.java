/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ColaNoFut.Controler;

import br.com.ColaNoFut.Bean.Locacao;
import br.com.ColaNoFut.Bean.Locador;
import br.com.ColaNoFut.Bean.Locatario;
import br.com.ColaNoFut.DAO.LocacaoDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author MAIKOVITORDEIZEPISIL
 */
public class ControlerLocacao {
 

    public static ControlerLocador  contLocador;
    public static ControlerLocatario contLocatario;
    public static LocacaoDAO locacaoDAO;
    
    public Locacao buscarLocacaoPorId(Locacao locacao) throws SQLException, ClassNotFoundException {

        locacaoDAO = new LocacaoDAO();
        locacao = locacaoDAO.busca(locacao);
        
        contLocador = new ControlerLocador();
        contLocatario = new ControlerLocatario();

        Locador loc = new Locador(locacao.getIdLocador(),"","","","");
        Locatario loca = new Locatario(locacao.getIdlocatario(),"","","","");
        
        locacao.setLocador(contLocador.buscarLocador(loc));
        locacao.setLocatario(contLocatario.buscaLocatario(loca));

        return locacao;
    }
    
    public Locacao inserirLocacao(Locacao locacao) throws SQLException, ClassNotFoundException {
        locacaoDAO = new LocacaoDAO();
        return locacaoDAO.inseri(locacao);
    }
 
    public Locacao alterarLocacao(Locacao locacao) throws SQLException, ClassNotFoundException {
        locacaoDAO = new LocacaoDAO();
        return locacaoDAO.altera(locacao);
    }

    public Locacao excluirLocacao(Locacao locacao) throws SQLException, ClassNotFoundException {
        locacaoDAO = new LocacaoDAO();
        return locacaoDAO.exclui(locacao);
    }

    public List<Locacao> listarLocacao(Locacao locacao) throws SQLException, ClassNotFoundException {

         locacaoDAO = new LocacaoDAO();

        List<Locacao> locacaolist = locacaoDAO.lista(locacao);
        
        contLocador = new ControlerLocador();
        contLocatario = new ControlerLocatario();
        for (Locacao localist : locacaolist) {
            Locador loc = new Locador(localist.getIdLocador(),"","","","");
            Locatario locatario = new Locatario(localist.getIdlocatario(),"","","","");
            localist.setLocador(contLocador.buscarLocador(loc));
            localist.setLocatario(contLocatario.buscaLocatario(locatario));
            localist.toString();
            
           
        }

        return locacaolist;
    }
}
