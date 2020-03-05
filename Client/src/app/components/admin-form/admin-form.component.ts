import { AdminServiceService } from './../../services/admin-service.service';
import { Component, OnInit } from '@angular/core';
import { LinkedList } from 'ngx-bootstrap';
import { Candidate, PoliticalParty } from 'src/app/app.module';
import { Identifiers } from '@angular/compiler';

@Component({
  selector: 'app-admin-form',
  templateUrl: './admin-form.component.html',
  styleUrls: ['./admin-form.component.css']
})
export class AdminFormComponent implements OnInit {
  candidatesList: LinkedList<Candidate>;
  partiesList: LinkedList<PoliticalParty>;
  winningCandidatesList: LinkedList<Candidate>;



  constructor(private adminServiceService: AdminServiceService) { }

  closeVoting() {
    this.adminServiceService.closeVoting();
  }

  createCandidate(name: string, party: string) {
    this.adminServiceService.createCandidate(name, party);
  }

  modifyCandidate(id: number, name: string, party: string) {
    this.adminServiceService.modifyCandidate(id, name, party);
  }

  deleteCandidate(id: number) {
    this.adminServiceService.deleteCandidate(id);
  }

  getCandidates() {
    this.adminServiceService.getCandidates();
    this.candidatesList = this.adminServiceService.candidatesList;
  }

  getElectionResult() {
    console.log('LOG');
    this.adminServiceService.getElectionResult();
    this.winningCandidatesList = this.adminServiceService.winningCandidatesList;
  }

  getParties() {
    this.adminServiceService.getParties();
    this.partiesList = this.adminServiceService.partiesList;
  }

  createParty(name: string) {
    this.adminServiceService.createParty(name);
  }

  updateParty(id: number, name: string) {
    this.adminServiceService.updateParty(id, name);
  }

  deleteParty(id: number) {
    this.adminServiceService.removeParty(id);
  }

  ngOnInit() {
  }

}
