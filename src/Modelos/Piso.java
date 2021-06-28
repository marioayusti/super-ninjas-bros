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
public class Piso
{

    public int x;
    public int y;
    public int ancho;
    public int alto;
    public ImageIcon imagen;
    public Rectangle Rectangulo;

    public Piso(int x, int y, int ancho, int alto, String imagen)
    {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.imagen = this.imagen = new ImageIcon(getClass().getResource(imagen));
        this.Rectangulo = new Rectangle(x, y, ancho, alto);
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

    public Rectangle getRectangulo()
    {
        return Rectangulo;
    }

    public void setRectangulo(Rectangle Rectangulo)
    {
        this.Rectangulo = Rectangulo;
    }

}
