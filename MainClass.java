/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexion3a18.tests;


import edu.connexion3a18.entities.Vehicule;
import edu.connexion3a18.services.VehiculeCRUD;
import edu.connexion3a18.utils.Myconnection;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 *
 * @author BKHmidi
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
       // Myconnection mc = new  Myconnection();
       BufferedImage defaultImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);

        Vehicule v1= new Vehicule("223TUNIS8515", "Voiture", "KIA", 1, 25, 45000, defaultImage);
        VehiculeCRUD vcd = new VehiculeCRUD();
       vcd.addEntity2(v1);
       System.out.println(vcd.entitiesList());
        
    }
    
    
}
