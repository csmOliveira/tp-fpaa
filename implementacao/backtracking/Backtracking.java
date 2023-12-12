  import java.util.*;
  import Utilitarios.*;

  public class Backtracking {
    public static List<List<Integer>> distribuicaoRotas(List<Integer> candidatos, int distanciaAlvo) {
      Collections.sort(candidatos);
      List<List<Integer>> solucao = new ArrayList<List<Integer>>();
      List<Integer> solucoesCandidatas = new ArrayList<Integer>();
      encontrarDistribuicaoRotas(candidatos, distanciaAlvo, solucao, solucoesCandidatas, 0);
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
  public static List<List<Integer>> distribuirRotas(List<List<Integer>> possibilidades) { 
    List<List<Integer>> rotas = new ArrayList<List<Integer>>(3); rotas.add(new ArrayList());
    rotas.add(new ArrayList());
    rotas.add(new ArrayList());

    rotas.get(0).addAll(possibilidades.get(0));
    rotas.get(1).addAll(possibilidades.get(1));
    rotas.get(2).addAll(possibilidades.get(2));
    
  /*  for(int i = 0; i < possibilidades.size(); i++) {
      if(i > 2) {
        rotas.get(i%3).addAll(possibilidades.get(i));
      } else {
        rotas.get(i).addAll(possibilidades.get(i));
      }
    }*/

    return rotas;
  }

  public static List<Integer> atualizarTeste(List<List<Integer>> possibilidades, List<Integer> testes) {
    for(int i = 0; i < possibilidades.size(); i++) {
      testes.removeAll(possibilidades.get(i));
    }

    return testes;
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

  public static int indexMenorDistancia(List<List<Integer>> rotas) {
    int[] somaDistRotas = new int[3];
    int soma = 0;
    int index = 0;
    for(int i = 0; i < rotas.size(); i++){
      if(rotas.get(i).size() == 0) {
        index = i;
        return index;
      }
      for(int j = 0; j < rotas.get(i).size(); j++) {
        soma += rotas.get(i).get(j);
      }
      somaDistRotas[i] = soma;
      soma = 0;
    }   
    
    for(int i = 0; i < somaDistRotas.length - 1; i++) {
      if(somaDistRotas[i] > somaDistRotas[i + 1]) index = i + 1;
      else index = i;
    }
    return index;
  }

  public static List<List<Integer>> resolver(List<Integer> conjTeste) {
    List<List<Integer>> distPossiveis;
    List<List<Integer>> distribuicao = new ArrayList<List<Integer>>(3);
    int alvo = getDistanciaAlvo(conjTeste, 3);

    distPossiveis = distribuicaoRotas(conjTeste, alvo);
    while(conjTeste.size() > 3) {
      int i = 0;

      while(distPossiveis.size() == 0 && i < alvo) {
        distPossiveis = distribuicaoRotas(conjTeste, alvo + i);
        i += 1;
      } 

      distribuicao = distribuirRotas(distPossiveis);
      conjTeste = atualizarTeste(distPossiveis, conjTeste);
      
      alvo = getDistanciaAlvo(conjTeste, 3);
      distPossiveis = distribuicaoRotas(conjTeste, alvo);

    }
    
    for(int i = 0; i < conjTeste.size(); i++) {
      //distribuicao.get(2 - i).add(conjTeste.get(i));
      distribuicao.get(indexMenorDistancia(distribuicao)).add(conjTeste.get(i));
    }

    return distribuicao;
  }

  public static void main(String[] args) {
    List<List<Integer>> distribuicaoDasRotas;

    System.out.println("Conjunto 01: ");
    int[] rotasCandidatas = {40,36,38,29,32,28,31,35,31,30,32,30,29,39,35,38,39,35,32,38,32,33,29,33,29,39,28};
    distribuicaoDasRotas = resolver(converterParaLista(rotasCandidatas));
    printDistribuicaoRotas(distribuicaoDasRotas);
    System.out.println();

    System.out.println("Conjunto 02: ");
    int[] rotasCandidatas2 = {32,51,32,43,42,30,42,51,43,51,29,25,27,32,29,55,43,29,32,44,55,29,53,30,24,27};
    distribuicaoDasRotas = resolver(converterParaLista(rotasCandidatas2));
    printDistribuicaoRotas(distribuicaoDasRotas);
    System.out.println();
  } 
}
