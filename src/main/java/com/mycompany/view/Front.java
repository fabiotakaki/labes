package com.mycompany.view;

import com.mycompany.servlet.Servlet;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Front extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Front frame = new Front();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Front() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(234, 34, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(234, 72, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNomeUsuario = new JLabel("Nome Usuário");
		lblNomeUsuario.setBounds(97, 37, 46, 14);
		contentPane.add(lblNomeUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(97, 75, 100, 17);
		contentPane.add(lblSenha);
		
		JButton btnCadastrar = new JButton("cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrar();
				
			}
		});
		btnCadastrar.setBounds(97, 127, 111, 23);
		contentPane.add(btnCadastrar);
	}
	
	private void cadastrar() {
		try{
                        String senha = textField_1.getText();
			String nome = textField.getText();
			Servlet servlet = new Servlet();
			servlet.parameterPessoa(senha, nome);
			JOptionPane.showMessageDialog(this,"cadastrado com sucesso!");
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(this,"erro!");
		}
	}
	
}
