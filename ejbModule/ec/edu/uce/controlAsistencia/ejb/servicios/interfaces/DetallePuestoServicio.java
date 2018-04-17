package ec.edu.uce.controlAsistencia.ejb.servicios.interfaces;

import java.util.List;

import ec.edu.uce.controlAsistencia.jpa.entidades.*;;

public interface DetallePuestoServicio {

	/**
	 * Busqueda de informacion de Detalle Puesto del Empleado  Por Nombres
	 * @return
	 */
	public List<DetallePuesto> BuscarLstPorNombres(String nombres);
	
	/**
	 * Busqueda de Informacion de Detalle Puesto del Empleado por Apellidos
	 * @return
	 */
	public List<DetallePuesto> BuscarLstPorApellidos(String apellidos);
	
}
