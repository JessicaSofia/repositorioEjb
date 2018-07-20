package ec.edu.uce.controlAsistencia.ejb.datos;

import java.io.Serializable;
import java.sql.Date;

import java.sql.Timestamp;

public class ReporteAusencias  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numAccion;
	private String nombres;
	private Timestamp fechaEmision;
	private Date fechaInicio;
	private Date fechaFinal;
	private String Observacion;
	private String conCopia;
	private int Estado;
	private String dependencia;
	private String regimen;
	
	
	
	
	public ReporteAusencias(int numAccion, String nombres, Timestamp fechaEmision, Date fechaInicio, Date fechaFinal,
			String observacion, String conCopia, int estado, String dependencia, String regimen) {
		super();
		this.numAccion = numAccion;
		this.nombres = nombres;
		this.fechaEmision = fechaEmision;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		Observacion = observacion;
		this.conCopia = conCopia;
		Estado = estado;
		this.dependencia = dependencia;
		this.regimen = regimen;
	}
	public int getNumAccion() {
		return numAccion;
	}
	public void setNumAccion(int numAccion) {
		this.numAccion = numAccion;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public Timestamp getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Timestamp fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	public String getDependencia() {
		return dependencia;
	}
	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}
	public String getRegimen() {
		return regimen;
	}
	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}
	public String getObservacion() {
		return Observacion;
	}
	public void setObservacion(String observacion) {
		Observacion = observacion;
	}
	public String getConCopia() {
		return conCopia;
	}
	public void setConCopia(String conCopia) {
		this.conCopia = conCopia;
	}
	public int getEstado() {
		return Estado;
	}
	public void setEstado(int estado) {
		Estado = estado;
	}

	
	
	
	

}
