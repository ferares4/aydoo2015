import java.util.Iterator;
import java.util.List;


public class Paquete {
	
	private double costoTotal=0;

	/* Calcula el costo total de un itinerario sin tener en cuenta las promociones */
	public void calcularCostoTotal(List<Atraccion> itinerario){
		

		Iterator<Atraccion> iterador = itinerario.iterator();
		while (iterador.hasNext()){
		
			costoTotal += iterador.next().getCosto(); 
		
		}
		
		
	}
	
	/* Ajusta el costo total de un paquete teniendo en cuenta las promociones, se debe haber calculado previamente el costo total */
	public void calcularCostoEnBaseAPromociones(List<Atraccion> itinerario, Promocion[] vectorDePromociones){

		if (costoTotal!=0) {

			this.calcularCostoTotal(itinerario);

			//Chequea y descuenta todas las promocines porcentuales
			Iterator<Atraccion> iterador = itinerario.iterator();

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

			//Chequea y descuenta si todas las atracciones del itinerario tienen una promocion por paquete
			for (int i=0;i<vectorDePromociones.length;i++){

				if (vectorDePromociones[i].getTipo().equals(tipoDePromocion.PROMOCION_POR_PAQUETE) && vectorDePromociones[i].getPeriodoDeVigenciaEnDias()>0){

					if (vectorDePromociones[i].getListaDeAtracciones().containsAll(itinerario)){

						this.costoTotal = costoTotal-((costoTotal*15)/100);

					}

				}

			}

			//Chequea si todas las promocines del itinerario tienen promocion AxV luego descuenta la mas barata
			for (int i=0;i<vectorDePromociones.length;i++){

				if (vectorDePromociones[i].getTipo().equals(tipoDePromocion.PROMOCIONAXB) && vectorDePromociones[i].getPeriodoDeVigenciaEnDias()>0){

					if (vectorDePromociones[i].getListaDeAtracciones().containsAll(itinerario)){

						while(iterador.hasNext()){

							List<Atraccion> listaXCosto = new SugerenteDeVisitas().ordenarListaPorCosto(itinerario);
							costoTotal -= listaXCosto.get(0).getCosto();

						}

					}

				}

			}

		}
		
		else { System.out.println ("Error: No existe un costo total previo");}

	}
	
	// Getters & Setters:
	
	public double getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(double costoTotal) {
		this.costoTotal = costoTotal;
	}

}
