package ads.poo;

import edu.princeton.cs.algs4.Draw;

import java.awt.*;

public class Grade {

    private final int linhas = 10;   //Número de linhas
    private final int colunas = 10;  //Número de colunas
    private final int celula = 40;   //Tamanho dos quadrados

    private int xGrade;                   //Início do mapa em X
    private int yGrade;                   //Início do mapa em Y


//----------------------------------------------


    public Grade(int xGrade, int yGrade) {
        this.xGrade = xGrade;
        this.yGrade = yGrade;
    }

    public void gerarLetrasNumeros(Draw draw) {
        //Letras na esquerda
        int espaco = 15;

        draw.setPenColor(Color.red);
        char letra = 'A';
        for (int i = 0; i < linhas; i++) {
            draw.text((this.xGrade - espaco), yGrade + (i * celula) + espaco, String.valueOf(letra));
            letra++;
        }

        int num = 1;
        //Numeros embaixo
        for (int i = 0; i < colunas; i++) {
            draw.text(xGrade + (i * celula + celula / 2), yGrade - espaco, String.valueOf(num));
            num++;
        }

    }

    public void desenharGrade(Draw draw) {
        draw.setPenColor(Color.black);
        //desenhar linhas
        for (int i = 0; i <= linhas; i++) {
            draw.line(xGrade, yGrade + (i * celula), xGrade + (colunas * celula), yGrade + (i * celula));
        }
        //desenhar colunas
        for (int j = 0; j <= colunas; j++) {
            draw.line(xGrade + (j * celula), yGrade, xGrade + (j * celula), yGrade + (linhas * celula));
        }
        gerarLetrasNumeros(draw);

    }


    public double getLinhas() {
        return linhas;
    }

    public double getColunas() {
        return colunas;
    }

    public double getCelula() {
        return celula;
    }

    public double getxGrade() {
        return xGrade;
    }

    public double getyGrade() {
        return yGrade;
    }
}
