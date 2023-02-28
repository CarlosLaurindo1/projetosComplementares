package modelo;

import java.util.ArrayList;

public class Carro {

	protected String modelo;
	protected String cor;
	// protected String combustivel;
	// protected int qtdePortas;

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public void constroiCarro(String modelo, String cor) {
		setModelo(modelo);
		setCor(cor);
	}

}
