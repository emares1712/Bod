package controllers;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import models.ModelProductos;
import views.ViewProductos;
/**
 *
 * @author ninte
 */
public class ControllerProductos implements KeyListener{
    private ModelProductos mProductos;
    private ViewProductos vProductos;
    
public ControllerProductos(Object models[], Object views[], Object controllers[]){
        this.mProductos = (ModelProductos)models[4];
        this.vProductos = (ViewProductos)views[4];
        initView();
    }
    public void initView(){
        Agregar();
        mProductos.ConsultarProducto();
        //mProductos.MoverPrimero();
        mProductos.AsignarProducto();
        obtenerValor();
        ActualizarTabla();
    }
    
    public void ActualizarTabla(){
        mProductos.ConsultaTabla();
        vProductos.jt_productos.setModel(mProductos.getModelo());
    }
    public void Agregar(){
        vProductos.jtf_buscar.addKeyListener(this);
        vProductos.jb_anterior.addActionListener(e->jbtn_anterior_Click());
        vProductos.jb_eliminar.addActionListener(e->jbtn_eliminar_Click());
        vProductos.jb_guardar.addActionListener(e->jbtn_guardar_Click());
        vProductos.jb_modificar.addActionListener(e->jbtn_modificar_Click());
        vProductos.jb_nuevo.addActionListener(e->jbtn_nuevo_Click());
        vProductos.jb_primero.addActionListener(e->jbtn_primero_Click());
        vProductos.jb_siguiente.addActionListener(e->jbtn_siguiente_Click());
        vProductos.jb_ultimo.addActionListener(e->jbtn_ultimo_Click());
    }
    public void obtenerValor(){
        vProductos.jtf_id_producto.setText(mProductos.getIdProducto());
        vProductos.jtf_nombre.setText(mProductos.getNombreProducto());
        vProductos.jtf_descripcion.setText(mProductos.getDescripcion());
        vProductos.jtf_existencias.setText(mProductos.getCantidadExistencias());
        vProductos.jtf_precio_compra.setText(mProductos.getPrecioCompra());
        vProductos.jtf_precio_venta.setText(mProductos.getPrecioVenta());
    }
    public void editarValor(){
        mProductos.setIdProducto((vProductos.jtf_id_producto.getText()));
        mProductos.setNombreProducto((vProductos.jtf_nombre.getText()));
        mProductos.setDescripcion((vProductos.jtf_descripcion.getText()));
        mProductos.setCantidadExistencias((vProductos.jtf_existencias.getText()));
        mProductos.setPrecioCompra((vProductos.jtf_precio_compra.getText()));
        mProductos.setPrecioVenta((vProductos.jtf_precio_venta.getText()));
    }
    public void NuevoEmpleado(){
        vProductos.jtf_id_producto.setText("");
        vProductos.jtf_nombre.setText("");
        vProductos.jtf_descripcion.setText("");
        vProductos.jtf_existencias.setText("");
        vProductos.jtf_precio_compra.setText("");
        vProductos.jtf_precio_venta.setText("");
    }
    public void jbtn_anterior_Click(){
        mProductos.MoverAnterior();
        obtenerValor();
    }
    public void jbtn_eliminar_Click(){
        editarValor();
        mProductos.EliminarProducto();
        ActualizarTabla();
    }
    public void jbtn_guardar_Click(){
        editarValor();
        mProductos.InsertarProducto();
        ActualizarTabla();
    }
    public void jbtn_modificar_Click(){
        editarValor();
        mProductos.ModificarProducto();
        ActualizarTabla();
    }
    public void jbtn_nuevo_Click(){
        NuevoEmpleado();
        mProductos.ConsultarProducto();
    }
    public void jbtn_primero_Click(){
        mProductos.MoverPrimero();
        obtenerValor();
    }
    public void jbtn_siguiente_Click(){
        mProductos.MoverSiguiente();
        obtenerValor();
    }
    public void jbtn_ultimo_Click(){
        mProductos.MoverUltimo();
        obtenerValor();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        mProductos.BuscarProducto(""+ vProductos.jtf_buscar.getText());
        vProductos.jt_productos.setModel(mProductos.getModelo());//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
         //To change body of generated methods, choose Tools | Templates.
    }
}
