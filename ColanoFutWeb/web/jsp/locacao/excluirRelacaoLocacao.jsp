<%-- 
    Document   : excluirUsuario
    Created on : 31/08/2017, 09:57:18
    Author     : ProfAlexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.ColaNoFut.Controler.ControlerLocacao"%>
<%@page import="br.com.ColaNoFut.Bean.Locacao"%>


<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Locacao locacao = new Locacao(id,0,0,"");
    ControlerLocacao contLocacao = new ControlerLocacao();
    locacao = contLocacao.excluirLocacao(locacao);
    
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarRelacaoLocacao.jsp?obs=" + pbusca;
    response.sendRedirect(url);

%>

