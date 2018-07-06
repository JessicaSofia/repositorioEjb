package ec.edu.uce.controlAsistencia.ejb.datos;

public class ParametroVacacionesDto {

	
	private int PrvcId;
	private int rgmId;
	private String valor;
	
	
	
	public ParametroVacacionesDto(int prvcId, int rgmId, String valor) {
		super();
		PrvcId = prvcId;
		this.rgmId = rgmId;
		this.valor = valor;
	}
	public int getPrvcId() {
		return PrvcId;
	}
	public void setPrvcId(int prvcId) {
		PrvcId = prvcId;
	}
	public int getRgmId() {
		return rgmId;
	}
	public void setRgmId(int rgmId) {
		this.rgmId = rgmId;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
}
