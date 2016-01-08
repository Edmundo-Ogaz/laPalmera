package cl.obam.pasteleria.lapalmera.cons;

public enum UnidadMedidaEnum {
	
	LITRO ("LTS", 0.001f, "Litros"),
	CENTRIMETRO_CUBICOS ("CM3", 10000f, "Centimetros Cubicos");
	
	private final String codigo;
	private final Float conversion;
	private final String nombre;
	
	private UnidadMedidaEnum(String codigo, Float conversion, String nombre) {
		this.codigo = codigo;
		this.conversion = conversion;
		this.nombre = nombre;
	}
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public Float getConversion() {
		return conversion;
	}

	public String getNombre() {
		return this.nombre;
	}
}