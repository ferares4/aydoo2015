import org.junit.Assert;
import org.junit.Test;


public class PromocionAbsolutaTest {

	@Test
	public void creaUnaNuevaPromocionYLeAsignaAtracciones(){
		
		Promocion miPromocion = new PromocionAbsoluta(30, (double) 300);
		
		Atraccion atraccion1 = new Atraccion();
		Atraccion atraccion2 = new Atraccion();
		
		miPromocion.addAtraccion(atraccion1);
		miPromocion.addAtraccion(atraccion2);
		
		Assert.assertTrue(miPromocion.getListaDeAtracciones().contains(atraccion1));
		Assert.assertTrue(miPromocion.getListaDeAtracciones().contains(atraccion2));
		
		
	}
	
	@Test
	public void creaUnaNuevaPromocionYCalculaElDescuentoDeUnPaquete(){
		
		PromocionAbsoluta miPromocion = new PromocionAbsoluta(30, (double) 300);
		Assert.assertEquals(300,0, miPromocion.calcularDescuento(new Paquete()));
		
	}
	
	
}