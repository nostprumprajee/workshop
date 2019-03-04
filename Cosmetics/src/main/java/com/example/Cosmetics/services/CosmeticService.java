package com.example.Cosmetics.services;

import java.util.List;

import com.example.Cosmetics.entities.Cosmetic;
import com.example.Cosmetics.repositories.CosmeticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CosmeticService {

	@Autowired
	private CosmeticRepository cosmeticRepository;
	
	public List<Cosmetic> getAllCosmetics(){
			return cosmeticRepository.findAll();
	}

	public void addCosmetic(Cosmetic cosmetic){
		cosmeticRepository.save(cosmetic);
	}

	public void deleteCosmetic(String id) {
		cosmeticRepository.deleteById(id);
	}
}