/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.connexion3a18.services;

import edu.connexion3a18.entities.Vehicule;
import edu.connexion3a18.interfaces.EntityCRUD;
import edu.connexion3a18.utils.Myconnection;
import java.awt.image.BufferedImage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.imageio.ImageIO;

/**
 *
 * @author abdel
 */
public class VehiculeCRUD implements EntityCRUD<Vehicule> {

    public void addEntity2(Vehicule v) throws IOException {
        try {
            String requete = "INSERT INTO VEHICULE (immatriculation,type_du_vehicule,marque,"
                    + "cin_conducteur,etat,kilometrage,imageV) VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement st = new Myconnection().getCnx().prepareStatement(requete);
            st.setString(1, v.getImmatriculation());
            st.setString(2, v.getType_du_vehicule());
            st.setString(3, v.getMarque());
            st.setInt(4, v.getCin_conducteur());
            st.setInt(5, v.getEtat());
            st.setInt(6, v.getKilometrage());
            
            BufferedImage image = v.getImageV();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", baos);
            InputStream is = new ByteArrayInputStream(baos.toByteArray());

            st.setBinaryStream(7, is);
            
            st.executeUpdate();
            System.out.println("Vehicule ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void addEntity(Vehicule v) {
        try {
            String requete = "INSERT INTO VEHICULE (immatriculation, type_du_vehicule, marque, "
                    + "cin_conducteur, etat, kilometrage, imageV) VALUES (?, ?, ?, ?, ?, ?, ?)";
            Statement st = new Myconnection().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Vehicule ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Vehicule> entitiesList() {
        ArrayList<Vehicule> myList = new ArrayList();
        try {
            String requete = "SELECT * FROM VEHICULE";
            Statement st = Myconnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Vehicule v = new Vehicule();
                v.setImmatriculation(rs.getString(1));
                v.setType_du_vehicule(rs.getString(2));
                v.setMarque(rs.getString(3));
                v.setCin_conducteur(rs.getInt(4));
                v.setEtat(rs.getInt(5));
                v.setKilometrage(rs.getInt(6));
                v.setImageV(ImageIO.read(rs.getBinaryStream(7)));
                myList.add(v);
            }

        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;

    }

}
