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
public class ModelEmpleados {
    private Connection sql_connection;
    private Statement sql_st;
    private PreparedStatement sql_ps;
    private ResultSet sql_rs;
    private String sql;
    private ModelPrincipal modelPrincipal;
    private String idEmpleado;
    private String nombreEmpleado;
    private String colonia;
    private String calle;
    private String telefono;

    public TableModel getModelo() {
        return modelo;
    }
    private TableModel modelo;
    
    private void Connect(){
        try{
            sql_connection = DriverManager.getConnection("jdbc:mysql://localhost/Bodega","root","");
            sql_st = sql_connection.createStatement();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 107: No hay conexión con la base de datos: " + e);
        }
    }
    
    public void ConsultarEmpleado(){
        try{
            Connect();
            sql = "SELECT * FROM Empleado ORDER BY EmpleadoID ASC";
            sql_rs = sql_st.executeQuery(sql);
            sql_rs.first();
            //sql_connection.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 108: Consulta tabla Empleado: " + e);
        }
    }
    public void AsignarEmpleado(){
        try{
            idEmpleado = sql_rs.getString("EmpleadoID");
            nombreEmpleado = sql_rs.getString("Nombre_Empleado");
            colonia = sql_rs.getString("Colonia");
            calle = sql_rs.getString("Calle");
            telefono = sql_rs.getString("Telefono");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 109: Asignado de valores del empleado: " + e);
        }
    }
    public void InsertarEmpleado(){
        try{
            Connect();
            sql = "Insert into Empleado (EmpleadoID, Nombre_Empleado, Colonia, Calle, Telefono)Values (?,?,?,?,?);";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_ps.setString(1, idEmpleado);
            sql_ps.setString(2, nombreEmpleado);
            sql_ps.setString(3, colonia);
            sql_ps.setString(4, calle);
            sql_ps.setString(5, telefono);
            sql_ps.executeUpdate();
            //sql_connection.close();
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Error 110: Insertando nuevo cliente: " + e);
        }
    }
    public void ModificarEmpleado(){
        try{
            Connect();
            sql = "Update Empleado Set Nombre_Empleado = (?), Colonia = (?), Calle = (?), Telefono =(?) Where EmpleadoID = (?);";
            sql_ps = sql_connection.prepareStatement(sql);
           sql_ps.setString(1, nombreEmpleado);
           sql_ps.setString(2, colonia);
           sql_ps.setString(3, calle);
           sql_ps.setString(4, telefono);
           sql_ps.setString(5, idEmpleado);
           sql_ps.executeUpdate();
           //sql_connection.close();
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Error 111: Modificar Empleado: " + e);
        }
    }

    public void EliminarEmpleado(){
        try{
            Connect();
            sql = "DELETE FROM Empleado Where EmpleadoID = ?;";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_ps.setString(1,idEmpleado);
            sql_ps.executeUpdate();
            //sql_connection.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 112: Eliminar Empleado: " + e);
        }
    }
    
    public void MoverPrimero(){
        try{
            if (sql_rs.isFirst() == false) {
                sql_rs.first();
                AsignarEmpleado();
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 205: Mover al primer registro: " + e);
        }
    }
    
    public void MoverAnterior(){
        try {
            if (sql_rs.isFirst() == false) {
                sql_rs.previous();
                AsignarEmpleado();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 206: Mover al primer registro: " + e);
        }
    }
    
    public void MoverSiguiente(){
        try {
            if (sql_rs.isLast() == false) {
                sql_rs.next();
                AsignarEmpleado();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 207: Mover al primer registro: " + e);
        }
    }
    
    public void MoverUltimo(){
        try {
            if (sql_rs.isLast() == false) {
                sql_rs.last();
                AsignarEmpleado();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 208: Mover al primer registro: " + e);
        }
    }
    
    public void ConsultaTabla(){
        try{
            sql =  "Select * from Empleado";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_rs = sql_ps.executeQuery();
            modelo = DbUtils.resultSetToTableModel(sql_rs);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 302: Error al consultar Empleado: " + e);
        }
    }
    public void BuscarEmpleado(String busca){
        try{
            sql = "Select * from Empleado Where Nombre_Empleado Like = ? or Colonia Like = ? or Calle Like = ? or EmpleadoID Like ?";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_ps.setString(1, busca+"%");
            sql_ps.setString(2, busca+"%");
            sql_ps.setString(3, busca+"%");
            sql_ps.setString(4, busca+"%");
            sql_rs = sql_ps.executeQuery();
            modelo = DbUtils.resultSetToTableModel(sql_rs);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 402: Error al buscar Empleado: " + e);
        }
    }
    
    public String getIdEmpleado() {
        return idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
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

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
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
}

