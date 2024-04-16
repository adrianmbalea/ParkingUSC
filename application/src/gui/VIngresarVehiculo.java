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
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JButton;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.awt.Component;
import java.sql.Timestamp;




/**
 *
 * @author grupo2b
 */
public class VIngresarVehiculo extends javax.swing.JFrame {
  
    private aplicacion.FachadaAplicacion fa;
    private UsuarioUSC miembroUSC;
    private String campusSeleccionado;
    private String centroSeleccionado;
    private Parking parking;
    private Timestamp fecha;
    private ArrayList<JButton> plazas;
    
    private ArrayList<Aparcar> vehiculosAparcados;
    private ArrayList<Vehiculo> vehiculosLibres;
    private Vehiculo vehiculoParaAparcar;
    private int idPlazaParaAparcar;
    private Color colorSeleccionado;
    private String tipo;

    
    /** Creates new form VPrincipal */
    public VIngresarVehiculo(aplicacion.FachadaAplicacion fa) {
        initComponents();
        Component componente = this.jTabbedPane1.getComponent(2);
        this.jTabbedPane1.setSelectedComponent(componente);
        this.fa=fa;
        this.plazas = new ArrayList<>(Arrays.asList(jButton01, jButton02, jButton03, jButton04, 
      jButton05, jButton06, jButton07,jButton08, jButton09, jButton10, jButton11, jButton12, jButton13, 
      jButton14, jButton15, jButton16, jButton17, jButton18, jButton19, jButton20, jButton21, jButton22));
        this.inicializarComboBox();
    }
    
    public void setMiembroUSC(UsuarioUSC usuario){
        this.miembroUSC = usuario;
    
       actualizarSaldo();
        vehiculosAparcados = fa.getFachadaBaseDatos().vehiculosAparcados(usuario);
        // Retirar los vehiculos aparcados de los vehiculos que se muestran disponibles para seleccionar
        ArrayList<Vehiculo> vehiculosNoAparcados = new ArrayList<>();
        vehiculosNoAparcados.addAll(this.miembroUSC.getVehiculos());
        for(Aparcar aparcado  : vehiculosAparcados){
            for(int i = 0; i<vehiculosNoAparcados.size(); i++){
                Vehiculo v = vehiculosNoAparcados.get(i);
                if(aparcado.getVehiculo().getMatricula().equals(v.getMatricula())){
                    vehiculosNoAparcados.remove(i);
                }
            }
        }
        this.vehiculosLibres = vehiculosNoAparcados;
        
        for(Vehiculo vehiculo : vehiculosLibres){
            String texto = "<html>";
            texto += vehiculo.getTipo() + ": <br>";
            texto += "Matricula: " + vehiculo.getMatricula()  + " <br>";
            texto +=  "Marca: " + vehiculo.getMarca() + "<br>";
            texto +=  "Modelo: " + vehiculo.getModelo() + "</html>";
            this.jComboBoxSeleccionarVehiculo.addItem(texto);
        }
    }
    
    public void actualizarSaldo(){
        this.jLabelSaldo.setText("Saldo: " + this.miembroUSC.getSaldo() + "€");
    }

    public UsuarioUSC getMiembroUSC() {
        return miembroUSC;
    }


    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
  

    public Timestamp getFecha() {
        return fecha;
    }

    public void setParking(Parking parking) {
        this.parking = parking;
    }

    public Parking getParking() {
        return parking;
    }
    
    public void setCampusSeleccionado(String campusSeleccionado) {
        this.campusSeleccionado = campusSeleccionado;
    }

    public void setCentroSeleccionado(String centroSeleccionado) {
        this.centroSeleccionado = centroSeleccionado;
    }

    public String getCampusSeleccionado() {
        return campusSeleccionado;
    }

    public String getCentroSeleccionado() {
        return centroSeleccionado;
    }
    

    public ArrayList<JButton> getPlazas() {
        return plazas;
    }
    
