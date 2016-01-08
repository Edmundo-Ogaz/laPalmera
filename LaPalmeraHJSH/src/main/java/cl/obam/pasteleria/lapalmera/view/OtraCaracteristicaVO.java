package cl.obam.pasteleria.lapalmera.view;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

public class OtraCaracteristicaVO implements java.io.Serializable {

	private String codigootracaracteristica;
	private String nombreotracaracteristica;

	public OtraCaracteristicaVO() {
	}

	public OtraCaracteristicaVO(String codigootracaracteristica) {
		this.codigootracaracteristica = codigootracaracteristica;
	}

	public OtraCaracteristicaVO(String codigootracaracteristica,
			String nombreotracaracteristica) {
		this.codigootracaracteristica = codigootracaracteristica;
		this.nombreotracaracteristica = nombreotracaracteristica;
	}

	public String getCodigootracaracteristica() {
		return this.codigootracaracteristica;
	}

	public String getNombreotracaracteristica() {
		return this.nombreotracaracteristica;
	}
}