package Exercicio_SPA;

public class Emagrecimento extends Pacientes implements Atividades{
//atributos
	protected CalculoPeso CalculoPeso = new CalculoPeso();
	protected double pesoIdeal;
	protected double peso;
	protected double altura;

	public Emagrecimento(String nome,String sexo, int telefone,double peso,double altura, String tipoAtividade){
		
		
		this.nome = nome;
		this.sexo = sexo;
		this.telefone = telefone;
		this.peso = peso;
		this.altura = altura;
		this.tipoAtividade = tipoAtividade;
		
		pesoIdeal = CalculoPeso.pesoIdeal(this.altura, this.sexo);
	
}//Construtor

			@Override
			public String mostrarDadoscadastro(){
				
				return "Nome: " + this.nome + "\nSexo: " + this.sexo + "\nTelefone: " + this.telefone + "\nPeso: " + this.peso + " Kg" +"\nTipo de Atividade: " + this.tipoAtividade;
				
}//metodop de sobrecarga
			
	
	

		public String caminharBosque() {
				
				return "Caminhar no Bosque";
}//InterfaceBosque
		
		
			public String nadarPiscina() {
				
				return "Nadar na Piscina";
}//InterfacePiscina
		
		
			public String exercitarAcademia() {
		
				return "Exercitar na Academia";
}//InterfaceAcademia
		
}



