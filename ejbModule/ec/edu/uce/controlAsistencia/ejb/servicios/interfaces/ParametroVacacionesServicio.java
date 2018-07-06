package ec.edu.uce.controlAsistencia.ejb.servicios.interfaces;

import ec.edu.uce.controlAsistencia.ejb.datos.ParametroVacacionesDto;
import ec.edu.uce.controlAsistencia.jpa.entidades.ParametroVacaciones;

public interface ParametroVacacionesServicio {

	/***
	 * Obtiene un objeto de tipo Parametro
	 * @param id
	 * @param rgmId
	 * @return
	 */
	public ParametroVacacionesDto buscarPorId(int prvcId, int rgmId);
}
