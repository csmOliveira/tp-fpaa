import java.util.*;

public class Exemplo {
 public static List<List<Integer>> distribuicaoRotas(int[] candidatos, int distanciaAlvo) {
      Arrays.sort(candidatos);
      List<List<Integer>> solucao = new ArrayList<List<Integer>>();
      List<Integer> solucoesCandidatas = new ArrayList<Integer>();
      encontrarDistribuicaoRotas(candidatos, distanciaAlvo, solucao, solucoesCandidatas, 0);
      return solucao;
    }

    public static void encontrarDistribuicaoRotas(int[] candidatos, int alvo, List<List<Integer>> solucao, List<Integer> solucoesPossiveis,int index) {
      
      if(alvo == 0) solucao.add(new ArrayList(solucoesPossiveis));
      else if(alvo < 0) return; 
      else {
        for(int i = index; i < candidatos.length; i++){
          if(i > index && candidatos[i] == candidatos[i-1]) continue;
          solucoesPossiveis.add(candidatos[i]);
          encontrarDistribuicaoRotas(candidatos, alvo - candidatos[i], solucao, solucoesPossiveis, i + 1);
          solucoesPossiveis.remove(solucoesPossiveis.get(solucoesPossiveis.size() - 1));
        }
      }
    }

    public static int encontrarAlvo(int[] candidatos) {
      int soma = 0;
      for(int i = 0; i < candidatos.length; i++) {
        soma += candidatos[i];
      }

      return soma / 3;
    }

    public static List<List<Integer>> alocarRotas (List<List<Integer>> distPossiveis, List<List<Integer>> distFinal, int next) {
      distFinal.add(next, distPossiveis.get(0));
      return distFinal;
    }

    public static void main(String[] args) {
      List<List<Integer>> distribuicaoDeRotas;
      List<List<Integer>> listaFinal = new ArrayList<List<Integer>>(3);
      int[] candidatos = {40,36,38,29,32,28,31,35,31,30,32,30,29,39,35,38,39,35,32,38,32,33,29,33,29,39,28};
      int alvo = encontrarAlvo(candidatos);
    
      distribuicaoDeRotas = distribuicaoRotas(candidatos, alvo);
      for(int i = 0; i < 3; i++) {
        System.out.println(distribuicaoDeRotas.get(i));
      }
      
      listaFinal = alocarRotas(distribuicaoDeRotas, listaFinal, 0);
      System.out.println(listaFinal);
    }
}
