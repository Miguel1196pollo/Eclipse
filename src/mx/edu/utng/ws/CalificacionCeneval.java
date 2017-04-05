package mx.edu.utng.ws;

public class CalificacionCeneval {
	private int id;
	private String nombreAlumno;
	private String fechaEdicion;
	private float calificacion;
	private String activo;
	
	public CalificacionCeneval(int id, String nombreAlumno, String fechaEdicion,
			float calificacion, String activo) {
		super();
		this.id = id;
		this.nombreAlumno = nombreAlumno;
		this.fechaEdicion = fechaEdicion;
		this.calificacion = calificacion;
		this.activo = activo;
	}
	
	public CalificacionCeneval(){
		this(0, "", "", 0.0f, "");
	}

		public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public String getFechaEdicion() {
		return fechaEdicion;
	}

	public void setFechaEdicion(String fechaEdicion) {
		this.fechaEdicion = fechaEdicion;
	}

	public float getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

		@Override
	public String toString() {
		return "CalificacionCeneval [cveCalificacionesCeneval=" + id + ", nombreAlumno="
				+ nombreAlumno + ", fechaEdicion=" + fechaEdicion + ", calificacion=" + calificacion + ", activo="
				+ activo + "]";
	}
	
	
}
