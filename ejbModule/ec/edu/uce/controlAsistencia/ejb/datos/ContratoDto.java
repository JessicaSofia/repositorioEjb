package ec.edu.uce.controlAsistencia.ejb.datos;

import java.io.Serializable;
import java.util.Date;


public class ContratoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int cntId;
	private int cntEstado;
	private Date cntFechaFin;
	private Date cntFechaInicio;
	
	
	public int getCntId() {
		return cntId;
	}
	public void setCntId(int cntId) {
		this.cntId = cntId;
	}
	public int getCntEstado() {
		return cntEstado;
	}
	public void setCntEstado(int cntEstado) {
		this.cntEstado = cntEstado;
	}
	public Date getCntFechaFin() {
		return cntFechaFin;
	}
	public void setCntFechaFin(Date cntFechaFin) {
		this.cntFechaFin = cntFechaFin;
	}
	public Date getCntFechaInicio() {
		return cntFechaInicio;
	}
	public void setCntFechaInicio(Date cntFechaInicio) {
		this.cntFechaInicio = cntFechaInicio;
	}
	
	
	
	

}
