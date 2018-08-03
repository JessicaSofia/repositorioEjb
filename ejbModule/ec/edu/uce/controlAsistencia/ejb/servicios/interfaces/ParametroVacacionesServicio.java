package ec.edu.uce.controlAsistencia.ejb.servicios.interfaces;


import ec.edu.uce.controlAsistencia.jpa.entidades.ParametroVacacionRegimen;


public interface ParametroVacacionesServicio {

	/***
	 * Obtiene un objeto de tipo Parametro
	 * @param id
	 * @param rgmId
	 * @return
	 */
	public ParametroVacacionRegimen buscarPorId(int prvcId, int rgmId);
}
