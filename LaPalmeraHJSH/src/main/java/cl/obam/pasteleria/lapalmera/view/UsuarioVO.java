package cl.obam.pasteleria.lapalmera.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

public class UsuarioVO implements java.io.Serializable {

	private String username;
	private GrupoVO grupo;
	private FuncionarioVO funcionario;
	private String password;

	public UsuarioVO() {
	}

	public UsuarioVO(String username, FuncionarioVO funcionario) {
		this.username = username;
		this.funcionario = funcionario;
	}

	public UsuarioVO(String username, GrupoVO grupo, FuncionarioVO funcionario,
			String password) {
		this.username = username;
		this.grupo = grupo;
		this.funcionario = funcionario;
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public GrupoVO getGrupo() {
		return this.grupo;
	}

	public FuncionarioVO getFuncionario() {
		return this.funcionario;
	}

	public String getPassword() {
		return this.password;
	}
}