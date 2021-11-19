package com.example.demo.restservice;

import java.util.List;

public interface IHeroService {

   Hero getHeroById(Long id);

   Hero getHeroByName(String name);

   List<Hero> getAllHeroes();

   void addNewHero(Hero hero);

   void deleteHero(Long id);

   void updateHero(Hero hero);
}
