/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/EmptyTestNGTest.java to edit this template
 */
package usuario;

import static org.testng.Assert.*;

/**
 *
 * @author EduardoM
 */
public class UsuarioNGTest {
    
    public UsuarioNGTest() {
    }

    @org.testng.annotations.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.testng.annotations.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.testng.annotations.BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @org.testng.annotations.AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of getId method, of class Usuario.
     */
    @org.testng.annotations.Test
    public void testGetId() {
        System.out.println("getId");
        Usuario instance = new Usuario();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLogin method, of class Usuario.
     */
    @org.testng.annotations.Test
    public void testGetLogin() {
        System.out.println("getLogin");
        Usuario instance = new Usuario();
        String expResult = "";
        String result = instance.getLogin();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getClave method, of class Usuario.
     */
    @org.testng.annotations.Test
    public void testGetClave() {
        System.out.println("getClave");
        Usuario instance = new Usuario();
        String expResult = "";
        String result = instance.getClave();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Usuario.
     */
    @org.testng.annotations.Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Usuario instance = new Usuario();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of canEqual method, of class Usuario.
     */
    @org.testng.annotations.Test
    public void testCanEqual() {
        System.out.println("canEqual");
        Object other = null;
        Usuario instance = new Usuario();
        boolean expResult = false;
        boolean result = instance.canEqual(other);
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Usuario.
     */
    @org.testng.annotations.Test
    public void testHashCode() {
        System.out.println("hashCode");
        Usuario instance = new Usuario();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(result, expResult);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
