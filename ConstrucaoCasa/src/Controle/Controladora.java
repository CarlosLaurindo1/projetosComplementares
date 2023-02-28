package Controle;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import Visualizacao.EntradaSaida;
import Modelo.*;

public class Controladora {

	private Casa casa = null;
	// Precisa criar a variavel fora do case, pois se torna assim, uma vari�vel
	// global, e consegue receber todos os dados de dentro do case.

	public void exibeMenu() {
		int opcao;
		boolean casaConstruida = false;

		do {
			opcao = EntradaSaida.solicitaOpcao();

			switch (opcao) {
			case 0:
				this.casa = new Casa();

				String descricao = EntradaSaida.solicitaDescricao("casa", 0);
				String cor = EntradaSaida.solicitaCor();
				int qtdePortas = EntradaSaida.solicitaQtdeAberturas("portas");
				int qtdeJanelas = EntradaSaida.solicitaQtdeAberturas("janelas");

				ArrayList<Aberturas> listaDePortas = new ArrayList<Aberturas>();

				for (int i = 0; i < qtdePortas; i++) {
					Portas porta = new Portas();
					porta.setDescricao(EntradaSaida.solicitaDescricao("porta", (i + 1)));
					porta.setEstado(EntradaSaida.solicitaEstado("porta"));
					listaDePortas.add(porta);
				}

				ArrayList<Aberturas> listaDeJanelas = new ArrayList<Aberturas>();

				for (int i = 0; i < qtdeJanelas; i++) {
					Janelas janela = new Janelas();
					janela.setDescricao(EntradaSaida.solicitaDescricao("janela", (i + 1)));
					janela.setEstado(EntradaSaida.solicitaEstado("janela"));
					listaDeJanelas.add(janela);
				}

				JOptionPane.showMessageDialog(null, "Construir casa");
				this.casa.constroiCasa(descricao, cor, listaDePortas, listaDeJanelas);
				System.out.println("Descri��o da casa: " + casa.getDescricao() + "\n");
				System.out.println("Cor da casa: " + casa.getCor() + "\n");
				for (Aberturas porta : casa.getListaDePortas()) {
					System.out.println("Descri��o da porta: " + porta.getDescricao() + "\n");
					System.out.println("Estado da porta: " + porta.getEstado() + "\n");
				}

				for (Aberturas janela : casa.getListaDeJanelas()) {
					System.out.println("Descri��o da janela: " + janela.getDescricao() + "\n");
					System.out.println("Estado da janela: " + janela.getEstado() + "\n");
				}

				// Eu add esta vari�vel para usar como validador da casa como sendo constru�da
				//Caso eu tivesse validado o this.casa diferente de nulo teria funcionado tamb�m
				casaConstruida = true;
				break;

			case 1:
				if (casaConstruida == false) {
					JOptionPane.showMessageDialog(null,
							"Casa ainda n�o constru�da. Por favor, construa antes de ver suas informa��es.");
				} else {
					String tipoAbertura = EntradaSaida.solicitaTipoAbertura();

					ArrayList<Aberturas> listaDeAberturas = new ArrayList<Aberturas>();

					if (tipoAbertura.equals("porta")) {
						listaDeAberturas = this.casa.getListaDePortas();
					} else {
						listaDeAberturas = this.casa.getListaDeJanelas();
					}

					int posicao = EntradaSaida.solicitaAberturaMover(listaDeAberturas);
					int novoEstado = 0;

					if (posicao != -1) {
						novoEstado = EntradaSaida.solicitaEstado(tipoAbertura);
						Aberturas abertura = this.casa.retornaAbertura(posicao, tipoAbertura);
						this.casa.moverAbertura(abertura, novoEstado);
						System.out.println("Novo estado da " + tipoAbertura + ": " + abertura.getEstado());
					} else {
						EntradaSaida.exibeMsgAbertura();
					}
					// eu havia comentado
					JOptionPane.showMessageDialog(null, "Movimentar portas ou janelas");
				}
				break;

			case 2:
				// Fa�a uma valida��o de dados para que as op��es do menu possam ser acessadas
				// somente ap�s a casa ter sido constru�da. Pense bem na premissa que possu�mos
				// para saber se a casa j� foi constru�da ou n�o;
				if (casaConstruida == false) {
					JOptionPane.showMessageDialog(null,
							"Casa ainda n�o constru�da. Por favor, construa antes de ver suas informa��es.");
				} else {
					String informacoes = this.casa.geraInfoCasa();
					EntradaSaida.exibeInfoCasa(informacoes);
					// eu havia comentado
					JOptionPane.showMessageDialog(null, "Ver informa��es da casa");
				}
				break;
			}
		} while (opcao != 3);

		EntradaSaida.exibeMsgEncerraPrograma();

		System.exit(0);
	}

}
