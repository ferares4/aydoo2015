import java.util.LinkedList;
import java.util.List;


public class SugerenteDeVisitas {
	
	Usuario usuario;
	Paquete paqueteFinal;
	Atraccion [] vectorDeAtracciones;
	Promocion [] vectorDePromociones;
	
	
	
	public SugerenteDeVisitas(Usuario usuario, Atraccion[] vectorDeAtracciones,
			Promocion[] vectorDePromociones) {
		super();
		this.usuario = usuario;
		this.vectorDeAtracciones = vectorDeAtracciones;
		this.vectorDePromociones = vectorDePromociones;
	
	}

	public List<Atraccion> sugerirVisita(){
		
			
		List<Atraccion> listaDeAtraccionesParaUsuario = new LinkedList<Atraccion>();
		
		for (int i=0;i<vectorDeAtracciones.length;i++){
			
			if (atraccionSugeridaParaUsuario(usuario,vectorDeAtracciones[i])){
				
				listaDeAtraccionesParaUsuario.add(vectorDeAtracciones[i]);
				
			}
			
			
		}
		
		return listaDeAtraccionesParaUsuario;
		
	}
	
	public boolean atraccionSugeridaParaUsuario(Usuario usuario, Atraccion atraccion){
		
		
				if (
			
						atraccion.getTipo() != null	
						&& usuario.getTipoDeAtraccionPreferida().equals(atraccion.getTipo())
						&& usuario.getPresupuesto() > atraccion.getCosto()	
						&& usuario.getTiempoDisponibleParaVisitasEnMinutos() > atraccion.getTiempoNecesarioParaVisitaEnMinutos()
			
					) 
		
		
					{
			
						return true;
			
					}
		
				else if (
								atraccion.getTipo() != null			
								&&  usuario.getPresupuesto() > atraccion.getCosto()	
								&&  usuario.getTiempoDisponibleParaVisitasEnMinutos() > atraccion.getTiempoNecesarioParaVisitaEnMinutos()
					
						)
				{
			
			
					return true;
			
				}
		
				else {
			
				
					return false;
		
				}
		
		
	}
	
	
	/*
	public boolean validarPromocionesVigentes(){
		
		return !(vectorDePromociones == null);
				
	}
	
	
	public void aplicarPromocion(Atraccion atraccion){
		
		switch (nombre){
		
		// 10% de descuento sobre el costo de la atraccion
		case "Promocion Porcentual": paqueteFinal.setCostoTotal((atraccion.getCosto()*90)/100);
		break;
			
		default: return paqueteFinal;
		
		
		}
		

				
	}
		
	
	public void aplicarPromocion(Atraccion [] atracciones){
			
			switch (nombre){
			
			// 20% de descuento sobre el costo total de todas las atracciones
			case "Promocion por Paquete": 
				
				for (int i=0; i<atracciones.length;i++){
					
					paqueteFinal.setCostoTotal(paqueteFinal.getCostoTotal()+atracciones[i].getCosto());
				
				}
				
				paqueteFinal.setCostoTotal((paqueteFinal.getCostoTotal()*80)/100);
			
			break;
			
			// Si el numero de atracciones a contratar es mayor a 4 entonces reintegra la mas barata
			case "Promocion A x B":
				
				//implementar
				
				
			break;
			
			
			default: return paqueteFinal;
			
			
			}		
		
		
		
	}
	*/
	
	
}
