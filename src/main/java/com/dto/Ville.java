package com.dto;


public class Ville{

	private String code_commune_INSEE;
	private String nom_commune;
	private String code_Postal;
	private String libelle_Acheminement;
	private String ligne_5;
	private String latitude;
	private String longitude;

	public Ville(String codeCommuneInsee, String nomCommune, String codePostal, String libelleAcheminement,
			String ligne5, String lattitude, String longitude) {
		super();
		this.code_commune_INSEE = codeCommuneInsee;
		this.nom_commune = nomCommune;
		this.code_Postal = codePostal;
		this.libelle_Acheminement = libelleAcheminement;
		this.ligne_5 = ligne5;
		this.latitude = lattitude;
		this.longitude = longitude;
	}


	public String getCodeCommuneInsee() {
		return code_commune_INSEE;
	}

	public void setCodeCommuneInsee(String codeCommuneInsee) {
		this.code_commune_INSEE = codeCommuneInsee;
	}

	public String getNomCommune() {
		return nom_commune;
	}

	public void setNomCommune(String nomCommune) {
		this.nom_commune = nomCommune;
	}

	public String getCodePostal() {
		return code_Postal;
	}

	public void setCodePostal(String codePostal) {
		this.code_Postal = codePostal;
	}

	public String getLibelleAcheminement() {
		return libelle_Acheminement;
	}

	public void setLibelleAcheminement(String libelleAcheminement) {
		this.libelle_Acheminement = libelleAcheminement;
	}

	public String getLigne5() {
		return ligne_5;
	}

	public void setLigne5(String ligne5) {
		this.ligne_5 = ligne5;
	}

	public String getLattitude() {
		return latitude;
	}

	public void setLattitude(String lattitude) {
		this.latitude = lattitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}
