package visualizacao;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EntradaSaida {

	public static int solicitaOpcao() {
		String[] opcoes = { "Fabricar carros", "Vender carro", "Ver informações dos carros", "Sair do programa" };
		JComboBox<String> menu = new JComboBox<String>(opcoes);
		JOptionPane.showConfirmDialog(null, menu, "Selecione a opção desejada", JOptionPane.OK_CANCEL_OPTION);
		return menu.getSelectedIndex();
	}

	public static int qtdeCarros() {
		int qtde = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a quantidade total de carros"));
		return qtde;
	}

	public static void exibeMsgEncerraPrograma() {
		JOptionPane.showMessageDialog(null, "O programa será encerrado!");
	}

	public static String solicitaModelo(String modelo) {
		return JOptionPane.showInputDialog("Informe o " + modelo);
	}

	public static String solicitaCor() {
		return JOptionPane.showInputDialog("Informe a cor do carro");
	}

	public static void informaDadosIncorretos() {
		JOptionPane.showMessageDialog(null, "Modelo e cor informados, não conferem com os carros fabricados!");
	}
	
	public static void confirmaCarrosFabricados() {
		JOptionPane.showMessageDialog(null,
				"Nenhum existe nenhum carro fabricado ainda, ou todos foram vendidos. "
						+ "\nPor favor, confirme os dados com a fabrica e tente novamente ap�s o cadastro.");
	}

}