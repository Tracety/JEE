package com.blo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dto.Ville;

public interface VilleBLO {
	
	List<Ville> getVille(String ville) throws VilleException;
	void deleteVille(String Nom_commune) throws SQLException;
	void putVille(Ville ville) throws SQLException;
	void postVille(Ville ville) throws SQLException;
}
