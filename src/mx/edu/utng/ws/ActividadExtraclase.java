package mx.edu.utng.ws;

public class ActividadExtraclase {
	private int id;
	private String cveActividadExtraclase;
	private String description;
	private String lugar;
	private String totalHoras;
	private String tipoActividad;
	
	
	public ActividadExtraclase(int id, String cveActividadExtraclase,String description, String lugar, String totalHoras, String tipoActividad){
		super();
		this.id = id;
		this.cveActividadExtraclase = cveActividadExtraclase;
		this.description = description;
		this.lugar = lugar;
		this.totalHoras = totalHoras;
		this.tipoActividad = tipoActividad;
	}
	
	public ActividadExtraclase(){
		this(0,"","","","","");
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCveActividadExtraclase() {
		return cveActividadExtraclase;
	}


	public void setCveActividadExtraclase(String cveActividadExtraclase) {
		this.cveActividadExtraclase = cveActividadExtraclase;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getLugar() {
		return lugar;
	}


	public void setLugar(String lugar) {
		this.lugar = lugar;
	}


	public String getTotalHoras() {
		return totalHoras;
	}


	public void setTotalHoras(String totalHoras) {
		this.totalHoras = totalHoras;
	}


	public String getTipoActividad() {
		return tipoActividad;
	}


	public void setTipoActividad(String tipoActividad) {
		this.tipoActividad = tipoActividad;
	}

	@Override
	public String toString() {
		return "ActividadExtraclase [id=" + id + ", cveActividadExtraclase=" + cveActividadExtraclase + ", description="
				+ description + ", lugar=" + lugar + ", totalHoras=" + totalHoras + ", tipoActividad=" + tipoActividad
				+ "]";
	}
	
	
	
	

}
