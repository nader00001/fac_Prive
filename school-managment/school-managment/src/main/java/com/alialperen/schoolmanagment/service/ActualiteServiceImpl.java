package com.alialperen.schoolmanagment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alialperen.schoolmanagment.entities.Actualite;
import com.alialperen.schoolmanagment.repository.ActualiteRepository;

@Service
public class ActualiteServiceImpl implements ActualiteService {

    private final ActualiteRepository actualiteRepository;

    @Autowired
    public ActualiteServiceImpl(ActualiteRepository actualiteRepository) {
        this.actualiteRepository = actualiteRepository;
    }

    @Override
    public Actualite postActualite(Actualite actualite) {
        
        if (actualite != null && actualite.getSujet() != null && actualite.getDate() != null) {
            return actualiteRepository.save(actualite);
        }
        return null; // or throw a custom exception
    }
}
