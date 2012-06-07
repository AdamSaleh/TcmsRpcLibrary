/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.redhat.nitrate;

/**
 * This class will store access credentials and ensures they won`t be serialized.
 * 
 * @author jrusnack
 */
public class TcmsAccessCredentials {
    
    private transient String username;
    private transient String password;
    
    public TcmsAccessCredentials(){
        this.username = null;
        this.password = null;
    }
    
    public String getUsername(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
            
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void clear(){
        this.username = null;
        this.password = null;
    }
    
    public boolean isEmpty(){
        return username == null || username.isEmpty() || password == null || password.isEmpty();
    }
}
