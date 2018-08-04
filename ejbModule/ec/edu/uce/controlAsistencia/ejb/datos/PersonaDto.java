package ec.edu.uce.controlAsistencia.ejb.datos;

import java.io.Serializable;

public class PersonaDto  implements Serializable {
	
	
	/**
	 * jessica
	 */
	private static final long serialVersionUID = 1L;
	private int prsId;
	private String prsNombres;
	private String prsIdentificacion;
	private String prsPrimerApellido;
	private String prsSegundoApellido;
	private int fcemId;
	private int dtpsId;
	private int dpnId;
	private int pstId;
	private int rgmId;
	private int rllbId;
	private int ctgId;
	private String dpnNombre;
	private String pstNombre;
	private String rgmNombre;
	
	
	
	
	public PersonaDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public PersonaDto(int prsId, String prsNombres, String prsIdentificacion, String prsPrimerApellido,
			String prsSegundoApellido, int fcemId, int dtpsId, int dpnId , int pstId, int rgmId , int rllbId) {
		super();
		this.prsId = prsId;
		this.prsNombres = prsNombres;
		this.prsIdentificacion = prsIdentificacion;
		this.prsPrimerApellido = prsPrimerApellido;
		this.prsSegundoApellido = prsSegundoApellido;
		this.fcemId = fcemId;
		this.dtpsId = dtpsId;
		this.dpnId = dpnId;
		this.pstId=pstId;
		this.rgmId = rgmId;
		this.rllbId = rllbId;
	}




	public int getPstId() {
		return pstId;
	}




	public void setPstId(int pstId) {
		this.pstId = pstId;
	}




	public int getRgmId() {
		return rgmId;
	}




	public void setRgmId(int rgmId) {
		this.rgmId = rgmId;
	}




	public int getRllbId() {
		return rllbId;
	}




	public void setRllbId(int rllbId) {
		this.rllbId = rllbId;
	}




	public int getPrsId() {
		return prsId;
	}




	public void setPrsId(int prsId) {
		this.prsId = prsId;
	}




	public String getPrsNombres() {
		return prsNombres;
	}




	public void setPrsNombres(String prsNombres) {
		this.prsNombres = prsNombres;
	}




	public String getPrsIdentificacion() {
		return prsIdentificacion;
	}




	public void setPrsIdentificacion(String prsIdentificacion) {
		this.prsIdentificacion = prsIdentificacion;
	}




	public String getPrsPrimerApellido() {
		return prsPrimerApellido;
	}




	public void setPrsPrimerApellido(String prsPrimerApellido) {
		this.prsPrimerApellido = prsPrimerApellido;
	}




	public String getPrsSegundoApellido() {
		return prsSegundoApellido;
	}




	public void setPrsSegundoApellido(String prsSegundoApellido) {
		this.prsSegundoApellido = prsSegundoApellido;
	}




	public int getFcemId() {
		return fcemId;
	}




	public void setFcemId(int fcemId) {
		this.fcemId = fcemId;
	}




	public int getDtpsId() {
		return dtpsId;
	}




	public void setDtpsId(int dtpsId) {
		this.dtpsId = dtpsId;
	}




	public int getDpnId() {
		return dpnId;
	}




	public void setDpnId(int dpnId) {
		this.dpnId = dpnId;
	}




	public int getCtgId() {
		return ctgId;
	}




	public void setCtgId(int ctgId) {
		this.ctgId = ctgId;
	}




	public String getDpnNombre() {
		return dpnNombre;
	}




	public void setDpnNombre(String dpnNombre) {
		this.dpnNombre = dpnNombre;
	}




	public String getPstNombre() {
		return pstNombre;
	}




	public void setPstNombre(String pstNombre) {
		this.pstNombre = pstNombre;
	}




	public String getRgmNombre() {
		return rgmNombre;
	}




	public void setRgmNombre(String rgmNombre) {
		this.rgmNombre = rgmNombre;
	}




	@Override
	public String toString() {
		return ""+ prsPrimerApellido+" "+ prsSegundoApellido+ "";
	}
	
	
public String nombresCompetos() {
	return  prsNombres+" " + prsPrimerApellido+" "+ prsSegundoApellido+ "";
}
	

}
