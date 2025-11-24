import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Solicitud } from '../models/clinical-models';

@Injectable({
    providedIn: 'root'
})
export class SolicitudService {
    private apiUrl = 'http://localhost:8080/api/solicitudes';

    constructor(private http: HttpClient) { }

    getSolicitudesByPaciente(cedula: number): Observable<Solicitud[]> {
        return this.http.get<Solicitud[]>(`${this.apiUrl}/paciente/${cedula}`);
    }

    createSolicitud(solicitud: Solicitud): Observable<Solicitud> {
        return this.http.post<Solicitud>(this.apiUrl, solicitud);
    }
}
