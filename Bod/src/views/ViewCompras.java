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
public class ViewCompras extends javax.swing.JPanel {

    /**
     * Creates new form ViewCompras
     */
    public ViewCompras() {
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

        jb_primero = new javax.swing.JButton();
        jl_buscar = new javax.swing.JLabel();
        jl_total = new javax.swing.JLabel();
        jb_anterior = new javax.swing.JButton();
        jtf_buscar = new javax.swing.JTextField();
        jtf_total = new javax.swing.JTextField();
        jb_siguiente = new javax.swing.JButton();
        jb_ultimo = new javax.swing.JButton();
        jb_nuevo = new javax.swing.JButton();
        jl_fecha = new javax.swing.JLabel();
        jb_modificar = new javax.swing.JButton();
        jtf_fecha = new javax.swing.JTextField();
        jb_guardar = new javax.swing.JButton();
        jb_eliminar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jt_detalle_compra = new javax.swing.JTable();
        jl_compra_id = new javax.swing.JLabel();
        jtf_compra = new javax.swing.JTextField();
        jl_proveedor = new javax.swing.JLabel();
        jtf_proveedor = new javax.swing.JTextField();

        jb_primero.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jb_primero.setText("|<");

        jl_buscar.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jl_buscar.setText("Busqueda");

        jl_total.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jl_total.setText("Total");

        jb_anterior.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jb_anterior.setText("<<");

        jtf_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtf_totalActionPerformed(evt);
            }
        });

        jb_siguiente.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jb_siguiente.setText(">>");

        jb_ultimo.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jb_ultimo.setText(">|");

        jb_nuevo.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jb_nuevo.setText("Nuevo");

        jl_fecha.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jl_fecha.setText("Fecha de la Compra");

        jb_modificar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jb_modificar.setText("Modificar");

        jb_guardar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jb_guardar.setText("Guardar");

        jb_eliminar.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jb_eliminar.setText("Eliminar");

        jt_detalle_compra.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jt_detalle_compra);

        jl_compra_id.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jl_compra_id.setText("Clave de la Compra");

        jl_proveedor.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 12)); // NOI18N
        jl_proveedor.setText("Proveedor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jl_compra_id)
                                    .addComponent(jl_proveedor))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtf_compra, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtf_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jl_fecha)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtf_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jl_total)
                                        .addGap(68, 68, 68)
                                        .addComponent(jtf_total, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jb_nuevo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jb_modificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jb_guardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jb_eliminar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addComponent(jb_primero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jb_anterior)
                                .addGap(36, 36, 36)
                                .addComponent(jb_siguiente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jb_ultimo)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(197, Short.MAX_VALUE)
                    .addComponent(jl_buscar)
                    .addGap(18, 18, 18)
                    .addComponent(jtf_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(144, 144, 144)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_fecha)
                    .addComponent(jtf_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_compra_id)
                    .addComponent(jtf_compra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jl_total)
                    .addComponent(jtf_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jl_proveedor)
                    .addComponent(jtf_proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_primero)
                    .addComponent(jb_anterior)
                    .addComponent(jb_siguiente)
                    .addComponent(jb_ultimo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jb_nuevo)
                    .addComponent(jb_modificar)
                    .addComponent(jb_guardar)
                    .addComponent(jb_eliminar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jl_buscar)
                        .addComponent(jtf_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(397, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtf_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtf_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtf_totalActionPerformed


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
    public javax.swing.JLabel jl_buscar;
    public javax.swing.JLabel jl_compra_id;
    public javax.swing.JLabel jl_fecha;
    public javax.swing.JLabel jl_proveedor;
    public javax.swing.JLabel jl_total;
    public javax.swing.JTable jt_detalle_compra;
    public javax.swing.JTextField jtf_buscar;
    public javax.swing.JTextField jtf_compra;
    public javax.swing.JTextField jtf_fecha;
    public javax.swing.JTextField jtf_proveedor;
    public javax.swing.JTextField jtf_total;
    // End of variables declaration//GEN-END:variables
}
