package controle;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import modelo.*;
import visualizacao.EntradaSaida;

public class Controladora {

	private Fabrica fabrica = new Fabrica();
	private Carro carro = null;

	public void exibeMenu() {
		int opcao;
		boolean carroFabricado = false;

		do {
			opcao = EntradaSaida.solicitaOpcao();

			switch (opcao) {
			case 0:
				int qtdeCarros = EntradaSaida.qtdeCarros();

				// Diferente da casa, na constru��o do carro, n�o precisamos acrescentar novos
				// dados para atribuir outras informa��es do carro
				// Dentro do FOR n�s adicionamos todos os dados do carro (modelo, cor)

				for (int i = 0; i < qtdeCarros; i++) {
					// acrescentamos o carro pois � aqui que o construimos.
					Carro carro = new Carro();
					// Abaixo pedimos para completar as informa��es do carro.
					String modelo = EntradaSaida.solicitaModelo("Modelo do Carro");
					String cor = EntradaSaida.solicitaCor();
					// Depois de solicitado os atributos, n�s constru�mos o carro
					carro.constroiCarro(modelo, cor);
					this.fabrica.fabricaCarro(carro);
				}
				carroFabricado = true;
				break;
			case 1:
				if (carroFabricado == false) {
					EntradaSaida.confirmaCarrosFabricados();
				} else {
					// Pedir ao usu�rio que informe a cor e modelo do carro
					String modelo = EntradaSaida.solicitaModelo("Modelo do Carro");
					String cor = EntradaSaida.solicitaCor();
					fabrica.vendeCarro(modelo, cor);
				}
				break;
			case 2:
				if (carroFabricado == false) {
					EntradaSaida.confirmaCarrosFabricados();
				} else {
					fabrica.geraInforCarro();
				}
				break;
			case 3:
				break;
			}
			// A op��o neste caso tem de ser diferente de 3
		} while (opcao != 3);
		EntradaSaida.exibeMsgEncerraPrograma();

		System.exit(0);
	}
}
