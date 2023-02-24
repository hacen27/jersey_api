package com.api.dao;

import java.util.List;

import com.api.entity.Vacations;

public interface  DaoVocations {
	void saveVacations(Vacations Vacations);

	Vacations getVacationsById(int id);

	List<Vacations> getAllVacations();

	int updateVacations(int id,Vacations Vacations);

	int deleteVacationsById(int id);
	
	

}
