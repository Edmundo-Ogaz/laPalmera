package cl.obam.pasteleria.lapalmera.view;

public class ComunaVO {
	
	private String codigo;
	private String nombre;
	private CiudadVO ciudad;
	
	public ComunaVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComunaVO(String codigo, String nombre, CiudadVO ciudad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.ciudad = ciudad;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public CiudadVO getCiudad() {
		return ciudad;
	}

}
