package cl.obam.pasteleria.lapalmera.view;


public class CiudadVO {
	
	private String codigo;
	private String nombre;
	private RegionVO region;
	
	public CiudadVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CiudadVO(String codigo, String nombre, RegionVO region) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.region = region;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public RegionVO getRegion() {
		return region;
	}

}