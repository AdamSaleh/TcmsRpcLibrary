/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.redhat.nitrate;

import redstone.xmlrpc.XmlRpcArray;

/**
 *
 * @author asaleh
 */
public class Env {
    
    public static class filter_groups extends TcmsHashCommand{
        @RequiredField
        public String name;
     };
     public static class get_properties extends TcmsArrayCommand{
        @RequiredField
        public Integer env_group_id;
        @RequiredField
        public Boolean is_active  ;
     };
     public static class get_values extends TcmsArrayCommand{
        @RequiredField
        public Integer env_property_id;
        @RequiredField
        public Boolean is_active;
     };
     public static class Group{
        public Integer id;
        public String manager;
        public boolean is_active;
        public Integer manager_id;
        public String name;
        public XmlRpcArray property;
        public String modified_by;
        public Integer modified_by_id;
    }
    public static class Property{
        public Integer id;
        public String name;
        public boolean is_active;
    }
    public static class Value{
        public Integer id;
        public String  value;
        public String property;
        public Integer property_id;
        public boolean is_active;
    }
}
