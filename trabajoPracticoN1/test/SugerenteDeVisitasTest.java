import java.util.LinkedList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;


public class SugerenteDeVisitasTest {
	
	@Test
	public void sugerirVisita(){
		
		List<Atraccion> listaDeAtracciones = new LinkedList<Atraccion>();
		Usuario miUsuario = new Usuario();
		Atraccion[] vectorDeAtracciones = new Atraccion[]{new Atraccion(), new Atraccion(), new Atraccion(), new Atraccion(), new Atraccion()};
		
		//Configuracion de Usuario de Prueba
		miUsuario.setTipoDeAtraccionPreferida("Gondor");
		miUsuario.setPresupuesto(100);
		miUsuario.setTiempoDisponibleParaVisitas(180);
				
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[1].setTipo("Gondor");
		vectorDeAtracciones[1].setCosto(90);
		vectorDeAtracciones[1].setTiempoNecesarioParaVisita(150);
		
		//Configuracion de Atraccion de Prueba2 > Cumple algunas condiciones
		vectorDeAtracciones[2].setTipo("Paisaje De Aventura");
		vectorDeAtracciones[2].setCosto(90);
		vectorDeAtracciones[2].setTiempoNecesarioParaVisita(150);
		
		//Configuracion de Atraccion de Prueba2 > No cumple alguna condicion
		vectorDeAtracciones[4].setTipo("Paseo de Tarde");
		vectorDeAtracciones[4].setCosto(150);
		vectorDeAtracciones[4].setTiempoNecesarioParaVisita(150);
		
		Assert.assertTrue(listaDeAtracciones.isEmpty());
		
		SugerenteDeVisitas miSugerente = new SugerenteDeVisitas(vectorDeAtracciones);
		listaDeAtracciones = miSugerente.sugerirVisita(miUsuario);
		
		Assert.assertFalse(listaDeAtracciones.isEmpty());
		Assert.assertTrue(listaDeAtracciones.size()==2);
		Assert.assertTrue(listaDeAtracciones.contains(vectorDeAtracciones[1]));
		Assert.assertTrue(listaDeAtracciones.contains(vectorDeAtracciones[2]));
		Assert.assertFalse(listaDeAtracciones.contains(vectorDeAtracciones[4]));
		
	}

	@Test
	public void sugerirItinerarioPorMenorCostoDeAtraccion(){
		
		//Configuracion de Usuario de Prueba
		Usuario miUsuario = new Usuario();
		miUsuario.setTipoDeAtraccionPreferida("Gondor");
		miUsuario.setPresupuesto(4000);
		miUsuario.setTiempoDisponibleParaVisitas(168);
		miUsuario.setVelocidadDeTraslado(10);
				
		//Configuracion de atracciones
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
		
		SugerenteDeVisitas miSugerente = new SugerenteDeVisitas(vectorDeAtracciones);
		
		//Test de metodos
		miSugerente.sugerirVisita(miUsuario);
		miSugerente.sugerirItinerarioPorCosto(miUsuario);
		
		//Test de resultados
		List<Atraccion> ListaDeAtracciones;
		ListaDeAtracciones = miSugerente.sugerirItinerarioPorCosto(miUsuario);
		Assert.assertTrue(ListaDeAtracciones.contains(vectorDeAtracciones[0]));
		Assert.assertTrue(ListaDeAtracciones.contains(vectorDeAtracciones[1]));
		Assert.assertTrue(ListaDeAtracciones.contains(vectorDeAtracciones[2]));
		Assert.assertTrue(ListaDeAtracciones.contains(vectorDeAtracciones[3]));
		Assert.assertFalse(ListaDeAtracciones.contains(vectorDeAtracciones[4]));
		Assert.assertFalse(ListaDeAtracciones.contains(vectorDeAtracciones[5]));
		Assert.assertTrue(ListaDeAtracciones.contains(vectorDeAtracciones[6]));

		
	}
	
	@Test
	public void sugerirItinerarioPorMenorDistancia(){
		
		//Configuracion de Usuario de Prueba
		Usuario miUsuario = new Usuario();
		miUsuario.setTipoDeAtraccionPreferida("Gondor");
		miUsuario.setPresupuesto(4000);
		miUsuario.setTiempoDisponibleParaVisitas(168);
		miUsuario.setVelocidadDeTraslado(10);

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
		
		SugerenteDeVisitas miSugerente = new SugerenteDeVisitas(vectorDeAtracciones);
		List<Atraccion> ListaDeAtracciones;
		ListaDeAtracciones = miSugerente.sugerirItinerarioPorMenorDistancia(miUsuario);
		
		/*
		 * El itinerario calculado arrancando en la posicion 0,0 deberia ser:
		 * 
		 * Gondor - Mordor - Paseo De Aventura - Minas Tirith
		 * 
		 */
		
		Assert.assertTrue(ListaDeAtracciones.size()==4);
		Assert.assertEquals(vectorDeAtracciones[0],ListaDeAtracciones.get(0));
		Assert.assertEquals(vectorDeAtracciones[1],ListaDeAtracciones.get(1));
		Assert.assertEquals(vectorDeAtracciones[4],ListaDeAtracciones.get(2));
		Assert.assertEquals(vectorDeAtracciones[5],ListaDeAtracciones.get(3));
		
		
	}
	
	@Test
	public void calcularCostoDePaqueteUsandoPromociones(){
		
		//Configuracion de Usuario de Prueba
		Usuario miUsuario = new Usuario();
		miUsuario.setTipoDeAtraccionPreferida("Gondor");
		miUsuario.setPresupuesto(4000);
		miUsuario.setTiempoDisponibleParaVisitas(168);
		miUsuario.setVelocidadDeTraslado(10);
				
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
		paquete.calcularCostoTotal(itinerario);
		Assert.assertEquals(3950,0,paquete.getCostoTotal());

		/*Para el itinerario esperado y los paquetes asignados el precio total deberia dar:
		 * 
		 * Costo total inicial = 3950,0
		 * Gondor tiene promo porcentual 10% > Costo total 3950,0 - (1200 *10%) = 3830,0
		 * Mordor, Paseo y Minas tiene promo por paquete 15% sobre el total > Costo total = 3830,0 - (3830,0*15%) = 3255,5
		 * Gondor, Mordor, Paseo y Minas tienen promo AxB, debe descontar la mas barata (Mordor) > Costo total = 3255,5 - 450 = 2805,5
		 * 
		 */
		paquete.calcularCostoEnBaseAPromociones(itinerario, new Promocion[]{promocionPorPorcentaje,promocionPorPaquete,promocionAXB});
		Assert.assertEquals(2805,5, paquete.getCostoTotal());
		
		
		
	}

}
