<%-- 
    Document   : validaConsultarUsuario
    Created on : 25/08/2017, 19:54:19
    Author     : ProfAlexandre
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.ColaNoFut.Controler.ControlerLocatario"%>
<%@page import="br.com.ColaNoFut.Bean.Locatario"%>
<%@page import="br.com.ColaNoFut.Bean.Usuario"%>




<%
    
    String nome = request.getParameter("nome");
    Locatario loc = new Locatario(0,"","",nome,"");
    ControlerLocatario cl = new ControlerLocatario();
    List<Locatario> locadors = cl.listarLocatario(loc);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + loc.getNome()+"&ID=" ;
%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA LOCADOR</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="id_locatario">Id</th>
                  <th data-field="cpf">Cpf</th>
                  <th data-field="rg">RG</th>
                  <th data-field="nome">Nome</th>
                  <th data-field="telefone">Telefone</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(locadors.isEmpty())) { %>    
                <tbody>  <% for (Locatario locador : locadors) { %>
                        <tr>
                            <td><%=locador.getId_locatario()%></td>
                            <td><%=locador.getCpf()%></td>
                            <td><%=locador.getRg()%></td>
                            <td><%=locador.getNome()%></td>
                            <td><%=locador.getTelefone()%></td>
                             
                            <% if (usuLogado.getTipo().equals("admin")) { %>
                                <td><a href="excluirLocatario.jsp?<%=url + locador.getId_locatario()%>">Excluir</a></td>
                                <td><a href="alterarLocatario.jsp?<%=url + locador.getId_locatario()%>">Alterar</a></td>
                             <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>