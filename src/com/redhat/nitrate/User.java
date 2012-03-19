/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redhat.nitrate;

/**
 *
 * @author asaleh
 */
public class User {

    public static class get extends TcmsArrayCommand {

        @RequiredField
        public Integer run_id;
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
