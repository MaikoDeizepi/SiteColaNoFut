<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.ColaNoFut.Controler.ControlerLocador"%>
<%@page import="br.com.ColaNoFut.Bean.Locador"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    String cnpj = request.getParameter("cnpj");
    String nome_proprietario = request.getParameter("nome_proprietario");
    String nome_espaco = request.getParameter("nome_espaco");
    String telefone = request.getParameter("telefone");
    String pbusca = request.getParameter("PBUSCA");
    
    Locador loc = new Locador(id,cnpj,nome_proprietario,nome_espaco,telefone);
    ControlerLocador cl = new ControlerLocador();
    loc = cl.alterarNome(loc);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarLocador.jsp?nome_proprietario=" + pbusca;
    response.sendRedirect(url);
%>