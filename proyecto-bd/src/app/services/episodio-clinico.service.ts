import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { EpisodioClinico } from '../models/clinical-models';

@Injectable({
    providedIn: 'root'
})
export class EpisodioClinicoService {
    private apiUrl = 'http://localhost:8080/api/episodios';

    constructor(private http: HttpClient) { }

    getEpisodiosByPaciente(cedula: string): Observable<EpisodioClinico[]> {
        return this.http.get<EpisodioClinico[]>(`${this.apiUrl}/paciente/${cedula}`);
    }

    getEpisodio(id: number): Observable<EpisodioClinico> {
        return this.http.get<EpisodioClinico>(`${this.apiUrl}/${id}`);
    }

    updateEpisodio(id: number, episodio: EpisodioClinico): Observable<EpisodioClinico> {
        return this.http.put<EpisodioClinico>(`${this.apiUrl}/${id}`, episodio);
    }

    getDiagnosticos(id: number): Observable<any[]> {
        return this.http.get<any[]>(`${this.apiUrl}/${id}/diagnosticos`);
    }

    getProcedimientos(id: number): Observable<any[]> {
        return this.http.get<any[]>(`${this.apiUrl}/${id}/procedimientos`);
    }
}
