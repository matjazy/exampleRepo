import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Candidate, PoliticalParty } from '../app.module';
import { LinkedList } from 'ngx-bootstrap';

@Injectable({
  providedIn: 'root'
})
export class AdminServiceService {

  candidatesList: LinkedList<Candidate>;
  partiesList: LinkedList<PoliticalParty>;
  winningCandidatesList: LinkedList<Candidate>;

  constructor(private httpClient: HttpClient) { }



  public closeVoting() {
    console.log('been there');
    this.httpClient.post('http://localhost:8080/closeVoting',
      {}).subscribe();
    console.log('and there too');
  }

  public getCandidates() {
    this.httpClient.get<LinkedList<Candidate>>('http://localhost:8080/candidates')
      .subscribe(data => (this.candidatesList = data));
  }

  public getElectionResult() {
    console.log('DATA');
    this.httpClient.get<LinkedList<Candidate>>('http://localhost:8080/winningParties')
      .subscribe(data => (this.winningCandidatesList = data));
  }

  public getParties() {
    console.log('log');
    this.httpClient.get<LinkedList<PoliticalParty>>('http://localhost:8080/parties')
      .subscribe(data => (this.partiesList = data));
  }

  public modifyCandidate(id: number, name: string, party: string) {
    this.httpClient.post('http://localhost:8080/candidateUpdate', {
      'id': id,
      'name': name,
      'party': party
    }).subscribe();
  }

  public deleteCandidate(id: number) {
    this.httpClient.delete('http://localhost:8080/candidate/' + id).subscribe();
  }

  public updateParty(id: number, name: string) {
    console.log('been there');
    this.httpClient.post('http://localhost:8080/partyUpdate', {
      'id': id,
      'name': name,
    }).subscribe();
  }

  public removeParty(id: number) {
    this.httpClient.delete('http://localhost:8080/party/' + id).subscribe();
  }

  public createCandidate(name: string, party: string) {
    this.httpClient.post('http://localhost:8080/candidate', {
      'name': name,
      'party': party
    }).subscribe();
  }

  public createParty(name: string) {
    this.httpClient.post('http://localhost:8080/party', {
      'name': name,
    }).subscribe();
  }


}
