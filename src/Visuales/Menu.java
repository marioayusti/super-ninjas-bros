/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visuales;

import Modelos.*;
import java.applet.AudioClip;
import java.awt.*;

/**
 *
 * @author G40
 */
public class Menu extends javax.swing.JFrame
{
    Game_PRO nuevoGame;
    Selector Selector = new Selector(20, 60, 110, 220);
    Personaje[] Personajes = new Personaje[4];
    AudioClip Cancion=java.applet.Applet.newAudioClip(getClass().getResource("../Sonido/Menu.wav"));
    
    /**
     * Creates new form Menu
     */
    public Menu()
    {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(this);
        this.Personajes[0] = new Personaje(30, 70, 90, 200, "../Pictures/Players/NarutoSe.png", 0);
        this.Personajes[1] = new Personaje(230, 70, 90, 200, "../Pictures/Players/KakashiSe.png", 1);
        this.Personajes[2] = new Personaje(430, 70, 90, 200, "../Pictures/Players/KakashiASe.png", 2);
        this.Personajes[3] = new Personaje(630, 70, 90, 200, "../Pictures/Players/ItachiSe.png", 3);
        this.panelDeSeleccion1.Selector(this.Selector, this.Personajes, this.Caracteristicas);
        this.Cancion.play();
    }

