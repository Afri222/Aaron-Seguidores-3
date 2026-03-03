package calculadora;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CalculadoraMain implements ActionListener{

	private JFrame frame;
	private JTextField campoTexto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculadoraMain window = new CalculadoraMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalculadoraMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[436px,grow]", "[19px,grow,fill][grow]"));
		
		campoTexto = new JTextField();
		frame.getContentPane().add(campoTexto, "cell 0 0,growx,aligny top");
		campoTexto.setColumns(10);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, "cell 0 1,grow");
		panel.setLayout(new MigLayout("", "[grow,fill][grow,fill][grow,fill][grow,fill]", "[grow,fill][grow,fill][grow,fill][grow,fill]"));
		
		JButton cuatro = new JButton("4");
		panel.add(cuatro, "cell 0 1");
		
		JButton cinco = new JButton("5");
		panel.add(cinco, "cell 1 1");
		
		JButton seis = new JButton("6");
		panel.add(seis, "cell 2 1");
		
		JButton resta = new JButton("-");
		panel.add(resta, "cell 3 1");
		
		JButton siete = new JButton("7");
		panel.add(siete, "cell 0 0");
		
		JButton ocho = new JButton("8");
		panel.add(ocho, "cell 1 0");
		
		JButton nueve = new JButton("9");
		panel.add(nueve, "cell 2 0");
		
		JButton suma = new JButton("+");
		panel.add(suma, "cell 3 0");
		
		JButton uno = new JButton("1");
		panel.add(uno, "cell 0 2");
		
		JButton dos = new JButton("2");
		panel.add(dos, "cell 1 2");
		
		JButton tres = new JButton("3");
		panel.add(tres, "cell 2 2");
		
		JButton multiplicacion = new JButton("*");
		panel.add(multiplicacion, "cell 3 2");
		
		JButton borrarTodo = new JButton("C");
		panel.add(borrarTodo, "cell 0 3");
		
		JButton cero = new JButton("0");
		panel.add(cero, "cell 1 3");
		
		JButton igualA = new JButton("=");
		panel.add(igualA, "cell 2 3");
		
		JButton division = new JButton("/");
		panel.add(division, "cell 3 3");
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton=(JButton)e.getSource();
		String numero = campoTexto.getText()+boton.getText();
		campoTexto.setText(numero);
		
	}

}