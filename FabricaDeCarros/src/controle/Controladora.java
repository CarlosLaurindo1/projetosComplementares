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

				// Diferente da casa, na construção do carro, não precisamos acrescentar novos
				// dados para atribuir outras informações do carro
				// Dentro do FOR nós adicionamos todos os dados do carro (modelo, cor)

				for (int i = 0; i < qtdeCarros; i++) {
					// acrescentamos o carro pois é aqui que o construimos.
					Carro carro = new Carro();
					// Abaixo pedimos para completar as informações do carro.
					String modelo = EntradaSaida.solicitaModelo("Modelo do Carro");
					String cor = EntradaSaida.solicitaCor();
					// Depois de solicitado os atributos, nós construímos o carro
					carro.constroiCarro(modelo, cor);
					this.fabrica.fabricaCarro(carro);
				}
				carroFabricado = true;
				break;
			case 1:
				if (carroFabricado == false) {
					EntradaSaida.confirmaCarrosFabricados();
				} else {
					// Pedir ao usuário que informe a cor e modelo do carro
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
			// A opção neste caso tem de ser diferente de 3
		} while (opcao != 3);
		EntradaSaida.exibeMsgEncerraPrograma();

		System.exit(0);
	}
}
