package ExercicioSpa;

public class Estetica extends Pacientes implements Atividaes {
	
	protected String tipoServico;
	
	/***************************CONSTRUTOR***********************/
	
	public Estetica(String nome,String sexo, int telefone, String tipoAtividade, String tipoServico){
		
		this.nome = nome;
		this.sexo = sexo;
		this.telefone = telefone;
		this.tipoAtividade = tipoAtividade;
		this.tipoServico = tipoServico;
	}
	
	/*******************MÉTODO SOBRESCRITO*********************/
	
	@Override
	public String mostrarDadoscadastro(){
		
		return "Nome: " + this.nome + "\nSexo: " + this.sexo + "\nTelefone: " + this.telefone +  
				"\nTipo de Atividade: " + this.tipoAtividade + "\nTipo de Serviço: " + this.tipoServico;
		
	}
	
	/*******************MÉTODOS DA INTERFACE*******************/
	
	public String caminharBosque() {
		
		return "Caminhar no Bosque";
	}
	

	public String nadarPiscina() {
		
		return "Nadar na Piscina";
	}


	public String exercitarAcademia() {

		return "Exercitar na Academia";
	}

}
