/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.redhat.nitrate;

/**
 *
 * @author asaleh
 */
public class Build {
    
    public String milestone;
    public String product;
    public Integer product_id;
    public Boolean is_active;
    public String description;
    public String name;
    public Integer build_id;
    
    public static class check_build extends TcmsArrayCommand{
        @RequiredField
        public String name;
        @RequiredField
        public Integer productid;
    }
    public static class create extends TcmsHashCommand{
        @RequiredField
        public Integer product;
        @RequiredField
        public String  name;
        public String  description;
        public Boolean is_active;
    }
    /*public static class filter extends TcmsCommand{
        TOO COMPLICATED
    }*/
    public static class get extends TcmsArrayCommand{
        @RequiredField
        public Integer id;
    };
    public static class get_caseruns extends Build.get{}
    public static class get_runs extends Build.get{}
        public static class update extends TcmsArrayCommand{
         @RequiredField
         public Integer id;
         public update.Values values=new Values();
         public static class Values extends TcmsHashCommand{
            public Integer product;
            public String  name;
            public String  description;
            public Boolean is_active;
         }
    }
}
