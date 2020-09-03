<%-- 
    Document   : consultaUsuario
    Created on : 25/08/2017, 19:48:39
    Author     : ProfAlexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>CONSULTAR LOCADOR</title>
    <body>
       <div class="container"/>
       <h1>CONSULTAR USUÁRIO</h1>
       <form name="consultarLocador" action="validaConsultarLocador.jsp" method="post">
           Nome Proprietario: <input type="text" name ="nome_proprietario" value=""> <br>
           <input type="submit" name ="Enviar" value="Enviar"> <br>
      
           
       </form>
       </div>
    </body>
</html>
