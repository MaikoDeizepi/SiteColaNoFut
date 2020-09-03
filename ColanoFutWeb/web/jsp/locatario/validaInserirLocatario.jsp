<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.ColaNoFut.Controler.ControlerLocatario"%>
<%@page import="br.com.ColaNoFut.Bean.Locatario"%>

<%
    String nome = request.getParameter("nome");
    String rg = request.getParameter("rg");
    String cpf = request.getParameter("cpf");
    String telefone = request.getParameter("telefone");
    Locatario loc = new Locatario(0,cpf,rg,nome,telefone);
    ControlerLocatario cl = new ControlerLocatario();
    loc = cl.inserirNome(loc); 

    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirLocatario.jsp";
    response.sendRedirect(url);
%>
