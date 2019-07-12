import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-inputest',
  templateUrl: './inputest.component.html',
  styleUrls: ['./inputest.component.css']
})
export class InputestComponent implements OnInit {
  username = ""
  constructor() { }

  ngOnInit() {
  }
  reset(){
    this.username = ''
  }

}
