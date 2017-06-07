/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipo;

import java.util.ArrayList;

/**
 *
 * @author axelpc
 */
public class Getset {
    
    private String marca;
    private String modelo;
    private String serial;
    private int id;
    
    
    public Getset(){
         
     }
    
    ArrayList<Getset> listacat=new ArrayList<Getset>();
        
    public Getset(int id){
         
         this.setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Getset> getListacat() {
        return listacat;
    }

    public void setListacat(ArrayList<Getset> listacat) {
        this.listacat = listacat;
    }

    
    
    public void agregardatos(int id){
            Getset obj=new Getset(id);
            listacat.add(obj);
        }
    
}
