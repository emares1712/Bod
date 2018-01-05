/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ninte
 */
public class ModelProveedores {
    private Connection sql_connection;
    private Statement sql_st;
    private PreparedStatement sql_ps;
    private ResultSet sql_rs;
    private String sql;
    private ModelPrincipal modelPrincipal;
    private String idProveedor;
    private String nombreProveedor;
    private String ciudad;
    private String colonia;
    private String calle;
    private String telefono;
    private String whatsapp;
    private TableModel modelo;
    
    public TableModel getModelo(){
        return modelo;
    }
    
    private void Connect(){
        try{
            sql_connection = DriverManager.getConnection("jdbc:mysql://localhost/Bodega","root","1234");
            sql_st = sql_connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 113: No hay conexión con la base de datos: " + e);
        }
    }
    public void ConsultarProveedor(){
        try{
            Connect();
            sql = "SELECT * FROM Proveedores ORDER BY ProveedoresID ASC";
            sql_rs = sql_st.executeQuery(sql);
            sql_rs.first();
            //sql_connection.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 114: Consulta tabla Proveedor: " + e);
        }
    }
    public void AsignarProveedor(){
        try{
            idProveedor = sql_rs.getString("ProveedoresID");
            nombreProveedor = sql_rs.getString("Nombre_Proveedor");
            ciudad = sql_rs.getString("Ciudad");
            colonia = sql_rs.getString("Colonia");
            calle = sql_rs.getString("Calle");
            telefono = sql_rs.getString("Telefono");
            whatsapp = sql_rs.getString("Whatsapp");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 115: Asignado de valores del Proveedor: " + e);
        }
    }
    public void InsertarProveedor(){
        try{
            Connect();
            sql = "Insert into Proveedores (ProveedoresID, Nombre_Proveedor, Ciudad, Colonia, Calle, Telefono, Whatsapp)Values (?,?,?,?,?,?,?);";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_ps.setString(1, idProveedor);
            sql_ps.setString(2, nombreProveedor);
            sql_ps.setString(3, ciudad);
            sql_ps.setString(4, colonia);
            sql_ps.setString(5, calle);
            sql_ps.setString(6, telefono);
            sql_ps.setString(7, whatsapp);
            sql_ps.executeUpdate();
           // sql_connection.close();
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Error 116: Insertando nuevo proveedor: " + e);
        }
    }
    public void ModificarProveedor(){
        try{
            Connect();
           sql = "Update Proveedores Set Nombre_Proveedor = (?), Ciudad = (?), Colonia = (?), Calle = (?), Telefono = (?), Whatsapp = (?) Where ProveedoresID = (?);";
           sql_ps = sql_connection.prepareStatement(sql);
           sql_ps.setString(1, nombreProveedor);
           sql_ps.setString(2, ciudad);
           sql_ps.setString(3, colonia);
           sql_ps.setString(4, calle);
           sql_ps.setString(5, telefono);
           sql_ps.setString(6, whatsapp);
           sql_ps.setString(7, idProveedor);
           sql_ps.executeUpdate();
           //sql_connection.close();
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Error 117: Modificar proveedor: " + e);
        }
    }

    public void EliminarProveedor(){
        try{
            Connect();
            sql = "DELETE FROM Proveedores Where ProveedoresID = ?;";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_ps.setString(1, idProveedor);
            sql_ps.executeUpdate();
            //sql_connection.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 118: Eliminar Proveedor: " + e);
        }
    }
    public void MoverPrimero(){
        try{
            if (sql_rs.isFirst() == false) {
                sql_rs.first();
                AsignarProveedor();
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 213: Mover al primer registro: " + e);
        }
    }
    
    public void MoverAnterior(){
        try {
            if (sql_rs.isFirst() == false) {
                sql_rs.previous();
                AsignarProveedor();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 214: Mover al primer registro: " + e);
        }
    }
    
    public void MoverSiguiente(){
        try {
            if (sql_rs.isLast() == false) {
                sql_rs.next();
                AsignarProveedor();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 215: al Mover al primer registro: " + e);
        }
    }
    
    public void MoverUltimo(){
        try {
            if (sql_rs.isLast() == false) {
                sql_rs.last();
                AsignarProveedor();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 216: Mover al primer registro: " + e);
        }
    }
    
    public void ConsultaTabla(){
        try{
            sql =  "Select * from Proveedores";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_rs = sql_ps.executeQuery();
            modelo = DbUtils.resultSetToTableModel(sql_rs);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 304: Error al consultar Proveedor: " + e);
        }
    }
    
    public void BuscarProveedor(String busca){
        try{
            sql = "Select * from Proveedores Where Nombre_Proveedor Like ? or Ciudad Like ? or Colonia Like ? or Calle Like ? or ProveedoresID Like ?";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_ps.setString(1, busca+"%");
            sql_ps.setString(2, busca+"%");
            sql_ps.setString(3, busca+"%");
            sql_ps.setString(4, busca+"%");
            sql_ps.setString(5, busca+"%");
            sql_rs = sql_ps.executeQuery();
            modelo = DbUtils.resultSetToTableModel(sql_rs);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 404: Error al buscar Proveedor: " + e);
        }
    }
    
 public String getIdProveedor() {
        return idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getColonia() {
        return colonia;
    }

    public String getCalle() {
        return calle;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }
}
