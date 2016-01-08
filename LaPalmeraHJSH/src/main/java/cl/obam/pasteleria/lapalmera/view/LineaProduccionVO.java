package cl.obam.pasteleria.lapalmera.view;

public class LineaProduccionVO implements java.io.Serializable {

	private String codigo;
	private String nombre;

	public LineaProduccionVO() {
	}

	public LineaProduccionVO(String codigo) {
		this.codigo = codigo;
	}

	public LineaProduccionVO(String codigo,
			String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public String getNombre() {
		return this.nombre;
	}
}