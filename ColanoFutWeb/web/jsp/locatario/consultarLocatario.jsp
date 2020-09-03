<%-- 
    Document   : consultaUsuario
    Created on : 25/08/2017, 19:48:39
    Author     : ProfAlexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>CONSULTAR - LOCATARIO</title>
    <body>
       <div class="container"/>
       <h1>CONSULTAR LOCATARIO</h1>
       <form name="consultarLocatario" action="validaConsultarLocatario.jsp" method="post">
           Nome: <input type="text" name ="nome" value=""> <br>
           <input type="submit" name ="Enviar" value="Enviar"> <br>
       </form>
       </div>
    </body>
</html>
