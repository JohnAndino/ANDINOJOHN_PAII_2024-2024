package figuras;

import interfaces.interfaceFiguras;

public class Circulo implements interfaceFiguras{

	@Override
	public void dibujar() {
		System.out.println("Se ah dibujado el circulo");
		System.out.println("  ****");
        System.out.println(" *    *");
        System.out.println(" *    *");
        System.out.println("  ****");
        System.out.println();
	}

}
