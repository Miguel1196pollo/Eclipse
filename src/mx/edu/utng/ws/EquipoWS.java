package mx.edu.utng.ws;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EquipoWS {
	
	private Connection connection;
	private Statement statement;
	private ResultSet resultSet;
	private PreparedStatement ps;

	public EquipoWS(){
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

	public int addEquipo(Equipo equipo){
		int result = 0;
		if (connection!= null) {
			try {
				ps = connection.prepareStatement(
						"INSERT INTO equipo (nombre,tipo_equipo,numero_equipo,descripcion, filial, estatus) "
						+ "VALUES(?,?,?,?,?,?);");
				ps.setString(1, equipo.getNombre());
				ps.setString(2, equipo.getTipoEquipo());
				ps.setString(3, equipo.getNumeroEquipo());
				ps.setString(4, equipo.getDescripcion());
				ps.setString(5, equipo.getFilial());
				ps.setString(6, equipo.getEstatus());
				
				result = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}	

	public int editEquipo(Equipo equipo){
		int result = 0;
		if(connection!=null){
			try {
				ps = connection.prepareStatement(
						"UPDATE equipo SET nombre =?,"
						+ "tipo_equipo= ?,"
						+ "numero_equipo = ?,"
						+ "descripcion =?,"
						+ "filial = ?,"
						+ "estatus = ?,"
						+ "WHERE id =?;");
				ps.setString(1, equipo.getNombre());
				ps.setString(2, equipo.getTipoEquipo());
				ps.setString(3, equipo.getNumeroEquipo());
				ps.setString(4, equipo.getDescripcion());
				ps.setString(5, equipo.getFilial());
				ps.setString(6, equipo.getEstatus());
				ps.setInt(7, equipo.getId());
				result = ps.executeUpdate();
			} catch (SQLException e) {
		e.printStackTrace();
			}
		}
		return result;
	}

	public int removeEquipo(int id){
		int result = 0;
		if (connection!= null) {
			try {
				ps = connection.prepareStatement(
						"DELETE FROM equipo WHERE id = ?;");
				ps.setInt(1, id);
				result = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public Equipo[] getEquipos(){
		Equipo[] result = null;
		List<Equipo>  equipos = new ArrayList<Equipo>();
		if (connection!= null) {
			try {
				statement = connection.createStatement();
				resultSet = statement.executeQuery("SELECT * FROM equipo;");
						while(resultSet.next()){
							Equipo equipo = new Equipo(
									resultSet.getInt("id"),
									resultSet.getString("nombre"),
									resultSet.getString("tipo_equipo"),
									resultSet.getString("numero_equipo"),
									resultSet.getString("descripcion"),
									resultSet.getString("filial"),
									resultSet.getString("estatus"));
							equipos.add(equipo);
						}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		result = equipos.toArray(new Equipo[equipos.size()]);
		return result;
	}

	public Equipo getEquiposById(int id){
		Equipo  equipo = null;
		if (connection!= null) {
			try {
				ps = connection.prepareStatement("SELECT * FROM equipo WHERE id = ?;");
				ps.setInt(1, id);
				resultSet = ps.executeQuery();
						while(resultSet.next()){
							equipo = new Equipo(
									resultSet.getInt("id"),
									resultSet.getString("nombre"),
									resultSet.getString("tipo_equipo"),
									resultSet.getString("numero_equipo"),
									resultSet.getString("descripcion"),
									resultSet.getString("filial"),
									resultSet.getString("estatus"));
						}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return equipo;
	}
	
	
}
