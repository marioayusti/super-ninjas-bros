/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import static java.lang.Thread.sleep;
import java.util.logging.*;
import javax.swing.*;

/**
 *
 * @author G40
 */
public class Coordenadas implements Runnable
{
    Player p;
    JLabel Coordenadas;

    public Coordenadas(Player p, JLabel Coordenadas)
    {
        this.p = p;
        this.Coordenadas = Coordenadas;
    }

    @Override
    public void run()
    {
        while(true)
        {
            try {
                Thread.sleep(1);
                this.Coordenadas.setText("X: "+this.p.getX()+" Y: "+this.p.getY());
            }
            catch (InterruptedException ex) {
                Logger.getLogger(Coordenadas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    
    
    }
    
}
