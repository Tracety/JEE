package com.dto;


public class Ville{

	private String code_Commune_INSEE;
	private String nom_Commune;
	private String code_Postal;
	private String libelle_Acheminement;
	private String ligne_5;
	private String latitude;
	private String longitude;

	public Ville(String code_Commune_INSEE, String nom_Commune, String code_Postal, String libelleAcheminement,
			String ligne5, String latitude, String longitude) {
		super();
		this.code_Commune_INSEE = code_Commune_INSEE;
		this.nom_Commune = nom_Commune;
		this.code_Postal = code_Postal;
		this.libelle_Acheminement = libelleAcheminement;
		this.ligne_5 = ligne5;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	public Ville() {
		
	}


	public String getCodeCommuneInsee() {
		return code_Commune_INSEE;
	}

	public void setCodeCommuneInsee(String code_Commune_INSEE) {
		this.code_Commune_INSEE = code_Commune_INSEE;
	}

	public String getNomCommune() {
		return nom_Commune;
	}

	public void setNomCommune(String nom_Commune) {
		this.nom_Commune = nom_Commune;
	}

	public String getCodePostal() {
		return code_Postal;
	}

	public void setCodePostal(String code_Postal) {
		this.code_Postal = code_Postal;
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

	public String getLatitude() {
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

	// format JSON pour le front
	@Override
    public String toString() {
        return "{ \"code_Commune_INSEE\":" +"\""+ this.code_Commune_INSEE +"\""+ ", \"nom_Commune\":" +"\""+ this.nom_Commune
                +"\""+ ", \"code_Postal\":" +"\""+ this.code_Postal +"\""+ ", \"libelle_Acheminement\":" +"\""+
        		this.libelle_Acheminement +"\""+ ", \"ligne5\":"
                +"\""+ this.ligne_5 +"\""+ ", \"latitude\":" +"\""+ this.latitude +"\""+ ", \"longitude\":"
        		+"\""+ this.longitude +"\""+ " }";
    }
}
