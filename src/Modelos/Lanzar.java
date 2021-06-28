/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.awt.*;
import java.util.logging.*;
import javafx.scene.paint.*;
import javax.swing.*;
import sun.awt.*;

/**
 *
 * @author G40
 */
public class Lanzar implements Runnable {

    int a;
    int Lon;
    Player p;
    String[] L;
    String P;
    EnemigoH[] EHs;
    EBowser EBowser;

    public Lanzar(Player p, EnemigoH[] EHs, EBowser EBowser, String[] L, String P) {
        this.p = p;
        this.EHs = EHs;
        this.L = L;
        this.P = P;
        this.EBowser = EBowser;
    }

    @Override
    public void run() {
        this.p.setNumArmas(this.p.getNumArmas() - 1);
        try {
            this.p.setImagen(new ImageIcon(getClass().getResource(this.L[0])));
            Thread.sleep(200);
            this.p.setImagen(new ImageIcon(getClass().getResource(this.L[1])));
            Thread.sleep(200);
            if (this.L.length == 3) {
                this.p.setImagen(new ImageIcon(getClass().getResource(this.L[2])));
                Thread.sleep(200);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Lanzar.class.getName()).log(Level.SEVERE, null, ex);
        }
        if ((this.p.getBolsa().length) < (this.p.getNumArmas())) {
            this.p.setBolsa(new Kunai[this.p.getNumArmas()]);
        }
        for (int i = 0; i < this.p.getBolsa().length; i++) {
            if ((this.p.getBolsa()[i]) == null) {
                this.p.getBolsa()[i] = new Kunai((this.p.getX() + this.p.getAncho()), (this.p.getY() + 40), 30, 10);
                this.a = i;
                i = this.p.getBolsa().length + 1;
            }
        }
        this.p.setImagen(new ImageIcon(getClass().getResource(this.P)));
        while (this.Lon < 50) {
            try {
                Thread.sleep(20);
                this.p.getBolsa()[a].setX(this.p.getBolsa()[a].getX() + 10);
                this.Lon++;
                if ((new Rectangle(this.p.getBolsa()[a].getX(), this.p.getBolsa()[a].getY(), this.p.getBolsa()[a].getAncho(), this.p.getBolsa()[a].getAlto()).intersects(new Rectangle(this.EBowser.getX(), this.EBowser.getY(), this.EBowser.getAncho(), this.EBowser.getAlto())))) {
                    this.Lon = 50;
                    this.EBowser.setVida(this.EBowser.getVida() - 30);
                } else {
                    for (int i = 0; i < this.EHs.length; i++) {
                        if (this.EHs[i] != null && (new Rectangle(this.p.getBolsa()[a].getX(), this.p.getBolsa()[a].getY(), this.p.getBolsa()[a].getAncho(), this.p.getBolsa()[a].getAlto()).intersects(new Rectangle(this.EHs[i].getX(), this.EHs[i].getY(), this.EHs[i].getAncho(), this.EHs[i].getAlto())))) {
                            (new Thread(new EnemigoHMuerte(EHs, i))).start();
                            this.Lon = 50;
                        }
                    }
                }
                if (this.Lon == 50) {
                    this.p.getBolsa()[a] = null;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Lanzar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
