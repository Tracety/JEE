package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.blo.VilleException;
import com.config.JDBCConfiguration;
import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO{
	 private static final String SQL_INSERT = "INSERT INTO ville_france (Code_commune_INSEE, Nom_commune, "
	            + "Code_postal, Libelle_acheminement, Ligne_5, Latitude, Longitude) ";
	 
	@Override
	public ArrayList<Ville> getVille(String ville) {
		ArrayList<Ville> listeVille = new ArrayList<Ville>();

		try {

			Connection con = JDBCConfiguration.getConnection();
			try (Statement statement = con.createStatement()){
			ResultSet resultSet = statement.executeQuery("SELECT * FROM ville_france WHERE Nom_commune LIKE \""
					+ ville + "\"");
			
			while (resultSet.next()) {
				Ville ville2 = new Ville();
				
				ville2.setCodeCommuneInsee(resultSet.getString("Code_commune_INSEE"));
				ville2.setNomCommune(resultSet.getString("Nom_commune"));
				ville2.setCodePostal(resultSet.getString("Code_postal"));
				ville2.setLibelleAcheminement(resultSet.getString("Libelle_acheminement"));
				ville2.setLigne5(resultSet.getString("Ligne_5"));
				ville2.setLattitude(resultSet.getString("Latitude"));
				ville2.setLongitude(resultSet.getString("Longitude"));
				
				listeVille.add(ville2);
	
			}

			resultSet.close();
			statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listeVille;
	}

	@Override
	public void deleteVille(String Nom_commune) throws SQLException {

					try (Connection con = JDBCConfiguration.getConnection()){
					try (Statement statement = con.createStatement()){

					// execute la requete
					try {
						try (PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM ville_france WHERE "
						+ "'Nom_Commune' LIKE '%" + Nom_commune + "%'")) {
						preparedStatement.executeUpdate();
						preparedStatement.close();
						statement.close();
						
					} 
					}catch (SQLException e) {
						e.printStackTrace();
					}
					}catch (SQLException e) {
						e.printStackTrace();
					}
					} catch (SQLException e) {
						e.printStackTrace();
					}
		
	}

	@Override
	public void putVille(Ville ville) throws SQLException {
		Connection con = JDBCConfiguration.getConnection();
		// solution 2
		// Connection con = JDBCConfigurationSol2.getConnection();
		try (Statement statement = con.createStatement()){
		PreparedStatement preparedStatement = con.prepareStatement(SQL_INSERT+ "VALUES ("+ "'" 
		+ ville.getCodeCommuneInsee()
        + "', " + "'" + ville.getNomCommune() + "', " + "'" + ville.getCodePostal()
        + "', " + "'" + ville.getLibelleAcheminement() + "', " + "'" + ville.getLigne5()
        + "', " + "'" + ville.getLatitude() + "', " + "'" + ville.getLongitude() + "')");
		preparedStatement.executeUpdate();
		preparedStatement.close();
		statement.close();
		}
	}
	
	@Override
	public void postVille(Ville ville) throws SQLException {
		Connection con = JDBCConfiguration.getConnection();
		
		// solution 2
		// Connection con = JDBCConfigurationSol2.getConnection();
		try (Statement statement = con.createStatement()){
		PreparedStatement preparedStatement = con.prepareStatement(SQL_INSERT+ "VALUES ("+ "'" 
		+ ville.getCodeCommuneInsee()
        + "', " + "'" + ville.getNomCommune() + "', " + "'" + ville.getCodePostal()
        + "', " + "'" + ville.getLibelleAcheminement() + "', " + "'" + ville.getLigne5()
        + "', " + "'" + ville.getLatitude() + "', " + "'" + ville.getLongitude() + "')");
		preparedStatement.executeUpdate();
		preparedStatement.close();
		statement.close();
		}
	}

	@Override
	public List<Ville> allVille() {
		List<Ville> listeVille = new ArrayList<Ville>();

		try {

			Connection con = JDBCConfiguration.getConnection();
			try (Statement statement = con.createStatement()){
			ResultSet resultSet = statement.executeQuery("SELECT * FROM ville_france");
			
			while (resultSet.next()) {
				Ville ville = new Ville();
				
				ville.setCodeCommuneInsee(resultSet.getString("Code_commune_INSEE"));
				ville.setNomCommune(resultSet.getString("Nom_commune"));
				ville.setCodePostal(resultSet.getString("Code_postal"));
				ville.setLibelleAcheminement(resultSet.getString("Libelle_acheminement"));
				ville.setLigne5(resultSet.getString("Ligne_5"));
				ville.setLattitude(resultSet.getString("Latitude"));
				ville.setLongitude(resultSet.getString("Longitude"));
				
				listeVille.add(ville);
	
			}

			resultSet.close();
			statement.close();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listeVille;
	}
}