/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author G40
 */
public class Player
{

    public int x;
    public int y;
    public int ancho;
    public int alto;
    public ImageIcon imagen;
    public Rectangle Rectangulo;
    public int Energia = 0;
    public Kunai[] Bolsa = new Kunai[1];
    public int NumArmas = 0;
    public int Vidas = 1;

    public Player(int x, int y, int ancho, int alto, String imagen)
    {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.Rectangulo=new Rectangle(this.x, this.y, this.ancho, this.alto);
        this.imagen = new ImageIcon(getClass().getResource(imagen));
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

    public int getEnergia()
    {
        return Energia;
    }

    public void setEnergia(int Energia)
    {
        this.Energia = Energia;
    }

    public int getNumArmas()
    {
        return NumArmas;
    }

    public void setNumArmas(int NumArmas)
    {
        this.NumArmas = NumArmas;
    }

    public Kunai[] getBolsa()
    {
        return Bolsa;
    }

    public void setBolsa(Kunai[] Bolsa)
    {
        this.Bolsa = Bolsa;
    }

    public int getVidas()
    {
        return Vidas;
    }

    public void setVidas(int Vidas)
    {
        this.Vidas = Vidas;
    }

    public Rectangle getRectangulo()
    {
        return Rectangulo;
    }

    public void setRectangulo(Rectangle Rectangulo)
    {
        this.Rectangulo = Rectangulo;
    }

}
