package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
//@RequestMapping("/path")
class villeController {

	@Autowired
	VilleBLO villeService;

	// Methode GET
    @GetMapping("/get")
    public String get(@RequestParam(required = false, value = "Nom_commune") String Nom_commune) {
        List<Ville> response = villeService.getVille(Nom_commune);
        return response.toString();
    }

	// Methode POST
	@PostMapping("/post")
	@ResponseBody
	public String post(@RequestBody Ville ville)
			throws SQLException {
		villeService.postVille(ville);
		return "JSON POST";
	}

	// Methode DELETE
	@GetMapping("/delete")
	public String delete(@RequestParam(required = false, value = "Nom_commune") String nom_commune)
			throws SQLException {
		villeService.deleteVille(nom_commune);
		return "JSON DELETE";
	}

	// Methode PUT
	@RequestMapping(value = "/put", method = RequestMethod.PUT)
	@ResponseBody
	public String put(@RequestParam(required = false, value = "code_commune_INSEE") Ville ville)
			throws SQLException {
		villeService.putVille(ville);
		return "JSON PUT";
	}
}