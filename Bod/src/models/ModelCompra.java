/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.Date;
import models.ModelPrincipal;

/**
 *
 * @author ninte
 */
public class ModelCompra{
    private Connection sql_connection;
    private Statement sql_st;
    private PreparedStatement sql_ps;
    private ResultSet sql_rs;
    private String sql;
    
    private List listaidProveedor = new List();
    private String idproveedor;
    private java.sql.Date fecha_compra;
    
    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public void setIdproveedor(int posicion) {
        idproveedor = "" + listaidProveedor.getItem(posicion);
    }
    
    private void Connect(){
        try{
            sql_connection = DriverManager.getConnection("jdbc:mysql://localhost/Bodega","root","");
            sql_st = sql_connection.createStatement();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 125: No hay conexión con la base de datos: " + e);
        }
    }
    
    public void LlenarCombo(javax.swing.JComboBox jcmb_proveedor){
        try{
        Connect();
        sql = "Select ProveedoresID, Nombre_Proveedor from Proveedores Order by ProveedoresID ASC";
        sql_rs = sql_st.executeQuery(sql);
        listaidProveedor.removeAll();
        jcmb_proveedor.removeAllItems();
        while(sql_rs.next()){
            listaidProveedor.add(sql_rs.getString("ProveedoresID"));
            jcmb_proveedor.addItem(sql_rs.getString("Nombre_Proveedor"));
        }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 701: No se ha llenado el combo: " + e);
        }
    }
    
    public void InsertarCompra(){
        try{
            sql = "Insert into Compra(ProveedoresID, Fecha_Compra) Values(?, ?);";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_ps.setString(1, idproveedor);
            sql_ps.setDate(2, fecha_compra);
            sql_ps.executeUpdate();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 720: No se ha llenado el combo: " + e);
        }
    }
}
