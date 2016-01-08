package cl.obam.pasteleria.lapalmera.view;

import java.util.Date;
import java.util.List;

public class SolicitudProductoVO implements java.io.Serializable {

	private String codigoproducto;
	private String cantidadproducto;
	private String preciototalproducto; 
	private String dedicatoriapedido;
	private String observacionpedido;
	
	private String fechaentregadespacho;
	private String horaentregadespacho;

	public SolicitudProductoVO() {
	}

	public SolicitudProductoVO(String codigoproducto,
			String cantidadproducto, String preciototalproducto,
			String dedicatoriapedido, String observacionpedido,
			String fechaentregadespacho, String horaentregadespacho) {
		super();
		this.codigoproducto = codigoproducto;
		this.cantidadproducto = cantidadproducto;
		this.preciototalproducto = preciototalproducto;
		this.dedicatoriapedido = dedicatoriapedido;
		this.observacionpedido = observacionpedido;
		this.fechaentregadespacho = fechaentregadespacho;
		this.horaentregadespacho = horaentregadespacho;
	}

	public String getCodigoproducto() {
		return codigoproducto;
	}

	public void setCodigoproducto(String codigoproducto) {
		this.codigoproducto = codigoproducto;
	}

	public String getCantidadproducto() {
		return cantidadproducto;
	}

	public void setCantidadproducto(String cantidadproducto) {
		this.cantidadproducto = cantidadproducto;
	}

	public String getPreciototalproducto() {
		return preciototalproducto;
	}

	public void setPreciototalproducto(String preciototalproducto) {
		this.preciototalproducto = preciototalproducto;
	}

	public String getDedicatoriapedido() {
		return dedicatoriapedido;
	}

	public void setDedicatoriapedido(String dedicatoriapedido) {
		this.dedicatoriapedido = dedicatoriapedido;
	}

	public String getObservacionpedido() {
		return observacionpedido;
	}

	public void setObservacionpedido(String observacionpedido) {
		this.observacionpedido = observacionpedido;
	}

	public String getFechaentregadespacho() {
		return fechaentregadespacho;
	}

	public void setFechaentregadespacho(String fechaentregadespacho) {
		this.fechaentregadespacho = fechaentregadespacho;
	}

	public String getHoraentregadespacho() {
		return horaentregadespacho;
	}

	public void setHoraentregadespacho(String horaentregadespacho) {
		this.horaentregadespacho = horaentregadespacho;
	}

	
	
	}