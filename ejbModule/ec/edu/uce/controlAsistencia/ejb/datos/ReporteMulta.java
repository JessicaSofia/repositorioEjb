package ec.edu.uce.controlAsistencia.ejb.datos;

public class ReporteMulta {

	private String falta;
	private int frecuencia;
	private String fechas;
	private String observaciones;
	public String getFalta() {
		return falta;
	}
	public void setFalta(String falta) {
		this.falta = falta;
	}
	public int getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}
	public String getFechas() {
		return fechas;
	}
	public void setFechas(String fechas) {
		this.fechas = fechas;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
