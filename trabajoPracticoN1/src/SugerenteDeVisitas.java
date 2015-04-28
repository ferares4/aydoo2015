import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class SugerenteDeVisitas {
	
	//Usuario usuario;
	Paquete paqueteFinal;
	Atraccion [] vectorDeAtracciones;
	Promocion [] vectorDePromociones;
	
	
	
	public SugerenteDeVisitas(Atraccion[] vectorDeAtracciones, Promocion[] vectorDePromociones) {
		super();
		//this.usuario = usuario;
		this.vectorDeAtracciones = vectorDeAtracciones;
		this.vectorDePromociones = vectorDePromociones;
	
	}
	
	//Devuelve true-false si la atraccion cumple con los requisitos para ser sugerida
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
	//Devuelve una lista con todas las atracciones que cumplen los requisitos para ser sugeridas
	public List<Atraccion> sugerirVisita(Usuario usuario){
			
		List<Atraccion> listaDeAtraccionesParaUsuario = new LinkedList<Atraccion>();
		
		for (int i=0;i<vectorDeAtracciones.length;i++){
			
			// Tiene Promocion()?? Cual??? Aplicar descuento: vectorDeAtracciones[i].setCosto(vectorDeAtracciones[i].getCosto()*  PORCENTAJE)
			
			if (atraccionSugeridaParaUsuario(usuario,vectorDeAtracciones[i])){
				

							listaDeAtraccionesParaUsuario.add(vectorDeAtracciones[i]);

				
			}
			
			
		}
		
		return listaDeAtraccionesParaUsuario;
		
	}
	
	
	public Promocion buscarAtraccionEnPromocionesVigentes(Atraccion atraccion){
		
		if (vectorDePromociones != null){
			
			for(int i=0;i<vectorDePromociones.length;i++){
				
				if (vectorDePromociones[i].getListaDeAtracciones().contains(atraccion)){
					
					return vectorDePromociones[i];
					
				}
				
				else {
					
					i++;
					
				}
				
			}
			
			
			
		}
		
		
		return null;
	}
	
	/*Devuelve una lista de atracciones sugeridas por costo, solo elegira las mas baratas y si existe una preferida*/
	public List<Atraccion> sugerirItinerarioPorCosto(Usuario miUsuario){
		
		double presupuestoDisponible=miUsuario.getPresupuesto();
		Atraccion atraccionTemporal=new Atraccion();	
		List<Atraccion> listaDeAtraccionesDisponibles = this.sugerirVisita(miUsuario);
		Iterator<Atraccion> iteradorDeAtracciones = listaDeAtraccionesDisponibles.iterator();
		List<Atraccion> listaDeAtraccionesEnItinerario = new LinkedList<Atraccion>();
		
		//Por menor precio (que incluya promociones)
		
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
		
		

	
	public List<Atraccion> ordenarListaPorCosto(List <Atraccion> miLista){
		
		Collections.sort(miLista, new AtraccionComparator(Atributos.COSTO));
		return miLista;
		
	}
	
	public List<Atraccion> ordenarListaPorTiempo(List <Atraccion> miLista){
		
		Collections.sort(miLista, new AtraccionComparator(Atributos.TIEMPO));
		return miLista;
		
	}
	 	
	/*
	public List<Atraccion> sugerirItinerarioPorTiempo(Usuario miUsuario){
		
		int tiempoDisponible = miUsuario.getTiempoDisponibleParaVisitas();
		Atraccion atraccionTemporal=new Atraccion();
		List<Atraccion> listaDeAtraccionesDisponibles = this.sugerirVisita(miUsuario);
		Iterator<Atraccion> iteradorDeAtracciones = listaDeAtraccionesDisponibles.iterator();
		List<Atraccion> listaDeAtraccionesEnItinerario = new LinkedList<Atraccion>();
		
		this.ordenarListaPorTiempo(listaDeAtraccionesDisponibles);

		//Agrega si existe la atraccion preferida
		while (iteradorDeAtracciones.hasNext()){
			
			atraccionTemporal=iteradorDeAtracciones.next();
			
						
			if(		(atraccionTemporal.getTipo().equals(miUsuario.getTipoDeAtraccionPreferida())
				&&  (tiempoDisponible>=atraccionTemporal.getTiempoNecesarioParaVisita()))
			  ) {
				
				tiempoDisponible -= atraccionTemporal.getTiempoNecesarioParaVisita();
				listaDeAtraccionesEnItinerario.add(atraccionTemporal);
				
				
			}	
			
			
		}
		
		Iterator<Atraccion> iteradorDeAtracciones2 = listaDeAtraccionesDisponibles.iterator();
		
		//Agrega el resto de las atracciones con menor tiempo
		while (iteradorDeAtracciones2.hasNext()){
			
			atraccionTemporal=iteradorDeAtracciones2.next();
			
			if (tiempoDisponible>=atraccionTemporal.getTiempoNecesarioParaVisita() &&
					!(atraccionTemporal.getTipo().equals(miUsuario.getTipoDeAtraccionPreferida()))){
				tiempoDisponible -= atraccionTemporal.getTiempoNecesarioParaVisita();
			listaDeAtraccionesEnItinerario.add(atraccionTemporal);
			}
			
		}
		
		return listaDeAtraccionesEnItinerario;
		
	}
	
	
	public tipoDePromocion validarPromociones(Atraccion atraccion){
		
		for (int i=0;i<vectorDePromociones.length;i++){
			
			if (vectorDePromociones[i].tienePromocion(atraccion)){
				
				return vectorDePromociones[i].getTipo();
				
			}
			
		}
		
	}
	
	*/
	
	
}
