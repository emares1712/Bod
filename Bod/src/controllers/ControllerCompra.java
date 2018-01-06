/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import models.ModelClientes;
import models.ModelCompra;
import views.ViewClientes;
import views.ViewCompra;
import views.ViewPrincipal;
import views.ViewDetalleCompra;

/**
 *
 * @author ninte
 */
public class ControllerCompra implements FocusListener {
    private ModelCompra mCompra;
    private ViewCompra vCompra;
    private ViewPrincipal vPrincipal;
    private ViewDetalleCompra vDetalleC;
    
    public ControllerCompra(Object models[], Object views[], Object controllers[]){
        this.vPrincipal = (ViewPrincipal)views[0];
        this.mCompra = (ModelCompra)models[10];
        this.vCompra = (ViewCompra)views[10];
        this.vDetalleC = (ViewDetalleCompra) views[11];
        initView();
    }
    public void initView(){
        Agregar();
    }
    
    public void Agregar(){
        vCompra.addFocusListener(this);
        vCompra.jbtn_nueva.addActionListener(a->jbtn_nuevo_Click());
    }
    
    public void jbtn_nuevo_Click(){
        mCompra.setIdproveedor(vCompra.jcmb_proveedor.getSelectedIndex());
        mCompra.setFecha_compra(java.sql.Date.valueOf(vCompra.jTextField1.getText()));
        mCompra.InsertarCompra();
        vPrincipal.setContentPane(vDetalleC);
        vPrincipal.revalidate();
        vPrincipal.repaint();
        vDetalleC.requestFocusInWindow();
    }

    @Override
    public void focusGained(FocusEvent e) {
        vCompra.jTextField1.setText("");
        mCompra.LlenarCombo(vCompra.jcmb_proveedor);
    }

    @Override
    public void focusLost(FocusEvent e) {
        
    }
}