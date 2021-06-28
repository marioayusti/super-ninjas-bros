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
public class EnemigoH implements Runnable
{
    public int x;
    public int y;
    public int ancho;
    public int alto;
    int limX1;
    int LimX2;
    String[] imagenes = {"../Pictures/EH0.png", "../Pictures/EH1.png", "../Pictures/EH2.png"};
    public ImageIcon imagen = new ImageIcon(getClass().getResource(this.imagenes[0]));
    public boolean flag = true;
    public int dir;
    int a = 0;

    public EnemigoH(int x, int y, int ancho, int alto, int limX1, int LimX2, int dir)
    {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.limX1 = limX1;
        this.LimX2 = LimX2;
        this.dir = dir;
    }

    @Override
    public void run()
    {
        while (this.isFlag())
            try {
                Thread.sleep(150);
                this.setImagen(new ImageIcon(getClass().getResource(this.imagenes[a])));
                this.setX(this.getX() + ((this.dir) * 7));
                a++;
                if (this.a == this.imagenes.length)
                    a = 0;
                if (this.getX() <= this.limX1 || this.getX() >= this.LimX2)
                    this.dir *= -1;
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

    public boolean isFlag()
    {
        return flag;
    }

    public void setFlag(boolean flag)
    {
        this.flag = flag;
    }
}
