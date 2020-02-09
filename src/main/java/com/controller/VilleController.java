package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
//@RequestMapping("/path")
class villeController {

	@Autowired
	VilleBLO villeService;

	// Methode GET
	@RequestMapping(value = "/ville", method = RequestMethod.GET)
	@ResponseBody
	public List<Ville> get(@RequestParam(required = false, value = "osef") String osef)
			throws SQLException {
		List<Ville> listeVilles = new ArrayList<Ville>();
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection connexion = DriverManager.getConnection(
				"jdbc:mysql://localhost/maven?useLegacyDatetimeCode=false&serverTimezone=Europe/Paris", "root", "");
		Statement stmt = connexion.createStatement();
		String sql_query = "SELECT * FROM `ville_france`";
		ResultSet result = stmt.executeQuery(sql_query);

		while (result.next()) {
			listeVilles.add(new Ville(result.getString("Code_commune_INSEE"),
					result.getString("Nom_commune"),
					result.getString("Code_postal"),
					result.getString("Libelle_acheminement"),
					result.getString("Ligne_5"),
					result.getString("Latitude"), 
					result.getString("Longitude")));
		}

		result.close();
		stmt.close();
		connexion.close();
	return listeVilles;

	}

	// Methode POST
	@RequestMapping(value = "/villePost", method = RequestMethod.POST)
	@ResponseBody
	public String post(@RequestParam(required = false, value = "code_commune_INSEE") String code_commune_INSEE)
			throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection connexion = DriverManager.getConnection(
				"jdbc:mysql://localhost/maven?useLegacyDatetimeCode=false&serverTimezone=Europe/Paris", "root", "");
		Statement statement = connexion.createStatement();
		String query = "UPDATE `ville_france` SET `Code_commune_INSEE`='" + code_commune_INSEE
				+ "' WHERE `Code_commune_INSEE`=" + code_commune_INSEE + ";";
		statement.execute(query);
		statement.close();
		connexion.close();
		villeService.postVille(code_commune_INSEE);
		return "JSON POST";
	}

	// Methode DELETE
	@RequestMapping(value = "/villeDelete", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(@RequestParam(required = false, value = "code_commune_INSEE") String code_commune_INSEE)
			throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection connexion = DriverManager.getConnection(
				"jdbc:mysql://localhost/maven?useLegacyDatetimeCode=false&serverTimezone=Europe/Paris", "root", "");
		Statement statement = connexion.createStatement();
		String query = "DELETE FROM `ville_france` WHERE `Code_commune_INSEE`=00000;";
		statement.execute(query);
		statement.close();
		connexion.close();
		villeService.deleteVille(code_commune_INSEE);
		return "JSON DELETE";
	}

	// Methode PUT
	@RequestMapping(value = "/villePut", method = RequestMethod.PUT)
	@ResponseBody
	public String put(@RequestParam(required = false, value = "code_commune_INSEE") String code_commune_INSEE)
			throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/maven?useLegacyDatetimeCode=false&serverTimezone=Europe/Paris", "root", "");
		Statement statement = connection.createStatement();
		String query = "INSERT INTO `ville_france`(`Code_commune_INSEE`, `Nom_commune`, `Code_postal`, `Libelle_acheminement`, `Ligne_5`, `Latitude`, `Longitude`) VALUES ('00000', 'oui ', '00000', 'oui ', '', '10', '-10');";
		statement.execute(query);
		statement.close();
		connection.close();
		villeService.putVille(code_commune_INSEE);
		return "JSON PUT";
	}
}