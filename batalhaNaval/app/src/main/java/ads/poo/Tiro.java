package ads.poo;

import edu.princeton.cs.algs4.Draw;

import java.awt.*;

public class Tiro {

    private final int raioTiro = 20;        //Raio do tiro
    private int xTiro;                      //X do tiro
    private int yTiro;                      //Y do tiro
    private boolean acertouTiro;            //True tiro acertou um navio, false acertou a agua


//-------------------------------------------------------------------------------------------

    public Tiro(int xTiro, int yTiro, boolean acertouTiro) {
        this.xTiro = xTiro;
        this.yTiro = yTiro;
        this.acertouTiro = acertouTiro;
    }

    public Tiro() {
    }

//Desenhar o tiro dado pelo computador a depender se acertou ou nao um navio
    public boolean desenharTiroComputador(Draw draw, Grade grade) {
        if (this.acertouTiro) {
            draw.setPenColor(Color.RED);
            draw.filledCircle(conversaoXComputador(this.xTiro) + this.raioTiro, conversaoYComputador(this.yTiro) + this.raioTiro, this.raioTiro);
            return true;
        } else {
            draw.setPenColor(Color.blue);
            draw.filledCircle(conversaoXComputador(this.xTiro) + this.raioTiro, conversaoYComputador(this.yTiro) + this.raioTiro, this.raioTiro);
            return false;
        }
    }

//Desenhar o tiro dado pelo jogador a depender se acertou ou nao um navio
    public boolean desenharTiroJogador(Draw draw, Grade grade) {
        if (this.acertouTiro) {
            draw.setPenColor(Color.RED);
            draw.filledCircle(conversaoXJogador(this.xTiro) + this.raioTiro, conversaoYJogador(this.yTiro) + this.raioTiro, this.raioTiro);
            return true;
        } else {
            draw.setPenColor(Color.blue);
            draw.filledCircle(conversaoXJogador(this.xTiro) + this.raioTiro, conversaoYJogador(this.yTiro) + this.raioTiro, this.raioTiro);
            return false;
        }
    }


    public void setAcertouTiro(boolean acertouTiro) {
        this.acertouTiro = acertouTiro;
    }

    public int getRaioTiro() {
        return raioTiro;
    }

    public int getxTiro() {
        return xTiro;
    }

    public int getyTiro() {
        return yTiro;
    }


    public int conversaoXComputador(int xNavio) {
        int resultado = 550 + (40 * (xNavio - 1));
        return resultado;
    }

    public int conversaoYComputador(int yNavio) {
        int resultado = 100 + (40 * (yNavio - 1));
        return resultado;

    }

    public int conversaoXJogador(int xNavio) {
        int resultado = 50 + (40 * (xNavio - 1));
        return resultado;
    }

    public int conversaoYJogador(int yNavio) {
        int resultado = 100 + (40 * (yNavio - 1));
        return resultado;

    }


}






