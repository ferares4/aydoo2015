import org.junit.Assert;
import org.junit.Test;


public class PromocionAxBTest {

	@Test
	public void creaUnaNuevaPromocionYLeAsignaAtracciones(){
		
		Promocion miPromocion = new PromocionAxB(30);
		
		Atraccion atraccion1 = new Atraccion();
		Atraccion atraccion2 = new Atraccion();
		
		miPromocion.addAtraccion(atraccion1);
		miPromocion.addAtraccion(atraccion2);
		
		Assert.assertTrue(miPromocion.getListaDeAtracciones().contains(atraccion1));
		Assert.assertTrue(miPromocion.getListaDeAtracciones().contains(atraccion2));
		
		
	}
	
	@Test
	public void calcularDescuentoAxB(){
		
		Promocion miPromocion = new PromocionAxB(30);
		Paquete miPaquete = new Paquete();

		miPaquete.agregarPromocionDisponible(miPromocion);
		
		Atraccion torre = new Atraccion();
		Atraccion mordor = new Atraccion();
		Atraccion gondor = new Atraccion();
		Atraccion laComarca = new Atraccion();
		
		torre.setCosto(1000);
		mordor.setCosto(500);
		gondor.setCosto(700);
		laComarca.setCosto(300);
		
		miPromocion.addAtraccion(torre);
		miPromocion.addAtraccion(mordor);
		miPromocion.addAtraccion(gondor);
		miPromocion.addAtraccion(laComarca);
		
		miPaquete.comprarEntrada(torre);
		miPaquete.comprarEntrada(mordor);
		miPaquete.comprarEntrada(gondor);
		miPaquete.comprarEntrada(laComarca);
		miPaquete.comprarEntrada(laComarca);
		miPaquete.comprarEntrada(laComarca);
		miPaquete.comprarEntrada(laComarca);
		
		Assert.assertTrue(miPromocion.calcularDescuento(miPaquete) == (double) 1200);
		
	}
	
}
