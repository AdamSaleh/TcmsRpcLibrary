/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redhat.nitrate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import redstone.xmlrpc.XmlRpcFault;

/**
 *
 * @author asaleh
 */
public abstract class TcmsCommand {

    public String name() {
        String s[] = this.getClass().getCanonicalName().split("\\.");
        int l = s.length;
        String name = s[l - 2] + "." + s[l - 1];
        return name;
    }

    ;
     public Object invoke(TcmsConnection c) throws XmlRpcFault {
        return c.invoke(this);
    }

    public String description() {
        try {
            return TcmsConnection.commandToString(this);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TcmsCommand.class.getName()).log(Level.SEVERE, null, ex);
            return ex.getMessage();
        }
    }

    public Hashtable<String, String> descriptionMap() {
        Hashtable<String, String> out = new Hashtable<String, String>();
        Hashtable<String, Object> map = TcmsConnection.fieldsToHashtable(this);
        for (String k : map.keySet()) {
            out.put(k, map.get(k).toString());
        }
        return out;
    }

    @Override
    public boolean equals(Object obj) {
        int hashcode = TcmsConnection.fieldsToHashtable(obj).hashCode();
        return hashcode == hashCode();
    }

    @Override
    public int hashCode() {
        return TcmsConnection.fieldsToHashtable(this).hashCode();
    }
}
