/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redhat.nitrate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import redstone.xmlrpc.XmlRpcFault;

/**
 *
 * @author asaleh
 */
public class TcmsConnectionTest {

    public TcmsConnectionTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    /**
     * Test of Auth_login method, of class TcmsConnection.
     */
    @Test
    public void testConnect() throws MalformedURLException, IOException {
             TcmsConnection connection = new TcmsConnection("https://tcms.engineering.redhat.com/xmlrpc");
              connection.setUsernameAndPassword(PrivatePassword.name, PrivatePassword.password);
              assertTrue(connection.testTcmsConnection());
    }
    
    /**
     * Test of Auth_login method, of class TcmsConnection.
     */
    @Test
    public void testLogin() throws MalformedURLException {
        try {
            TcmsConnection connection = new TcmsConnection("https://tcms.engineering.redhat.com/xmlrpc/");
            connection.setUsernameAndPassword(PrivatePassword.name, PrivatePassword.password);
            Auth.login_krbv login = new Auth.login_krbv();
            String session = login.invoke(connection);
            assertTrue(session.length() > 0);
            connection.setSession(session);
            
            
            
            connection.invoke(new Auth.logout());
        } catch (XmlRpcFault ex) {
            Logger.getLogger(TcmsConnectionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
