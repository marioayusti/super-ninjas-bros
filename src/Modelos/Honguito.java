/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author G40
 */
public class Honguito {

    private int x;
    private int y;
    private int ancho;
    private int alto;
    private ImageIcon imagen;
    private String[] imagenes = {"../Pictures/HongoV.png", "../Pictures/HongoP.png"};
    public int Tipo;
    public Rectangle Rectangulo;

    public Honguito(int x, int y, int ancho, int alto, int Tipo) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.Tipo = Tipo;
        if (Tipo == 2) {
            this.imagen = new ImageIcon(getClass().getResource(this.imagenes[1]));
        } else {
            this.imagen = new ImageIcon(getClass().getResource(this.imagenes[0]));
        }
        this.Rectangulo = new Rectangle(x, y, ancho, alto);
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the ancho
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * @param ancho the ancho to set
     */
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    /**
     * @return the alto
     */
    public int getAlto() {
        return alto;
    }

    /**
     * @param alto the alto to set
     */
    public void setAlto(int alto) {
        this.alto = alto;
    }

    /**
     * @return the imagen
     */
    public ImageIcon getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the imagenes
     */
    public String[] getImagenes() {
        return imagenes;
    }

    /**
     * @param imagenes the imagenes to set
     */
    public void setImagenes(String[] imagenes) {
        this.imagenes = imagenes;
    }

    public int getTipo() {
        return Tipo;
    }

    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }

    public Rectangle getRectangulo() {
        return Rectangulo;
    }

    public void setRectangulo(Rectangle Rectangulo) {
        this.Rectangulo = Rectangulo;
    }
}
