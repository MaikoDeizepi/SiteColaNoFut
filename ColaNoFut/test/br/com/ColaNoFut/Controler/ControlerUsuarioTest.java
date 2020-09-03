/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ColaNoFut.Controler;

import br.com.ColaNoFut.Bean.Usuario;
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
public class ControlerUsuarioTest {
    
    public ControlerUsuarioTest() {
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

    /**
     * Test of validaUsuario method, of class ControlerUsuario.
     */
    

    /**
     * Test of inserirUsuario method, of class ControlerUsuario.
     */
    @Test
    public void testInserirUsuario() throws Exception {
       Usuario usu = new Usuario(4,"teste","teste","teste","","admin");
       ControlerUsuario controlerUsuario = new ControlerUsuario();
       usu = controlerUsuario.inserirUsuario(usu);
    }

    /**
     * Test of excluirUsuario method, of class ControlerUsuario.
     */
    @Test
    public void testExcluirUsuario() throws Exception {
        Usuario usu = new Usuario(9,"","","","","");
       ControlerUsuario controlerUsuario = new ControlerUsuario();
       usu = controlerUsuario.excluirUsuario(usu);
    }

    /**
     * Test of buscarUsuario method, of class ControlerUsuario.
     */
    /**
    @Test
    public void testBuscarUsuario() throws Exception {
        System.out.println("buscarUsuario");
        Usuario usu = null;
        ControlerUsuario instance = new ControlerUsuario();
        Usuario expResult = null;
        Usuario result = instance.buscarUsuario(usu);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterarUsuario method, of class ControlerUsuario.
    
    @Test
    public void testAlterarUsuario() throws Exception {
        System.out.println("alterarUsuario");
        Usuario usu = null;
        ControlerUsuario instance = new ControlerUsuario();
        Usuario expResult = null;
        Usuario result = instance.alterarUsuario(usu);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listarUsuario method, of class ControlerUsuario.
  
    @Test
    public void testListarUsuario() throws Exception {
        System.out.println("listarUsuario");
        Usuario usu = null;
        ControlerUsuario instance = new ControlerUsuario();
        List<Usuario> expResult = null;
        List<Usuario> result = instance.listarUsuario(usu);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


     * Test of listarTodosUsuario method, of class ControlerUsuario.

    @Test
    public void testListarTodosUsuario() throws Exception {
        System.out.println("listarTodosUsuario");
        ControlerUsuario instance = new ControlerUsuario();
        List<Usuario> expResult = null;
        List<Usuario> result = instance.listarTodosUsuario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
     */
    
}
