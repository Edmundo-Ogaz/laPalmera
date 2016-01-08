package cl.obam.pasteleria.lapalmera.view;


public class ConceptoTecnicoVO implements java.io.Serializable {

	private String codigoconceptotecnico;
	private String nombreconceptotecnico;

	public ConceptoTecnicoVO() {
	}

	public ConceptoTecnicoVO(String codigoconceptotecnico,
			String nombreconceptotecnico) {
		this.codigoconceptotecnico = codigoconceptotecnico;
		this.nombreconceptotecnico = nombreconceptotecnico;
	}

	public String getCodigoconceptotecnico() {
		return this.codigoconceptotecnico;
	}

	public String getNombreconceptotecnico() {
		return this.nombreconceptotecnico;
	}

}