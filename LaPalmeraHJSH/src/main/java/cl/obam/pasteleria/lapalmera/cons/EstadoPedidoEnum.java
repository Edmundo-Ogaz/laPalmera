package cl.obam.pasteleria.lapalmera.cons;

public enum EstadoPedidoEnum {
	
	CONFIRMADO ("C", "Confirmado"),
	INGRESADO ("I", "Ingresado"),
	RECHAZADO ("R", "Rechazado");
	
	private final String codigo;
	private final String nombre;
	
	private EstadoPedidoEnum(String codigo, String nombre) {
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
