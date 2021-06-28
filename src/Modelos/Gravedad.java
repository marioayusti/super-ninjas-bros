/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.awt.*;
import java.util.logging.*;

/**
 *
 * @author G40
 */
public class Gravedad implements Runnable
{

    Player p;
    boolean flagsMOV[];

    public Gravedad(Player p, boolean[] flagsMOV)
    {
        this.p = p;
        this.flagsMOV = flagsMOV;
    }

    @Override
    public void run()
    {
        while (true)
            synchronized (this) {
                if (this.flagsMOV[4])
                    try {
                        Thread.sleep(5);
                        this.p.setY(this.p.getY() + 1);
                    }
                    catch (InterruptedException ex) {
                        Logger.getLogger(Gravedad.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
    }

}
