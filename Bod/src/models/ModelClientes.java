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
public class ModelClientes {
    private Connection sql_connection;
    private Statement sql_st;
    private PreparedStatement sql_ps;
    private ResultSet sql_rs;
    private String sql;
    private String idCliente;
    private String nombreCliente;
    private String estado;
    private String ciudad;
    private String telefono;
    private String whatsapp;

    public TableModel getModelo() {
        return modelo;
    }
    private TableModel modelo;
    
    private void Connect(){
        try{
            sql_connection = DriverManager.getConnection("jdbc:mysql://localhost/Bodega","root","1234"); // En la URL tenías escrito <<bodega>> en lugar de <<Bodega>>
            sql_st = sql_connection.createStatement();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 101: No hay conexión con la base de datos: " + e);
        }
    }
    public void ConsultarClientes(){
        try{
            Connect();
            sql = "SELECT * FROM Cliente";
            sql_rs = sql_st.executeQuery(sql);
            sql_rs.first();
            //sql_connection.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 102: Consulta tabla Personas: " + e);
        }
    }
    public void AsignarCliente(){
        try{
            idCliente = sql_rs.getString("ClienteID");
            nombreCliente = sql_rs.getString("Nombre_Cliente");
            ciudad = sql_rs.getString("Ciudad");
            estado = sql_rs.getString("Estado");
            telefono = sql_rs.getString("Telefono");
            whatsapp = sql_rs.getString("Whatsapp");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 103: Asignado de valores del cliente: " + e);
        }
    }
    
    public void InsertarCliente(){
        try{
            Connect();
            sql = "Insert into Cliente (ClienteID, Nombre_Cliente, Ciudad, Estado, Telefono, Whatsapp)Values (?,?,?,?,?,?);";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_ps.setString(1, idCliente);
            sql_ps.setString(2, nombreCliente);
            sql_ps.setString(3, ciudad);
            sql_ps.setString(4, estado);
            sql_ps.setString(5, telefono);
            sql_ps.setString(6, whatsapp);
            sql_ps.executeUpdate();
            //sql_connection.close();
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Error 104: Insertando nuevo cliente: " + e);
        }
    }
    public void ModificarCliente(){
        try{
            Connect();
            sql = "Update Cliente Set Nombre_Cliente = (?), Ciudad = (?), Estado = (?), Telefono = (?), Whatsapp = (?) Where ClienteID = (?);";
            sql_ps = sql_connection.prepareStatement(sql);
           sql_ps.setString(1, nombreCliente);
           sql_ps.setString(2, ciudad);
           sql_ps.setString(3, estado);
           sql_ps.setString(4, telefono);
           sql_ps.setString(5, whatsapp);
           sql_ps.setString(6, idCliente);
           sql_ps.executeUpdate();
           //sql_connection.close();
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Error 105: Modificar Cliente: " + e);
        }
    }

    public void EliminarCliente(){
        try{
            Connect();
            sql = "DELETE FROM Cliente Where ClienteID = ?;";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_ps.setString(1, idCliente);
            sql_ps.executeUpdate();
            //sql_connection.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 106: Eliminar Cliente: " + e);
        }
    }
    
    public void MoverPrimero(){
        try{
            if (sql_rs.isFirst() == false) {
                sql_rs.first();
                AsignarCliente();
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 201: Mover al primer registro: " + e);
        }
    }
    
    public void MoverAnterior(){
        try {
            if (sql_rs.isFirst() == false) {
                sql_rs.previous();
                AsignarCliente();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 202: Mover al primer registro: " + e);
        }
    }
    
    public void MoverSiguiente(){
        try {
            if (sql_rs.isLast() == false) {
                sql_rs.next();
                AsignarCliente();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 203: Mover al primer registro: " + e);
        }
    }
    
    public void MoverUltimo(){
        try {
            if (sql_rs.isLast() == false) {
                sql_rs.last();
                AsignarCliente();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 204: Mover al primer registro: " + e);
        }
    }
    public void ConsultaTabla(){
        try{
            sql =  "Select * from Cliente";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_rs = sql_ps.executeQuery();
            modelo = DbUtils.resultSetToTableModel(sql_rs);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 301: Error al consultar Cliente: " + e);
        }
    }
    public void BuscarCliente(String busca){
        try{
            sql = "Select * from Cliente Where Nombre_Cliente Like ? or Ciudad Like ? or Estado Like ? or ClienteID Like ?";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_ps.setString(1, busca+"%");
            sql_ps.setString(2, busca+"%");
            sql_ps.setString(3, busca+"%");
            sql_ps.setString(4, busca+"%");
            sql_rs = sql_ps.executeQuery();
            modelo = DbUtils.resultSetToTableModel(sql_rs);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 401: Error al buscar Cliente: " + e);
        }
    }
    
    public String getIdCliente() {
        return idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getEstado() {
        return estado;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }
}
