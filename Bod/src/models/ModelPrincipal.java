package models;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
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

public class ModelPrincipal {
    private Connection sql_connection;
    private Statement sql_st;
    private PreparedStatement sql_ps;
    private ResultSet sql_rs;
    private String sql;
    private MessageDigest md5;
    private StringBuilder string_builder;
    private String idcompra;
    
    public void Connect(){
        try {
            // Aquí habías colocado una línea de más que sólo se usa con el driver de PostgreSQL.
            sql_connection = DriverManager.getConnection("jdbc:mysql://localhost/Bodega","root","");
            sql_st = sql_connection.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 001: Conexion con la base de datos: " + e);
        }
    }
    
    public void Ejecutar_Consulta() {
        try {
            Connect();
            sql_rs = sql_st.executeQuery(sql);
            //sql_connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 002: Ejecutar consulta: " + e);
        }
    }
    
    public void EjecutarPS() {
        try {
            sql_rs = sql_ps.executeQuery();
            //sql_connection.close();
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 003: Ejecutar PS: " + e);
        }
    }

    public void Actualizacion() {
        try {
            sql_ps.executeUpdate();
            //sql_connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 004: Ejecutar actualización: " + e);
        }
    }

    public void Sentencia() {
        try {
            Connect();
            sql_st.execute(sql);
            sql_connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Eroor 005: Ejecutar sentencia" + e);
        }
    }

    public void PS() {
        try {
            Connect();
            sql_ps = sql_connection.prepareStatement(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 006: Preparar Statement: " + e);
        }
    }
    
    public String Cifrar(String texto, String tipo_cifrado){
        try{
            md5 = MessageDigest.getInstance(tipo_cifrado);
            byte[] auxiliar_cifrado = md5.digest(texto.getBytes());
            string_builder = new StringBuilder();
            for(int x = 0; x < auxiliar_cifrado.length; x ++){
                string_builder.append(Integer.toHexString((auxiliar_cifrado[x] & 0xFF) | 0x100).substring(1,3));
            }
            return string_builder.toString();
        }
        catch(NoSuchAlgorithmException e){
            JOptionPane.showMessageDialog(null, "Error 007: Cifrar la información" + e);
        }
        return "";
    }

    public Connection getSql_connection() {
        return sql_connection;
    }

    public void setSql_connection(Connection sql_connection) {
        this.sql_connection = sql_connection;
    }

    public Statement getSql_statement() {
        return sql_st;
    }

    public void setSql_statement(Statement sql_statement) {
        this.sql_st = sql_statement;
    }

    public PreparedStatement getSql_prepared_statement() {
        return sql_ps;
    }

    public void setSql_prepared_statement(PreparedStatement sql_prepared_statement) {
        this.sql_ps = sql_prepared_statement;
    }

    public ResultSet getSql_result_set() {
        return sql_rs;
    }

    public void setSql_result_set(ResultSet sql_result_set) {
        this.sql_rs = sql_result_set;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public StringBuilder getString_builder() {
        return string_builder;
    }

    public void setString_builder(StringBuilder string_builder) {
        this.string_builder = string_builder;
    }

    public MessageDigest getMD5() {
        return md5;
    }

    public void setMD5(MessageDigest md5) {
        this.md5 = md5;
    }

    public String getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(String idcompra) {
        this.idcompra = idcompra;
    }
     
}