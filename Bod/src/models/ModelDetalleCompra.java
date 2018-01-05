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
    private ModelPrincipal modelPrincipal;

    
    private int dc_id;
    private String compraID;
    private String productosid;
    private String cantidad_existente;
    private String precio_unitario;
    private String total;
    private List listaProductos = new List();

    public ModelDetalleCompra (ModelPrincipal mPrincipal){
        this.mPrincipal = mPrincipal;
    }
    
    
    public void setProductosid(int posicion) {
        productosid = listaProductos.getItem(posicion);
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
            JOptionPane.showMessageDialog(null, "Error 101: No hay conexión con la base de datos: " + e);
        }
    }
    public void Crearid(){
        try{
            sql = "Select DC_ID FROM DetalleCompra ORDER BY ASC";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_rs = sql_ps.executeQuery();
            sql_rs.last();
            dc_id = sql_rs.getInt("DC_ID");
            dc_id ++;
            
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Error 803: No se ha comprobado la compraid: " + e);
        }
    }
    public void InsertarDetalle_Compra(){
        try{
            Connect();
            sql = "Insert into Detalle_Compra (DC_ID, CompraID, ProductosID,Cantidad_Productos , Precio_Unitario, Total )Values (?,?,?,?,?,?);";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_ps.setInt(1, dc_id);
            sql_ps.setString(2, compraID);
            sql_ps.setString(3, productosid);
            sql_ps.setString(4, cantidad_existente);
            sql_ps.setString(5, precio_unitario);
            sql_ps.setString(6, total);
            sql_ps.executeUpdate();
            sql_connection.close();
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Error 104: Insertando nuevo Detalle_venta: " + e);
        }
        
    }
    public void ModificarDetalle_Compra(){
        try{
            Connect();
            sql = "Update Detalle_Compra Set CompraID = (?), ProductosID = (?), Cantidad_Productos = (?), Precio_Unitario = (?), Total = (?) Where DC_ID = (?);";
            sql_ps = sql_connection.prepareStatement(sql);
           sql_ps.setString(1, compraID );
           sql_ps.setString(2, productosid);
           sql_ps.setString(3, cantidad_existente);
           sql_ps.setString(4, precio_unitario);
           sql_ps.setString(5, total);
           sql_ps.setInt(6, dc_id);
           sql_ps.executeUpdate();
           //sql_connection.close();
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Error 105: Modificar Detalle_Compra: " + e);
        }
    }

    public void EliminarDetalle_Compra(){
        try{
            Connect();
            sql = "DELETE FROM Detalle_Compra Where DC_ID = (?);";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_ps.setInt(1, dc_id);
            sql_ps.executeUpdate();
            //sql_connection.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 106: Eliminar Detalle_Compra: " + e);
        }
    }
  
    public void ConsultaTabla(){
        try{
            sql =  "Select * from Detalle_Compra Where DC_ID = ?";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_ps.setString(1, "" + dc_id);
            sql_rs = sql_ps.executeQuery();
            modelo = DbUtils.resultSetToTableModel(sql_rs);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 301: Error al consultar Cliente: " + e);
        }
    }
    
    public void llenarProductos(javax.swing.JComboBox jcmb_productos){
        String des = "";
         try{
        Connect();
        sql = "Select ProductosID, Nombre_Producto,Descripcion from Productos Order by ProductosID ASC";
        sql_rs = sql_st.executeQuery(sql);
        listaProductos.removeAll();
        jcmb_productos.removeAllItems();
        while(sql_rs.next()){
            listaProductos.add(sql_rs.getString("ProductosID"));
            des += sql_rs.getString("Nombre_Producto") + "(";
            des += sql_rs.getString("Descripcion") + ")";
            jcmb_productos.addItem(des);
            des = "";
        }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 702: No se ha llenado el combo: " + e);
        }
    }
    
    public void ConsultarSeleccionado(){
        try{
        sql = "Select Cantidad_Existente, Precio_compra From Productos Where ProductosID = ?";
        sql_ps = sql_connection.prepareStatement(sql);
        sql_ps.setString(1,productosid);
        sql_rs = sql_ps.executeQuery();
        sql_rs.first();
        cantidad_existente = sql_rs.getString("Cantidad_Existente");
        precio_unitario = sql_rs.getString("Precio_compra");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 802: No se ha llenado el combo: " + e);
        }
    }
    
    public void BuscarCompra(String busca){
        try{
            sql = "Select * from Detalle_Compra Where Nombre_Cliente Like ? or Ciudad Like ? or Estado Like ? or ClienteID Like ?";
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
    
    
    public int getDc_id() {
        return dc_id;
    }

    public String getCompraID() {
        return compraID;
    }

    public String getProductosid() {
        return productosid;
    }

    public String getCantidad_existente() {
        return cantidad_existente;
    }

    public String getPrecio_unitario() {
        return precio_unitario;
    }

    public String getTotal() {
        return total;
    }

    public void setDc_id(int dc_id) {
        this.dc_id = dc_id;
    }

    public void setCompraID() {
        compraID = mPrincipal.getIdC();
    }

    public void setCantidad_existente(String cantidad_existente) {
        this.cantidad_existente = cantidad_existente;
    }

    public void setPrecio_unitario(String precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
}