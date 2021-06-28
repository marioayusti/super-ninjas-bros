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
public class Salto implements Runnable
{

    boolean[] flagsEST;
    boolean[] flagsMOV;
    Player p;
    int Altura = 0;

    public Salto(boolean[] flagsEST, boolean[] flagMOV, Player p)
    {
        this.flagsEST = flagsEST;
        this.flagsMOV = flagMOV;
        this.p = p;
    }

    @Override
    public void run()
    {
        this.flagsMOV[2] = true;//bandera salto
        this.flagsMOV[4] = false;//apago gravedad
        this.flagsEST[0] = true;//esta en el aire
        this.Altura = this.p.getY();
        while ((this.p.getY() >= (this.Altura - 200)) && this.flagsMOV[3])
            try {
                Thread.sleep(5);
                this.p.setY(this.p.getY() - 5);
            }
            catch (InterruptedException ex) {
                Logger.getLogger(Salto.class.getName()).log(Level.SEVERE, null, ex);
            }
//        this.flagsMOV[4] = true;//vueve gravedad
        this.flagsMOV[3] = true;
        this.flagsMOV[2] = false;//bandera dejo de saltar
    }
}
