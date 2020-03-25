package calculadoragráfica;

import Geometria2D.Compilador;
import static Geometria2D.Compilador.*;
import Geometria2D.Dupla;
import Herramientas.ColorRGB;
import Imagen.Imagen;
import static calculadoragráfica.Funcion.*;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VentanaPrincipal extends javax.swing.JFrame {

    SuperficieDeDibujo superficieDeDibujo;
    Plano plano;

    public VentanaPrincipal(String nombre, SuperficieDeDibujo SuperficieDeDibujo) {

        initComponents();
        setVisible(true);
        setExtendedState(MAXIMIZED_BOTH);

        superficieDeDibujo = SuperficieDeDibujo;
        plano = SuperficieDeDibujo.plano;

        jTextField3.setText(plano.función.v + "");
        Desface.setText("Inhabilitado");
        plano.función.representación = jTextField3;

        plano.función.MODO_GRAFICA = Modo.getSelectedIndex();
        superficieDeDibujo.plano.DibujarLineasGuias = Cuadricula.isSelected();
        superficieDeDibujo.plano.DibujarEjes = Ejes.isSelected();
        superficieDeDibujo.plano.DibujarNumeros = EtiquetaEjes.isSelected();
        superficieDeDibujo.plano.función.relleno = PintarPoligono.isSelected();
        plano.función.dibujarEtiqueta = EtiquetaFunción.isSelected();

        jPanel1.add(SuperficieDeDibujo);
        plano.Tamaño = new Dupla(jPanel1.getSize().width, jPanel1.getSize().height);
        plano.función.V_Incremento();

        setTitle(nombre);
        this.superficieDeDibujo.Hilo.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        V_Siguiente = new javax.swing.JButton();
        V_Anterior = new javax.swing.JButton();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        Restaurar = new javax.swing.JButton();
        Menos = new javax.swing.JButton();
        Más = new javax.swing.JButton();
        Arriba = new javax.swing.JButton();
        Abajo = new javax.swing.JButton();
        Derecha = new javax.swing.JButton();
        Izquierda = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jSlider2 = new javax.swing.JSlider();
        jPanel5 = new javax.swing.JPanel();
        Cuadricula = new javax.swing.JRadioButton();
        Ejes = new javax.swing.JRadioButton();
        EtiquetaEjes = new javax.swing.JRadioButton();
        EtiquetaFunción = new javax.swing.JRadioButton();
        PintarPoligono = new javax.swing.JRadioButton();
        InvertirRelacion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Modo = new javax.swing.JList<>();
        jButton5 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        DesfaceAstroCardioidal_Slider = new javax.swing.JSlider();
        Desface = new javax.swing.JLabel();
        jSlider3 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentResized(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 599, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("V"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField1.setText("0.00123456789");
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 70, 30));

        jButton1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton1.setText("P");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 30, 50, 30));

        V_Siguiente.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        V_Siguiente.setText("N");
        V_Siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                V_SiguienteActionPerformed(evt);
            }
        });
        jPanel2.add(V_Siguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 40, 16));

        V_Anterior.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        V_Anterior.setText("B");
        V_Anterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                V_AnteriorActionPerformed(evt);
            }
        });
        jPanel2.add(V_Anterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 40, 16));

        jTextField3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField3.setText("3");
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField3KeyTyped(evt);
            }
        });
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 58, 34));

        jLabel2.setText("Diferencial");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 60, 20));

        jLabel3.setText("Cambio");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 60, 20));

        jButton7.setFont(new java.awt.Font("Calibri", 0, 8)); // NOI18N
        jButton7.setText("c");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 60, -1, 16));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Cometa"));

        jButton4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton4.setText("S");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton6.setText("R");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton2.setText("P");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton4)
                .addComponent(jButton2)
                .addComponent(jButton6))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Zoom y Desplazamiento"));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Restaurar.setText("R");
        Restaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestaurarActionPerformed(evt);
            }
        });
        jPanel7.add(Restaurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        Menos.setText("-");
        Menos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenosActionPerformed(evt);
            }
        });
        jPanel7.add(Menos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        Más.setText("+");
        Más.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MásActionPerformed(evt);
            }
        });
        jPanel7.add(Más, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, -1, -1));

        Arriba.setText("Ar");
        Arriba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArribaActionPerformed(evt);
            }
        });
        jPanel7.add(Arriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 50, -1));

        Abajo.setText("Ab");
        Abajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbajoActionPerformed(evt);
            }
        });
        jPanel7.add(Abajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 50, -1));

        Derecha.setText("De");
        Derecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DerechaActionPerformed(evt);
            }
        });
        jPanel7.add(Derecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 50, 20));

        Izquierda.setText("Iz");
        Izquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IzquierdaActionPerformed(evt);
            }
        });
        jPanel7.add(Izquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 50, 20));

        jButton3.setText("Ver Ecuación");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jSlider1.setMaximum(0);
        jSlider1.setMinimum(-1000);
        jSlider1.setValue(-200);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        jSlider2.setMaximum(1000);
        jSlider2.setValue(200);
        jSlider2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider2StateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 167, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSlider1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(261, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inicio", jPanel4);

        Cuadricula.setSelected(true);
        Cuadricula.setText("Cuadricula");
        Cuadricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuadriculaActionPerformed(evt);
            }
        });

        Ejes.setSelected(true);
        Ejes.setText("Ejes");
        Ejes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EjesActionPerformed(evt);
            }
        });

        EtiquetaEjes.setSelected(true);
        EtiquetaEjes.setText("Etiquetas Ejes");
        EtiquetaEjes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EtiquetaEjesActionPerformed(evt);
            }
        });

        EtiquetaFunción.setText("Etiqueta de la Función");
        EtiquetaFunción.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EtiquetaFunciónActionPerformed(evt);
            }
        });

        PintarPoligono.setText("Pintar Poligono");
        PintarPoligono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PintarPoligonoActionPerformed(evt);
            }
        });

        InvertirRelacion.setText("Invertir Relación");
        InvertirRelacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InvertirRelacionActionPerformed(evt);
            }
        });

        Modo.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Rectangular", "Polar", "PolarMod(rCos(θ)Sen(5θ),rSen(θ)Sen(5θ))", "(rSenAstroide(θ,k),rCosAstroide(θ,k))[k=3]", "(rSenAstroide(θ,k),rCosAstroide(θ,k))[k=4]", "(rSenAstroide(θ,k),rCosAstroide(θ,k))[k=5]", "(rSenAstroide(θ,k),rCosAstroide(θ,k))[k=6]", "(rSenAstroide(θ,k),rCosAstroide(θ,k))[k=7]", "(rSenAstroide(θ,k),rCosAstroide(θ,k))[k=8]", "(rSenAstroide(θ,k),rCosAstroide(θ,k))[k=9]", "(rSenAstroide(θ,k),rCosAstroide(θ,k))[k=10]", "(rSenAstroide(θ,k),rCosAstroide(θ,k))[k=11]", "(rSenAstroide(θ,k),rCosAstroide(θ,k))[k=12]", "(rSenAstroide(θ,k),rCosAstroide(θ,k))[k=13]", "(rSenAstroide(θ,k),rCosAstroide(θ,k))[k=14]", "(rSenAstroide(θ,k),rCosAstroide(θ,k))[k=15]", "(rSenAstroide(θ,k),rCosAstroide(θ,k))[k=16]", "(rSenAstroide(θ,k),rCosAstroide(θ,k))[k=17]", "(rSenAstroide(θ,k),rCosAstroide(θ,k))[k=18]", "(rSenAstroide(θ,k),rCosAstroide(θ,k))[k=19]", "(rSenAstroide(θ,k),rCosAstroide(θ,k))[k=20]", "(rSenAstroide(θ,k),rCosAstroide(θ,k))[k=21]", "(rSenAstroide(θ,k),rCosAstroide(θ,k))[k=22]", "(rSenAstroide(θ,k),rCosAstroide(θ,k))[k=23]", "(rSenAstroide(θ,k),rCosAstroide(θ,k))[k=24]", "(rSenAstroide(θ,k),rCosAstroide(θ,k))[k=25]", "(rSenCardioide(θ,k),rCosCardioide(θ,k))[k=1]", "(rSenCardioide(θ,k),rCosCardioide(θ,k))[k=2]", "(rSenCardioide(θ,k),rCosCardioide(θ,k))[k=3]", "(rSenCardioide(θ,k),rCosCardioide(θ,k))[k=4]", "(rSenCardioide(θ,k),rCosCardioide(θ,k))[k=5]", "(rSenCardioide(θ,k),rCosCardioide(θ,k))[k=6]", "(rSenCardioide(θ,k),rCosCardioide(θ,k))[k=7]", "(rSenCardioide(θ,k),rCosCardioide(θ,k))[k=8]", "(rSenCardioide(θ,k),rCosCardioide(θ,k))[k=9]", "(rSenCardioide(θ,k),rCosCardioide(θ,k))[k=10]", "(rSenCardioide(θ,k),rCosCardioide(θ,k))[k=11]", "(rSenCardioide(θ,k),rCosCardioide(θ,k))[k=12]", "(rSenCardioide(θ,k),rCosCardioide(θ,k))[k=13]", "(rSenCardioide(θ,k),rCosCardioide(θ,k))[k=14]", "(rSenCardioide(θ,k),rCosCardioide(θ,k))[k=15]", "(rSenCardioide(θ,k),rCosCardioide(θ,k))[k=16]", "(rSenCardioide(θ,k),rCosCardioide(θ,k))[k=17]", "(rSenCardioide(θ,k),rCosCardioide(θ,k))[k=18]", "(rSenCardioide(θ,k),rCosCardioide(θ,k))[k=19]", "(rSenCardioide(θ,k),rCosCardioide(θ,k))[k=20]", "(rSenCardioide(θ,k),rCosCardioide(θ,k))[k=21]", "(rSenCardioide(θ,k),rCosCardioide(θ,k))[k=22]", "(rSenCardioide(θ,k),rCosCardioide(θ,k))[k=23]", "(rSenCardioide(θ,k),rCosCardioide(θ,k))[k=24]", "(rSenCardioide(θ,k),rCosCardioide(θ,k))[k=25]", "(rSenPoligonoide(θ,k),rCosPoligonoide(θ,k))[k=1]", "(rSenPoligonoide(θ,k),rCosPoligonoide(θ,k))[k=2]", "(rSenPoligonoide(θ,k),rCosPoligonoide(θ,k))[k=3]", "(rSenPoligonoide(θ,k),rCosPoligonoide(θ,k))[k=4]", "(rSenPoligonoide(θ,k),rCosPoligonoide(θ,k))[k=5]", "(rSenPoligonoide(θ,k),rCosPoligonoide(θ,k))[k=6]", "(rSenPoligonoide(θ,k),rCosPoligonoide(θ,k))[k=7]", "(rSenPoligonoide(θ,k),rCosPoligonoide(θ,k))[k=8]", "(rSenPoligonoide(θ,k),rCosPoligonoide(θ,k))[k=9]", "(rSenPoligonoide(θ,k),rCosPoligonoide(θ,k))[k=10]", "(rSenPoligonoide(θ,k),rCosPoligonoide(θ,k))[k=11]", "(rSenPoligonoide(θ,k),rCosPoligonoide(θ,k))[k=12]", "(rSenPoligonoide(θ,k),rCosPoligonoide(θ,k))[k=13]", "(rSenPoligonoide(θ,k),rCosPoligonoide(θ,k))[k=14]", "(rSenPoligonoide(θ,k),rCosPoligonoide(θ,k))[k=15]", "(rSenPoligonoe(θ,k),rCosPoligon(θ,k))[k=3]", "(rSenPoligono(θ,k),rCosPoligono(θ,k))[k=4]", "(rSenPoligono(θ,k),rCosPoligono(θ,k))[k=5]", "(rSenPoligono(θ,k),rCosPoligono(θ,k))[k=6]", "(rSenPoligono(θ,k),rCosPoligono(θ,k))[k=7]", "(rSenPoligono(θ,k),rCosPoligono(θ,k))[k=8]", "(rSenPoligono(θ,k),rCosPoligono(θ,k))[k=9]", "(rSenPoligono(θ,k),rCosPoligono(θ,k))[k=10]", "(rSenPoligono(θ,k),rCosPoligono(θ,k))[k=11]", "(rSenPoligono(θ,k),rCosPoligono(θ,k))[k=12]", "(rSenPoligono(θ,k),rCosPoligono(θ,k))[k=13]", "(rSenPoligono(θ,k),rCosPoligono(θ,k))[k=14]", "(rSenPoligono(θ,k),rCosPoligono(θ,k))[k=15]" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        Modo.setSelectedIndex(0);
        Modo.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ModoValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(Modo);

        jButton5.setText("Generar Códigos");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(5);
        jTextArea1.setRows(3);
        jScrollPane2.setViewportView(jTextArea1);

        DesfaceAstroCardioidal_Slider.setMaximum(1000);
        DesfaceAstroCardioidal_Slider.setMinimum(-2000);
        DesfaceAstroCardioidal_Slider.setValue(0);
        DesfaceAstroCardioidal_Slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                DesfaceAstroCardioidal_SliderStateChanged(evt);
            }
        });
        DesfaceAstroCardioidal_Slider.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                DesfaceAstroCardioidal_SliderKeyTyped(evt);
            }
        });

        Desface.setText("jLabel1");

        jSlider3.setMaximum(720);
        jSlider3.setValue(0);
        jSlider3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider3StateChanged(evt);
            }
        });

        jLabel1.setText("Rotación");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DesfaceAstroCardioidal_Slider, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PintarPoligono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EtiquetaEjes)
                            .addComponent(EtiquetaFunción))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(Cuadricula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Ejes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(InvertirRelacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jSlider3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(3, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(Desface)
                                .addContainerGap())))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Cuadricula)
                    .addComponent(Ejes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EtiquetaEjes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EtiquetaFunción)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PintarPoligono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InvertirRelacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(Desface)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DesfaceAstroCardioidal_Slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Configuración", jPanel5);

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        jMenu1.setText("Otros");

        jMenuItem1.setText("Geogebra, Descarga gratuita");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("FooPlot, Gráficador Online");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar2.add(jMenu1);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        plano.funciones.stream().forEach((función) -> {
            función.cometa = superficieDeDibujo.plano.función.puntosTabular + 1;
        });
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        plano.funciones.stream().forEach((función) -> {
            función.V_EnMovimiento = !función.V_EnMovimiento;
        });
        jTextField3.setEditable(!superficieDeDibujo.plano.función.V_EnMovimiento);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void V_SiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_V_SiguienteActionPerformed
        plano.funciones.stream().forEach((Funcion) -> {
            Funcion.V_Incremento();
        });
    }//GEN-LAST:event_V_SiguienteActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_DELETE:
            case KeyEvent.VK_BACKSPACE:
                if (jTextField1.getText().equals("")) {
                    jTextField1.setText("0");
                    plano.funciones.stream().forEach((Funcion) -> {
                        Funcion.IncrementoV = Double.parseDouble(jTextField1.getText());
                    });
                }
                return;
            case KeyEvent.VK_CONTROL:
                Control = true;
                break;
            case KeyEvent.VK_END:
            case KeyEvent.VK_ENTER:
            case KeyEvent.VK_HOME:
            case KeyEvent.VK_SHIFT:
                return;
        }
        if (Control) {
            return;
        }
        char c = evt.getKeyChar();
        if (c == '/') {
            evt.consume();
        }
        if (jTextField1.getText().contains(".") && c == '.') {
            evt.consume();
        }
        if (c != KeyEvent.VK_DELETE && c != KeyEvent.VK_BACKSPACE
                && c != KeyEvent.VK_RIGHT && c != KeyEvent.VK_LEFT) {
            if (c < '.' || c > '9') {
                evt.consume();
            }
        }
        try {
            plano.funciones.stream().forEach((Funcion) -> {
                Funcion.IncrementoV = Double.parseDouble(jTextField1.getText());
            });
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void CuadriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuadriculaActionPerformed
        plano.DibujarLineasGuias = Cuadricula.isSelected();
    }//GEN-LAST:event_CuadriculaActionPerformed

    private void EjesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EjesActionPerformed
        plano.DibujarEjes = Ejes.isSelected();
    }//GEN-LAST:event_EjesActionPerformed

    private void EtiquetaEjesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EtiquetaEjesActionPerformed
        plano.DibujarNumeros = EtiquetaEjes.isSelected();
    }//GEN-LAST:event_EtiquetaEjesActionPerformed

    private void PintarPoligonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PintarPoligonoActionPerformed
        plano.función.relleno = PintarPoligono.isSelected();
    }//GEN-LAST:event_PintarPoligonoActionPerformed

    private void InvertirRelacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InvertirRelacionActionPerformed
        plano.función.Inversa();
    }//GEN-LAST:event_InvertirRelacionActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        plano.funciones.stream().forEach((función) -> {
            función.cometa = 0;
            función.Cometa_EnMovimiento = true;
        });

    }//GEN-LAST:event_jButton6ActionPerformed

    private void IzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IzquierdaActionPerformed
        plano.Desplazar(10, 0);
    }//GEN-LAST:event_IzquierdaActionPerformed

    private void DerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DerechaActionPerformed
        plano.Desplazar(-10, 0);
    }//GEN-LAST:event_DerechaActionPerformed

    private void ArribaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArribaActionPerformed
        plano.Desplazar(0, -10);
    }//GEN-LAST:event_ArribaActionPerformed

    private void AbajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbajoActionPerformed
        plano.Desplazar(0, 10);
    }//GEN-LAST:event_AbajoActionPerformed

    private void RestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestaurarActionPerformed
        plano.UnidadDeEscala = plano.IntervaloDeSeparaciónEntreUnidades;
        plano.Desplazar_Sustituir(0, 0);
    }//GEN-LAST:event_RestaurarActionPerformed

    private void MenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenosActionPerformed
        if (plano.UnidadDeEscala - plano.d < 1) {
            plano.UnidadDeEscala /= 2;
        } else {
            plano.UnidadDeEscala -= 5;
        }
        plano.GenerarFondo();
    }//GEN-LAST:event_MenosActionPerformed

    private void MásActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MásActionPerformed
        if (plano.UnidadDeEscala + plano.d < 1) {
            plano.UnidadDeEscala *= 2;
        } else {
            plano.UnidadDeEscala += 5;
        }
        plano.GenerarFondo();
    }//GEN-LAST:event_MásActionPerformed

    private void ModoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ModoValueChanged
        DesfaceAstroCardioidal_Slider.setValue(0);
        ActualizarSenoYCosenoDeLaFuncion();
        if (superficieDeDibujo.VerFunción) {
            superficieDeDibujo.imagenVerFunción
                    = new BufferedImage(superficieDeDibujo.getWidth(),
                            superficieDeDibujo.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics g = superficieDeDibujo.imagenVerFunción.getGraphics();
            g.setColor(plano.colorFondo);
            g.fillRect(0, 0, superficieDeDibujo.getWidth(), superficieDeDibujo.getHeight());
            BufferedImage imagenEtiqueta;
            if (plano.función.ColorDibujado == null) {
                imagenEtiqueta = (BufferedImage) plano.función.ImagenParaNombre(60, Color.BLACK);
            } else {
                imagenEtiqueta = (BufferedImage) plano.función.ImagenParaNombre(60, plano.función.ColorDibujado);
            }
            Dupla pos = new Dupla().UbicarRectanguloDentroDeOtro(plano.Tamaño, new Dupla(imagenEtiqueta.getWidth(), imagenEtiqueta.getHeight()));
            g.drawImage(imagenEtiqueta, pos.intX(), pos.intY(), null);
        }
        plano.función.tabular();
    }//GEN-LAST:event_ModoValueChanged

    public void ActualizarSenoYCosenoDeLaFuncion() {
        plano.función.MODO_GRAFICA = Modo.getSelectedIndex();
        switch (plano.función.MODO_GRAFICA) {
            case POLAR:
                plano.función.CosEspacio = "Cos(t)";
                plano.función.SenEspacio = "Sen(t)";
                break;
            case POLAR2:
                plano.función.CosEspacio = "Cos(t)Sen(5t)";
                plano.función.SenEspacio = "Sen^2(t)";
                break;
            case ASTROIDE_3V:
            case ASTROIDE_4V:
            case ASTROIDE_5V:
            case ASTROIDE_6V:
            case ASTROIDE_7V:
            case ASTROIDE_8V:
            case ASTROIDE_9V:
            case ASTROIDE_10V:
            case ASTROIDE_11V:
            case ASTROIDE_12V:
            case ASTROIDE_13V:
            case ASTROIDE_14V:
            case ASTROIDE_15V:
            case ASTROIDE_16V:
            case ASTROIDE_17V:
            case ASTROIDE_18V:
            case ASTROIDE_19V:
            case ASTROIDE_20V:
            case ASTROIDE_21V:
            case ASTROIDE_22V:
            case ASTROIDE_23V:
            case ASTROIDE_24V:
            case ASTROIDE_25V:
                double k = plano.función.MODO_GRAFICA + plano.función.desface_Astroide_Cardioide_Poligonoide;
                plano.función.CosEspacio = "\\tfrac{1}{" + recortarDecimales(k) + "}  (" + recortarDecimales(k - 1)
                        + " Cos(t) + Cos(" + recortarDecimales(k - 1) + " t)) ";
                plano.función.SenEspacio = "\\tfrac{1}{" + recortarDecimales(k) + "}  (" + recortarDecimales(k - 1)
                        + "Sen(t) - Sen(" + recortarDecimales(k - 1) + " t))";
                break;
            case CARDIOIDE_1V:
            case CARDIOIDE_2V:
            case CARDIOIDE_3V:
            case CARDIOIDE_4V:
            case CARDIOIDE_5V:
            case CARDIOIDE_6V:
            case CARDIOIDE_7V:
            case CARDIOIDE_8V:
            case CARDIOIDE_9V:
            case CARDIOIDE_10V:
            case CARDIOIDE_11V:
            case CARDIOIDE_12V:
            case CARDIOIDE_13V:
            case CARDIOIDE_14V:
            case CARDIOIDE_15V:
            case CARDIOIDE_16V:
            case CARDIOIDE_17V:
            case CARDIOIDE_18V:
            case CARDIOIDE_19V:
            case CARDIOIDE_20V:
            case CARDIOIDE_21V:
            case CARDIOIDE_22V:
            case CARDIOIDE_23V:
            case CARDIOIDE_24V:
            case CARDIOIDE_25V:
                k = plano.función.MODO_GRAFICA - 25 + plano.función.desface_Astroide_Cardioide_Poligonoide;
                plano.función.CosEspacio = "\\tfrac{1}{" + recortarDecimales(k + 2) + "}(" + recortarDecimales(k + 1) + " Cos(t) - Cos(" + recortarDecimales(k + 1) + " t)) ";
                plano.función.SenEspacio = "\\tfrac{1}{" + recortarDecimales(k + 2) + "}(" + recortarDecimales(k + 1) + "Sen(t) - Sen(" + recortarDecimales(k + 1) + " t))";
                break;
            case POLIGONOIDE_1:
                plano.función.CosEspacio = "Cos(t)Sen(t)";
                plano.función.SenEspacio = "Sen^2(t)";
                break;
            case POLIGONOIDE_2:
                plano.función.CosEspacio = "(Sen(θ)(1 - Sen(θ)) + 1)";
                plano.función.SenEspacio = "Cos(θ)(1 - Sen(θ))";
                break;
            case POLIGONOIDE_3:
                plano.función.CosEspacio = "Sen(θ)(1 - Sen(θ)) + 2";
                plano.función.SenEspacio = "Cos(θ)(1 - Sen(θ))";
                break;
        }
        if (plano.función.dibujarEtiqueta) {
            if (plano.función.ColorDibujado == null) {
                plano.función.imagenEtiqueta = (BufferedImage) plano.función.ImagenParaNombre(plano.función.tamañoLetra, plano.función.colorDinamico.Retornarse());
            } else {
                plano.función.imagenEtiqueta = (BufferedImage) plano.función.ImagenParaNombre(plano.función.tamañoLetra, plano.función.ColorDibujado);
            }
        }
    }

    private void EtiquetaFunciónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EtiquetaFunciónActionPerformed
        plano.función.dibujarEtiqueta = EtiquetaFunción.isSelected();
        if (plano.función.dibujarEtiqueta) {
            if (plano.función.ColorDibujado == null) {
                plano.función.imagenEtiqueta = (BufferedImage) plano.función.ImagenParaNombre(plano.función.tamañoLetra, plano.función.colorDinamico.Retornarse());
            } else {
                plano.función.imagenEtiqueta = (BufferedImage) plano.función.ImagenParaNombre(plano.función.tamañoLetra, plano.función.ColorDibujado);
            }
        }
    }//GEN-LAST:event_EtiquetaFunciónActionPerformed

    private void V_AnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_V_AnteriorActionPerformed
        plano.funciones.stream().forEach((Funcion) -> {
            Funcion.V_Decremento();
        });
    }//GEN-LAST:event_V_AnteriorActionPerformed

    private void jTextField3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyTyped
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_DELETE:
            case KeyEvent.VK_BACKSPACE:
                if (jTextField3.getText().equals("")) {
                    jTextField3.setText("0");
                    plano.funciones.stream().forEach((Funcion) -> {
                        Funcion.V_Sustitución(0);
                    });
                }
                return;
            case KeyEvent.VK_CONTROL:
                Control = true;
                break;
            case KeyEvent.VK_END:
            case KeyEvent.VK_ENTER:
            case KeyEvent.VK_HOME:
            case KeyEvent.VK_SHIFT:
                return;
            case KeyEvent.VK_MINUS:
                if (jTextField1.getText().contains("-")) {
                    jTextField1.setText(jTextField1.getText().replace("-", ""));
                    evt.consume();
                } else {
                    jTextField1.setText("-" + jTextField1.getText());
                    evt.consume();
                }
        }
        if (Control) {
            return;
        }
        char c = evt.getKeyChar();
        if (c == '/') {
            evt.consume();
        }
        if (jTextField1.getText().contains(".") && c == '.') {
            evt.consume();
        }
        if (c != KeyEvent.VK_DELETE && c != KeyEvent.VK_BACKSPACE
                && c != KeyEvent.VK_RIGHT && c != KeyEvent.VK_LEFT) {
            if (c < '.' || c > '9') {
                evt.consume();
            }
        }
        try {
            plano.funciones.stream().forEach((función) -> {
                función.V_Sustitución(Double.parseDouble(jTextField3.getText()));
            });
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jTextField3KeyTyped
    boolean Control = false;
    private void jPanel1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentResized
        if (superficieDeDibujo != null) {
            superficieDeDibujo.setSize(jPanel1.getSize());
        }
    }//GEN-LAST:event_jPanel1ComponentResized

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        plano.funciones.stream().forEach((función) -> {
            función.Cometa_EnMovimiento = !plano.función.Cometa_EnMovimiento;
        });
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        superficieDeDibujo.VerFunción = !superficieDeDibujo.VerFunción;
        if (superficieDeDibujo.VerFunción) {
            Imagen image = new Imagen(null);

            int espaciado = 0;
            BufferedImage[] imagenEtiqueta = new BufferedImage[plano.funciones.size()];
            int ancho = 0, alto = 0, i = 0;

            for (Funcion función : plano.funciones) {
                //Generar todas las imagenes de las curvas
                if (función.ColorDibujado == null) {
                    imagenEtiqueta[i] = (BufferedImage) función.ImagenParaNombre(60, Color.BLACK);
                } else {
                    imagenEtiqueta[i] = (BufferedImage) función.ImagenParaNombre(60, plano.función.ColorDibujado);
                }
                ancho = imagenEtiqueta[i].getWidth() > ancho ? imagenEtiqueta[i].getWidth() : ancho;
                alto += imagenEtiqueta[i].getHeight() + espaciado;
                i++;
            }

            superficieDeDibujo.imagenVerFunción
                    = new BufferedImage(superficieDeDibujo.Tamaño().intX(),
                            superficieDeDibujo.Tamaño().intY(), 2);

            Graphics g = superficieDeDibujo.imagenVerFunción.getGraphics();
            g.setColor(plano.colorFondo);
            g.fillRect(0, 0, superficieDeDibujo.getWidth(), superficieDeDibujo.getHeight());

            i = 0;
            int posY = 0;
            BufferedImage etiqueta = new BufferedImage(ancho, alto, 2);
            Graphics ge = etiqueta.getGraphics();

            for (BufferedImage bufferedImage : imagenEtiqueta) {
                ge.drawImage(bufferedImage, 0, posY, null);
                posY += bufferedImage.getHeight() + espaciado;
            }

            if (ancho > plano.Tamaño.X) {
                System.out.println("Ximg: " + etiqueta.getWidth() + " Xplano: " + plano.Tamaño.X + " proporción: " + plano.Tamaño.X / etiqueta.getWidth());
                etiqueta = image.Escalar(etiqueta, plano.Tamaño.X / etiqueta.getWidth(), false);
            }
            if (alto > plano.Tamaño.Y) {
                etiqueta = image.Escalar(etiqueta, plano.Tamaño.Y / etiqueta.getHeight(), false);
            }
            Dupla pos = new Dupla().UbicarRectanguloDentroDeOtro(plano.Tamaño, new Dupla(etiqueta.getWidth(), etiqueta.getHeight()));
            g.drawImage(etiqueta, pos.intX(), pos.intY(), null);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jSlider2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider2StateChanged
        plano.funciones.stream().forEach((función) -> {
            double unidad = 100;
            función.Dominio_Máx = jSlider2.getValue() * pi / abs(jSlider2.getMaximum() / unidad);
            función.tabular();
            if (función.dibujarEtiqueta) {
                if (función.ColorDibujado == null) {
                    función.imagenEtiqueta = (BufferedImage) función.ImagenParaNombre(función.tamañoLetra, función.colorDinamico.Retornarse());
                } else {
                    función.imagenEtiqueta = (BufferedImage) función.ImagenParaNombre(función.tamañoLetra, función.ColorDibujado);
                }
            }
        });
    }//GEN-LAST:event_jSlider2StateChanged

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        plano.funciones.stream().forEach((función) -> {
            double unidad = 100;
            función.Dominio_Mín = jSlider1.getValue() * pi / abs(jSlider1.getMinimum() / unidad);
            función.tabular();
            if (función.dibujarEtiqueta) {
                if (función.ColorDibujado == null) {
                    función.imagenEtiqueta = (BufferedImage) función.ImagenParaNombre(función.tamañoLetra, función.colorDinamico.Retornarse());
                } else {
                    función.imagenEtiqueta = (BufferedImage) función.ImagenParaNombre(función.tamañoLetra, función.ColorDibujado);
                }
            }
        });
    }//GEN-LAST:event_jSlider1StateChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        String textoGEOGEBRA = "";
        int cont = 0;

        for (Funcion función : plano.funciones) {
            cont++;
            if (plano.funciones.size() > 1) {
                textoGEOGEBRA += "Curva " + cont + "\n";
            }
            if (plano.función.MODO_GRAFICA > RECTANGULAR) {
                textoGEOGEBRA += "x=" + FuncionesPropias(función.FunciónY, GEOGEBRA) + función.CosEspacio + "\\\\" + "y=(" + FuncionesPropias(función.FunciónY, GEOGEBRA) + ")" + función.SenEspacio;
            } else if (función.FunciónX.equals("t")) {
                textoGEOGEBRA += "y= " + FuncionesPropias(función.FunciónY.replace("v", recortarDecimales(función.v) + ""), GEOGEBRA).replace("t", "x");
            } else {
                textoGEOGEBRA
                        += "Curva[" + FuncionesPropias(función.FunciónX.replace("v", recortarDecimales(función.v) + ""), GEOGEBRA)
                        + "," + FuncionesPropias(función.FunciónY.replace("v", recortarDecimales(función.v) + ""), GEOGEBRA)
                        + ",t," + recortarDecimales(función.Dominio_Mín / π) + "pi, " + recortarDecimales(función.Dominio_Máx / π) + "pi]";
            }
            textoGEOGEBRA += "\n\n";
        }

        textoGEOGEBRA = textoGEOGEBRA
                .replace("Sen", "sen")
                .replace("Cos", "cos")
                .replace("Sgn", "sgn")
                .replace("(\\tfrac{", "(")
                .replace("\\tfrac{", "*")
                .replace("}{", "/").replace("}", "*")
                .replace("(K-1)", (plano.función.MODO_GRAFICA - 1) + "")
                .replace("K", plano.función.MODO_GRAFICA + "");

        jTextArea1.setText("GeoGebra:\n"
                + textoGEOGEBRA
                .concat("\n\nDescarga geogebra\n"
                        + "https://www.geogebra.org/download?lang=es\n"
                        + "\n"
                        + "Entra a fooplot\n"
                        + "http://fooplot.com/?lang=es\n"
                        + "\n"
                        + "------------------------------------------------------------\n"
                        + "\n"
                        + "Calculadora Gráfica | Graphic Calculator\n"
                        + "Desarrollada en Java | Developed in Java\n"
                        + "Descarga Código fuente | Download Code Source\n"
                        + "\n"
                        + "https://mega.nz/#F!w4kVmDIL!hgfc7az-nACYhHnDLz3XAw\n"
                        + "\n"
                        + "---------------------------------------------------------------------")
        );
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (java.awt.Desktop.isDesktopSupported()) {
            try {
                Desktop dk = Desktop.getDesktop();
                dk.browse(new URI("http://fooplot.com/?lang=es"));
            } catch (Exception e) {
                System.out.println("Error al abrir URL: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        if (java.awt.Desktop.isDesktopSupported()) {
            try {
                Desktop dk = Desktop.getDesktop();
                dk.browse(new URI("https://www.geogebra.org/download"));
            } catch (Exception e) {
                System.out.println("Error al abrir URL: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void DesfaceAstroCardioidal_SliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_DesfaceAstroCardioidal_SliderStateChanged
        double valor = DesfaceAstroCardioidal_Slider.getValue();
        double Unidad = DesfaceAstroCardioidal_Slider.getMaximum();
        double proporción = valor / Unidad;
        if (plano.función.MODO_GRAFICA >= ASTROIDE_3V && plano.función.MODO_GRAFICA <= ASTROIDE_25V) {
            Desface.setText("Desface Astroidal: " + proporción);
        } else if (plano.función.MODO_GRAFICA >= CARDIOIDE_1V && plano.función.MODO_GRAFICA <= CARDIOIDE_25V) {
            Desface.setText("Desface Cardioidal: " + proporción);
        } else {
            Desface.setText("Inhabilitado");
            return;
        }
        plano.función.desface_Astroide_Cardioide_Poligonoide = proporción;
        ActualizarSenoYCosenoDeLaFuncion();
        plano.función.tabular();
    }//GEN-LAST:event_DesfaceAstroCardioidal_SliderStateChanged

    private void DesfaceAstroCardioidal_SliderKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DesfaceAstroCardioidal_SliderKeyTyped
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_DELETE:
                DesfaceAstroCardioidal_Slider.setValue(0);
        }
    }//GEN-LAST:event_DesfaceAstroCardioidal_SliderKeyTyped

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        plano.funciones.stream().forEach((Funcion) -> {
            Funcion.IncrementoV = -Funcion.IncrementoV;
        });
        jTextField1.setText(plano.función.IncrementoV + "");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jSlider3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider3StateChanged
        jLabel1.setText("Rotación: " + jSlider3.getValue());
        plano.funciones.stream().forEach((Funcion) -> {
            Funcion.Rotación_EspacioParamétrico = jSlider3.getValue() * π / 180;
            Funcion.tabular();
        });
    }//GEN-LAST:event_jSlider3StateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Abajo;
    private javax.swing.JButton Arriba;
    private javax.swing.JRadioButton Cuadricula;
    private javax.swing.JButton Derecha;
    private javax.swing.JLabel Desface;
    private javax.swing.JSlider DesfaceAstroCardioidal_Slider;
    private javax.swing.JRadioButton Ejes;
    private javax.swing.JRadioButton EtiquetaEjes;
    private javax.swing.JRadioButton EtiquetaFunción;
    private javax.swing.JButton InvertirRelacion;
    private javax.swing.JButton Izquierda;
    private javax.swing.JButton Menos;
    private javax.swing.JList<String> Modo;
    private javax.swing.JButton Más;
    private javax.swing.JRadioButton PintarPoligono;
    private javax.swing.JButton Restaurar;
    private javax.swing.JButton V_Anterior;
    private javax.swing.JButton V_Siguiente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    private javax.swing.JSlider jSlider3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
