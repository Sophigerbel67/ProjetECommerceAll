import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModifierCComponent } from './modifier-c.component';

describe('ModifierCComponent', () => {
  let component: ModifierCComponent;
  let fixture: ComponentFixture<ModifierCComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ModifierCComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModifierCComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
