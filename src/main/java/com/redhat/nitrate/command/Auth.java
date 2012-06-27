
package com.redhat.nitrate.command;

import com.redhat.nitrate.*;


/**
 *
 * @author asaleh
 */
public class Auth {

    public static class login extends TcmsHashCommand {

        @RequiredField
        public String username;
        @RequiredField
        public String password;

        public login() {
        }

        public login(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override
        public String invoke(TcmsConnection c) throws TcmsException {
            return (String) c.invoke(this);
        }
    }

    public static class login_krbv extends TcmsArrayCommand {

        @Override
        public String invoke(TcmsConnection c) throws TcmsException  {
            return (String) c.invoke(this);
        }
    }

    public static class logout extends TcmsArrayCommand {
    }

    public static class get extends TcmsArrayCommand {

        @RequiredField
        public Integer id;
    };
}
