import org.junit.Assert;
import org.junit.Test;


public class PaqueteTest {
	
	@Test 
	public void crearUnPaqueteYCargarPromocionesDisponibles(){
		
		Paquete miPaquete = new Paquete();
		Assert.assertEquals(0,0,miPaquete.getCostoTotal());
		
		miPaquete.calcularCostoTotalDelPaquete(miPaquete.getListaDeAtraccionesContratadas(), miPaquete.getCantidadDeEntradas());
		Assert.assertEquals(0,0,miPaquete.getCostoTotal());
		
		Promocion promocionPorcentual = new PromocionPorcentual(30, 10);
		Promocion promocionAbsoluta = new PromocionAbsoluta(30, (double) 200);
		Promocion promocionFamiliar = new PromocionFamiliar(30);
		Promocion promocionExtranjero = new PromocionExtranjero(30);
		Promocion promocionAxB = new PromocionAxB(30);
		
		miPaquete.agregarPromocionDisponible(promocionPorcentual);
		miPaquete.agregarPromocionDisponible(promocionAbsoluta);
		miPaquete.agregarPromocionDisponible(promocionFamiliar);
		miPaquete.agregarPromocionDisponible(promocionExtranjero);
		miPaquete.agregarPromocionDisponible(promocionAxB);
		
		Assert.assertTrue(miPaquete.getListaDePromocionesDisponibles().contains(promocionPorcentual));
		Assert.assertTrue(miPaquete.getListaDePromocionesDisponibles().contains(promocionAbsoluta));
		Assert.assertTrue(miPaquete.getListaDePromocionesDisponibles().contains(promocionFamiliar));
		Assert.assertTrue(miPaquete.getListaDePromocionesDisponibles().contains(promocionExtranjero));
		Assert.assertTrue(miPaquete.getListaDePromocionesDisponibles().contains(promocionAxB));
		Assert.assertEquals(5, miPaquete.getListaDePromocionesDisponibles().size());
		
	}
	
	@Test
	public void comprarEntradasParaVariasAtracciones(){

		InicialidazorDeTests miInicializador = new InicialidazorDeTests();
		Paquete miPaquete = miInicializador.getPaquete();
		
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[0]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[0]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[0]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[1]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[2]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[2]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[2]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[2]);
		
		//Compruebo que el paquete guardo en su lista de atracciones contratadas todas las atraciones donde compre entradas
		Assert.assertTrue(miPaquete.getListaDeAtraccionesContratadas().contains(miInicializador.vectorDeAtracciones[0]));
		Assert.assertTrue(miPaquete.getListaDeAtraccionesContratadas().contains(miInicializador.vectorDeAtracciones[1]));
		Assert.assertTrue(miPaquete.getListaDeAtraccionesContratadas().contains(miInicializador.vectorDeAtracciones[2]));
		Assert.assertEquals(miInicializador.vectorDeAtracciones[0], miPaquete.getListaDeAtraccionesContratadas().get(0));
		
