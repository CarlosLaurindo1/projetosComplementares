package modelo;

import java.util.ArrayList;
import visualizacao.EntradaSaida;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import modelo.Carro;

public class Fabrica {

	private ArrayList<Carro> listaDeCarros = new ArrayList<Carro>();
	// Aqui não precisamos pedir nada em relação aos atributos do carro, afinal
	// estamos com todas as informações do carro já construidas na classe carro.
	// A ideia da fábrica é ter vários carros e não um carro ter várias fábricas.

	public ArrayList<Carro> getListaDeCarros() {
		return listaDeCarros;
	}

	public void setListaDeCarros(ArrayList<Carro> listaDeCarros) {
		this.listaDeCarros = listaDeCarros;
	}

	public void fabricaCarro(Carro carro) {
		listaDeCarros.add(carro);
	}

	public void vendeCarro(String modelo, String cor) {
		boolean verificador = false;
		// Validar com o get modelo e cor que existe
		// Usar for com IF e comparar se a cor e modelo informados são equivalentes ao
		// carro encontrado, caso contrário apresentar a mensagem que o carro não existe
		for (int i = 0; i < listaDeCarros.size(); i++) {
			Carro carro = listaDeCarros.get(i);
			// System.out.println(carro.getCor() + carro.getModelo());
			// quando faz comparação entre um objeto e uma classe estática é necessário
			// utilizar o .equals ou .contains
			if (carro.getModelo().equals(modelo) && carro.getCor().equals(cor)) {
				listaDeCarros.remove(carro);
				JOptionPane.showMessageDialog(null, "Carro vendido!");
				verificador = true;
			}
		}
		// tirada a verificação de dentro do for
		if (verificador == false) {
			EntradaSaida.informaDadosIncorretos();
		}
	}

	public void geraInforCarro() {
		// int i = 0;
		String informacao = "";

		for (Carro carro : listaDeCarros) {
			informacao += "Modelo: " + carro.getModelo() + "\n";
			informacao += "Cor: " + carro.getCor() + "\n ------------- \n";
		}
		// coloco a mensagem para fora do for a fim de imprimir todos os dados de um só
		// vez
		JOptionPane.showMessageDialog(null, informacao);
	}
}
