<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.ColaNoFut.Controler.ControlerLocador"%>
<%@page import="br.com.ColaNoFut.Bean.Locador"%>

<%
    String nome_proprietario = request.getParameter("nome_proprietario");
    String nome_espaco = request.getParameter("nome_espaco");
    String cnpj = request.getParameter("cnpj");
    String telefone = request.getParameter("telefone");
    Locador loc = new Locador(0,cnpj,nome_proprietario,nome_espaco,cnpj);
    ControlerLocador cl = new ControlerLocador();
    loc = cl.inserirNome(loc);

    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirLocador.jsp";
    response.sendRedirect(url);
%>