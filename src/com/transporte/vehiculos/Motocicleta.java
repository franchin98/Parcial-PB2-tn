package com.transporte.vehiculos;

import com.transporte.personas.Acompaniante;
import com.transporte.personas.Chofer;
import com.transporte.personas.Persona;

public class Motocicleta extends Vehiculo {

	private Acompaniante acompanianteDelChofer;

	public Motocicleta(Chofer choferDeLaMoto, Acompaniante acompaniante) {
		super(choferDeLaMoto);
		agregarPasajero(acompaniante);
	}

	public Motocicleta(Chofer choferDeLaMoto) {
		super(choferDeLaMoto);
	}

	@Override
	public Boolean cambiarChoferDelVehiculo(Chofer nuevo) {
		if (getAcompanianteDelChofer() == null) {
			setChoferDelVehiculo(nuevo);
			return true;
		}
		return false;
	}

	public Acompaniante getAcompanianteDelChofer() {
		return acompanianteDelChofer;
	}

	@Override
	public Boolean agregarPasajero(Persona nuevoPasajero) {
		if (getChoferDelVehiculo() != null) {
			this.acompanianteDelChofer = (Acompaniante) nuevoPasajero;
			return true;
		}

		return false;
	}

}
