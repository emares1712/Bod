package controllers;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import models.ModelProveedores;
import views.ViewProveedores;
/**
 *
 * @author ninte
 */
public class ControllerProveedores implements KeyListener{
    private ModelProveedores mProveedores;
    private ViewProveedores vProveedores;
    
public ControllerProveedores(Object models[], Object views[], Object controllers[]){
        this.mProveedores = (ModelProveedores)models[5];
        this.vProveedores = (ViewProveedores)views[5];
        initView();
    }
    public void initView(){
        Agregar();
        mProveedores.ConsultarProveedor();
        //mClientes.MoverPrimero();
        mProveedores.AsignarProveedor();
        obtenerValor();
        ActualizarTabla();
    }
    
    public void ActualizarTabla(){
        mProveedores.ConsultaTabla();
        vProveedores.jt_proveedor.setModel(mProveedores.getModelo());
    }
    
    public void Agregar(){
        vProveedores.jtf_buscar.addKeyListener(this);
        vProveedores.jb_atras.addActionListener(e->jbtn_anterior_Click());
        vProveedores.jb_eliminar.addActionListener(e->jbtn_eliminar_Click());
        vProveedores.jb_guardar.addActionListener(e->jbtn_guardar_Click());
        vProveedores.jb_modificar.addActionListener(e->jbtn_modificar_Click());
        vProveedores.jb_nuevo.addActionListener(e->jbtn_nuevo_Click());
        vProveedores.jb_primero.addActionListener(e->jbtn_primero_Click());
        vProveedores.jb_siguiente.addActionListener(e->jbtn_siguiente_Click());
        vProveedores.jb_ultimo.addActionListener(e->jbtn_ultimo_Click());
    }
    public void obtenerValor(){
        vProveedores.jtf_id.setText(mProveedores.getIdProveedor());
        vProveedores.jtf_nombre.setText(mProveedores.getNombreProveedor());
        vProveedores.jtf_ciudad.setText(mProveedores.getCiudad());
        vProveedores.jtf_colonia.setText(mProveedores.getColonia());
        vProveedores.jtf_calle.setText(mProveedores.getCalle());
        vProveedores.jtf_telefono.setText(mProveedores.getTelefono());
        vProveedores.jtf_whatsapp.setText(mProveedores.getWhatsapp());
    }
    public void editarValor(){
        mProveedores.setIdProveedor((vProveedores.jtf_id.getText()));
        mProveedores.setNombreProveedor((vProveedores.jtf_nombre.getText()));
        mProveedores.setCiudad((vProveedores.jtf_ciudad.getText()));
        mProveedores.setColonia((vProveedores.jtf_colonia.getText()));
        mProveedores.setCalle((vProveedores.jtf_calle.getText()));
        mProveedores.setTelefono((vProveedores.jtf_telefono.getText()));
        mProveedores.setWhatsapp((vProveedores.jtf_whatsapp.getText()));
    }
    public void NuevoEmpleado(){
        vProveedores.jtf_id.setText("");
        vProveedores.jtf_nombre.setText("");
        vProveedores.jtf_ciudad.setText("");
        vProveedores.jtf_colonia.setText("");
        vProveedores.jtf_calle.setText("");
        vProveedores.jtf_telefono.setText("");
        vProveedores.jtf_whatsapp.setText("");
    }
    public void jbtn_anterior_Click(){
        mProveedores.MoverAnterior();
        obtenerValor();
    }
    public void jbtn_eliminar_Click(){
        editarValor();
        mProveedores.EliminarProveedor();
        ActualizarTabla();
    }
    public void jbtn_guardar_Click(){
        editarValor();
        mProveedores.InsertarProveedor();
        ActualizarTabla();
    }
    public void jbtn_modificar_Click(){
        editarValor();
        mProveedores.ModificarProveedor();
        ActualizarTabla();
    }
    public void jbtn_nuevo_Click(){
        NuevoEmpleado();
        mProveedores.ConsultarProveedor();
    }
    public void jbtn_primero_Click(){
        mProveedores.MoverPrimero();
        obtenerValor();
    }
    public void jbtn_siguiente_Click(){
        mProveedores.MoverSiguiente();
        obtenerValor();
    }
    public void jbtn_ultimo_Click(){
        mProveedores.MoverUltimo();
        obtenerValor();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        mProveedores.BuscarProveedor(""+vProveedores.jtf_buscar.getText());
        vProveedores.jt_proveedor.setModel(mProveedores.getModelo());//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
         //To change body of generated methods, choose Tools | Templates.
    }
}
