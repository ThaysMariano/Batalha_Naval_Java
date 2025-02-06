package ads.poo;

import edu.princeton.cs.algs4.Draw;

import java.awt.*;

public class Navio {

    private final int largura = 40;  //largura fixa do navio

    private int xNavio;                 //X do navio
    private int yNavio;                 //Y do navio
    private boolean horizontal;         //true = horizontal, false = vertical
    private int comprimento;            //comprimento do navio
    private String tipo;                // tipo do navio
    private int dano;                   // dano do navio

//------------------------------------------------------------------------------------------------

    public Navio(int xNavio, int yNavio, boolean horizontal, String t) {
        this.xNavio = xNavio;
        this.yNavio = yNavio;
        this.horizontal = horizontal;
        this.tipo = t;
        this.comprimento = definirComprimento();
        this.dano = 0;

    }

    public int definirComprimento() {
        switch (this.tipo) {
            case "P" -> this.comprimento = 5;
            case "S", "C" -> this.comprimento = 3;
            case "N" -> this.comprimento = 2;
            case "E" -> this.comprimento = 4;
            default -> this.comprimento = 0; //msg de erro
        }
        return this.comprimento;

    }


    public void desenharNavioJ(Draw draw) {
        //desenhar na horizontal se true e na vertical se false
        draw.setPenColor(Color.darkGray);
        if (this.horizontal) {
            for (int i = 0; i < this.comprimento; i++) {
                draw.filledSquare((conversaoXJogador(this.xNavio) + largura * i) + largura / 2, conversaoYJogador(this.yNavio) + largura / 2, largura / 2);
            }
        } else {
            for (int i = 0; i < this.comprimento; i++) {
                draw.filledSquare(conversaoXJogador(this.xNavio) + largura / 2, (conversaoYJogador(this.yNavio) + largura * i) + largura / 2, largura / 2);
            }

        }
    }

    // Verificar a situação do navio, true o navio afundou
    public boolean tomarDano() {
        this.dano = this.dano + 1;
        if (this.dano == this.comprimento) {
            return true;
        }
        return false;
    }

//Conversoes
    public int conversaoXJogador(int xNavio) {
        int resultado = 50 + (largura * (xNavio - 1));
        return resultado;
    }

    public int conversaoYJogador(int yNavio) {
        int resultado = 100 + (largura * (yNavio - 1));
        return resultado;
    }

    public int getLargura() {
        return largura;
    }

    public int getxNavio() {
        return xNavio;
    }

    public int getyNavio() {
        return yNavio;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public int getComprimento() {
        return comprimento;
    }

    public String getTipo() {
        return tipo;
    }

//Para fins de teste

//    @Override
//    public String toString() {
//        return "Navio{" +
//                "xNavio=" + xNavio +
//                ", yNavio=" + yNavio +
//                ", horizontal=" + horizontal +
//                ", comprimento=" + comprimento +
//                ", tipo='" + tipo + '\'' +
//                '}';
//    }

    //Desenhar navio computador

//    public void desenharNavioC(Draw draw) {
//        //desenhar na horizontal se true e na vertical se false
//        draw.setPenColor(Color.darkGray);
//        if (this.horizontal) {
//            for (int i = 0; i < this.comprimento; i++) {
//                draw.filledSquare((conversaoXComputador(this.xNavio) + largura * i) + largura / 2, conversaoYComputador(this.yNavio) + largura / 2, largura / 2);
//            }
//        } else {
//            for (int i = 0; i < this.comprimento; i++) {
//                draw.filledSquare(conversaoXComputador(this.xNavio) + largura / 2, (conversaoYComputador(this.yNavio) + largura * i) + largura / 2, largura / 2);
//            }
//        }
//    }


    //conversoes

//    public int conversaoXComputador(int xNavio) {
//        int resultado = 550 + (largura * (xNavio - 1));
//        return resultado;
//    }
//
//    public int conversaoYComputador(int yNavio) {
//        int resultado = 100 + (largura * (yNavio - 1));
//        return resultado;
//
//    }
}
