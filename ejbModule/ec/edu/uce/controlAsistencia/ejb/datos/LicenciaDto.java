package ec.edu.uce.controlAsistencia.ejb.datos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;


public class LicenciaDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int lcprId;
	private int dtpsId;
	private int tplcId;
	private int lcprNumLicencia;
	private Timestamp lcprFechaEmision;
	private int lcprNumDias;
	private Date lcprFechaInicio;
	private Date lcprFechaFin;
	private Date lcprNumHoras;
	private Date lcprHoraInicio;
	private Date lcprHoraFin;
	private String lcprExplicacion;
	private String lcprObservacion;
	private String lcprCopia;
	private int lcprCargoVacaciones;
	private int tplcEstado;
	private String lcprObservacionEstado;
	
	
	public LicenciaDto(){
		super();
	}

	public LicenciaDto(int lcprId, int dtpsId, int tplcId, int lcprNumLicencia, Timestamp lcprFechaEmision,
			int lcprNumDias, Date lcprFechaInicio, Date lcprFechaFin, Date lcprNumHoras, Date lcprHoraInicio,
			Date lcprHoraFin, String lcprExplicacion, String lcprObservacion, String lcprCopia, int lcprCargoVacaciones,
			int tplcEstado, String lcprObservacionEstado) {
		super();
		this.lcprId = lcprId;
		this.dtpsId = dtpsId;
		this.tplcId = tplcId;
		this.lcprNumLicencia = lcprNumLicencia;
		this.lcprFechaEmision = lcprFechaEmision;
		this.lcprNumDias = lcprNumDias;
		this.lcprFechaInicio = lcprFechaInicio;
		this.lcprFechaFin = lcprFechaFin;
		this.lcprNumHoras = lcprNumHoras;
		this.lcprHoraInicio = lcprHoraInicio;
		this.lcprHoraFin = lcprHoraFin;
		this.lcprExplicacion = lcprExplicacion;
		this.lcprObservacion = lcprObservacion;
		this.lcprCopia = lcprCopia;
		this.lcprCargoVacaciones = lcprCargoVacaciones;
		this.tplcEstado = tplcEstado;
		this.lcprObservacionEstado = lcprObservacionEstado;
	}

	@Override
	public String toString() {
		return "LicenciaDto [lcprId=" + lcprId + ", dtpsId=" + dtpsId + ", tplcId=" + tplcId + ", lcprNumLicencia="
				+ lcprNumLicencia + ", lcprFechaEmision=" + lcprFechaEmision + ", lcprNumDias=" + lcprNumDias
				+ ", lcprFechaInicio=" + lcprFechaInicio + ", lcprFechaFin=" + lcprFechaFin + ", lcprNumHoras="
				+ lcprNumHoras + ", lcprHoraInicio=" + lcprHoraInicio + ", lcprHoraFin=" + lcprHoraFin
				+ ", lcprExplicacion=" + lcprExplicacion + ", lcprObservacion=" + lcprObservacion + ", lcprCopia="
				+ lcprCopia + ", lcprCargoVacaciones=" + lcprCargoVacaciones + ", tplcEstado=" + tplcEstado
				+ ", lcprObservacionEstado=" + lcprObservacionEstado + "]";
	}

	/*Getter & Setter*/
	public int getLcprId() {
		return lcprId;
	}

	public void setLcprId(int lcprId) {
		this.lcprId = lcprId;
	}

	public int getDtpsId() {
		return dtpsId;
	}

	public void setDtpsId(int dtpsId) {
		this.dtpsId = dtpsId;
	}

	public int getTplcId() {
		return tplcId;
	}

	public void setTplcId(int tplcId) {
		this.tplcId = tplcId;
	}

	public int getLcprNumLicencia() {
		return lcprNumLicencia;
	}

	public void setLcprNumLicencia(int lcprNumLicencia) {
		this.lcprNumLicencia = lcprNumLicencia;
	}

	public Timestamp getLcprFechaEmision() {
		return lcprFechaEmision;
	}

	public void setLcprFechaEmision(Timestamp lcprFechaEmision) {
		this.lcprFechaEmision = lcprFechaEmision;
	}

	public int getLcprNumDias() {
		return lcprNumDias;
	}

	public void setLcprNumDias(int lcprNumDias) {
		this.lcprNumDias = lcprNumDias;
	}

	public Date getLcprFechaInicio() {
		return lcprFechaInicio;
	}

	public void setLcprFechaInicio(Date lcprFechaInicio) {
		this.lcprFechaInicio = lcprFechaInicio;
	}

	public Date getLcprFechaFin() {
		return lcprFechaFin;
	}

	public void setLcprFechaFin(Date lcprFechaFin) {
		this.lcprFechaFin = lcprFechaFin;
	}

	public Date getLcprNumHoras() {
		return lcprNumHoras;
	}

	public void setLcprNumHoras(Date lcprNumHoras) {
		this.lcprNumHoras = lcprNumHoras;
	}

	public Date getLcprHoraInicio() {
		return lcprHoraInicio;
	}

	public void setLcprHoraInicio(Date lcprHoraInicio) {
		this.lcprHoraInicio = lcprHoraInicio;
	}

	public Date getLcprHoraFin() {
		return lcprHoraFin;
	}

	public void setLcprHoraFin(Date lcprHoraFin) {
		this.lcprHoraFin = lcprHoraFin;
	}

	public String getLcprExplicacion() {
		return lcprExplicacion;
	}

	public void setLcprExplicacion(String lcprExplicacion) {
		this.lcprExplicacion = lcprExplicacion;
	}

	public String getLcprObservacion() {
		return lcprObservacion;
	}

	public void setLcprObservacion(String lcprObservacion) {
		this.lcprObservacion = lcprObservacion;
	}

	public String getLcprCopia() {
		return lcprCopia;
	}

	public void setLcprCopia(String lcprCopia) {
		this.lcprCopia = lcprCopia;
	}

	public int getLcprCargoVacaciones() {
		return lcprCargoVacaciones;
	}

	public void setLcprCargoVacaciones(int lcprCargoVacaciones) {
		this.lcprCargoVacaciones = lcprCargoVacaciones;
	}

	public int getTplcEstado() {
		return tplcEstado;
	}

	public void setTplcEstado(int tplcEstado) {
		this.tplcEstado = tplcEstado;
	}

	public String getLcprObservacionEstado() {
		return lcprObservacionEstado;
	}

	public void setLcprObservacionEstado(String lcprObservacionEstado) {
		this.lcprObservacionEstado = lcprObservacionEstado;
	}

	
	
	
	
	
	
	
	
	

}
