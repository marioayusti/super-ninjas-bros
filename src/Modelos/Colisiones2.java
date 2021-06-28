/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import Visuales.*;
import java.awt.*;
import java.awt.Menu;
import java.util.logging.*;
import javax.swing.*;

/**
 *
 * @author G40
 */
public class Colisiones2 implements Runnable {

    Game_PRO Game;
    Arma[] Armas;
    Honguito[] Hs;
    EnemigoH[] EnemigosHs;
    EBowser EBowser;
    boolean PV = false;
    Player p;
    String M;
    int[] A_XY;
    boolean flagsE = true;
    boolean[] flagsMOV;
    int j = -1;

    public Colisiones2(Player p, int[] A_XY, Arma[] Armas, Honguito[] Hs, EnemigoH[] EHs, EBowser EBow, String M, boolean[] flagsMOV, Game_PRO Game) {
        this.Armas = Armas;
        this.Hs = Hs;
        this.p = p;
        this.EnemigosHs = EHs;
        this.A_XY = A_XY;
        this.M = M;
        this.flagsMOV = flagsMOV;
        this.EBowser = EBow;
        this.Game = Game;
    }

    @Override
    public void run() {
        while (true) {
            this.flagsE = true;
            for (int i = 0; i < this.Armas.length; i++) {
                if (this.Armas[i] != null) {
                    if (this.p.getRectangulo().intersects(this.Armas[i].getRectangulo())) {
                        this.Armas[i] = null;
                        this.p.setNumArmas(this.p.getNumArmas() + 1);
                    }
                }
            }
            if (this.Hs[0] != null && this.p.getRectangulo().intersects(this.Hs[0].getRectangulo())) {
                if (this.Hs[0].getTipo() == 2) {
                    this.p.setEnergia(this.p.getEnergia() + 30);
                } else if (this.Hs[0].getTipo() == 3) {
                    this.p.setVidas(this.p.getVidas() + 1);
                }
                this.Hs[0] = null;
            }
            if (new Rectangle(this.p.getRectangulo()).intersects(new Rectangle(this.EBowser.getX(), this.EBowser.getY(), this.EBowser.getAncho(), this.EBowser.getAlto())) && !this.flagsMOV[6]) {
                this.PV = true;
                this.p.setVidas(1);
            } else {
                for (int i = 0; i < this.EnemigosHs.length && this.flagsE; i++) {
                    if (this.j != i && this.EnemigosHs[i] != null && (this.p.getRectangulo().intersects(new Rectangle(this.EnemigosHs[i].getX(), this.EnemigosHs[i].getY(), this.EnemigosHs[i].getAncho(), this.EnemigosHs[i].getAlto()))) && !this.flagsMOV[6]) {
                        if ((this.p.getY() + this.p.getAlto()) <= this.EnemigosHs[i].getY() + 3) {
                            (new Thread(new EnemigoHMuerte(EnemigosHs, i))).start();
                            this.flagsE = false;
                            this.j = i;
                        } else if (this.p.getVidas() > 0 && this.EnemigosHs[i].getAlto() == 30) {
                            this.PV = true;
                        }
                    }
                }
            }
            if (this.PV || (this.p.getVidas() == 0)) {
                if ((this.p.getVidas() - 1) >= 0) {
                    this.p.setVidas(this.p.getVidas() - 1);
                }
                this.PV = false;
                if (this.p.getVidas() == 0) {
                    try {
                        this.flagsMOV[5] = false;
                        this.p.setY(this.p.getY() + this.p.getAlto() - this.p.getAncho());
                        this.p.setAncho(this.p.getAlto());
                        this.p.setAlto(this.p.getAncho());
                        this.p.setImagen(new ImageIcon(getClass().getResource(this.M)));
                        Thread.sleep(1500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Colisiones2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(null, "GAME OVER", "Perdiste!!!", JOptionPane.INFORMATION_MESSAGE);
                    Visuales.Menu Menu1 = new Visuales.Menu();
                    Menu1.setVisible(true);
                    Menu1.setLocationRelativeTo(this.Game);
                    this.Game.dispose();
                    this.p.setVidas(-1);
                }
            }
        }
    }

}

//    new Rectangle(this.Armas[i].getX(), this.Armas[i].getY(), this.Armas[i].getAncho(), this.Armas[i].getAlto())

