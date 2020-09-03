<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR - LOCADOR</title>
    <body>
       <div class="container"/>
        <h1>INSERIR LOCADOR</h1>
        <form name="inserirLocador" action="validaInserirLocador.jsp" method="post">
            Nome Proprietario: <input type="text" name="nome_proprietario" value=""> <br>
            Nome Espaço: <input type="text" name="nome_espaco" value=""> <br>
            CNPJ: <input type="text" name="cnpj" value=""> <br>
            Telefone: <input type="text" name="telefone" value=""> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        </div>
    </body>
</html>
