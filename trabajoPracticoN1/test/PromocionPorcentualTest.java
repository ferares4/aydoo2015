import org.junit.Assert;
import org.junit.Test;


public class PromocionPorcentualTest {

	@Test
	public void calcularDescuentoDebeCalcularElCuarentaPorcientoDelTotal(){
		
		Promocion miPromocion = new PromocionPorcentual(30, 40);
		Paquete miPaquete = new Paquete();
		
		miPaquete.agregarPromocionDisponible(miPromocion);
		
		Atraccion gondor = new Atraccion();
		gondor.setCosto(1000);
		
		// Compro 10 entradas de la misma atraccion
		miPaquete.comprarEntrada(gondor);
		miPaquete.comprarEntrada(gondor);
		miPaquete.comprarEntrada(gondor);
		miPaquete.comprarEntrada(gondor);
		miPaquete.comprarEntrada(gondor);
		miPaquete.comprarEntrada(gondor);
		miPaquete.comprarEntrada(gondor);
		miPaquete.comprarEntrada(gondor);
		miPaquete.comprarEntrada(gondor);
		miPaquete.comprarEntrada(gondor);
		
		miPaquete.calcularCostoTotalDelPaquete(miPaquete.getListaDeAtraccionesContratadas(), miPaquete.getCantidadDeEntradas());
		
		Assert.assertTrue(miPromocion.calcularDescuento(miPaquete) == (double) 4000);
		
	}
	
	@Test
	public void calcularDescuentoCambiandoElProcentajeDeDescuento(){
		
		PromocionPorcentual miPromocion = new PromocionPorcentual(30, 40);
		Paquete miPaquete = new Paquete();
		
		miPaquete.agregarPromocionDisponible(miPromocion);
		
		Atraccion gondor = new Atraccion();
		gondor.setCosto(1000);
		
		// Compro 10 entradas de la misma atraccion
		miPaquete.comprarEntrada(gondor);
		miPaquete.comprarEntrada(gondor);
		miPaquete.comprarEntrada(gondor);
		miPaquete.comprarEntrada(gondor);
		miPaquete.comprarEntrada(gondor);
		miPaquete.comprarEntrada(gondor);
		miPaquete.comprarEntrada(gondor);
		miPaquete.comprarEntrada(gondor);
		miPaquete.comprarEntrada(gondor);
		miPaquete.comprarEntrada(gondor);
		
		miPaquete.calcularCostoTotalDelPaquete(miPaquete.getListaDeAtraccionesContratadas(), miPaquete.getCantidadDeEntradas());
		
		Assert.assertTrue(miPromocion.calcularDescuento(miPaquete) == (double) 4000);
		
		miPromocion.setPorcentaje(20);
		
		Assert.assertTrue(miPromocion.calcularDescuento(miPaquete) == (double) 2000);
		
	}

	
}
