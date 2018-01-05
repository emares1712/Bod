/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
     * and open the template in the editor.
 */
package controllers;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import models.*;
import views.*;

/**
 *
 * @author ninte
 */
public class ControllerDetalleCompras implements KeyListener{
    private ModelDetalleCompras mDetalle;
    private ViewDetalleCompras vDetalle;
    
    public ControllerDetalleCompras(Object models[], Object views[], Object controllers[]){
        this.mDetalle = (ModelDetalleCompras )models[8];
        this.vDetalle = (ViewDetalleCompras)views[8];
        initView();
    }
    public void initView(){
        Agregar();
        mDetalle.ConsultarDetalle();
        //mClientes.MoverPrimero();
        mDetalle.AsignarDetalle();
        obtenerValor();
        ActualizarTabla();
    }
    public void ActualizarTabla(){
        mDetalle.ConsultaTabla();
        vDetalle.jt_dc.setModel(mDetalle.getModelo());
    }
    public void Agregar(){
        vDetalle.jtf_buscar.addKeyListener((KeyListener) this);
        vDetalle.jb_atras.addActionListener(e->jbtn_anterior_Click());
        vDetalle.jb_eliminar.addActionListener(e->jbtn_eliminar_Click());
        vDetalle.jb_guardar.addActionListener(e->jbtn_guardar_Click());
        vDetalle.jb_modificar.addActionListener(e->jbtn_modificar_Click());
        vDetalle.jb_nuevo.addActionListener(e->jbtn_nuevo_Click());
        vDetalle.jb_primero.addActionListener(e->jbtn_primero_Click());
        vDetalle.jb_siguiente.addActionListener(e->jbtn_siguiente_Click());
        vDetalle.jb_ultimo.addActionListener(e->jbtn_ultimo_Click());
    }
    public void obtenerValor(){
        vDetalle.jtf_detalle.setText(mDetalle.getDc_id());
        vDetalle.jtf_id.setText(mDetalle.getCompraID());
        vDetalle.jtf_producto.setText(mDetalle.getProductosid());
        vDetalle.jtf_cantidad.setText(mDetalle.getCantidad_existente());
        vDetalle.jtf_precio.setText(mDetalle.getPrecio_unitario());
        vDetalle.jtf_total.setText(mDetalle.getTotal());
      
    }
    public void editarValor(){
        mDetalle.setDc_id((vDetalle.jtf_detalle.getText()));
        mDetalle.setCompraID((vDetalle.jtf_id.getText()));
        mDetalle.setProductosid((vDetalle.jtf_producto.getText()));
        mDetalle.setCantidad_existente((vDetalle.jtf_cantidad.getText()));
        mDetalle.setPrecio_unitario((vDetalle.jtf_precio.getText()));
        mDetalle.setTotal(vDetalle.jtf_total.getText());
     
    }
    public void Nueva_Compra(){
        vDetalle.jtf_detalle.setText("");
        vDetalle.jtf_id.setText("");
        vDetalle.jtf_producto.setText("");
        vDetalle.jtf_cantidad.setText("");
        vDetalle.jtf_precio.setText("");
        vDetalle.jtf_total.setText("");
     
    }
    public void jbtn_anterior_Click(){
        mDetalle.MoverAnterior();
        obtenerValor();
    }
    public void jbtn_eliminar_Click(){
        editarValor();
        mDetalle.EliminarDetalle_Compra();
        ActualizarTabla();
    }
    public void jbtn_guardar_Click(){
        editarValor();
        mDetalle.InsertarDetalle_Compra();
        ActualizarTabla();
    }
    public void jbtn_modificar_Click(){
        editarValor();
        mDetalle.ModificarDetalle_Compra();
        ActualizarTabla();
    }
    public void jbtn_nuevo_Click(){
        Nueva_Compra();
        mDetalle.ConsultarDetalle();
    }
    public void jbtn_primero_Click(){
        mDetalle.MoverPrimero();
        obtenerValor();
    }
    public void jbtn_siguiente_Click(){
        mDetalle.MoverSiguiente();
        obtenerValor();
    }
    public void jbtn_ultimo_Click(){
        mDetalle.MoverUltimo();
        obtenerValor();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
       mDetalle.BuscarCompra(""+vDetalle.jtf_buscar.getText()); //To change body of generated methods, choose Tools | Templates.
       vDetalle.jt_dc.setModel(mDetalle.getModelo());    
    }

    @Override
    public void keyReleased(KeyEvent e) {
       //To change body of generated methods, choose Tools | Templates.
    }
}
