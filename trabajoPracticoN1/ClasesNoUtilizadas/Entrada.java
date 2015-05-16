
public class Entrada {
	
	private Atraccion atraccion;
	private double costoEntrada;
	
	public Entrada(Atraccion atraccion){
		
		this.atraccion = atraccion;
		this.costoEntrada = atraccion.getCosto();
				
	}


	// Getters & Setters
		
	public Atraccion getAtraccion() {
		return atraccion;
	}

	public double getCostoEntrada() {
		return costoEntrada;
	}
	
}
