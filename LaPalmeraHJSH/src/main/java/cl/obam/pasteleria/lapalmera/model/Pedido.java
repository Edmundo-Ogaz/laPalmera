package cl.obam.pasteleria.lapalmera.model;

// Generated 07-01-2016 12:33:38 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Pedido generated by hbm2java
 */
@Entity
@Table(name = "pedido", catalog = "lapalmera")
public class Pedido implements java.io.Serializable {

	private Integer numeropedido;
	private Cliente cliente;
	private Estadopedido estadopedido;
	private Date fechapedido;
	private int preciototalpedido;
	private String observacionpedido;
	private Set<Ordenfabricacion> ordenfabricacions = new HashSet<Ordenfabricacion>(
			0);
	private Despachopedido despachopedido;
	private Confirmacionpedido confirmacionpedido;
	private Set<Detallepedido> detallepedidos = new HashSet<Detallepedido>(0);

	public Pedido() {
	}

	public Pedido(Cliente cliente, Estadopedido estadopedido, Date fechapedido,
			int preciototalpedido) {
		this.cliente = cliente;
		this.estadopedido = estadopedido;
		this.fechapedido = fechapedido;
		this.preciototalpedido = preciototalpedido;
	}

	public Pedido(Cliente cliente, Estadopedido estadopedido, Date fechapedido,
			int preciototalpedido, String observacionpedido,
			Set<Ordenfabricacion> ordenfabricacions,
			Despachopedido despachopedido,
			Confirmacionpedido confirmacionpedido,
			Set<Detallepedido> detallepedidos) {
		this.cliente = cliente;
		this.estadopedido = estadopedido;
		this.fechapedido = fechapedido;
		this.preciototalpedido = preciototalpedido;
		this.observacionpedido = observacionpedido;
		this.ordenfabricacions = ordenfabricacions;
		this.despachopedido = despachopedido;
		this.confirmacionpedido = confirmacionpedido;
		this.detallepedidos = detallepedidos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "NUMEROPEDIDO", unique = true, nullable = false)
	public Integer getNumeropedido() {
		return this.numeropedido;
	}

	public void setNumeropedido(Integer numeropedido) {
		this.numeropedido = numeropedido;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RUTCLIENTE", nullable = false)
	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CODIGOESTADOPEDIDO", nullable = false)
	public Estadopedido getEstadopedido() {
		return this.estadopedido;
	}

	public void setEstadopedido(Estadopedido estadopedido) {
		this.estadopedido = estadopedido;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHAPEDIDO", nullable = false, length = 19)
	public Date getFechapedido() {
		return this.fechapedido;
	}

	public void setFechapedido(Date fechapedido) {
		this.fechapedido = fechapedido;
	}

	@Column(name = "PRECIOTOTALPEDIDO", nullable = false)
	public int getPreciototalpedido() {
		return this.preciototalpedido;
	}

	public void setPreciototalpedido(int preciototalpedido) {
		this.preciototalpedido = preciototalpedido;
	}

	@Column(name = "OBSERVACIONPEDIDO", length = 80)
	public String getObservacionpedido() {
		return this.observacionpedido;
	}

	public void setObservacionpedido(String observacionpedido) {
		this.observacionpedido = observacionpedido;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido")
	public Set<Ordenfabricacion> getOrdenfabricacions() {
		return this.ordenfabricacions;
	}

	public void setOrdenfabricacions(Set<Ordenfabricacion> ordenfabricacions) {
		this.ordenfabricacions = ordenfabricacions;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "pedido")
	public Despachopedido getDespachopedido() {
		return this.despachopedido;
	}

	public void setDespachopedido(Despachopedido despachopedido) {
		this.despachopedido = despachopedido;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "pedido")
	public Confirmacionpedido getConfirmacionpedido() {
		return this.confirmacionpedido;
	}

	public void setConfirmacionpedido(Confirmacionpedido confirmacionpedido) {
		this.confirmacionpedido = confirmacionpedido;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pedido")
	public Set<Detallepedido> getDetallepedidos() {
		return this.detallepedidos;
	}

	public void setDetallepedidos(Set<Detallepedido> detallepedidos) {
		this.detallepedidos = detallepedidos;
	}

}
