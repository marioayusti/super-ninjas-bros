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
public class Camara implements Runnable
{

    Player p;
    int[] A_XY;
    int[] preM;

    public Camara(Player p, int[] A_XY, int[] preM)
    {
        this.p = p;
        this.A_XY = A_XY;
        this.preM = preM;
    }

    @Override
    public void run()
    {
        while (true)
            try {
                Thread.sleep(1);
                if (this.p.getX() >= (320 + this.A_XY[0]) && this.p.getX() <= (350 + this.A_XY[0])) {
                    this.A_XY[0] += this.preM[0];
                    this.A_XY[1] -= this.preM[0];
                }
                if (this.p.getY() <= (0))
                    this.A_XY[2] = -this.p.getY();
            }
            catch (InterruptedException ex) {
                Logger.getLogger(Camara.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

}
