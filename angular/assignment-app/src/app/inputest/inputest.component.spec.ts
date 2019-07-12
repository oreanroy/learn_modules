import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InputestComponent } from './inputest.component';

describe('InputestComponent', () => {
  let component: InputestComponent;
  let fixture: ComponentFixture<InputestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InputestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InputestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
