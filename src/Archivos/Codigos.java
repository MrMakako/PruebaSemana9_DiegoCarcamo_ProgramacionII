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
public class Codigos extends Bin{
    
    
    int pos=0;

    public Codigos() throws FileNotFoundException {
        
        
        
        Dir= new RandomAccessFile(new File("Archivos del programa/Codigos.itn"),"rw");
        
        
        try {
            Dir.seek(0);
            Dir.writeInt(1);
            Dir.writeInt(1);
        } catch (IOException ex) {
            Logger.getLogger(Codigos.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        
    }
    
    
    
    public int getCodigo(long offSet){
        int code;
        try {
           
            
            if(offSet==0 && offSet==4){
            
                Dir.seek(offSet);
                
                code=Dir.readInt();
               
                Dir.seek(offSet);
                Dir.write(code+1);
                
                
                
                return code;
                
                
                
            
            }
            
           
            
     
            
        } catch (IOException ex) {
            Logger.getLogger(Codigos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return -1;
    
    
    
    
        
    
    }
    
    
    
    
    
   
}
