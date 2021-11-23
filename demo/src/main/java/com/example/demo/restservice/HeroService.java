package com.example.demo.restservice;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeroService implements IHeroService{
  List<Hero> heroes = new ArrayList<>();

  public HeroService() {
    heroes.add(new Hero(11L, "Dr Nice"));
    heroes.add(new Hero(12L, "Narco"));
    heroes.add(new Hero(13L, "Bombasto"));
    heroes.add(new Hero(14L, "Celeritas"));
    heroes.add(new Hero(15L, "Magneta"));
    heroes.add(new Hero(16L, "RubberMan"));
    heroes.add(new Hero(17L, "Dynama"));
    heroes.add(new Hero(18L, "Dr IQ"));
    heroes.add(new Hero(19L, "Magma"));
    heroes.add(new Hero(20L, "Tornado"));
  }

  @Override
  public Hero getHeroById(Long id) {
    for (Hero hero : heroes) {
      if (hero.getId() == id) {
        return hero;
      }
    }
    return null;
  }

  @Override
  public List<Hero> getHeroByName(String name) {
    List<Hero> filteredHeroes = new ArrayList<>();

    for(Hero hero: heroes){
      if(hero.getName().contains(name)){
        filteredHeroes.add(hero);
      }
    }
    return filteredHeroes;
  }


  @Override
  public List<Hero> getAllHeroes() {
    return this.heroes;
  }

  @Override
  public Hero addNewHero(Hero hero) {

    //hero.setId(hero.getId() == 0 ? heroes.size()+11 : hero.getId());
    hero.setId(heroes.get(heroes.size()-1).getId()+1);
    heroes.add(hero);
    return hero;
  }

  @Override
  public void deleteHero(Long id) {
    Hero deletedHero=null;
    for (Hero hero : heroes) {
      if (hero.getId() == id)
        deletedHero = hero;
    }
    heroes.remove(deletedHero);
  }

  @Override
  public void updateHero(Hero hero) {
    for (Hero heroInList : heroes) {
      if(hero.getId()==heroInList.getId()){
        heroInList.setName(hero.getName());
    }
    }
  }
}
