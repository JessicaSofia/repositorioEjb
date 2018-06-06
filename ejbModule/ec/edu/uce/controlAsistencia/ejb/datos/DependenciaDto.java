package ec.edu.uce.controlAsistencia.ejb.datos;

import java.io.Serializable;
import java.math.BigDecimal;

import ec.edu.uce.controlAsistencia.jpa.entidades.Dependencia;

public class DependenciaDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int dpnId;
	private int depDpnId;
	private String dpnDescripcion;
	private int  dpnTipo;
	
	public DependenciaDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DependenciaDto(int dpnId, int depDpnId, String dpnDescripcion, int dpnTipo) {
		super();
		this.dpnId = dpnId;
		this.depDpnId = depDpnId;
		this.dpnDescripcion = dpnDescripcion;
		this.dpnTipo = dpnTipo;
	}

	public int getDpnId() {
		return dpnId;
	}

	public void setDpnId(int dpnId) {
		this.dpnId = dpnId;
	}

	public int getDepDpnId() {
		return depDpnId;
	}

	public void setDepDpnId(int depDpnId) {
		this.depDpnId = depDpnId;
	}

	public String getDpnDescripcion() {
		return dpnDescripcion;
	}

	public void setDpnDescripcion(String dpnDescripcion) {
		this.dpnDescripcion = dpnDescripcion;
	}

	public int getDpnTipo() {
		return dpnTipo;
	}

	public void setDpnTipo(int dpnTipo) {
		this.dpnTipo = dpnTipo;
	}
	
	

}
