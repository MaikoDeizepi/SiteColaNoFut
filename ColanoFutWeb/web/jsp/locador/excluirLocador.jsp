<%-- 
    Document   : excluirUsuario
    Created on : 31/08/2017, 09:57:18
    Author     : ProfAlexandre
--%>

<%@page import="br.com.ColaNoFut.Bean.Locador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.ColaNoFut.Controler.ControlerLocador"%>


<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Locador loc = new Locador(id,"","","","");
    ControlerLocador usuCont = new ControlerLocador();
    loc = usuCont.excluirNome(loc);
    String pbusca = request.getParameter("PBUSCA");
    
    
    String url = "validaConsultarLocador.jsp?nome_proprietario="+pbusca;
    response.sendRedirect(url);
    
%>
