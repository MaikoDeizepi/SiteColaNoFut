<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.ColaNoFut.Controler.ControlerUsuario"%>
<%@page import="br.com.ColaNoFut.Bean.Usuario"%>

<%
    String nome = request.getParameter("NOME");
    String login = request.getParameter("LOGIN");
    String senha = request.getParameter("SENHA");
    String status = request.getParameter("STATUS");
    String tipo = request.getParameter("TIPO");
    Usuario usu = new Usuario(0,login,nome,senha,status,tipo);
    ControlerUsuario usucont = new ControlerUsuario();
    usu = usucont.inserirUsuario(usu);

    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirUsuario.jsp";
    response.sendRedirect(url);
%>
