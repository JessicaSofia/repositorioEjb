package ec.edu.uce.controlAsistencia.ejb.datos;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReporteSancion  implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int dtpsSnId;
	private  int dtpsId;
	private int  numSancion;
	private String identificacion;
	private String Nombres;
	private String dias;
	private float valor;
	private String cargo;
	private String dependencia;
	private int frecuencia;
	private String sancion;
	private List<String> faltas;
	private List<ReporteSancion> lstSanciones;
	
	
	

	
	
	
	
	

	public ReporteSancion(int dtpsId, String identificacion, String nombres, float valor, String cargo, String dependencia) {
		super();
		this.identificacion = identificacion;
		Nombres = nombres;
		this.valor = valor;
		this.cargo = cargo;
		this.dependencia = dependencia;
		this.dtpsId=dtpsId;
	}
	
	public ReporteSancion(int dtpsId, String identificacion, String nombres, int frecuencia, String cargo, String dependencia) {
		super();
		this.identificacion = identificacion;
		Nombres = nombres;
		this.frecuencia = frecuencia;
		this.cargo = cargo;
		this.dependencia = dependencia;
		this.dtpsId=dtpsId;
	}


	 public ReporteSancion(int dtpsId, String identificacion, String nombres, float valor, String cargo, String dependencia, List<ReporteSancion> faltas) {
			super();
			this.identificacion = identificacion;
			Nombres = nombres;
			this.valor = valor;
			this.cargo = cargo;
			this.dependencia = dependencia;
			this.dtpsId=dtpsId;
			this.lstSanciones=faltas;
		}
	 
	
	 
	 
		
	public ReporteSancion() {
		super();
		// TODO Auto-generated constructor stub
	}

	 
	public int getDtpsId() {
		return dtpsId;
	}


	public void setDtpsId(int dtpsId) {
		this.dtpsId = dtpsId;
	}


	public int getDtpsSnId() {
		return dtpsSnId;
	}
	public void setDtpsSnId(int dtpsSnId) {
		this.dtpsSnId = dtpsSnId;
	}
	public int getNumSancion() {
		return numSancion;
	}
	public void setNumSancion(int numSancion) {
		this.numSancion = numSancion;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public String getNombres() {
		return Nombres;
	}
	public void setNombres(String nombres) {
		Nombres = nombres;
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
	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getDependencia() {
		return dependencia;
	}
	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}
	public int getFrecuencia() {
		return frecuencia;
	}
	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}

	public String getSancion() {
		return sancion;
	}

	public void setSancion(String sancion) {
		this.sancion = sancion;
	}


	public List<ReporteSancion> getLstSanciones() {
		return lstSanciones;
	}


	public void setLstSanciones(List<ReporteSancion> lstSanciones) {
		this.lstSanciones = lstSanciones;
	}

	public List<String> getFaltas() {
		return faltas;
	}

	public void setFaltas(List<String> faltas) {
		this.faltas = faltas;
	}
	
	
	
	
	

}
