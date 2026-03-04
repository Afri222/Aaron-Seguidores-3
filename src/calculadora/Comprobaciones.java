package calculadora;


import java.util.ArrayList;
import java.util.Set;



public class Comprobaciones {
	private String lectura;
	private ArrayList<String> listNumeros;
	private final Set<String> OPERADORES;
	
	
	public Comprobaciones() {
		this.OPERADORES = Set.of("+","-","x","/","=");
		this.listNumeros = new ArrayList<String>();
		
	}
	
	public ArrayList<String> lecturaPantalla(String lecturaPantalla) {
		int i = 0;
		int comienzoNum = i;
		lecturaPantalla = lecturaPantalla.toLowerCase();
		String subStr;

		while(i < lecturaPantalla.length()){
			char caracter = lecturaPantalla.charAt(i);
			if (OPERADORES.contains(String.valueOf(caracter))) {		
				subStr = lecturaPantalla.substring(comienzoNum, i);
				listNumeros.add(subStr);
				comienzoNum = i + 1;
				//Comprobar si hay operadores, si no hay (!) significa que llego al final y se debe añadir a la lista
				if (!this.hayOperador(lecturaPantalla, i + 1)){
					subStr = lecturaPantalla.substring(i + 1);
					listNumeros.add(String.valueOf(caracter));
					listNumeros.add(subStr);
				}else {
					listNumeros.add(String.valueOf(caracter));
				}
			}
			i++;
		}
		return listNumeros;
	}
	
	public boolean hayOperador(String subStr, int indice) {
		String str = subStr.substring(indice);
		if (str.indexOf('+') == -1 &&
				str.indexOf('-') == -1 &&
				str.indexOf('x') == -1 && 
				str.indexOf('/') == -1) {
			return false;			
		}	
		return true;
	}
	
	public ArrayList<String> jerarquiaMultDiv(ArrayList<String> listaNumeros){
		int resultado;
		System.out.println("tamaño Lista: " + listaNumeros.size());
		System.out.println(listaNumeros);
		
		for (int i = 0; i < listaNumeros.size(); i++) {
			//System.out.println(listaNumeros.get(i)); 
			
			//Usar las clase Operadores
			if (listaNumeros.get(i).equals("x")) {
				System.out.println("Poscicion Actual: " +  i + "------" + listaNumeros.get(i));
				resultado = Integer.parseInt(listaNumeros.get(i - 1)) * Integer.parseInt(listaNumeros.get(i + 1));
				listaNumeros.set(i - 1, String.valueOf(resultado));
				listaNumeros.remove(i);
				listaNumeros.remove(i);
				i--;
				System.out.println("-----Nueva Lista---: " + listaNumeros);
				System.out.println("Poscicion Nueva: " + i + "------" + listaNumeros.get(i));
				//System.out.println("Resultado de multiplicacion: " + resultado);
			}else if (listaNumeros.get(i).equals("/")) {
				System.out.println("Poscicion Actual: " + i + "------" + listaNumeros.get(i));
				resultado = Integer.parseInt(listaNumeros.get(i - 1)) / Integer.parseInt(listaNumeros.get(i + 1));
				listaNumeros.set(i - 1, String.valueOf(resultado));
				listaNumeros.remove(i);
				listaNumeros.remove(i);
				i--;
				System.out.println("Poscicion nueva: " + i + "------" + listaNumeros.get(i));
			}
		}
		System.out.println("tamaño Lista: " + listaNumeros.size());
		System.out.println(listaNumeros);
		
		if (listaNumeros.size() == 1)
			return listaNumeros;
		else {
			for(int i = 0; i < listaNumeros.size(); i++) {
				if (listaNumeros.get(i).equals("+")){
					resultado = Integer.parseInt(listaNumeros.get(i - 1)) + Integer.parseInt(listaNumeros.get(i+1));
					listaNumeros.set(i - 1, String.valueOf(resultado));
					listaNumeros.remove(i);
					listaNumeros.remove(i);
					i--;
				}else {
					resultado = Integer.parseInt(listaNumeros.get(i - 1)) - Integer.parseInt(listaNumeros.get(i+1));
					listaNumeros.set(i - 1, String.valueOf(resultado));
					listaNumeros.remove(i);
					listaNumeros.remove(i);
					i--;
				}
				System.out.println("Iterador: " +i);
			}
		}
		System.out.println(listaNumeros);
		return listaNumeros;
	}
	
	public String getLectura() {
		return lectura;
	}

	public void setLectura(String lectura) {
		this.lectura = lectura;
	}

	public ArrayList<String> getListNumeros() {
		return listNumeros;
	}

	public void setListNumeros(ArrayList<String> listNumeros) {
		this.listNumeros = listNumeros;
	}

	public Set<String> getOPERADORES() {
		return OPERADORES;
	}
}
