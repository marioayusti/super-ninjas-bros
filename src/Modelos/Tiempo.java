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
public class Tiempo implements Runnable
{

    int segs = 0;
    int mins = 0;
    boolean pausa;
    JLabel tiempo;

    public Tiempo(boolean pausa, JLabel tiempo)
    {
        this.pausa = pausa;
        this.tiempo = tiempo;
    }

    @Override
    public void run()
    {
        while (true)
            try {
                if (!pausa) {
                    Thread.sleep(1000);
                    if (this.segs == 60) {
                        this.segs = 0;
                        this.mins++;
                    }
                    this.tiempo.setText("Time: " + this.mins + ":" + this.segs);
                    this.segs++;

                }
            }
            catch (InterruptedException ex) {
                Logger.getLogger(Tiempo.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

}
