/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.redhat.nitrate;

/**
 *
 * @author asaleh
 */
public class Env {
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
        public Boolean is_active  ;
    };
}
