/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.logging.*;

/**
 *
 * @author G40
 */
public class SaltoA implements Runnable
{

    boolean[] flagsMOV;
    boolean[] flagsEST;
    Player p;
    int Altura;
    int[] A_XY;

    public SaltoA(boolean[] flagsEST, boolean[] flagMOV, Player p, int[] A_XY)
    {
        this.flagsMOV = flagMOV;
        this.flagsEST = flagsEST;
        this.p = p;
        this.A_XY = A_XY;
    }

    @Override
    public void run()
    {
        this.flagsMOV[2] = true;//bandera salto
        this.flagsMOV[4] = false;//apago gravedad
        this.Altura = this.p.getY();
        while (this.p.getY() >= (this.Altura - 120) && this.p.getX() > this.A_XY[0] && this.flagsMOV[3] && this.flagsMOV[0])
            try {
                this.flagsEST[0] = true;//esta en el aire
                Thread.sleep(9);
                this.p.setY(this.p.getY() - 5);
                this.p.setX(this.p.getX() - 5);
            }
            catch (InterruptedException ex) {
                Logger.getLogger(Salto.class.getName()).log(Level.SEVERE, null, ex);
            }
        this.flagsMOV[3] = true;//puedo seguir subiendo
        this.flagsMOV[2] = false;//bandera dejo de saltar
    }
}
