import java.util.Iterator;


public class PromocionFamiliar extends Promocion{

	public PromocionFamiliar(int periodo) {
		super(periodo);
		// TODO Auto-generated constructor stub
	}

	public double calcularDescuento(Paquete paquete){
		
		double descuento=0;
		Iterator<Atraccion> iteradorAtraccion = paquete.getListaDeAtraccionesContratadas().iterator();
				
		while (iteradorAtraccion.hasNext()){
			
			Atraccion atraccionTemporal = new Atraccion();
			atraccionTemporal = iteradorAtraccion.next();
			int indice = paquete.getListaDeAtraccionesContratadas().indexOf(atraccionTemporal);
			int cantidad = paquete.getCantidadDeEntradas().get(indice);
			
			if (cantidad==4){
				
				// Al descuento se agrega el 10% del valor de la atraccion
				descuento += ((atraccionTemporal.getCosto()*10)/100);
				
			}
			
			else if (cantidad>4){
				
				// Al descuento se agrega el 10% del valor de la atraccion y un 30% por cada entrada extra
				descuento += ((atraccionTemporal.getCosto()*10)/100);
				
				descuento += (((atraccionTemporal.getCosto()*30)/100)*(cantidad-4));
				
			}
			
			
		}

		return descuento;
		
	}
	
}
