package com.example.demo.restservice;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class HeroService implements IHeroService{
  List<Hero> heroes = new ArrayList<>();

  public HeroService() {
    heroes.add(new Hero(11L, "Dr Nice"));
    heroes.add(new Hero(12L, "Narco"));
    heroes.add(new Hero(13L, "Bombasto;"));
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
  public List<Hero> getAllHeroes() {
    return this.heroes;
  }

  @Override
  public void addNewHero(Hero hero) {

    hero.setId(hero.getId() == 0 ? heroes.size() : hero.getId());
    //tempId=heroes.indexOf(heroes.get(heroes.size()-1)).getId;
    heroes.add(hero);
  }

  @Override
  public void deleteHero(Long id) {
    for (Hero hero : heroes) {
      if (hero.getId() == id)
        heroes.remove(hero);
    }
  }

  @Override
  public void updateHero(Hero hero) {
   heroes.set(heroes.indexOf(hero),hero);
  }
}
