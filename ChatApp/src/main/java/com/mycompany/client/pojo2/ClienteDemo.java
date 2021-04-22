/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.client.pojo2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sistemas-07
 */
public class ClienteDemo implements Runnable{
    
    private int puerto;
    private String mensaje;
    
    public ClienteDemo(int puerto, String mensaje){
        this.puerto = puerto;
        this.mensaje= mensaje;
    }
    
    
    @Override
    public void run() {
        //Host del servidor 
    final String HOST= "127.0.0.1";
    //Puerto del servidor 
    final int PUERTO = 5000;
    
    DataOutputStream out;
    
    Socket sc;
        try {
            sc = new Socket(HOST, PUERTO);
            
            out = new DataOutputStream(sc.getOutputStream());
            //Envio de un mensaje del cliente
            out.writeUTF("Hola mundo desde el cliente");
            //Recibiendo mensaje del servidor 
            
            System.out.println(mensaje);
            sc.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ClienteDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
    
    
}
