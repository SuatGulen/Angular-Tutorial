package com.example.demo.restcontroller;

import com.example.demo.restservice.Hero;
import com.example.demo.restservice.HeroService;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HeroController {

  private final HeroService heroService;

  public HeroController(HeroService heroService)
  {
    this.heroService = heroService;
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/heroes/{id}")
  public Hero getHeroById(@PathVariable("id") Long id)
  {
   return heroService.getHeroById(id);
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @GetMapping("/heroes")
  public List<Hero> getAllHeroes(){
    return heroService.getAllHeroes();
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @PostMapping("/heroes")
  public void addNewHero(@RequestBody @NonNull Hero hero)
  {
    heroService.addNewHero(hero);
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @DeleteMapping("/heroes/{id}")
  public void deleteHero(@PathVariable("id") Long id)
  {
    this.heroService.deleteHero(id);
  }

  @CrossOrigin(origins = "http://localhost:4200")
  @PutMapping("/heroes")
  public void updateHero(@RequestBody @NonNull Hero hero)
  {
    heroService.updateHero(hero);
  }

}
