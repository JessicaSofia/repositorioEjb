package ec.edu.uce.controlAsistencia.ejb.servicios.interfaces;

import java.util.List;

import ec.edu.uce.controlAsistencia.ejb.datos.ReporteAusencias;


public interface ReportesAusenciasServicios {

	public List<ReporteAusencias> obtenerListPorAnioMesTodos(int anio, int mes);
	public List<ReporteAusencias> obtenerListPorAnioMesvacacion(int anio, int mes);

	public List<ReporteAusencias> obtenerListPorAnioMesPermiso(int anio, int mes);

	public List<ReporteAusencias> obtenerListPorAnioMesLicencia(int anio, int mes);
	public List<ReporteAusencias> obtenerListPorAnioMesvacacionPermiso(int anio, int mes);

	public List<ReporteAusencias> obtenerListPorAnioMesPermisoLicencia(int anio, int mes);

	public List<ReporteAusencias> obtenerListPorAnioMesVacacionLicencia(int anio, int mes);
	
	
}
