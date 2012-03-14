/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redhat.nitrate;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import redstone.xmlrpc.XmlRpcClient;
import redstone.xmlrpc.XmlRpcFault;
/**
 *
 * @author asaleh
 */
public class TcmsConnection {
    private XmlRpcClient client;
    private String session;
    public TcmsConnection(String server_url) throws MalformedURLException {
          client = new XmlRpcClient(server_url,false);     
    }

    public void setSession(String session) {
        client.setRequestProperty("Cookie", "sessionid=".concat(session));
        this.session = session;
    }
    
    public Object invoke(TcmsCommand cmd) throws XmlRpcFault{
        Hashtable<String,Object> data =new Hashtable<String,Object>();
        
        Field[] fields =  cmd.getClass().getFields();

        if(fields.length==0){
            Object o= client.invoke(cmd.name(), new ArrayList());
            return o;
        }

        if(fields.length==1){
            try {
                ArrayList l = new ArrayList();
                l.add(fields[0].get(cmd));
                Object o = client.invoke(cmd.name(), l);
                return o;
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(TcmsConnection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(TcmsConnection.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        for (Field field : fields) {
            try {
                String name = field.getName();
                Object value = field.get(cmd);
                if(value!=null){
                 data.put(name, value);
                }
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(TcmsConnection.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(TcmsConnection.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        Vector params = new Vector();
        params.add(data);
        Object o= client.invoke(cmd.name(), params);
        return o;
    }
}
