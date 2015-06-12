
public class PromocionExtranjero extends Promocion {

	public PromocionExtranjero(int periodo) {
		super(periodo);
		// TODO Auto-generated constructor stub
	}
	
	public double calcularDescuento(Paquete paquete){
		
		double descuento=0;
		
		Usuario usuarioTemporal = paquete.getUsuarioDelPaquete();
		Atraccion atraccionTemporal = usuarioTemporal.buscarAtraccionMasCercana(usuarioTemporal.getDireccionX(),usuarioTemporal.getDireccionY(),paquete.getListaDeAtraccionesContratadas());
		int distancia = usuarioTemporal.calcularDistanciaDeViaje(usuarioTemporal.getDireccionX(), usuarioTemporal.getDireccionY(), atraccionTemporal.getCoordenadaX(),atraccionTemporal.getCoordenadaY());
		
		if (distancia>200){
			
			descuento = paquete.getCostoTotal()/2;
					
		}
		
		return descuento;
		
	}
	
	
}
