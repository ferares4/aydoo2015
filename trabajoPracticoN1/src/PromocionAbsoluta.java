public class PromocionAbsoluta extends Promocion {
	
	private double valorDeDescuento;

	public PromocionAbsoluta(int periodo, Double valorDeDescuento) {
		super(periodo);
		this.valorDeDescuento = valorDeDescuento;
		// TODO Auto-generated constructor stub
	}

	public double calcularDescuento(Paquete paquete){
		
		return this.valorDeDescuento;

	} 
	
	
	// Getters & Setters
	
	
	public double getValorDeDescuento() {
		return valorDeDescuento;
	}

	public void setValorDeDescuento(double valorDeDescuento) {
		this.valorDeDescuento = valorDeDescuento;
	}



}
