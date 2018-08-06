package ec.edu.uce.controlAsistencia.ejb.servicios.interfaces;

import java.util.List;

import ec.edu.uce.controlAsistencia.ejb.datos.ReporteSancion;
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
	
	public Falta ObtenerFaltaPorNombre(String Nombre);
	
	
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
	 * Obtiene una Lista de DetallePuestoSancion Filtrado  por Año, Mes, Regimen y Tipo de Sancion 
	 * @param anio
	 * @param mes
	 * @param rgmId
	 * @param tpsnId
	 * @return
	 */
	public List<ReporteSancion> listarDtSancionPorAnioMesRegimenIdTipoSancionId(int  anio, int mes, int  rgmId, int  tpsnId);
	
	public List<ReporteSancion> listarDtSancionPorAnioMesRegimenIdTipoSancionIdNoAgrupado(int  anio, int mes, int  rgmId, int  tpsnId);
	
	
	public String DiasSancionPorTpSancionIdFaltaId(int tpSnId, int flId, int dtpsId, int anio, int mes);
	
	public List<ReporteSancion> listarDtSancionAnualPorAnioMes(int anioInicio, int mesInicio, int  anioFin, int mesFin);
	
	
	 
	public List<ReporteSancion> listarDtSancionAnualPorAnioMesRegimenIdTipoSancionId(int anio, int mes, int rgmId, int tpSnId, int mesFin);
	       

	/**
	 * Obtiene  un objeto de tipo sancion siendo este el ultimo aplicado por detallePuestoId
	 * @param tpSn
	 * @return
	 */
	public DetallePuestoSancion obtenerUltimaSancion(int dtpsId );
	
	/**
	 * Obtine un entidad dee tipo DetallePuestoSancion por Mes, anio, categoriaFalta y detallePuesto Id
	 * @param dtpsId
	 * @param ctgflId
	 * @param mes
	 * @param anio
	 * @return
	 */
	public DetallePuestoSancion obtenerSancionPorMesAnio(int dtpsId,int ctgflId, int mes,int anio);
	
	/**
	 * Obtner sueldo por dtpsId
	 * @param dtpsId
	 * @return
	 */
	public  int ObtnerSueldoPorDetallePuestoId(int dtpsId);
	

}
