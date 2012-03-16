/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.redhat.nitrate;

import java.util.List;
import java.util.Hashtable;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author asaleh
 */
public class TestPlanTest {

    public TestPlanTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testCreate() throws IllegalAccessException {
        TestPlan.create create = new TestPlan.create();
        create.product = new Integer(1);
        create.name = "Plan8";
        create.type=new Integer(1);
        create.default_product_version =new Integer(1);
        create.text="texting";
        create.is_active = Boolean.TRUE;

        List<Object> l = TcmsConnection.commandToParams(create);
        assertEquals(1, l.size());
        Hashtable<String,Object> table = (Hashtable<String,Object>) l.get(0);
        assertEquals(6,table.size());

        assertEquals(new Integer(1),table.get("product"));
        assertEquals("Plan8",table.get("name"));
        assertEquals(new Integer(1),table.get("default_product_version"));
        assertEquals(new Integer(1),table.get("type"));
        assertEquals("texting",table.get("text"));
        assertEquals(Boolean.TRUE,table.get("is_active"));

    }

    public void testUpdate() throws IllegalAccessException {
        TestPlan.update update = new TestPlan.update();
        update.id = new Integer(8);
        update.values.name = "Plan9";
        update.values.product = new Integer(1);
        update.values.type=new Integer(1);
        update.values.default_product_version =new Integer(1);
        update.values.parent = new Integer(1);
        update.values.is_active = Boolean.TRUE;
        update.values.env_group = new Integer(1);

        List<Object> l = TcmsConnection.commandToParams(update);
        assertEquals(2, l.size());
        assertEquals(8,l.get(0));
        Hashtable<String,Object> table = (Hashtable<String,Object>) l.get(1);
        assertEquals(7,table.size());

        assertEquals(new Integer(1),table.get("product"));
        assertEquals("Plan9",table.get("name"));
        assertEquals(new Integer(1),table.get("default_product_version"));
        assertEquals(new Integer(1),table.get("type"));
        assertEquals(Boolean.TRUE,table.get("is_active"));

    }

    @Test
    public void testGet() throws IllegalAccessException {
        TestPlan.get get = new TestPlan.get();
        get.id=new Integer(15);

        List<Object> l = TcmsConnection.commandToParams(get);
        assertEquals(1, l.size());
        assertEquals(15,l.get(0));
    }
    @Test
    public void testGetText() throws IllegalAccessException {
        TestPlan.get_text get = new TestPlan.get_text();
        get.id=new Integer(15);

        List<Object> l = TcmsConnection.commandToParams(get);
        assertEquals(1, l.size());
        assertEquals(15,l.get(0));
    }

}