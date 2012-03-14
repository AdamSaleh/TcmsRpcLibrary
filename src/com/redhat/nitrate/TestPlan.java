/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.redhat.nitrate;

/**
 *
 * @author asaleh
 */
public class TestPlan {
    public static class add_tag extends TcmsCommand{
        @RequiredField
        public Integer[] plan_ids;
        @RequiredField
        public String[]  tags;
    }

    public static class create extends TcmsCommand{
        @RequiredField
        public Integer product;
        @RequiredField
        public String  name;
        @RequiredField
        public Integer type;
        @RequiredField
        public Integer default_product_version;
        @RequiredField
        public String  text;
        public Integer parent;
        public Boolean is_active;
    }
}
