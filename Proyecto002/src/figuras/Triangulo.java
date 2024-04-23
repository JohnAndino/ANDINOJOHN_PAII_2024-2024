package figuras;

import interfaces.interfaceFiguras;

public class Triangulo implements interfaceFiguras{

	@Override
	public void dibujar() {
		System.out.println("Se ah dibujado el Triangulo");
		System.out.println("  *");
        System.out.println(" ***");
        System.out.println("*****");
        System.out.println();
		
	}

}
