import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class PaqueteTest {

	@Test
	public void calcularCostoDePaqueteUsandoPromociones(){
		
		//Configuracion de Usuario de Prueba
		Usuario miUsuario = new Usuario();
		miUsuario.setDireccionX(0);
		miUsuario.setDireccionY(0);
		miUsuario.setTipoDeAtraccionPreferida("Gondor");
		miUsuario.setPresupuesto(4000);
		miUsuario.setTiempoDisponibleParaVisitas(168);
		miUsuario.setVelocidadDeTraslado(10);
		miUsuario.setDireccionX(0);
		miUsuario.setDireccionY(0);

				
		Atraccion[] vectorDeAtracciones = new Atraccion[]{new Atraccion(), new Atraccion(), new Atraccion(), new Atraccion(), new Atraccion(),new Atraccion(),new Atraccion()};
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[0].setTipo("Gondor");
		vectorDeAtracciones[0].setCosto(1200);
		vectorDeAtracciones[0].setTiempoNecesarioParaVisita(10);
		vectorDeAtracciones[0].setCoordenadaX(10);
		vectorDeAtracciones[0].setCoordenadaY(15);
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[1].setTipo("Mordor");
		vectorDeAtracciones[1].setCosto(450);
		vectorDeAtracciones[1].setTiempoNecesarioParaVisita(20);
		vectorDeAtracciones[1].setCoordenadaX(20);
		vectorDeAtracciones[1].setCoordenadaY(30);
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[2].setTipo("La Comarca");
		vectorDeAtracciones[2].setCosto(700);
		vectorDeAtracciones[2].setTiempoNecesarioParaVisita(40);
		vectorDeAtracciones[2].setCoordenadaX(35);
		vectorDeAtracciones[2].setCoordenadaY(10);
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[3].setTipo("Bosque Encantado");
		vectorDeAtracciones[3].setCosto(700);
		vectorDeAtracciones[3].setTiempoNecesarioParaVisita(5);
		vectorDeAtracciones[3].setCoordenadaX(40);
		vectorDeAtracciones[3].setCoordenadaY(20);
		
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[4].setTipo("Paseo de Aventura");
		vectorDeAtracciones[4].setCosto(800);
		vectorDeAtracciones[4].setTiempoNecesarioParaVisita(30);
		vectorDeAtracciones[4].setCoordenadaX(40);
		vectorDeAtracciones[4].setCoordenadaY(40);
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[5].setTipo("Minas Tirith");
		vectorDeAtracciones[5].setCosto(1500);
		vectorDeAtracciones[5].setTiempoNecesarioParaVisita(10);
		vectorDeAtracciones[5].setCoordenadaX(60);
		vectorDeAtracciones[5].setCoordenadaY(35);
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[6].setTipo("Torre");
		vectorDeAtracciones[6].setCosto(350);
		vectorDeAtracciones[6].setTiempoNecesarioParaVisita(15);
		vectorDeAtracciones[6].setCoordenadaX(60);
		vectorDeAtracciones[6].setCoordenadaY(20);
		
		Promocion promocionPorPorcentaje = new Promocion(tipoDePromocion.PROMOCION_PORCENTUAL, 30);
		Promocion promocionPorPaquete = new Promocion(tipoDePromocion.PROMOCION_POR_PAQUETE, 30);
		Promocion promocionAXB = new Promocion(tipoDePromocion.PROMOCIONAXB, 30);
		
		//Agrego 1 atraccion al tipo Promocion por porcentaje
		promocionPorPorcentaje.addAtraccion(vectorDeAtracciones[0]);
		
		//Agrego varias atracciones al tipo de Promo Promocion x Paquete
		promocionPorPaquete.addAtraccion(vectorDeAtracciones[1]);
		promocionPorPaquete.addAtraccion(vectorDeAtracciones[4]);
		promocionPorPaquete.addAtraccion(vectorDeAtracciones[5]);
		
		//Agrego 4 atracciones al tipo AxB
		promocionAXB.addAtraccion(vectorDeAtracciones[0]);
		promocionAXB.addAtraccion(vectorDeAtracciones[1]);
		promocionAXB.addAtraccion(vectorDeAtracciones[4]);
		promocionAXB.addAtraccion(vectorDeAtracciones[5]);
		
		SugerenteDeVisitas miSugerente = new SugerenteDeVisitas(vectorDeAtracciones); 
		List<Atraccion> itinerario = miSugerente.sugerirItinerarioPorMenorDistancia(miUsuario);
		
		//corroboro que las promociones aplicadas devuelven resultados esperados
		Assert.assertTrue(promocionPorPorcentaje.getListaDeAtracciones().contains(vectorDeAtracciones[0]));
		Assert.assertFalse(promocionPorPaquete.getListaDeAtracciones().containsAll(itinerario));
		Assert.assertTrue(promocionAXB.getListaDeAtracciones().containsAll(itinerario));
		
		Paquete paquete = new Paquete();
		paquete.setUsuarioDelPaquete(miUsuario);
		
		//Compro 1 entrada de cada Atraccion
		paquete.comprarEntrada(vectorDeAtracciones[0]);
		paquete.comprarEntrada(vectorDeAtracciones[1]);
		paquete.comprarEntrada(vectorDeAtracciones[2]);
		paquete.comprarEntrada(vectorDeAtracciones[3]);
		paquete.comprarEntrada(vectorDeAtracciones[4]);
		paquete.comprarEntrada(vectorDeAtracciones[5]);
		paquete.comprarEntrada(vectorDeAtracciones[5]);
		

		/*Para el itinerario esperado y los paquetes asignados el precio total deberia dar:
		 * 
		 * Costo total inicial = 3950,0
		 * Gondor tiene promo porcentual 10% > Costo total 3950,0 - (1200 *10%) = 3830,0
		 * Mordor, Paseo y Minas tiene promo por paquete 15% sobre el total > Costo total = 3830,0 - (3830,0*15%) = 3255,5
		 * Gondor, Mordor, Paseo y Minas tienen promo AxB, debe descontar la mas barata (Mordor) > Costo total = 3255,5 - 450 = 2805,5
		 * 
		 */
		paquete.calcularCostoEnBaseAPromociones(new Promocion[]{promocionPorPorcentaje,promocionPorPaquete,promocionAXB});
		Assert.assertEquals(2805,5, paquete.getCostoTotal());
		
	}
	
	@Test
	public void calcularCostoDePaqueteConPromocionExtranjero(){
		
		//Configuracion de Usuario de Prueba
		Usuario miUsuario = new Usuario();
		miUsuario.setTipoDeAtraccionPreferida("Gondor");
		miUsuario.setPresupuesto(4000);
		miUsuario.setTiempoDisponibleParaVisitas(200000);
		miUsuario.setVelocidadDeTraslado(10);
		miUsuario.setDireccionX(0);
		miUsuario.setDireccionY(0);
				
				
		Atraccion[] vectorDeAtracciones = new Atraccion[]{new Atraccion(), new Atraccion(), new Atraccion(), new Atraccion(), new Atraccion(),new Atraccion(),new Atraccion()};
				
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[0].setTipo("Gondor");
		vectorDeAtracciones[0].setCosto(1200);
		vectorDeAtracciones[0].setTiempoNecesarioParaVisita(10);
		vectorDeAtracciones[0].setCoordenadaX(600);
		vectorDeAtracciones[0].setCoordenadaY(700);
				
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[1].setTipo("Mordor");
		vectorDeAtracciones[1].setCosto(450);
		vectorDeAtracciones[1].setTiempoNecesarioParaVisita(20);
		vectorDeAtracciones[1].setCoordenadaX(600);
		vectorDeAtracciones[1].setCoordenadaY(600);
				
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[2].setTipo("La Comarca");
		vectorDeAtracciones[2].setCosto(700);
		vectorDeAtracciones[2].setTiempoNecesarioParaVisita(40);
		vectorDeAtracciones[2].setCoordenadaX(800);
		vectorDeAtracciones[2].setCoordenadaY(900);
				
		SugerenteDeVisitas miSugerente = new SugerenteDeVisitas(vectorDeAtracciones); 
		List<Atraccion> itinerario = miSugerente.sugerirVisita(miUsuario);
		Paquete paquete = new Paquete();
		paquete.setUsuarioDelPaquete(miUsuario);
				
		//Compro una entrada para cada atraccion
		paquete.comprarEntrada(vectorDeAtracciones[0]);
		paquete.comprarEntrada(vectorDeAtracciones[1]);
		paquete.comprarEntrada(vectorDeAtracciones[2]);
		
		//Verifico que Mordor es la atraccion mas cercana del itinerario
		Assert.assertEquals(vectorDeAtracciones[1].getTipo(),miUsuario.buscarAtraccionMasCercana(miUsuario.getDireccionX(), miUsuario.getDireccionY(), itinerario).getTipo());
			
		//Verifico que la distancia a Mordor es mayor que 200
		Assert.assertEquals(849,miUsuario.calcularDistanciaDeViaje(0, 0, 600, 600));

		/*El paquete actual solo aplica a promocion extranjero
		 * 
		 * El precio final deberia dar 1175
		 * 
		 */
		
		paquete.calcularCostoEnBaseAPromociones(new Promocion[]{});
		Assert.assertEquals(1175,0,paquete.getCostoTotal());
				
	}
	
	@Test
	public void comprarEntradasParaVariasAtracciones(){
		
		//Configuracion de Usuario de Prueba
		Usuario miUsuario = new Usuario();
		miUsuario.setTipoDeAtraccionPreferida("Gondor");
		miUsuario.setPresupuesto(4000);
		miUsuario.setTiempoDisponibleParaVisitas(200000);
		miUsuario.setVelocidadDeTraslado(10);
		miUsuario.setDireccionX(0);
		miUsuario.setDireccionY(0);
		
		Atraccion[] vectorDeAtracciones = new Atraccion[]{new Atraccion(), new Atraccion(), new Atraccion()};
		
		//Configuracion de Atraccion de Prueba
		vectorDeAtracciones[0].setTipo("Gondor");
		vectorDeAtracciones[0].setCosto(1200);
		vectorDeAtracciones[0].setTiempoNecesarioParaVisita(10);
		vectorDeAtracciones[0].setCoordenadaX(10);
		vectorDeAtracciones[0].setCoordenadaY(15);
		
		//Configuracion de Atraccion de Prueba
		vectorDeAtracciones[1].setTipo("Mordor");
		vectorDeAtracciones[1].setCosto(450);
		vectorDeAtracciones[1].setTiempoNecesarioParaVisita(20);
		vectorDeAtracciones[1].setCoordenadaX(20);
		vectorDeAtracciones[1].setCoordenadaY(30);
		
		//Configuracion de Atraccion de Prueba
		vectorDeAtracciones[2].setTipo("La Comarca");
		vectorDeAtracciones[2].setCosto(700);
		vectorDeAtracciones[2].setTiempoNecesarioParaVisita(40);
		vectorDeAtracciones[2].setCoordenadaX(35);
		vectorDeAtracciones[2].setCoordenadaY(10);
		
		Paquete paquete = new Paquete();
		paquete.setUsuarioDelPaquete(miUsuario);
		
		paquete.comprarEntrada(vectorDeAtracciones[0]);
		paquete.comprarEntrada(vectorDeAtracciones[0]);
		paquete.comprarEntrada(vectorDeAtracciones[0]);
		
		paquete.comprarEntrada(vectorDeAtracciones[1]);
		
		paquete.comprarEntrada(vectorDeAtracciones[2]);
		paquete.comprarEntrada(vectorDeAtracciones[2]);
		paquete.comprarEntrada(vectorDeAtracciones[2]);
		paquete.comprarEntrada(vectorDeAtracciones[2]);
		
		//Compruebo que el paquete guardo en su lista de atracciones contratadas todas las atraciones donde compre entradas
		Assert.assertTrue(paquete.getListaDeAtraccionesContratadas().contains(vectorDeAtracciones[0]));
		Assert.assertTrue(paquete.getListaDeAtraccionesContratadas().contains(vectorDeAtracciones[1]));
		Assert.assertTrue(paquete.getListaDeAtraccionesContratadas().contains(vectorDeAtracciones[2]));
		
		//Compruebo la cantidad de entradas
		Assert.assertEquals(3, (int) paquete.getCantidadDeEntradas().get(paquete.getListaDeAtraccionesContratadas().indexOf(vectorDeAtracciones[0])));
		Assert.assertEquals(1, (int) paquete.getCantidadDeEntradas().get(paquete.getListaDeAtraccionesContratadas().indexOf(vectorDeAtracciones[1])));
		Assert.assertEquals(4, (int) paquete.getCantidadDeEntradas().get(paquete.getListaDeAtraccionesContratadas().indexOf(vectorDeAtracciones[2])));

	}
	
	@Test
	public void calcularCostoDePaqueteConPromocionFamiliar(){

		//Configuracion de Usuario de Prueba
		Usuario miUsuario = new Usuario();
		miUsuario.setTipoDeAtraccionPreferida("Gondor");
		miUsuario.setPresupuesto(4000);
		miUsuario.setTiempoDisponibleParaVisitas(200000);
		miUsuario.setVelocidadDeTraslado(10);
		miUsuario.setDireccionX(0);
		miUsuario.setDireccionY(0);
		
		Atraccion[] vectorDeAtracciones = new Atraccion[]{new Atraccion(), new Atraccion(), new Atraccion()};
		
		//Configuracion de Atraccion de Prueba
		vectorDeAtracciones[0].setTipo("Gondor");
		vectorDeAtracciones[0].setCosto(1200);
		vectorDeAtracciones[0].setTiempoNecesarioParaVisita(10);
		vectorDeAtracciones[0].setCoordenadaX(10);
		vectorDeAtracciones[0].setCoordenadaY(15);
		
		//Configuracion de Atraccion de Prueba
		vectorDeAtracciones[1].setTipo("Mordor");
		vectorDeAtracciones[1].setCosto(450);
		vectorDeAtracciones[1].setTiempoNecesarioParaVisita(20);
		vectorDeAtracciones[1].setCoordenadaX(20);
		vectorDeAtracciones[1].setCoordenadaY(30);
		
		//Configuracion de Atraccion de Prueba
		vectorDeAtracciones[2].setTipo("La Comarca");
		vectorDeAtracciones[2].setCosto(700);
		vectorDeAtracciones[2].setTiempoNecesarioParaVisita(40);
		vectorDeAtracciones[2].setCoordenadaX(35);
		vectorDeAtracciones[2].setCoordenadaY(10);
		
		Paquete paquete = new Paquete();
		paquete.setUsuarioDelPaquete(miUsuario);
		
		paquete.comprarEntrada(vectorDeAtracciones[0]);
		paquete.comprarEntrada(vectorDeAtracciones[0]);
		paquete.comprarEntrada(vectorDeAtracciones[0]);
		
		paquete.comprarEntrada(vectorDeAtracciones[1]);
		
		paquete.comprarEntrada(vectorDeAtracciones[2]);
		paquete.comprarEntrada(vectorDeAtracciones[2]);
		paquete.comprarEntrada(vectorDeAtracciones[2]);
		paquete.comprarEntrada(vectorDeAtracciones[2]);
		paquete.comprarEntrada(vectorDeAtracciones[2]);
		paquete.comprarEntrada(vectorDeAtracciones[2]);
		
		//Corrobora que el costo total del paquete sin promociones sea el esperado
		paquete.calcularCostoTotal(paquete.getListaDeAtraccionesContratadas(), paquete.getCantidadDeEntradas());
		Assert.assertEquals(8250,0, paquete.getCostoTotal());
		
		//Corrobora que la promocion Familiar se aplique correctamente
		paquete.aplicarPromocionFamiliar(paquete.getListaDeAtraccionesContratadas(), paquete.getCantidadDeEntradas());
		Assert.assertEquals(7760,0, paquete.getCostoTotal());
		
	}
	
}
