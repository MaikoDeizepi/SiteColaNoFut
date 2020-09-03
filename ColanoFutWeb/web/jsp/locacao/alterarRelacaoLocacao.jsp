<%-- 
    Document   : excluirUsuario
    Created on : 31/08/2017, 09:57:18
    Author     : ProfAlexandre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="br.com.ColaNoFut.Bean.Locador"%>
<%@page import="br.com.ColaNoFut.Bean.Locacao"%>
<%@page import="br.com.ColaNoFut.Bean.Locatario"%>

<%@page import="br.com.ColaNoFut.Controler.ControlerLocador"%>
<%@page import="br.com.ColaNoFut.Controler.ControlerLocatario"%>
<%@page import="br.com.ColaNoFut.Controler.ControlerLocacao"%>



<%
    ControlerLocador contLocador = new ControlerLocador();
    List<Locador> locadors = contLocador.listarLocadors();

    ControlerLocatario contLocatario = new ControlerLocatario();
    List<Locatario> locatarios = contLocatario.listarLocatarios();
    
    
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Locacao locacao = new Locacao(id,0,0,"");
    ControlerLocacao contLocacao = new ControlerLocacao();
    locacao = contLocacao.buscarLocacaoPorId(locacao);
    String pbusca = request.getParameter("PBUSCA");


%>


    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - LOCAÇÃO</title>
    
       <div class="container"/>
       <h1>ALTERAR - LOCAÇÃO</h1>
        <form name="alterarRelacaoLocacao" action="validaAlterarLocacao.jsp" method="post">
            <table>
                <tr>
                    <td>LOCADOR</td>
                        <td>
                            <select NAME="idLocador" class="browser-default">
                                <% for (Locador loc :locadors ) { %>
                                <% if( loc.getId_locador() == locacao.getIdLocador()) { %>
                                        <option selected value="<%=loc.getId_locador()%>"><%=loc.getNome_espaco()%></option>
                                    <% } else { %>
                                    <option value="<%=loc.getId_locador()%>"><%=loc.getNome_espaco()%></option>
                                    <% } %>
                                <% } %>
                            </select> 
                        </td>
                </tr>
                <tr>
                        <td>LOCATARIO</td>
                        <td>
                            <select NAME ="idLocatario" class="browser-default">
                                <% for (Locatario loca : locatarios) { %>
                                    <% if( loca.getId_locatario()== locacao.getIdlocatario()) { %>
                                        <option selected value="<%=loca.getId_locatario()%>"><%=loca.getNome()%></option>
                                    <% } else { %>
                                        <option value="<%=loca.getId_locatario()%>"><%=loca.getNome()%></option>
                                    <% } %>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Observação:</td>
                        <td><input type="text" name="obs" value="<%=locacao.getObs()%>"></td>

                    </tr>
                </table>    
            <input type="HIDDEN" name="ID" value="<%=locacao.getIdLocadLocat()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>">
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
        </div>
       
