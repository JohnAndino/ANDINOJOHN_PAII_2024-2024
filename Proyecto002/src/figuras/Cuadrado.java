package figuras;

import interfaces.interfaceFiguras;

public class Cuadrado implements interfaceFiguras{

	@Override
	public void dibujar() {
		System.out.println("Se ah dibujado el Cuadrado");
		System.out.println("****");
        System.out.println("*  *");
        System.out.println("*  *");
        System.out.println("****");
        System.out.println();
		
	}

}
