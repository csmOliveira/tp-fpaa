  import java.util.*;

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

  public static void main(String[] args) {
    int[] rotasCandidatas = {10,11,11,11,12,13,14,15,16};
    int distanciaAlvo = 37;

    distribuicaoRotas(rotasCandidatas, distanciaAlvo).forEach(i -> System.out.println(i));
  }
}