		//Compruebo la cantidad de entradas
		Assert.assertEquals(3, (int) miPaquete.getCantidadDeEntradas().get(miPaquete.getListaDeAtraccionesContratadas().indexOf(miInicializador.vectorDeAtracciones[0])));
		Assert.assertEquals(1, (int) miPaquete.getCantidadDeEntradas().get(miPaquete.getListaDeAtraccionesContratadas().indexOf(miInicializador.vectorDeAtracciones[1])));
		Assert.assertEquals(4, (int) miPaquete.getCantidadDeEntradas().get(miPaquete.getListaDeAtraccionesContratadas().indexOf(miInicializador.vectorDeAtracciones[2])));

	}

	@Test
	public void calcularCostoDePaqueteConTodasLasPromocionesMenosPromocionExtranjero(){

		InicialidazorDeTests miInicializador = new InicialidazorDeTests();
		Paquete miPaquete = miInicializador.getPaquete();
		
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[0]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[0]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[0]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[1]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[1]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[2]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[2]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[2]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[2]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[2]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[2]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[4]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[4]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[5]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[5]);
		
		miPaquete.calcularCostoTotalDelPaquete(miPaquete.getListaDeAtraccionesContratadas(), miPaquete.getCantidadDeEntradas());
				
		//Corrobora que el costo total del paquete sin promociones sea el esperado
		Assert.assertTrue(miPaquete.getCostoTotal() == (double) 13300);

		//Remuevo la Promocion Extranjero para que no aplique
		miPaquete.getListaDePromocionesDisponibles().remove(4);
		
		/* Para el itinerario esperado y los paquetes asignados el precio total deberia dar:
		 * 
		 * Costo total inicial = 13300
		 * Descuento por promocion porcentual = 13300 * 10% = 1330
		 * Descuento por promocion Absoluta = 200
		 * Descuento por promocion AxB, la mas barata es Mordor 450, se compraron 2 entradas = 900
		 * Descuento por promocion Familiar (Al descuento se agrega el 10% del valor de la atraccion y un 30% por cada entrada extra)
		 * Son 6 entradas corresponde, un 10% del valor de la 4ta entrada mas un 30% por cada entrada extra (2) = (700*10%) + (700*30%)*2 = 490
		 * 
		 * Costo total Final = 13300 - (1330 + 200 + 900 + 490) = 9160
		 */
		
		miPaquete.ajustarCostoEnBaseAPromociones();
		
		//Corrobora que la promocion Familiar se aplique correctamente
		Assert.assertTrue(miPaquete.getCostoTotal() == (double) 10380);
		
	}
	
	@Test
	public void calcularCostoDePaqueteConTodasLasPromocionesDebeAplicarSoloPromocionExtranjero(){

		InicialidazorDeTests miInicializador = new InicialidazorDeTests();
		Paquete miPaquete = miInicializador.getPaquete();
		
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[0]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[0]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[0]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[1]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[1]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[2]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[2]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[2]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[2]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[2]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[2]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[4]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[4]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[5]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[5]);
		
		miPaquete.calcularCostoTotalDelPaquete(miPaquete.getListaDeAtraccionesContratadas(), miPaquete.getCantidadDeEntradas());
				
		//Corrobora que el costo total del paquete sin promociones sea el esperado
		Assert.assertTrue(miPaquete.getCostoTotal() == (double) 13300);	
		
		/* Para el itinerario esperado y los paquetes asignados el precio total deberia dar:
		 * 
		 * Costo total inicial = 13300
		 * Descuento por promocion extranjero = 13300 / 2 =  6650
		 * Costo total Final = 13300 - 6650 = 6650
		 */
		
		miPaquete.ajustarCostoEnBaseAPromociones();
		
		//Corrobora que la promocion Familiar se aplique correctamente
		Assert.assertTrue(miPaquete.getCostoTotal() == (double) 6650);
		
	}
	
	@Test
	public void calcularCostoDePaqueteConPromocionesVencidasDebeExcluirLosDescuentosQueNoAplica(){

		InicialidazorDeTests miInicializador = new InicialidazorDeTests();
		Paquete miPaquete = miInicializador.getPaquete();
		
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[0]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[0]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[0]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[1]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[1]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[2]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[2]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[2]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[2]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[2]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[2]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[4]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[4]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[5]);
		miPaquete.comprarEntrada(miInicializador.vectorDeAtracciones[5]);
		
		miPaquete.calcularCostoTotalDelPaquete(miPaquete.getListaDeAtraccionesContratadas(), miPaquete.getCantidadDeEntradas());
				
		//Corrobora que el costo total del paquete sin promociones sea el esperado
		Assert.assertTrue(miPaquete.getCostoTotal() == (double) 13300);
		
		//Remuevo la Promocion Extranjero para que no aplique
		miPaquete.getListaDePromocionesDisponibles().remove(4);
		
		//Fuerzo a vencer el periodo de vigencia para Promocion Absoluta
		miPaquete.getListaDePromocionesDisponibles().get(1).setPeriodoDeVigenciaEnDias(0);
		//Fuerzo a vencer el periodo de vigencia para Promocion Familiar
		miPaquete.getListaDePromocionesDisponibles().get(3).setPeriodoDeVigenciaEnDias(0);

		
		/* Para el itinerario esperado y los paquetes asignados el precio total deberia dar:
		 * 
		 * Costo total inicial = 13300
		 * Descuento por promocion porcentual = 13300 * 10% = 1330
		 * Descuento por promocion AxB, la mas barata es Mordor 450, se compraron 2 entradas = 900
		 * Costo total Final = 13300 - (1330 + 900) = 11070
		 */
		
		miPaquete.ajustarCostoEnBaseAPromociones();
		
		//Corrobora que la promocion Familiar se aplique correctamente
		Assert.assertTrue(miPaquete.getCostoTotal() == (double) 11070);
		
	}
	
	
	
}
