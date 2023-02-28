package Visualizacao;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import Modelo.Aberturas;

public class EntradaSaida {

	public static int solicitaOpcao() {
		String[] opcoes = { "Contruir casa", "Movimentar portas ou janelas", "Ver informa��es da casa",
				"Sair do programa" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Seleciona a op��o desejada", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	}

	public static void exibeMsgEncerraPrograma() {
		JOptionPane.showMessageDialog(null, "O programa ser� encerrado!");
	}

	public static String solicitaDescricao(String descricao, int ordem) {
		if (ordem == 0) {
			return JOptionPane.showInputDialog("Informe a descri��o da " + descricao);
		} else {
			return JOptionPane.showInputDialog("Informe a descri��o da " + ordem + " " + descricao);
		}
	}

	public static String solicitaCor() {
		return JOptionPane.showInputDialog("Informe a cor da casa");
	}

	public static int solicitaQtdeAberturas(String abertura) {
		//2 - Fa�a uma valida��o de dados para que n�o possam ser informadas quantidades negativas de portas ou janelas ou zero; 
		int qtdePortasJanelas = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de " + abertura));
		
		while(qtdePortasJanelas<=0) {
			qtdePortasJanelas = Integer.parseInt(JOptionPane.showInputDialog("A quantidade � menor ou igual a Zero! \nVerifique e informe a quantidade de " + abertura + " novamente."));
		}
		
		return qtdePortasJanelas;
	}

	public static int solicitaEstado(String tipoAbertura) {
		String[] opcoes = { "Fechada", "Aberta" };

		return JOptionPane.showOptionDialog(null, "Informe o estado da " + tipoAbertura, "Estado",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[1]);
	}

	public static String solicitaTipoAbertura() {
		String[] opcoes = { "Porta", "Janela" };

		int tipoAbertura = JOptionPane.showOptionDialog(null, "Informe qual tipo de abertura deseja mover",
				"Mover abertura", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
		if (tipoAbertura == 0) {
			return "porta";
		} else {
			return "janela";
		}
	}

	public static int solicitaAberturaMover(ArrayList<Aberturas> listaDeAberturas) {
		String tipoAbertura = listaDeAberturas.get(0).getClass().getName();
		tipoAbertura = tipoAbertura.replaceAll("modelo.", "");
		int qtdeAbertura = listaDeAberturas.size();
		String[] descricoesAberturas = new String[qtdeAbertura];

		for (int i = 0; i < qtdeAbertura; i++) {
			descricoesAberturas[i] = listaDeAberturas.get(i).getDescricao();
		}

		String msg = "Escolha a " + tipoAbertura + " a ser movimentada";
		JComboBox exibicaoAberturas = new JComboBox(descricoesAberturas);
		int confirmacao = JOptionPane.showConfirmDialog(null, exibicaoAberturas, msg, JOptionPane.OK_CANCEL_OPTION);

		if (confirmacao == 0) {
			return exibicaoAberturas.getSelectedIndex();
		} else {
			return -1;
		}
	}

	public static void exibeMsgAbertura() {
		JOptionPane.showMessageDialog(null, "Nenhuma abertura ser� movimentada");
	}

	public static void exibeInfoCasa(String informacoes) {
		JOptionPane.showMessageDialog(null, informacoes, "Informa��es da casa", JOptionPane.INFORMATION_MESSAGE);
	}

}
