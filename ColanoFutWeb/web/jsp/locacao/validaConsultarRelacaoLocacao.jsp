<%-- 
    Document   : validaConsultarUsuario
    Created on : 25/08/2017, 19:54:19
    Author     : ProfAlexandre
--%>

<%@page import="br.com.ColaNoFut.Bean.Usuario"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.ColaNoFut.Bean.Locacao"%>
<%@page import="br.com.ColaNoFut.Controler.ControlerLocacao"%>

<%
    String obs = request.getParameter("obs");
    Locacao locacao = new Locacao(0,0,0,obs);
    ControlerLocacao contLocacao = new ControlerLocacao();
    List<Locacao> locacoes = contLocacao.listarLocacao(locacao);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + locacao.getObs() +"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA LOCACAO</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="idLocadLocat">Id</th>
                  <th data-field="idLocador">idLocador</th>
                  <th data-field="nome_proprietario">Nome do Espaço</th>
                  <th data-field="idLocatario">idlocatario</th>
                  <th data-field="nome">Nome do locatario</th>
                  <th data-field="obs">Observacao</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(locacoes.isEmpty())) { %>    
                <tbody>
                    <% for (Locacao locac : locacoes) { %>
                        <tr>
                            <td><%=locac.getIdLocadLocat()%></td>
                            <td><%=locac.getLocador().getId_locador()%></td>
                            <td><%=locac.getLocador().getNome_espaco()%></td>
                            <td><%=locac.getLocatario().getId_locatario()%></td>
                            <td><%=locac.getLocatario().getNome()%></td>
                            <td><%=locac.getObs()%></td>
                            <% if (usuLogado.getTipo().equals("admin")) { %>
                                <td><a href="excluirRelacaoLocacao.jsp?<%=url + locac.getIdLocadLocat()%>">Excluir</a></td>
                                <td><a href="alterarRelacaoLocacao.jsp?<%=url + locac.getIdLocadLocat()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>