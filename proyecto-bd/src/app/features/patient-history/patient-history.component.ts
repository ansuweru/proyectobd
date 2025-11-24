import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { Paciente, EpisodioClinico, Solicitud } from '../../models/clinical-models';
import { PacienteService } from '../../services/paciente.service';
import { EpisodioClinicoService } from '../../services/episodio-clinico.service';
import { AuthService } from '../../services/auth.service';
import { SolicitudService } from '../../services/solicitud.service';
import { FormsModule } from '@angular/forms';

@Component({
    selector: 'app-patient-history',
    standalone: true,
    imports: [CommonModule, FormsModule],
    templateUrl: './patient-history.component.html',
    styleUrls: ['./patient-history.component.css']
})
export class PatientHistoryComponent {
    paciente: Paciente | null = null;
    episodios: EpisodioClinico[] = [];
    cedula: string = '';

    // Edit Modal
    showEditModal = false;
    editPatient: Paciente = { cedula: 0, nombre: '', fecha_nacimiento: '', genero: '', direccion: '' };

    // Solicitudes Modal
    showSolicitudesModal = false;
    solicitudes: Solicitud[] = [];
    newSolicitud: Solicitud = { num_solicitud: 0, cedula: 0, descripcion: '', fecha_solicitud: '' };

    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private pacienteService: PacienteService,
        private episodioService: EpisodioClinicoService,
        public authService: AuthService,
        private solicitudService: SolicitudService
    ) {
        this.cedula = this.route.snapshot.paramMap.get('cedula') || '';
        if (this.cedula) {
            this.loadData();
        }
    }

    loadData() {
        this.pacienteService.getPaciente(this.cedula).subscribe(p => this.paciente = p);
        this.episodioService.getEpisodiosByPaciente(this.cedula).subscribe(e => this.episodios = e);
    }

    verDetalle(episodio: EpisodioClinico) {
        this.router.navigate(['/episode', episodio.num_episodio]);
    }

    // Edit Modal Methods
    openEditModal() {
        if (this.paciente) {
            this.editPatient = { ...this.paciente };
            this.showEditModal = true;
        }
    }

    closeEditModal() {
        this.showEditModal = false;
    }

    updatePatient() {
        if (this.editPatient) {
            this.pacienteService.updatePaciente(this.editPatient.cedula, this.editPatient).subscribe({
                next: (updated) => {
                    this.paciente = updated;
                    alert('Datos actualizados');
                    this.closeEditModal();
                },
                error: (err) => console.error('Error updating patient', err)
            });
        }
    }

    // Solicitudes Modal Methods
    openSolicitudesModal() {
        if (this.paciente) {
            this.showSolicitudesModal = true;
            this.loadSolicitudes();
            this.newSolicitud = {
                num_solicitud: 0,
                cedula: this.paciente.cedula,
                descripcion: '',
                fecha_solicitud: new Date().toISOString().split('T')[0]
            };
        }
    }

    closeSolicitudesModal() {
        this.showSolicitudesModal = false;
    }

    loadSolicitudes() {
        if (this.paciente) {
            this.solicitudService.getSolicitudesByPaciente(this.paciente.cedula).subscribe(s => this.solicitudes = s);
        }
    }

    createSolicitud() {
        this.solicitudService.createSolicitud(this.newSolicitud).subscribe({
            next: (created) => {
                this.solicitudes.push(created);
                this.newSolicitud.descripcion = ''; // Reset description
                alert('Solicitud creada');
            },
            error: (err) => console.error('Error creating solicitud', err)
        });
    }
}
