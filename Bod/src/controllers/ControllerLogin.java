/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.ModelLogin;
import views.ViewPrincipal;
import views.ViewLogin;

/**
 *
 * @author ninte
 */

public class ControllerLogin {
    
    private ModelLogin mLogin;
    private ViewLogin vLogin;
    private ViewPrincipal vPrincipal;
    private ControllerPrincipal cPrincipal; 
    
    public ControllerLogin(Object[] models, Object[] views, Object[] controllers){
        this.mLogin = (ModelLogin)models[1];
        this.vLogin = (ViewLogin)views[1];
        this.vPrincipal = (ViewPrincipal)views[0];
        this.cPrincipal = (ControllerPrincipal)controllers[0];
        initView();
    }
    
    public void initView(){
        vLogin.jb_continuar.addActionListener(e -> jbtn_continuarClick());
        vLogin.setFocusable(true);
        vLogin.requestFocusInWindow();
    }
    
    public void setDatos(){
        mLogin.setUsuario(vLogin.jtf_usuario.getText());
        mLogin.setContraseña_Usuario(vLogin.jpass_contraseña.getPassword());
    }
    public void jbtn_continuarClick(){
        setDatos();
        mLogin.Verificar_Usuario();
        mLogin.Verificar_Tipo_Usuario();
        if(mLogin.getTipo_Usuario().equals("Admin")){
            vPrincipal.jm_menu.setVisible(true);
            vPrincipal.jmi_clientes.setVisible(true);
            vPrincipal.jmi_con_compra.setVisible(true);
            vPrincipal.jmi_detalleCompras.setVisible(true);
            vPrincipal.jmi_detalleVentas.setVisible(true);
            vPrincipal.jmi_empleados.setVisible(true);
            vPrincipal.jmi_productos.setVisible(true);
            vPrincipal.jmi_proveedores.setVisible(true);
            vPrincipal.jmi_ventas.setVisible(true);
            vPrincipal.jmi_compra.setVisible(true);
        }
        else{
            vPrincipal.jm_menu.setVisible(false);
            vPrincipal.jmi_clientes.setVisible(false);
            vPrincipal.jmi_con_compra.setVisible(false);
            vPrincipal.jmi_detalleCompras.setVisible(false);
            vPrincipal.jmi_detalleVentas.setVisible(false);
            vPrincipal.jmi_empleados.setVisible(false);
            vPrincipal.jmi_productos.setVisible(false);
            vPrincipal.jmi_proveedores.setVisible(false);
            vPrincipal.jmi_ventas.setVisible(false);
            vPrincipal.jmi_compra.setVisible(false);
        }
        vLogin.jtf_usuario.setText("");
        vLogin.jpass_contraseña.setText("");
    }
}

