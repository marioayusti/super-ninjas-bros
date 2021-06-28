/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visuales;

import Modelos.*;
import java.awt.*;
import java.util.logging.*;
import javax.swing.*;

/**
 *
 * @author G40
 */
public class Mundo_M extends javax.swing.JPanel {

    Game_PRO Game;
    JProgressBar Energia;
    JLabel NumArmas;
    JLabel Vidas;
    boolean[] flagsEst;
    boolean[] flagsMOV;
    int[] preM;
    int[] A_XY;
    Player p;
    String[] Poss;
    EnemigoH[] EHs;
    EBowser EBowser;
    Honguito[] Hs = new Honguito[1];
    Piso PisoM[] = new Piso[7];
    BloqueN Bloques[] = new BloqueN[36];
    Arma[] Armas = new Arma[18];
    Fondo Fondos[] = new Fondo[24];
    int aux = 0;

    /**
     * Creates new form Nivel_A2
     */
    public Mundo_M() {
        initComponents();
        this.PisoM[0] = new Piso(0, 340, 600, 50, "../Pictures/PisoM.png");
        this.PisoM[1] = new Piso(600, 340, 600, 50, "../Pictures/PisoM.png");
        this.PisoM[2] = new Piso(1300, 340, 600, 50, "../Pictures/PisoM.png");
        this.PisoM[3] = new Piso(2500, 340, 700, 40, "../Pictures/PisoM.png");
        this.PisoM[4] = new Piso(1900, 340, 600, 50, "../Pictures/PisoM.png");
        this.PisoM[5] = new Piso(3910, 0, 600, 50, "../Pictures/PisoM.png");
        this.PisoM[6] = new Piso(4610, 340, 600, 50, "../Pictures/PisoM.png");
        this.Bloques[0] = new BloqueN(500, 220, 30, 30, "../Pictures/BloqueMario1.png", 1);
        this.Bloques[1] = new BloqueN(620, 220, 30, 30, "../Pictures/BloqueMario.gif", 0);
        this.Bloques[2] = new BloqueN(650, 220, 30, 30, "../Pictures/BloqueMario1.png", 2);
        this.Bloques[3] = new BloqueN(680, 220, 30, 30, "../Pictures/BloqueMario.gif", 0);
        this.Bloques[4] = new BloqueN(710, 220, 30, 30, "../Pictures/BloqueMario1.png", 1);
        this.Bloques[5] = new BloqueN(740, 220, 30, 30, "../Pictures/BloqueMario.gif", 0);
        this.Bloques[6] = new BloqueN(680, 100, 30, 30, "../Pictures/BloqueMario1.png", 1);
        this.Bloques[7] = new BloqueN(890, 280, 60, 60, "../Pictures/Verde.png", 0);
        this.Bloques[8] = new BloqueN(1025, 190, 30, 30, "../Pictures/BloqueMario.gif", 0);
        this.Bloques[9] = new BloqueN(1055, 160, 30, 30, "../Pictures/BloqueMario.gif", 0);
        this.Bloques[10] = new BloqueN(1085, 130, 30, 30, "../Pictures/BloqueMario.gif", 0);
        this.Bloques[11] = new BloqueN(1115, 100, 30, 30, "../Pictures/BloqueMario.gif", 0);
        this.Bloques[12] = new BloqueN(1145, 70, 30, 30, "../Pictures/BloqueMario.gif", 0);
        this.Bloques[13] = new BloqueN(1175, 70, 30, 30, "../Pictures/BloqueMario.gif", 0);
        this.Bloques[14] = new BloqueN(1205, 70, 30, 30, "../Pictures/BloqueMario.gif", 0);
        this.Bloques[15] = new BloqueN(1235, 70, 30, 30, "../Pictures/BloqueMario.gif", 0);
        this.Bloques[16] = new BloqueN(1265, 70, 30, 30, "../Pictures/BloqueMario.gif", 0);
        this.Bloques[17] = new BloqueN(1295, 70, 30, 30, "../Pictures/BloqueMario.gif", 0);
        this.Bloques[18] = new BloqueN(1325, 70, 30, 30, "../Pictures/BloqueMario.gif", 0);
        this.Bloques[19] = new BloqueN(1355, 70, 30, 30, "../Pictures/BloqueMario.gif", 0);
        this.Bloques[20] = new BloqueN(1385, 70, 30, 30, "../Pictures/BloqueMario.gif", 0);
        this.Bloques[21] = new BloqueN(1295, -80, 30, 30, "../Pictures/BloqueMario1.png", 2);
        this.Bloques[22] = new BloqueN(2400, 280, 60, 60, "../Pictures/Verde.png", 0);
        this.Bloques[23] = new BloqueN(2660, 260, 60, 80, "../Pictures/Verde.png", 0);
        this.Bloques[24] = new BloqueN(2920, 260, 60, 80, "../Pictures/Verde.png", 0);
        this.Bloques[25] = new BloqueN(3080, 190, 30, 30, "../Pictures/Vacia.png", 3);
        this.Bloques[26] = new BloqueN(3310, 310, 30, 30, "../Pictures/BloqueMario.gif", 0);
        this.Bloques[27] = new BloqueN(3460, 310, 30, 30, "../Pictures/BloqueMario.gif", 0);
        this.Bloques[28] = new BloqueN(3560, 200, 30, 30, "../Pictures/BloqueMario.gif", 0);
        this.Bloques[29] = new BloqueN(3660, 100, 30, 30, "../Pictures/BloqueMario.gif", 0);
        this.Bloques[30] = new BloqueN(3760, 0, 30, 30, "../Pictures/BloqueMario.gif", 0);
        this.Bloques[31] = new BloqueN(4060, -150, 30, 30, "../Pictures/BloqueMario.gif", 1);
        this.Bloques[32] = new BloqueN(4090, -150, 30, 30, "../Pictures/BloqueMario.gif", 1);
        this.Bloques[33] = new BloqueN(4120, -150, 30, 30, "../Pictures/BloqueMario.gif", 3);
        this.Bloques[34] = new BloqueN(4060, -270, 30, 30, "../Pictures/BloqueMario.gif", 2);
        this.Bloques[35] = new BloqueN(1770, 190, 30, 30, "../Pictures/Vacia.png", 2);
        this.Armas[0] = new Arma(180, 310, 30, 30, "../Pictures/KunaiP.gif");
        this.Armas[1] = new Arma(1000, 310, 30, 30, "../Pictures/KunaiP.gif");
        this.Armas[2] = new Arma(1030, 310, 30, 30, "../Pictures/KunaiP.gif");
        this.Armas[3] = new Arma(1145, 40, 30, 30, "../Pictures/KunaiP.gif");
        this.Armas[4] = new Arma(1175, 40, 30, 30, "../Pictures/KunaiP.gif");
        this.Armas[5] = new Arma(1205, 40, 30, 30, "../Pictures/KunaiP.gif");
        this.Armas[6] = new Arma(1235, 40, 30, 30, "../Pictures/KunaiP.gif");
        this.Armas[7] = new Arma(1265, 40, 30, 30, "../Pictures/KunaiP.gif");
        this.Armas[8] = new Arma(1295, 40, 30, 30, "../Pictures/KunaiP.gif");
        this.Armas[9] = new Arma(1325, 40, 30, 30, "../Pictures/KunaiP.gif");
        this.Armas[10] = new Arma(1355, 40, 30, 30, "../Pictures/KunaiP.gif");
        this.Armas[11] = new Arma(1385, 40, 30, 30, "../Pictures/KunaiP.gif");
        this.Armas[12] = new Arma(1900, 310, 30, 30, "../Pictures/KunaiP.gif");
        this.Armas[13] = new Arma(2500, 310, 30, 30, "../Pictures/KunaiP.gif");
        this.Armas[14] = new Arma(2750, 310, 30, 30, "../Pictures/KunaiP.gif");
        this.Armas[15] = new Arma(4300, -30, 30, 30, "../Pictures/KunaiP.gif");
        this.Armas[16] = new Arma(4330, -30, 30, 30, "../Pictures/KunaiP.gif");
        this.Armas[17] = new Arma(4360, -30, 30, 30, "../Pictures/KunaiP.gif");
        this.Fondos[0] = new Fondo(1200, -30, 1000, 400, "../Pictures/FondoMario.jpg");
        this.Fondos[1] = new Fondo(0, 290, 150, 50, "../Pictures/MontanaMariog.png");
        this.Fondos[2] = new Fondo(250, 70, 40, 40, "../Pictures/NubeMario.png");
        this.Fondos[3] = new Fondo(360, 320, 100, 20, "../Pictures/ArbusMariog.png");
        this.Fondos[4] = new Fondo(480, 310, 100, 30, "../Pictures/MontanaMario.png");
        this.Fondos[5] = new Fondo(730, 310, 60, 30, "../Pictures/ArbusMario.png");
        this.Fondos[6] = new Fondo(650, 60, 40, 40, "../Pictures/NubeMario.png");
        this.Fondos[7] = new Fondo(890, 70, 100, 40, "../Pictures/NubesMario.png");
        this.Fondos[8] = new Fondo(2490, 310, 60, 30, "../Pictures/ArbusMario.png");
        this.Fondos[9] = new Fondo(2300, 70, 100, 40, "../Pictures/NubesMario.png");
        this.Fondos[10] = new Fondo(2720, 290, 150, 50, "../Pictures/MontanaMariog.png");
        this.Fondos[11] = new Fondo(3000, 320, 100, 20, "../Pictures/ArbusMariog.png");
        this.Fondos[12] = new Fondo(2850, 60, 60, 40, "../Pictures/NubeMario.png");
        this.Fondos[13] = new Fondo(3100, 40, 60, 40, "../Pictures/NubeMario.png");
        this.Fondos[14] = new Fondo(3530, -130, 100, 40, "../Pictures/NubesMario.png");
        this.Fondos[15] = new Fondo(4000, -220, 100, 40, "../Pictures/NubesMario.png");
        this.Fondos[16] = new Fondo(4500, -70, 60, 40, "../Pictures/NubeMario.png");
        this.Fondos[17] = new Fondo(4700, -60, 100, 40, "../Pictures/NubesMario.png");
        this.Fondos[18] = new Fondo(4333, 0, 60, 40, "../Pictures/NubeMario.png");
        this.Fondos[19] = new Fondo(4875, 70, 100, 40, "../Pictures/NubesMario.png");
        this.Fondos[20] = new Fondo(5200, 60, 60, 40, "../Pictures/NubeMario.png");
        this.Fondos[21] = new Fondo(4700, 320, 100, 20, "../Pictures/ArbusMariog.png");
        this.Fondos[22] = new Fondo(4820, 290, 150, 50, "../Pictures/MontanaMariog.png");
        this.Fondos[23] = new Fondo(5170, 120, 40, 220, "../Pictures/Bandera.png");
    }

