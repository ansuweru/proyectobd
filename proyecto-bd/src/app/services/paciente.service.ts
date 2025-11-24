import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Paciente } from '../models/clinical-models';

@Injectable({
    providedIn: 'root'
})
export class PacienteService {
    private apiUrl = 'http://localhost:8080/api/pacientes';

    constructor(private http: HttpClient) { }

    getPaciente(cedula: string): Observable<Paciente> {
        return this.http.get<Paciente>(`${this.apiUrl}/${cedula}`);
    }

    getAllPacientes(): Observable<Paciente[]> {
        return this.http.get<Paciente[]>(this.apiUrl);
    }

    createPaciente(paciente: Paciente): Observable<Paciente> {
        return this.http.post<Paciente>(this.apiUrl, paciente);
    }

    updatePaciente(cedula: number, paciente: Paciente): Observable<Paciente> {
        return this.http.put<Paciente>(`${this.apiUrl}/${cedula}`, paciente);
    }
}
