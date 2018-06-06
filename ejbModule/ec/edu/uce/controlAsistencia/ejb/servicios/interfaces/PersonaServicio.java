  package ec.edu.uce.controlAsistencia.ejb.servicios.interfaces;

import java.util.List;

import ec.edu.uce.controlAsistencia.ejb.datos.PersonaDto;

public interface PersonaServicio {  
	
	/**
	 * Busqueda de informacion de Detalle Puesto del Empleado  Por Nombres
	 * @return
	 */
	public List<PersonaDto> BuscarPorNombres(String nombres);

}
