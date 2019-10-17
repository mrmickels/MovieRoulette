package com.filmroulette.service;

import org.springframework.stereotype.Component;
import com.filmroulette.dto.UpcomingMovieDTO;


@Component
public class UpcomingMovieServiceStub implements IUpcomingMovieService {
	
//	@Override
//	public SpecimenDTO fetchById(int id) {
//		SpecimenDTO specimenDTO = new SpecimenDTO();
//		specimenDTO.setSpecimenId(43);
//		specimenDTO.setLatitude("40.70");
//		specimenDTO.setLongitude("-65.42");
//		specimenDTO.setDescription("A Beautiful Eastern RedBud");
//		return specimenDTO;
//	}


	@Override
	public UpcomingMovieDTO fetchById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(UpcomingMovieDTO upcomingMovieDTO) {
		
	}

}
