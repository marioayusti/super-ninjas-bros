/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.awt.*;
import java.util.logging.*;
import javax.swing.*;

/**
 *
 * @author G40
 */
public class Colisiones implements Runnable {

    boolean[] flagsEst;
    boolean[] FlagsMOV;
    boolean aux[] = new boolean[4];
    int j = -1;
    int k = -1;
    int l = 0;
    int a[] = new int[2];
    Player p;
    String[] Poss;
    Piso[] Piso;
    BloqueN[] Bloques;
    Honguito[] Hs;

    public Colisiones(boolean[] flagsEst, boolean[] FlagMOV, Player p, Piso[] Piso, BloqueN[] Bloques, Honguito[] Hs, String[] Poss) {
        this.flagsEst = flagsEst;
        this.FlagsMOV = FlagMOV;
        this.p = p;
        this.Piso = Piso;
        this.Bloques = Bloques;
        this.aux[0] = true;
        this.aux[1] = true;
        this.aux[2] = true;
        this.a[0] = 0;
        this.a[1] = 0;
        this.Hs = Hs;
        this.Poss = Poss;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                try {
                    Thread.sleep(0);
                    if (l < 0) {
                        this.aux[0] = false;
                        for (int i = 0; i < this.Piso.length && !this.aux[0]; i++) {
                            if (this.Piso[i] != null && this.p.getRectangulo().intersects(this.Piso[i].getRectangulo()) && ((this.p.getY() + this.p.getAlto() - 15) < this.Piso[i].getY())) {
                                this.FlagsMOV[4] = false;
                                this.flagsEst[0] = false;
                                this.aux[0] = true;
                                l = i;
                            }
                        }
                    }
                    if ((j >= 0) && (this.Bloques[j] == null || !(this.p.getRectangulo().intersects(this.Bloques[j].getRectangulo())) || (this.p.getY() + (this.p.getAlto() / 2) + 20 <= this.Bloques[j].getY()))) {
                        j = -1;
                        this.FlagsMOV[0] = true;
                        this.FlagsMOV[1] = true;
                    }
                    if (j < 0 || k < 0) {
                        this.aux[1] = false;
                        for (int i = 0; i < this.Bloques.length && !this.aux[1]; i++) {
                            if (this.Bloques[i] != null && (this.p.getRectangulo().intersects(this.Bloques[i].getRectangulo()))) {
                                if (j < 0) {
                                    this.a[0] = this.p.getY() + (this.p.getAlto() / 2) + 20;
                                    if (this.a[0] >= this.Bloques[i].getY()) {
                                        if ((this.p.getX()) <= (this.Bloques[i].getX())) {
                                            this.FlagsMOV[1] = false;
                                            j = i;
                                        } else if ((this.p.getX() - 10) >= this.Bloques[i].getX()) {
                                            this.FlagsMOV[0] = false;
                                            j = i;
                                        }
                                    }
                                }
                                if (k < 0) {
                                    if (this.FlagsMOV[4] && (this.p.getY()) <= (this.Bloques[i].getY() - 20)) {
                                        this.FlagsMOV[4] = false;
                                        this.aux[0] = true;
                                        this.flagsEst[0] = false;
                                        k = i;
                                    } else if (this.FlagsMOV[2] && (this.p.getY()) >= (this.Bloques[i].getY() + 20)) {
                                        if (this.Bloques[i].getTipo() == 0) {
                                            this.Bloques[i] = null;
                                        } else {
                                            this.Bloques[i].setImagen(new ImageIcon(getClass().getResource("../Pictures/BloqueR1.png")));
                                            if (this.Bloques[i].getTipo() == 2) {
                                                Hs[0] = new Honguito(this.Bloques[i].getX(), this.Bloques[i].getY() - 30, 30, 30, 2);
                                                this.Bloques[i].setTipo(1);
                                            } else if (this.Bloques[i].getTipo() == 3) {
                                                Hs[0] = new Honguito(this.Bloques[i].getX(), this.Bloques[i].getY() - 30, 30, 30, 3);
                                                this.Bloques[i].setTipo(1);
                                            }
                                        }
                                        this.FlagsMOV[3] = false;
                                        this.FlagsMOV[4] = true;
                                        k = i;
                                    }
                                }
                            }
                            if ((this.j > 0) && (this.k > 0)) {
                                this.aux[1] = true;
                            }
                        }

                    }
                    if ((k >= 0) && ((this.Bloques[k] == null) || (!(this.p.getRectangulo().intersects(this.Bloques[k].getRectangulo()))))) {
                        k = -1;
                        this.FlagsMOV[4] = true;
                    } else if ((l >= 0) && !(this.p.getRectangulo().intersects(this.Piso[l].getRectangulo()))) {
                        l = -1;
                        this.FlagsMOV[4] = true;
                    }

                    if (this.aux[0]) {
                        this.p.setImagen(new ImageIcon(getClass().getResource(this.Poss[0])));
                        this.aux[0] = false;
                    }
                    if (this.flagsEst[0] && !this.FlagsMOV[2]) {
                        this.FlagsMOV[3] = true;
                        this.FlagsMOV[4] = true;
                        this.p.setImagen(new ImageIcon(getClass().getResource(this.Poss[1])));
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Colisiones.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
//        new Rectangle(this.Bloques[j].getX(), this.Bloques[j].getY(), this.Bloques[j].getAncho(), this.Bloques[j].getAlto())
//new Rectangle(this.Bloques[i].getX(), this.Bloques[i].getY(), this.Bloques[i].getAncho(), this.Bloques[i].getAlto())
//    this.Bloques[k].getX(), this.Bloques[k].getY(), this.Bloques[k].getAncho(), this.Bloques[k].getAlto())
//new Rectangle(this.Piso[l].getX(), this.Piso[l].getY(), this.Piso[l].getAncho(), this.Piso[l].getAlto()
//        new Rectangle(this.Piso[i].getX(), this.Piso[i].getY(), this.Piso[i].getAncho(), this.Piso[i].getAlto())
//new Rectangle(this.p.getX(), this.p.getY(), this.p.getAncho(), this.p.getAlto())
//                                        this.p.setRectangulo(new Rectangle(this.p.x, this.p.y, this.p.ancho, this.p.alto));
    }

}
