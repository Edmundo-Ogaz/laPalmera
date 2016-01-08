package cl.obam.pasteleria.lapalmera.util;

import cl.obam.pasteleria.lapalmera.cons.UnidadMedidaEnum;

public final class UnidadMedidaHelper {

	public static float conversion(String codigoUnidadMedidaBase, String codigoUnidadMediaNew, Float cantidad) {
		
		if(!codigoUnidadMedidaBase.equals(codigoUnidadMediaNew)) {
			if(UnidadMedidaEnum.LITRO.getCodigo().equals(codigoUnidadMediaNew))
				cantidad = cantidad * UnidadMedidaEnum.LITRO.getConversion();
			if(UnidadMedidaEnum.CENTRIMETRO_CUBICOS.getCodigo().equals(codigoUnidadMediaNew))
				cantidad = cantidad * UnidadMedidaEnum.CENTRIMETRO_CUBICOS.getConversion();
		}
		
		return cantidad;
	}
}