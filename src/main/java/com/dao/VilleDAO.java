package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blo.VilleException;
import com.dto.Ville;

public interface VilleDAO {
	public List<Ville> allVille();
    ArrayList<Ville> getVille(String ville) throws VilleException;
	public void deleteVille(String Nom_commune) throws SQLException;
	public void putVille(Ville ville) throws SQLException;
	public void postVille(Ville ville) throws SQLException;
}