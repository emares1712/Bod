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
public class ViewProductos extends javax.swing.JPanel {

    /**
     * Creates new form ViewProductos
     */
    public ViewProductos() {
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

        jb_eliminar = new javax.swing.JButton();
        jtf_precio_venta = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jt_productos = new javax.swing.JTable();
        jtf_precio_compra = new javax.swing.JTextField();
        jl_id_Producto = new javax.swing.JLabel();
        jtf_existencias = new javax.swing.JTextField();
        jl_Nombre = new javax.swing.JLabel();
        jb_primero = new javax.swing.JButton();
        jl_buscar = new javax.swing.JLabel();
        jl_descripcion = new javax.swing.JLabel();
        jb_anterior = new javax.swing.JButton();
        jtf_buscar = new javax.swing.JTextField();
        jl_precio_venta = new javax.swing.JLabel();
        jb_siguiente = new javax.swing.JButton();
        jl_precio_compra = new javax.swing.JLabel();
        jb_ultimo = new javax.swing.JButton();
        jl_existencias = new javax.swing.JLabel();
        jb_nuevo = new javax.swing.JButton();
        jtf_id_producto = new javax.swing.JTextField();
        jb_guardar = new javax.swing.JButton();
        jtf_nombre = new javax.swing.JTextField();
        jb_modificar = new javax.swing.JButton();
        jtf_descripcion = new javax.swing.JTextField();

        jb_eliminar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jb_eliminar.setText("Eliminar");

        jt_productos.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jt_productos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jt_productos);

        jl_id_Producto.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jl_id_Producto.setText("ID del Producto");

        jl_Nombre.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jl_Nombre.setText("Nombre del Producto");

        jb_primero.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jb_primero.setText("|<");

        jl_buscar.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jl_buscar.setText("Busqueda");

        jl_descripcion.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jl_descripcion.setText("Descripción");

        jb_anterior.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jb_anterior.setText("<<");

        jl_precio_venta.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jl_precio_venta.setText("Precio Venta");

        jb_siguiente.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jb_siguiente.setText(">>");

        jl_precio_compra.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jl_precio_compra.setText("Precio Compra");

        jb_ultimo.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jb_ultimo.setText(">|");

        jl_existencias.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jl_existencias.setText("Existencias");

        jb_nuevo.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jb_nuevo.setText("Nuevo");

        jb_guardar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jb_guardar.setText("Guardar");

        jb_modificar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jb_modificar.setText("Modificar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(143, 143, 143)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jb_nuevo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jb_guardar)
                            .addGap(18, 18, 18)
                            .addComponent(jb_modificar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jb_eliminar))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jb_primero)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jb_anterior)
                            .addGap(86, 86, 86)
                            .addComponent(jb_siguiente)
                            .addGap(18, 18, 18)
                            .addComponent(jb_ultimo)))
                    .addGap(118, 118, 118))
                .addGroup(layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jl_id_Producto)
                            .addGap(44, 44, 44)
                            .addComponent(jtf_id_producto, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jl_descripcion)
                            .addGap(18, 18, 18)
                            .addComponent(jtf_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jl_precio_compra)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtf_precio_compra, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jl_precio_venta)
                            .addGap(12, 12, 12)
                            .addComponent(jtf_precio_venta, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(51, 51, 51)
                            .addComponent(jl_existencias)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jtf_existencias, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl_buscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtf_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jl_Nombre)
                                .addGap(18, 18, 18)
                                .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(325, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jl_buscar)
                        .addComponent(jtf_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jl_id_Producto)
                        .addComponent(jtf_id_producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jl_Nombre)
                        .addComponent(jtf_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jl_descripcion)
                            .addGap(38, 38, 38)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jl_precio_venta)
                                .addComponent(jtf_precio_venta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jtf_descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jl_precio_compra)
                        .addComponent(jtf_precio_compra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jl_existencias)
                        .addComponent(jtf_existencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jb_primero)
                        .addComponent(jb_anterior)
                        .addComponent(jb_siguiente)
                        .addComponent(jb_ultimo))
                    .addGap(26, 26, 26)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jb_nuevo)
                        .addComponent(jb_guardar)
                        .addComponent(jb_modificar)
                        .addComponent(jb_eliminar))
                    .addContainerGap(181, Short.MAX_VALUE)))
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
    public javax.swing.JLabel jl_descripcion;
    public javax.swing.JLabel jl_existencias;
    public javax.swing.JLabel jl_id_Producto;
    public javax.swing.JLabel jl_precio_compra;
    public javax.swing.JLabel jl_precio_venta;
    public javax.swing.JTable jt_productos;
    public javax.swing.JTextField jtf_buscar;
    public javax.swing.JTextField jtf_descripcion;
    public javax.swing.JTextField jtf_existencias;
    public javax.swing.JTextField jtf_id_producto;
    public javax.swing.JTextField jtf_nombre;
    public javax.swing.JTextField jtf_precio_compra;
    public javax.swing.JTextField jtf_precio_venta;
    // End of variables declaration//GEN-END:variables
}