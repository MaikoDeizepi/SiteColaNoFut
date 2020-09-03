<%-- 
    Document   : consultaUsuario
    Created on : 25/08/2017, 19:48:39
    Author     : ProfAlexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>CONSULTAR LOCAÇÃO</title>
    <body>
       <div class="container"/>
       <h1>CONSULTAR LOCACAO</h1>
       <form name="consultarRelacaoLocacao" action="validaConsultarRelacaoLocacao.jsp" method="post">
           Observação: <input type="text" name ="obs" value=""> <br>
           <input type="submit" name ="Enviar" value="Enviar"> <br>
       </form>
       </div>
    </body>
</html>
