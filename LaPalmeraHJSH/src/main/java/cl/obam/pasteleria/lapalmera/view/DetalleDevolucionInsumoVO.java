package cl.obam.pasteleria.lapalmera.view;


public class DetalleDevolucionInsumoVO implements java.io.Serializable {

	private int correlativoDevolucionInsumo;
	private ProductoVO insumo;
	private Integer cantidadDevolucionInsumo;
	private String codigoUnidadMedida;

	public DetalleDevolucionInsumoVO() {
	}

	public DetalleDevolucionInsumoVO(int correlativodevolucioninsumo,
			ProductoVO insumo, Integer cantidadDevolucionInsumo, 
			String codigoUnidadMedida) {
		this.correlativoDevolucionInsumo = correlativodevolucioninsumo;
		this.insumo = insumo;
		this.cantidadDevolucionInsumo = cantidadDevolucionInsumo;
		this.codigoUnidadMedida = codigoUnidadMedida;
	}

	public int getCorrelativoDevolucionInsumo() {
		return this.correlativoDevolucionInsumo;
	}

	public ProductoVO getInsumo() {
		return this.insumo;
	}

	public Integer getCantidadDevolucionInsumo() {
		return this.cantidadDevolucionInsumo;
	}

	public String getCodigoUnidadMedida() {
		return this.codigoUnidadMedida;
	}
}