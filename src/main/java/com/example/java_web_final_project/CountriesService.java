package com.example.java_web_final_project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountriesService{
        private final CountriesRepository countriesRepository;

        public CountriesService(@Autowired CountriesRepository countriesRepository) {
            this.countriesRepository = countriesRepository;
        }


        public Countries save(Countries countries) {
            //TODO implement this method
            return countriesRepository.save(countries);
        }

        public void delete(int countryId) {
            //TODO implement this method
            countriesRepository.deleteById(countryId);
        }

        public List<Countries> getAll()
        {
            //TODO implement this method
            return countriesRepository.findAll();
        }

        public Countries findById(int countriesId) {
            //TODO implement this method
            Optional<Countries> countries = countriesRepository.findById(countriesId);
            return countries.get();
        }
    }


