package cl.obam.pasteleria.lapalmera.view;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

public class SubFamiliaVO implements java.io.Serializable {

	private String codigo;
	private FamiliaVO familia;
	private String nombre;
	
	public SubFamiliaVO() {
	}

	public SubFamiliaVO(String codigosubfamilia) {
		this.codigo = codigosubfamilia;
	}

	public SubFamiliaVO(String codigosubfamilia, FamiliaVO familia,
			String nombresubfamilia) {
		this.codigo = codigosubfamilia;
		this.familia = familia;
		this.nombre = nombresubfamilia;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public FamiliaVO getFamilia() {
		return this.familia;
	}

	public String getNombre() {
		return this.nombre;
	}
}