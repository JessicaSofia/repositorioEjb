package ec.edu.uce.controlAsistencia.ejb.servicios.interfaces;

import java.util.List;

import ec.edu.uce.controlAsistencia.jpa.entidades.TipoLicencia;

public interface TipoLicenciaServicio {
	
	/***
	 * Obtiene la lista de los Tipos de Licencia
	 * 
	 */
	
	public List<TipoLicencia> listarTipoLicencia(int id_regimen);
	
	/***
	 * Busca un objeto TipoLicencia a través del ID
	 * 
	 */
	public TipoLicencia buscarTipoLicenciaPorId(int id_tipo_licencia);

	/**
	 * Obtiene la lista de los hijos, dado el padre 
	 * 
	 */
	public List<TipoLicencia> buscarTipoLicenciaPorPadre(int id_padre);
	
	

}
