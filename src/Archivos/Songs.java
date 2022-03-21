/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego Carcamo
 */
public class Songs extends Bin{
    
    
    int codigo;
    String nombre;
    String cantante;
    double precio;
    int estrellas=0;
    int cantidadR=0;

    public Songs() throws FileNotFoundException {
        
        Dir= new RandomAccessFile(new File("Archivos del programa/Songs.itn"),"rw");
        
        
        
    }
    
    
    public double getPrecio(int code){
        
        long pos= FindSong(code);
        if(pos>=0){
        
            try {
                Dir.readUTF();
                Dir.readUTF();
                
                double price=Dir.readDouble();
                
                Dir.seek(0);
                return price;
            } catch (IOException ex) {
                Logger.getLogger(Songs.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        
        }
        
        
        return 0;
        
        
        
    }
    
    
    public long FindSong(int code){
    
        try {
            Dir.seek(0);
            
            while(Dir.getFilePointer()<Dir.length()){
                
                
                int SongCode=Dir.readInt();
                long pos= Dir.getFilePointer();
                
                
                Dir.readUTF();
                Dir.readUTF();
                
                Dir.skipBytes(16);
                
                
                
                if(SongCode==code){
                    
                    
                    Dir.seek(pos);
                    return code;
                    
                    
                
                
                    
                
                
                }
                
            
            
            
            }
                    
                    
           } catch (IOException ex) {
               
               System.out.println(ex.getMessage());
        }
        
        
        return -1;
    
    
    }    
    
    
    
    
    
    
    
    
   
    
}
