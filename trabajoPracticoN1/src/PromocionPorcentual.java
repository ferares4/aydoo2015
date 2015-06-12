
public class PromocionPorcentual extends Promocion {
	
	private int porcentaje;

	public PromocionPorcentual(int periodo, int porcentaje) {
		super(periodo);
		this.porcentaje = porcentaje;
		// TODO Auto-generated constructor stub
	}

	public double calcularDescuento(Paquete paquete){
		
		return (paquete.getCostoTotal()*porcentaje)/100;

	} 

	//Getters & Setters
	
	public int getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}


}