    public void preferencias(Player p, String[] Poss, EnemigoH[] EHs, EBowser EBowser, JProgressBar Energia, JLabel NumArmas, JLabel Vidas, boolean[] flagsEst, boolean[] flagsMOV, int[] preM, int[] A_XY, Game_PRO Game) {
        this.Game = Game;
        this.p = p;
        this.Poss = Poss;
        this.EHs = EHs;
        this.EBowser = EBowser;
        this.Energia = Energia;
        this.NumArmas = NumArmas;
        this.Vidas = Vidas;
        this.flagsEst = flagsEst;
        this.flagsMOV = flagsMOV;
        this.preM = preM;
        this.A_XY = A_XY;
        (new Thread(new Camara(this.p, this.A_XY, this.preM))).start();
        (new Thread(new Colisiones(this.flagsEst, this.flagsMOV, this.p, this.PisoM, this.Bloques, this.Hs, this.Poss))).start();
        (new Thread(new Colisiones2(this.p, this.A_XY, this.Armas, this.Hs, this.EHs, this.EBowser, this.Poss[5], this.flagsMOV, this.Game))).start();
        (new Thread(new Gravedad(this.p, this.flagsMOV))).start();
        (new Thread(EHs[0])).start();
        (new Thread(EHs[1])).start();
        (new Thread(EHs[2])).start();
        (new Thread(EHs[3])).start();
        (new Thread(EHs[4])).start();
        (new Thread(EHs[5])).start();
        (new Thread(EHs[6])).start();
        (new Thread(EHs[7])).start();
        (new Thread(EHs[8])).start();
        (new Thread(EHs[9])).start();
        (new Thread(EHs[10])).start();
        (new Thread(EHs[11])).start();
        (new Thread(this.EBowser)).start();

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

        setBackground(new java.awt.Color(0, 204, 204));
        setPreferredSize(new java.awt.Dimension(400, 300));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.

        if (this.A_XY != null) {
            g.translate(this.getX() + this.A_XY[1], this.getY() + this.A_XY[2]);
        }

        if (this.Energia != null && this.NumArmas != null && this.Vidas != null) {
            this.Energia.setValue(this.p.getEnergia());
            this.NumArmas.setText("Armas: " + this.p.getNumArmas());
            this.Vidas.setText("X" + this.p.getVidas());
        }
        for (int i = 0; i < this.Fondos.length; i++) {
            g.drawImage(this.Fondos[i].getImagen().getImage(), this.Fondos[i].getX(), this.Fondos[i].getY(), this.Fondos[i].getAncho(), this.Fondos[i].getAlto(), this);
        }
        if (this.p != null) {
            this.p.setRectangulo(new Rectangle(this.p.getX(), this.p.getY(), this.p.getAncho() + 3, this.p.getAlto() + 2));
            g.drawImage(this.p.getImagen().getImage(), this.p.getX(), this.p.getY(), this.p.getAncho(), this.p.getAlto(), this);
        }
        if (this.EBowser != null) {
            g.drawImage(this.EBowser.getImagen().getImage(), this.EBowser.getX(), this.EBowser.getY(), this.EBowser.getAncho(), this.EBowser.getAlto(), this);
            for (int i = 0; i < this.EBowser.getAtaques().length; i++) {
                if (this.EBowser.getVida() <= 0) {
                    this.EBowser = null;
                }
                if (this.EBowser.getAtaques()[i] != null) {
                    g.drawImage(this.EBowser.getAtaques()[i].getImagen().getImage(), this.EBowser.getAtaques()[i].getX(), this.EBowser.getAtaques()[i].getY(), this.EBowser.getAtaques()[i].getAncho(), this.EBowser.getAtaques()[i].getAlto(), this);
                }
            }
        }
        for (int i = 0; i < this.PisoM.length; i++) {
            g.drawImage(this.PisoM[i].getImagen().getImage(), this.PisoM[i].getX(), this.PisoM[i].getY(), this.PisoM[i].getAncho(), this.PisoM[i].getAlto(), this);
        }
        if (this.Bloques != null) {
            for (int i = 0; i < this.Bloques.length; i++) {
                if (this.Bloques[i] != null) {
                    g.drawImage(this.Bloques[i].getImagen().getImage(), this.Bloques[i].getX(), this.Bloques[i].getY(), this.Bloques[i].getAncho(), this.Bloques[i].getAlto(), this);
                }
            }
        }
        if (this.Armas != null) {
            for (int i = 0; i < this.Armas.length; i++) {
                if (this.Armas[i] != null) {
                    g.drawImage(this.Armas[i].getImagen().getImage(), this.Armas[i].getX(), this.Armas[i].getY(), this.Armas[i].getAncho(), this.Armas[i].getAlto(), this);
                }
            }
        }
        if (this.p != null) {
            for (int i = 0; i < this.p.getBolsa().length; i++) {
                if (this.p.getBolsa()[i] != null) {
                    g.drawImage(this.p.getBolsa()[i].getImagen().getImage(), this.p.getBolsa()[i].getX(), this.p.getBolsa()[i].getY(), this.p.getBolsa()[i].getAncho(), this.p.getBolsa()[i].getAlto(), this);
                }
            }
        }
        if (this.EHs != null) {
            for (int i = 0; i < this.EHs.length; i++) {
                if (this.EHs[i] != null) {
                    g.drawImage(this.EHs[i].getImagen().getImage(), this.EHs[i].getX(), this.EHs[i].getY(), this.EHs[i].getAncho(), this.EHs[i].getAlto(), this);
                }
            }
        }
        if (this.Hs[0] != null) {
            g.drawImage(this.Hs[0].getImagen().getImage(), this.Hs[0].getX(), this.Hs[0].getY(), this.Hs[0].getAncho(), this.Hs[0].getAlto(), this);
        }
        repaint();
    }

}
