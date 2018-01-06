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

/**
 *
 * @author ninte
 */
public class ModelDetalleCompra {

    private ModelPrincipal mPrincipal;
    private Connection sql_connection;
    private Statement sql_st;
    private PreparedStatement sql_ps;
    private ResultSet sql_rs;
    private String sql;

    private String dc_id;
    private String compraID;
    private String productosid;
    private String cantidad_existente;
    private String cantidad_compra;
    private String precio_unitario;
    private String total_fila;
    private String total_compra;
    private List listaProductos = new List();
    private List listaidDetalle = new List();
    private TableModel modelo;

    public ModelDetalleCompra(ModelPrincipal mPrincipal) {
        this.mPrincipal = mPrincipal;
    }

    private void Connect() {
        try {
            sql_connection = DriverManager.getConnection("jdbc:mysql://localhost/Bodega", "root", "");
            sql_st = sql_connection.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 101: No hay conexión con la base de datos: " + e);
        }
    }
    
    public void AsignarIDCompra(){
        try{
            Connect();
            sql = "Select CompraID from Compra ORDER BY CompraID ASC;";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_rs = sql_ps.executeQuery();
            sql_rs.last();
            compraID = sql_rs.getString("CompraID");
            sql_connection.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 110: Insertando nuevo Detalle_venta: " + e);
        }
    }
    
    public boolean VerificarExistencia(){
        boolean verificado = false;
        try{
            Connect();
            sql = "Select Cantidad_Existente from Productos Where ProductosID = ?;";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_ps.setString(1, productosid);
            sql_rs = sql_ps.executeQuery();
            sql_rs.first();
            if(Integer.parseInt(cantidad_compra) > sql_rs.getInt("Cantidad_Existente")){
                JOptionPane.showMessageDialog(null, "Insuficientes productos para compra");
                verificado = false;
            }
            else{
                verificado = true;
            }
            sql_connection.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error 110: Insertando nuevo Detalle_venta: " + e);
        }
        
        return verificado;  
    }
    
    public void DisminuirExistencias(){
        try{
            Connect();
            sql = "Update Productos Set Cantidad_Existente = ? Where ProductosID = ?";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_ps.setInt(1, Integer.parseInt(cantidad_existente) - Integer.parseInt(cantidad_compra));
            sql_ps.setString(2, productosid);
            sql_ps.executeUpdate();
            sql_connection.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error 120: Actualizando Existencia de Productos: " + e);
        }
    }
    
    public void InsertarDetalle_Compra() {
        try {
            if(VerificarExistencia()){
                Connect();
                total_fila = "" + (Double.parseDouble(precio_unitario) * Double.parseDouble(cantidad_compra));
                sql = "Insert into Detalle_Compra (CompraID, ProductosID, Cantidad_Productos , Precio_Unitario, Total)Values (?,?,?,?,?);";
                sql_ps = sql_connection.prepareStatement(sql);
                sql_ps.setString(1, compraID);
                sql_ps.setString(2, productosid);
                sql_ps.setString(3, cantidad_compra);
                sql_ps.setDouble(4, Double.parseDouble(precio_unitario));
                sql_ps.setDouble(5, Double.parseDouble(total_fila));
                sql_ps.executeUpdate();
                sql_connection.close();
                DisminuirExistencias();
            }
            else{
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 104: Insertando nuevo Detalle_venta: " + e);
        }
    }
    
    public void ObtenerIDSeleccion(int posicion){
        try{
         dc_id = listaidDetalle.getItem(posicion);
        }
        catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro de la tabla");
        }
    }
    
