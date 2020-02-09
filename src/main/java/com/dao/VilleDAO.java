package com.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {
	public ArrayList<Ville> getVille();
	public void deleteVille(Ville ville) throws SQLException;
	public void putVille(Ville ville) throws SQLException;
}