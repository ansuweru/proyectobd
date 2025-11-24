import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { Paciente } from '../../models/clinical-models';
import { PacienteService } from '../../services/paciente.service';
import { AuthService } from '../../services/auth.service';

@Component({
    selector: 'app-patient-search',
    standalone: true,
    imports: [CommonModule, FormsModule],
    templateUrl: './patient-search.component.html',
    styleUrls: ['./patient-search.component.css']
})
export class PatientSearchComponent implements OnInit {
    searchTerm = '';
    pacientes: Paciente[] = [];
    errorMessage = '';

    constructor(
        private pacienteService: PacienteService,
        private router: Router,
        public authService: AuthService
    ) { }

    ngOnInit() {
        // Check initial value
        const currentUser = this.authService.getCurrentUser();
        if (currentUser && (currentUser.rol === 'Administrador' || currentUser.rol === 'Archivista')) {
            this.loadAllPacientes();
        }

        // Subscribe for future changes
        this.authService.currentUser.subscribe(user => {
            if (user && (user.rol === 'Administrador' || user.rol === 'Archivista')) {
                this.loadAllPacientes();
            }
        });
    }

    loadAllPacientes() {
        this.pacienteService.getAllPacientes().subscribe({
            next: (data) => this.pacientes = data,
            error: (err) => console.error('Error loading patients', err)
        });
    }

    buscarPaciente() {
        if (!this.searchTerm) return;

        this.pacienteService.getPaciente(this.searchTerm).subscribe({
            next: (paciente) => {
                this.pacientes = [paciente];
                this.errorMessage = '';
            },
            error: (err) => {
                console.error('Error fetching patient', err);
                this.pacientes = [];
                this.errorMessage = 'Paciente no encontrado';
            }
        });
    }

    verHistorial(paciente: Paciente) {
        this.router.navigate(['/history', paciente.cedula]);
    }

    showNewPatientModal = false;
    newPatient: Paciente = {
        cedula: 0,
        nombre: '',
        fecha_nacimiento: '',
        genero: '',
        direccion: ''
    };

    openNewPatientModal() {
        this.newPatient = { cedula: 0, nombre: '', fecha_nacimiento: '', genero: '', direccion: '' };
        this.showNewPatientModal = true;
    }

    closeNewPatientModal() {
        this.showNewPatientModal = false;
    }

    createPatient() {
        this.pacienteService.createPaciente(this.newPatient).subscribe({
            next: (createdPatient) => {
                alert('Paciente creado exitosamente');
                this.closeNewPatientModal();
                // Reload list if admin/archivista
                const user = this.authService.getCurrentUser();
                if (user && (user.rol === 'Administrador' || user.rol === 'Archivista')) {
                    this.loadAllPacientes();
                }
            },
            error: (err) => {
                console.error('Error creating patient', err);
                alert('Error al crear paciente');
            }
        });
    }
}
