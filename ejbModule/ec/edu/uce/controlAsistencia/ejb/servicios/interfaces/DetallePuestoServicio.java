package ec.edu.uce.controlAsistencia.ejb.servicios.interfaces;

import java.util.List;

import ec.edu.uce.controlAsistencia.ejb.datos.DetallePuestoDto;
import ec.edu.uce.controlAsistencia.jpa.entidades.*;;

public interface DetallePuestoServicio {

	 
	
	/**                                                                   
	 * Busqueda de Informacion de Detalle Puesto del Empleado por Apellidos
	 * @return
	 */
	public List<DetallePuesto> BuscarLstPorApellidos(String apellidos);
	
	public DetallePuestoDto BuscarPorId(int id);
	
	
	public DetallePuesto DetallePuestoBuscarPorId(int id) ;
}
