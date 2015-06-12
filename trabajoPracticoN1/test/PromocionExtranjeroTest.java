import org.junit.Assert;
import org.junit.Test;



public class PromocionExtranjeroTest {

	@Test
	public void calcularDescuentoParaUnUsuarioExtranjero(){
		
		Promocion miPromocion = new PromocionExtranjero(30);
		Paquete miPaquete = new Paquete();
		Usuario usuarioDelPaquete = new Usuario();
		
		Atraccion torre = new Atraccion();
		Atraccion mordor = new Atraccion();
			
		miPaquete.setUsuarioDelPaquete(usuarioDelPaquete);
		
		usuarioDelPaquete.setDireccionX(0);
		usuarioDelPaquete.setDireccionY(0);
				
		torre.setCosto(1000);
		torre.setCoordenadaX(800);
		torre.setCoordenadaY(900);

		mordor.setCosto(500);
		mordor.setCoordenadaX(500);
		mordor.setCoordenadaY(1000);

		miPaquete.comprarEntrada(torre);
		miPaquete.comprarEntrada(mordor);
		
		miPaquete.calcularCostoTotalDelPaquete(miPaquete.getListaDeAtraccionesContratadas(), miPaquete.getCantidadDeEntradas());

		//Calculo el descuento
		Assert.assertTrue(miPromocion.calcularDescuento(miPaquete) == (double) 750);
		
	}
	
	@Test
	public void calcularDescuentoParaUnUsuarioNoExtranjeroElDescuentoDebeDarCero(){
		
		Promocion miPromocion = new PromocionExtranjero(30);
		Paquete miPaquete = new Paquete();
		Usuario usuarioDelPaquete = new Usuario();
		
		Atraccion torre = new Atraccion();
		Atraccion mordor = new Atraccion();
			
		miPaquete.setUsuarioDelPaquete(usuarioDelPaquete);
		
		usuarioDelPaquete.setDireccionX(0);
		usuarioDelPaquete.setDireccionY(0);
				
		torre.setCosto(1000);
		torre.setCoordenadaX(10);
		torre.setCoordenadaY(100);

		mordor.setCosto(500);
		mordor.setCoordenadaX(20);
		mordor.setCoordenadaY(20);

		miPaquete.comprarEntrada(torre);
		miPaquete.comprarEntrada(mordor);
		
		miPaquete.calcularCostoTotalDelPaquete(miPaquete.getListaDeAtraccionesContratadas(), miPaquete.getCantidadDeEntradas());

		//Calculo el descuento
		Assert.assertTrue(miPromocion.calcularDescuento(miPaquete) == (double) 0);
		
	}
	
}
