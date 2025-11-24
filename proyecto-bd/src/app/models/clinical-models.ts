export interface Paciente {
  cedula: number;
  nombre: string;
  fecha_nacimiento: string;
  genero: string;
  direccion: string;
}

export interface EpisodioClinico {
  num_episodio: number;
  cedula: number;
  id_medico: number;
  fecha_apertura: string;
  motivo_consulta: string;
  anamnesis: string;
  examen_fisico: string;
  plan_manejo: string;
  estado: string;
}

export interface Diagnostico {
  id_diagnostico: number;
  num_episodio: number;
  codigo_cie: string;
  descripcion: string;
  tipo: string;
}

export interface Procedimiento {
  id_procedimiento: number;
  num_episodio: number;
  codigo_cup: string;
  nombre_procedimiento: string;
  fecha_procedimiento: string;
}

export interface PersonalMedico {
  id_medico: number;
  nombre_completo: string;
  especialidad: string;
  num_colegiado: number;
}

export interface Solicitud {
  num_solicitud: number;
  cedula: number;
  descripcion: string;
  fecha_solicitud: string;
}

export interface Registro {
  num_registro: number;
  id_usuario: number;
  num_episodio: number;
  fecha_hora_registro: string;
  tipo_acceso: string;
}
