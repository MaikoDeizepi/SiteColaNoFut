<%-- 
    Document   : validaConsultarUsuario
    Created on : 25/08/2017, 19:54:19
    Author     : ProfAlexandre
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.ColaNoFut.Controler.ControlerUsuario"%>
<%@page import="br.com.ColaNoFut.Bean.Usuario"%>

<%
    String nome = request.getParameter("NOME");
    Usuario  usu = new Usuario(0,nome,"","","","");
    ControlerUsuario usucont = new ControlerUsuario();
    List<Usuario> usus = usucont.listarUsuario(usu);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + usu.getNome() +"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA USUÁRIOS</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id">Id</th>
                  <th data-field="Login">Login</th>
                  <th data-field="Login">Nome</th>
                  <th data-field="Senha">Senha</th>
                  <th data-field="Status">Status</th>
                  <th data-field="Tipo">Tipo</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(usus.isEmpty())) { %>    
                <tbody>
                    <% for (Usuario listaUsuario : usus) { %>
                        <tr>
                            <td><%=listaUsuario.getId()%></td>
                            <td><%=listaUsuario.getLogin()%></td>
                            <td><%=listaUsuario.getNome()%></td>
                            <td><%=listaUsuario.getSenha()%></td>
                            <td><%=listaUsuario.getStatus()%></td>
                            <td><%=listaUsuario.getTipo()%></td>
                            <% if (usuLogado.getTipo().equals("admin")) { %>
                                <td><a href="excluirUsuario.jsp?<%=url + listaUsuario.getId()%>">Excluir</a></td>
                                <td><a href="alterarUsuario.jsp?<%=url + listaUsuario.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                
                </tbody>
             
            <% } %>
        </table>    
    </body>
</html>