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
import models.*;
import views.*;

/**
 *
 * @author ninte
 */
public class ControllerDetalleCompra implements FocusListener{
    private ModelDetalleCompra mDetalleC;
    private ViewDetalleCompra vDetalleC;
    
    public ControllerDetalleCompra(Object models[], Object views[], Object controllers[]){
        this.mDetalleC = (ModelDetalleCompra )models[11];
        this.vDetalleC = (ViewDetalleCompra)views[11];
        initView();
    }
    public void initView(){
        Agregar();
        mDetalleC.llenarProductos(vDetalleC.jcmb_producto);
        vDetalleC.jcmb_producto.addActionListener(e->jbtn_producto_Click());
    }
    public void ActualizarTabla(){
        mDetalleC.ConsultaTabla();
        vDetalleC.jt_dc.setModel(mDetalleC.getModelo());
    }
    public void Agregar(){
        vDetalleC.jbtn_quitar.addActionListener(e->jbtn_quitar_Click());
        vDetalleC.jbtn_agregar.addActionListener(e->jbtn_agregar_Click());
    }
    public void jbtn_producto_Click(){
        mDetalleC.setProductosid(vDetalleC.jcmb_producto.getSelectedIndex());
        mDetalleC.ConsultarSeleccionado();
        vDetalleC.jtf_existencias.setText(mDetalleC.getCantidad_existente());
        vDetalleC.jtf_precio.setText(mDetalleC.getPrecio_unitario());
    }
    public void jbtn_quitar_Click(){
        mDetalleC.EliminarDetalle_Compra();
        ActualizarTabla();
    }
    public void jbtn_agregar_Click(){
        
        mDetalleC.InsertarDetalle_Compra();
        ActualizarTabla();
    }

    @Override
    public void focusGained(FocusEvent e) {
        mDetalleC.Crearid(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void focusLost(FocusEvent e) {
         //To change body of generated methods, choose Tools | Templates.
    }
}