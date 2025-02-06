#  Batalha Naval 💣🚢

### Como Jogar 🤔
- **Disposição dos navios do jogador:** 🚤
    - Digite a coordenada (x,y) do mapa em que deseja posicionar seu navio
    - Indique a posição do navio vertical (0) ou horizontal (1)
      - Navios são desenhados da origem para cima ou da origem para a direita
    - Selecione qual tipo de navio deseja adicionar ao tabuleiro
        - Porta-Aviões(P), Enouraçado(E), Submarino(S), Cruzador(C) e Contratorpedeiro(N) 
        - Tamanhos: (P) 5 casas, (E) 4 casas, (S) 3 casas, (C) 3 casas e (N) 2 casas


- **Atirar:** 🔫
    - Digite a coordenada (x,y) do mapa em que deseja atirar da grade inimiga
      - Círcuclos azuis significam que o disparo acertou a água
      - Círculos vermelhos indicam que o disparo acertou uma posição do navio inimigo
    

- **Fim da partida:** 💯
  - Se todas as posições de um navio forem acertadas, o navio é eliminado
    - Vence aquele que destruir todos os 5 navios do adversário primeiro
  - Você pode iniciar uma nova partida digitando 1 ou fechar o jogo digitando 0
  - Ao encerrar o jogo as estatísticas serão mostradas no terminal

 ____   

### Captura de Tela do Jogo 📸

![Captura do jogo](./JOGO.PNG)

 ____  
### Implementações

- ✔️
  - Desenhar os navios com o Scanner
  - Navio não ultrapassar a grade/sobrepor outros
  - Verificar se a posição da grade já está ocupada
  - Atirar 
  - Contar dano do navio
  - Mensagem de quem é o vencedor
  - Loop no menu para o jogo
  - Estatísticas
  - Alterar a ordem do primeiro a jogar

- ❌
  - Mensagem de navio afundado/local do tiro

 ____
### UML 📄

```mermaid

    classDiagram
        
        direction LR

        Computador "1" *--> "1"Grade
        Computador "1" *--> "0..5"Navio
        Computador "1"*--> "*"Tiro

        Jogador"1" *--> "1"Grade
        Jogador"1" *--> "0..5"Navio
        Jogador"1" *-- >"*"Tiro
      

        App"1" --> "1"Computador
        App"1" --> "1"Jogador
        
        
        class Navio{
          - largura : int
          - xNavio: int
          - yNavio: int
          - horizontal: boolean
          - tipo: String
          - comprimento : int
          - dano : int
        
         + definirComprimento() int
         + desenharNavioJ(draw : Draw) void
         + tomarDano() Boolean
         + conversaoXJogador(xNavio : int) int
         + conversaoYJogador(yNavio : int) int
        
        }
        
        class Grade{
            - xGrade: int
            - yGrade: int
            - celula: int
            - linhas: int
            - colunas: int 

            + gerarLetrasNumeros(draw : Draw) void
            + desenharGrade(draw : Draw) void
            
        }
        class Tiro{
            - raioTiro : int
            - xTiro: int
            - yTiro: char
            - acertouTiro: boolean
            
            + verificarTiro(gr: Grade) boolean 
            + desenharTiroComputador(grade : Grade, draw : Draw) boolean
            + desenharTiroJogador(grade : Grade, draw : Draw) boolean
            + conversaoXJogador(xNavio : int) int
            + conversaoYJogador(yNavio : int) int
            + conversaoXComputador(xNavio : int) int
            + conversaoYComputador(yNavio : int) int

        }

        class Jogador{
            - navios : ArrayList~Navio~
            - tiro : ArrayList~Tiro~
            - grade : Grade
            - naviosAfundados : int

            + analisarTiro(draw: Draw, grade : Grade)boolean
            + posicionarNavio(x : int, y : int, t : String, h : boolean, draw: Draw, grade : Grade)boolean
            + validarNavio(navio: Navio, grade : Grade)boolean
            + verificarNavio(tipo : String) boolean
            + validarPosicaoNavio(x: int, y: int, comprimento: int, h: boolean) boolean
            + verificarTiroNaPosicao(x: int, y: int) boolean

        }
        
        class Computador{
            - navios : ArrayList~Navio~
            - tiros : ArrayList~Tiro~
            - grade : Grade
            - naviosAfundados : int
            
          + analisarTiro(x: int, y:int, draw : Draw, grade:Grade)boolean
          + posicionarNavioComputador(draw: Draw, grade : Grade)boolean
          + validarNavioNaGrade(navio: Navio, grade : Grade)boolean
          + verificarTipoNavio(tipo : String) boolean
          + validarPosicaoNavio(x: int, y: int, comprimento: int, h: boolean) boolean
          + verificarTiroNaPosicao(x: int, y: int) boolean
          
        }
        class App{
            - draw : Draw
            - jogador: Jogador
            - computador : Computador
            - naviosJogador : boolean
            - naviosComputador : boolean
            - partidas : int
            -vitoriasJogador: int
            - vitorias computador : int
           - xInicioGradeJogador : int
           - yInicioGradeJogador : int
           - xInicioGradeComputador : int
           - yInicioGradeComputador : int
           - larguraJanela : int
           - alturaJanela : int
           - numNavios : int

            + transformarLetras(y:String) int
            + jogarNovamente(r: int, teclado : Scanner) boolean
            + definirBooleanQuemInicia() void
            + estatisticas() void
            + incrementarPartidas() int
            + incrementarVitoriasJ() int
            + incrementarVitoriasC() int
            +main()$
        }
   
       
       

```
