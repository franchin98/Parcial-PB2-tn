package com.transporte.empresa;

import java.util.LinkedList;

import com.transporte.vehiculos.Vehiculo;

public class Empresa {
	
	private LinkedList<Vehiculo> vehiculosDeLaEmpresa;

	public Empresa() {
		vehiculosDeLaEmpresa = new LinkedList<Vehiculo>();
	}
	
	public void agregarVehiculoALaFlota(Vehiculo nuevo) {
		vehiculosDeLaEmpresa.add(nuevo);
	}

	public LinkedList<Vehiculo> getVehiculosDeLaEmpresa() {
		return vehiculosDeLaEmpresa;
	}
	
	
	
}
