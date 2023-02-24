package com.api.dao;

import java.util.List;

import com.api.entity.Etudiant;

public interface DaoEtud {

	void saveEtudiant(Etudiant Etudiant);

	Etudiant getEtudiantById(int id);

	List<Etudiant> getAllEtudiants();

	int updateEtudiant(int id,Etudiant Etudiant);

	int deleteEtudiantById(int id);

}
