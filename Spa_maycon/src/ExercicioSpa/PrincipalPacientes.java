/**************************************
* 								      *
* Criado por: Maycon Robert Brolacci  *
* Turma: 	  Senai Zerbini 2 INF A	  *
* Data:		  Novembro/2017		   	  *
*								   	  *
**************************************/

package ExercicioSpa;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class PrincipalPacientes{

		//Contrutor contendo todo o programa 
		public PrincipalPacientes() {
		/****************************DECLARAÇÕES*************************************/
		
		Set<Pacientes> registro = new HashSet<Pacientes>();
		
		Object opcoes[] = {"Cadastrar", "Pesquisar", "Alterar", "Remover", "Apresentar", "Evolução do Peso", "Sair"};
		Object servicos[] = {"Emagrecimento", "Estética"};
		String sexo[] = {"Masculino", "Feminino"};
		String atividades[] = {"Caminhar no Bosque", "Nadar na Piscina", "Exercitar na Academia"};
		String servicos2[] = {"Limpeza de Pele", "Hidratação Profunda", "Massagem Estética"};
		Emagrecimento pacienteEmaAux;
		Estetica pacienteEstAux;
		
		String auxNome,novaAtividade;
		int escolha,servico, sair;
		double pesoIdeal, peso;
		boolean encontrar = false;
		Pacientes paciente = null;
		CalculoPeso cp = new CalculoPeso();
		DecimalFormat df = new DecimalFormat("###,##0.00");	
		
		
		do {
		
			escolha = JOptionPane.showOptionDialog(null,null,"Menu Principal",JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, new ImageIcon(getClass().getResource("/ExercicioSpa/SpaLogo.png")),opcoes,"Cadastrar");
			
			switch(escolha) {
			
				//Cadastro de novos Pacientes
				case 0:
					
					servico = JOptionPane.showConfirmDialog(null, "O Paciente é de Estética?", "Serviço", JOptionPane.YES_NO_OPTION);
					
					//Caso o paciente for de estética, irá realizar o cadastro do mesmo
					if(servico == 0) {
						
						paciente = new Estetica(JOptionPane.showInputDialog("Insira o nome do Paciente").toUpperCase(), (String) JOptionPane.showInputDialog(null,"Insira o sexo do Paciente",null, JOptionPane.QUESTION_MESSAGE,null,sexo,null),
								Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone do Paciente")), (String) JOptionPane.showInputDialog(null,"Insira o tipo de Atividade",null, JOptionPane.QUESTION_MESSAGE,null,atividades,null),
								(String) JOptionPane.showInputDialog(null,"Insira o Serviço",null, JOptionPane.QUESTION_MESSAGE,null,servicos2,null));
						
						
						break;
					
					//Caso o paciente for de Emagrecimento irá realizar o teste para saber se é necessário
					}else {
						
						pesoIdeal = cp.pesoIdeal(Double.parseDouble(JOptionPane.showInputDialog("Insira a altura do Paciente")), (String) JOptionPane.showInputDialog(null,"Insira o sexo do Paciente",null, JOptionPane.QUESTION_MESSAGE,null,sexo,null));
						peso = Double.parseDouble(JOptionPane.showInputDialog("Peso do Cliente"));
						
						//Caso for necessário irá começar o cadastro
						if(pesoIdeal < peso) {
							
							JOptionPane.showMessageDialog(null, "O paciente pode fazer Emagrecimento");
							
							paciente = new Emagrecimento(JOptionPane.showInputDialog("Insira o nome do Paciente").toUpperCase(), (String) JOptionPane.showInputDialog(null,"Insira o sexo do Paciente",null, JOptionPane.QUESTION_MESSAGE,null,sexo,null),
								Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone do Paciente")), Double.parseDouble(JOptionPane.showInputDialog("Insira o peso do Paciente")), 
								Double.parseDouble(JOptionPane.showInputDialog("Insira a altura do Paciente")), (String) JOptionPane.showInputDialog(null,"Insira o tipo de Atividade",null, JOptionPane.QUESTION_MESSAGE,null,atividades,null));
							
							break;
						
						//Caso não for necessário irá mostrar esta mensagem e irá voltar ao Menu Principal
						}else {
							
							JOptionPane.showMessageDialog(null, "Este cliente não precisa fazer o serviço de Emagrecimento");break;
							
						}
						
						
					}//Chave do primeiro 'ELSE'
				
				
				//Busca por Nome
				case 1:
					
					auxNome = JOptionPane.showInputDialog("Insira o Nome do Paciente a qual deseja buscar").toUpperCase();
					
					//Busca na Lista
					for (Pacientes paciente2 : registro) {
						
						if(paciente2.nome.equals(auxNome)) {
							
							if(paciente2 instanceof Emagrecimento){
								
								pacienteEmaAux = (Emagrecimento) paciente2;
								
								JOptionPane.showMessageDialog(null, pacienteEmaAux.mostrarDadoscadastro());
								
								encontrar = true;

							}else{
								
								pacienteEstAux = (Estetica) paciente2;
								
								JOptionPane.showMessageDialog(null, pacienteEstAux.mostrarDadoscadastro());
								
								encontrar = true;
								
							}
								break;	
							
						}// Chave 'IF'

							
					}// Chave 'FOR'
					
					
					//Checa se o paciente existe na Lista
					if(encontrar == false) {
						
						JOptionPane.showMessageDialog(null, "Paciente não encontrado");
						
					}

					break;

				
				//Altera a atividade de um Paciente
				case 2:
					
					auxNome = JOptionPane.showInputDialog("Insira o nome do Paciente que deseja alterar a Atividade").toUpperCase();
					
					for (Pacientes paciente2 : registro) {
						
						if(paciente2.nome.equals(auxNome)) {
							
							novaAtividade = (String) JOptionPane.showInputDialog(null,"Insira a nova Atividade",null, JOptionPane.QUESTION_MESSAGE,null,atividades,null);
							
							paciente2.tipoAtividade = novaAtividade;
							
							encontrar = true;
							
						break;
						
						}
						

					}
					
					
					//Checa se o paciente existe na Lista
					if(encontrar == false) {
							
							JOptionPane.showMessageDialog(null, "Paciente não encontrado");
							
							break;
							
						}// Chave 'IF'
					
					break;

				
				//Remove um paciente da Lista	
				case 3:
					
					auxNome = JOptionPane.showInputDialog("Insira o nome do Paciente que deseja remover").toUpperCase();
					
					for (Pacientes paciente2 : registro) {
						
						if(paciente2.nome.equals(auxNome)) {
							
							registro.remove(paciente2);
							
							JOptionPane.showMessageDialog(null, "Paciente removido com sucesso");
							
							encontrar = true;
							
							break;
							
						}// Chave do 'IF'
						
					}// Chave do 'FOR'
					
					
					//Checa se o paciente existe na Lista
					if(encontrar == false) {
							
							JOptionPane.showMessageDialog(null, "Paciente não encontrado");
							
						}
					
					break;
					
				//Mostra todos os pacientes de um determinado Serviço
				case 4:
					
					servico = JOptionPane.showOptionDialog(null,"Qual serviço deseja mostrar?","Serviços",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,servicos,"Emagrecimento");
					
					if(servico == 0) {
						
						//Verifica se a lista esta vazia
						if(registro.size() == 0) {
							
							JOptionPane.showMessageDialog(null, "Lista Vazia");
							
							break;
							
						}
						
						for (Pacientes paciente2 : registro) {
							
							if(paciente2 instanceof Emagrecimento) {
								
								pacienteEmaAux = (Emagrecimento) paciente2;
								
								JOptionPane.showMessageDialog(null, pacienteEmaAux.mostrarDadoscadastro(), "Cliente", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/ExercicioSpa/Usuario.png")));
								
							}//Chave segundo 'IF'
							
						}//Chave 'FOR'
						
						break;
						
					}else {
						
						//Verifica se a lista esta vazia
						if(registro.size() == 0) {
							
							JOptionPane.showMessageDialog(null, "Lista Vazia");
							
							break;
							
						}
						
						for (Pacientes paciente2 : registro) {
							
							if(paciente2 instanceof Estetica) {
								
								pacienteEstAux = (Estetica) paciente2;
								
								JOptionPane.showMessageDialog(null, pacienteEstAux.mostrarDadoscadastro(), "Cliente", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/ExercicioSpa/Usuario.png")));
							
							}//Chave segundo 'IF'
							
							
						}//Chave 'FOR'
						
					}//Chave 'Else'
					
					break;
					
					
				//Evolução do Peso
				case 5:
					
					auxNome = JOptionPane.showInputDialog("Insira o nome do Paciente").toUpperCase();
					
					for (Pacientes paciente2 : registro) {
						
						if(paciente2.nome.equals(auxNome)) {
							
							if(paciente2 instanceof Emagrecimento) {
								
								 pacienteEmaAux = (Emagrecimento) paciente2;
								
								JOptionPane.showMessageDialog(null, "Nome: " + pacienteEmaAux.nome + "\nPorcentagem para o Peso Ideal: " + df.format(cp.porcentagemPesoIdeal(pacienteEmaAux.peso, 
										pacienteEmaAux.altura, pacienteEmaAux.sexo ) )+ " %");
								
								encontrar = true;
							
							}else {
								
								JOptionPane.showMessageDialog(null, "Este paciente não é de Emagrecimento");
								
								encontrar = true;
								
							}break;
								
						}//Chave primeiro 'IF'
						
					}// Chave do 'FOR'
					
					
					//Checa se o paciente existe na Lista
					if(encontrar == false) {
						
						JOptionPane.showMessageDialog(null, "Paciente não encontrado");
						
					}
					
					break;
				
				//Sair do programa
				case 6:
					
					sair = JOptionPane.showConfirmDialog(null, "Deseja Mostrar os Créditos?", "Créditos", JOptionPane.YES_NO_OPTION);
					
					if(sair == 0) {
						
						JOptionPane.showMessageDialog(null, "Criado por: Maycon Robert Brolacci \n\nSenai Zerbini 2- INF A\n\nCriado em: Novembro 2017","Créditos",JOptionPane.PLAIN_MESSAGE,new ImageIcon(getClass().getResource("/ExercicioSpa/Creditos.png")));
						
					}
				
					System.exit(0);
			
			}//Chave 'Switch'
		
		}while(escolha != 6);	//Chave 'Do'

	}//Chave Construtor
		
		//Rodar o programa
		public static void main(String[] args) {

			new PrincipalPacientes();	//Criar um novo objeto do tipo PrincipalPacientes
			
		}

}
