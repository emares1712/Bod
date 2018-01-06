/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import models.*;
import views.*;
import controllers.*;
/**
 *
 * @author ninte
 */
public class Main {
    public static void main(String ej[]){
        ModelPrincipal mPrincipal = new ModelPrincipal();
        ModelLogin mLogin = new ModelLogin(mPrincipal);
        ModelClientes mClientes = new ModelClientes();
        ModelEmpleados mEmpleados = new ModelEmpleados();
        ModelProductos mProductos = new ModelProductos();
        ModelProveedores mProveedores = new ModelProveedores();
        ModelCompras    mCompras = new ModelCompras();
        ModelVentas     mVentas = new ModelVentas();
        ModelDetalleCompras     mDetalle = new ModelDetalleCompras();
        ModelCompra     mCompra = new ModelCompra();
        ModelDetalleCompra     mDetalleC = new ModelDetalleCompra(mPrincipal);
        
        ViewLogin vLogin = new ViewLogin();
        ViewPrincipal vPrincipal = new ViewPrincipal();
        ViewClientes vClientes = new ViewClientes();
        ViewEmpleados vEmpleados = new ViewEmpleados();
        ViewProductos vProductos = new ViewProductos();
        ViewProveedores vProveedores = new ViewProveedores();
        ViewCompras   vCompras   = new ViewCompras();
        ViewVentas     vVentas      = new ViewVentas();
        ViewDetalleCompras vDetalle = new ViewDetalleCompras();
        ViewCompra vCompra = new ViewCompra();
        ViewDetalleCompra vDetalleC = new ViewDetalleCompra();
        
        Object models[] = new Object[14];
        Object views[] = new Object[14];
        Object controllers[] = new Object [14];
        
        models[0] = mPrincipal;
        models[1] = mLogin;
        models[2] = mClientes;
        models[3] = mEmpleados;
        models[4] = mProductos;
        models[5] = mProveedores;
        models[6] = mCompras;
        models[7] = mVentas;
        models[8] = mDetalle;
        models[10] = mCompra;
        models[11] = mDetalleC;
        
        views[0] = vPrincipal;
        views[1] = vLogin;
        views[2] = vClientes;
        views[3] = vEmpleados;
        views[4] = vProductos;
        views[5] = vProveedores;
        views[6] = vCompras;
        views[7] = vVentas;
        views[8] = vDetalle;
        views[10] = vCompra;
        views[11] = vDetalleC;
        
        ControllerPrincipal cPrincipal = new ControllerPrincipal(models, views, controllers);
        controllers[0] = cPrincipal;
        ControllerLogin cLogin = new ControllerLogin(models, views, controllers);
        controllers[1] = cLogin;
        ControllerClientes cClientes = new ControllerClientes(models, views, controllers);
        controllers[2] = cClientes;
        ControllerEmpleados cEmpleados = new ControllerEmpleados(models, views, controllers);
        controllers[3] = cEmpleados;
        ControllerProductos cProductos = new ControllerProductos(models, views, controllers);
        controllers[4] = cProductos;
        ControllerProveedores cProveedores = new ControllerProveedores(models, views, controllers);
        controllers[5] = cProveedores;
        ControllerCompras cCompras = new ControllerCompras (models, views, controllers);
        controllers[6] = cCompras;
        ControllerVentas cVentas = new ControllerVentas (models, views, controllers);
        controllers[7] = cVentas;
        ControllerDetalleCompras cDetalle = new ControllerDetalleCompras(models, views, controllers);
        controllers[8] = cDetalle;
        ControllerCompra cCompra = new ControllerCompra(models, views, controllers);
        controllers[10] = cCompra;
        ControllerDetalleCompra cDetalleC = new ControllerDetalleCompra(models, views, controllers);
        controllers[11] = cDetalleC;
    }
}
