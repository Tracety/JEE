package com.dto.client;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "code_commune_INSEE", "nom_commune", "code_Postal", "libelle_Acheminement", "ligne_5",
		"latitude","longitude" })
public class VilleClient {

	@JsonProperty("code_commune_INSEE")
	private String code_commune_INSEE;
	@JsonProperty("nom_commune")
	private String nom_commune;
	@JsonProperty("code_Postal")
	private String code_Postal;
	@JsonProperty("libelle_Acheminement")
	private String libelle_Acheminement;
	@JsonProperty("ligne_5")
	private String ligne_5;
	@JsonProperty("latitude")
	private String latitude;
	@JsonProperty("longitude")
	private String longitude;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("code_commune_INSEE")
	public String getCode_commune_INSEE() {
		return code_commune_INSEE;
	}

	@JsonProperty("code_commune_INSEE")
	public void setCode_commune_INSEE(String code_commune_INSEE) {
		this.code_commune_INSEE = code_commune_INSEE;
	}

	@JsonProperty("nom_commune")
	public String getNom_commune() {
		return nom_commune;
	}

	@JsonProperty("nom_commune")
	public void setNom_commune(String nom_commune) {
		this.nom_commune = nom_commune;
	}

	@JsonProperty("code_Postal")
	public String getCode_Postal() {
		return code_Postal;
	}

	@JsonProperty("code_Postal")
	public void setCode_Postal(String code_Postal) {
		this.code_Postal = code_Postal;
	}

	@JsonProperty("libelle_Acheminement")
	public String getLibelle_Acheminement() {
		return libelle_Acheminement;
	}

	@JsonProperty("libelle_Acheminement")
	public void setLibelle_Acheminement(String libelle_Acheminement) {
		this.libelle_Acheminement = libelle_Acheminement;
	}

	@JsonProperty("ligne_5")
	public String getLigne_5() {
		return ligne_5;
	}

	@JsonProperty("ligne_5")
	public void setLigne_5(String ligne_5) {
		this.ligne_5 = ligne_5;
	}

	@JsonProperty("latitude")
	public String getLatitude() {
		return latitude;
	}

	@JsonProperty("latitude")
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
