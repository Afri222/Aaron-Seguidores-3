package calculadora;

public class Operaciones {
	
	private double resultado;
	
	
	public double getResultado() {
		return resultado;
	}


	public void setResultado(double resultado) {
		this.resultado = resultado;
	}

	
	

	public double suma(double numero1 ,double numero2) {
		
		this.resultado=numero1+numero2;
	return this.resultado;
		
	}

	
	public double resta(double numero1, double numero2) {
		
		this.resultado=numero1-numero2;
		
		return this.resultado;
	}
	
	
	public double division(double numero1,double numero2) {
		
		if(numero2==0) {
			
			this.resultado=0;
		}
		else {
			
			this.resultado=numero1/numero2;
		}

		return this.resultado;
		
	}
	
	public double multiplicar(double numero1,double numero2) {
		
		this.resultado=numero1*numero2;
		
		return this.resultado;
	}
	
}