    public void ObtenerIDProducto(int fila_seleccionada){
        try{
            productosid = "" + modelo.getValueAt(fila_seleccionada, 0);
        }
        catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro de la tabla");
        }
    }
    
    public void RegenerarExistencias(){
        int cantidad_actual;
        int cantidad_regenerar;
        try{
            Connect();
            sql = "Select Cantidad_Existente from Productos Where ProductosID = ?;";
            sql_ps = sql_connection.prepareStatement(sql);
            System.out.println(productosid);
            sql_ps.setString(1, productosid);
            sql_rs = sql_ps.executeQuery();
            sql_rs.first();
            cantidad_actual = sql_rs.getInt("Cantidad_Existente");
            System.out.println("Cantidad antes de la regeneración: " + cantidad_actual);
            
            sql = "Select Cantidad_Productos from Detalle_Compra Where DC_ID = ?;";
            sql_ps = sql_connection.prepareStatement(sql);
            System.out.println(dc_id);
            sql_ps.setInt(1, Integer.parseInt(dc_id));
            sql_rs = sql_ps.executeQuery();
            sql_rs.first();
            cantidad_regenerar= sql_rs.getInt("Cantidad_Productos");
            System.out.println("Cantidad a regenerar: " + cantidad_regenerar);
            
            sql = "Update Productos SET Cantidad_Existente = ? Where ProductosID = ?";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_ps.setInt(1, cantidad_actual + cantidad_regenerar);
            sql_ps.setString(2, productosid);
            sql_ps.executeUpdate();
            sql_connection.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 198: Regenerando Existencias: " + e);
        }
    }
    public void EliminarDetalle_Compra() {
        try {
            RegenerarExistencias();
            Connect();
            sql = "Delete from Detalle_Compra Where DC_ID = ?;";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_ps.setInt(1, Integer.parseInt(dc_id));
            sql_ps.executeUpdate();
            sql_connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 106: Eliminar Detalle_Compra: " + e);
        }
    }
    
    public void CancelarCompra(int no_filas){
        try{
            for(int x = 0; x < no_filas; x ++){
                ObtenerIDSeleccion(x);
                ObtenerIDProducto(x);
                EliminarDetalle_Compra();
            }
            Connect();
            sql = "Delete from Compra Where CompraID = ?;";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_ps.setInt(1, Integer.parseInt(compraID));
            sql_ps.executeUpdate();
            sql_connection.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 184: Cancelando Compra: " + e);
        }
    }

    public void ConsultaTabla() {
        try {
            Connect();
            sql = "  CREATE OR REPLACE VIEW Resumen_Compra AS Select Detalle_Compra.DC_ID AS DC_ID, Detalle_Compra.ProductosID AS ID_Producto,\n"
                    + "  Productos.Nombre_Producto AS Producto, Productos.Descripcion AS Descripción, \n"
                    + "  Detalle_Compra.Precio_Unitario AS Precio, \n"
                    + "  Detalle_Compra.Cantidad_Productos AS Cantidad, Detalle_Compra.Total AS Total\n"
                    + "  FROM Detalle_Compra\n"
                    + "  INNER JOIN Productos ON Detalle_Compra.ProductosID = Productos.ProductosID\n"
                    + "  WHERE Detalle_Compra.CompraID = ?;";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_ps.setString(1, compraID);
            sql_ps.execute();
            
            sql = "Select ID_Producto, Producto, Descripción, Precio, Cantidad, Total from Resumen_Compra;";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_rs = sql_ps.executeQuery();
            modelo = DbUtils.resultSetToTableModel(sql_rs);
            
            sql = "Select DC_ID from Detalle_Compra Where CompraID = ? ORDER BY DC_ID ASC;";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_ps.setString(1, compraID);
            sql_rs = sql_ps.executeQuery();
            listaidDetalle.removeAll();
            while(sql_rs.next()){
                listaidDetalle.add(sql_rs.getString("DC_ID"));
            }
            
            sql = "Select SUM(Total) AS Total from Detalle_Compra WHERE CompraID = ?;";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_ps.setString(1, compraID);
            sql_rs = sql_ps.executeQuery();
            sql_rs.first();
            total_compra = sql_rs.getString("Total");
            sql_connection.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 301: Error al consultar Cliente: " + e);
        }
    }

    public void llenarProductos(javax.swing.JComboBox jcmb_productos) {
        String des = "";
        try {
            Connect();
            sql = "Select ProductosID, Nombre_Producto,Descripcion from Productos Order by ProductosID ASC";
            sql_rs = sql_st.executeQuery(sql);
            listaProductos.removeAll();
            jcmb_productos.removeAllItems();
            while (sql_rs.next()) {
                listaProductos.add(sql_rs.getString("ProductosID"));
                des += sql_rs.getString("Nombre_Producto") + "(";
                des += sql_rs.getString("Descripcion") + ")";
                jcmb_productos.addItem(des);
                des = "";
            }
            sql_connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 702: No se ha llenado el combo: " + e);
        }
    }

    public void ConsultarSeleccionado() {
        try {
            Connect();
            sql = "Select Cantidad_Existente, Precio_compra From Productos Where ProductosID = ?";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_ps.setString(1, productosid);
            sql_rs = sql_ps.executeQuery();
            sql_rs.first();
            cantidad_existente = sql_rs.getString("Cantidad_Existente");
            precio_unitario = sql_rs.getString("Precio_compra");
            sql_connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 802: No se ha llenado el combo: " + e);
        }
    }

    public void setProductosid(int posicion) {
        productosid = listaProductos.getItem(posicion);
    }

    public TableModel getModelo() {
        return modelo;
    }

    public String getProductosid() {
        return productosid;
    }

    public String getCantidad_existente() {
        return cantidad_existente;
    }

    public String getCantidad_compra() {
        return cantidad_compra;
    }

    public void setCantidad_compra(String cantidad_compra) {
        this.cantidad_compra = cantidad_compra;
    }

    public String getPrecio_unitario() {
        return precio_unitario;
    }

    public String getTotal_fila() {
        return total_fila;
    }

    public void setCompraID() {
        compraID = mPrincipal.getIdcompra();
    }

    public void setCantidad_existente(String cantidad_existente) {
        this.cantidad_existente = cantidad_existente;
    }

    public void setPrecio_unitario(String precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public void setTotal_fila(String total) {
        this.total_fila = total;
    }

    public String getTotal_compra() {
        return total_compra;
    }

    public void setTotal_compra(String total_compra) {
        this.total_compra = total_compra;
    }
}