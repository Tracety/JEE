package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfigurationSol1;
import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {
	private static final String SQL_INSERT = "INSERT INTO ville_france (Code_commune_INSEE, Nom_commune, "
			+ "Code_postal, Libelle_acheminement, Ligne_5, Latitude, Longitude) " + "VALUES (";
	@Override
	public ArrayList<Ville> getVille() {
		ArrayList<Ville> listVille = new ArrayList<Ville>();

		try {
			Connection con = JDBCConfigurationSol1.getConnection();
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM ville_france");
			while (resultSet.next()) {
				Ville ville = new Ville(null, null, null, null, null, null, null);

				ville.setCodeCommuneInsee(resultSet.getString("Code_commune_INSEE"));
				ville.setNomCommune(resultSet.getString("Nom_commune"));
				ville.setCodePostal(resultSet.getString("Code_postal"));
				ville.setLibelleAcheminement(resultSet.getString("Libelle_acheminement"));
				ville.setLigne5(resultSet.getString("Ligne_5"));
				ville.setLattitude(resultSet.getString("Latitude"));
				ville.setLongitude(resultSet.getString("Longitude"));

				listVille.add(ville);
			}
			resultSet.close();
			statement.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listVille;

	}

	@Override
	public void deleteVille(Ville ville) throws SQLException {
		Connection con = JDBCConfigurationSol1.getConnection();
		Statement statement = con.createStatement();
		PreparedStatement preparedStatement = con.prepareStatement(
				"DELETE FROM ville_france WHERE " + "Code_Commune_INSEE LIKE '%" + ville.getCodeCommuneInsee() + "%'");
		preparedStatement.executeUpdate();
		preparedStatement.close();
		statement.close();

	}

	@Override
	public void putVille(Ville ville) throws SQLException {
		Connection con = JDBCConfigurationSol1.getConnection();
		Statement statement = con.createStatement();
		PreparedStatement preparedStatement = con.prepareStatement(SQL_INSERT + "'" + ville.getCodeCommuneInsee()
				+ "', " + "'" + ville.getNomCommune() + "', " + "'" + ville.getCodePostal() + "', " + "'"
				+ ville.getLibelleAcheminement() + "', " + "'" + ville.getLigne5() + "', " + "'" + ville.getLattitude()
				+ "', " + "'" + ville.getLongitude() + "')");
		preparedStatement.executeUpdate();
		preparedStatement.close();
		statement.close();
	}

	@Override
	public ArrayList<Ville> findAllVille() {
		return null;
	}

}