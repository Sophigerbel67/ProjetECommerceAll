import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RechercherPComponent } from './rechercher-p.component';

describe('RechercherPComponent', () => {
  let component: RechercherPComponent;
  let fixture: ComponentFixture<RechercherPComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RechercherPComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RechercherPComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
