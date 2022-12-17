package com.example.java_web_final_project.controller;

import com.example.java_web_final_project.Countries;
import com.example.java_web_final_project.CountriesRepository;
import com.example.java_web_final_project.CountriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
    public class CountriesController {
        private CountriesService countriesService;
        final CountriesRepository countriesRepository;



        public CountriesController(@Autowired CountriesRepository countriesRepository, @Autowired CountriesService countriesService) {
            this.countriesRepository = countriesRepository;
            this.countriesService = countriesService;
        }

        @GetMapping(path = "/all")
        public List<Countries> getCountries(){
            return countriesService.getAll();
        }
        @PostMapping
        public Countries save(@RequestBody Countries countries) {
            return countriesService.save(countries);
        }
        @GetMapping("/{id}")
        public Countries findCountryById (@PathVariable Integer id) {
            return countriesService.findById(id);
        }
        @PutMapping("/{id}")
        public Countries update(@RequestBody Countries countries, @PathVariable Integer id )
        {
//            Countries countries = countriesService.findById(id);
            countries.setId(countries.getId());
            countries.setName(countries.getName());
            countries.setLanguage(countries.getLanguage());
            countries.setPopulation(countries.getPopulation());
            return countriesService.save(countries);
        }

        @DeleteMapping( "/{id}" )
        public void delete(@PathVariable Integer id )
        {
            countriesService.delete(id);
        }
}

