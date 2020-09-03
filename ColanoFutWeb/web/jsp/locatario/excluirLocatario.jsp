<%-- 
    Document   : excluirUsuario
    Created on : 31/08/2017, 09:57:18
    Author     : ProfAlexandre
--%>

<%@page import="br.com.ColaNoFut.Controler.ControlerLocatario"%>
<%@page import="br.com.ColaNoFut.Bean.Locatario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.ColaNoFut.Controler.ControlerUsuario"%>
<%@page import="br.com.ColaNoFut.Bean.Usuario"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Locatario loc = new Locatario(id,"","","","");
    ControlerLocatario usuCont = new ControlerLocatario();
    loc = usuCont.excluirNome(loc);
    String pbusca = request.getParameter("PBUSCA");
    
    String url = "validaConsultarLocatario.jsp?nome="+pbusca;
    response.sendRedirect(url);
%>
