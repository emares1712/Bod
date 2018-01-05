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
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import java.sql.Date;
import models.ModelPrincipal;

/**
 *
 * @author ninte
 */
public class ModelCompra{
    private ModelPrincipal mPrincipal;
    private Connection sql_connection;
    private Statement sql_st;
    private PreparedStatement sql_ps;
    private ResultSet sql_rs;
    private String sql;
    private List listaidProveedor = new List();
    private String idproveedor;
    private java.sql.Date fecha_compra;

    public ModelCompra(ModelPrincipal mPrincipal){
        this.mPrincipal = mPrincipal;
    }
    public Date getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
        mPrincipal.setFecha(fecha_compra);
        System.out.println(mPrincipal.getFecha());
    }

    public String getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int posicion) {
        idproveedor = "" + listaidProveedor.getItem(posicion);
        mPrincipal.setTexto(idproveedor);
        System.out.println(mPrincipal.getTexto());

    }
    
    public TableModel getModelo() {
        return modelo;
    }
    private TableModel modelo;
    
    private void Connect(){
        try{
            sql_connection = DriverManager.getConnection("jdbc:mysql://localhost/Bodega","root","1234");
            sql_st = sql_connection.createStatement();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 125: No hay conexión con la base de datos: " + e);
        }
    }
    public void llenarcombo(javax.swing.JComboBox jcmb_proveedor){
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
}
