package org.yourorghere;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import static oracle.jrockit.jfr.events.Bits.floatValue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jorge
 */
public class Transformacion extends JFrame implements ActionListener {

    public JButton trasladar, rotar, escalar;
    static float corX = 0, corY = 0, corZ = 0, grados = 0;
    static int indicador = 0;
    int veces = 0;

    public JButton getEscalar() {
        return escalar;
    }

    public void setEscalar(JButton escalar) {
        this.escalar = escalar;
    }

    public float getCorX() {
        return corX;
    }

    public void setCorX(float corX) {
        this.corX = corX;
    }

    public float getCorY() {
        return corY;
    }

    public void setCorY(float corY) {
        this.corY = corY;
    }

    public float getCorZ() {
        return corZ;
    }

    public void setCorZ(float corZ) {
        this.corZ = corZ;
    }

    double width, height;
    public float[][] matriz = {{600, 513, 1}, {830, 513, 1}, {830, 300, 1}, {600, 300, 1}};
    //public float[][] matriz = {{100, 400, 0}, {400, 400, 0}, {400, 100, 0}, {100, 100, 0}};

    public float[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(float[][] matriz) {
        this.matriz = matriz;
    }

    static GL gl;
    static GLU glu;

    public Transformacion() {
        trasladar = new JButton("Trasladar");
        trasladar.setFont(new java.awt.Font("Lucida Sans", 1, 24));
        trasladar.setBounds(5, 60, 200, 29);
        trasladar.setBackground(Color.green);
        this.add(trasladar);
        trasladar.addActionListener(this);

        rotar = new JButton("Rotar");
        rotar.setFont(new java.awt.Font("Lucida Sans", 1, 24));
        rotar.setBounds(5, 100, 200, 29);
        //rotar.setBackground(Color.green);
        this.add(rotar);
        rotar.addActionListener(this);

        escalar = new JButton("Escalar");
        escalar.setFont(new java.awt.Font("Lucida Sans", 1, 24));
        escalar.setBounds(5, 140, 200, 29);
        escalar.setBackground(Color.red);
        this.add(escalar);
        escalar.addActionListener(this);

        setTitle("Figura");
        //Instanciamos la clase Graphic
        Dibujar listener = new Dibujar();
        //Transformacion frame = new Transformacion();
        //Creamos el canvas
        GLCanvas canvas = new GLCanvas(new GLCapabilities());
        canvas.addGLEventListener(listener);
        getContentPane().add(canvas);

        //frame.init();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = screenSize.getWidth();
        height = screenSize.getHeight();

        // listener.trasformarFigura();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == trasladar) {
            JVentana.traslada = true;
            JVentana ventana = new JVentana();
            this.setVisible(true);
            ventana.setVisible(true);
            if(veces >= 1){
              this.setVisible(false);  
              System.out.println("veces----- " + veces );
            }
            veces++;
            

        }

        if (e.getSource() == rotar) {
            JVentana.rotar = true;
            JVentana ventana = new JVentana();
            this.setVisible(true);
         
            ventana.setVisible(true);
            veces++;

        }
        if (e.getSource() == escalar) {
            JVentana.escalar = true;
            JVentana ventana = new JVentana();
            this.setVisible(true);
         
            ventana.setVisible(true);
            veces++;
        }
    }

    public static void main(String args[]) {
        Transformacion ventana = new Transformacion();

        ventana.setResizable(false);
        ventana.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventana.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
        ventana.setVisible(true);
        // ventana.add(new JVentana());
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public class Dibujar implements GLEventListener {

        public void display(GLAutoDrawable arg0) {

            glu = new GLU();
            gl = arg0.getGL();

            gl.glMatrixMode(gl.GL_PROJECTION);
            System.out.println("Indicador == " + indicador);
            if (indicador == 1) {
                gl.glTranslatef(corX, corY, 0);
                indicador = 0;
            }
            if (indicador == 2) {
                gl.glScalef(corX, corY, 1);
                gl.glTranslatef(600 - corX, 513 - corY, 0);
                indicador = 0;
            }
            if (indicador == 3) {
                double pi = Math.PI;
                double grados2 = (float) (grados * (pi / 180));

                float coseno = (float) Math.cos(grados2);
                float senoN = (float) -Math.sin(grados2);
                float seno = floatValue(Math.sin(grados2));

                //System.out.println("seno negativo:  " + senoN);
                //System.out.println("seno:  " + seno);
                //System.out.println("Coseno  " + coseno);
                corX = 600 - ((coseno * 600) + (senoN * 300));
                corY = 300 - ((seno * 600) + (coseno * 300));
                //System.out.println("Corx ---- " + corX + "   cordenada en Y ------" + corY);
                gl.glTranslatef(corX, corY, 0);
                gl.glRotatef(grados, 0, 0, 1);

                indicador = 0;
            }

            gl.glBegin(GL.GL_POLYGON);

            gl.glColor3f(200, 200, 121);
            // gl.glVertex2d(width, width);
            gl.glVertex2d(matriz[0][0], matriz[0][1]);
            gl.glVertex2d(matriz[1][0], matriz[1][1]);
            gl.glVertex2d(matriz[2][0], matriz[2][1]);
            gl.glVertex2d(matriz[3][0], matriz[3][1]);

            gl.glEnd();

        }

        public void init(GLAutoDrawable arg0) {
            glu = new GLU();
            gl = arg0.getGL();
            gl.glClearColor(0, 0, 0, 0);
            //Establecer los parametros para la proyeccion
            gl.glMatrixMode(gl.GL_PROJECTION);

            glu.gluOrtho2D(0, width, 0, height);

        }

        public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {

        }

        public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {

        }

    }
}
