	/*
	
	public @interface _Correcciones {
	

	La principal cuestión que veo es que el modelo lo siento distante de la realidad en varias cuestiones, por ejemplo la Promoción no tiene precio y el Paquete no sabe lo que incluye.
	Hay una parte que no está modelada, lo que tiene que ver con el tipo de atraccion: paisaje, de aventura, de degustacion y que es lo que determina la prefencia del usuario.
	Al mismo tiempo no veo el uso de técnicas OO, no hay polimorfismo pues la situaciones polimórficas se resuelven con if anidados (o case) lo cual quita flexibilidad y dificulta el mantenimiento.
	Si bien la cobertura es alta, las pruebas son insuficientes y el código deja bastante que desear (¡¡¡hay un método de 100 lineas!!!)

	
	- El diagrama de secuencia no está bien:
			-- deberia empezar con un mensaje desde el margen
			-- no es consistente con el código, no muestra las estructuras de control (branches y loops)
	- La relación entre Atracción y Promoción está representada en el diagrama de clases de una forma que no consistente con el código
	- Los test son insuficientes, por ejemplo calcularCostoDePaqueteUsandoPromociones tiene un solo test cuando en realidad hay muchas situaciones que no hay sido contempladas.
	
	
	Corregidos:
	- Me hace ruido que la clase Promocion tenga un metodo tienePromocion, me parece que el nombre no es apropiado pues no sugiere lo que realmente hace > Corregido, metodo que no se usaba
	- En la clase Atraccion hay código muerto >  Corregido 
	- AtraccionComparator no tiene tests > Corregido
	- Los nombre de los test no son explícitos respeto de lo que hacen y por ende no respetan lo visto en clase. Para testear calcularTiempoDeViaje el test deberia llamarse calcularTiempoDeViajeDeberiaDevolver1CuandoVoyDeMordorAGondor o algo por el estilo. O sea, el  nombre del tests tiene que ser un ejemplo concreto.
	- Usuario.buscarAtraccionMasCercana tiene un if vacio y un else con código, resulta confuso
	- El paquete tiene el costo no la lista de Atracciones que incluso, suena raro, o sea no corresponde con el mundo real
	- El método calcularCostoDePaqueteUsandoPromociones tiene 100 líneas > Se separo la logica de cada promocion en metodos independientes 
	
	No se pudo corregir:
	- La clase AtraccionComparator está muy fulera tiene varios if > No encuentro otra forma de realizarlo
	- La promoción no sabe cual es su costo, conceptualmente no cierra pues el costo es fundamental > Conceptualmente se entendio que la promocion aplica sobre un costo y no que en si guarda un costo, no encuentro forma de corregirlo en este diseño
	
	
	
	}

*/
