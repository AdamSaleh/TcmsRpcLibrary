/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.redhat.nitrate;

import com.redhat.nitrate.command.Auth;
import java.util.Hashtable;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author asaleh
 */
public class AuthTest {

    public AuthTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testLogin() throws IllegalAccessException {
        Auth.login login = new Auth.login();
        login.username ="user";
        login.password = "nbusr123";

        List<Object> l = TcmsConnection.commandToParams(login);
        assertEquals(1, l.size());
        Hashtable<String,Object> table = (Hashtable<String,Object>) l.get(0);
        assertEquals(2,table.size());

        assertEquals("user",table.get("username"));
        assertEquals("nbusr123",table.get("password"));
 
    }
    @Test
    public void testLogout() throws IllegalAccessException {
        Auth.logout auth = new Auth.logout ();
        
        List<Object> l = TcmsConnection.commandToParams(auth);
        assertEquals(0, l.size());
        
    }

}