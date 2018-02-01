package Exercicio_SPA;

public class Estetica extends Pacientes implements Atividades {
	
		protected String tipoServico;
		
		public Estetica(String nome,String sexo, int telefone, String tipoAtividade, String tipoServico){
			
			this.nome = nome;
			this.sexo = sexo;
			this.telefone = telefone;
			this.tipoAtividade = tipoAtividade;
			this.tipoServico = tipoServico;
}//ConstrutorEstetica
		
		@Override
		public String mostrarDadoscadastro(){
			
			return "Nome: " + this.nome + "\nSexo: " + this.sexo + "\nTelefone: " + this.telefone +  "\nTipo de Atividade: " + this.tipoAtividade + "\nTipo de Serviço: " + this.tipoServico;
			
}//Método de sobrecarga
		
		public String caminharBosque() {
			
			return "Caminhar no Bosque";
}//InterfaceBosque
		

		public String nadarPiscina() {
			
			return "Nadar na Piscina";
}//InterfacePiscina

		public String exercitarAcademia() {

			return "Exercitar na Academia";
}//InterfaceAcademia

}//fimEstetica
		









