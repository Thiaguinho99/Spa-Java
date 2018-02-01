package ExercicioSpa;

public class Emagrecimento extends Pacientes implements Atividaes{
	
	/***************************VARIÁVEIS*************************/
	
	protected CalculoPeso cp = new CalculoPeso();
	protected double pesoIdeal;
	
	protected double peso;
	protected double altura;
	
	/***************************CONSTRUTOR***********************/
	
	public Emagrecimento(String nome,String sexo, int telefone,double peso,double altura, String tipoAtividade){
		
		
		this.nome = nome;
		this.sexo = sexo;
		this.telefone = telefone;
		this.peso = peso;
		this.altura = altura;
		this.tipoAtividade = tipoAtividade;
		
		pesoIdeal = cp.pesoIdeal(this.altura, this.sexo);
		
	}
	
	
	/*******************MÉTODO SOBRESCRITO*********************/
	
	@Override
	public String mostrarDadoscadastro(){
		
		return "Nome: " + this.nome + "\nSexo: " + this.sexo + "\nTelefone: " + this.telefone + "\nPeso: " + this.peso + " Kg" +
				"\nTipo de Atividade: " + this.tipoAtividade;
		
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
