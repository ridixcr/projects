
package org.edessco.sva.test;

import org.edessco.sva.util.Encrypt;

public class Encriptar {

    public static void main(String[] args) {
        String contraseña = "admin";
        System.out.println("Contraseña encriptada : "+Encrypt.sha512(contraseña));
        
    }
    
}
