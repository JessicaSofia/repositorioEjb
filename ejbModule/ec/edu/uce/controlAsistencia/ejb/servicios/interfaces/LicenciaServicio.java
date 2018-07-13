package ec.edu.uce.controlAsistencia.ejb.servicios.interfaces;

import java.util.List;

import ec.edu.uce.controlAsistencia.jpa.entidades.Licencia;


public interface LicenciaServicio { 
	
	
	/***
	 * Inserta un objeto de Tipo LicenciaYPermiso
	 * @param licencia
	 * @return
	 */
	public boolean  LicenciaInsertar(Licencia licencia);
	
	/***
	 * Obtiene una lista de Tipo LicenciaPermiso Por DetallePuestoId
	 * @param detallePuestoId
	 * @return
	 */
	public List<Licencia > ListaLicenciaPorDetallePuestoId(int  detallePuestoId );
	
	/***
	 * Actualiza un objet de Tipo licenciaYPermiso
	 * @param licenciaYPermiso
	 * @return
	 */
	public Licencia LicenciaActualizar(Licencia licencia);
	
	 /***
	  * Obtiene el Numero de Autorizacion de una licenciaYPermio
	  * @return
	  */
	public int  MaximaNumAutorizacion();

}
