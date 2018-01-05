/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.SQLException;
import javax.swing.JOptionPane;



/**
 *
 * @author ninte
 */

public class ModelLogin {
    private final ModelPrincipal model_principal;
    
    private String usuario;
    private char[] contraseña_usuario;
    private String contraseña_usuario_s;
    private String tipo_usuario;
    
    public ModelLogin(ModelPrincipal model_principal){
        this.model_principal = model_principal;
    }
    
    public void Verificar_Usuario(){
        try{
            contraseña_usuario_s = model_principal.Cifrar(contraseña_usuario_s, "MD5");
            model_principal.setSql("SELECT COUNT(Usuario)AS Verificado FROM Usuarios WHERE Usuario = ? AND Contraseña = ?;");
            model_principal.PS();   
            model_principal.getSql_prepared_statement().setString(1, usuario);
            model_principal.getSql_prepared_statement().setString(2, contraseña_usuario_s);
            model_principal.EjecutarPS();
            model_principal.getSql_result_set().first();
            if(model_principal.getSql_result_set().getString("Verificado").equals("1")){
                JOptionPane.showMessageDialog(null, "Bienvenido " + usuario);
            }
            else{
                throw new SQLException();
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos | Acceso Denegado");
        }
    }
    
    public void Verificar_Tipo_Usuario(){
        try{
            model_principal.setSql("SELECT Rol FROM Usuarios WHERE Usuario = ?;");
            model_principal.PS();
            model_principal.getSql_prepared_statement().setString(1, usuario);
            model_principal.EjecutarPS();
            model_principal.getSql_result_set().first();
            if (model_principal.getSql_result_set().getString("Rol").equals("0")) {
                tipo_usuario = "Admin";
            } 
            else {
                tipo_usuario = "Vendedor";
            }
            System.out.println(tipo_usuario);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al verificar el tipo de usuario: " + e);
        }
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public char[] getContraseña_Usuario() {
        return contraseña_usuario;
    }

    public void setContraseña_Usuario(char[] contraseña_usuario) {
        try{
            this.contraseña_usuario = contraseña_usuario;
            contraseña_usuario_s = "";
            
            for (int x = 0; this.contraseña_usuario[x] != '\0'; x++) {
                contraseña_usuario_s += this.contraseña_usuario[x];
            }  
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            //
        }
    }

    public String getTipo_Usuario() {
        return tipo_usuario;
    }

    public void setTipo_Usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }
}