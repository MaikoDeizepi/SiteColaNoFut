<%@page import="br.com.ColaNoFut.Controler.ControlerUsuario"%>
<%@page import="br.com.ColaNoFut.Bean.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    String login = request.getParameter("LOGIN");
    String senha = request.getParameter("SENHA");
    Usuario usu = new Usuario("", login, senha, "", "");
    ControlerUsuario usucont = new ControlerUsuario();
    usu = usucont.validaUsuario(usu);
    session.setAttribute("UsuarioLogado", usu);
%>

<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>SISTEMA </title>
    <body>
        <% if (!usu.getTipo().equals("")) { %>
        <!-- Dropdown1 Trigger -->
        <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown1'>Manter Controle de Usuario</a>         
        <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown2'>Manter Controle de Locador</a>        
        <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown3'>Manter Controle de Locatario</a>        
        <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown4'>Manter Controle de Locação</a>          

        <% if (usu.getTipo().equalsIgnoreCase("admin")) { %>
        <!-- Dropdown1 Structure -->
        <ul id='dropdown1' class='dropdown-content'>
            <li><a href="../usuario/inserirUsuario.jsp"> InseriUsuario </a></li>
            <li><a href="../usuario/consultarUsuario.jsp"> Consulta Usuario </a></li>
        </ul>
        <% } %>

        <% if ((usu.getTipo().equalsIgnoreCase("admin")) || (usu.getTipo().equalsIgnoreCase("usulocacao"))) { %>
        <!-- Dropdown2 Structure -->
        <ul id="dropdown2" class="dropdown-content">
            <li><a href="../locador/inserirLocador.jsp"> Inserir Locador </a></li>
            <li><a href="../locador/consultarLocador.jsp"> Consultar Locador</a></li>
        </ul>
        <% } else { %>
        <ul id='dropdown2' class='dropdown-content'>
           <li><a href="../locador/consultarLocador.jsp"> Consultar Locador</a></li>
        </ul>
        <% } %>

        <% if ((usu.getTipo().equalsIgnoreCase("admin")) || (usu.getTipo().equalsIgnoreCase("usulocatario"))) { %>
        <!-- Dropdown1 Structure -->
        <ul id='dropdown3' class='dropdown-content'>
            <li><a href="../locatario/inserirLocatario.jsp"> Inserir Locatario </a></li>
            <li><a href="../locatario/consultarLocatario.jsp"> Consultar Locatario</a></li>
        </ul>
        <% } else { %>
        <ul id='dropdown3' class='dropdown-content'>
            <li><a href="../locatario/consultarLocatario.jsp"> Consultar Locatario</a></li>
        </ul>
        <% } %>

        <% if (usu.getTipo().equalsIgnoreCase("admin")) { %>
        <!-- Dropdown1 Structure -->
        <ul id='dropdown4' class='dropdown-content'>
           <li><a href="../locacao/inserirRelacaoLocacao.jsp"> Inserir Locação </a></li>
            <li><a href="../locacao/consultarRelacaoLocacao.jsp"> Consultar Locação</a></li>
        </ul>
        <% } else { %>
        <ul id='dropdown4' class='dropdown-content'>
              <li><a href="../locacao/consultarRelacaoLocacao.jsp"> Consultar Locação</a></li>
        </ul>
        <% } %>

      
        <% } else { %>
        <h1>USUÁRIO INVÁLIDO</h1>
        <% }%>




    </body>
</html>
