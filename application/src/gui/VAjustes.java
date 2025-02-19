/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * VPrincipal.java
 *
 * Created on 27-ene-2011, 10:31:24
 */

package gui;
import aplicacion.*;
import java.awt.Component;
import javax.swing.text.html.HTMLEditorKit;


/**
 *
 * @author grupo2b
 */
public class VAjustes extends javax.swing.JFrame {
  
    aplicacion.FachadaAplicacion fa;
    UsuarioUSC miembroUSC;
    private Vehiculo vehiculo;
    
    /** Creates new form VPrincipal */
    public VAjustes(aplicacion.FachadaAplicacion fa) {
        this.fa=fa;
        initComponents();
    }
    
    public void setMiembroUSC(UsuarioUSC usuario){
        this.miembroUSC = usuario;
        // Actualizamos la información de los ajustes
        this.jLabelInfoPersonal.setText( "<html>DNI=" + usuario.getDniUsuario()  + "<br>"
                + "Nombre=" + usuario.getNombreCompleto()   + "<br>"
                + "CorreoElectronico=" + usuario.getCorreoElectronico()  + "<br>"
                + "Contrasenha= ********"  + "<br>"
                + "Telefono=" + usuario.getTelefono()   + "<br>"
                + "Saldo=" + usuario.getSaldo()   + "<br>"
                + "FechaIngreso=" + usuario.getFechaIngreso() + "</html>");
        
        String textoVehiculos = "<html>";
        for(Vehiculo v : usuario.getVehiculos()){
            textoVehiculos += ("<br>---------------------------------------------<br>Matricula=" + v.getMatricula() + "<br>"
                + "Tipo=" + v.getTipo() + "<br>"
                + "Marca=" + v.getMarca() + "<br>"
                + "Modelo=" + v.getModelo() + "<br>"
                + "NumeroInfracciones=" + v.getNumeroInfracciones());
        }
        textoVehiculos += "</html>";
        
        // Usa un HTMLEditorKit para renderizar HTML en el JEditorPane
        this.jEditorPane1.setEditorKit(new HTMLEditorKit());
        this.jEditorPane1.setText(textoVehiculos);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelInfoPersonal = new javax.swing.JLabel();
        jLabelVehiculos1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jButtonAnhadirVehiculo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jTextFieldTipo = new javax.swing.JTextField();
        jTextFieldMarca = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jTextFieldModelo = new javax.swing.JTextField();
        jButtonAnhadir = new javax.swing.JButton();
        jTextFieldMatricula = new javax.swing.JTextField();
        jLabelErrorAnhadirVehiculo = new javax.swing.JLabel();
        panelAzul = new java.awt.Panel();
        jLabelCoche = new javax.swing.JLabel();
        jButtonSalir = new javax.swing.JButton();
        jButtonAtras = new javax.swing.JButton();
        jLabelParkingUSC1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Parking USC");
        setForeground(new java.awt.Color(51, 204, 255));
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setName("vPrincipal"); // NOI18N
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setMaximumSize(new java.awt.Dimension(800, 500));
        background.setMinimumSize(new java.awt.Dimension(800, 500));
        background.setPreferredSize(new java.awt.Dimension(800, 500));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 24)); // NOI18N
        jLabel1.setText("Vehículos");

        jLabelInfoPersonal.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabelInfoPersonal.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabelVehiculos1.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 24)); // NOI18N
        jLabelVehiculos1.setText("Información personal");

        jEditorPane1.setBorder(null);
        jEditorPane1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(jEditorPane1);

        jButtonAnhadirVehiculo.setBackground(new java.awt.Color(204, 204, 204));
        jButtonAnhadirVehiculo.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jButtonAnhadirVehiculo.setText("<html>Añadir Vehiculo</html>");
        jButtonAnhadirVehiculo.setToolTipText("");
        jButtonAnhadirVehiculo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonAnhadirVehiculo.setMaximumSize(new java.awt.Dimension(90, 40));
        jButtonAnhadirVehiculo.setMinimumSize(new java.awt.Dimension(90, 40));
        jButtonAnhadirVehiculo.setPreferredSize(new java.awt.Dimension(90, 40));
        jButtonAnhadirVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnhadirVehiculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelVehiculos1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelInfoPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonAnhadirVehiculo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabelVehiculos1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelInfoPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAnhadirVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 24)); // NOI18N
        jLabel2.setText("Añadir un vehículo");

        jLabel3.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        jLabel3.setText("Modelo");

        jLabel4.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        jLabel4.setText("Matrícula");

        jLabel5.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        jLabel5.setText("Tipo");

        jLabel6.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        jLabel6.setText("Marca");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        jTextFieldTipo.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jTextFieldTipo.setBorder(null);
        jTextFieldTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTipoActionPerformed(evt);
            }
        });

        jTextFieldMarca.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jTextFieldMarca.setBorder(null);
        jTextFieldMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMarcaActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));

        jTextFieldModelo.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jTextFieldModelo.setBorder(null);
        jTextFieldModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldModeloActionPerformed(evt);
            }
        });

        jButtonAnhadir.setBackground(new java.awt.Color(204, 204, 204));
        jButtonAnhadir.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jButtonAnhadir.setText("<html>Añadir</html>");
        jButtonAnhadir.setToolTipText("");
        jButtonAnhadir.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonAnhadir.setMaximumSize(new java.awt.Dimension(90, 40));
        jButtonAnhadir.setMinimumSize(new java.awt.Dimension(90, 40));
        jButtonAnhadir.setPreferredSize(new java.awt.Dimension(90, 40));
        jButtonAnhadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnhadirActionPerformed(evt);
            }
        });

        jTextFieldMatricula.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jTextFieldMatricula.setBorder(null);
        jTextFieldMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMatriculaActionPerformed(evt);
            }
        });

        jLabelErrorAnhadirVehiculo.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErrorAnhadirVehiculo.setText("Faltan campos por rellenar!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(jButtonAnhadir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldMarca, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelErrorAnhadirVehiculo))))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldModelo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextFieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(7, 7, 7))))
                        .addContainerGap(42, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButtonAnhadir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabelErrorAnhadirVehiculo))
                .addGap(7, 7, 7)
                .addComponent(jTextFieldMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(3, 3, 3)
                .addComponent(jTextFieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabelErrorAnhadirVehiculo.setVisible(false);

        jTabbedPane1.addTab("tab1", jPanel2);

        background.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, -30, 500, 530));

        panelAzul.setBackground(new java.awt.Color(153, 204, 255));
        panelAzul.setForeground(new java.awt.Color(0, 0, 0));
        panelAzul.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCoche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/coche.png"))); // NOI18N
        panelAzul.add(jLabelCoche, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jButtonSalir.setBackground(new java.awt.Color(204, 204, 204));
        jButtonSalir.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jButtonSalir.setText("<html>Salir</html>");
        jButtonSalir.setToolTipText("");
        jButtonSalir.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonSalir.setMaximumSize(new java.awt.Dimension(90, 40));
        jButtonSalir.setMinimumSize(new java.awt.Dimension(90, 40));
        jButtonSalir.setPreferredSize(new java.awt.Dimension(90, 40));
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        panelAzul.add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 90, 40));

        jButtonAtras.setBackground(new java.awt.Color(204, 204, 204));
        jButtonAtras.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jButtonAtras.setText("<html>Atrás</html>");
        jButtonAtras.setToolTipText("");
        jButtonAtras.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonAtras.setMaximumSize(new java.awt.Dimension(90, 40));
        jButtonAtras.setMinimumSize(new java.awt.Dimension(90, 40));
        jButtonAtras.setPreferredSize(new java.awt.Dimension(90, 40));
        jButtonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtrasActionPerformed(evt);
            }
        });
        panelAzul.add(jButtonAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 90, 40));

        jLabelParkingUSC1.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 36)); // NOI18N
        jLabelParkingUSC1.setText("PARKING USC");
        panelAzul.add(jLabelParkingUSC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 220, -1));

        background.add(panelAzul, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("Biblioteca Informática");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtrasActionPerformed
        // TODO add your handling code here:
        // Se vuelve a instanciar la ventana principal y se asigna el miembro
        VPrincipal vp = new VPrincipal(this.fa);
        vp.setMiembroUSC(this.miembroUSC);
        // La nueva ventana tiene la misma posicion que la anterior
        this.dispose();
        vp.setLocation(this.getLocation());
        vp.setVisible(true);
    }//GEN-LAST:event_jButtonAtrasActionPerformed

    private void jButtonAnhadirVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnhadirVehiculoActionPerformed
        // TODO add your handling code here:
        // Cambia de pestanha
        // Obtener el componente de la segunda pestaña
        Component componente = this.jTabbedPane1.getComponentAt(1);

        // Cambiar a la segunda pestaña
        this.jTabbedPane1.setSelectedComponent(componente);
    }//GEN-LAST:event_jButtonAnhadirVehiculoActionPerformed

    private void jTextFieldTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTipoActionPerformed

    private void jTextFieldMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMatriculaActionPerformed

    private void jTextFieldModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldModeloActionPerformed

    private void jTextFieldMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMarcaActionPerformed

    private void jButtonAnhadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnhadirActionPerformed
        // TODO add your handling code here:
        // Asignamos los datos del vehiculo
        if(this.jTextFieldMatricula.getText()==null || this.jTextFieldMatricula.getText().equals("") || this.jTextFieldMatricula.getText().equals(" ") ||
                this.jTextFieldTipo.getText()==null || this.jTextFieldTipo.getText().equals("") || this.jTextFieldTipo.getText().equals(" ") ||
                this.jTextFieldMarca.getText()==null || this.jTextFieldMarca.getText().equals("") || this.jTextFieldMarca.getText().equals(" ") ||
                this.jTextFieldModelo.getText()==null || this.jTextFieldModelo.getText().equals("") || this.jTextFieldModelo.getText().equals(" ")){
            
            this.jLabelErrorAnhadirVehiculo.setVisible(true);
            return;
        }
        this.jLabelErrorAnhadirVehiculo.setVisible(false);
        
        this.vehiculo = new Vehiculo(this.jTextFieldMatricula.getText(), this.jTextFieldTipo.getText(), this.jTextFieldMarca.getText(), this.jTextFieldModelo.getText(), 0);
        
        // Intentamos anhadir el vehiculo a la base de datos
        if(fa.getFachadaBaseDatos().anhadirVehiculo(miembroUSC, vehiculo) == true){
        this.miembroUSC.getVehiculos().add(vehiculo);
        /// -------------------- ACTUALIZAR LOS DATOS DEL USUARIO --------------
        this.miembroUSC.setVehiculos(fa.getFachadaBaseDatos().vehiculosUsuario(this.miembroUSC));
        
        
        // Mostrar ventana aviso de añadido
           VAvisoCompletado vc = new VAvisoCompletado(this.fa, "Vehiculo añadido correctamente");
        // La nueva ventana tiene la misma posicion que la anterior
        this.jButtonAtras.doClick();
        vc.setVisible(true);
    }else{
            // Mostrar ventana aviso de pagado
           VAvisoCompletado vc = new VAvisoCompletado(this.fa, "Datos de vehiculo incorrectos");
        // La nueva ventana tiene la misma posicion que la anterior
        this.jButtonAtras.doClick();
        vc.setVisible(true);
        }
        
        
        
        
    }//GEN-LAST:event_jButtonAnhadirActionPerformed

    /**
    * @param args the command line arguments
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton jButtonAnhadir;
    private javax.swing.JButton jButtonAnhadirVehiculo;
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelCoche;
    private javax.swing.JLabel jLabelErrorAnhadirVehiculo;
    private javax.swing.JLabel jLabelInfoPersonal;
    private javax.swing.JLabel jLabelParkingUSC1;
    private javax.swing.JLabel jLabelVehiculos1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextFieldMarca;
    private javax.swing.JTextField jTextFieldMatricula;
    private javax.swing.JTextField jTextFieldModelo;
    private javax.swing.JTextField jTextFieldTipo;
    private java.awt.Panel panelAzul;
    // End of variables declaration//GEN-END:variables

    
}
