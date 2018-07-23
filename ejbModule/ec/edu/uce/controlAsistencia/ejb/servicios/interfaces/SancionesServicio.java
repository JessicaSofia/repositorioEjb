package ec.edu.uce.controlAsistencia.ejb.servicios.interfaces;

import java.util.List;

import ec.edu.uce.controlAsistencia.jpa.entidades.CategoriaFalta;
import ec.edu.uce.controlAsistencia.jpa.entidades.DetallePuestoSancion;
import ec.edu.uce.controlAsistencia.jpa.entidades.Falta;
import ec.edu.uce.controlAsistencia.jpa.entidades.Sancion;
import ec.edu.uce.controlAsistencia.jpa.entidades.TipoSancion;

public interface SancionesServicio {
	
	/**
	 * Inserta un Objeto de Tipo Sancion
	 * @param sancion
	 * @return
	 */
	public  boolean insertaSancion(DetallePuestoSancion  dtSancion);
	
	/**
	 * Actualiza un objeto de tipo Sancion
	 * @param sancion
	 * @return
	 */
	public DetallePuestoSancion actualizarSancion(DetallePuestoSancion  dtSancion);
	
	/***
	 * Obtiene una lista  de Tipo Sancion por DetallePuesto Id
	 * @param dtpsId
	 * @return
	 */
	public List<DetallePuestoSancion> listarSancionPorDetallePuestoId(int dtpsId);
	
/**
 * obtiene una lista de las Sanciones 
 * @return
 */
	public List<Sancion> listarSancion();
	
	/**
	 * Obtiene una lista de las faltas
	 * @return
	 */
	public List<Falta> listarFalta();
	
	/**
	 * Lista todos por parametros por CategoriaId y  faltaId
	 * @param ctgId
	 * @param ftId
	 * @return
	 */
	public List<CategoriaFalta> listarcategoriaFaltaPorCategoriaIdFaltaId(int ctgId, int ftId);
	
	/**
	 * Genera el  numero de Accion 
	 * @return
	 */
	public int MaximaNumAutorizacion();
	
	/**
	 * Obtine la entidad falta por FaltaId
	 * @param flId
	 * @return
	 */
	public Falta  ObtenerFaltaPorI(int flId);
	
	/**
	 * Obtiene una entidad de tipo Sancion por SancionId
	 * @param snId
	 * @return
	 */
	public Sancion ObtenerSancionPorId(int snId);
	
	/**
	 *Obtiene una lista de sanciones por el TipoSancionId 
	 * @param tpSnId
	 * @return
	 */
	public List<Sancion>  ObtenerLstSancionPorTipoSancionId(int tpSnId);
	
	
	/**
	 * Obtine una lista de todas los tipos de sanciones
	 * @return
	 */
	public List<TipoSancion> ObtenerLstTipoSancionTodo();
	
	/**
	 * Obtine un Lista de Sanciones
	 * @return
	 */
	public List<DetallePuestoSancion> listarDtSancionTodos();
	
	/**
	 * Obtiene una Lista de Sanciones Filtrado por  Año y Mes
	 * @param anio
	 * @param mes
	 * @return
	 */
	public List<DetallePuestoSancion> listarDtSancionPorAnioMes(int anio, int mes);
	
	/**
	 * Obtener una lista de DetallePuestosancion Filtrado por Año, Mes  y Regimen
	 * @param anio
	 * @param mes
	 * @param rgmId
	 * @return
	 */
	public List<DetallePuestoSancion> listarDtSancionPorAnioMesRegimenId(int anio, int mes, int rgmId);
	
	/**
	 * Obtiene una Lista de DetallePuestoSancion Filtrado  por Año, Mes, Regimen y Tipo de Sancion 
	 * @param anio
	 * @param mes
	 * @param rgmId
	 * @param tpsnId
	 * @return
	 */
	public List<DetallePuestoSancion> listarDtSancionPorAnioMesRegimenIdTipoSancionId(int  anio, int mes, int  rgmId, int  tpsnId);
	
	/**
	 *  Obtiene una lista de DetallePuesto Sancion friltrado por Año, mes y tipo de Sancion
	 * @param anio
	 * @param mes
	 * @param tpsnId
	 * @return
	 */
	public List<DetallePuestoSancion> listarDtSancionPorAnioMesTipoSancionId(int anio, int  mes, int  tpsnId);
	
	
	
	
	
}
