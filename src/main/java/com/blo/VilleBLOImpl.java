package com.blo;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.MissionDAO;
import com.dao.VilleDAO;
import com.dto.Mission;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {

	@Autowired
	private VilleDAO villeDAO;

	@Override
	public ArrayList<Ville> getInfoVille(Ville ville) throws VilleException, SQLException {
		ArrayList<Ville> listVille;

		if (ville.getCodePostal() == null || "".equalsIgnoreCase(ville.getCodePostal())) {
			listVille = villeDAO.getVille();
		} else {
			listVille = villeDAO.findAllVille(ville);
		}
		System.out.println("Nombre de mission récupéré : " + listVille.size());

		return listVille;
	}

	@Override
	public void addVille(String ville) throws SQLException {
		 ville ville = new ville();
		ville=formalismePasFou(ville);
		villeDAO.putVille(ville);
		
	}

	@Override
	public void postVille(String ville) throws SQLException {
		 ville ville = new ville();
		ville=formalismePasFou(ville);
		villeDAO.modifyVille(ville);
		
	}

	@Override
	public void deleteVille(String codeCommuneInsee) throws SQLException {
		ville ville = new ville();
		ville.setCodeCommuneInsee(codeCommuneInsee);
		villeDAO.deleteVille(ville);
	}
	

}