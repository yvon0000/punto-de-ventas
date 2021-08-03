
package clases;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static Connection conectar(){
        try{
           Connection cn= DriverManager.getConnection("jdbc:mysql://localhost/bd_ds","root",""); 
           return cn;
        }catch(Exception e){
            System.out.println("error en"+e);
        }
        
       return null; 
        
        
    }
}
