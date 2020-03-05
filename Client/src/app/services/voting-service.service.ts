import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LinkedList } from 'ngx-bootstrap';
import { Candidate } from '../app.module';

@Injectable({
  providedIn: 'root'
})
export class VotingServiceService {

  candidatesList: LinkedList<Candidate>;

  constructor(private httpClient: HttpClient) { }

  public getCandidates() {
    this.httpClient.get<LinkedList<Candidate>>('http://localhost:8080/candidates')
      .subscribe(data => (this.candidatesList = data));
  }

  public vote(id: number, numberOfVotes: number, username: string) {
    this.httpClient.post('http://localhost:8080/vote',
      {
        // tslint:disable-next-line:quotemark
        "id": id,
        // tslint:disable-next-line:quotemark
        "numberOfVotes": numberOfVotes,
        // tslint:disable-next-line:quotemark
        "username": username
      }).subscribe();

  }

}
