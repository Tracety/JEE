package com.blo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {

	@Autowired
	private VilleDAO villeDAO;

	public List<Ville> getVille(String ville) throws VilleException{
		List<Ville> listeVille;
		if (ville == null || "".equalsIgnoreCase(ville)) {
			listeVille = villeDAO.allVille();
        } else {
        	listeVille = villeDAO.getVille(ville);
        }
		return listeVille;
	}
	
	
	public void putVille(Ville ville) throws SQLException {
		villeDAO.putVille(ville);
	}

	
	public void postVille(Ville ville) throws SQLException {
		villeDAO.postVille(ville);
	}

	
	public void deleteVille(String Nom_commune) throws SQLException {
		villeDAO.deleteVille(Nom_commune);
	}
	

}