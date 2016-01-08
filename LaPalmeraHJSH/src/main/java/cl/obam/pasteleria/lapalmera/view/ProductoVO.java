package cl.obam.pasteleria.lapalmera.view;

import java.util.List;

public class ProductoVO implements java.io.Serializable {

	private String codigo;
	private UnidadMedidaVO unidadMedida;
	private OtraCaracteristicaVO otraCaracteristica;
	private FamiliaVO familia;
	private SubFamiliaVO subFamilia;
	private String nombre;
	private Integer stockcriticoproducto;
	private Integer valorcosto;
	private Integer valorventa;
	private String preparacion;
	private TipoProductoVO tipoProducto;
	private String fotoproducto;
	private String observacion;
	private StockVO stock;
	private List<UbicacionVO> ubicacions;
	private List<IngredienteVO> ingredientes;

	public ProductoVO() {
	}
	
	public ProductoVO(String codigo) {
		this.codigo = codigo;
	}

	public ProductoVO(String codigo, UnidadMedidaVO unidadMedida,
			OtraCaracteristicaVO otraCaracteristica, FamiliaVO familia,
			SubFamiliaVO subfamilia, String nombre,
			Integer stockcriticoproducto, Integer valorcosto,
			Integer valorventa, String preparacion, TipoProductoVO tipoproducto,
			String fotoproducto, String observacion) {
		this.codigo = codigo;
		this.unidadMedida = unidadMedida;
		this.otraCaracteristica = otraCaracteristica;
		this.familia = familia;
		this.subFamilia = subFamilia;
		this.nombre = nombre;
		this.stockcriticoproducto = stockcriticoproducto;
		this.valorcosto = valorcosto;
		this.valorventa = valorventa;
		this.preparacion = preparacion;
		this.tipoProducto = tipoproducto;
		this.fotoproducto = fotoproducto;
		this.observacion = observacion;
	}
	
	public ProductoVO(String codigo, UnidadMedidaVO unidadMedida,
			OtraCaracteristicaVO codigootracaracteristica, FamiliaVO codigofamilia,
			SubFamiliaVO codigosubfamilia, String nombreproducto,
			Integer stockcriticoproducto, Integer valorcosto,
			Integer valorventa, String preparacion, TipoProductoVO tipoproducto,
			String fotoproducto, String observacion, StockVO stock) {
		this.codigo = codigo;
		this.unidadMedida = unidadMedida;
		this.otraCaracteristica = codigootracaracteristica;
		this.familia = codigofamilia;
		this.subFamilia = codigosubfamilia;
		this.nombre = nombreproducto;
		this.stockcriticoproducto = stockcriticoproducto;
		this.valorcosto = valorcosto;
		this.valorventa = valorventa;
		this.preparacion = preparacion;
		this.tipoProducto = tipoproducto;
		this.fotoproducto = fotoproducto;
		this.observacion = observacion;
		this.stock = stock;
	}
	
	public ProductoVO(String codigo, UnidadMedidaVO unidadMedida,
			OtraCaracteristicaVO codigootracaracteristica, FamiliaVO codigofamilia,
			SubFamiliaVO codigosubfamilia, String nombreproducto,
			Integer stockcriticoproducto, Integer valorcosto,
			Integer valorventa, String preparacion, TipoProductoVO tipoproducto,
			String fotoproducto, String observacion, StockVO stock, List<UbicacionVO> ubicacions) {
		this.codigo = codigo;
		this.unidadMedida = unidadMedida;
		this.otraCaracteristica = codigootracaracteristica;
		this.familia = codigofamilia;
		this.subFamilia = codigosubfamilia;
		this.nombre = nombreproducto;
		this.stockcriticoproducto = stockcriticoproducto;
		this.valorcosto = valorcosto;
		this.valorventa = valorventa;
		this.preparacion = preparacion;
		this.tipoProducto = tipoproducto;
		this.fotoproducto = fotoproducto;
		this.observacion = observacion;
		this.stock = stock;
		this.ubicacions = ubicacions;
	}
	
	public ProductoVO(String codigo, UnidadMedidaVO unidadMedida, 
			OtraCaracteristicaVO otraCaracteristica, FamiliaVO familia, SubFamiliaVO subFamilia, 
			String nombre, Integer stockCriticoProducto, Integer valorCosto, Integer valorVenta, 
			String preparacion, TipoProductoVO tipoProducto, String fotoProducto, String observacion,
			List<UbicacionVO> ubicacions) {
		this.codigo = codigo;
		this.unidadMedida = unidadMedida;
		this.otraCaracteristica = otraCaracteristica;
		this.familia = familia;
		this.subFamilia = subFamilia;
		this.nombre = nombre;
		this.stockcriticoproducto = stockCriticoProducto;
		this.valorcosto = valorCosto;
		this.valorventa = valorVenta;
		this.preparacion = preparacion;
		this.tipoProducto = tipoProducto;
		this.fotoproducto = fotoProducto;
		this.observacion = observacion;
		this.ubicacions = ubicacions;
	}
	
	public ProductoVO(String codigo, String nombreproducto, 
			List<IngredienteVO> ingredientes) {
		this.codigo = codigo;
		this.nombre = nombreproducto;
		this.ingredientes = ingredientes;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public UnidadMedidaVO getUnidadMedida() {
		return this.unidadMedida;
	}

	public OtraCaracteristicaVO getOtraCaracteristica() {
		return this.otraCaracteristica;
	}

	public FamiliaVO getFamilia() {
		return this.familia;
	}
	
	public SubFamiliaVO getSubFamilia() {
		return this.subFamilia;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Integer getStockcriticoproducto() {
		return this.stockcriticoproducto;
	}

	public Integer getValorcosto() {
		return this.valorcosto;
	}

	public Integer getValorventa() {
		return this.valorventa;
	}

	public String getPreparacion() {
		return this.preparacion;
	}

	public TipoProductoVO getTipoProducto() {
		return this.tipoProducto;
	}

	public String getFotoproducto() {
		return this.fotoproducto;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public StockVO getStock() {
		return stock;
	}

	public List<IngredienteVO> getIngredientes() {
		return ingredientes;
	}

	public List<UbicacionVO> getUbicacions() {
		return ubicacions;
	}

	public void setStock(StockVO stock) {
		this.stock = stock;
	}

	public void setUbicacions(List<UbicacionVO> ubicacions) {
		this.ubicacions = ubicacions;
	}
	
	
	
}