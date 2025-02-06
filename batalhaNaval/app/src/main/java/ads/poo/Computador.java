package ads.poo;

import edu.princeton.cs.algs4.Draw;

import java.util.ArrayList;
import java.util.Random;


public class Computador {
    private ArrayList<Navio> navios;        //lista de navios do computador
    private Grade grade;                    //grade do computador
    private ArrayList<Tiro> tiros;          //lista de tiros do computador
    private int naviosAfundados;            //numero de navios afundados do computador

//--------------------------------------------------------------

    public Computador() {
        this.navios = new ArrayList<>();
        this.grade = grade;
        this.tiros = new ArrayList<>();
        this.naviosAfundados = 0;
    }


    Random r = new Random();
    String[] letrasNavios = {"P", "N", "E", "S", "C"};

    // Cria o navio com dados aleatorios e se válido, desenha
    public boolean posicionarNavioComputador(Draw draw, Grade grade) {

        while (true) {
            String tipo = letrasNavios[r.nextInt(5)];
            if (verificarTipoNavio(tipo)) {
                Navio nc = new Navio(r.nextInt(10) + 1, r.nextInt(10) + 1, r.nextBoolean(), tipo);
                if (validarNavioNaGrade(nc, grade) && validarPosicaoNavio(nc.getxNavio(), nc.getyNavio(), nc.getComprimento(), nc.isHorizontal())) {
//                    nc.desenharNavioC(draw);
                    navios.add(nc);
                } else {
                    return false;
                }
                return true;
            }
        }

    }

    //valida se o navio cabe no tabuleiro
    public boolean validarNavioNaGrade(Navio navio, Grade grade) {
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

    // analisar se o tiro feito pelo jogador acertou ou nao um navio
    public boolean analisarTiro(int x, int y, Draw draw, Grade grade) {

        //leitura de cada navio
        for (Navio navio : navios) {

            // Navio na horizontal
            if (navio.isHorizontal()) {
                for (int i = navio.getxNavio(); i < navio.getxNavio() + navio.getComprimento(); i++) {
                    if (x == i && y == navio.getyNavio()) {
                        Tiro tr = new Tiro(x, y, true);
                        tr.desenharTiroComputador(draw, grade);
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
                        Tiro tr = new Tiro(x, y, true);
                            tr.desenharTiroComputador(draw, grade);
                            tiros.add(tr);
                        if (navio.tomarDano()) {
                            this.naviosAfundados = naviosAfundados + 1;
                        }
                        return true;
                    }
                }
            }
        }
        //tiro que não acertou
        Tiro tr = new Tiro(x, y, false);
        if(verificarTiroNaPosicao(x, y)){
            tr.desenharTiroComputador(draw, grade);
            tiros.add(tr);
        }
        return false;
    }

    //Permitir apenas 1 navio de cada tipo
    public boolean verificarTipoNavio(String tipo) {
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
                            if(navio.getyNavio()==i && j==x){
                                return false;
                            }
                        }
                    //Navio da grade na vertical
                    }else{
                        for (int j = navio.getyNavio(); j<navio.getyNavio()+navio.getComprimento(); j++){
                            if(i==j && x==navio.getxNavio()){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        //navio pode ser poscionado sem sobrepor
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

