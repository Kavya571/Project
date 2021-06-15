import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddcoupanComponent } from './addcoupan.component';

describe('AddcoupanComponent', () => {
  let component: AddcoupanComponent;
  let fixture: ComponentFixture<AddcoupanComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddcoupanComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddcoupanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
