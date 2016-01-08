package cl.obam.pasteleria.lapalmera.cons;

public enum TipoProductoEnum {
	
	INSUMO ("I", "Insumo"),
	SEMIELABORADO ("S", "Semielaborado"),
	TERMINADO ("T", "Terminado");
	
	private final String codigo;
	private final String nombre;
	
	private TipoProductoEnum(String codigo, String nombre) {
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
