package ec.edu.uce.controlAsistencia.ejb.servicios.interfaces;

import ec.edu.uce.controlAsistencia.ejb.datos.AccionPersonalDto;
import ec.edu.uce.controlAsistencia.ejb.datos.ContratoDto;
import ec.edu.uce.controlAsistencia.jpa.entidades.Contrato;

public interface ContratoServicio {

	/***
	 * obtine una entidad de tipo Contrato por Detalle Puesto Id
	 * @param dtpsId
	 * @return
	 */
	public Contrato obtenerporDetallePuestoId(int dtpsId);
	
	/***
	 * Obtine una entidad de tipo de Contrato por Id
	 * @param id
	 * @return
	 */
	public ContratoDto obtenerPorId(int id);
	/***
	 * Obtine el accion de personal por detallePuestoId
	 * @param dtpsId
	 * @return
	 */
	public AccionPersonalDto  obtenerAccionPersonal(int dtpsId);
	
}
