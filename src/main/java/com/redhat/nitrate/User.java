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
public class User {
         public Integer id;
         public XmlRpcArray user_permissions;
         public XmlRpcArray groups;
         public String first_name;
         public String username;
         public String last_name;
         public String email;
         public String date_joined;
         public Boolean is_staff;
         public Boolean is_active;
         public Boolean is_superuser;
         public String last_login;
         

    public static class get extends TcmsArrayCommand {

        @RequiredField
        public Integer id;
    }

    public static class filter extends TcmsHashCommand {
        public String username__startswith;
    }
    public static class get_me extends TcmsArrayCommand {
    }

    public static class update extends TcmsArrayCommand {

        public update.Values values = new Values();

        public static class Values extends TcmsHashCommand {

            public String first_name;
            public String last_name;
            public String email;
            public String password;
            public String old_password;
        }
        public Integer xid;
    }
}
