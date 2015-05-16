import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Paquete {
	
	private double costoTotal=0;
	private List<Atraccion> listaDeAtraccionesContratadas;
	private List<Integer> cantidadDeEntradas;
	private Usuario usuarioDelPaquete;

	
	public Paquete(){
		
		listaDeAtraccionesContratadas = new LinkedList<Atraccion>();
		cantidadDeEntradas = new LinkedList<Integer>();

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
	
	public void calcularCostoTotal(List <Atraccion> listaDeAtraccionesContratadas, List<Integer> cantidadDeEntradas){
		
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
	public void calcularCostoEnBaseAPromociones(Promocion[] vectorDePromociones){

		this.calcularCostoTotal(listaDeAtraccionesContratadas, cantidadDeEntradas);
		
		if (this.aplicarPromocionExtrajero()==false){


			this.aplicarPromocionPorcentual(vectorDePromociones);
			this.aplicarPromocionPorPaquete(vectorDePromociones);
			this.aplicarPromocionAxB(vectorDePromociones);


		}

	}
	
	public void aplicarPromocionPorPaquete(Promocion[] vectorDePromociones){
		
		//Chequea y descuenta si todas las atracciones del itinerario tienen una promocion por paquete
		for (int i=0;i<vectorDePromociones.length;i++){

			if (vectorDePromociones[i].getTipo().equals(tipoDePromocion.PROMOCION_POR_PAQUETE) && vectorDePromociones[i].getPeriodoDeVigenciaEnDias()>0){

				if (vectorDePromociones[i].getListaDeAtracciones().containsAll(listaDeAtraccionesContratadas)){

					this.costoTotal = costoTotal-((costoTotal*15)/100);

				}

			}

		}
		
	}
	
	
	public void aplicarPromocionPorcentual(Promocion[] vectorDePromociones){
		
		Iterator<Atraccion> iterador = listaDeAtraccionesContratadas.iterator();
		
		//Chequea y descuenta todas las promocines porcentuales
		while (iterador.hasNext()){

			Atraccion atraccionTemporal = iterador.next();

			for (int i=0;i<vectorDePromociones.length;i++){

				if (vectorDePromociones[i].getTipo().equals(tipoDePromocion.PROMOCION_PORCENTUAL) && vectorDePromociones[i].getPeriodoDeVigenciaEnDias()>0){

					if (vectorDePromociones[i].getListaDeAtracciones().contains(atraccionTemporal)){

						this.costoTotal = costoTotal - ((atraccionTemporal.getCosto()*10)/100);

					}

				}


			} 

		}
		
		
	}
	
	public void aplicarPromocionAxB(Promocion[] vectorDePromociones){
		
		Iterator<Atraccion> iterador = listaDeAtraccionesContratadas.iterator();
		
		//Chequea si todas las promocines del itinerario tienen promocion AxB luego descuenta la mas barata
		for (int i=0;i<vectorDePromociones.length;i++){

			if (vectorDePromociones[i].getTipo().equals(tipoDePromocion.PROMOCIONAXB) && vectorDePromociones[i].getPeriodoDeVigenciaEnDias()>0){

				if (vectorDePromociones[i].getListaDeAtracciones().containsAll(listaDeAtraccionesContratadas)){

					while(iterador.hasNext()){

						List<Atraccion> listaXCosto = new SugerenteDeVisitas().ordenarListaPorCosto(listaDeAtraccionesContratadas);
						costoTotal -= listaXCosto.get(0).getCosto();

					}

				}

			}

		}
		
	}
	
	public boolean aplicarPromocionExtrajero(){
		
		Atraccion atraccionTemporal = usuarioDelPaquete.buscarAtraccionMasCercana(usuarioDelPaquete.getDireccionX(),usuarioDelPaquete.getDireccionY(),listaDeAtraccionesContratadas);
		int distancia = this.usuarioDelPaquete.calcularDistanciaDeViaje(usuarioDelPaquete.getDireccionX(), usuarioDelPaquete.getDireccionY(), atraccionTemporal.getCoordenadaX(),atraccionTemporal.getCoordenadaY());
		
		if (distancia>200){
			
			this.costoTotal = costoTotal/2;
			return true;
		}
		
		return false;
		
	}
	

	
	public void aplicarPromocionFamiliar(List <Atraccion> listaDeAtraccionesContratadas, List<Integer> cantidadDeEntradas){
		
		Iterator<Atraccion> iteradorAtraccion = listaDeAtraccionesContratadas.iterator();
				
		while (iteradorAtraccion.hasNext()){
			
			Atraccion atraccionTemporal = new Atraccion();
			atraccionTemporal = iteradorAtraccion.next();
			int indice = listaDeAtraccionesContratadas.indexOf(atraccionTemporal);
			int cantidad = cantidadDeEntradas.get(indice);
			
			if (cantidad==4){
				
				// Al costo total se resta el 10% de la atraccion
				this.costoTotal = this.costoTotal - ((atraccionTemporal.getCosto()*10)/100);
				
			}
			
			else if (cantidad>4){
				
				// Al costo total se resta el 10% de la atraccion y un 30% por cada entrada extra
				this.costoTotal = this.costoTotal - ((atraccionTemporal.getCosto()*10)/100) - (((atraccionTemporal.getCosto()*30)/100)*(cantidad-4));
				
			}
			
			
		}
		
		
	}

	// Getters & Setters:
	
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
