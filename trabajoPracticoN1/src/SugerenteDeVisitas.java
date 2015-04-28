import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class SugerenteDeVisitas {

	Atraccion [] vectorDeAtracciones;

	public SugerenteDeVisitas(){};

	public SugerenteDeVisitas(Atraccion[] vectorDeAtracciones) {

		super();
		this.vectorDeAtracciones = vectorDeAtracciones;

	}
	
	public List<Atraccion> ordenarListaPorCosto(List <Atraccion> miLista){

		Collections.sort(miLista, new AtraccionComparator(Atributos.COSTO));
		return miLista;

	}

	public List<Atraccion> ordenarListaPorTiempo(List <Atraccion> miLista){

		Collections.sort(miLista, new AtraccionComparator(Atributos.TIEMPO));
		return miLista;

	}
	
	/* Devuelve true-false si la atraccion cumple con los requisitos para ser sugerida */
	public boolean atraccionSugeridaParaUsuario(Usuario usuario, Atraccion atraccion){


		if (

				atraccion.getTipo() != null	
				&& usuario.getTipoDeAtraccionPreferida().equals(atraccion.getTipo())
				&& usuario.getPresupuesto() > atraccion.getCosto()	
				&& usuario.getTiempoDisponibleParaVisitas() > atraccion.getTiempoNecesarioParaVisita()+usuario.calcularTiempoDeViaje(0, 0, atraccion.getCoordenadaX(), atraccion.getCoordenadaY())

				) 


		{


			return true;

		}

		else if (
				atraccion.getTipo() != null			
				&&  usuario.getPresupuesto() > atraccion.getCosto()	
				&&  usuario.getTiempoDisponibleParaVisitas() > atraccion.getTiempoNecesarioParaVisita()

				)
		{


			return true;

		}

		else {


			return false;

		}


	}

	/* Devuelve una lista con todas las atracciones que cumplen los requisitos para ser sugeridas */
	public List<Atraccion> sugerirVisita(Usuario usuario){

		List<Atraccion> listaDeAtraccionesParaUsuario = new LinkedList<Atraccion>();

		for (int i=0;i<vectorDeAtracciones.length;i++){

			if (atraccionSugeridaParaUsuario(usuario,vectorDeAtracciones[i])){


				listaDeAtraccionesParaUsuario.add(vectorDeAtracciones[i]);


			}


		}

		return listaDeAtraccionesParaUsuario;

	}

	/*Devuelve una lista de atracciones sugeridas por costo, solo elegira las mas baratas y si existe una preferida, no tiene en cuenta ninguna promocion*/
	public List<Atraccion> sugerirItinerarioPorCosto(Usuario miUsuario){

		double presupuestoDisponible=miUsuario.getPresupuesto();
		Atraccion atraccionTemporal=new Atraccion();	
		List<Atraccion> listaDeAtraccionesDisponibles = this.sugerirVisita(miUsuario);
		Iterator<Atraccion> iteradorDeAtracciones = listaDeAtraccionesDisponibles.iterator();
		List<Atraccion> listaDeAtraccionesEnItinerario = new LinkedList<Atraccion>();

		this.ordenarListaPorCosto(listaDeAtraccionesDisponibles);

		//Agrega si existe la atraccion preferida
		while (iteradorDeAtracciones.hasNext()){

			atraccionTemporal=iteradorDeAtracciones.next();


			if(		atraccionTemporal.getTipo().equals(miUsuario.getTipoDeAtraccionPreferida())
					&&  presupuestoDisponible>=atraccionTemporal.getCosto()
					) 

			{


				presupuestoDisponible -= atraccionTemporal.getCosto();
				listaDeAtraccionesEnItinerario.add(atraccionTemporal);


			}	


		}	

		Iterator<Atraccion> iteradorDeAtracciones2 = listaDeAtraccionesDisponibles.iterator();

		//Agrega el resto de las atracciones mas baratas
		while (iteradorDeAtracciones2.hasNext()){

			atraccionTemporal=iteradorDeAtracciones2.next();

			if (presupuestoDisponible>=atraccionTemporal.getCosto() &&
					!(atraccionTemporal.getTipo().equals(miUsuario.getTipoDeAtraccionPreferida()))){
				presupuestoDisponible -= atraccionTemporal.getCosto();
				listaDeAtraccionesEnItinerario.add(atraccionTemporal);
			}

		}


		return listaDeAtraccionesEnItinerario;

	}	


	/* Devuelve una lista de Atracciones que representa un itinerario viajando de atraccion en atraccion de acuerdo a la mas cercana, no tiene en cuenta atracciones preferidas */
	public List<Atraccion> sugerirItinerarioPorMenorDistancia(Usuario miUsuario) {

		double presupuesto = miUsuario.getPresupuesto();
		int tiempoDisponible = miUsuario.getTiempoDisponibleParaVisitas();
		int coordenadaActualX=0;
		int coordenadaActualY=0;
		List<Atraccion> listaDeAtraccionesDisponibles = this.sugerirVisita(miUsuario);
		List<Atraccion> listaDeAtraccionesParaItinerario = new LinkedList<Atraccion>();
		Atraccion atraccionTemporal = miUsuario.buscarAtraccionMasCercana(coordenadaActualX, coordenadaActualY, listaDeAtraccionesDisponibles);
		Atraccion atraccionTemporal2 = new Atraccion();

		while (		presupuesto >= miUsuario.buscarAtraccionMasCercana(coordenadaActualX, coordenadaActualY, listaDeAtraccionesDisponibles).getCosto() 
				&&  tiempoDisponible >= (miUsuario.calcularTiempoDeViaje(coordenadaActualX, coordenadaActualY, atraccionTemporal.getCoordenadaX(), atraccionTemporal.getCoordenadaY()))+atraccionTemporal.getTiempoNecesarioParaVisita()

				)
		{

			atraccionTemporal2 = miUsuario.buscarAtraccionMasCercana(coordenadaActualX, coordenadaActualY, listaDeAtraccionesDisponibles);
			tiempoDisponible -= miUsuario.calcularTiempoDeViaje(coordenadaActualX, coordenadaActualY, atraccionTemporal2.getCoordenadaX(), atraccionTemporal2.getCoordenadaY())+atraccionTemporal.getTiempoNecesarioParaVisita();
			presupuesto -= atraccionTemporal2.getCosto();
			coordenadaActualX = atraccionTemporal2.getCoordenadaX();
			coordenadaActualY = atraccionTemporal2.getCoordenadaY();
			listaDeAtraccionesParaItinerario.add(atraccionTemporal2);
			listaDeAtraccionesDisponibles.remove(listaDeAtraccionesDisponibles.indexOf(atraccionTemporal2));

		}	

		return listaDeAtraccionesParaItinerario;

	}

}
