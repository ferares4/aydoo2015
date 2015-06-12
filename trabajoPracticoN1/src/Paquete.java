import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Paquete {
	
	private double costoTotal=0;
	private List<Atraccion> listaDeAtraccionesContratadas;
	private List<Integer> cantidadDeEntradas;
	private Usuario usuarioDelPaquete;
	private List<Promocion> listaDePromocionesDisponibles; 

	
	public Paquete(){
		
		listaDeAtraccionesContratadas = new LinkedList<Atraccion>();
		cantidadDeEntradas = new LinkedList<Integer>();
		listaDePromocionesDisponibles = new LinkedList<Promocion>();

	}
	
	public void agregarPromocionDisponible(Promocion promocion){
		
		if (!this.listaDePromocionesDisponibles.contains(promocion)){
			
			this.listaDePromocionesDisponibles.add(promocion);			
		}
				
	}
	
	public void comprarEntrada(Atraccion atraccion){
		
		if (!listaDeAtraccionesContratadas.contains(atraccion)){
			
			listaDeAtraccionesContratadas.add(atraccion);
			cantidadDeEntradas.add(listaDeAtraccionesContratadas.indexOf(atraccion), 1);
			
		}
		
		else {
			
			cantidadDeEntradas.add(listaDeAtraccionesContratadas.indexOf(atraccion), cantidadDeEntradas.get(listaDeAtraccionesContratadas.indexOf(atraccion))+1);
			
		}
		
	}
	
	public void calcularCostoTotalDelPaquete(List <Atraccion> listaDeAtraccionesContratadas, List<Integer> cantidadDeEntradas){
		
		Iterator<Atraccion> iteradorAtraccion = listaDeAtraccionesContratadas.iterator();
		
		while (iteradorAtraccion.hasNext()){
			
			Atraccion atraccionTemporal = new Atraccion();
			atraccionTemporal = iteradorAtraccion.next();
			int indice = listaDeAtraccionesContratadas.indexOf(atraccionTemporal);
			int cantidad = cantidadDeEntradas.get(indice);
							
				costoTotal = costoTotal + atraccionTemporal.getCosto()*cantidad;
				
		}
		
		
	}
		
	
	/* Ajusta el costo total de un paquete teniendo en cuenta las promociones, se debe haber calculado previamente el costo total */
	public void ajustarCostoEnBaseAPromociones(){

		boolean aplicaPromocionExtranjero=false;
		double costoTotalTemporal = costoTotal;
		double descuento=0;

		//Recorre todas las promociones disponibles si esta promocion 
		for (Promocion promocion : this.listaDePromocionesDisponibles){

			if (promocion.getClass().equals(PromocionExtranjero.class) && promocion.getPeriodoDeVigenciaEnDias()>0){

				descuento = promocion.calcularDescuento(this);

				if (costoTotal == descuento*2){


					costoTotalTemporal -= descuento;
					aplicaPromocionExtranjero=true;

				}

			}

		}	


		if (aplicaPromocionExtranjero==false){

			for (Promocion promocion2 : this.listaDePromocionesDisponibles){

				if (promocion2.getPeriodoDeVigenciaEnDias()>0) {

					costoTotalTemporal -= promocion2.calcularDescuento(this);
				
				}
			}
		}

		costoTotal = costoTotalTemporal;

	}
	

	// Getters & Setters:
	
	public List<Promocion> getListaDePromocionesDisponibles() {
		return listaDePromocionesDisponibles;
	}

	public double getCostoTotal() {
		
		return costoTotal;
	
	}
	
	public Usuario getUsuarioDelPaquete(){
		
		return usuarioDelPaquete;
		
	}
	
	public void setUsuarioDelPaquete(Usuario usuario){
		
		this.usuarioDelPaquete = usuario;
		
	}

	public List<Atraccion> getListaDeAtraccionesContratadas() {
	
		return listaDeAtraccionesContratadas;
	
	}

	public List<Integer> getCantidadDeEntradas() {
	
		return cantidadDeEntradas;
	
	}


}
