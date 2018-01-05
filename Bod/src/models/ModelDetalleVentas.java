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
/**
 *
 * @author ninte
 */
public class ModelDetalleVentas {
    private Connection sql_connection;
    private Statement sql_st;
    private PreparedStatement sql_ps;
    private ResultSet sql_rs;
    private String sql;
    private ModelPrincipal modelPrincipal;
    private String ventaid;
    private String compraid;
    private String fecha_venta;
    private String total;

    
    private void Connect(){
        try{
            sql_connection = DriverManager.getConnection("jdbc:mysql://localhost/Bodega","root","1234");
            sql_st = sql_connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 119: No hay conexión con la base de datos: " + e);
        }
    }
    public void ConsultarVenta(){
        try{
            Connect();
            sql = "SELECT * FROM Ventas ORDER BY VentasID ASC";
            sql_rs = sql_st.executeQuery(sql);
            sql_rs.first();
            //sql_connection.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 120: Consulta tabla Productos: " + e);
        }
    }
    public void AsignarVenta(){
        try{
            ventaid = sql_rs.getString("VentsID");
            compraid = sql_rs.getString("CompraID");
            fecha_venta = sql_rs.getString("Fecha_Venta");
            total = sql_rs.getString("Total");

            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 121: Asignado de valores del producto: " + e);
        }
    }
    public void InsertarVenta(){
        try{
            Connect();
            sql = "Insert into Venta(VentaID, ClienteID, Fecha_Venta, Total)Values (?,?,?,?);";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_ps.setString(1, compraid);
            sql_ps.setString(2, fecha_venta);
            sql_ps.setString(3, total);
            sql_ps.executeUpdate();
            //sql_connection.close();
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Error 122: Insertando nueva_venta: " + e);
        }
    }
    public void ModificarVenta(){
        try{
            Connect();
            sql = "Update Productos Set CompraID = (?), Fecha_Venta (?), Total (?) Where VentaID = (?);";
            sql_ps = sql_connection.prepareStatement(sql);
           sql_ps.setString(1, compraid);
           sql_ps.setString(2, fecha_venta);
           sql_ps.setString(3, total);
           sql_ps.setInt(6, Integer.parseInt(ventaid));
           sql_ps.executeUpdate();
           //sql_connection.close();
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Error 123: Modificar venta: " + e);
        }
    }

    public void EliminarVenta(){
        try{
            Connect();
            sql = "DELETE FROM Venta Where ventaID = (?);";
            sql_ps.setInt(1, Integer.parseInt(ventaid));
            sql_ps.executeUpdate();
            //sql_connection.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 124: Eliminar venta: " + e);
        } }
    
    public void MoverPrimero(){
        try{
            if (sql_rs.isFirst() == false) {
                sql_rs.first();
                AsignarVenta();
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 209: Mover a la primer venta " + e);
        }
    }
    
    public void MoverAnterior(){
        try {
            if (sql_rs.isFirst() == false) {
                sql_rs.previous();
                AsignarVenta();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 210: Mover a la primer venta: " + e);
        }
    }
    
    public void MoverSiguiente(){
        try {
            if (sql_rs.isLast() == false) {
                sql_rs.next();
                AsignarVenta();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 211: Mover a la primer venta: " + e);
        }
    }
    
    public void MoverUltimo(){
        try {
            if (sql_rs.isLast() == false) {
                sql_rs.last();
                AsignarVenta();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 212: Mover a la primer venta: " + e);
        }
    }
    public String getVentaid() {
        return ventaid;
    }

    public String getCompraid() {
        return compraid;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public String getTotal() {
        return total;
    }

    public void setVentaid(String ventaid) {
        this.ventaid = ventaid;
    }

    public void setCompraid(String compraid) {
        this.compraid = compraid;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}


