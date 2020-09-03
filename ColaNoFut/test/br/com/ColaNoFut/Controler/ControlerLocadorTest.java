/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ColaNoFut.Controler;

import br.com.ColaNoFut.Bean.Locador;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MAIKOVITORDEIZEPISIL
 */
public class ControlerLocadorTest {
    
    public ControlerLocadorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   
    @Test
    public void testConsultarPorNome() throws SQLException, ClassNotFoundException {
        Locador locador = new Locador(3,"","maiko","","");
        ControlerLocador cl = new ControlerLocador();
        locador = cl.buscarLocador(locador);
    }

    
}
