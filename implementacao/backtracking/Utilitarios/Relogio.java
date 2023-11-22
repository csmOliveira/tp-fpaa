package Utilitarios;

public class Relogio {
	private final long inicio;

	public Relogio() {
		inicio = System.currentTimeMillis();
	}

	public double tempoDecorrido() {
		long agora = System.currentTimeMillis();
		return (agora - inicio) / 1000.0;
	}
}
