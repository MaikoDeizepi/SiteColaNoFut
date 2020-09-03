/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ColaNoFut.Controler;

import br.com.ColaNoFut.Bean.Usuario;
import br.com.ColaNoFut.DAO.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author MAIKOVITORDEIZEPISIL
 */
public class ControlerUsuario {
    
      public Usuario validaUsuario(Usuario usu) throws SQLException, ClassNotFoundException {
        UsuarioDAO usuDao = new UsuarioDAO();
        usu = usuDao.validaLogin(usu);
        return usu;
    }
    
    public Usuario inserirUsuario(Usuario usu) throws SQLException, ClassNotFoundException {
        UsuarioDAO usuDao = new UsuarioDAO();
        usu = usuDao.inseri(usu);
        return usu;
    }

    public Usuario excluirUsuario(Usuario usu) throws SQLException, ClassNotFoundException {
        UsuarioDAO usuDao = new UsuarioDAO();
        usu = usuDao.exclui(usu);
        return usu;
    }

    public Usuario buscarUsuario(Usuario usu) throws SQLException, ClassNotFoundException {
        UsuarioDAO usuDao = new UsuarioDAO();
        usu = usuDao.busca(usu);
        return usu;
    }

    public Usuario alterarUsuario(Usuario usu) throws SQLException, ClassNotFoundException {
        UsuarioDAO usuDao = new UsuarioDAO();
        usu = usuDao.altera(usu);
        return usu;
    }
    
    public List<Usuario> listarUsuario(Usuario usu) throws SQLException, ClassNotFoundException {
        List<Usuario>  usus ;
        UsuarioDAO usuDao = new UsuarioDAO();
        usus = usuDao.lista(usu);
        return usus;
    }

    public List<Usuario> listarTodosUsuario() throws SQLException, ClassNotFoundException {
        List<Usuario>  usus ;
        UsuarioDAO usuDao = new UsuarioDAO();
        usus = usuDao.listaTodos();
        return usus;
    }

}
