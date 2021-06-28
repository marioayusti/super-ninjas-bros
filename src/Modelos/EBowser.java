/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author G40
 */
public class EBowser implements Runnable {

    int Random = 0;
    public int x = 4915;
    public int y = 250;
    public int ancho = 60;
    public int alto = 90;
    public int limX1 = 4915;
    public int LimX2 = 5000;
    public int Vida = 200;
    public EBowserAtaque[] Ataques = new EBowserAtaque[5];
    String[] imagenes = {"../Pictures/B.png", "../Pictures/B1.png", "../Pictures/B2.png", "../Pictures/B2.png"};
    public ImageIcon imagen = new ImageIcon(getClass().getResource(this.imagenes[0]));
    public boolean flag = true;
    public int a = 0;
    Player p;

    public EBowser(Player p) {
        this.p = p;
    }

    
    

    @Override
    public void run() {
        while (this.Vida > 0) {
            synchronized (this) {
                try {
                    Thread.sleep(100);
                    this.imagen = new ImageIcon(getClass().getResource(this.imagenes[a]));
                    a++;
                    if(a==this.imagenes.length)
                    {
                        a=0;
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(EBowser.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    Thread.sleep(300);
                    Random = (int) (Math.random() * 6);
                } catch (InterruptedException ex) {
                    Logger.getLogger(EBowser.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (Random == 0 && (((this.x) - 10) >= this.limX1)) {
                    this.x = this.x - 10;
                } else if (Random == 1 && (((this.x) + 10) <= this.LimX2)) {
                    this.x = this.x + 10;
                } else if (Random == 2) {
                    while (this.y > 100) {
                        try {
                            Thread.sleep(5);
                            this.y = this.y - 1;
                        } catch (InterruptedException ex) {
                            Logger.getLogger(EBowser.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    while (this.y < 250) {
                        try {
                            Thread.sleep(5);
                            this.y = this.y + 1;
                        } catch (InterruptedException ex) {
                            Logger.getLogger(EBowser.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                else if(Random==3)
                {
                    for (int i = 0; i < this.Ataques.length; i++) {
                        if(this.Ataques[i]==null)
                        {
                            this.Ataques[i]=new EBowserAtaque(this.getX(), this.getY()+7, 40, 30, "../Pictures/Fuego.png");
                            (new Thread(new EBowserLanzar(this.p, this, Ataques, i))).start();
                            i=this.Ataques.length;
                        }
                    }
                    
                }
            }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getLimX1() {
        return limX1;
    }

    public void setLimX1(int limX1) {
        this.limX1 = limX1;
    }

    public int getLimX2() {
        return LimX2;
    }

    public void setLimX2(int LimX2) {
        this.LimX2 = LimX2;
    }

    public int getVida() {
        return Vida;
    }

    public void setVida(int Vida) {
        this.Vida = Vida;
    }

    public EBowserAtaque[] getAtaques() {
        return Ataques;
    }

    public void setAtaques(EBowserAtaque[] Ataques) {
        this.Ataques = Ataques;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

}
