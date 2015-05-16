	/*
	
	public @interface _Correcciones {
	

	La principal cuesti�n que veo es que el modelo lo siento distante de la realidad en varias cuestiones, por ejemplo la Promoci�n no tiene precio y el Paquete no sabe lo que incluye.
	Hay una parte que no est� modelada, lo que tiene que ver con el tipo de atraccion: paisaje, de aventura, de degustacion y que es lo que determina la prefencia del usuario.
	Al mismo tiempo no veo el uso de t�cnicas OO, no hay polimorfismo pues la situaciones polim�rficas se resuelven con if anidados (o case) lo cual quita flexibilidad y dificulta el mantenimiento.
	Si bien la cobertura es alta, las pruebas son insuficientes y el c�digo deja bastante que desear (���hay un m�todo de 100 lineas!!!)

	
	- El diagrama de secuencia no est� bien:
			-- deberia empezar con un mensaje desde el margen
			-- no es consistente con el c�digo, no muestra las estructuras de control (branches y loops)
	- La relaci�n entre Atracci�n y Promoci�n est� representada en el diagrama de clases de una forma que no consistente con el c�digo
	- Los test son insuficientes, por ejemplo calcularCostoDePaqueteUsandoPromociones tiene un solo test cuando en realidad hay muchas situaciones que no hay sido contempladas.
	
	
	Corregidos:
	- Me hace ruido que la clase Promocion tenga un metodo tienePromocion, me parece que el nombre no es apropiado pues no sugiere lo que realmente hace > Corregido, metodo que no se usaba
	- En la clase Atraccion hay c�digo muerto >  Corregido 
	- AtraccionComparator no tiene tests > Corregido
	- Los nombre de los test no son expl�citos respeto de lo que hacen y por ende no respetan lo visto en clase. Para testear calcularTiempoDeViaje el test deberia llamarse calcularTiempoDeViajeDeberiaDevolver1CuandoVoyDeMordorAGondor o algo por el estilo. O sea, el  nombre del tests tiene que ser un ejemplo concreto.
	- Usuario.buscarAtraccionMasCercana tiene un if vacio y un else con c�digo, resulta confuso
	- El paquete tiene el costo no la lista de Atracciones que incluso, suena raro, o sea no corresponde con el mundo real
	- El m�todo calcularCostoDePaqueteUsandoPromociones tiene 100 l�neas > Se separo la logica de cada promocion en metodos independientes 
	
	No se pudo corregir:
	- La clase AtraccionComparator est� muy fulera tiene varios if > No encuentro otra forma de realizarlo
	- La promoci�n no sabe cual es su costo, conceptualmente no cierra pues el costo es fundamental > Conceptualmente se entendio que la promocion aplica sobre un costo y no que en si guarda un costo, no encuentro forma de corregirlo en este dise�o
	
	
	
	}

*/
