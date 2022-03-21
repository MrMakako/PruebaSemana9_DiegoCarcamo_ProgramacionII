/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Calendar;

/**
 *
 * @author Diego Carcamo
 */
public class Downloads extends Bin  {
    
    
    int codigo;
    Calendar fecha;
    int codeCancion;
    String nombreUser;//El usuairo que la descarga
    double precio;
    

    public Downloads() throws FileNotFoundException {
        
     
        Dir= new RandomAccessFile(new File("Archivos del programa/Downloads.itn"),"rw");
    
    
    }
    
    
    

    
    
    
 
    
    
    
    
    
    
    
}
