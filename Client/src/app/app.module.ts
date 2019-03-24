import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LoginFormComponent } from './components/login-form/login-form.component';
import { RegistrationDivComponent } from './components/registration-div/registration-div.component';

import { RouterModule, Routes } from '@angular/router';

const appRoutes: Routes = [
  { path: 'registration', component: RegistrationDivComponent },
  { path: '', component: LoginFormComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    LoginFormComponent,
    RegistrationDivComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true }
    )
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
