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
     public String name(){
            String s[] = this.getClass().getCanonicalName().split("\\.");
            int l = s.length;
            String name = s[l-2]+"."+s[l-1];
            return name;
     };
     public Object invoke(TcmsConnection c) throws XmlRpcFault{
            return c.invoke(this);
     }
    
     public String description(){
        try {
            return TcmsConnection.commandToString(this);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TcmsCommand.class.getName()).log(Level.SEVERE, null, ex);
            return TcmsCommand.class.getName() + ":" + ex.getMessage();
        }
     }
    @Override
    public boolean equals(Object obj) {
        int hashcode =  TcmsConnection.fieldsToHashtable(obj).hashCode();
        return hashcode == hashCode();
    }

    @Override
    public int hashCode() {
       /* Hashtable<String,Object> t = TcmsConnection.fieldsToHashtable(this);
        int sum=0;
        for(String s:t.keySet()){
            sum+=t.get(s).hashCode();
        }*/
        return TcmsConnection.fieldsToHashtable(this).hashCode();
    }
}
