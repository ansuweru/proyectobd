import { Routes } from '@angular/router';
import { LoginComponent } from './features/login/login.component';
import { PatientSearchComponent } from './features/patient-search/patient-search.component';
import { PatientHistoryComponent } from './features/patient-history/patient-history.component';
import { EpisodeDetailComponent } from './features/episode-detail/episode-detail.component';

export const routes: Routes = [
    { path: '', redirectTo: 'login', pathMatch: 'full' },
    { path: 'login', component: LoginComponent },
    { path: 'search', component: PatientSearchComponent },
    { path: 'history/:cedula', component: PatientHistoryComponent },
    { path: 'episode/:id', component: EpisodeDetailComponent },
    { path: '**', redirectTo: 'login' }
];
