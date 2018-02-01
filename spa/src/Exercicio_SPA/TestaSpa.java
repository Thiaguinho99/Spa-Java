	package Exercicio_SPA;
	
	import java.util.HashSet;
	import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
	
	public class TestaSpa {
	
		public static void main (String[] args) {
			// TODO Auto-generated method stub
			Set<Pacientes> registro = new HashSet<Pacientes>();
			
			Object Escolhalocal[] = {"Estetica", "Emagrecimento"};
			Object opcoes[] = {"Cadastrar", "Pesquisar", "Alterar", "Remover", "Apresentar", "Evolução do Peso", "Sair"};
			Object servicos[] = {"Emagrecimento", "Estética"};
			String sexo[] = {"Masculino", "Feminino"};
			String atividades[] = {"Caminhar no Bosque", "Nadar na Piscina", "Exercitar na Academia"};
			String servicos2[] = {"Massagem Nuru", "Meditacao hinduista", "Meditacao do Silencio"};
			Emagrecimento pacienteEmagrecimentoAux;
			Estetica pacienteEsteticaAux;
			String auxNome,novaAtividade;
			int escolha,servico, sair;
			double pesoIdeal, peso;
			boolean encontrar = false;
			Pacientes paciente = null;
			CalculoPeso CalculoPeso = new CalculoPeso();
			
			
			do {
				
				escolha = JOptionPane.showOptionDialog(null,null,"Menu Principal",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE, null,opcoes,"Cadastrar");
				
				switch(escolha) {
				
	//Cadastro
					case 0:
						
						servico = JOptionPane.showOptionDialog(null,"O paciente vai para a estetica?","PAra onde vai o paciente?",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE, null,Escolhalocal,"Sim");
						
	//se o paciente for de estética
						if(servico == 0) {
							
							paciente = new Estetica(JOptionPane.showInputDialog("Insira o nome do Paciente").toUpperCase(), 
									(String) JOptionPane.showInputDialog(null,"Insira o sexo do Paciente",null, JOptionPane.QUESTION_MESSAGE,null,sexo,null),
									Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone do Paciente")),
									(String) JOptionPane.showInputDialog(null,"Insira o tipo de Atividade",null, JOptionPane.QUESTION_MESSAGE,null,atividades,null),
									(String) JOptionPane.showInputDialog(null,"Insira o Serviço",null, JOptionPane.QUESTION_MESSAGE,null,servicos2,null));
							
							
							break;
						
	//se o paciente for de Emagrecimento
						}else {
							
							pesoIdeal = CalculoPeso.pesoIdeal(Double.parseDouble(JOptionPane.showInputDialog("Insira a altura do Paciente")),
									(String) JOptionPane.showInputDialog(null,"Insira o sexo do Paciente",null, JOptionPane.QUESTION_MESSAGE,null,sexo,null));
							peso = Double.parseDouble(JOptionPane.showInputDialog("Peso do Cliente"));
							
	
							if(pesoIdeal < peso) {
								
								JOptionPane.showMessageDialog(null, "O paciente pode fazer Emagrecimento");
								
								paciente = new Emagrecimento(JOptionPane.showInputDialog("Insira o nome do Paciente").toUpperCase(),
										(String) JOptionPane.showInputDialog(null,"Insira o sexo do Paciente",null, JOptionPane.QUESTION_MESSAGE,null,sexo,null),
									Integer.parseInt(JOptionPane.showInputDialog("Insira o telefone do Paciente")),
									Double.parseDouble(JOptionPane.showInputDialog("Insira o peso do Paciente")), 
									Double.parseDouble(JOptionPane.showInputDialog("Insira a altura do Paciente")), 
									(String) JOptionPane.showInputDialog(null,"Insira o tipo de Atividade",null, JOptionPane.QUESTION_MESSAGE,null,atividades,null));
								
								break;
							
	
							}else {
								
								JOptionPane.showMessageDialog(null, "Este cliente não precisa fazer o serviço de Emagrecimento");break;
								
							
	}//fim else
							
							
	}//fim else
						
					
	//case 1 :Busca por Nome
					case 1:
						
						auxNome = JOptionPane.showInputDialog("Insira o Nome do Paciente que deseja buscar ").toUpperCase();
						
	//Buscar
						for (Pacientes pacientePesquisa : registro) {
							
							if(pacientePesquisa.nome.equals(auxNome)) {
								
								if(pacientePesquisa instanceof Emagrecimento){
									
									pacienteEmagrecimentoAux = (Emagrecimento) pacientePesquisa;
									
									JOptionPane.showMessageDialog(null, pacienteEmagrecimentoAux.mostrarDadoscadastro());
									
									encontrar = true;
	
								}else{
									
									pacienteEsteticaAux = (Estetica) pacientePesquisa;
									
									JOptionPane.showMessageDialog(null, pacienteEsteticaAux.mostrarDadoscadastro());
									
									encontrar = true;
									
	}//fim else
									break;	
								
	}//fim if
	
								
	}//fim for
						
						
						//Checa se o paciente existe na Lista
						if(encontrar == false) {
							
							JOptionPane.showMessageDialog(null, "Paciente não encontrado");
							
	}//fim if
	
						break;
	
					
	//Alterar
					case 2:
						
						auxNome = JOptionPane.showInputDialog("Insira o nome do Paciente que deseja alterar a Atividade no spa").toUpperCase();
						
						for (Pacientes pacienteAlterar : registro) {
							
							if(pacienteAlterar.nome.equals(auxNome)) {
								
								novaAtividade = (String) JOptionPane.showInputDialog(null,"Insira a nova Atividade",null, JOptionPane.QUESTION_MESSAGE,null,atividades,null);
								
								pacienteAlterar.tipoAtividade = novaAtividade;
								
								encontrar = true;
								
							break;
							
	}//fim if
							
	
	}//fim for
						
						
						//Checa se o paciente existe na Lista
						if(encontrar == false) {
								
								JOptionPane.showMessageDialog(null, "Paciente não encontrado");
								
								break;
								
	}//fim if
						
						break;
	
					
	//Remover 	
					case 3:
						
						auxNome = JOptionPane.showInputDialog("Insira o nome do Paciente que deseja remover").toUpperCase();
						
						for (Pacientes pacienteRemover : registro) {
							
							if(pacienteRemover.nome.equals(auxNome)) {
								
								registro.remove(pacienteRemover);
								
								JOptionPane.showMessageDialog(null, "Paciente removido com sucesso");
								
								encontrar = true;
								
								break;
								
	}//fim if
							
	}//fim for
						
						
						//Checa se o paciente existe na Lista
						if(encontrar == false) {
								
								JOptionPane.showMessageDialog(null, "Paciente não encontrado");
								
	}//fim if
						
						break;
						
					//Master todos os pacientes de um determinado Serviço
					case 4:
						
						servico = JOptionPane.showOptionDialog(null,"Qual serviço deseja ver?","Serviços",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,servicos,"Emagrecimento");
						
						if(servico == 0) {
							
							//Verifica se a lista esta vazia
							if(registro.size() == 0) {
								
								JOptionPane.showMessageDialog(null, "Nenhum paciente na lista");
								
								break;
	}//fim if
							
							for (Pacientes pacientesLista : registro) {
								
								if(pacientesLista instanceof Emagrecimento) {
									
									pacienteEmagrecimentoAux = (Emagrecimento) pacientesLista;
									
									JOptionPane.showMessageDialog(null, pacienteEmagrecimentoAux.mostrarDadoscadastro(), "Cliente", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("/Spa_SintaFeliz/img_sexo.jpeg"));
									
	}//fim if
								
	}//fim for
							
							break;
							
						}else {
							
							//Verifica se a lista esta vazia
							if(registro.size() == 0) {
								
								JOptionPane.showMessageDialog(null, "Lista Vazia");
								
								break;
								
	}
							
							for (Pacientes pacientesLista : registro) {
								
								if(pacientesLista instanceof Estetica) {
									
									pacienteEsteticaAux = (Estetica) pacientesLista;
									
									JOptionPane.showMessageDialog(null, pacienteEsteticaAux.mostrarDadoscadastro(), "Cliente", JOptionPane.INFORMATION_MESSAGE,null);
								
	}//fim segundo if
								
								
	}//fim for
							
	}//fim else
						
						break;
						
						
					//Evolução do Peso
					case 5:
						
						auxNome = JOptionPane.showInputDialog("Insira o nome do Paciente").toUpperCase();
						
						for (Pacientes paciente2 : registro) {
							
							if(paciente2.nome.equals(auxNome)) {
								
								if(paciente2 instanceof Emagrecimento) {
									
									 pacienteEmagrecimentoAux = (Emagrecimento) paciente2;
									
									JOptionPane.showMessageDialog(null, "Nome: " + pacienteEmagrecimentoAux.nome + "\nPorcentagem para o Peso Ideal: " + CalculoPeso.porcentagemPesoIdeal(pacienteEmagrecimentoAux.peso, 
											pacienteEmagrecimentoAux.altura, pacienteEmagrecimentoAux.sexo ) + " %");
									
									encontrar = true;
								
								}else {
									
									JOptionPane.showMessageDialog(null, "Este paciente não é de Emagrecimento");
									
									encontrar = true;
									
								}break;
									
	}//fim if
							
	}//fim for
						
						
						//verifica se a lista esta vazia
						if(encontrar == false) {
							
							JOptionPane.showMessageDialog(null, "Paciente não encontrado");
							
	}
						
						break;
					
	//Sair do programa
					case 6:
							JOptionPane.showMessageDialog(null, "Criado por: Thiago Henrique Camara Araujo      V 0.1 \n\nSenai Zerbini 2 - INF A\n\nAno: 2017 \nTODOS OS DIREITOS RESERVADOS ","Créditos",JOptionPane.PLAIN_MESSAGE,null);
							System.exit(0);
				
	}//fim switch
			
	}while(escolha != 6);	//fim do
	
	
			
	
	
	}
	
	}


