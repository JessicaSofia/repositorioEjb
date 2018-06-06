package ec.edu.uce.controlAsistencia.ejb.datos;

import java.math.BigDecimal;

import ec.edu.uce.controlAsistencia.jpa.entidades.Contrato;
import ec.edu.uce.controlAsistencia.jpa.entidades.Dependencia;
import ec.edu.uce.controlAsistencia.jpa.entidades.FichaEmpleado;
import ec.edu.uce.controlAsistencia.jpa.entidades.Puesto;
import ec.edu.uce.controlAsistencia.jpa.entidades.RelacionLaboral;

public class DetallePuestoDto {
	
	
	private int dtpsId;
	private int contrato;
	private int dependencia;
	private int fichaEmpleado;
	private int puesto;
	private int relacionLaboral;
	private int dtpsEstado;
	

	
	public DetallePuestoDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public DetallePuestoDto(int dtpsId, int contrato, int dependencia, int fichaEmpleado, int puesto,
			int relacionLaboral, int dtpsEstado) {
		super();
		this.dtpsId = dtpsId;
		this.contrato = contrato;
		this.dependencia = dependencia;
		this.fichaEmpleado = fichaEmpleado;
		this.puesto = puesto;
		this.relacionLaboral = relacionLaboral;
		this.dtpsEstado = dtpsEstado;
	}



	public int getDtpsId() {
		return dtpsId;
	}



	public void setDtpsId(int dtpsId) {
		this.dtpsId = dtpsId;
	}



	public int getContrato() {
		return contrato;
	}



	public void setContrato(int contrato) {
		this.contrato = contrato;
	}



	public int getDependencia() {
		return dependencia;
	}



	public void setDependencia(int dependencia) {
		this.dependencia = dependencia;
	}



	public int getFichaEmpleado() {
		return fichaEmpleado;
	}



	public void setFichaEmpleado(int fichaEmpleado) {
		this.fichaEmpleado = fichaEmpleado;
	}



	public int getPuesto() {
		return puesto;
	}



	public void setPuesto(int puesto) {
		this.puesto = puesto;
	}



	public int getRelacionLaboral() {
		return relacionLaboral;
	}



	public void setRelacionLaboral(int relacionLaboral) {
		this.relacionLaboral = relacionLaboral;
	}



	public int getDtpsEstado() {
		return dtpsEstado;
	}



	public void setDtpsEstado(int dtpsEstado) {
		this.dtpsEstado = dtpsEstado;
	}



	@Override
	public String toString() {
		return "DetallePuestoDto [dtpsId=" + dtpsId + ", contrato=" + contrato + ", dependencia=" + dependencia
				+ ", fichaEmpleado=" + fichaEmpleado + ", puesto=" + puesto + ", relacionLaboral=" + relacionLaboral
				+ ", dtpsEstado=" + dtpsEstado + "]";
	}
	
	
	
}
