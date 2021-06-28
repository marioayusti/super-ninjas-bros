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
public class Rasengan implements Runnable
{

    Player p;
    int i = 1;

    public Rasengan(Player p)
    {
        this.p = p;
    }

    @Override
    public void run()
    {
        while (i < 36)
            try {
                Thread.sleep(70);
                this.p.setImagen(new ImageIcon(getClass().getResource("../Pictures/Poderes/Rasengan/" + this.i + ".png")));
                i++;
            }
            catch (InterruptedException ex) {
                Logger.getLogger(Rasengan.class.getName()).log(Level.SEVERE, null, ex);
            }
        this.p.setImagen(new ImageIcon(getClass().getResource("../Pictures/Players/Naruto/P.png")));

    }

}
