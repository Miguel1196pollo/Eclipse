package mx.edu.utng.ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class ActividadExtraclaseWS {
	
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement ps;
	
	public ActividadExtraclaseWS(){
		conectar();
	}
	
	public void conectar(){
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/wbtst",
					"postgres", "1234");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
	}
	
}
	
	public int addActividadExtraclase(ActividadExtraclase actividad){
		int result = 0;
		if (connection!= null) {
			try {
				ps = connection.prepareStatement(
						"INSERT INTO actividad_extraclase (cve_actividad_extraclase,description,lugar,total_horas, tipo_actividad) "
						+ "VALUES(?,?,?,?,?);");
				ps.setString(1, actividad.getCveActividadExtraclase());
				ps.setString(2,actividad.getDescription());
				ps.setString(3, actividad.getLugar());
				ps.setString(4, actividad.getTotalHoras());
				ps.setString(5, actividad.getTipoActividad());
				
				result = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}	

	public int editActividadExtraclase(ActividadExtraclase actividad){
		int result = 0;
		if(connection!=null){
			try {
				ps = connection.prepareStatement(
						"UPDATE actividad_extraclase SET cve_actividad_extraclase =?,"
						+ "description= ?,"
						+ "lugar = ?,"
						+ "total_horas =?,"
						+ "tipo_actividad"
						+ "WHERE id =?;");
				ps.setString(1, actividad.getCveActividadExtraclase());
				ps.setString(2, actividad.getDescription());
				ps.setString(3, actividad.getLugar());
				ps.setString(4, actividad.getTotalHoras());
				ps.setString(5, actividad.getTipoActividad());
				ps.setInt(6, actividad.getId());
				result = ps.executeUpdate();
			} catch (SQLException e) {
		e.printStackTrace();
			}
		}
		return result;
	}

	public int removeActividadExtraclase(int id){
		int result = 0;
		if (connection!= null) {
			try {
				ps = connection.prepareStatement(
						"DELETE FROM actividad_extraclase WHERE id = ?;");
				ps.setInt(1, id);
				result = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public ActividadExtraclase[] getActividades(){
		ActividadExtraclase[] result = null;
		List<ActividadExtraclase>  actividades = new ArrayList<ActividadExtraclase>();
		if (connection!= null) {
			try {
				statement = connection.createStatement();
				resultSet = statement.executeQuery("SELECT * FROM actividad_extraclase;");
						while(resultSet.next()){
							ActividadExtraclase actividad = new ActividadExtraclase(
									resultSet.getInt("id"),
									resultSet.getString("cve_actividad_extraclase"),
									resultSet.getString("description"),
									resultSet.getString("lugar"),
									resultSet.getString("total_horas"),
									resultSet.getString("tipo_actividad"));
							actividades.add(actividad);
						}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		result = actividades.toArray(new ActividadExtraclase[actividades.size()]);
		return result;
	}

	public ActividadExtraclase getActivdadExtraclaseById(int id){
		ActividadExtraclase  actividad = null;
		if (connection!= null) {
			try {
				ps = connection.prepareStatement("SELECT * FROM actividad_extraclase WHERE id = ?;");
				ps.setInt(1, id);
				resultSet = ps.executeQuery();
						while(resultSet.next()){
							actividad = new ActividadExtraclase(
									resultSet.getInt("id"),
									resultSet.getString("cve_actividad_extraclase"),
									resultSet.getString("description"),
									resultSet.getString("lugar"),
									resultSet.getString("total_horas"),
									resultSet.getString("tipo_actividad"));
						}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return actividad;
	}
	
	

}
