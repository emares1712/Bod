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
import java.sql.Date;

/**
 *
 * @author ninte
 */
public class ModelCompras{
    private Connection sql_connection;
    private Statement sql_st;
    private PreparedStatement sql_ps;
    private ResultSet sql_rs;
    private String sql;
    private String idCompra;
    private String idproveedores;
    private java.sql.Date fecha_compra;
    
     public TableModel getModelo() {
        return modelo;
    }
    private TableModel modelo;
    
    private void Connect(){
        try{
            sql_connection = DriverManager.getConnection("jdbc:mysql://localhost/Bodega","root","");
            sql_st = sql_connection.createStatement();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 125: No hay conexión con la base de datos: " + e);
        }
    }
    public void ConsultarCompras(){
        try{
            Connect();
            sql = "SELECT * FROM Compra ORDER BY CompraID ASC";
            sql_rs = sql_st.executeQuery(sql);
            sql_rs.first();
            //sql_connection.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 126: Consulta tabla Compra: " + e);
        }
    }
    public void AsignarCompra(){
        try{
            idCompra = sql_rs.getString("CompraID");
            idproveedores = sql_rs.getString("ProveedoresID");
            fecha_compra= sql_rs.getDate("Fecha_Compra");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 127: Asignado de valores de la Compra: " + e);
        }
    }
    public void InsertarCompra(){
        try{
            Connect();
            sql = "Insert into Compra (CompraID, ProveedoresID, Fecha_Compra)Values (?,?,?);";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_ps.setString(1, idCompra);
            sql_ps.setString(2, idproveedores);
            sql_ps.setDate(3, fecha_compra);
            sql_ps.executeUpdate();
            //sql_connection.close();
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Error 128: Insertando nueva compra: " + e);
        }
    }
    public void ModificarCompra(){
        try{
            Connect();
            sql = "Update Compra Set  ProveedoresID = (?), Fecha_Compra = (?) Where CompraID = (?);";
            sql_ps = sql_connection.prepareStatement(sql);
           sql_ps.setString(1, idproveedores);
           sql_ps.setDate(2, fecha_compra);
           sql_ps.setString(3, idCompra);
           sql_ps.executeUpdate();
           //sql_connection.close();
        }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Error 129: Modificar Compra: " + e);
        }
    }

    public void EliminarCompra(){
        try{
            Connect();
            sql = "DELETE FROM Compra Where CompraID = (?);";
            sql_ps.setString(1, idCompra);
            sql_ps.executeUpdate();
            //sql_connection.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 130: Eliminar Compra: " + e);
        }
    }
    public void MoverPrimero(){
        try{
            if (sql_rs.isFirst() == false) {
                sql_rs.first();
                AsignarCompra();
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
                AsignarCompra();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 214: Mover al primer registro: " + e);
        }
    }
    
    public void MoverSiguiente(){
        try {
            if (sql_rs.isLast() == false) {
                sql_rs.next();
                AsignarCompra();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 215: Mover al primer registro: " + e);
        }
    }
    
    public void MoverUltimo(){
        try {
            if (sql_rs.isLast() == false) {
                sql_rs.last();
                AsignarCompra();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 216: Mover al primer registro: " + e);
        }
    }
    public void ConsultaTabla(){
        try{
            sql =  "Select * from Compra";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_rs = sql_ps.executeQuery();
            modelo = DbUtils.resultSetToTableModel(sql_rs);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 307: Error al consultar la compra: " + e);
        }
    }
    public void BuscarCompra(String busca){
        try{
           sql = "Select * from Compra Where ProveedoresID Like ? or Fecha_Compra Like ? or Total Like ? or CompraID Like ?";
            sql_ps = sql_connection.prepareStatement(sql);
            sql_ps.setString(1, busca+"%");
            sql_ps.setString(2, busca+"%");
            sql_ps.setString(3, busca+"%");
            sql_ps.setString(4, busca+"%");
            sql_rs = sql_ps.executeQuery();
            modelo = DbUtils.resultSetToTableModel(sql_rs);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error 407: Error al buscar la Compra: " + e);
        }
    }
    
    public String getCompraID() {
        return idCompra;
    }

    public String getProveedoresID() {
        return idproveedores;
    }

    public Date getFecha_Compra() {
        return fecha_compra;
    }


    public void setCompraID(String idcompra) {
        this.idCompra = idcompra;
    }

    public void setProveedoresID(String idproveedores) {
        this.idproveedores = idproveedores;
    }

    public void setFecha_Compra(Date fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

}
