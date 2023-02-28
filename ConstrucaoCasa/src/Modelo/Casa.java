package Modelo;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Casa {

	private String descricao;
	private String cor;
	private ArrayList<Aberturas> listaDePortas = new ArrayList<Aberturas>();
	private ArrayList<Aberturas> listaDeJanelas = new ArrayList<Aberturas>();

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public ArrayList<Aberturas> getListaDePortas() {
		return listaDePortas;
	}

	public void setListaDePortas(ArrayList<Aberturas> listaDePortas) {
		this.listaDePortas = listaDePortas;
	}

	public ArrayList<Aberturas> getListaDeJanelas() {
		return listaDeJanelas;
	}

	public void setListaDeJanelas(ArrayList<Aberturas> listaDeJanelas) {
		this.listaDeJanelas = listaDeJanelas;
	}

	public void constroiCasa(String descricao, String cor, ArrayList<Aberturas> listaDePortas,
			ArrayList<Aberturas> listaDeJanelas) {
		setDescricao(descricao);
		setCor(cor);
		setListaDePortas(listaDePortas);
		setListaDeJanelas(listaDeJanelas);
		
	}

	public Aberturas retornaAbertura(int posicao, String tipoAbertura) {
		if (tipoAbertura.equals("porta")) {
			return this.listaDePortas.get(posicao);
		} else {
			return this.listaDeJanelas.get(posicao);
		}
	}

	public void moverAbertura(Aberturas abertura, int novoEstado) {
		abertura.setEstado(novoEstado);
	}

	public String geraInfoCasa() {
		String informacoes = "Descrição: " + this.descricao + "\nCor: " + this.cor + "\nLista de portas: \n";

		for (Aberturas abertura : this.listaDePortas) {
			// Faça uma validação para que ao invés de 0 ou 1, sejam exibidos os estados
			// “fechada” ou “aberta” respectivamente no método geraInfoCasa() para as portas
			// e janelas;
			// Criada nova variável para armazenar o status da abertura
			String statusAbertura = null;
			int estado = abertura.getEstado();
			if (estado == 1) {
				statusAbertura = "Aberta";
			} else {
				statusAbertura = "Fechada";
			}
			informacoes += abertura.getDescricao() + " Estado: " + statusAbertura + "\n";
		}
		informacoes += "\nLista de janelas: \n";

		for (Aberturas abertura : this.listaDeJanelas) {
			// Criada nova variável para armazenar o status da abertura
			String statusAbertura = null;
			int estado = abertura.getEstado();
			if (estado == 1) {
				statusAbertura = "Aberta";
			} else {
				statusAbertura = "Fechada";
			}
			informacoes += abertura.getDescricao() + " Estado: " + statusAbertura + "\n";
		}

		return informacoes;
	}

	public static void exibeInfoCasa(String informacoes) {
		JOptionPane.showMessageDialog(null, informacoes, "Informações da casa", JOptionPane.INFORMATION_MESSAGE);
	}

}
