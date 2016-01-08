package cl.obam.pasteleria.lapalmera.cons;

public enum EstadoOrdenFabricacionEnum {
	
	ACTIVO ("A", "Activo"),
	SUPENDIDO ("S", "Suspendido"),
	TERMINADO ("T", "Terminado");
	
	private final String codigo;
	private final String nombre;
	
	private EstadoOrdenFabricacionEnum(String codigo, String nombre) {
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
