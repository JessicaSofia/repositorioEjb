package ec.edu.uce.controlAsistencia.ejb.datos;

public class ReporteSancionPdf {

	private String falta;
	private String sancion;
	private int anio;
	private String mes;
	private String dias;
	private float valor;
	private String observaciones;
	public String getFalta() {
		return falta;
	}
	public void setFalta(String falta) {
		this.falta = falta;
	}
	public String getSancion() {
		return sancion;
	}
	public void setSancion(String sancion) {
		this.sancion = sancion;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public String getDias() {
		return dias;
	}
	public void setDias(String dias) {
		this.dias = dias;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
	
}
