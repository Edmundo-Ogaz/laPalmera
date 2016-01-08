package cl.obam.pasteleria.lapalmera.view;


public class TipoClienteVO implements java.io.Serializable {

	private String codigo;
	private String nombre;

	public TipoClienteVO() {
	}

	public TipoClienteVO(String codigo, String nombre) {
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