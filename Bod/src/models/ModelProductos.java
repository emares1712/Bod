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
public class ModelProductos {
    private Connection sql_connection;
    private Statement sql_st;
    private PreparedStatement sql_ps;
    private ResultSet sql_rs;
    private String sql;
    private ModelPrincipal modelPrincipal;
    private String idProducto;
    private String nombreProducto;
    private String descripcion;
    private String cantidadExistencias;
    private String precioCompra;
    private String precioVenta;
    private TableModel modelo;
    
    public TableModel getModelo(){
        return modelo;
    }
    
    private void Connect(){
        try{
            sql_connection = DriverManager.getConnection("jdbc:mysql://localhost/Bodega","root","1234");
            sql_st = sql_connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 119: No hay conexión con la base de datos: " + e);
        }
    }
    public void ConsultarProducto(){
        try{
            Connect();
            sql = "SELECT * FROM Productos ORDER BY ProductosID ASC";
            sql_rs = sql_st.executeQuery(sql);
            sql_rs.first();
            //sql_connection.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 120: Consulta tabla Productos: " + e);
        }
    }
    public void AsignarProducto(){
        try{
            idProducto = sql_rs.getString("ProductosID");
            nombreProducto = sql_rs.getString("Nombre_Producto");
            descripcion = sql_rs.getString("Descripcion");
            cantidadExistencias = sql_rs.getString("Cantidad_Existente");
            precioCompra = sql_rs.getString("Precio_Compra");
            precioVenta = sql_rs.getString("Precio_Venta");
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 121: Asignado de valores del producto: " + e);
        }
    }
    public void InsertarProducto(){
        try{
            Connect();
            sql = "Insert into Productos (ProductosID, Nombre_Producto, Descripcion, Cantidad_Existente, Precio_compra, Precio_Venta)Values (?,?,?,?,?,?);";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_ps.setString(1, idProducto);
            sql_ps.setString(2, nombreProducto);
            sql_ps.setString(3, descripcion);
            sql_ps.setInt(4, Integer.parseInt(cantidadExistencias));
            sql_ps.setInt(5, Integer.parseInt(precioCompra));
            sql_ps.setInt(6, Integer.parseInt(precioVenta));
            sql_ps.executeUpdate();
            //sql_connection.close();
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Error 122: Insertando nuevo producto: " + e);
        }
    }
    public void ModificarProducto(){
        try{
            Connect();
            sql = "Update Productos Set Nombre_Producto = (?), Descripcion = (?), Cantidad_Existente = (?), Precio_compra = (?), Precio_Venta = (?) Where ProductosID = (?);";
            sql_ps = sql_connection.prepareStatement(sql);
           sql_ps.setString(1, nombreProducto);
           sql_ps.setString(2, descripcion);
           sql_ps.setInt(3, Integer.parseInt(cantidadExistencias));
           sql_ps.setInt(4, Integer.parseInt(precioCompra));
           sql_ps.setInt(5, Integer.parseInt(precioVenta));
           sql_ps.setString(6, idProducto);
           sql_ps.executeUpdate();
           //sql_connection.close();
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Error 123: Modificar producto: " + e);
        }
    }

    public void EliminarProducto(){
        try{
            Connect();
            sql = "DELETE FROM Productos Where ProductosID = ?;";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_ps.setString(1, idProducto);
            sql_ps.executeUpdate();
            //sql_connection.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 124: Eliminar producto: " + e);
        }
    }
    
    public void MoverPrimero(){
        try{
            if (sql_rs.isFirst() == false) {
                sql_rs.first();
                AsignarProducto();
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 209: Mover al primer registro: " + e);
        }
    }
    
    public void MoverAnterior(){
        try {
            if (sql_rs.isFirst() == false) {
                sql_rs.previous();
                AsignarProducto();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 210: Mover al primer registro: " + e);
        }
    }
    
    public void MoverSiguiente(){
        try {
            if (sql_rs.isLast() == false) {
                sql_rs.next();
                AsignarProducto();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 211: Mover al primer registro: " + e);
        }
    }
    
    public void MoverUltimo(){
        try {
            if (sql_rs.isLast() == false) {
                sql_rs.last();
                AsignarProducto();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 212: Mover al primer registro: " + e);
        }
    }
    public void ConsultaTabla(){
        try{
            sql =  "Select * from Productos";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_rs = sql_ps.executeQuery();
            modelo = DbUtils.resultSetToTableModel(sql_rs);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 303: Error al consultar Producto: " + e);
        }
    }
    
    public void BuscarProducto(String busca){
        try{
            sql = "Select * from Productos Where Nombre_Producto Like ? or Descripcion Like ? or ClienteID Like ?";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_ps.setString(1, busca+"%");
            sql_ps.setString(2, busca+"%");
            sql_ps.setString(3, busca+"%");
            sql_rs = sql_ps.executeQuery();
            modelo = DbUtils.resultSetToTableModel(sql_rs);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 403: Error al buscar Producto: " + e);
        }
    }
    
    public String getIdProducto() {
        return idProducto;
    }
    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCantidadExistencias() {
        return cantidadExistencias;
    }

    public String getPrecioCompra() {
        return precioCompra;
    }

    public String getPrecioVenta() {
        return precioVenta;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidadExistencias(String cantidadExistencias) {
        this.cantidadExistencias = cantidadExistencias;
    }

    public void setPrecioCompra(String precioCompra) {
        this.precioCompra = precioCompra;
    }

    public void setPrecioVenta(String precioVenta) {
        this.precioVenta = precioVenta;
    }
}
