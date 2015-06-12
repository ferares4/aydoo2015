import org.junit.Assert;
import org.junit.Test;


public class PromocionTest {

	@Test
	public void creaUnaNuevaPromocionYLeAsignaAtracciones(){
		
		Promocion miPromocion = new Promocion(30);
		
		Atraccion atraccion1 = new Atraccion();
		Atraccion atraccion2 = new Atraccion();
		
		miPromocion.addAtraccion(atraccion1);
		miPromocion.addAtraccion(atraccion2);
		
		Assert.assertTrue(miPromocion.getListaDeAtracciones().contains(atraccion1));
		Assert.assertTrue(miPromocion.getListaDeAtracciones().contains(atraccion2));
		
		
	}
	
	@Test
	public void calcularDescuentoDebeDevolverSiempreCero(){
		
		
		Promocion miPromocion = new Promocion(30);
		Assert.assertEquals(0,0, miPromocion.calcularDescuento(new Paquete()));
		
		
	}
	
		
}
