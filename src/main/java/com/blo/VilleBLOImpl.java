package com.blo;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {

	@Autowired
	private VilleDAO villeDAO;

	@Override
	public ArrayList<Ville> getInfoVille(Ville ville) throws VilleException, SQLException {
		ArrayList<Ville> listVille;

		if (ville.getCodeCommuneInsee() == null || "".equalsIgnoreCase(ville.getCodePostal())) {
			listVille = villeDAO.getVille();
		} else {
			listVille = villeDAO.findAllVille();
		}
		System.out.println("Nombre de ville récupéré : " + listVille.size());

		return listVille;
	}

	@Override
	public void putVille(String ville) throws SQLException {
		Ville ville1 = new Ville(null, null, null, null, null, null, null);
		villeDAO.putVille(ville1);
		
	}

	@Override
	public void postVille(String ville) throws SQLException {

	}

	@Override
	public void deleteVille(String codeCommuneInsee) throws SQLException {
		Ville ville1 = new Ville(null, null, null, null, null, null, null);
		villeDAO.deleteVille(ville1);
	}
	

}