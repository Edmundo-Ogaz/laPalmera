package cl.obam.pasteleria.lapalmera.model;

// Generated 02-09-2015 09:17:53 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * IngredienteId generated by hbm2java
 */
@Embeddable
public class IngredienteId implements java.io.Serializable {

	private String codigoproducto;
	private String codigoinsumo;

	public IngredienteId() {
	}

	public IngredienteId(String codigoproducto, String codigoinsumo) {
		this.codigoproducto = codigoproducto;
		this.codigoinsumo = codigoinsumo;
	}

	@Column(name = "CODIGOPRODUCTO", nullable = false, length = 20)
	public String getCodigoproducto() {
		return this.codigoproducto;
	}

	public void setCodigoproducto(String codigoproducto) {
		this.codigoproducto = codigoproducto;
	}

	@Column(name = "CODIGOINSUMO", nullable = false, length = 20)
	public String getCodigoinsumo() {
		return this.codigoinsumo;
	}

	public void setCodigoinsumo(String codigoinsumo) {
		this.codigoinsumo = codigoinsumo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof IngredienteId))
			return false;
		IngredienteId castOther = (IngredienteId) other;

		return ((this.getCodigoproducto() == castOther.getCodigoproducto()) || (this
				.getCodigoproducto() != null
				&& castOther.getCodigoproducto() != null && this
				.getCodigoproducto().equals(castOther.getCodigoproducto())))
				&& ((this.getCodigoinsumo() == castOther.getCodigoinsumo()) || (this
						.getCodigoinsumo() != null
						&& castOther.getCodigoinsumo() != null && this
						.getCodigoinsumo().equals(castOther.getCodigoinsumo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getCodigoproducto() == null ? 0 : this.getCodigoproducto()
						.hashCode());
		result = 37
				* result
				+ (getCodigoinsumo() == null ? 0 : this.getCodigoinsumo()
						.hashCode());
		return result;
	}

}
