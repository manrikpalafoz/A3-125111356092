package Interfaces;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


public class TelaMenu extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
//	public static TelaMenu FOpcao;
	private JTextField txtNome;
	private JRadioButton rbtnComputador, rbtnPlayers;
	private JTextField txtParOuImpar;


	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					TelaMenu frame= new TelaMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TelaMenu() {
		setTitle("Par ou Impar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNome = new JTextField();
		txtNome.setHorizontalAlignment(SwingConstants.CENTER);
		txtNome.setText("Digite seu nome");
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNome.setColumns(10);
		txtNome.setBounds(163, 169, 233, 53);
		contentPane.add(txtNome);
		
		JButton btnJogar = new JButton("JOGAR");
		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!txtNome.getText().trim().equals("")){
						if(rbtnComputador.isSelected()){
							TeladeJogada frame = new TeladeJogada(txtNome.getText());
							frame.setVisible(true);
						}else{
							TeladeJogadaRede frame2 = new TeladeJogadaRede(txtNome.getText());
							frame2.setEnabled(false);
							frame2.setFocusable(false);
							frame2.setVisible(true);
							TelaEspera frame1 = new TelaEspera(frame2);
							frame1.setVisible(true);
							
						}
						dispose();
					}else{
						JOptionPane.showMessageDialog(null, "Digite um nome v�lido!");
					}
				}catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnJogar.setBounds(204, 245, 161, 70);
		contentPane.add(btnJogar);
		
		rbtnComputador = new JRadioButton("Jogar contra PC");
		rbtnComputador.setBackground(new Color(255, 250, 250));
		rbtnComputador.setSelected(true);
		rbtnComputador.setFont(new Font("Tahoma", Font.BOLD, 20));
		rbtnComputador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rbtnComputador.setSelected(true);
				rbtnPlayers.setSelected(false);
			}
		});
		rbtnComputador.setBounds(40, 79, 216, 61);
		contentPane.add(rbtnComputador);
		
		rbtnPlayers = new JRadioButton("Multiplayer");
		rbtnPlayers.setFont(new Font("Tahoma", Font.BOLD, 20));
		rbtnPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbtnComputador.setSelected(false);
				rbtnPlayers.setSelected(true);
			}
		});
		rbtnPlayers.setBounds(348, 79, 199, 61);
		contentPane.add(rbtnPlayers);
		
		txtParOuImpar = new JTextField();
		txtParOuImpar.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtParOuImpar.setHorizontalAlignment(SwingConstants.CENTER);
		txtParOuImpar.setText("PAR OU IMPAR");
		txtParOuImpar.setBounds(131, 11, 314, 44);
		contentPane.add(txtParOuImpar);
		txtParOuImpar.setColumns(10);
	}
}
