/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import models.ModelPrincipal;
import views.*;
import models.*;
/**
 *
 * @author ninte
 */
public class ControllerPrincipal {
    private ModelPrincipal mPrincipal;
    private ViewPrincipal vPrincipal;
    private ViewLogin vLogin;
    private ModelLogin mLogin;
    private ControllerLogin cLogin;
    private ViewClientes vClientes;
    private ModelClientes mClientes;
    private ControllerClientes cClientes;
    private ViewEmpleados vEmpleados;
    private ModelEmpleados mEmpleados;
    private ControllerEmpleados cEmpleados;
    private ViewProductos vProductos;
    private ModelProductos mProductos;
    private ControllerProductos cProductos;
    private ViewProveedores vProveedores;
    private ModelProveedores mProveedores;
    private ControllerProveedores cProveedores;
    private ViewCompras vCompras;
    private ModelCompras mCompras;
    private ControllerCompras cCompras;
    private ViewVentas vVentas;
    private ModelVentas mVentas;
    private ControllerVentas cVentas;
    private ViewDetalleVentas vDetalleVentas;
    private ModelDetalleVentas mDetalleVentas;
    private ControllerDetalleVentas cDetalleVentas;
    private ViewDetalleCompras vDetalle;
    private ModelDetalleCompras mDetalle;
    private ControllerDetalleCompras cDetalle;
    private ViewCompra vCompra;
    private ModelCompra mCompra;
    private ControllerCompra cCompra;
    private ViewDetalleCompra vDetalleC;
    private ModelDetalleCompra mDetalleC;
    private ControllerDetalleCompra cDetalleC;
    
    public ControllerPrincipal(Object models[], Object views[], Object controllers[]){
        this.mPrincipal = (ModelPrincipal)models[0];
        this.vPrincipal = (ViewPrincipal)views[0];
        this.vLogin = (ViewLogin)views[1];
        this.mLogin = (ModelLogin)models[1];
        this.cLogin = (ControllerLogin)controllers[1];
        this.vClientes = (ViewClientes)views[2];
        this.mClientes = (ModelClientes)models[2];
        this.cClientes = (ControllerClientes)controllers[2];
        this.vEmpleados = (ViewEmpleados)views[3];
        this.mEmpleados = (ModelEmpleados)models[3];
        this.cEmpleados = (ControllerEmpleados)controllers[3];
        this.vProductos = (ViewProductos)views[4];
        this.mProductos = (ModelProductos)models[4];
        this.cProductos = (ControllerProductos)controllers[4];
        this.vProveedores = (ViewProveedores)views[5];
        this.mProveedores = (ModelProveedores)models[5];
        this.cProveedores = (ControllerProveedores)controllers[5];
        this.vCompras = (ViewCompras)views[6];
        this.mCompras = (ModelCompras)models[6];
        this.cCompras = (ControllerCompras)controllers[6];
        this.vVentas = (ViewVentas)views[7];
        this.mVentas = (ModelVentas)models[7];
        this.cVentas = (ControllerVentas)controllers[7];
        this.vDetalle = (ViewDetalleCompras)views[8];
        this.mDetalle = (ModelDetalleCompras)models[8];
        this.cDetalle = (ControllerDetalleCompras)controllers[8];
        this.vDetalleVentas = (ViewDetalleVentas)views[9];
        this.mDetalleVentas = (ModelDetalleVentas)models[9];
        this.cDetalleVentas = (ControllerDetalleVentas)controllers[9];
        this.vCompra = (ViewCompra)views[10];
        this.mCompra = (ModelCompra)models[10];
        this.cCompra = (ControllerCompra)controllers[10];
        this.vDetalleC = (ViewDetalleCompra)views[11];
        this.mDetalleC = (ModelDetalleCompra)models[11];
        this.cDetalleC = (ControllerDetalleCompra)controllers[11];
        initView();
    }
    public void initView(){
        vPrincipal.setTitle("Bodega J & B");
        vPrincipal.setLocationRelativeTo(null);
        vPrincipal.setVisible(true);
        Agregar_Menu();
    }
    public void Agregar_Menu(){
        vPrincipal.jm_menu.setVisible(false);
        vPrincipal.jmi_clientes.setVisible(false);
        vPrincipal.jmi_compra.setVisible(false);
        vPrincipal.jmi_con_compra.setVisible(false);
        vPrincipal.jmi_detalleCompras.setVisible(false);
        vPrincipal.jmi_detalleCompra.setVisible(false);
        vPrincipal.jmi_detalleVentas.setVisible(false);
        vPrincipal.jmi_empleados.setVisible(false);
        vPrincipal.jmi_productos.setVisible(false);
        vPrincipal.jmi_proveedores.setVisible(false);
        vPrincipal.jmi_ventas.setVisible(false);
        vPrincipal.jmi_inicio.addActionListener(e->jmi_inicio_click());
        vPrincipal.jmi_clientes.addActionListener(e->jmi_clientes_click());
        vPrincipal.jmi_empleados.addActionListener(e->jmi_empleados_click());
        vPrincipal.jmi_productos.addActionListener(e->jmi_productos_click());
        vPrincipal.jmi_proveedores.addActionListener(e->jmi_proveedores_click());
        vPrincipal.jmi_con_compra.addActionListener(e->jmi_compras_click());
        vPrincipal.jmi_ventas.addActionListener(e->jmi_ventas_click());
        vPrincipal.jmi_detalleCompras.addActionListener(e->jmi_detalleCompras_click());
        vPrincipal.jmi_detalleVentas.addActionListener(e->jmi_detalleVentas_click());
        vPrincipal.jmi_compra.addActionListener(e->jmi_compra_click());
        vPrincipal.jmi_detalleCompra.addActionListener(e->jmi_detalleCompra_click());
    }
    public void jmi_inicio_click(){
        vPrincipal.setContentPane(vLogin);
        vPrincipal.revalidate();
        vPrincipal.repaint();
    }
    public void jmi_clientes_click(){
        vPrincipal.setContentPane(vClientes);
        vPrincipal.revalidate();
        vPrincipal.repaint();
    }
    public void jmi_empleados_click(){
        vPrincipal.setContentPane(vEmpleados);
        vPrincipal.revalidate();
        vPrincipal.repaint();
    }
    public void jmi_productos_click(){
        vPrincipal.setContentPane(vProductos);
        vPrincipal.revalidate();
        vPrincipal.repaint();
    }
    public void jmi_proveedores_click(){
        vPrincipal.setContentPane(vProveedores);
        vPrincipal.revalidate();
        vPrincipal.repaint();
    }
    public void jmi_compras_click(){
        vPrincipal.setContentPane(vCompras);
        vPrincipal.revalidate();
        vPrincipal.repaint();
    }
    public void jmi_ventas_click(){
        vPrincipal.setContentPane(vVentas);
        vPrincipal.revalidate();
        vPrincipal.repaint();
    }
    public void jmi_detalleCompras_click(){
        vPrincipal.setContentPane(vDetalle);
        vPrincipal.revalidate();
        vPrincipal.repaint();
    }
    public void jmi_detalleVentas_click(){
        vPrincipal.setContentPane(vVentas);
        vPrincipal.revalidate();
        vPrincipal.repaint();
    }
    public void jmi_compra_click(){
        vPrincipal.setContentPane(vCompra);
        vPrincipal.revalidate();
        vPrincipal.repaint();
    }
    public void jmi_detalleCompra_click(){
        vPrincipal.setContentPane(vDetalleC);
        vPrincipal.revalidate();
        vPrincipal.repaint();
    }
}
