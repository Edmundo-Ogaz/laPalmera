package cl.obam.pasteleria.lapalmera.view;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class GrupoVO implements java.io.Serializable {

	private String codigo;
	private String nombre;
	private List<UsuarioVO> usuarios;

	public GrupoVO() {
	}

	public GrupoVO(String codigo) {
		this.codigo = codigo;
	}

	public GrupoVO(String codigo, String nombre, List<UsuarioVO> usuarios) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.usuarios = usuarios;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public List<UsuarioVO> getUsuarios() {
		return this.usuarios;
	}
}
