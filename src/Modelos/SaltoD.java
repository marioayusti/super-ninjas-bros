/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.logging.*;
import javax.swing.*;

/**
 *
 * @author G40
 */
public class SaltoD implements Runnable
{

    boolean[] flagsMOV;
    boolean[] flagsEST;
    Player p;
    int Altura;

    public SaltoD(boolean[] flagsEST, boolean[] flagsMOV, Player p)
    {
        this.flagsMOV = flagsMOV;
        this.flagsEST = flagsEST;
        this.p = p;
    }

    @Override
    public void run()
    {
        this.flagsMOV[2] = true;//bandera salto
        this.flagsMOV[4] = false;//apago gravedad
        this.Altura = this.p.getY();
        while (this.p.getY() >= (this.Altura - 120) && this.flagsMOV[3] && this.flagsMOV[1])
            try {
                Thread.sleep(9);
                this.flagsEST[0] = true;//esta en el aire
                this.p.setY(this.p.getY() - 5);
                this.p.setX(this.p.getX() + 5);
            }
            catch (InterruptedException ex) {
                Logger.getLogger(Salto.class.getName()).log(Level.SEVERE, null, ex);
            }
        this.flagsMOV[3] = true;
        this.flagsMOV[2] = false;//bandera dejo de saltarF
    }
}
