import java.util.ArrayList;

public class Backtracking {
//índice, tamanho do conjunto
  public static void encontrarRotas(int i, int n, int[]conjuntoRotas, int distanciaDesejada, ArrayList<Integer> rotasCandidatas){
    if(distanciaDesejada == 0){

      rotasCandidatas.forEach((valor) -> System.out.print(valor + " "));
      System.out.println();

      return;
    }

    if(i == n) {
      return;
    }

    encontrarRotas(i + 1, n, conjuntoRotas, distanciaDesejada, rotasCandidatas);

    if(conjuntoRotas[i] <= distanciaDesejada) {
      rotasCandidatas.add(conjuntoRotas[i]);

      encontrarRotas(i + 1, n, conjuntoRotas, distanciaDesejada - conjuntoRotas[i], rotasCandidatas);

      rotasCandidatas.remove(rotasCandidatas.size() - 1);
    }
  }

  public static void main(String[] args) {
    int[] conjuntoRotas = {10,11,13,11,14,15,11,12,16};
    int distanciaDesejada = 37;
    int n = conjuntoRotas.length;
    ArrayList<Integer> rotasCandidatas = new ArrayList<Integer>();
    encontrarRotas(0, n, conjuntoRotas, distanciaDesejada, rotasCandidatas);
  }
}
