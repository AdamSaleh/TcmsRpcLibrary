/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.redhat.nitrate;

import java.net.MalformedURLException;
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
    /*@Test
    public void testLogin() {
        try {
            TcmsConnection nitrate;
            nitrate = new TcmsConnection("http://localhost:8000/xmlrpc/");
            Auth.login login = new Auth.login("asaleh", "*Cygnusolor*");
            String session = (String) nitrate.invoke(login);

            nitrate.setSession(session);
            
           TestPlan.create create = new TestPlan.create();
            create.product = new Integer(1);
            create.name = "Plan8";
            create.type=new Integer(1);
            create.default_product_version =new Integer(1);
            create.text="texting";
            create.is_active = Boolean.TRUE;
            Object o= nitrate.invoke(create);
           
            
            TestPlan.check_plan_type cmd = new TestPlan.check_plan_type();
            cmd.name="Unit";
            Object o= nitrate.invoke(cmd);

            nitrate.invoke(new Auth.logout());
        } catch (XmlRpcFault ex) {
            Logger.getLogger(TcmsConnectionTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(TcmsConnectionTest.class.getName()).log(Level.SEVERE, null, ex);
        }


    }*/

}