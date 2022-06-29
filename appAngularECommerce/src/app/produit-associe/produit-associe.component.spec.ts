import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProduitAssocieComponent } from './produit-associe.component';

describe('ProduitAssocieComponent', () => {
  let component: ProduitAssocieComponent;
  let fixture: ComponentFixture<ProduitAssocieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProduitAssocieComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProduitAssocieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
