package clases;

public class Mascota {
	
	private String nombre,especie,id;
	private int edad;
	private boolean estadoMascota = false;
	
	
	public Mascota () {
	}

	public Mascota (String id, String nombre, int edad, String especie) {
		setId(id);
		setNombre(nombre);
		setEdad(edad);
		setEspecie(especie);
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	public String getEspecie() {
		return especie;
	}
	
	public boolean isEstadoMascota() {
		return estadoMascota;
	}

	public void setEstadoMascota(boolean estadoMascota) {
		this.estadoMascota = estadoMascota;
	}
	
	
	public void hacerSonido () {
		
		if (especie.equalsIgnoreCase("Perro")) {
			System.out.println("¡Guau guau!");
		}
		else if (especie.equalsIgnoreCase("gato")) {
			System.out.println("¡Miau Miau!");
		}
		
	}
	
	
	public void jugarMascota() {
		estadoMascota = true;
		System.out.println("Estoy jugando con mi mascota "+ nombre);

	}
	
	
	public void estadoMascota() {
		if (estadoMascota == false) {
			System.out.println("¡Tu mascota esta triste debes jugar con ella!");
		} else {
			System.out.println("¡Tu mascota esta feliz junto a tu lado!");
		}

	}
	
	
}
