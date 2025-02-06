package ads.poo;

import edu.princeton.cs.algs4.Draw;

import java.util.ArrayList;
import java.util.Random;

public class Jogador {
    private ArrayList<Navio> navios;        //lista de navios do jogador
    private Grade grade;                    //grade do jogador
    private ArrayList<Tiro> tiros;          //lista de tiros do jogador
    private int naviosAfundados;            //numero de navios afundados do jogador

//--------------------------------------------------------------------------
    Random r = new Random();

    public Jogador() {
        this.navios = new ArrayList<>();
        this.grade = grade;
        this.tiros = new ArrayList<>();
        this.naviosAfundados = 0;
    }

    // Cria o navio com dados passados e se válido, desenha
    public boolean posicionarNavio(int x, int y, boolean h, String t, Draw draw, Grade grade) {
        Navio n = new Navio(x, y, h, t);
        if (validarNavio(n, grade) && validarPosicaoNavio(n.getxNavio(), n.getyNavio(), n.getComprimento(), n.isHorizontal())) {
            n.desenharNavioJ(draw);
            navios.add(n);
            return true;
        } else {
            return false;
        }
    }

    //valida se o navio cabe no tabuleiro
    public boolean validarNavio(Navio navio, Grade grade) {
        if (navio.isHorizontal()) {
            if (navio.getxNavio() + navio.getComprimento() > grade.getLinhas() + 1) {
                return false;
            }
        } else {
            if (navio.getyNavio() + navio.getComprimento() > grade.getColunas() + 1) {
                return false;
            }
        }
        return true;
    }

//Analisar o tiro dado pelo Computador no tabuleiro do jogador, se acertou ou nao um navio
    public boolean analisarTiro(Draw draw, Grade grade) {

        while(true) {
            // x e y do computador
            int x = r.nextInt(10) + 1;
            int y = r.nextInt(10) + 1;

            if (verificarTiroNaPosicao(x, y)) {

                //leitura de cada navio
                for (Navio navio : navios) {

                    // Navio na horizontal
                    if (navio.isHorizontal()) {
                        for (int i = navio.getxNavio(); i < navio.getxNavio() + navio.getComprimento(); i++) {
                            if (x == i && y == navio.getyNavio()) {
                                //se o tiro bater com uma posicao de navio
                                Tiro tr = new Tiro(x, y, true);
                                tr.desenharTiroJogador(draw, grade);
                                tiros.add(tr);
                                if (navio.tomarDano()) {
                                    this.naviosAfundados = naviosAfundados + 1;
                                }
                                return true;
                            }
                        }
                        // Navio na vertical
                    } else {
                        for (int i = navio.getyNavio(); i < navio.getyNavio() + navio.getComprimento(); i++) {
                            if (y == i && x == navio.getxNavio()) {
                                //se o tiro bater com uma posicao de navio
                                Tiro tr = new Tiro(x, y, true);
                                tr.desenharTiroJogador(draw, grade);
                                tiros.add(tr);
                                if (navio.tomarDano()) {
                                    this.naviosAfundados = naviosAfundados + 1;
                                }
                                return true;
                            }
                        }
                    }
                }
                //tiro nao acerta um navio
                Tiro tr = new Tiro(x, y, false);
                if (verificarTiroNaPosicao(x, y)) {
                    tr.desenharTiroJogador(draw, grade);
                    tiros.add(tr);
                }
                return false;
            }
        }
    }

    //Garantir que haja apenas um navio de cada tipo
    public boolean verificarNavio(String tipo) {

        for (Navio navio : navios) {
            if (navio.getTipo().equals(tipo)) {
                return false;
            }
        }
        return true;
    }


//Validar se um navio nao sobrepoe outro
    public boolean validarPosicaoNavio(int x, int y, int comprimento, boolean h) {

        //Novo navio na horizontal
        if(h){
            for(int i = x; i<x+comprimento; i++ ){
                for (Navio navio : navios){
                    //navio da grade na horizontal
                    if(navio.isHorizontal()){
                        for (int j = navio.getxNavio(); j < navio.getxNavio()+navio.getComprimento() ; j++) {
                            //se x=y e y=y, posicao ja ocupada - x aumenta
                            if(i==j && y==navio.getyNavio()){
                                return false;
                            }
                        }
                    //Navio da grade na vertical
                    }else{
                        for (int j = navio.getyNavio(); j<navio.getyNavio()+navio.getComprimento(); j++){
                            //se x=x e y=y, posicao ja ocupada - y aumenta
                            if(navio.getxNavio()==i && j==y){
                                return false;
                            }
                        }
                    }
                }
            }
        //novo navio na vertical
        }else{
            for(int i = y; i<y+comprimento; i++ ){
                for (Navio navio : navios){
                    //navio da grade na horizontal
                    if(navio.isHorizontal()){
                        for (int j = navio.getxNavio(); j < navio.getxNavio()+navio.getComprimento() ; j++) {
                            //se y=x e x=x, posicao ja ocupada - x aumenta
                            if(navio.getyNavio()==i && j==x){
                                return false;
                            }
                        }
                    //Navio da grade na vertical
                    }else{
                        for (int j = navio.getyNavio(); j<navio.getyNavio()+navio.getComprimento(); j++){
                            //se x=y e x=y, posicao ja ocupada - y aumenta
                            if(i==j && x==navio.getxNavio()){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        //navio pode ser posicionado sem sobrepor
        return true;
    }

    //verificar se ja teve um tiro na posicao indicada, true pode atirar
    public boolean verificarTiroNaPosicao(int x, int y) {
        for (Tiro tiro : tiros) {
            if (x == tiro.getxTiro() && y == tiro.getyTiro()) {
                return false;
            }
        }
        return true;
    }

    public int getNaviosAfundados() {
        return naviosAfundados;
    }
}


