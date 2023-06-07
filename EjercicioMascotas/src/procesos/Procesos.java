package procesos;
import java.util.HashMap;

import javax.swing.JOptionPane;

import clases.Mascota;

public class Procesos {
	HashMap<String, Mascota> mapaMascotas;
	String menu ="", especie, nombre, id, buscarId;
	int opcion, cantidadMascotas, edad;
	Mascota mascota;

	public Procesos() {
		mapaMascotas = new HashMap<String, Mascota>();
		menuPrograma();
	}

	public void ingresarMascota() {
		cantidadMascotas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de mascotas"));
		for (int i = 0; i < cantidadMascotas; i++) {
			id = JOptionPane.showInputDialog("Ingrese la identificacion de la mascota");
			nombre = JOptionPane.showInputDialog("Ingrese el nombre de la mascota");
			edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de la mascota"));
			especie = JOptionPane.showInputDialog("Ingrese la especie de la mascota");
			mascota = new Mascota(id, nombre, edad, especie);
			mapaMascotas.put(id, mascota);
		}

	}

	public void imprimirListaCompleta() {
		for (Mascota mascota : mapaMascotas.values()) {
			System.out.println("---------Informacion Mascota------------");
			System.out.println("ID mascota:" + mascota.getId());
			System.out.println("Nombre: " + mascota.getNombre());
			System.out.println("Edad: " + mascota.getEdad());
			System.out.println("Especie: " + mascota.getEspecie());
			System.out.println("-----------------------------------------");
		}
	}

	public void consultarMascota() {
		buscarId = JOptionPane.showInputDialog("Ingrese el documento de la mascota a buscar");
		boolean encontrado = false;
		for (String id : mapaMascotas.keySet()) {
			if (id.equalsIgnoreCase(buscarId)) {
				mascota = mapaMascotas.get(id);
				System.out.println("---------Informacion Mascota------------");
				System.out.println("ID mascota:" + mascota.getId());
				System.out.println("Nombre: " + mascota.getNombre());
				System.out.println("Edad: " + mascota.getEdad());
				System.out.println("Especie: " + mascota.getEspecie());
				System.out.println("-----------------------------------------");
				mascota.estadoMascota();
				mascota.jugarMascota();
				mascota.estadoMascota();
				encontrado = true;
			}
		}

		if (!encontrado) {
			System.out.println("No se encuentra registrado la mascota con identificacion: " + buscarId);
		}

	}

	public void actualizarMascota() {

		buscarId = JOptionPane.showInputDialog("Ingrese el documento de la mascota actualizar");
		boolean encontrado = false;
		
		for (String id : mapaMascotas.keySet()) {
			if (id.equalsIgnoreCase(buscarId)) {
				mascota = mapaMascotas.get(id);
				String menu = "Que desea actualizar de la mascota" + "\n";
				menu += "1. nombre" + "\n";
				menu += "2. edad" + "\n";
				menu += "3. especie" + "\n";

				int opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
				switch (opcion) {
				case 1:
					String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre para la mascota");
					mascota.setNombre(nuevoNombre);
					break;
				case 2:
					int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva edad de la mascota"));
					mascota.setEdad(edad);
					break;
				case 3:
					String especie = JOptionPane.showInputDialog("Ingrese la nueva especie la mascota");
					mascota.setEspecie(especie);
					break;

				default:
					System.out.println("Opcion invalida");
					break;
				}
				encontrado = true;
			} 
		}
			if (!encontrado) 
			{
				System.out.println("No se encuentra registrado la mascota con identificacion: " + buscarId);
			}

		}


	private void menuPrograma() {
		menu += "---------Bienvenido al programa de mascotas---------" + "\n";
		menu += "1. Registrar mascotas" + "\n";
		menu += "2. Imprimir Lista Completa" + "\n";
		menu += "3. Consultar mascota" + "\n";
		menu += "4. Actualizar mascota" + "\n";
		menu += "5. Salir" + "\n";

		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

			switch (opcion) {
			case 1:
				ingresarMascota();
				break;
			case 2:
				if (!mapaMascotas.isEmpty()) {
					imprimirListaCompleta();
				} else {
					JOptionPane.showMessageDialog(null, "No hay mascota registradas", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case 3:
				if (!mapaMascotas.isEmpty()) {
					consultarMascota();
				} else {
					JOptionPane.showMessageDialog(null, "No hay mascota registradas", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case 4:
				if (!mapaMascotas.isEmpty()) {
					actualizarMascota();
				} else {
					JOptionPane.showMessageDialog(null, "No hay mascota registradas", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
				break;
			case 5:
				JOptionPane.showMessageDialog(null, "¡Gracias por usar el programa!");
				break;
			default:
				JOptionPane.showMessageDialog(null, "¡Opcion invalida!");
				break;
			}
		} while (opcion != 5);

	}

}
