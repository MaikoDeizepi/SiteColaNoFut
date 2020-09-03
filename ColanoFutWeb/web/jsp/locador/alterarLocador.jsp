<%-- 
    Document   : excluirUsuario
    Created on : 31/08/2017, 09:57:18
    Author     : ProfAlexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.ColaNoFut.Controler.ControlerLocador"%>
<%@page import="br.com.ColaNoFut.Bean.Locador"%>

<%
    String cod = request.getParameter("ID");
    Integer id = Integer.parseInt(cod);
    Locador locador = new Locador(id,"","","","");
    ControlerLocador loc = new ControlerLocador();
    locador = loc.buscarLocador(locador);
    String pbusca = request.getParameter("PBUSCA");
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - LOCADOR</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR LOCADOR</h1>
        <form name="alterarLocador" action="validaAlterarLocador.jsp" method="post">
            ID: <input type="text" name="id_locador" value="<%=locador.getId_locador()%>"> <br>
            CNPJ: <input type="text" name="cnpj" value="<%=locador.getCnpj()%>"> <br>
            Nome proprietario: <input type="text" name="nome_proprietario" value="<%=locador.getNome_proprietario()%>"> <br>
            Nome Espaço: <input type="text" name="nome_espaco" value="<%=locador.getNome_espaco()%>"> <br>
            Telefone: <input type="text" name="telefone" value="<%=locador.getTelefone()%>"> <br>
            <input type="HIDDEN" name="ID" value="<%=locador.getId_locador()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        </div>
    </body>
</html>