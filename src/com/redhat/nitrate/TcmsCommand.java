/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.redhat.nitrate;

import java.util.Collections;
import java.util.Vector;
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
    

}
