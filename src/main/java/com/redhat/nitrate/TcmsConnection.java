/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redhat.nitrate;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
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
    
    static Hashtable<String,Object> fieldsToHashtable(Object object) throws IllegalAccessException{
         Hashtable<String,Object> data =new Hashtable<String,Object>();
        
        Field[] fields =  object.getClass().getFields();
         for (Field field : fields) {
           String name = getName(field);
           Object value = field.get(object);
           if(value!=null){
               data.put(name, value);
           }
        }
        return data;
    }

    static String getName(Field field){
        String s = field.getName();
        if(s.contains("caseVar")){
            s="case";
        }
        return s;
    }
    static List<Object> fieldsToCollection(Object object) throws IllegalAccessException{
        ArrayList data = new ArrayList();
        
        Field[] fields =  object.getClass().getFields();
         for (Field field : fields) {
           String name = getName(field);
           Object value = field.get(object);
           
           if(TcmsArrayCommand.class.isInstance(value)){
             value= fieldsToCollection(value);
           }else if(TcmsHashCommand.class.isInstance(value)){
             value = fieldsToHashtable(value);
           }

           if(value!=null){
               data.add(value);
           }
        }
        return data;
    }

    public static List commandToParams(TcmsCommand cmd) throws IllegalAccessException{
          Field[] fields = cmd.getClass().getFields();
          
          if(TcmsArrayCommand.class.isInstance(cmd)){
             return fieldsToCollection(cmd);
          }else if(TcmsHashCommand.class.isInstance(cmd)){
             Hashtable<String, Object> data = fieldsToHashtable(cmd);
             Vector params = new Vector();
             params.add(data);
             return params;
          }
          return null;
    }

    public Object invoke(TcmsCommand cmd) throws XmlRpcFault{
        try {
            List params = commandToParams(cmd);
            Object o = client.invoke(cmd.name(), params);
            return o;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TcmsConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
