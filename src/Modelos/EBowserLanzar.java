/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.awt.Rectangle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author G40
 */
public class EBowserLanzar implements Runnable {

    public EBowser EBowser;
    public EBowserAtaque[] Ataque;
    public int i;
    public int Lon = 0;
    public Player p;

    public EBowserLanzar(Player p, EBowser EBowser, EBowserAtaque[] Ataque, int i) {
        this.EBowser = EBowser;
        this.Ataque = Ataque;
        this.i = i;
        this.p = p;
    }

    @Override
    public void run() {
        while (this.Lon < 100) {
            synchronized (this) {
                try {
                    Thread.sleep(50);
                    this.Ataque[i].setX(this.Ataque[i].getX() - 10);
                    this.Lon++;
                    if (this.Ataque[i] != null && this.p != null && this.p.getRectangulo().intersects(new Rectangle(this.Ataque[i].getX(), this.Ataque[i].getY(), this.Ataque[i].getAncho(), this.Ataque[i].getAlto()))) {
                        this.p.setVidas(this.getP().getVidas() - 1);
                        this.setLon(100);
                    }
                    if (this.getLon() == 100) {
                        this.Ataque[i] = null;
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(EBowserLanzar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public EBowser getEBowser() {
        return EBowser;
    }

    public void setEBowser(EBowser EBowser) {
        this.EBowser = EBowser;
    }

    public EBowserAtaque[] getAtaque() {
        return Ataque;
    }

    public void setAtaque(EBowserAtaque[] Ataque) {
        this.Ataque = Ataque;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getLon() {
        return Lon;
    }

    public void setLon(int Lon) {
        this.Lon = Lon;
    }

    public Player getP() {
        return p;
    }

    public void setP(Player p) {
        this.p = p;
    }

}
