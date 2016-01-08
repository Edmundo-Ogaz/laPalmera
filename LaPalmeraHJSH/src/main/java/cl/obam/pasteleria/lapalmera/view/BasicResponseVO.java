package cl.obam.pasteleria.lapalmera.view;

public class BasicResponseVO {

	private String codigo;
	private String respuesta;
	private Object detalle;
	
	public BasicResponseVO(String codigo, String respuesta, Object detalle) {
		super();
		this.codigo = codigo;
		this.respuesta = respuesta;
		this.detalle = detalle;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public Object getDetalle() {
		return detalle;
	}
}