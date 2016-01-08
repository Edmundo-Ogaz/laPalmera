package cl.obam.pasteleria.lapalmera.view;
public class RegionVO {


	private String codigo;
	private String nombre;

	public RegionVO() {
	}
	
	public RegionVO(String codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}
}