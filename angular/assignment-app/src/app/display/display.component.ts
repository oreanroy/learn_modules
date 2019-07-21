import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css'],
  
})
export class DisplayComponent implements OnInit {
  show = "block";
  range = [];
  count = 0;
  

  constructor() { }

  buttonClick(){
    this.count++;
    this.range = []
    for (var i=0;i<this.count;i++){
      this.range.push(i);
    }
  }

  ngOnInit() {
  }

  getDisplay(){
    if (this.show === "block") {
      this.show = "none";
      } else{
      this.show= "block";
    }
  }

}
