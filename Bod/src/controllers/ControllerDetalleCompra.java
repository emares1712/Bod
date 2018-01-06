/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import models.*;
import views.*;

/**
 *
 * @author ninte
 */
public class ControllerDetalleCompra implements FocusListener{

    private ModelDetalleCompra mDetalleC;
    private ViewDetalleCompra vDetalleC;
    private ControllerPrincipal cPrincipal;
    
    private final ActionListener cambio_estado_combo = (e -> jbtn_producto_Click());

    public ControllerDetalleCompra(Object models[], Object views[], Object controllers[]) {
        this.mDetalleC = (ModelDetalleCompra) models[11];
        this.vDetalleC = (ViewDetalleCompra) views[11];
        this.cPrincipal = (ControllerPrincipal) controllers[0];
        initView();
    }

    public void initView() {
        Agregar();
    }

    public void ActualizarTabla() {
        mDetalleC.ConsultaTabla();
        vDetalleC.jt_dc.setModel(mDetalleC.getModelo());
    }

    public void Agregar() {
        vDetalleC.addFocusListener(this);
        vDetalleC.jbtn_quitar.addActionListener(e -> jbtn_quitar_Click());
        vDetalleC.jbtn_agregar.addActionListener(e -> jbtn_agregar_Click());
        vDetalleC.jbtn_aceptar.addActionListener(e -> jbtn_aceptar_Click());
        vDetalleC.jbtn_cancelar.addActionListener(e -> jbtn_cancelar_Click());
    }

    public void jbtn_producto_Click() {
        mDetalleC.setProductosid(vDetalleC.jcmb_producto.getSelectedIndex());
        mDetalleC.ConsultarSeleccionado();
        vDetalleC.jtf_existencias.setText(mDetalleC.getCantidad_existente());
        vDetalleC.jtf_precio.setText(mDetalleC.getPrecio_unitario());
        vDetalleC.jtf_cantidad.setText("");
    }

    public void jbtn_quitar_Click() {
        mDetalleC.ObtenerIDSeleccion(vDetalleC.jt_dc.getSelectedRow());
        mDetalleC.ObtenerIDProducto(vDetalleC.jt_dc.getSelectedRow());
        mDetalleC.EliminarDetalle_Compra();
        ActualizarTabla();
        vDetalleC.jtf_total.setText(mDetalleC.getTotal_compra());
        mDetalleC.ConsultarSeleccionado();
        vDetalleC.jtf_existencias.setText(mDetalleC.getCantidad_existente());
        vDetalleC.jtf_precio.setText(mDetalleC.getPrecio_unitario());
        vDetalleC.jtf_cantidad.setText("");
    }
    
    public void jbtn_aceptar_Click(){
        cPrincipal.jmi_compra_click();
    }
    
    public void jbtn_cancelar_Click(){
        mDetalleC.CancelarCompra(vDetalleC.jt_dc.getRowCount());
        cPrincipal.jmi_compra_click();
    }

    public void jbtn_agregar_Click() {
        mDetalleC.setProductosid(vDetalleC.jcmb_producto.getSelectedIndex());
        mDetalleC.setCantidad_compra(vDetalleC.jtf_cantidad.getText());
        mDetalleC.setPrecio_unitario(vDetalleC.jtf_precio.getText());
        mDetalleC.setTotal_compra(vDetalleC.jtf_total.getText());
        mDetalleC.InsertarDetalle_Compra();
        ActualizarTabla();
        vDetalleC.jtf_total.setText(mDetalleC.getTotal_compra());
        mDetalleC.ConsultarSeleccionado();
        vDetalleC.jtf_existencias.setText(mDetalleC.getCantidad_existente());
        vDetalleC.jtf_precio.setText(mDetalleC.getPrecio_unitario());
        vDetalleC.jtf_cantidad.setText("");
    }

    @Override
    public void focusGained(FocusEvent e) {
        mDetalleC.AsignarIDCompra();
        vDetalleC.jcmb_producto.removeActionListener(cambio_estado_combo);
        mDetalleC.llenarProductos(vDetalleC.jcmb_producto);
        vDetalleC.jcmb_producto.addActionListener(cambio_estado_combo);
        vDetalleC.jtf_cantidad.setText("");
        ActualizarTabla();
    }

    @Override
    public void focusLost(FocusEvent e) {
    }
}