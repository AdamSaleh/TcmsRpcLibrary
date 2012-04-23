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
import redstone.xmlrpc.XmlRpcStruct;

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

    /**
     * Test of testTcmsConnection method, of class TcmsConnection.
     */
    @Test
    public void testTestTcmsConnection() throws Exception {
    }

    /**
     * Test of setSession method, of class TcmsConnection.
     */
    @Test
    public void testSetSession() {
    }

    /**
     * Test of setUsernameAndPassword method, of class TcmsConnection.
     */
    @Test
    public void testSetUsernameAndPassword() {
    }

    /**
     * Test of hashtableToFields method, of class TcmsConnection.
     */
    @Test
    public void testHashtableToFields() throws Exception {
    }

    /**
     * Test of rpcStructToFields method, of class TcmsConnection.
     */
    @Test
    public void testRpcStructToFields() throws MalformedURLException  {
        try{
            TcmsConnection connection = new TcmsConnection("https://tcms.engineering.redhat.com/xmlrpc/");
            connection.setUsernameAndPassword(PrivatePassword.name, PrivatePassword.password);
            Auth.login_krbv login = new Auth.login_krbv();
            String session = login.invoke(connection);
            assertTrue(session.length() > 0);
            connection.setSession(session);
        
            // test getting TestPlan
            testRpcStructToFieldsTestPlan(connection);
        
            // test getting Build
            testRpcStructToFieldsBuild(connection);
            
            // test getting Product
            testRpcStructToFieldsProduct(connection);
            
            // test getting TestRun
            testRpcStructToFieldsTestRun(connection);
            
            connection.invoke(new Auth.logout());
        } catch (XmlRpcFault ex) {
            Logger.getLogger(TcmsConnectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
                Logger.getLogger(TcmsConnectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TcmsConnectionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void testRpcStructToFieldsTestPlan(TcmsConnection connection) 
            throws  XmlRpcFault, IllegalAccessException, InstantiationException{
        
        TestPlan planResult;
        TestPlan.get get = new TestPlan.get();
        // Get plan JenkinsPluginTest
        get.id = 5866;
        Object o = connection.invoke(get);
        if (o instanceof XmlRpcStruct) {
            planResult = TcmsConnection.rpcStructToFields((XmlRpcStruct) o, TestPlan.class);
        }
        
    }
    
    private void testRpcStructToFieldsBuild(TcmsConnection connection) throws IllegalAccessException, InstantiationException, XmlRpcFault{
       
        Build buildResult;
        Build.check_build get = new Build.check_build();
        get.name = "TCMS-3.0.3-1.svn2841";
        get.productid = 243;
        Object o = connection.invoke(get);
        if (o instanceof XmlRpcStruct) {
            buildResult = TcmsConnection.rpcStructToFields((XmlRpcStruct) o, Build.class);
        }                     
    }
    
    private void testRpcStructToFieldsProduct(TcmsConnection connection) throws IllegalAccessException, InstantiationException, XmlRpcFault{
        
        Product p;
        Product.get get = new Product.get();
        get.id = 243;
        Object o = connection.invoke(get);
        if (o instanceof XmlRpcStruct) {
            p = TcmsConnection.rpcStructToFields((XmlRpcStruct) o, Product.class);
        }                     
    }
    
    private void testRpcStructToFieldsTestRun(TcmsConnection connection) throws IllegalAccessException, InstantiationException, XmlRpcFault{
        
        TestRun t;
        TestRun.get get = new TestRun.get();
        get.run_id = 36898;
        Object o = connection.invoke(get);
        if (o instanceof XmlRpcStruct) {
            t = TcmsConnection.rpcStructToFields((XmlRpcStruct) o, TestRun.class);
            int a = 12;
        }                     
    }
    
    

    /**
     * Test of fieldsToHashtable method, of class TcmsConnection.
     */
    @Test
    public void testFieldsToHashtable() throws Exception {
    }

    /**
     * Test of commandToString method, of class TcmsConnection.
     */
    @Test
    public void testCommandToString() throws Exception {
    }

    /**
     * Test of getName method, of class TcmsConnection.
     */
    @Test
    public void testGetName() {
    }

    /**
     * Test of fieldsToCollection method, of class TcmsConnection.
     */
    @Test
    public void testFieldsToCollection() throws Exception {
    }

    /**
     * Test of commandToParams method, of class TcmsConnection.
     */
    @Test
    public void testCommandToParams() throws Exception {
    }

    /**
     * Test of invoke method, of class TcmsConnection.
     */
    @Test
    public void testInvoke() throws Exception {
    }

}
