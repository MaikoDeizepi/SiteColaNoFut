<%-- 
    Document   : excluirUsuario
    Created on : 31/08/2017, 09:57:18
    Author     : ProfAlexandre
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.ColaNoFut.Controler.ControlerUsuario"%>
<%@page import="br.com.ColaNoFut.DAO.UsuarioDAO"%>
<%@page import="br.com.ColaNoFut.Bean.Usuario"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Usuario usu = new Usuario(id,"","","","","");
    ControlerUsuario usuCont = new ControlerUsuario();
    usu = usuCont.buscarUsuario(usu);
    String pbusca = request.getParameter("PBUSCA");
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - USUÁRIO</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR USUÁRIO</h1>
        <form name="alterarUsuario" action="validaAlterarUsuario.jsp" method="post">
            
            ID: <input type="text" name="ID" value="<%=usu.getId()%>"> <br>
            Login: <input type="text" name="LOGIN" value="<%=usu.getLogin()%>"> <br>
            Nome: <input type="text" name="NOME" value="<%=usu.getNome()%>"> <br>
            Login: <input type="text" name="LOGIN" value="<%=usu.getLogin()%>"> <br>
            Senha: <input type="password" name="SENHA" value="<%=usu.getSenha()%>"> <br>
            Status: <input type="text" name="STATUS" value="<%=usu.getStatus()%>"> <br>
            Tipo: <input type="text" name="TIPO" value="<%=usu.getTipo()%>"> <br>
            <input type="HIDDEN" name="ID" value="<%=usu.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        </div>
    </body>
</html>