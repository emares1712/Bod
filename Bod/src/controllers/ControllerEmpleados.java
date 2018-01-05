package controllers;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import models.ModelEmpleados;
import views.ViewEmpleados;
/**
 *
 * @author ninte
 */
public class ControllerEmpleados implements KeyListener{
    private ModelEmpleados mEmpleados;
    private ViewEmpleados vEmpleados;
    
public ControllerEmpleados(Object models[], Object views[], Object controllers[]){
        this.mEmpleados = (ModelEmpleados)models[3];
        this.vEmpleados = (ViewEmpleados)views[3];
        initView();
    }
    public void initView(){
        Agregar();
        mEmpleados.ConsultarEmpleado();
        //mClientes.MoverPrimero();
        mEmpleados.AsignarEmpleado();
        obtenerValor();
        ActualizarTabla();
    }
     public void ActualizarTabla(){
        mEmpleados.ConsultaTabla();
        vEmpleados.jt_empleado.setModel(mEmpleados.getModelo());
    }
    public void Agregar(){
        vEmpleados.jb_anterior.addActionListener(e->jbtn_anterior_Click());
        vEmpleados.jb_eliminar.addActionListener(e->jbtn_eliminar_Click());
        vEmpleados.jb_guardar.addActionListener(e->jbtn_guardar_Click());
        vEmpleados.jb_modificar.addActionListener(e->jbtn_modificar_Click());
        vEmpleados.jb_nuevo.addActionListener(e->jbtn_nuevo_Click());
        vEmpleados.jb_primero.addActionListener(e->jbtn_primero_Click());
        vEmpleados.jb_siguiente.addActionListener(e->jbtn_siguiente_Click());
        vEmpleados.jb_ultimo.addActionListener(e->jbtn_ultimo_Click());
    }
    public void obtenerValor(){
        vEmpleados.jtf_id.setText(mEmpleados.getIdEmpleado());
        vEmpleados.jtf_nombre.setText(mEmpleados.getNombreEmpleado());
        vEmpleados.jtf_colonia.setText(mEmpleados.getColonia());
        vEmpleados.jtf_calle.setText(mEmpleados.getCalle());
        vEmpleados.jtf_telefono.setText(mEmpleados.getTelefono());
    }
    public void editarValor(){
        mEmpleados.setIdEmpleado((vEmpleados.jtf_id.getText()));
        mEmpleados.setNombreEmpleado((vEmpleados.jtf_nombre.getText()));
        mEmpleados.setColonia((vEmpleados.jtf_colonia.getText()));
        mEmpleados.setCalle((vEmpleados.jtf_calle.getText()));
        mEmpleados.setTelefono((vEmpleados.jtf_telefono.getText()));
    }
    public void NuevoEmpleado(){
        vEmpleados.jtf_id.setText("");
        vEmpleados.jtf_nombre.setText("");
        vEmpleados.jtf_colonia.setText("");
        vEmpleados.jtf_calle.setText("");
        vEmpleados.jtf_telefono.setText("");
    }
    public void jbtn_anterior_Click(){
        mEmpleados.MoverAnterior();
        obtenerValor();
    }
    public void jbtn_eliminar_Click(){
        editarValor();
        mEmpleados.EliminarEmpleado();
    }
    public void jbtn_guardar_Click(){
        editarValor();
        mEmpleados.InsertarEmpleado();
    }
    public void jbtn_modificar_Click(){
        editarValor();
        mEmpleados.ModificarEmpleado();
    }
    public void jbtn_nuevo_Click(){
        NuevoEmpleado();
        mEmpleados.ConsultarEmpleado();
    }
    public void jbtn_primero_Click(){
        mEmpleados.MoverPrimero();
        obtenerValor();
    }
    public void jbtn_siguiente_Click(){
        mEmpleados.MoverSiguiente();
        obtenerValor();
    }
    public void jbtn_ultimo_Click(){
        mEmpleados.MoverUltimo();
        obtenerValor();
    }

    @Override
    public void keyTyped(KeyEvent e) {
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        mEmpleados.BuscarEmpleado("" + vEmpleados.jtf_buscar.getText());
        vEmpleados.jt_empleado.setModel(mEmpleados.getModelo());//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
         //To change body of generated methods, choose Tools | Templates.
    }
}
