package com.blo;

import java.sql.SQLException;
import java.util.ArrayList;
import com.dto.Ville;

public interface VilleBLO {
	
	ArrayList<Ville> getInfoVille(Ville ville) throws MissionException, VilleException, SQLException;
	void postVille(String Code_commune_INSEE) throws SQLException;
	void deleteVille(String Code_commune_INSEE) throws SQLException;
	void putVille(String Code_commune_INSEE) throws SQLException;
}
