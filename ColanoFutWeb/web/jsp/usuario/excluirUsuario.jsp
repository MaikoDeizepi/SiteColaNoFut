<%-- 
    Document   : excluirUsuario
    Created on : 31/08/2017, 09:57:18
    Author     : ProfAlexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.ColaNoFut.Controler.ControlerUsuario"%>
<%@page import="br.com.ColaNoFut.Bean.Usuario"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Usuario usu = new Usuario(id,"","","","","");
    ControlerUsuario usuCont = new ControlerUsuario();
    usu = usuCont.excluirUsuario(usu);
    String pbusca = request.getParameter("PBUSCA");
    
    String url = "validaConsultarUsuario.jsp?NOME="+pbusca;
    response.sendRedirect(url);
%>

