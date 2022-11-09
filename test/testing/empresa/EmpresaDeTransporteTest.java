package testing.empresa;

import static org.junit.Assert.*;

import org.junit.Test;

import com.transporte.empresa.Empresa;
import com.transporte.personas.Acompaniante;
import com.transporte.personas.Chofer;
import com.transporte.personas.Pasajero;
import com.transporte.vehiculos.Autobus;
import com.transporte.vehiculos.Automovil;
import com.transporte.vehiculos.Motocicleta;

public class EmpresaDeTransporteTest {

	private final Integer PASAJEROS_A_SUBIR = 5;
	private final Integer VEINTE_PASAJEROS = 20;
	private final Integer TRES_PASAJEROS = 3;

	@Test
	public void quePuedaCambiarDeChoferSiLaMotoNoTieneAcompaniante() {
		Motocicleta nuevaMoto = dadoQueExisteUnaMotoConChoferSinAcompaniante(new Chofer("Franco"));
		entoncesPuedoCambiarDeChoferEn(nuevaMoto, new Chofer("Nuevo"));

	}

	@Test
	public void queNoPuedaCambiarDeChoferSiLaMotocicletaTieneAcompaniante() {
		Empresa empresaDeTransporte = dadoQueExisteUnaEmpresa();
		cuandoAgregoUnaMotocicletaConChoferYAcompanianteEn(empresaDeTransporte);
		entoncesNoPuedeCambiarDeChoferSiTieneAcompaniante(empresaDeTransporte);
	}

	@Test
	public void queNoPuedaCambiarDeChoferSiElAutobusTienePasajeros() {
		Autobus nuevoAutobus = dadoQueExisteUnAutobusConChofer(new Chofer("Carlos"));
		cuandoSubenPasajerosEn(nuevoAutobus, PASAJEROS_A_SUBIR);
		entoncesNoPuedeCambiarseElChoferEn(nuevoAutobus);
	}

	@Test
	public void quePuedaAgregarPasajerosAlAutobus() {
		Autobus nuevoAutobus = dadoQueExisteUnAutobusConChofer(new Chofer("Carlos"));
		cuandoSubenPasajerosEn(nuevoAutobus, PASAJEROS_A_SUBIR);
		entoncesExistenPasajerosABordoEn(nuevoAutobus);
	}

	@Test
	public void queNoPuedanIngresarMasPasajerosAlAutobus() {
		Autobus nuevoAutobus = dadoQueExisteUnAutobusConChofer(new Chofer("Carlos"));
		cuandoSubenPasajerosEn(nuevoAutobus, VEINTE_PASAJEROS);
		entoncesNoPuedenSubirMasPasajerosSiElAutobusEstaCompleto(nuevoAutobus);
	}

	@Test
	public void quePuedaAgregarPasajerosAlAutomovil() {
		Automovil nuevoAutomovil = dadoQueExisteUnAutomovilConChofer(new Chofer("Franco"));
		cuandoSubenPasajerosAlAutomovil(nuevoAutomovil, TRES_PASAJEROS);
		entonocesExistenPasajerosABordoEn(nuevoAutomovil);
	}

	@Test
	public void queNoPuedanIngresarMasPasajerosAlAuto() {
		Automovil nuevoAutomovil = dadoQueExisteUnAutomovilConChofer(new Chofer("Franco"));
		cuandoSubenPasajerosAlAutomovil(nuevoAutomovil, TRES_PASAJEROS);
		entoncesNoPuedenSubirMasPasajerosEn(nuevoAutomovil);
	}

	private void entoncesNoPuedenSubirMasPasajerosEn(Automovil nuevoAutomovil) {
		assertEquals(false, nuevoAutomovil.agregarPasajero(new Pasajero("Que no entra")));

	}

	private void cuandoSubenPasajerosAlAutomovil(Automovil nuevoAutomovil, Integer cantidadDePasajeros) {
		for (Integer i = 0; i < cantidadDePasajeros; i++) {
			nuevoAutomovil.agregarPasajero(new Pasajero("Franco"));
		}
	}

	private Automovil dadoQueExisteUnAutomovilConChofer(Chofer choferDelAutomovil) {
		return new Automovil(choferDelAutomovil);
	}

	private void entonocesExistenPasajerosABordoEn(Automovil nuevoAutomovil) {
		assertTrue(nuevoAutomovil.getPasajerosABordo().size() > 0);
	}

	private void entoncesNoPuedenSubirMasPasajerosSiElAutobusEstaCompleto(Autobus nuevoAutobus) {
		assertEquals(false, nuevoAutobus.agregarPasajero(new Pasajero("ultimo")));
	}

	private void entoncesNoPuedeCambiarseElChoferEn(Autobus nuevoAutobus) {
		assertEquals(false, nuevoAutobus.cambiarChoferDelVehiculo(new Chofer("nuevo")));
	}

	private void cuandoSubenPasajerosEn(Autobus nuevoAutobus, Integer cantidadDePasajeros) {
		for (Integer i = 0; i < cantidadDePasajeros; i++) {
			nuevoAutobus.agregarPasajero(new Pasajero("carlos"));
		}
	}

	private Autobus dadoQueExisteUnAutobusConChofer(Chofer choferDelAutobus) {
		return new Autobus(choferDelAutobus);
	}

	private void entoncesExistenPasajerosABordoEn(Autobus nuevoAutobus) {
		assertTrue(nuevoAutobus.getPasajerosABordo().size() > 0);
	}

	private void entoncesNoPuedeCambiarDeChoferSiTieneAcompaniante(Empresa empresaDeTransporte) {
		assertFalse(
				empresaDeTransporte.getVehiculosDeLaEmpresa().getFirst().cambiarChoferDelVehiculo(new Chofer("pepe")));
	}
	
	private Motocicleta dadoQueExisteUnaMotoConChoferSinAcompaniante(Chofer chofer) {
		return new Motocicleta(chofer);
	}
	
	private void entoncesPuedoCambiarDeChoferEn(Motocicleta nuevaMoto, Chofer chofer) {
		assertTrue(nuevaMoto.cambiarChoferDelVehiculo(chofer));
	}
	
	private void cuandoAgregoUnaMotocicletaConChoferYAcompanianteEn(Empresa empresaDeTransporte) {
		empresaDeTransporte.agregarVehiculoALaFlota(new Motocicleta(new Chofer("Carlos"), new Acompaniante("Franco")));
	}

	private Empresa dadoQueExisteUnaEmpresa() {
		return new Empresa();
	}


}
