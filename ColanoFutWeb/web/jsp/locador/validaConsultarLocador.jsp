<%-- 
    Document   : validaConsultarUsuario
    Created on : 25/08/2017, 19:54:19
    Author     : ProfAlexandre
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.ColaNoFut.Controler.ControlerLocador"%>
<%@page import="br.com.ColaNoFut.Bean.Locador"%>
<%@page import="br.com.ColaNoFut.Bean.Usuario"%>




<%
    
    String nome_proprietario = request.getParameter("nome_proprietario");
    Locador loc = new Locador(0,"",nome_proprietario,"","");
    ControlerLocador cl = new ControlerLocador();
    List<Locador> locadors = cl.listarLocador(loc);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + loc.getNome_proprietario() +"&ID=" ;
%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA LOCADOR</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id_locador">Id</th>
                  <th data-field="Cnpj">Cnpj</th>
                  <th data-field="Nome_proprietario">Nome Proprietario</th>
                  <th data-field="Nome_espaco">Nome Espaço</th>
                  <th data-field="telefone">Telefone</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(locadors.isEmpty())) { %>    
                <tbody>  <% for (Locador locador : locadors) { %>
                        <tr>
                            <td><%=locador.getId_locador()%></td>
                            <td><%=locador.getCnpj()%></td>
                            <td><%=locador.getNome_proprietario()%></td>
                            <td><%=locador.getNome_espaco()%></td>
                            <td><%=locador.getTelefone()%></td>
                             
                            <% if (usuLogado.getTipo().equals("admin")) { %>
                                <td><a href="excluirLocador.jsp?<%=url + locador.getId_locador()%>">Excluir</a></td>
                                <td><a href="alterarLocador.jsp?<%=url + locador.getId_locador()%>">Alterar</a></td>
                             <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>