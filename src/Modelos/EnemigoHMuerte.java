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
public class EnemigoHMuerte implements Runnable
{

    EnemigoH[] EHs;
    int i = 0;

    public EnemigoHMuerte(EnemigoH[] EHs, int i)
    {
        this.EHs = EHs;
        this.i = i;
    }

    @Override
    public void run()
    {
        try {
            this.EHs[i].setFlag(false);
            this.EHs[i].setAlto(10);
            this.EHs[i].setY(this.EHs[i].getY() + 20);
            Thread.sleep(1500);
            this.EHs[i] = null;
        }
        catch (InterruptedException ex) {
            Logger.getLogger(EnemigoHMuerte.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
