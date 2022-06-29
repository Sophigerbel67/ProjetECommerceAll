import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProduitsClientComponent } from './produits-client.component';

describe('ProduitsClientComponent', () => {
  let component: ProduitsClientComponent;
  let fixture: ComponentFixture<ProduitsClientComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProduitsClientComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProduitsClientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
