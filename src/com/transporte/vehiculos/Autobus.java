package com.transporte.vehiculos;

import java.util.LinkedList;

import com.transporte.personas.Chofer;
import com.transporte.personas.Pasajero;
import com.transporte.personas.Persona;

public final class Autobus extends Vehiculo {

	private LinkedList<Persona> pasajerosABordo;

	public Autobus(Chofer choferDelVehiculo) {
		super(choferDelVehiculo);
		setPasajerosABordo(new LinkedList<Persona>());
	}

	@Override
	public Boolean cambiarChoferDelVehiculo(Chofer nuevo) {
		if (getPasajerosABordo().size() == 0) {
			setChoferDelVehiculo(nuevo);
			return true;
		}
		return false;
	}

	public LinkedList<Persona> getPasajerosABordo() {
		return pasajerosABordo;
	}

	public Boolean agregarPasajero(Pasajero nuevo) {
		if (getPasajerosABordo().size() < 20) {
			pasajerosABordo.addLast(nuevo);
			return true;
		}
		return false;
	}

	private void setPasajerosABordo(LinkedList<Persona> pasajerosABordo) {
		this.pasajerosABordo = pasajerosABordo;
	}

	@Override
	public Boolean agregarPasajero(Persona nuevoPasajero) {
		// TODO Auto-generated method stub
		return null;
	}

}
