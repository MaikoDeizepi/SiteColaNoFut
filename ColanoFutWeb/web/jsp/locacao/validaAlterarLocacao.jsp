<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.ColaNoFut.Bean.Locacao"%>
<%@page import="br.com.ColaNoFut.Controler.ControlerLocacao"%>
<%@page import="br.com.ColaNoFut.Controler.ControlerLocatario"%>


    <%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    int idLoc = Integer.parseInt(request.getParameter("idLocador"));
    int idLoca = Integer.parseInt(request.getParameter("idLocatario"));
    String obs = request.getParameter("obs");
    String pbusca = request.getParameter("PBUSCA");
    Locacao locacao = new Locacao(id,idLoca,idLoc,obs);
    ControlerLocacao contLocacao = new ControlerLocacao();
    locacao = contLocacao.alterarLocacao(locacao);
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarRelacaoLocacao.jsp?obs=" + pbusca;
    response.sendRedirect(url);
%>   