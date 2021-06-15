import { TestBed } from '@angular/core/testing';

import { CoupanService } from './coupan.service';

describe('CoupanService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CoupanService = TestBed.get(CoupanService);
    expect(service).toBeTruthy();
  });
});
