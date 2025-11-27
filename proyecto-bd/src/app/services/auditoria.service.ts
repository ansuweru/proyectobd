import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Registro } from '../models/clinical-models';

export interface LogAuditoriaDTO {
    registro: Registro;
    nombreUsuario: string;
}

@Injectable({
    providedIn: 'root'
})
export class AuditoriaService {
    private apiUrl = '/api/auditoria';

    constructor(private http: HttpClient) { }

    getLogAuditoriaPorEpisodio(id: number): Observable<LogAuditoriaDTO[]> {
        return this.http.get<LogAuditoriaDTO[]>(`${this.apiUrl}/episodio/${id}`);
    }

    createRegistro(registro: any): Observable<any> {
        return this.http.post<any>(this.apiUrl, registro);
    }
}
