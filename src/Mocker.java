import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;


public class Mocker {

	public static void main(String[] args) {
		Mocker mocker = new Mocker();
		try {
			mocker.mockClientes(90000);
			mocker.generarHoteles(100);
			mocker.generarHostales(150);
			mocker.generarViviendas(100);
			mocker.generarHotelRoom(120, 100);
			mocker.generarHostalRoom(120, 150);
			mocker.generarInmueble(1000);
			mocker.generarViviendaRoom(150, 100);
			mocker.generarVecinos(2000);
			mocker.generarReservas(900000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Numero de Tuplas: " + mocker.numDatos);

	}

	public static final int ID_START = 100000;
	public static final String CLIENTES = "./data/clientes.csv";
	public static final String PERSONAS = "./data/personas.csv";
	public static final String ALOJAMIENTOS = "./data/alojamientos.csv";
	public static final String HOTELES = "./data/hoteles.csv";
	public static final String OPERADORES = "./data/operadores.csv";
	public static final String HOSTALES = "./data/hostales.csv";
	public static final String VIVIENDAS = "./data/viviendas.csv";
	public static final String HOSTALROOM = "./data/hostalRoom.csv";
	public static final String INMUEBLE = "./data/inmueble.csv";
	public static final String VECINO = "./data/vecino.csv";
	public static final String VECINOROOM = "./data/vecinoRoom.csv";
	public static final String VIVIENDAROOM = "./data/viviendaRoom.csv";
	public static final String RESERVAS = "./data/reservas.csv";

	public int numDatos = 0;
	
	public void mockClientes(int num) throws IOException {
		File fileClientes = new File(CLIENTES);
		boolean clientesExiste = true;
		if(!fileClientes.exists()) {
			fileClientes.createNewFile();
			clientesExiste = false;
		}
		FileOutputStream foscClientes = new FileOutputStream(fileClientes,true);
		PrintWriter prClientes = new PrintWriter(foscClientes);
		File filePersonas = new File(PERSONAS);
		boolean personasEx = true;
		if(!filePersonas.exists()) {
			filePersonas.createNewFile();
			personasEx = false;
		}
		FileOutputStream fosPersonas = new FileOutputStream(filePersonas,true);
		PrintWriter prPersonas = new PrintWriter(fosPersonas);

		if(!clientesExiste) {
			prClientes.println("Cedula");
		}
		if(!personasEx) {
			prPersonas.println("Cedula,Nombre,Rol,FechaNacimiento");
		}


		String cedula = "1000";
		RandomString rng = new RandomString(8, ThreadLocalRandom.current());
		for(int i = 0; i < num; i++) {
			String personaString = cedula + i + "," + rng.nextString() + "," + generarRolPersona() + "," + generarFecha(1950, 2000);
			prPersonas.println(personaString);
			String clienteString = cedula + i;
			prClientes.println(clienteString);
			numDatos++;
			numDatos++;
		}

		prClientes.close();
		prPersonas.close();
	}

	//OPERADORES
	public void generarHoteles(int cant) throws IOException {
		File fileHoteles = new File(HOTELES);
		boolean hotelesExiste = true;
		if(!fileHoteles.exists()) {
			fileHoteles.createNewFile();
			hotelesExiste = false;
		}
		FileOutputStream fosHoteles = new FileOutputStream(fileHoteles,true);
		PrintWriter prHoteles = new PrintWriter(fosHoteles);
		File fileOperadores = new File(OPERADORES);
		boolean operadoresEx = true;
		if(!fileOperadores.exists()) {
			fileOperadores.createNewFile();
			operadoresEx = false;
		}
		FileOutputStream fosOperadores = new FileOutputStream(fileOperadores,true);
		PrintWriter prOperadores = new PrintWriter(fosOperadores);

		if(!hotelesExiste) {
			prHoteles.println("ID,DESAYUNO,RESTAURANTE,PISCINA,PARQUEADERO");
		}
		if(!operadoresEx) {
			prOperadores.println("ID,NOMBRE,DIRECCION,DTYPE");
		}

		//EGNERACION
		RandomString rng = new RandomString(10, ThreadLocalRandom.current());
		for(int i = 0; i < cant; i++) {
			String alohaString = "" + (i+ID_START) + "," + rng.nextString() + "," + rng.nextString() + ",HOTEL";
			String hotelStr = "" + (i+ID_START) + "," + ThreadLocalRandom.current().nextInt(0,2) + "," + ThreadLocalRandom.current().nextInt(0,2) + "," + ThreadLocalRandom.current().nextInt(0,2) + "," + ThreadLocalRandom.current().nextInt(0,2); 
			prOperadores.println(alohaString);
			prHoteles.println(hotelStr);
			numDatos++;
			numDatos++;
			
		}
		prHoteles.close();
		prOperadores.close();
	}
	
	public void generarHostales(int cant) throws IOException {
		File fileHostales = new File(HOSTALES);
		boolean hostalesExiste = true;
		if(!fileHostales.exists()) {
			fileHostales.createNewFile();
			hostalesExiste = false;
		}
		FileOutputStream fosHostales = new FileOutputStream(fileHostales,true);
		PrintWriter prHostales = new PrintWriter(fosHostales);
		File fileOperadores = new File(OPERADORES);
		boolean operadoresEx = true;
		if(!fileOperadores.exists()) {
			fileOperadores.createNewFile();
			operadoresEx = false;
		}
		FileOutputStream fosOperadores = new FileOutputStream(fileOperadores,true);
		PrintWriter prOperadores = new PrintWriter(fosOperadores);

		if(!hostalesExiste) {
			prHostales.println("ID,APERTURA,CIERRE,DESAYUNO");
		}
		if(!operadoresEx) {
			prOperadores.println("ID,NOMBRE,DIRECCION,DTYPE");
		}

		//EGNERACION
		RandomString rng = new RandomString(10, ThreadLocalRandom.current());
		for(int i = 0; i < cant; i++) {
			String alohaString = "" + (i+(2*ID_START)) + "," + rng.nextString() + "," + rng.nextString() + ",HOSTAL";
			String hostalStr = "" + (i+(2*ID_START)) + "," + ThreadLocalRandom.current().nextInt(4,8) + "," + ThreadLocalRandom.current().nextInt(18, 24) + "," + ThreadLocalRandom.current().nextInt(0,2); 
			prOperadores.println(alohaString);
			prHostales.println(hostalStr);
			numDatos++;
			numDatos++;
			
		}
		prHostales.close();
		prOperadores.close();
	}
	
	public void generarViviendas(int cant) throws IOException {
		File fileViviendas = new File(VIVIENDAS);
		boolean viviendasExiste = true;
		if(!fileViviendas.exists()) {
			fileViviendas.createNewFile();
			viviendasExiste = false;
		}
		FileOutputStream fosViviendas = new FileOutputStream(fileViviendas,true);
		PrintWriter prViviendas = new PrintWriter(fosViviendas);
		File fileOperadores = new File(OPERADORES);
		boolean operadoresEx = true;
		if(!fileOperadores.exists()) {
			fileOperadores.createNewFile();
			operadoresEx = false;
		}
		FileOutputStream fosOperadores = new FileOutputStream(fileOperadores,true);
		PrintWriter prOperadores = new PrintWriter(fosOperadores);

		if(!viviendasExiste) {
			prViviendas.println("ID");
		}
		if(!operadoresEx) {
			prOperadores.println("ID,NOMBRE,DIRECCION,DTYPE");
		}

		//EGNERACION
		RandomString rng = new RandomString(10, ThreadLocalRandom.current());
		for(int i = 0; i < cant; i++) {
			String alohaString = "" + (i+(3*ID_START)) + "," + rng.nextString() + "," + rng.nextString() + ",VIVIENDAU";
			String viviendaStr = "" + (i+(3*ID_START)); 
			numDatos++;
			numDatos++;
			prOperadores.println(alohaString);
			prViviendas.println(viviendaStr);
			
		}
		prViviendas.close();
		prOperadores.close();
	}

	//Alojamientos
	public void generarHostalRoom(int immanuelKant, int cantHostales) throws IOException {
		File fileHostalRoom = new File(HOSTALROOM);
		boolean hostalRoomExiste = true;
		if(!fileHostalRoom.exists()) {
			fileHostalRoom.createNewFile();
			hostalRoomExiste = false;
		}
		FileOutputStream fosHostalRoom = new FileOutputStream(fileHostalRoom,true);
		PrintWriter prHostalRoom = new PrintWriter(fosHostalRoom);
		File fileAlojamiento = new File(ALOJAMIENTOS);
		boolean alojamientoEx = true;
		if(!fileAlojamiento.exists()) {
			fileAlojamiento.createNewFile();
			alojamientoEx = false;
		}
		FileOutputStream fosAlojamiento = new FileOutputStream(fileAlojamiento,true);
		PrintWriter prAlojamiento = new PrintWriter(fosAlojamiento);

		if(!hostalRoomExiste) {
			prHostalRoom.println("ID,CUARTO,IDHOSTAL");
		}
		if(!alojamientoEx) {
			prAlojamiento.println("ID,PRECIO,CAPACIDAD,DTYPE");
		}

		//EGNERACION
		int cont = 0;
		for(int i = 0; i < cantHostales; i++) {
			int idHostal = (i+(2*ID_START));
			for(int j = 0; j < immanuelKant; j++) {
				String hstlString = ((2*ID_START)+cont) + "," + j + "," + idHostal;
				String alojString = ((2*ID_START)+cont) + "," 
				+ ThreadLocalRandom.current().nextInt(100, 10001) + "," 
				+ ThreadLocalRandom.current().nextInt(1, 11) + ",HOSTALROOM";
				numDatos++;
				numDatos++;
				prHostalRoom.println(hstlString);
				prAlojamiento.println(alojString);
			}
			
		}
		prHostalRoom.close();
		prAlojamiento.close();
	}

	public void generarHotelRoom(int immanuelKant, int cantHoteles) throws IOException {
		File fileHotelRoom = new File(HOSTALROOM);
		boolean hotelRoomExiste = true;
		if(!fileHotelRoom.exists()) {
			fileHotelRoom.createNewFile();
			hotelRoomExiste = false;
		}
		FileOutputStream fosHotelRoom = new FileOutputStream(fileHotelRoom,true);
		PrintWriter prHotelRoom = new PrintWriter(fosHotelRoom);
		File fileAlojamiento = new File(ALOJAMIENTOS);
		boolean alojamientoEx = true;
		if(!fileAlojamiento.exists()) {
			fileAlojamiento.createNewFile();
			alojamientoEx = false;
		}
		FileOutputStream fosAlojamiento = new FileOutputStream(fileAlojamiento,true);
		PrintWriter prAlojamiento = new PrintWriter(fosAlojamiento);

		if(!hotelRoomExiste) {
			prHotelRoom.println("ID,TIPO,CUARTO,BANERA,JACUZZI,SALA,COCINA,CABLE,IDHOTEL");
		}
		if(!alojamientoEx) {
			prAlojamiento.println("ID,PRECIO,CAPACIDAD,DTYPE");
		}

		//EGNERACION
		int cont = 0;
		for(int i = 0; i < cantHoteles; i++) {
			int idHotel = (i+(ID_START));
			for(int j = 0; j < immanuelKant; j++) {
				String hstlString = ((ID_START)+cont) + "," 
				+ generarTipoHotelRoom() + ","
			    + j + "," 
				+ ThreadLocalRandom.current().nextInt(0,2) + ","
				+ ThreadLocalRandom.current().nextInt(0,2) + ","
				+ ThreadLocalRandom.current().nextInt(0,2) + ","
				+ ThreadLocalRandom.current().nextInt(0,2) + ","
				+ ThreadLocalRandom.current().nextInt(0,2) + ","
				+ idHotel;
				String alojString = ((ID_START)+cont) + "," 
				+ ThreadLocalRandom.current().nextInt(100, 10001) + "," 
				+ ThreadLocalRandom.current().nextInt(1, 11) + ",HOTELROOM";
				numDatos++;
				numDatos++;
				cont++;
				prHotelRoom.println(hstlString);
				prAlojamiento.println(alojString);
			}
			
		}
		prHotelRoom.close();
		prAlojamiento.close();
	}
	
	public void generarViviendaRoom(int immanuelKant, int cantViviendas) throws IOException {
		File fileViviendaRoom = new File(VIVIENDAROOM);
		boolean viviendaRoomExiste = true;
		if(!fileViviendaRoom.exists()) {
			fileViviendaRoom.createNewFile();
			viviendaRoomExiste = false;
		}
		FileOutputStream fosViviendaRoom = new FileOutputStream(fileViviendaRoom,true);
		PrintWriter prViviendaRoom = new PrintWriter(fosViviendaRoom);
		
		File fileAlojamiento = new File(ALOJAMIENTOS);
		boolean alojamientoEx = true;
		if(!fileAlojamiento.exists()) {
			fileAlojamiento.createNewFile();
			alojamientoEx = false;
		}
		FileOutputStream fosAlojamiento = new FileOutputStream(fileAlojamiento,true);
		PrintWriter prAlojamiento = new PrintWriter(fosAlojamiento);

		if(!viviendaRoomExiste) {
			prViviendaRoom.println("ID,CUARTO,COMPARTIDA,RESTAURANTE,SALADEESTUDIO,SALAESPARCIMIENTO,GYM,PRECIO,IDVIVIENDA");
		}
		if(!alojamientoEx) {
			prAlojamiento.println("ID,PRECIO,CAPACIDAD,DTYPE");
		}

		//EGNERACION
		int cont = 0;
		for(int i = 0; i < cantViviendas; i++) {
			int idVivienda = (i+(ID_START*4));
			for(int j = 0; j < immanuelKant; j++) {
				String hstlString = ((ID_START*4)+cont) + "," 
			    + j + "," 
				+ ThreadLocalRandom.current().nextInt(0,2) + ","
				+ ThreadLocalRandom.current().nextInt(0,2) + ","
				+ ThreadLocalRandom.current().nextInt(0,2) + ","
				+ ThreadLocalRandom.current().nextInt(0,2) + ","
				+ ThreadLocalRandom.current().nextInt(0,2) + ","
				+ idVivienda;
				String alojString = ((ID_START*4)+cont) + "," 
				+ ThreadLocalRandom.current().nextInt(100, 10001) + "," 
				+ ThreadLocalRandom.current().nextInt(1, 11) + ",HOTELROOM";
				numDatos++;
				numDatos++;
				cont++;
				prViviendaRoom.println(hstlString);
				prAlojamiento.println(alojString);
			}
			
		}
		prViviendaRoom.close();
		prAlojamiento.close();
	}
	
	public void generarInmueble(int immanuelKant) throws IOException {
		File fileInmueble = new File(INMUEBLE);
		boolean inmuebleExiste = true;
		if(!fileInmueble.exists()) {
			fileInmueble.createNewFile();
			inmuebleExiste = false;
		}
		FileOutputStream fosInmueble = new FileOutputStream(fileInmueble,true);
		PrintWriter prInmueble = new PrintWriter(fosInmueble);
		
		File fileAlojamiento = new File(ALOJAMIENTOS);
		boolean alojamientoExiste = true;
		if(!fileAlojamiento.exists()) {
			fileAlojamiento.createNewFile();
			alojamientoExiste = false;
		}
		FileOutputStream fosAlojamiento = new FileOutputStream(fileAlojamiento,true);
		PrintWriter prAlojamiento = new PrintWriter(fosAlojamiento);
		
		
		if(!inmuebleExiste) {
			prInmueble.println("ID,AMOBLADO,SERVICIOS,CABLE,ADMINISTRACION,DIRECCION,DUENO");
		}
		if(!alojamientoExiste) {
			prAlojamiento.println("ID,PRECIO,CAPACIDAD,DTYPE");
		}

		//EGNERACION
		RandomString rng = new RandomString(10, ThreadLocalRandom.current());
		String cedula = "1000";
		for(int i = 0; i < immanuelKant; i++) {
			String alojaString = ((3*ID_START)+i) + "," 
					+ ThreadLocalRandom.current().nextInt(100, 10001) + "," 
					+ ThreadLocalRandom.current().nextInt(1, 11) + ",INMUEBLE";
					numDatos++;
					numDatos++;
			String inmString = ((3*ID_START)+i) + "," 
					+ ThreadLocalRandom.current().nextInt(0,2) + "," 
					+ ThreadLocalRandom.current().nextInt(0,2) + "," 
					+ ThreadLocalRandom.current().nextInt(0,2) + "," 
					+ ThreadLocalRandom.current().nextInt(0,2) + "," 
					+ rng.nextString() + ","
					+ cedula + i;
			prInmueble.println(inmString);
			prAlojamiento.println(alojaString);
					
					
		}
		prInmueble.close();
		prAlojamiento.close();
	}
	
	public void generarVecinos(int immanuelKant) throws IOException {
		File fileVecinoRoom = new File(VECINOROOM);
		boolean vecinoRoomExiste = true;
		if(!fileVecinoRoom.exists()) {
			fileVecinoRoom.createNewFile();
			vecinoRoomExiste = false;
		}
		FileOutputStream fosVecinoRoom = new FileOutputStream(fileVecinoRoom,true);
		PrintWriter prVecinoRoom = new PrintWriter(fosVecinoRoom);
		
		File filePersona = new File(PERSONAS);
		boolean personaExiste = true;
		if(!filePersona.exists()) {
			filePersona.createNewFile();
			personaExiste = false;
		}
		FileOutputStream fosPersona = new FileOutputStream(filePersona,true);
		PrintWriter prPersona = new PrintWriter(fosPersona);
		
		
		File fileAlojamiento = new File(ALOJAMIENTOS);
		boolean alojamientoExiste = true;
		if(!fileAlojamiento.exists()) {
			fileAlojamiento.createNewFile();
			alojamientoExiste = false;
		}
		FileOutputStream fosAlojamiento = new FileOutputStream(fileAlojamiento,true);
		PrintWriter prAlojamiento = new PrintWriter(fosAlojamiento);
		
		File fileVecino = new File(VECINO);
		boolean vecinoExiste = true;
		if(!fileVecino.exists()) {
			fileVecino.createNewFile();
			vecinoExiste = false;
		}
		FileOutputStream fosVecino = new FileOutputStream(fileVecino,true);
		PrintWriter prVecino = new PrintWriter(fosVecino);
		
		
		if(!vecinoRoomExiste) {
			prVecinoRoom.println("ID,HABITACIONES, BANOS, DIRECCION, MENAJE, DUENO");
		}
		if(!alojamientoExiste) {
			prAlojamiento.println("ID,PRECIO,CAPACIDAD,DTYPE");
		}
		if(!vecinoExiste) {
			prVecino.println("CEDULA");
		}
		
		if(!personaExiste) {
			prPersona.println("CEDULA, NOMBRE, ROL, FECHANACIMIENTO");
		}

		//EGNERACION
		RandomString rng = new RandomString(15, ThreadLocalRandom.current());
		String cedula = "2000";
		for(int i = 0; i < immanuelKant; i++) {
			String vecStr = cedula + i;
			String perStr = cedula + i + "," + rng.nextString() + "," + generarRolPersona() + "," + generarFecha(1950, 2000);
			String alojStr = ((5*ID_START)+i) + "," 
					+ ThreadLocalRandom.current().nextInt(100, 10001) + "," 
					+ ThreadLocalRandom.current().nextInt(1, 11) + ",VECINOROOM";
			String vecRoom = ((5*ID_START)+i) 
					+ ThreadLocalRandom.current().nextInt(1, 5) + ","
					+ ThreadLocalRandom.current().nextInt(1, 5) + ","
					+ rng.nextString() + "," 
					+ rng.nextString() + ","
					+ cedula + i;
			numDatos++;
			numDatos++;
			numDatos++;
			numDatos++;
			prPersona.println(perStr);
			prAlojamiento.println(alojStr);
			prVecino.println(vecStr);
			prVecinoRoom.println(vecRoom);
			
			
					
		
		}
		prPersona.close();
		prVecino.close();
		prVecinoRoom.close();
		prAlojamiento.close();
	}

	public void generarReservas(int immanuelKant) throws IOException {
		File fileReservas = new File(RESERVAS);
		boolean reservasExiste = true;
		if(!fileReservas.exists()) {
			fileReservas.createNewFile();
			reservasExiste = false;
		}
		FileOutputStream fosReservas = new FileOutputStream(fileReservas,true);
		PrintWriter prReservas = new PrintWriter(fosReservas);
		
		if(!reservasExiste) {
			prReservas.println("ID,FECHAINICIO,FECHAFIN,PRECIO,CEDULA,CUARTO");
		}
		
		String cedula = "1000";
		for(int i = 0; i < immanuelKant; i++) {
			int a = darAlojamiento();
			String strRes = (ID_START+i) + ","
					+ generarFechaRes(1990, 2018) + ","
					+ ThreadLocalRandom.current().nextInt(100,100000) + ","
					+ cedula + ThreadLocalRandom.current().nextInt(1, 90000) + ","
					+ ((ID_START*a) +  ThreadLocalRandom.current().nextInt(0,darRangoAloja(a)));
			numDatos++;
			prReservas.println(strRes);
		} 
		prReservas.close();
	}
	
	
	public String generarFecha(int anhoI, int anhoF) {
		String fecha = "";
		fecha += ThreadLocalRandom.current().nextInt(1, 29) + "/";
		fecha += ThreadLocalRandom.current().nextInt(1, 12) + "/";
		fecha += ThreadLocalRandom.current().nextInt(anhoI, anhoF+1);
		return fecha;
	}
	
	public String generarFechaRes(int anhoI, int anhoF) {
		String fecha = "";
		int mes = ThreadLocalRandom.current().nextInt(1, 12);
		int anho = ThreadLocalRandom.current().nextInt(anhoI, anhoF+1);
		fecha += ThreadLocalRandom.current().nextInt(1, 12) + "/";
		fecha += mes + "/";
		fecha += anho + ",";
		fecha += ThreadLocalRandom.current().nextInt(12, 29) + "/";
		fecha += mes + "/";
		fecha += anho + ",";
		return fecha;
	}

	public String generarRolPersona() {
		String[] roles = {"Estudiante", "Profesor"};
		return roles[ThreadLocalRandom.current().nextInt(0, 2)];
	}
	
	public String generarTipoHotelRoom() {
		String[] roles = {"Suite", "Doble", "Sencilla", "Unica y Diferente"};
		return roles[ThreadLocalRandom.current().nextInt(0, 4)];
	}
	
	public int darAlojamiento() {
		double rng = ThreadLocalRandom.current().nextDouble(0, 100);
		if(rng < 37.5) {
			return 2;
		}else if(rng < 62.5)
			return 1;
		else if(rng < 64.583)
			return 3;
		else if(rng < 68.75)
			return 5;
		else if(rng <= 100)
			return 4;
		else
			return -1;
	}
	
	public int darRangoAloja(int rng) {
		switch (rng) {
		case 1:
			return 12000;
		case 2:
			return 18000;
		case 3:
			return 1000;
		case 4:
			return 15000;
		case 5:
			return 2000;
		}
		return 0;
		
	}





}
