import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { EpisodioClinico, Diagnostico, Procedimiento } from '../../models/clinical-models';
import { EpisodioClinicoService } from '../../services/episodio-clinico.service';

import { AuthService } from '../../services/auth.service';

import { AuditoriaService, LogAuditoriaDTO } from '../../services/auditoria.service';

@Component({
    selector: 'app-episode-detail',
    standalone: true,
    imports: [CommonModule, FormsModule],
    templateUrl: './episode-detail.component.html',
    styleUrls: ['./episode-detail.component.css']
})
export class EpisodeDetailComponent {
    episodio: EpisodioClinico | null = null;
    diagnosticos: Diagnostico[] = [];
    procedimientos: Procedimiento[] = [];
    logsAuditoria: LogAuditoriaDTO[] = [];
    showModal = false;

    constructor(
        private route: ActivatedRoute,
        private router: Router,
        private episodioService: EpisodioClinicoService,
        public authService: AuthService,
        private auditoriaService: AuditoriaService
    ) {
        const id = this.route.snapshot.paramMap.get('id');
        if (id) {
            this.loadData(+id);
        }
    }

    loadData(id: number) {
        this.episodioService.getEpisodio(id).subscribe(e => {
            this.episodio = e;

            // Log access
            const user = this.authService.getCurrentUser();
            if (user && this.episodio) {
                const registro = {
                    id_usuario: user.idUsuario,
                    num_episodio: this.episodio.num_episodio,
                    tipo_acceso: 'Consulta'
                };
                this.auditoriaService.createRegistro(registro).subscribe();
            }
        });
        this.episodioService.getDiagnosticos(id).subscribe(d => {
            this.diagnosticos = d;
        });
        this.episodioService.getProcedimientos(id).subscribe(p => {
            this.procedimientos = p;
        });
    }

    get isEditable(): boolean {
        const user = this.authService.getCurrentUser();
        return user?.rol === 'Médico' && this.episodio?.estado === 'Abierto';
    }

    verAuditoria() {
        if (this.episodio) {
            this.auditoriaService.getLogAuditoriaPorEpisodio(this.episodio.num_episodio).subscribe(logs => {
                this.logsAuditoria = logs;
                this.showModal = true;
            });
        }
    }

    closeModal() {
        this.showModal = false;
    }

    guardarCambios() {
        if (this.episodio) {
            this.episodioService.updateEpisodio(this.episodio.num_episodio, this.episodio).subscribe({
                next: (updatedEpisodio) => {
                    this.episodio = updatedEpisodio;

                    // Log update
                    const user = this.authService.getCurrentUser();
                    if (user && this.episodio) {
                        const registro = {
                            id_usuario: user.idUsuario,
                            num_episodio: this.episodio.num_episodio,
                            tipo_acceso: 'Edición'
                        };
                        this.auditoriaService.createRegistro(registro).subscribe();
                    }

                    alert('Cambios guardados exitosamente.');
                },
                error: (err) => console.error('Error updating episode', err)
            });
        }
    }

    cerrarSinGuardar() {
        // Navigate back to history
        if (this.episodio) {
            this.episodioService.getEpisodiosByPaciente(this.episodio.cedula.toString()).subscribe(episodios => {
                // We need the patient cedula. It's in the episode.
                // But the router link was /history/:cedula
                // Let's just go back using Location or Router with cedula
                // The episode object has 'cedula'.
                // However, in the previous code, cedula was Long/number.
                // Let's check the entity.
            });
            // Simpler: just go back to history using the cedula from the episode
            // We need to import Router if not already used for navigation in this method context, 
            // but it is injected in constructor.
            // Wait, I need to check if 'cedula' is available in 'episodio'.
            // In the model it is 'cedula: number'.
            this.router.navigate(['/history', this.episodio.cedula]);
        }
    }
}
