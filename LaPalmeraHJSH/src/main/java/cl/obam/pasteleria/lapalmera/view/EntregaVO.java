package cl.obam.pasteleria.lapalmera.view;

public class EntregaVO implements java.io.Serializable {

	private String codigo;
	private String descripcion;

	public EntregaVO() {
	}

	public EntregaVO(String codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

}