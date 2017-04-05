package mx.edu.utng.ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CalificacionCenevalWS {
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement ps;
	
	public CalificacionCenevalWS(){
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

	public int addCalificacionCeneval(CalificacionCeneval calificacion){
		int result = 0;
		if (connection!= null) {
			try {
				ps = connection.prepareStatement(
						"INSERT INTO calificacion_ceneval (nombre_alumno,fecha_edicion,calificacion,activo) "
						+ "VALUES(?,?,?,?);");
				ps.setString(1, calificacion.getNombreAlumno());
				ps.setString(2,calificacion.getFechaEdicion());
				ps.setFloat(3, calificacion.getCalificacion());
				ps.setString(4, calificacion.getActivo());
				result = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int editCalificacionCeneval(CalificacionCeneval calificacion){
		int result = 0;
		if(connection!=null){
			try {
				ps = connection.prepareStatement(
						"UPDATE calificacion_ceneval SET nombre_alumno =?,"
						+ "fecha_edicion= ?,"
						+ "calificacion = ?,"
						+ "activo =?"
						+ "WHERE id =?;");
				ps.setString(1, calificacion.getNombreAlumno());
				ps.setString(2, calificacion.getFechaEdicion());
				ps.setFloat(3, calificacion.getCalificacion());
				ps.setString(4,  calificacion.getActivo());
				ps.setInt(5, calificacion.getId());
				result = ps.executeUpdate();
			} catch (SQLException e) {
		e.printStackTrace();
			}
		}
		return result;
	}

	public int removeCalificacionCeneval(int id){
		int result = 0;
		if (connection!= null) {
			try {
				ps = connection.prepareStatement(
						"DELETE FROM calificacion_ceneval WHERE id = ?;");
				ps.setInt(1, id);
				result = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public CalificacionCeneval[] getCalificaciones(){
		CalificacionCeneval[] result = null;
		List<CalificacionCeneval>  calificaciones = new ArrayList<CalificacionCeneval>();
		if (connection!= null) {
			try {
				statement = connection.createStatement();
				resultSet = statement.executeQuery("SELECT * FROM calificacion_ceneval;");
						while(resultSet.next()){
							CalificacionCeneval calificacion = new CalificacionCeneval(
									resultSet.getInt("id"),
									resultSet.getString("nombre_alumno"),
									resultSet.getString("fecha_edicion"),
									resultSet.getFloat("calificacion"),
									resultSet.getString("activo"));
							calificaciones.add(calificacion);
						}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		result = calificaciones.toArray(new CalificacionCeneval[calificaciones.size()]);
		return result;
	}

	public CalificacionCeneval getCalificacionesById(int id){
		CalificacionCeneval  calificacion = null;
		if (connection!= null) {
			try {
				ps = connection.prepareStatement("SELECT * FROM calificacion_ceneval WHERE id = ?;");
				ps.setInt(1, id);
				resultSet = ps.executeQuery();
						while(resultSet.next()){
							calificacion = new CalificacionCeneval(
									resultSet.getInt("id"),
									resultSet.getString("nombre_alumno"),
									resultSet.getString("fecha_edicion"),
									resultSet.getFloat("calificacion"),
									resultSet.getString("activo"));
						}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return calificacion;
	}
	
	

	}