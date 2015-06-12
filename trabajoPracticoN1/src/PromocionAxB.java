import java.util.List;


public class PromocionAxB extends Promocion {

	public PromocionAxB(int periodo) {
		super(periodo);
		// TODO Auto-generated constructor stub
	}

	
	public double calcularDescuento(Paquete paquete){
		
		double descuento=0;
		Promocion promocionAxB = null;
		
		for (Promocion promocion : paquete.getListaDePromocionesDisponibles()){
			
			if (promocion.getClass().equals(this.getClass())){
				
				promocionAxB = promocion;
				
			}
		
		}
			
		if (promocionAxB!=null && paquete.getListaDeAtraccionesContratadas().containsAll(promocionAxB.getListaDeAtracciones())){
				
			List<Atraccion> listaDeAtracciones = promocionAxB.getListaDeAtracciones();	
			SugerenteDeVisitas sugerente = new SugerenteDeVisitas();
			sugerente.ordenarListaPorCosto(listaDeAtracciones);
			descuento = listaDeAtracciones.get(0).getCosto() * (paquete.getCantidadDeEntradas().get(paquete.getListaDeAtraccionesContratadas().indexOf(listaDeAtracciones.get(0))));
				
		}
	
		return descuento;
		
	}
	
}
