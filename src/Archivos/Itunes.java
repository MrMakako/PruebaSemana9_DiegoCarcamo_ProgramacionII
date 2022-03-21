/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego Carcamo
 */
public class Itunes {

    
    Songs canciones;
    Codigos codes;
    Downloads dw;
    public Itunes() {
        
        try {
            
            File carpeta= new File("Archivos del programa");
            carpeta.mkdirs();
            codes= new Codigos();
            canciones= new Songs();
            dw= new Downloads();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Itunes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
    
    
    
    
    public void AddSong(String nombre, String cantante,double precio){
        
        RandomAccessFile song = canciones.getDir();
        
        try {
            
            
            song.seek(song.length());
            song.writeInt(codes.getCodigo(0));
            
            song.writeUTF(nombre);
            song.writeUTF(cantante);
            song.writeDouble(precio); //8
            
            song.writeInt(0);//4
            song.writeInt(0);//4
            
            
            //Listo;;;
            
            song.seek(0);
            
            
            
            
            
      
            
            
           
            
            
            
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(Itunes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    
    
    
    }
     
    //Codigos
    
    //Downloads/
    
    //songs
    
    
   
    public void reviewSong(int code, int stars){
       RandomAccessFile song = canciones.getDir();

        
        if(stars<0 ||stars>5){
           
            throw new IllegalArgumentException();
            
        
            
            
        }else{
            
            
           try {
               song.seek(canciones.FindSong(code));
               
               
             
               
               song.readUTF();
               song.readUTF();
               song.skipBytes(8);
               
               long pos=song.getFilePointer();
               int SongStars =song.readInt();
               int reviews= song.readInt();
               
               song.seek(pos);
               song.writeInt(SongStars+stars);
               song.writeInt(reviews+1);
               
               song.seek(0);
               
               
               
               
           } catch (IOException ex) {
               Logger.getLogger(Itunes.class.getName()).log(Level.SEVERE, null, ex);
           }
        
        
            
        
        
        
        
        }
        
    
    
    
    
    
    
    }
    
    
    public void DownloadSong(String nombreClinte,int code){
        RandomAccessFile download = dw.getDir();
        
        if(canciones.FindSong(code)>=0){
            
            try {
                download.seek(download.length());
                
                download.writeInt(codes.getCodigo(4));
                
                
                download.writeInt(code);
                
                download.writeUTF(nombreClinte);
                download.writeDouble(canciones.getPrecio(code));
                
            } catch (IOException ex) {
                Logger.getLogger(Itunes.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
        
        
        
        }
    
        
        
        /*   int codigo;
    Calendar fecha;
    int codeCancion;
    String nombreUser;//El usuairo que la descarga
    double precio;
    */
        
    
    
    
    }
    
    
    public void songs(String txt){
    
        File  Arhcivo = new File(txt);
        
        
        Arhcivo.mkdirs();
        
        
        
        if(Arhcivo.isFile()){
            try {
                RandomAccessFile song = canciones.getDir();
                FileWriter writer= new FileWriter(Arhcivo,true);
                
                String Fila= "";
                while(song.getFilePointer()<song.length()){
                     
                    
                    Fila=+song.readInt()+"";
                    
                    Fila+="-"+song.readUTF();
                    Fila+="-"+song.readUTF();
                    
                    Fila+="-"+song.readDouble();
                    Fila+="-"+song.readInt();
                    
                    Fila+="\n";
                    
                     
                
                
                }
                writer.write(Fila);
               
                
                
                
                 
                
                
                
            } catch (IOException ex) {
                Logger.getLogger(Itunes.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        
        
        
        }
        
        
        
        
        
        
       
    
    
    
    }
    
    
    
    
    
    
}
