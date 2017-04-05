package mx.edu.utng.ws;

public class Equipo {
	private int id;
	private String nombre;
	private String tipoEquipo;
	private String numeroEquipo;
	private String descripcion;
	private String filial;
	private String estatus;
	public Equipo(int id, String nombre, String tipoEquipo, String numeroEquipo, String descripcion, String filial,
			String estatus) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipoEquipo = tipoEquipo;
		this.numeroEquipo = numeroEquipo;
		this.descripcion = descripcion;
		this.filial = filial;
		this.estatus = estatus;
	}
	
	public Equipo(){
		this(0,"","","","","","");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipoEquipo() {
		return tipoEquipo;
	}

	public void setTipoEquipo(String tipoEquipo) {
		this.tipoEquipo = tipoEquipo;
	}

	public String getNumeroEquipo() {
		return numeroEquipo;
	}

	public void setNumeroEquipo(String numeroEquipo) {
		this.numeroEquipo = numeroEquipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFilial() {
		return filial;
	}

	public void setFilial(String filial) {
		this.filial = filial;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + ", tipoEquipo=" + tipoEquipo + ", numeroEquipo="
				+ numeroEquipo + ", descripcion=" + descripcion + ", filial=" + filial + ", estatus=" + estatus + "]";
	}
	
	

}
