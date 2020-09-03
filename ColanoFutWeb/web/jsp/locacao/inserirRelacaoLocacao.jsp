<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="br.com.ColaNoFut.Bean.Locador"%>
<%@page import="br.com.ColaNoFut.Bean.Locatario"%>
<%@page import="br.com.ColaNoFut.Controler.ControlerLocador"%>
<%@page import="br.com.ColaNoFut.Controler.ControlerLocatario"%>


<%
    ControlerLocador controleLoc = new ControlerLocador();
    List<Locador> locadors = controleLoc.listarLocadors();

    ControlerLocatario controleLoca = new ControlerLocatario();
    List<Locatario> locatarios = controleLoca.listarLocatarios();

%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR LOCAÇÃO</title>
    <body>
        <div class="container"/>
            <h1>Inserir Locacao</h1>
            <form name="inserirRelacaoLocacao" action="validaRelacaoLocacao.jsp" method="POST">
                <table>
                    <tr>
                        <td> Locatario : Nome Locatario</td>
                        <td>
                            <select NAME ="idLocatario" class="browser-default">
                                <% for (Locatario loca : locatarios) { %>
                                    <option value="<%=loca.getId_locatario()%>"><%=loca.getNome()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Locador: Nome espaço </td>
                        <td>
                            <select NAME="idLocador" class="browser-default">
                                <% for (Locador loc : locadors) { %>
                                    <option value="<%=loc.getId_locador()%>"><%=loc.getNome_espaco()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Observação:</td>
                        <td><input type="text" name="obs" value=""></td>
                    </tr>
                </table>    
                <input type="submit" name="Enviar" value="Enviar">  <br>
            </form>
        </div>                     
    </body>
</html>
