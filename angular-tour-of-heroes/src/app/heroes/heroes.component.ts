import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import { Hero } from '../hero';
import { HeroService } from '../hero.service';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css'],
})

export class HeroesComponent implements OnInit {

  counter: number = 0;
  heroes: Hero[] = [];
  //timer: String[] = [];
  @Output() myOutputName = new EventEmitter();


  constructor(private heroService: HeroService) {}

  ngOnInit() {
    this.getHeroes();
  }

  ngOnChanges(){
    console.log("..");
  }



  getHeroes(): void {
    this.heroService.getHeroes()
      .subscribe(heroes => {
        console.log("Heroes= ", heroes);
        this.heroes = heroes;
      });
  }
  add(name: string): void {
    name = name.trim();
    if (!name) { return; }
    this.heroService.addHero({ name } as Hero)
      .subscribe(hero => {
        console.log("Hero= ", hero);
        this.heroes.push(hero);
        // this.ngOnInit();
      });
  }
  delete(hero: Hero): void {
    this.heroes = this.heroes.filter(h => h !== hero);
    this.heroService.deleteHero(hero.id).subscribe();
  }
}
