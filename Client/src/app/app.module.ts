import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginFormComponent } from './components/login-form/login-form.component';
import { RegistrationDivComponent } from './components/registration-div/registration-div.component';

import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AlertModule, LinkedList } from 'ngx-bootstrap';
import { NavigationBarComponent } from './components/navigation-bar/navigation-bar.component';
import { VotingFormComponent } from './components/voting-form/voting-form.component';
import { ResultsFormComponent } from './components/results-form/results-form.component';
import { AdminFormComponent } from './components/admin-form/admin-form.component';

const appRoutes: Routes = [
  { path: 'registration', component: RegistrationDivComponent },
  { path: '', component: LoginFormComponent },
  { path: 'admin', component: AdminFormComponent },
  { path: 'voting', component: VotingFormComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    LoginFormComponent,
    RegistrationDivComponent,
    NavigationBarComponent,
    VotingFormComponent,
    ResultsFormComponent,
    AdminFormComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true }
    ),
    HttpClientModule,
    FormsModule,
    AlertModule.forRoot(),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

export interface PoliticalParty {
  id: number;
  name: string;
  members: LinkedList<Candidate>;
}

export interface Candidate {
  id: number;
  name: string;
  politicalParty: PoliticalParty;
  numberOfVotes: number;
}
