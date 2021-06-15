import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddpizzaOrderComponent } from './addpizza-order.component';

describe('AddpizzaOrderComponent', () => {
  let component: AddpizzaOrderComponent;
  let fixture: ComponentFixture<AddpizzaOrderComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddpizzaOrderComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddpizzaOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
