import javax.swing.JOptionPane;
import controle.Controladora;


public class Principal {

	public static void main(String[] args) {
		//Se não adicionar nada no main, n�o ser� poss�vel reproduzir o c�digo. 
		Controladora controladora = new Controladora();
		controladora.exibeMenu();
	}

}
