import { TestBed } from '@angular/core/testing';

import { VotingServiceService } from './voting-service.service';

describe('VotingServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: VotingServiceService = TestBed.get(VotingServiceService);
    expect(service).toBeTruthy();
  });
});
