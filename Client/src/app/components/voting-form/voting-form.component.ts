import { LoginService } from './../../services/login.service';
import { VotingServiceService } from './../../services/voting-service.service';
import { Component, OnInit } from '@angular/core';
import { Candidate } from 'src/app/app.module';
import { LinkedList } from 'ngx-bootstrap';

@Component({
  selector: 'app-voting-form',
  templateUrl: './voting-form.component.html',
  styleUrls: ['./voting-form.component.css']
})
export class VotingFormComponent implements OnInit {

  candidatesList: LinkedList<Candidate>;

  getCandidates() {
    this.votingService.getCandidates();
    this.candidatesList = this.votingService.candidatesList;

  }

  vote(id: number, numberOfVotes: number) {
    this.votingService.vote(id, numberOfVotes, this.loginService.authenticatedName);
  }

  constructor(private votingService: VotingServiceService, private loginService: LoginService) { }

  ngOnInit() {
  }

}
