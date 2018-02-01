package Exercicio_SPA;

public class CalculoPeso {
	
public double pesoIdeal(double altura, String sexo){
		
		//se for Masculino
		if(sexo.equals("Masculino")){	
			return 72.7 * altura - 58;
		//se for feminino
		}else{		
			return 62.1 * altura - 44.7;
		}
		
	}
	
	public double porcentagemPesoIdeal(double peso, double altura, String sexo){
		
		return (1-pesoIdeal(altura,sexo)/peso) * 100;		
		
	}

}
