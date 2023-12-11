  import java.util.*;
  import Utilitarios.*;

  public class Backtracking {
    public static List<List<Integer>> distribuicaoRotas(List<Integer> rotasCandidatas, int distanciaAlvo) {
      Collections.sort(rotasCandidatas);
      List<List<Integer>> solucao = new ArrayList<List<Integer>>();
      List<Integer> solucoesCandidatas = new ArrayList<Integer>();
      encontrarDistribuicaoRotas(rotasCandidatas, distanciaAlvo, solucao, solucoesCandidatas, 0);
      return solucao;
    }

    public static void encontrarDistribuicaoRotas(List<Integer> candidatos, 
                                          int alvo, 
                                          List<List<Integer>> solucao, 
                                          List<Integer> solucoesPossiveis,
                                          int index) {
      
      if(alvo == 0) solucao.add(new ArrayList(solucoesPossiveis));
      else if(alvo < 0) return; 
      else {
        for(int i = index; i < candidatos.size(); i++){
          if(i > index && candidatos.get(i) == candidatos.get(i-1)) continue;
          solucoesPossiveis.add(candidatos.get(i));
          encontrarDistribuicaoRotas(candidatos, alvo - candidatos.get(i), solucao, solucoesPossiveis, i + 1);
          solucoesPossiveis.remove(solucoesPossiveis.get(solucoesPossiveis.size() - 1));
        }
      }
    }
  
  public static int getDistanciaAlvo(List<Integer> conj, int qtd) {
    int totalSoma = 0;

    for(int i = 0; i < conj.size(); i++) {
      totalSoma += conj.get(i);
    }

    return totalSoma/qtd;
  }

  public static void distribuirRotas(List<List<Integer>> possibilidades, List<List<Integer>> rotas) {
    for(int i = 0; i < possibilidades.size(); i++) {
      if(i > 2) {
        rotas.get(i%3).addAll(possibilidades.get(i));
      }

      rotas.get(i).addAll(possibilidades.get(i));
    }
  }

  public static void atualizarTeste(List<List<Integer>> possibilidades, List<Integer> testes) {
    for(int i = 0; i < possibilidades.size(); i++) {
      testes.removeAll(possibilidades.get(i));
    }
  }

  public static List<Integer> converterParaLista(int[] array) {
    List<Integer> novaLista = new ArrayList<Integer>(array.length);

    for(int i: array) {
      novaLista.add(i);
    }

    return novaLista;
  }

  public static void printDistribuicaoRotas(List<List<Integer>> rotas) {
    for(int i = 0; i < rotas.size(); i++) {
      System.out.println(rotas.get(i));
    }
  }

  public static List<List<Integer>> resolver(List<Integer> conjTeste) {
    List<List<Integer>> distPossiveis;
    List<List<Integer>> distribuicao = new ArrayList<List<Integer>>(3);
    int alvo = getDistanciaAlvo(conjTeste, 3);

    distPossiveis = distribuicaoRotas(conjTeste, alvo);
    while(conjTeste.size() > 3) {
      int i = 0;
      while(distPossiveis.size() == 0 && i < alvo) {
        distPossiveis = distribuicaoRotas(conjTeste, alvo - i);
        i++;
      }
      distribuirRotas(distPossiveis, distribuicao);
      atualizarTeste(distPossiveis, conjTeste);
    }

    for(int i = 0; i < conjTeste.size(); i++) {
      distribuicao.get(i).add(conjTeste.get(i));
    }
    return distribuicao;
  }

  public static void main(String[] args) {
    List<int[]> conjTeste = GeradorDeProblemas.geracaoDeRotas(6, 10, 0.8);
    List<List<Integer>> distribuicaoDasRotas;
    for(int i = 0; i < conjTeste.size(); i++) {
      distribuicaoDasRotas = resolver(converterParaLista(conjTeste.get(i)));
      printDistribuicaoRotas(distribuicaoDasRotas);
    }
  } 
}