    public void Personaje(int p)
    {
        if (p == 0) {
            String[] ADs = {"../Pictures/Players/Naruto/D.png", "../Pictures/Players/Naruto/D0.png", "../Pictures/Players/Naruto/D1.png", "../Pictures/Players/Naruto/D2.png", "../Pictures/Players/Naruto/D3.png"};
            String[] AAs = {"../Pictures/Players/Naruto/A.png", "../Pictures/Players/Naruto/A0.png", "../Pictures/Players/Naruto/A1.png", "../Pictures/Players/Naruto/A2.png", "../Pictures/Players/Naruto/A3.png"};
            String[] L = {"../Pictures/Players/Naruto/L.png", "../Pictures/Players/Naruto/L0.png"};
            String[] Poss = {"../Pictures/Players/Naruto/P.png", "../Pictures/Players/Naruto/S.png", "../Pictures/Players/Naruto/SA.png", "../Pictures/Players/Naruto/SD.png", "../Pictures/Players/Naruto/E.png", "../Pictures/Players/Naruto/M.png"};
            this.nuevoGame=new Game_PRO();
            this.nuevoGame.Pre1(ADs, AAs, L, Poss, p);
        }
        else if (p == 1) {
            String[] ADs = {"../Pictures/Players/Kakashi/D.png", "../Pictures/Players/Kakashi/D0.png", "../Pictures/Players/Kakashi/D1.png", "../Pictures/Players/Kakashi/D2.png", "../Pictures/Players/Kakashi/D3.png", "../Pictures/Players/Kakashi/D4.png"};
            String[] AAs = {"../Pictures/Players/Kakashi/A.png", "../Pictures/Players/Kakashi/A0.png", "../Pictures/Players/Kakashi/A1.png", "../Pictures/Players/Kakashi/A2.png", "../Pictures/Players/Kakashi/A3.png", "../Pictures/Players/Kakashi/A4.png"};
            String[] L = {"../Pictures/Players/Kakashi/L.png", "../Pictures/Players/Kakashi/L0.png"};
            String[] Poss = {"../Pictures/Players/Kakashi/P.png", "../Pictures/Players/Kakashi/S.png", "../Pictures/Players/Kakashi/SA.png", "../Pictures/Players/Kakashi/SD.png", "../Pictures/Players/Kakashi/E.png", "../Pictures/Players/Kakashi/M.png"};
            this.nuevoGame=new Game_PRO();
            this.nuevoGame.Pre1(ADs, AAs, L, Poss, p);
        }
        else if (p == 2) {
            String[] ADs = {"../Pictures/Players/KakashiA/D.png", "../Pictures/Players/KakashiA/D0.png", "../Pictures/Players/KakashiA/D1.png", "../Pictures/Players/KakashiA/D2.png", "../Pictures/Players/KakashiA/D3.png", "../Pictures/Players/KakashiA/D4.png"};
            String[] AAs = {"../Pictures/Players/KakashiA/A.png", "../Pictures/Players/KakashiA/A0.png", "../Pictures/Players/KakashiA/A1.png", "../Pictures/Players/KakashiA/A2.png", "../Pictures/Players/KakashiA/A3.png", "../Pictures/Players/KakashiA/A4.png"};
            String[] L = {"../Pictures/Players/KakashiA/L.png", "../Pictures/Players/KakashiA/L0.png"};
            String[] Poss = {"../Pictures/Players/KakashiA/P.png", "../Pictures/Players/KakashiA/S.png", "../Pictures/Players/KakashiA/SA.png", "../Pictures/Players/KakashiA/SD.png", "../Pictures/Players/KakashiA/E.png", "../Pictures/Players/KakashiA/M.png"};
            this.nuevoGame=new Game_PRO();
            this.nuevoGame.Pre1(ADs, AAs, L, Poss, p);
        }
        else if (p == 3) {
            String[] ADs = {"../Pictures/Players/Itachi/D.png", "../Pictures/Players/Itachi/D0.png", "../Pictures/Players/Itachi/D1.png", "../Pictures/Players/Itachi/D2.png", "../Pictures/Players/Itachi/D3.png", "../Pictures/Players/Itachi/D4.png"};
            String[] AAs = {"../Pictures/Players/Itachi/A.png", "../Pictures/Players/Itachi/A0.png", "../Pictures/Players/Itachi/A1.png", "../Pictures/Players/Itachi/A2.png", "../Pictures/Players/Itachi/A3.png", "../Pictures/Players/Itachi/A4.png"};
            String[] L = {"../Pictures/Players/Itachi/L.png", "../Pictures/Players/Itachi/L0.png", "../Pictures/Players/Itachi/L1.png"};
            String[] Poss = {"../Pictures/Players/Itachi/P.png", "../Pictures/Players/Itachi/S.png", "../Pictures/Players/Itachi/SA.png", "../Pictures/Players/Itachi/SD.png", "../Pictures/Players/Itachi/E.png", "../Pictures/Players/Itachi/M.png"};
            this.nuevoGame=new Game_PRO();
            this.nuevoGame.Pre1(ADs, AAs, L, Poss, p);
        }
        this.nuevoGame.setVisible(true);
        this.nuevoGame.setLocationRelativeTo(this);
        this.Cancion.stop();
        Menu.this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        panelDeSeleccion1 = new Visuales.PanelDeSeleccion();
        Caracteristicas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Selección de personaje");
        addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                formKeyPressed(evt);
            }
        });

        panelDeSeleccion1.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout panelDeSeleccion1Layout = new javax.swing.GroupLayout(panelDeSeleccion1);
        panelDeSeleccion1.setLayout(panelDeSeleccion1Layout);
        panelDeSeleccion1Layout.setHorizontalGroup(
            panelDeSeleccion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 761, Short.MAX_VALUE)
        );
        panelDeSeleccion1Layout.setVerticalGroup(
            panelDeSeleccion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );

        Caracteristicas.setFont(new java.awt.Font("Tempus Sans ITC", 0, 12)); // NOI18N
        Caracteristicas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Caracteristicas.setText("Caracteristicas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Caracteristicas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelDeSeleccion1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelDeSeleccion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Caracteristicas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_formKeyPressed
    {//GEN-HEADEREND:event_formKeyPressed

        if (evt.getKeyCode() == evt.VK_RIGHT) {
            if (this.Selector.getX() < 620)
                this.Selector.setX(this.Selector.getX() + 200);
        }
        else if (evt.getKeyCode() == evt.VK_LEFT) {
            if (this.Selector.getX() > 20)
                this.Selector.setX(this.Selector.getX() - 200);
        }
        else if (evt.getKeyCode() == evt.VK_ENTER)
            for (int i = 0; i < this.Personajes.length; i++)
                if (new Rectangle(this.Selector.getX(), this.Selector.getY(), this.Selector.getAncho(), this.Selector.getAlto()).intersects(this.Personajes[i].getRectangulo()))
                    this.Personaje(this.Personajes[i].getTipo());
    }//GEN-LAST:event_formKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
        }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Caracteristicas;
    private Visuales.PanelDeSeleccion panelDeSeleccion1;
    // End of variables declaration//GEN-END:variables
}
