import { Routes } from '@angular/router';
import { HistoriaClinica } from './historia-clinica/historia-clinica';
import { HomeComponent } from './home-component/home-component';

export const routes: Routes = [
    {
        path: '', component: HomeComponent
    },
    {
        path: 'historiaClinica',
        loadComponent: ()=>
            import('./historia-clinica/historia-clinica')
        .then(c => c.HistoriaClinica),
    }
];
