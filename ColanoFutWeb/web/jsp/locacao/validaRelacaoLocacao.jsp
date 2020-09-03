<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.ColaNoFut.Bean.Locacao"%>
<%@page import="br.com.ColaNoFut.Controler.ControlerLocacao"%>


<%
    int idLoc = Integer.parseInt(request.getParameter("idLocador"));
    int idLoca = Integer.parseInt(request.getParameter("idLocatario"));
    String obs = request.getParameter("obs");
    
    Locacao locacao = new Locacao(0,idLoca,idLoc,obs);
    ControlerLocacao controlerLocacao = new ControlerLocacao();
    locacao = controlerLocacao.inserirLocacao(locacao); 
    
// REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirRelacaoLocacao.jsp";
    response.sendRedirect(url);

%>