    // Funciones JPanelSeleccionarParking
    private void inicializarComboBox(){
        jComboBoxCampus.removeAllItems();
        ArrayList<Campus> listaCampus = fa.listarCampus();
        for(Campus c: listaCampus){
            jComboBoxCampus.addItem(c.getNombre());
        }
        jComboBoxCampus.setSelectedIndex(-1);
        jComboBoxCampus.setSelectedItem(null);
        this.setCampusSeleccionado(null);
        jComboBoxCampus.setSize(72, 23);
        jComboBoxCentro.setSelectedIndex(-1);
        jComboBoxCentro.setSelectedItem(null);
        this.setCentroSeleccionado(null);
        jComboBoxCentro.setSize(72, 23);
    }
    
    
    public void actualizarBotones(){
        if(fecha == null){
            for(int i=0; i<this.getPlazas().size(); i++){
                JButton boton = this.getPlazas().get(i);
                boton.setBackground(Color.BLACK);
            }
            return;
        }
        for(int i=0; i<this.getPlazas().size(); i++){
            JButton boton = this.getPlazas().get(i);
            //System.out.println("Plaza "+(i+1)+": "+fa.verPlaza(i+1, this.getParking(), this.getFecha()));
            switch(fa.verPlaza(i+1, this.getParking(), this.getFecha(), this.getFecha())){
                case "libre":
                    boton.setBackground(Color.GREEN);
                    break;
                case "ocupada":
                    boton.setBackground(Color.RED);
                    break;
                case "reservada":
                    boton.setBackground(Color.BLUE);
                    break;
                case "asignada":
                    boton.setBackground(Color.ORANGE);
                    break;
                default:
                    boton.setBackground(Color.BLACK);
                    break;
                
            }
            
            if(boton.getBackground().equals(Color.GREEN)){
                if(fa.getFachadaBaseDatos().verTipoPlaza(i + 1, this.getParking()).equals("privada")){
                    boton.setBackground(Color.GRAY);
                }
            }
            
        }
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
        jPanelVerParking = new javax.swing.JPanel();
        jLabelVerParking = new javax.swing.JLabel();
        jButton18 = new javax.swing.JButton();
        jButton02 = new javax.swing.JButton();
        jButton03 = new javax.swing.JButton();
        jButton04 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton01 = new javax.swing.JButton();
        jButton06 = new javax.swing.JButton();
        jButton05 = new javax.swing.JButton();
        jButton07 = new javax.swing.JButton();
        jButton08 = new javax.swing.JButton();
        jButton09 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonSeleccionarPlaza = new javax.swing.JButton();
        jLabelProblemaPlaza = new javax.swing.JLabel();
        jPanelSeleccionarParking = new javax.swing.JPanel();
        jLabelParkingUSC = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxCampus = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxCentro = new javax.swing.JComboBox<>();
        jButtonSeleccionar = new javax.swing.JButton();
        jLabelErrorComboBox = new javax.swing.JLabel();
        jJPanelSeleccionarVehiculo = new javax.swing.JPanel();
        jLabelSeleccionarVehiculo = new javax.swing.JLabel();
        jLabelSaldo = new javax.swing.JLabel();
        jComboBoxSeleccionarVehiculo = new javax.swing.JComboBox<>();
        jButtonSeleccionarVehiculo = new javax.swing.JButton();
        panelAzul = new java.awt.Panel();
        jLabelCoche = new javax.swing.JLabel();
        jButtonAtras = new javax.swing.JButton();
        jLabelParkingUSC1 = new javax.swing.JLabel();
        jButtonSalir1 = new javax.swing.JButton();

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

        jPanelVerParking.setBackground(new java.awt.Color(255, 255, 255));
        jPanelVerParking.setForeground(new java.awt.Color(255, 255, 255));

        jLabelVerParking.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 24)); // NOI18N
        jLabelVerParking.setText("Seleccionar Plaza");

        jButton18.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jButton18.setText("18");
        jButton18.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton02.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jButton02.setText("02");
        jButton02.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton02ActionPerformed(evt);
            }
        });

        jButton03.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jButton03.setText("03");
        jButton03.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton03ActionPerformed(evt);
            }
        });

        jButton04.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jButton04.setText("04");
        jButton04.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton04ActionPerformed(evt);
            }
        });

        jButton22.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jButton22.setText("22");
        jButton22.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton01.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jButton01.setText("01");
        jButton01.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton01ActionPerformed(evt);
            }
        });

        jButton06.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jButton06.setText("06");
        jButton06.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton06ActionPerformed(evt);
            }
        });

        jButton05.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jButton05.setText("05");
        jButton05.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton05ActionPerformed(evt);
            }
        });

        jButton07.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jButton07.setText("07");
        jButton07.setToolTipText("");
        jButton07.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton07ActionPerformed(evt);
            }
        });

        jButton08.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jButton08.setText("08");
        jButton08.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton08ActionPerformed(evt);
            }
        });

        jButton09.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jButton09.setText("09");
        jButton09.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton09ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jButton10.setText("10");
        jButton10.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jButton11.setText("11");
        jButton11.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jButton12.setText("12");
        jButton12.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jButton13.setText("13");
        jButton13.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jButton14.setText("14");
        jButton14.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jButton15.setText("15");
        jButton15.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jButton16.setText("16");
        jButton16.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jButton17.setText("17");
        jButton17.setToolTipText("");
        jButton17.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton19.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jButton19.setText("19");
        jButton19.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jButton20.setText("20");
        jButton20.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jButton21.setText("21");
        jButton21.setToolTipText("");
        jButton21.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButtonSeleccionarPlaza.setBackground(new java.awt.Color(204, 204, 204));
        jButtonSeleccionarPlaza.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jButtonSeleccionarPlaza.setText("<html>Seleccionar</html>");
        jButtonSeleccionarPlaza.setToolTipText("");
        jButtonSeleccionarPlaza.setActionCommand("");
        jButtonSeleccionarPlaza.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonSeleccionarPlaza.setMaximumSize(new java.awt.Dimension(90, 40));
        jButtonSeleccionarPlaza.setMinimumSize(new java.awt.Dimension(90, 40));
        jButtonSeleccionarPlaza.setPreferredSize(new java.awt.Dimension(90, 40));
        jButtonSeleccionarPlaza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeleccionarPlazaActionPerformed(evt);
            }
        });

        jLabelProblemaPlaza.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanelVerParkingLayout = new javax.swing.GroupLayout(jPanelVerParking);
        jPanelVerParking.setLayout(jPanelVerParkingLayout);
        jPanelVerParkingLayout.setHorizontalGroup(
            jPanelVerParkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVerParkingLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanelVerParkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelVerParkingLayout.createSequentialGroup()
                        .addGroup(jPanelVerParkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelVerParkingLayout.createSequentialGroup()
                                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButton18)
                                .addGap(34, 34, 34)
                                .addComponent(jButton20)
                                .addGap(4, 4, 4)
                                .addComponent(jButton21)
                                .addGap(4, 4, 4)
                                .addComponent(jButton22))
                            .addGroup(jPanelVerParkingLayout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(jButton19)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(jButtonSeleccionarPlaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelProblemaPlaza, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelVerParkingLayout.createSequentialGroup()
                        .addGroup(jPanelVerParkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelVerParkingLayout.createSequentialGroup()
                                .addComponent(jButton01, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButton02, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButton03, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButton04, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelVerParkingLayout.createSequentialGroup()
                                .addComponent(jButton06, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButton07, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButton08, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButton09, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelVerParkingLayout.createSequentialGroup()
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelVerParkingLayout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addGroup(jPanelVerParkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton05, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabelVerParking, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(51, 51, 51))
        );
        jPanelVerParkingLayout.setVerticalGroup(
            jPanelVerParkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVerParkingLayout.createSequentialGroup()
                .addGap(0, 59, Short.MAX_VALUE)
                .addGroup(jPanelVerParkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonSeleccionarPlaza, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelVerParkingLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelVerParking)
                        .addGap(15, 15, 15)
                        .addGroup(jPanelVerParkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelVerParkingLayout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelVerParkingLayout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton05, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelVerParkingLayout.createSequentialGroup()
                                .addGroup(jPanelVerParkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelVerParkingLayout.createSequentialGroup()
                                        .addGroup(jPanelVerParkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton01, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton02, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton03, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton04, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanelVerParkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton06, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton07, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton08, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton09, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanelVerParkingLayout.createSequentialGroup()
                                        .addGap(66, 66, 66)
                                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(10, 10, 10)
                                .addGroup(jPanelVerParkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanelVerParkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelProblemaPlaza, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 68, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", jPanelVerParking);

        jPanelSeleccionarParking.setBackground(new java.awt.Color(255, 255, 255));

        jLabelParkingUSC.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 36)); // NOI18N
        jLabelParkingUSC.setText("Seleccionar Parking");

        jLabel3.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabel3.setText("Campus:");

        jComboBoxCampus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCampusActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabel4.setText("Centro:");

        jComboBoxCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCentroActionPerformed(evt);
            }
        });

        jButtonSeleccionar.setBackground(new java.awt.Color(204, 204, 204));
        jButtonSeleccionar.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jButtonSeleccionar.setText("<html>Seleccionar</html>");
        jButtonSeleccionar.setToolTipText("");
        jButtonSeleccionar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonSeleccionar.setMaximumSize(new java.awt.Dimension(90, 40));
        jButtonSeleccionar.setMinimumSize(new java.awt.Dimension(90, 40));
        jButtonSeleccionar.setPreferredSize(new java.awt.Dimension(90, 40));
        jButtonSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeleccionarActionPerformed(evt);
            }
        });

        jLabelErrorComboBox.setFont(new java.awt.Font("Roboto Medium", 0, 13)); // NOI18N
        jLabelErrorComboBox.setForeground(new java.awt.Color(255, 0, 0));
        jLabelErrorComboBox.setText("Debes cubrir los dos campos!");

        javax.swing.GroupLayout jPanelSeleccionarParkingLayout = new javax.swing.GroupLayout(jPanelSeleccionarParking);
        jPanelSeleccionarParking.setLayout(jPanelSeleccionarParkingLayout);
        jPanelSeleccionarParkingLayout.setHorizontalGroup(
            jPanelSeleccionarParkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSeleccionarParkingLayout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addGroup(jPanelSeleccionarParkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSeleccionarParkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSeleccionarParkingLayout.createSequentialGroup()
                            .addGroup(jPanelSeleccionarParkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jLabelParkingUSC))
                            .addGap(115, 115, 115))
                        .addGroup(jPanelSeleccionarParkingLayout.createSequentialGroup()
                            .addGroup(jPanelSeleccionarParkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jComboBoxCentro, javax.swing.GroupLayout.Alignment.LEADING, 0, 320, Short.MAX_VALUE)
                                .addComponent(jComboBoxCampus, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addContainerGap()))
                    .addGroup(jPanelSeleccionarParkingLayout.createSequentialGroup()
                        .addComponent(jLabelErrorComboBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
        );
        jPanelSeleccionarParkingLayout.setVerticalGroup(
            jPanelSeleccionarParkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSeleccionarParkingLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabelParkingUSC)
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxCampus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelSeleccionarParkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSeleccionarParkingLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxCentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 110, Short.MAX_VALUE))
                    .addGroup(jPanelSeleccionarParkingLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelSeleccionarParkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelErrorComboBox))))
                .addGap(41, 41, 41))
        );

        jLabelErrorComboBox.setVisible(false);

        jTabbedPane1.addTab("tab2", jPanelSeleccionarParking);

        jJPanelSeleccionarVehiculo.setBackground(new java.awt.Color(255, 255, 255));

        jLabelSeleccionarVehiculo.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 24)); // NOI18N
        jLabelSeleccionarVehiculo.setText("Seleccionar Vehículo");

        jLabelSaldo.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        jLabelSaldo.setText("Saldo:");

        jComboBoxSeleccionarVehiculo.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jComboBoxSeleccionarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSeleccionarVehiculoActionPerformed(evt);
            }
        });

        jButtonSeleccionarVehiculo.setBackground(new java.awt.Color(204, 204, 204));
        jButtonSeleccionarVehiculo.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jButtonSeleccionarVehiculo.setText("<html>Seleccionar</html>");
        jButtonSeleccionarVehiculo.setToolTipText("");
        jButtonSeleccionarVehiculo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonSeleccionarVehiculo.setMaximumSize(new java.awt.Dimension(90, 40));
        jButtonSeleccionarVehiculo.setMinimumSize(new java.awt.Dimension(90, 40));
        jButtonSeleccionarVehiculo.setPreferredSize(new java.awt.Dimension(90, 40));
        jButtonSeleccionarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSeleccionarVehiculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jJPanelSeleccionarVehiculoLayout = new javax.swing.GroupLayout(jJPanelSeleccionarVehiculo);
        jJPanelSeleccionarVehiculo.setLayout(jJPanelSeleccionarVehiculoLayout);
        jJPanelSeleccionarVehiculoLayout.setHorizontalGroup(
            jJPanelSeleccionarVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jJPanelSeleccionarVehiculoLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabelSeleccionarVehiculo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jJPanelSeleccionarVehiculoLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jJPanelSeleccionarVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonSeleccionarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxSeleccionarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        jJPanelSeleccionarVehiculoLayout.setVerticalGroup(
            jJPanelSeleccionarVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jJPanelSeleccionarVehiculoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabelSaldo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelSeleccionarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxSeleccionarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(jButtonSeleccionarVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );

        jTabbedPane1.addTab("tab3", jJPanelSeleccionarVehiculo);

        background.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, -30, 490, 530));

        panelAzul.setBackground(new java.awt.Color(153, 204, 255));
        panelAzul.setForeground(new java.awt.Color(0, 0, 0));
        panelAzul.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelCoche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/coche.png"))); // NOI18N
        panelAzul.add(jLabelCoche, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jButtonAtras.setBackground(new java.awt.Color(204, 204, 204));
        jButtonAtras.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jButtonAtras.setToolTipText("");
        jButtonAtras.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonAtras.setLabel("<html>Atrás</html>");
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

        jButtonSalir1.setBackground(new java.awt.Color(204, 204, 204));
        jButtonSalir1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jButtonSalir1.setText("<html>Salir</html>");
        jButtonSalir1.setToolTipText("");
        jButtonSalir1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonSalir1.setMaximumSize(new java.awt.Dimension(90, 40));
        jButtonSalir1.setMinimumSize(new java.awt.Dimension(90, 40));
        jButtonSalir1.setPreferredSize(new java.awt.Dimension(90, 40));
        jButtonSalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalir1ActionPerformed(evt);
            }
        });
        panelAzul.add(jButtonSalir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 90, 40));

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

    private void jButtonSalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalir1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButtonSalir1ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
         this.idPlazaParaAparcar = 21;
        this.colorSeleccionado = this.jButton21.getBackground();
        this.tipo = "moto";
        
        this.jLabelProblemaPlaza.setText("Plaza seleccionada: " + 21);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButtonSeleccionarPlazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSeleccionarPlazaActionPerformed
        // TODO add your handling code here:
        
        // Se comprueba que la plaza seleccionada es válida
        if(this.colorSeleccionado != null){
        if(this.colorSeleccionado.equals(Color.RED)){
            this.jLabelProblemaPlaza.setForeground(Color.RED);
            this.jLabelProblemaPlaza.setText("La plaza seleccionada está ocupada !");
            this.jLabelProblemaPlaza.setVisible(true);
        }else if(this.colorSeleccionado.equals(Color.BLUE)){
            this.jLabelProblemaPlaza.setForeground(Color.RED);
            this.jLabelProblemaPlaza.setText("La plaza seleccionada está reservada !");
            this.jLabelProblemaPlaza.setVisible(true);
            this.jLabelProblemaPlaza.setForeground(Color.RED);
        }else if(this.colorSeleccionado.equals(Color.ORANGE)){
            this.jLabelProblemaPlaza.setForeground(Color.RED);
            this.jLabelProblemaPlaza.setText("La plaza seleccionada está asignada !");
            this.jLabelProblemaPlaza.setVisible(true);
        }else if(this.colorSeleccionado.equals(Color.GRAY)){
            this.jLabelProblemaPlaza.setForeground(Color.RED);
            this.jLabelProblemaPlaza.setText("La plaza seleccionada es privada !");
            this.jLabelProblemaPlaza.setVisible(true);
        }else if(this.colorSeleccionado.equals(Color.GREEN)){
            this.jLabelProblemaPlaza.setVisible(false);
            // Creamos la relación aparcar y la insertamos en la base de datos
            // Obtiene la fecha acutual para la relacion aparcar
            Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
            
            Aparcar aparcar = new Aparcar(fechaActual, null, 1.4f, 
                    this.vehiculoParaAparcar, this.parking.getCampus(), this.parking.getCentro(), this.idPlazaParaAparcar);
            
            if(fa.getFachadaBaseDatos().aparcarVehiculo(aparcar) == true){
                
                // Mostrar ventana aviso de pagado
           VAvisoCompletado vc = new VAvisoCompletado(this.fa, "Vehiculo ingresado correctamente");
        // La nueva ventana tiene la misma posicion que la anterior
        this.jButtonAtras.doClick();
        vc.setVisible(true);
        
                    /// ---------- IMPRIMIR TICKET
            }else{
                        // Mostrar ventana aviso de pagado
           VAvisoCompletado vc = new VAvisoCompletado(this.fa, "El vehiculo no ha podido ser ingresado");
        // La nueva ventana tiene la misma posicion que la anterior
        this.jButtonAtras.doClick();
        vc.setVisible(true);
                
            }
        }    
           this.jLabelProblemaPlaza.setForeground(Color.BLACK);
            
            
        }
        
   
       
        
    }//GEN-LAST:event_jButtonSeleccionarPlazaActionPerformed

    private void jButtonSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSeleccionarActionPerformed
        // TODO add your handling code here:
        if(this.jComboBoxCampus.getSelectedItem()==null || this.jComboBoxCampus.getSelectedIndex()==-1 ||
                this.jComboBoxCentro.getSelectedItem()==null || this.jComboBoxCentro.getSelectedIndex()==-1){
            this.jLabelErrorComboBox.setVisible(true);
            return;
        }
        this.jLabelErrorComboBox.setVisible(false);
        Component componente = this.jTabbedPane1.getComponent(0);
        this.jTabbedPane1.setSelectedComponent(componente);
        this.setParking(fa.getParking(new Campus(this.getCampusSeleccionado(), fa.listarCentros(campusSeleccionado)), new Centro(this.getCentroSeleccionado())));
        
        
         // Obtiene la fecha acutual para actualizar los botones
        Timestamp fechaActual = new Timestamp(System.currentTimeMillis());
        
            this.setFecha(fechaActual);
            this.actualizarBotones();
    }//GEN-LAST:event_jButtonSeleccionarActionPerformed

    private void jComboBoxCampusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCampusActionPerformed
        // TODO add your handling code here:
        jComboBoxCentro.removeAllItems();
        if(jComboBoxCampus.getSelectedIndex()!=-1){
            String nombreCampus = jComboBoxCampus.getSelectedItem().toString();
            for(Centro c: fa.listarCentros(nombreCampus)){
                jComboBoxCentro.addItem(c.getNombre());
            }
            this.setCampusSeleccionado(nombreCampus);
            jComboBoxCentro.setSelectedIndex(-1);
        }
    }//GEN-LAST:event_jComboBoxCampusActionPerformed

    private void jComboBoxCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCentroActionPerformed
        // TODO add your handling code here:
        if (jComboBoxCentro.getSelectedIndex()!=-1){
            this.setCentroSeleccionado(jComboBoxCentro.getSelectedItem().toString());
        }
    }//GEN-LAST:event_jComboBoxCentroActionPerformed

    private void jButtonSeleccionarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSeleccionarVehiculoActionPerformed
        // TODO add your handling code here:
        
        if(this.vehiculoParaAparcar != null){
            // Obtener el componente de la segunda pestaña
        Component componente = this.jTabbedPane1.getComponentAt(1);

        // Cambiar a la segunda pestaña
        this.jTabbedPane1.setSelectedComponent(componente);
        }
    }//GEN-LAST:event_jButtonSeleccionarVehiculoActionPerformed

    private void jComboBoxSeleccionarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSeleccionarVehiculoActionPerformed
        // TODO add your handling code here:
         // Se actualiza la fecha de salida del vehiculo seleccionado
        
        String elementoSeleccionado = (String) this.jComboBoxSeleccionarVehiculo.getSelectedItem();
        for(Vehiculo v : this.vehiculosLibres){
            if(elementoSeleccionado.contains(v.getMatricula())){
                this.vehiculoParaAparcar = v;
            }
        }
    }//GEN-LAST:event_jComboBoxSeleccionarVehiculoActionPerformed

    private void jButton01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton01ActionPerformed
        // TODO add your handling code here:
        this.idPlazaParaAparcar = 1;
        this.colorSeleccionado = this.jButton01.getBackground();
        this.tipo = "coche";
        
        this.jLabelProblemaPlaza.setText("Plaza seleccionada: " + 1);
    }//GEN-LAST:event_jButton01ActionPerformed

    private void jButton02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton02ActionPerformed
        // TODO add your handling code here:
         this.idPlazaParaAparcar = 2;
        this.colorSeleccionado = this.jButton02.getBackground();
        this.tipo = "coche";
        
        this.jLabelProblemaPlaza.setText("Plaza seleccionada: " + 2);
    }//GEN-LAST:event_jButton02ActionPerformed

    private void jButton03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton03ActionPerformed
        // TODO add your handling code here:
         this.idPlazaParaAparcar = 3;
        this.colorSeleccionado = this.jButton03.getBackground();
        this.tipo = "coche";
        
        this.jLabelProblemaPlaza.setText("Plaza seleccionada: " + 3);
    }//GEN-LAST:event_jButton03ActionPerformed

    private void jButton04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton04ActionPerformed
        // TODO add your handling code here:
         this.idPlazaParaAparcar = 4;
        this.colorSeleccionado = this.jButton04.getBackground();
        this.tipo = "coche";
        
        this.jLabelProblemaPlaza.setText("Plaza seleccionada: " + 4);
    }//GEN-LAST:event_jButton04ActionPerformed

    private void jButton05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton05ActionPerformed
        // TODO add your handling code here:
         this.idPlazaParaAparcar = 5;
        this.colorSeleccionado = this.jButton05.getBackground();
        this.tipo = "coche";
        
        this.jLabelProblemaPlaza.setText("Plaza seleccionada: " + 5);
    }//GEN-LAST:event_jButton05ActionPerformed

    private void jButton06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton06ActionPerformed
        // TODO add your handling code here:
         this.idPlazaParaAparcar = 6;
        this.colorSeleccionado = this.jButton06.getBackground();
        this.tipo = "coche";
        
        this.jLabelProblemaPlaza.setText("Plaza seleccionada: " + 6);
    }//GEN-LAST:event_jButton06ActionPerformed

    private void jButton07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton07ActionPerformed
        // TODO add your handling code here:
         this.idPlazaParaAparcar = 7;
        this.colorSeleccionado = this.jButton07.getBackground();
        this.tipo = "coche";
        
        this.jLabelProblemaPlaza.setText("Plaza seleccionada: " + 7);
    }//GEN-LAST:event_jButton07ActionPerformed

    private void jButton08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton08ActionPerformed
        // TODO add your handling code here:
         this.idPlazaParaAparcar = 8;
        this.colorSeleccionado = this.jButton08.getBackground();
        this.tipo = "coche";
        
        this.jLabelProblemaPlaza.setText("Plaza seleccionada: " + 8);
    }//GEN-LAST:event_jButton08ActionPerformed

    private void jButton09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton09ActionPerformed
        // TODO add your handling code here:
         this.idPlazaParaAparcar = 9;
        this.colorSeleccionado = this.jButton09.getBackground();
        this.tipo = "coche";
        
        this.jLabelProblemaPlaza.setText("Plaza seleccionada: " + 9);
    }//GEN-LAST:event_jButton09ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
         this.idPlazaParaAparcar = 10;
        this.colorSeleccionado = this.jButton10.getBackground();
        this.tipo = "coche";
        
        this.jLabelProblemaPlaza.setText("Plaza seleccionada: " + 10);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
         this.idPlazaParaAparcar = 11;
        this.colorSeleccionado = this.jButton11.getBackground();
        this.tipo = "coche";
        
        this.jLabelProblemaPlaza.setText("Plaza seleccionada: " + 10);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
         this.idPlazaParaAparcar = 12;
        this.colorSeleccionado = this.jButton12.getBackground();
        this.tipo = "coche";
        
        this.jLabelProblemaPlaza.setText("Plaza seleccionada: " + 12);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
         this.idPlazaParaAparcar = 13;
        this.colorSeleccionado = this.jButton13.getBackground();
        this.tipo = "coche";
        
        this.jLabelProblemaPlaza.setText("Plaza seleccionada: " + 13);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
         this.idPlazaParaAparcar = 14;
        this.colorSeleccionado = this.jButton14.getBackground();
        this.tipo = "coche";
        
        this.jLabelProblemaPlaza.setText("Plaza seleccionada: " + 14);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
         this.idPlazaParaAparcar = 15;
        this.colorSeleccionado = this.jButton15.getBackground();
        this.tipo = "coche";
        
        this.jLabelProblemaPlaza.setText("Plaza seleccionada: " + 15);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
         this.idPlazaParaAparcar = 16;
        this.colorSeleccionado = this.jButton16.getBackground();
        this.tipo = "coche";
        
        this.jLabelProblemaPlaza.setText("Plaza seleccionada: " + 16);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
         this.idPlazaParaAparcar = 17;
        this.colorSeleccionado = this.jButton17.getBackground();
        this.tipo = "coche";
        
        this.jLabelProblemaPlaza.setText("Plaza seleccionada: " + 17);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
         this.idPlazaParaAparcar = 18;
        this.colorSeleccionado = this.jButton18.getBackground();
        this.tipo = "moto";
        
        this.jLabelProblemaPlaza.setText("Plaza seleccionada: " + 18);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
         this.idPlazaParaAparcar = 19;
        this.colorSeleccionado = this.jButton19.getBackground();
        this.tipo = "moto";
        
        this.jLabelProblemaPlaza.setText("Plaza seleccionada: " + 19);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
         this.idPlazaParaAparcar = 20;
        this.colorSeleccionado = this.jButton20.getBackground();
        this.tipo = "moto";
        
        this.jLabelProblemaPlaza.setText("Plaza seleccionada: " + 20);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
         this.idPlazaParaAparcar = 22;
        this.colorSeleccionado = this.jButton22.getBackground();
        this.tipo = "moto";
        
        this.jLabelProblemaPlaza.setText("Plaza seleccionada: " + 22);
    }//GEN-LAST:event_jButton22ActionPerformed

    /**
    * @param args the command line arguments
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton jButton01;
    private javax.swing.JButton jButton02;
    private javax.swing.JButton jButton03;
    private javax.swing.JButton jButton04;
    private javax.swing.JButton jButton05;
    private javax.swing.JButton jButton06;
    private javax.swing.JButton jButton07;
    private javax.swing.JButton jButton08;
    private javax.swing.JButton jButton09;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButtonAtras;
    private javax.swing.JButton jButtonSalir1;
    private javax.swing.JButton jButtonSeleccionar;
    private javax.swing.JButton jButtonSeleccionarPlaza;
    private javax.swing.JButton jButtonSeleccionarVehiculo;
    private javax.swing.JComboBox<String> jComboBoxCampus;
    private javax.swing.JComboBox<String> jComboBoxCentro;
    private javax.swing.JComboBox<String> jComboBoxSeleccionarVehiculo;
    private javax.swing.JPanel jJPanelSeleccionarVehiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelCoche;
    private javax.swing.JLabel jLabelErrorComboBox;
    private javax.swing.JLabel jLabelParkingUSC;
    private javax.swing.JLabel jLabelParkingUSC1;
    private javax.swing.JLabel jLabelProblemaPlaza;
    private javax.swing.JLabel jLabelSaldo;
    private javax.swing.JLabel jLabelSeleccionarVehiculo;
    private javax.swing.JLabel jLabelVerParking;
    private javax.swing.JPanel jPanelSeleccionarParking;
    private javax.swing.JPanel jPanelVerParking;
    private javax.swing.JTabbedPane jTabbedPane1;
    private java.awt.Panel panelAzul;
    // End of variables declaration//GEN-END:variables

}
