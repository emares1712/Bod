/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import models.ModelClientes;
import models.ModelCompras;
import views.ViewClientes;
import views.ViewCompras;
/**
 *
 * @author ninte
 */
public class ControllerCompras implements KeyListener{
     private ModelCompras mCompras;
    private ViewCompras vCompras;
    
    public ControllerCompras(Object models[], Object views[], Object controllers[]){
        this.mCompras = (ModelCompras)models[6];
        this.vCompras = (ViewCompras)views[6];
        initView();
    }
    public void initView(){
        Agregar();
        mCompras.ConsultarCompras();
        //mClientes.MoverPrimero();
        mCompras.AsignarCompra();
        obtenerValor();
        ActualizarTabla();
    }
    public void ActualizarTabla(){
        mCompras.ConsultaTabla();
        vCompras.jt_detalle_compra.setModel(mCompras.getModelo());
    }
    public void Agregar(){
        vCompras.jtf_buscar.addKeyListener((KeyListener) this);
        vCompras.jb_anterior.addActionListener(e->jbtn_anterior_Click());
        vCompras.jb_eliminar.addActionListener(e->jbtn_eliminar_Click());
        vCompras.jb_guardar.addActionListener(e->jbtn_guardar_Click());
        vCompras.jb_modificar.addActionListener(e->jbtn_modificar_Click());
        vCompras.jb_nuevo.addActionListener(e->jbtn_nuevo_Click());
        vCompras.jb_primero.addActionListener(e->jbtn_primero_Click());
        vCompras.jb_siguiente.addActionListener(e->jbtn_siguiente_Click());
        vCompras.jb_ultimo.addActionListener(e->jbtn_ultimo_Click());
    }
    public void obtenerValor(){
        vCompras.jtf_compra.setText(mCompras.getCompraID());
        vCompras.jtf_proveedor.setText(mCompras.getProveedoresID());
        vCompras.jtf_fecha.setText("" + mCompras.getFecha_Compra());
      
    }
    public void editarValor(){
        mCompras.setCompraID((vCompras.jtf_compra.getText()));
        mCompras.setProveedoresID((vCompras.jtf_proveedor.getText()));
        mCompras.setFecha_Compra(Date.valueOf(vCompras.jtf_fecha.getText()));
     
    }
    public void Nueva_Compra(){
        vCompras.jtf_compra.setText("");
        vCompras.jtf_proveedor.setText("");
        vCompras.jtf_fecha.setText("");
        vCompras.jtf_total.setText("");
     
    }
    public void jbtn_anterior_Click(){
        mCompras.MoverAnterior();
        obtenerValor();
    }
    public void jbtn_eliminar_Click(){
        editarValor();
        mCompras.EliminarCompra();
        ActualizarTabla();
    }
    public void jbtn_guardar_Click(){
        editarValor();
        mCompras.InsertarCompra();
        ActualizarTabla();
    }
    public void jbtn_modificar_Click(){
        editarValor();
        mCompras.ModificarCompra();
        ActualizarTabla();
    }
    public void jbtn_nuevo_Click(){
        Nueva_Compra();
        mCompras.ConsultarCompras();
    }
    public void jbtn_primero_Click(){
        mCompras.MoverPrimero();
        obtenerValor();
    }
    public void jbtn_siguiente_Click(){
        mCompras.MoverSiguiente();
        obtenerValor();
    }
    public void jbtn_ultimo_Click(){
        mCompras.MoverUltimo();
        obtenerValor();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
       mCompras.BuscarCompra(""+vCompras.jtf_buscar.getText()); //To change body of generated methods, choose Tools | Templates.
       vCompras.jt_detalle_compra.setModel(mCompras.getModelo());    
    }

    @Override
    public void keyReleased(KeyEvent e) {
       //To change body of generated methods, choose Tools | Templates.
    }
}
