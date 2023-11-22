import Utilitarios.*;
import java.util.List;
import java.util.ArrayList;

public class Solucao {
  public static int getValorDesejado(int[] conjunto, int qtd){
    int valorDesejado, total = 0;

    for(int i = 0; i < conjunto.length; i++) 
      total += conjunto[i];

    valorDesejado = total / qtd;

    return valorDesejado;
  }

 /* public static void main(String[] args) {
    GeradorDeProblemas gerador = new GeradorDeProblemas();
    List<int[]> lista = new ArrayList<>(gerador.geracaoDeRotas(6,1,0.2));
  }*/
}
