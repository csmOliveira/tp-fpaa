  import java.util.*;
  import Utilitarios.*;

  public class Backtracking {
    public static List<List<Integer>> distribuicaoRotas(int[] rotasCandidatas, int distanciaAlvo) {
      Arrays.sort(rotasCandidatas);
      List<List<Integer>> solucao = new ArrayList<List<Integer>>();
      List<Integer> solucoesCandidatas = new ArrayList<Integer>();
      encontrarDistribuicaoRotas(rotasCandidatas, distanciaAlvo, solucao, solucoesCandidatas, 0);
      return solucao;
    }

    public static void encontrarDistribuicaoRotas(int candidatos[], 
                                          int alvo, 
                                          List<List<Integer>> solucao, 
                                          List<Integer> solucoesPossiveis,
                                          int index) {
      
      if(alvo == 0) solucao.add(new ArrayList(solucoesPossiveis));
      else if(alvo < 0) return; 
      else {
        for(int i = index; i < candidatos.length; i++){
          if(i > index && candidatos[i] == candidatos[i -1]) continue;
          solucoesPossiveis.add(candidatos[i]);
          encontrarDistribuicaoRotas(candidatos, alvo - candidatos[i], solucao, solucoesPossiveis, i + 1);
          solucoesPossiveis.remove(solucoesPossiveis.get(solucoesPossiveis.size() - 1));
        }
      }
    }
  
  public static int getDistanciaAlvo(int conjunto[]) {
    int totalSoma = 0;

    for(int i = 0; i < conjunto.length; i++) {
      totalSoma += conjunto[i];
    }

    return totalSoma/3;
  }

  public static void printRotas(List<List<Integer>> rotas) {
    rotas.forEach(item -> System.out.println(item));
    System.out.println();
  }

  public static void main(String[] args) {
   List<int[]> rotas = GeradorDeProblemas.geracaoDeRotas(6,10,0.6);
   List<int[]> distribuicaoFinalRota;
   List<List<Integer>> possiveisDistribuicoes;
   for(int i = 0; i < rotas.size(); i++) {
      // Separar em outra função
      int distanciaAlvo = getDistanciaAlvo(rotas.get(i));
      possiveisDistribuicoes = distribuicaoRotas(rotas.get(i), distanciaAlvo);
      printRotas(possiveisDistribuicoes);
    }
  } 
}
