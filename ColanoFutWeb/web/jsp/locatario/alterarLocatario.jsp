<%-- 
    Document   : excluirUsuario
    Created on : 31/08/2017, 09:57:18
    Author     : ProfAlexandre
--%>

<%@page import="br.com.ColaNoFut.Controler.ControlerLocatario"%>
<%@page import="br.com.ColaNoFut.Bean.Locatario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.ColaNoFut.Controler.ControlerUsuario"%>
<%@page import="br.com.ColaNoFut.Bean.Usuario"%>

<%
    String cod = request.getParameter("ID");
    Integer id = Integer.parseInt(cod);
    Locatario locatario = new Locatario(id,"","","","");
    ControlerLocatario usuCont = new ControlerLocatario();
    locatario = usuCont.buscaLocatario(locatario);
    String pbusca = request.getParameter("PBUSCA");
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - LOCATARIO</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR LOCATARIO</h1>
        <form name="alterarLocatario" action="validaAlterarLocatario.jsp" method="post">
            ID: <input type="text" name="id_locatario" value="<%=locatario.getId_locatario()%>"> <br>
            CPF: <input type="text" name="cpf" value="<%=locatario.getCpf()%>"> <br>
            RG: <input type="text" name="rg" value="<%=locatario.getRg()%>"> <br>
            Nome : <input type="text" name="nome" value="<%=locatario.getNome()%>"> <br>
            Telefone: <input type="text" name="telefone" value="<%=locatario.getTelefone()%>"> <br>
            <input type="HIDDEN" name="ID" value="<%=locatario.getId_locatario()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        </div>
    </body>
</html>