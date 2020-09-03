<%@page import="br.com.ColaNoFut.Controler.ControlerLocatario"%>
<%@page import="br.com.ColaNoFut.Bean.Locatario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.ColaNoFut.Controler.ControlerUsuario"%>
<%@page import="br.com.ColaNoFut.Bean.Usuario"%>



<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    String cpf = request.getParameter("cpf");
    String rg = request.getParameter("rg");
    String nome = request.getParameter("nome");
    String telefone = request.getParameter("telefone");
    String pbusca = request.getParameter("PBUSCA");
    
    Locatario loc = new Locatario(id,cpf,rg,nome,telefone);
    ControlerLocatario cl = new ControlerLocatario();
    loc = cl.alterarNome(loc);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarLocatario.jsp?nome=" + pbusca;
    response.sendRedirect(url);
%>