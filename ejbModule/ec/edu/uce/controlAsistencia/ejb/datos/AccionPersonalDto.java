package ec.edu.uce.controlAsistencia.ejb.datos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import ec.edu.uce.controlAsistencia.jpa.entidades.TipoAccion;

public class AccionPersonalDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long acprId;
	private int acprEstado;
	private Date acprFecha;
	private Date acprFechaPosesion;

	private int tipoAccion;

	public long getAcprId() {
		return acprId;
	}

	public void setAcprId(long acprId) {
		this.acprId = acprId;
	}

	public int getAcprEstado() {
		return acprEstado;
	}

	public void setAcprEstado(int acprEstado) {
		this.acprEstado = acprEstado;
	}

	public Date getAcprFecha() {
		return acprFecha;
	}

	public void setAcprFecha(Date acprFecha) {
		this.acprFecha = acprFecha;
	}

	public Date getAcprFechaPosesion() {
		return acprFechaPosesion;
	}

	public void setAcprFechaPosesion(Date acprFechaPosesion) {
		this.acprFechaPosesion = acprFechaPosesion;
	}

	public int getTipoAccion() {
		return tipoAccion;
	}

	public void setTipoAccion(int tipoAccion) {
		this.tipoAccion = tipoAccion;
	}
	
	


}
