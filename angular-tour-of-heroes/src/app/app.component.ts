import {ChangeDetectorRef, Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'Tour of Heroes';

  counter: number=0;

  ngOnInit() {
    console.log('init life cycle hook');
  }

  doNothing() {
    console.log('template evaluated');
  }

}
