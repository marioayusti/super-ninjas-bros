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
public class FondoCM implements Runnable
{

    public int x;
    public int y;
    public int ancho;
    public int alto;
    public int limX1;
    public int LimX2;
    public ImageIcon imagen;
    public int dir;

    public FondoCM(int x, int y, int ancho, int alto, int limX1, int LimX2, String imagen, int dir)
    {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.limX1 = limX1;
        this.LimX2 = LimX2;
        this.dir = dir;
        this.imagen = new ImageIcon(getClass().getResource(imagen));
    }

    @Override
    public void run()
    {
        while (true)
            try {
                Thread.sleep(150);
                this.setX(this.getX() + ((this.getDir()) * 20));
                if (this.getX() <= this.getLimX1() || this.getX() >= this.getLimX2())
                    this.setDir(this.getDir() * -1);
            }
            catch (InterruptedException ex) {
                Logger.getLogger(EnemigoH.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getAncho()
    {
        return ancho;
    }

    public void setAncho(int ancho)
    {
        this.ancho = ancho;
    }

    public int getAlto()
    {
        return alto;
    }

    public void setAlto(int alto)
    {
        this.alto = alto;
    }

    public int getLimX1()
    {
        return limX1;
    }

    public void setLimX1(int limX1)
    {
        this.limX1 = limX1;
    }

    public int getLimX2()
    {
        return LimX2;
    }

    public void setLimX2(int LimX2)
    {
        this.LimX2 = LimX2;
    }

    public ImageIcon getImagen()
    {
        return imagen;
    }

    public void setImagen(ImageIcon imagen)
    {
        this.imagen = imagen;
    }

    public int getDir()
    {
        return dir;
    }

    public void setDir(int dir)
    {
        this.dir = dir;
    }

}
