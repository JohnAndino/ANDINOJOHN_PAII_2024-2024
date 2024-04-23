package figuras;

import interfaces.interfaceFiguras;

public class Main {

	public static void main(String[] args) {
		
		DibujarFiguras triangulo = new DibujarFiguras(new Triangulo());
		DibujarFiguras cuadrado = new DibujarFiguras(new Cuadrado());
		DibujarFiguras circulo = new DibujarFiguras(new Circulo());

	}

}
