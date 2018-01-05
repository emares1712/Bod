/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import models.ModelVentas;
import views.ViewVentas;
/**
 *
 * @author ninte
 */
public class ControllerVentas implements FocusListener {
    ModelVentas mVentas;
    ViewVentas  vVentas;
    
    public ControllerVentas(Object models[], Object views[], Object controllers[]){
        this.mVentas = (ModelVentas) models[7];
        this.vVentas = (ViewVentas) views[7];
        initView();
    }
    public void ActualizarTabla(){
        mVentas.ConsultaTabla();
        vVentas.jt_detalle_venta.setModel(mVentas.getModelo());
    }
    public void initView(){
        vVentas.addFocusListener(this);
        vVentas.jb_anterior.addActionListener(e->jbtn_anterior_Click());
        vVentas.jb_eliminar.addActionListener(e->jbtn_eliminar_Click());
        vVentas.jb_guardar.addActionListener(e->jbtn_guardar_Click());
        vVentas.jb_modificar.addActionListener(e->jbtn_modificar_Click());
        vVentas.jb_nuevo.addActionListener(e->jbtn_nuevo_Click());
        vVentas.jb_primero.addActionListener(e->jbtn_primero_Click());
        vVentas.jb_siguiente.addActionListener(e->jbtn_siguiente_Click());
        vVentas.jb_ultimo.addActionListener(e->jbtn_ultimo_Click());
    }
     public void obtenerValor(){
        vVentas.jtf_venta.setText(mVentas.getVentaid());
        vVentas.jtf_cliente.setText(mVentas.getClienteid());
        vVentas.jtf_fecha.setText(mVentas.getFecha_venta());
        vVentas.jtf_total.setText(mVentas.getTotal());
     }
     public void editarValor(){
        mVentas.setVentaid((vVentas.jtf_venta.getText()));
        mVentas.setClienteid((vVentas.jtf_cliente.getText())); 
        mVentas.setFecha_venta((vVentas.jtf_fecha.getText()));
        mVentas.setTotal((vVentas.jtf_total.getText()));
     }
     public void Nueva_Venta(){
        vVentas.jtf_venta.setText("");
        vVentas.jtf_cliente.setText("");
        vVentas.jtf_fecha.setText("");
        vVentas.jtf_total.setText("");
       
    }
    public void jbtn_anterior_Click(){
        mVentas.MoverAnterior();
        obtenerValor();
    }
    public void jbtn_eliminar_Click(){
        editarValor();
        mVentas.EliminarVenta();
        ActualizarTabla();
    }
    public void jbtn_guardar_Click(){
        editarValor();
        mVentas.InsertarVenta();
        ActualizarTabla();
    }
    public void jbtn_modificar_Click(){
        editarValor();
        mVentas.InsertarVenta();
        ActualizarTabla();  
    }
    public void jbtn_nuevo_Click(){
        Nueva_Venta();
        mVentas.ConsultarVenta();
    }
    public void jbtn_primero_Click(){
        mVentas.MoverPrimero();
        obtenerValor();
    }
    public void jbtn_siguiente_Click(){
        mVentas.MoverSiguiente();
        obtenerValor();
    }
    public void jbtn_ultimo_Click(){
        mVentas.MoverUltimo();
        obtenerValor();
    }

    @Override
    public void focusGained(FocusEvent e) {
        mVentas.ObtenerVentas();
        vVentas.jt_detalle_venta.setModel(mVentas.getObtenerVentas());
        mVentas.ConsultarVenta();
        mVentas.AsignarVenta();
        obtenerValor();    
    }

    @Override
    public void focusLost(FocusEvent e) {
         //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

    