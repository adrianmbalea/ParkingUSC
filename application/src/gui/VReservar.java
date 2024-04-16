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
import java.util.concurrent.TimeUnit;




/**
 *
 * @author basesdatos
 */

public class VReservar extends javax.swing.JFrame {
  
    private aplicacion.FachadaAplicacion fa;
    private UsuarioUSC miembroUSC;
    private String campusSeleccionado;
    private String centroSeleccionado;
    private Parking parking;
    private Timestamp fechaEntrada;
    private Timestamp fechaSalida;
    private Integer plazaSeleccionada;
    private ArrayList<JButton> plazas;
    private Reservar reserva;

    
    /** Creates new form VPrincipal */
    public VReservar(aplicacion.FachadaAplicacion fa) {
        initComponents();
        Component componente = this.jTabbedPane1.getComponent(1);
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
        
    }
    
    public void actualizarSaldo(){
        this.jLabelSaldo.setText("Saldo: " + this.miembroUSC.getSaldo() + "€");
    }

    public UsuarioUSC getMiembroUSC() {
        return miembroUSC;
    }

    public void setFechaEntrada(Timestamp fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public void setFechaSalida(Timestamp fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Timestamp getFechaEntrada() {
        return fechaEntrada;
    }

    public Timestamp getFechaSalida() {
        return fechaSalida;
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

    public Integer getPlazaSeleccionada() {
        return plazaSeleccionada;
    }

    public void setPlazaSeleccionada(Integer plazaSeleccionada) {
        this.plazaSeleccionada = plazaSeleccionada;
    }

    public Reservar getReserva() {
        return reserva;
    }

    public void setReserva(Reservar reserva) {
        this.reserva = reserva;
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
        if(fechaEntrada == null || fechaSalida == null){
            for(int i=0; i<this.getPlazas().size(); i++){
                JButton boton = this.getPlazas().get(i);
                boton.setBackground(Color.BLACK);
            }
            return;
        }
        for(int i=0; i<this.getPlazas().size(); i++){
            JButton boton = this.getPlazas().get(i);
            //System.out.println("Plaza "+(i+1)+": "+fa.verPlaza(i+1, this.getParking(), this.getFecha()));
            switch(fa.verPlaza(i+1, this.getParking(), this.getFechaEntrada(), this.getFechaSalida())){
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
                if(fa.getFachadaBaseDatos().verTipoPlaza(i + 1, this.getParking()).equals("publica")){
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

        jLabel2 = new javax.swing.JLabel();
        background = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelSeleccionarPlaza = new javax.swing.JPanel();
        jButton18 = new javax.swing.JButton();
        jLabelVerParking = new javax.swing.JLabel();
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
        fechaTextoEntrada = new javax.swing.JTextField();
        ErrorTexto = new javax.swing.JLabel();
        jButtonBuscar = new javax.swing.JButton();
        fechaTextoSalida = new javax.swing.JTextField();
        jLabelPlazaSeleccionada = new javax.swing.JLabel();
        jButtonPagar = new javax.swing.JButton();
        ErrorSeleccionarPlaza = new javax.swing.JLabel();
        jLabelSaldo = new javax.swing.JLabel();
        jPanelSeleccionarParking = new javax.swing.JPanel();
        jLabelParkingUSC = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxCampus = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxCentro = new javax.swing.JComboBox<>();
        jButtonSeleccionar = new javax.swing.JButton();
        jLabelErrorComboBox = new javax.swing.JLabel();
        panelAzul = new java.awt.Panel();
        jLabelCoche = new javax.swing.JLabel();
        jButtonAtras = new javax.swing.JButton();
        jLabelParkingUSC1 = new javax.swing.JLabel();
        jButtonSalir1 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

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

        jPanelSeleccionarPlaza.setBackground(new java.awt.Color(255, 255, 255));
        jPanelSeleccionarPlaza.setForeground(new java.awt.Color(255, 255, 255));

        jButton18.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jButton18.setText("18");
        jButton18.setMargin(new java.awt.Insets(2, 2, 2, 2));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jLabelVerParking.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 36)); // NOI18N
        jLabelVerParking.setText("Seleccionar plaza");

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

        fechaTextoEntrada.setFont(new java.awt.Font("Roboto Medium", 0, 13)); // NOI18N
        fechaTextoEntrada.setForeground(new java.awt.Color(153, 153, 153));
        fechaTextoEntrada.setText("Fecha de entrada: YYYY-MM-DD HH:MI:SS");
        fechaTextoEntrada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fechaTextoEntradaMousePressed(evt);
            }
        });
        fechaTextoEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaTextoEntradaActionPerformed(evt);
            }
        });

        ErrorTexto.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        ErrorTexto.setForeground(new java.awt.Color(255, 0, 0));
        ErrorTexto.setText("<html>Debes escribir <br> una fecha !</html>");

        jButtonBuscar.setBackground(new java.awt.Color(204, 204, 204));
        jButtonBuscar.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jButtonBuscar.setText("<html>Buscar</html>");
        jButtonBuscar.setToolTipText("");
        jButtonBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonBuscar.setMaximumSize(new java.awt.Dimension(90, 40));
        jButtonBuscar.setMinimumSize(new java.awt.Dimension(90, 40));
        jButtonBuscar.setPreferredSize(new java.awt.Dimension(90, 40));
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        fechaTextoSalida.setFont(new java.awt.Font("Roboto Medium", 0, 13)); // NOI18N
        fechaTextoSalida.setForeground(new java.awt.Color(153, 153, 153));
        fechaTextoSalida.setText("Fecha de salida: YYYY-MM-DD HH:MI:SS");
        fechaTextoSalida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                fechaTextoSalidaMousePressed(evt);
            }
        });
        fechaTextoSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaTextoSalidaActionPerformed(evt);
            }
        });

        jLabelPlazaSeleccionada.setText("Plaza seleccionada: ");

        jButtonPagar.setBackground(new java.awt.Color(204, 204, 204));
        jButtonPagar.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jButtonPagar.setText("<html>Pagar</html>");
        jButtonPagar.setToolTipText("");
        jButtonPagar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonPagar.setMaximumSize(new java.awt.Dimension(90, 40));
        jButtonPagar.setMinimumSize(new java.awt.Dimension(90, 40));
        jButtonPagar.setPreferredSize(new java.awt.Dimension(90, 40));
        jButtonPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPagarActionPerformed(evt);
            }
        });

        ErrorSeleccionarPlaza.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        ErrorSeleccionarPlaza.setForeground(new java.awt.Color(255, 0, 0));
        ErrorSeleccionarPlaza.setText("<html>Debes seleccionar <br> una plaza !</html>");

        jLabelSaldo.setFont(new java.awt.Font("Roboto Medium", 0, 13)); // NOI18N
        jLabelSaldo.setText("Saldo: ");

        javax.swing.GroupLayout jPanelSeleccionarPlazaLayout = new javax.swing.GroupLayout(jPanelSeleccionarPlaza);
        jPanelSeleccionarPlaza.setLayout(jPanelSeleccionarPlazaLayout);
        jPanelSeleccionarPlazaLayout.setHorizontalGroup(
            jPanelSeleccionarPlazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSeleccionarPlazaLayout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addGroup(jPanelSeleccionarPlazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSeleccionarPlazaLayout.createSequentialGroup()
                        .addGroup(jPanelSeleccionarPlazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelSeleccionarPlazaLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1))
                            .addGroup(jPanelSeleccionarPlazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanelSeleccionarPlazaLayout.createSequentialGroup()
                                    .addGroup(jPanelSeleccionarPlazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelSeleccionarPlazaLayout.createSequentialGroup()
                                            .addComponent(jButton01, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10)
                                            .addComponent(jButton02, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10)
                                            .addComponent(jButton03, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10)
                                            .addComponent(jButton04, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanelSeleccionarPlazaLayout.createSequentialGroup()
                                            .addComponent(jButton06, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10)
                                            .addComponent(jButton07, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10)
                                            .addComponent(jButton08, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10)
                                            .addComponent(jButton09, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10)
                                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanelSeleccionarPlazaLayout.createSequentialGroup()
                                            .addGap(200, 200, 200)
                                            .addComponent(jButton05, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(190, 190, 190))
                                .addGroup(jPanelSeleccionarPlazaLayout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addGroup(jPanelSeleccionarPlazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelSeleccionarPlazaLayout.createSequentialGroup()
                                            .addComponent(jLabelVerParking)
                                            .addGap(53, 53, 53)
                                            .addComponent(jLabelSaldo))
                                        .addGroup(jPanelSeleccionarPlazaLayout.createSequentialGroup()
                                            .addGroup(jPanelSeleccionarPlazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(fechaTextoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(fechaTextoSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(28, 28, 28)
                                            .addGroup(jPanelSeleccionarPlazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(ErrorTexto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(0, 34, Short.MAX_VALUE))
                    .addGroup(jPanelSeleccionarPlazaLayout.createSequentialGroup()
                        .addGroup(jPanelSeleccionarPlazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelSeleccionarPlazaLayout.createSequentialGroup()
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
                            .addGroup(jPanelSeleccionarPlazaLayout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(jButton19))
                            .addGroup(jPanelSeleccionarPlazaLayout.createSequentialGroup()
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelSeleccionarPlazaLayout.createSequentialGroup()
                                .addGap(200, 200, 200)
                                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelSeleccionarPlazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSeleccionarPlazaLayout.createSequentialGroup()
                                .addComponent(jLabelPlazaSeleccionada, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSeleccionarPlazaLayout.createSequentialGroup()
                                .addComponent(ErrorSeleccionarPlaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59))
                            .addGroup(jPanelSeleccionarPlazaLayout.createSequentialGroup()
                                .addComponent(jButtonPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        jPanelSeleccionarPlazaLayout.setVerticalGroup(
            jPanelSeleccionarPlazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSeleccionarPlazaLayout.createSequentialGroup()
                .addGap(0, 24, Short.MAX_VALUE)
                .addGroup(jPanelSeleccionarPlazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelVerParking)
                    .addComponent(jLabelSaldo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGroup(jPanelSeleccionarPlazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelSeleccionarPlazaLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ErrorTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelSeleccionarPlazaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fechaTextoEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fechaTextoSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(jPanelSeleccionarPlazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelSeleccionarPlazaLayout.createSequentialGroup()
                                .addGroup(jPanelSeleccionarPlazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelSeleccionarPlazaLayout.createSequentialGroup()
                                        .addGroup(jPanelSeleccionarPlazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton01, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton02, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton03, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton04, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanelSeleccionarPlazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton06, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton07, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton08, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton09, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanelSeleccionarPlazaLayout.createSequentialGroup()
                                        .addGap(66, 66, 66)
                                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanelSeleccionarPlazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelSeleccionarPlazaLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanelSeleccionarPlazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(10, 10, 10))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSeleccionarPlazaLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelPlazaSeleccionada)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ErrorSeleccionarPlaza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanelSeleccionarPlazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanelSeleccionarPlazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanelSeleccionarPlazaLayout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton05, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelSeleccionarPlazaLayout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(52, 52, 52))))
        );

        ErrorTexto.setVisible(false);
        jLabelPlazaSeleccionada.setVisible(false);
        ErrorSeleccionarPlaza.setVisible(false);

        jTabbedPane1.addTab("tab1", jPanelSeleccionarPlaza);

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
                .addGroup(jPanelSeleccionarParkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSeleccionarParkingLayout.createSequentialGroup()
                        .addGroup(jPanelSeleccionarParkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabelParkingUSC))
                        .addGap(115, 115, 115))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSeleccionarParkingLayout.createSequentialGroup()
                        .addComponent(jLabelErrorComboBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(jPanelSeleccionarParkingLayout.createSequentialGroup()
                        .addGroup(jPanelSeleccionarParkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBoxCentro, javax.swing.GroupLayout.Alignment.LEADING, 0, 320, Short.MAX_VALUE)
                            .addComponent(jComboBoxCampus, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
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
                .addGap(74, 74, 74)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jComboBoxCentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(jPanelSeleccionarParkingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelErrorComboBox))
                .addGap(35, 35, 35))
        );

        jLabelErrorComboBox.setVisible(false);

        jTabbedPane1.addTab("tab2", jPanelSeleccionarParking);

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

    private void fechaTextoEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaTextoEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaTextoEntradaActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        if(this.jButton21.getBackground().equals(Color.GREEN)){
            this.jLabelPlazaSeleccionada.setText("Plaza seleccionada: 21");
            this.jLabelPlazaSeleccionada.setVisible(true);
            this.setPlazaSeleccionada(21);
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
        if(fechaTextoEntrada.getText() == null || fechaTextoEntrada.getText().equals("") || fechaTextoEntrada.getText().equals(" ") || fechaTextoEntrada.getText().equals("Fecha de entrada: YYYY-MM-DD HH:MI:SS") ||
                fechaTextoSalida.getText() == null || fechaTextoSalida.getText().equals("") || fechaTextoSalida.getText().equals(" ") || fechaTextoSalida.getText().equals("Fecha de salida: YYYY-MM-DD HH:MI:SS")){
            ErrorTexto.setText("<html>Debes escribir <br> una fecha !</html>");
            ErrorTexto.setVisible(true);
            return;
        }
        
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateFormat.setLenient(false); // para que no acepte fechas invalidas
            Date date = dateFormat.parse(this.fechaTextoEntrada.getText());
            Timestamp timestamp1 = new Timestamp(date.getTime());
            this.setFechaEntrada(timestamp1);
            try{
                Date dateSalida = dateFormat.parse(this.fechaTextoSalida.getText());
                Timestamp timestamp2 = new Timestamp(dateSalida.getTime());
                this.setFechaSalida(timestamp2);
                ErrorTexto.setVisible(false);
                this.actualizarBotones();
            }
            catch(ParseException ex){
                ErrorTexto.setText("<html>La fecha de salida<br>es incorrecta!</html>");
                ErrorTexto.setVisible(true);
            }
        }
        catch(ParseException ex){
            ErrorTexto.setText("<html>La fecha de entrada<br>es incorrecta!</html>");
            ErrorTexto.setVisible(true);
        }
        
    }//GEN-LAST:event_jButtonBuscarActionPerformed

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

    private void fechaTextoEntradaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaTextoEntradaMousePressed
        // TODO add your handling code here:
        // TODO add your handling code here:
        if(fechaTextoEntrada.getText().equals("Fecha de entrada: YYYY-MM-DD HH:MI:SS")){
            fechaTextoEntrada.setText("");
            fechaTextoEntrada.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_fechaTextoEntradaMousePressed

    private void fechaTextoSalidaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaTextoSalidaMousePressed
        // TODO add your handling code here:
        if(fechaTextoSalida.getText().equals("Fecha de salida: YYYY-MM-DD HH:MI:SS")){
            fechaTextoSalida.setText("");
            fechaTextoSalida.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_fechaTextoSalidaMousePressed

    private void fechaTextoSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaTextoSalidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaTextoSalidaActionPerformed

    private void jButton01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton01ActionPerformed
        // TODO add your handling code here:
        if(this.jButton01.getBackground().equals(Color.GREEN)){
            this.jLabelPlazaSeleccionada.setText("Plaza seleccionada: 01");
            this.jLabelPlazaSeleccionada.setVisible(true);
            this.setPlazaSeleccionada(1);
        }
    }//GEN-LAST:event_jButton01ActionPerformed

    private void jButton02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton02ActionPerformed
        // TODO add your handling code here:
        if(this.jButton02.getBackground().equals(Color.GREEN)){
            this.jLabelPlazaSeleccionada.setText("Plaza seleccionada: 02");
            this.jLabelPlazaSeleccionada.setVisible(true);
            this.setPlazaSeleccionada(2);
        }
    }//GEN-LAST:event_jButton02ActionPerformed

    private void jButton03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton03ActionPerformed
        // TODO add your handling code here:
        if(this.jButton03.getBackground().equals(Color.GREEN)){
            this.jLabelPlazaSeleccionada.setText("Plaza seleccionada: 03");
            this.jLabelPlazaSeleccionada.setVisible(true);
            this.setPlazaSeleccionada(3);
        }
    }//GEN-LAST:event_jButton03ActionPerformed

    private void jButton04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton04ActionPerformed
        // TODO add your handling code here:
        if(this.jButton04.getBackground().equals(Color.GREEN)){
            this.jLabelPlazaSeleccionada.setText("Plaza seleccionada: 04");
            this.jLabelPlazaSeleccionada.setVisible(true);
            this.setPlazaSeleccionada(4);
        }
    }//GEN-LAST:event_jButton04ActionPerformed

    private void jButton05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton05ActionPerformed
        // TODO add your handling code here:
       if(this.jButton05.getBackground().equals(Color.GREEN)){
            this.jLabelPlazaSeleccionada.setText("Plaza seleccionada: 05");
            this.jLabelPlazaSeleccionada.setVisible(true);
            this.setPlazaSeleccionada(5);
        }
    }//GEN-LAST:event_jButton05ActionPerformed

    private void jButton06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton06ActionPerformed
        // TODO add your handling code here:
        if(this.jButton06.getBackground().equals(Color.GREEN)){
            this.jLabelPlazaSeleccionada.setText("Plaza seleccionada: 06");
            this.jLabelPlazaSeleccionada.setVisible(true);
            this.setPlazaSeleccionada(6);
        }
    }//GEN-LAST:event_jButton06ActionPerformed

    private void jButton07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton07ActionPerformed
        // TODO add your handling code here:
        if(this.jButton07.getBackground().equals(Color.GREEN)){
            this.jLabelPlazaSeleccionada.setText("Plaza seleccionada: 07");
            this.jLabelPlazaSeleccionada.setVisible(true);
            this.setPlazaSeleccionada(7);
        }
    }//GEN-LAST:event_jButton07ActionPerformed

    private void jButton08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton08ActionPerformed
        // TODO add your handling code here:
        if(this.jButton08.getBackground().equals(Color.GREEN)){
            this.jLabelPlazaSeleccionada.setText("Plaza seleccionada: 08");
            this.jLabelPlazaSeleccionada.setVisible(true);
            this.setPlazaSeleccionada(8);
        }
    }//GEN-LAST:event_jButton08ActionPerformed

    private void jButton09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton09ActionPerformed
        // TODO add your handling code here:
        if(this.jButton09.getBackground().equals(Color.GREEN)){
            this.jLabelPlazaSeleccionada.setText("Plaza seleccionada: 09");
            this.jLabelPlazaSeleccionada.setVisible(true);
            this.setPlazaSeleccionada(9);
        }
    }//GEN-LAST:event_jButton09ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        if(this.jButton10.getBackground().equals(Color.GREEN)){
            this.jLabelPlazaSeleccionada.setText("Plaza seleccionada: 10");
            this.jLabelPlazaSeleccionada.setVisible(true);
            this.setPlazaSeleccionada(10);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        if(this.jButton11.getBackground().equals(Color.GREEN)){
            this.jLabelPlazaSeleccionada.setText("Plaza seleccionada: 11");
            this.jLabelPlazaSeleccionada.setVisible(true);
            this.setPlazaSeleccionada(11);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        if(this.jButton12.getBackground().equals(Color.GREEN)){
            this.jLabelPlazaSeleccionada.setText("Plaza seleccionada: 12");
            this.jLabelPlazaSeleccionada.setVisible(true);
            this.setPlazaSeleccionada(12);
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        if(this.jButton13.getBackground().equals(Color.GREEN)){
            this.jLabelPlazaSeleccionada.setText("Plaza seleccionada: 13");
            this.jLabelPlazaSeleccionada.setVisible(true);
            this.setPlazaSeleccionada(13);
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        if(this.jButton14.getBackground().equals(Color.GREEN)){
            this.jLabelPlazaSeleccionada.setText("Plaza seleccionada: 14");
            this.jLabelPlazaSeleccionada.setVisible(true);
            this.setPlazaSeleccionada(14);
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        if(this.jButton15.getBackground().equals(Color.GREEN)){
            this.jLabelPlazaSeleccionada.setText("Plaza seleccionada: 15");
            this.jLabelPlazaSeleccionada.setVisible(true);
            this.setPlazaSeleccionada(15);
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        if(this.jButton16.getBackground().equals(Color.GREEN)){
            this.jLabelPlazaSeleccionada.setText("Plaza seleccionada: 16");
            this.jLabelPlazaSeleccionada.setVisible(true);
            this.setPlazaSeleccionada(16);
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        if(this.jButton17.getBackground().equals(Color.GREEN)){
            this.jLabelPlazaSeleccionada.setText("Plaza seleccionada: 17");
            this.jLabelPlazaSeleccionada.setVisible(true);
            this.setPlazaSeleccionada(17);
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        if(this.jButton18.getBackground().equals(Color.GREEN)){
            this.jLabelPlazaSeleccionada.setText("Plaza seleccionada: 18");
            this.jLabelPlazaSeleccionada.setVisible(true);
            this.setPlazaSeleccionada(18);
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        if(this.jButton19.getBackground().equals(Color.GREEN)){
            this.jLabelPlazaSeleccionada.setText("Plaza seleccionada: 19");
            this.jLabelPlazaSeleccionada.setVisible(true);
            this.setPlazaSeleccionada(19);
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        if(this.jButton20.getBackground().equals(Color.GREEN)){
            this.jLabelPlazaSeleccionada.setText("Plaza seleccionada: 20");
            this.jLabelPlazaSeleccionada.setVisible(true);
            this.setPlazaSeleccionada(20);
        }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        if(this.jButton22.getBackground().equals(Color.GREEN)){
            this.jLabelPlazaSeleccionada.setText("Plaza seleccionada: 22");
            this.jLabelPlazaSeleccionada.setVisible(true);
            this.setPlazaSeleccionada(22);
        }
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButtonPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPagarActionPerformed
        // TODO add your handling code here:
        if(this.getPlazaSeleccionada() == null){
            this.ErrorSeleccionarPlaza.setVisible(true);
            return;
        }
        this.ErrorSeleccionarPlaza.setVisible(false);
        Reservar r = new Reservar(this.getFechaEntrada(), this.getFechaSalida(), 1.25f, this.getMiembroUSC(), this.getParking().getCampus(), this.getParking().getCentro(), this.getPlazaSeleccionada());
        this.setReserva(r);
        
        // Calcular la cantidad de horas entre las dos fechas
        long diferenciaEnMilisegundos = r.getFechaFin().getTime() - r.getFechaInicio().getTime();
        long horas = TimeUnit.MILLISECONDS.toHours(diferenciaEnMilisegundos);
        
        // Mostrar vehiculo, parking, fechas y precio
        float coste = reserva.getPrecioHora() * horas;
        
        if(this.getMiembroUSC().getSaldo() < coste){
            VAvisoCompletado vc = new VAvisoCompletado(this.fa, "No tienes suficiente saldo");
            // La nueva ventana tiene la misma posicion que la anterior
            this.jButtonAtras.doClick();
            vc.setVisible(true);
        }
        
        else{
            if(fa.realizarReserva(reserva)){
                /// -------------------- ACTUALIZAR LOS DATOS DEL USUARIO --------------
                this.miembroUSC.setSaldo(fa.getFachadaBaseDatos().getUsuario(miembroUSC.getDniUsuario()).getSaldo());
                VAvisoCompletado vc = new VAvisoCompletado(this.fa, "Reserva realizada correctamente");
                // La nueva ventana tiene la misma posicion que la anterior
                this.jButtonAtras.doClick();
                vc.setVisible(true);
            }
            else{
                VAvisoCompletado vc = new VAvisoCompletado(this.fa, "No se ha podido realizar la reserva");
                // La nueva ventana tiene la misma posicion que la anterior
                this.jButtonAtras.doClick();
                vc.setVisible(true);
            }
        }
        
        
    }//GEN-LAST:event_jButtonPagarActionPerformed

    /**
    * @param args the command line arguments
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ErrorSeleccionarPlaza;
    private javax.swing.JLabel ErrorTexto;
    private javax.swing.JPanel background;
    private javax.swing.JTextField fechaTextoEntrada;
    private javax.swing.JTextField fechaTextoSalida;
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
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonPagar;
    private javax.swing.JButton jButtonSalir1;
    private javax.swing.JButton jButtonSeleccionar;
    private javax.swing.JComboBox<String> jComboBoxCampus;
    private javax.swing.JComboBox<String> jComboBoxCentro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelCoche;
    private javax.swing.JLabel jLabelErrorComboBox;
    private javax.swing.JLabel jLabelParkingUSC;
    private javax.swing.JLabel jLabelParkingUSC1;
    private javax.swing.JLabel jLabelPlazaSeleccionada;
    private javax.swing.JLabel jLabelSaldo;
    private javax.swing.JLabel jLabelVerParking;
    private javax.swing.JPanel jPanelSeleccionarParking;
    private javax.swing.JPanel jPanelSeleccionarPlaza;
    private javax.swing.JTabbedPane jTabbedPane1;
    private java.awt.Panel panelAzul;
    // End of variables declaration//GEN-END:variables

}
