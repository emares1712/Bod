/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

/**
 *
 * @author ninte
 */
public class ViewEmpleados extends javax.swing.JPanel {

    /**
     * Creates new form ViewEmpleados
     */
    public ViewEmpleados() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtf_buscar = new javax.swing.JTextField();
        jb_primero = new javax.swing.JButton();
        jl_colonia = new javax.swing.JLabel();
        jb_anterior = new javax.swing.JButton();
        jl_calle = new javax.swing.JLabel();
        jb_siguiente = new javax.swing.JButton();
        jl_telefono = new javax.swing.JLabel();
        jb_ultimo = new javax.swing.JButton();
        jtf_id = new javax.swing.JTextField();
        jb_nuevo = new javax.swing.JButton();
        jtf_nombre = new javax.swing.JTextField();
        jb_modificar = new javax.swing.JButton();
        jtf_colonia = new javax.swing.JTextField();
        jb_guardar = new javax.swing.JButton();
        jtf_calle = new javax.swing.JTextField();
        jb_eliminar = new javax.swing.JButton();
        jtf_telefono = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jt_empleado = new javax.swing.JTable();
        jl_buscar = new javax.swing.JLabel();
        jl_id = new javax.swing.JLabel();
        jl_Nombre = new javax.swing.JLabel();

        jb_primero.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jb_primero.setText("|<");

        jl_colonia.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jl_colonia.setText("Colonia");

        jb_anterior.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jb_anterior.setText("<<");

        jl_calle.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jl_calle.setText("Calle");

        jb_siguiente.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jb_siguiente.setText(">>");

        jl_telefono.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jl_telefono.setText("Telefono");

        jb_ultimo.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jb_ultimo.setText(">|");

        jb_nuevo.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jb_nuevo.setText("Nuevo");

        jb_modificar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jb_modificar.setText("Modificar");

        jb_guardar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jb_guardar.setText("Guardar");

        jb_eliminar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jb_eliminar.setText("Eliminar");

        jt_empleado.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jt_empleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jt_empleado);

        jl_buscar.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jl_buscar.setText("Busqueda");

        jl_id.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jl_id.setText("ID Empleado");

        jl_Nombre.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jl_Nombre.setText("Nombre del Empleado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jl_id)
                                        .addComponent(jl_Nombre)
                                        .addComponent(jl_colonia)
                                        .addComponent(jl_calle)
                                        .addComponent(jl_telefono))
                                    .addGap(27, 27, 27)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jtf_id, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jtf_nombre)
                                        .addComponent(jtf_colonia)
                                        .addComponent(jtf_calle)
                                        .addComponent(jtf_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(64, 64, 64)
                                    .addComponent(jl_buscar)
                                    .addGap(18, 18, 18)
                                    .addComponent(jtf_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(78, 78, 78)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jb_nuevo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jb_modificar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jb_guardar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jb_eliminar))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(jb_primero)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jb_anterior)
                                    .addGap(57, 57, 57)
                                    .addComponent(jb_siguiente)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jb_ultimo)))))
                    .addContainerGap(123, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(342, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtf_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jl_buscar))
                    .addGap(29, 29, 29)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jl_id)
                        .addComponent(jtf_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jl_Nombre)
                        .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jl_colonia)
                        .addComponent(jtf_colonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jl_calle)
                        .addComponent(jtf_calle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jl_telefono)
                        .addComponent(jtf_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jb_primero)
                        .addComponent(jb_anterior)
                        .addComponent(jb_siguiente)
                        .addComponent(jb_ultimo))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jb_nuevo)
                        .addComponent(jb_modificar)
                        .addComponent(jb_guardar)
                        .addComponent(jb_eliminar))
                    .addContainerGap(157, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JButton jb_anterior;
    public javax.swing.JButton jb_eliminar;
    public javax.swing.JButton jb_guardar;
    public javax.swing.JButton jb_modificar;
    public javax.swing.JButton jb_nuevo;
    public javax.swing.JButton jb_primero;
    public javax.swing.JButton jb_siguiente;
    public javax.swing.JButton jb_ultimo;
    public javax.swing.JLabel jl_Nombre;
    public javax.swing.JLabel jl_buscar;
    public javax.swing.JLabel jl_calle;
    public javax.swing.JLabel jl_colonia;
    public javax.swing.JLabel jl_id;
    public javax.swing.JLabel jl_telefono;
    public javax.swing.JTable jt_empleado;
    public javax.swing.JTextField jtf_buscar;
    public javax.swing.JTextField jtf_calle;
    public javax.swing.JTextField jtf_colonia;
    public javax.swing.JTextField jtf_id;
    public javax.swing.JTextField jtf_nombre;
    public javax.swing.JTextField jtf_telefono;
    // End of variables declaration//GEN-END:variables
}
