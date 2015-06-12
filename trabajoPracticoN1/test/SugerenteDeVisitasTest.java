import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class SugerenteDeVisitasTest {
	
	@Test
	public void sugerirListaDeVisitasQueCumplenConRequisitosParaElUsuario(){
		
		List<Atraccion> listaDeAtracciones = new LinkedList<Atraccion>();
		Usuario miUsuario = new Usuario();
		Atraccion[] vectorDeAtracciones = new Atraccion[]{new Atraccion(), new Atraccion(), new Atraccion(), new Atraccion(), new Atraccion()};
		
		//Configuracion de Usuario de Prueba
		miUsuario.setTipoDeAtraccionPreferida(TipoDeAtraccion.GONDOR);
		miUsuario.setPresupuesto(100);
		miUsuario.setTiempoDisponibleParaVisitas(180);
				
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[1].setTipo(TipoDeAtraccion.GONDOR);
		vectorDeAtracciones[1].setCosto(90);
		vectorDeAtracciones[1].setTiempoNecesarioParaVisita(150);
		
		//Configuracion de Atraccion de Prueba2 > Cumple algunas condiciones
		vectorDeAtracciones[2].setTipo(TipoDeAtraccion.PASEO_DE_AVENTURA);
		vectorDeAtracciones[2].setCosto(90);
		vectorDeAtracciones[2].setTiempoNecesarioParaVisita(150);
		
		//Configuracion de Atraccion de Prueba2 > No cumple alguna condicion
		vectorDeAtracciones[4].setTipo(TipoDeAtraccion.LA_COMARCA);
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
	public void sugerirItinerarioPorMenorCostoDeAtraccionDevuelveListaOrdenadaPorCostoHastaDondeAlcanzaElPresupuesto(){
		
		//Configuracion de Usuario de Prueba
		Usuario miUsuario = new Usuario();
		miUsuario.setTipoDeAtraccionPreferida(TipoDeAtraccion.GONDOR);
		miUsuario.setPresupuesto(4000);
		miUsuario.setTiempoDisponibleParaVisitas(168);
		miUsuario.setVelocidadDeTraslado(10);
				
		//Configuracion de atracciones
		Atraccion[] vectorDeAtracciones = new Atraccion[]{new Atraccion(), new Atraccion(), new Atraccion(), new Atraccion(), new Atraccion(),new Atraccion(),new Atraccion()};
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[0].setTipo(TipoDeAtraccion.GONDOR);
		vectorDeAtracciones[0].setCosto(1200);
		vectorDeAtracciones[0].setTiempoNecesarioParaVisita(10);
		vectorDeAtracciones[0].setCoordenadaX(10);
		vectorDeAtracciones[0].setCoordenadaY(15);
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[1].setTipo(TipoDeAtraccion.MORDOR);
		vectorDeAtracciones[1].setCosto(450);
		vectorDeAtracciones[1].setTiempoNecesarioParaVisita(20);
		vectorDeAtracciones[1].setCoordenadaX(20);
		vectorDeAtracciones[1].setCoordenadaY(30);
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[2].setTipo(TipoDeAtraccion.LA_COMARCA);
		vectorDeAtracciones[2].setCosto(700);
		vectorDeAtracciones[2].setTiempoNecesarioParaVisita(40);
		vectorDeAtracciones[2].setCoordenadaX(35);
		vectorDeAtracciones[2].setCoordenadaY(10);
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[3].setTipo(TipoDeAtraccion.BOSQUE_ENCANTADO);
		vectorDeAtracciones[3].setCosto(700);
		vectorDeAtracciones[3].setTiempoNecesarioParaVisita(5);
		vectorDeAtracciones[3].setCoordenadaX(40);
		vectorDeAtracciones[3].setCoordenadaY(20);
		
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[4].setTipo(TipoDeAtraccion.PASEO_DE_AVENTURA);
		vectorDeAtracciones[4].setCosto(800);
		vectorDeAtracciones[4].setTiempoNecesarioParaVisita(30);
		vectorDeAtracciones[4].setCoordenadaX(40);
		vectorDeAtracciones[4].setCoordenadaY(40);
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[5].setTipo(TipoDeAtraccion.MINAS_TIRITH);
		vectorDeAtracciones[5].setCosto(1500);
		vectorDeAtracciones[5].setTiempoNecesarioParaVisita(10);
		vectorDeAtracciones[5].setCoordenadaX(60);
		vectorDeAtracciones[5].setCoordenadaY(35);
		
		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[6].setTipo(TipoDeAtraccion.TORRE);
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
	public void sugerirItinerarioPorMenorDistanciaDevuelveListaDeAtraccionMasCercanaEnBaseALaPosicion(){
		
		//Configuracion de Usuario de Prueba
		Usuario miUsuario = new Usuario();
		miUsuario.setTipoDeAtraccionPreferida(TipoDeAtraccion.GONDOR);
		miUsuario.setPresupuesto(4000);
		miUsuario.setTiempoDisponibleParaVisitas(168);
		miUsuario.setVelocidadDeTraslado(10);
		miUsuario.setDireccionX(0);
		miUsuario.setDireccionY(0);

		Atraccion[] vectorDeAtracciones = new Atraccion[]{new Atraccion(), new Atraccion(), new Atraccion(), new Atraccion(), new Atraccion(),new Atraccion(),new Atraccion()};

		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[0].setTipo(TipoDeAtraccion.GONDOR);
		vectorDeAtracciones[0].setCosto(1200);
		vectorDeAtracciones[0].setTiempoNecesarioParaVisita(10);
		vectorDeAtracciones[0].setCoordenadaX(10);
		vectorDeAtracciones[0].setCoordenadaY(15);

		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[1].setTipo(TipoDeAtraccion.MORDOR);
		vectorDeAtracciones[1].setCosto(450);
		vectorDeAtracciones[1].setTiempoNecesarioParaVisita(20);
		vectorDeAtracciones[1].setCoordenadaX(20);
		vectorDeAtracciones[1].setCoordenadaY(30);

		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[2].setTipo(TipoDeAtraccion.LA_COMARCA);
		vectorDeAtracciones[2].setCosto(700);
		vectorDeAtracciones[2].setTiempoNecesarioParaVisita(40);
		vectorDeAtracciones[2].setCoordenadaX(35);
		vectorDeAtracciones[2].setCoordenadaY(10);

		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[3].setTipo(TipoDeAtraccion.BOSQUE_ENCANTADO);
		vectorDeAtracciones[3].setCosto(700);
		vectorDeAtracciones[3].setTiempoNecesarioParaVisita(5);
		vectorDeAtracciones[3].setCoordenadaX(40);
		vectorDeAtracciones[3].setCoordenadaY(20);


		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[4].setTipo(TipoDeAtraccion.PASEO_DE_AVENTURA);
		vectorDeAtracciones[4].setCosto(800);
		vectorDeAtracciones[4].setTiempoNecesarioParaVisita(30);
		vectorDeAtracciones[4].setCoordenadaX(40);
		vectorDeAtracciones[4].setCoordenadaY(40);

		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[5].setTipo(TipoDeAtraccion.MINAS_TIRITH);
		vectorDeAtracciones[5].setCosto(1500);
		vectorDeAtracciones[5].setTiempoNecesarioParaVisita(10);
		vectorDeAtracciones[5].setCoordenadaX(60);
		vectorDeAtracciones[5].setCoordenadaY(35);

		//Configuracion de Atraccion de Prueba > Cumple todas las condiciones
		vectorDeAtracciones[6].setTipo(TipoDeAtraccion.TORRE);
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

}
