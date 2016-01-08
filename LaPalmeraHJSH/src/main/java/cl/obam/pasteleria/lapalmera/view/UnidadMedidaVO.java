package cl.obam.pasteleria.lapalmera.view;


public class UnidadMedidaVO implements java.io.Serializable {

	private String codigo;
	private String nombre;
	private FamiliaVO familia;

	public UnidadMedidaVO() {
	}

	public UnidadMedidaVO(String codigo) {
		this.codigo = codigo;
	}

	public UnidadMedidaVO(String codigo, String nombre, FamiliaVO familia) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.familia = familia;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public FamiliaVO getFamilia() {
		return familia;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}