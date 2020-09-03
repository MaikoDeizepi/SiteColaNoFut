<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR - LOCATARIO</title>
    <body>
       <div class="container"/>
        <h1>INSERIR LOCATARIO</h1>
        <form name="inserirUsuario" action="validaInserirLocatario.jsp" method="post">
            CPF: <input type="text" name="cpf" value=""> <br>
            RG: <input type="text" name="rg" value=""> <br>
            Nome: <input type="text" name="nome" value=""> <br>
            Telefone <input type="text" name="telefone" value=""> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        </div>
    </body>
</html>
