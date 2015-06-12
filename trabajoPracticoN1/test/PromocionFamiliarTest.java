import org.junit.Assert;
import org.junit.Test;


public class PromocionFamiliarTest {

	@Test
	public void calcularDescuentoParaUnPaqueteQueIncluyeCuatroEntradasParaLaMismaAtraccion(){
		
		Paquete miPaquete = new Paquete();
		Promocion miPromocion = new PromocionFamiliar(20);
		
		Atraccion laComarca = new Atraccion();
		laComarca.setCosto(1000);
		
		miPaquete.agregarPromocionDisponible(miPromocion);
		
		//Se adquieren 9 entradas para la misma atraccion
		miPaquete.comprarEntrada(laComarca);
		miPaquete.comprarEntrada(laComarca);
		miPaquete.comprarEntrada(laComarca);
		miPaquete.comprarEntrada(laComarca);
		
		miPaquete.calcularCostoTotalDelPaquete(miPaquete.getListaDeAtraccionesContratadas(), miPaquete.getCantidadDeEntradas());
		
		/*
		 * Valor del paquete sin descuento = 1000 * 9 = 9000
		 * Descuento = (1000 * 10%) = 100
		 */
		
		Assert.assertTrue(miPromocion.calcularDescuento(miPaquete) == (double) 100);
		
	}
	
	@Test
	public void calcularDescuentoParaUnPaqueteQueIncluyeMasDeCuatroEntradasParaLaMismaAtraccion(){
		
		Paquete miPaquete = new Paquete();
		Promocion miPromocion = new PromocionFamiliar(20);
		
		Atraccion laComarca = new Atraccion();
		laComarca.setCosto(1000);
		
		miPaquete.agregarPromocionDisponible(miPromocion);
		
		//Se adquieren 9 entradas para la misma atraccion
		miPaquete.comprarEntrada(laComarca);
		miPaquete.comprarEntrada(laComarca);
		miPaquete.comprarEntrada(laComarca);
		miPaquete.comprarEntrada(laComarca);
		miPaquete.comprarEntrada(laComarca);
		miPaquete.comprarEntrada(laComarca);
		miPaquete.comprarEntrada(laComarca);
		miPaquete.comprarEntrada(laComarca);
		miPaquete.comprarEntrada(laComarca);
		
		miPaquete.calcularCostoTotalDelPaquete(miPaquete.getListaDeAtraccionesContratadas(), miPaquete.getCantidadDeEntradas());
		
		/*
		 * Valor del paquete sin descuento = 1000 * 9 = 9000
		 * Descuento = (1000 * 10%) + (1000 * 30%) * 5 = 1500
		 */
		
		Assert.assertTrue(miPromocion.calcularDescuento(miPaquete) == (double) 1600);
		
	}
	
}
