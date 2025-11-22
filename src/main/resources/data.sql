-- Insertar Pacientes
INSERT INTO PACIENTE (cedula, nombre, fecha_nacimiento, genero, direccion) VALUES 
(1010101010, 'Ana María', '1995-08-21', 'F', 'Carrera 15 #50-10'),
(2020202020, 'Luis Fernando', '1980-03-14', 'M', 'Calle 70 #3A-25'),
(3030303030, 'Sofía Elena', '2005-11-05', 'F', 'Avenida 10 #12-30'),
(4040404040, 'Javier Andrés', '1972-01-30', 'M', 'Transversal 8 #9-11');

-- Insertar Personal Médico
INSERT INTO PERSONAL_MEDICO (id_medico, nombre_completo, especialidad, num_colegiado) VALUES 
(100, 'Dr. Carlos Vargas', 'Pediatría', 556677),
(101, 'Dra. Rosa Soto', 'Cardiología', 889900),
(102, 'Dr. Miguel Ángel', 'Medicina General', 112233);

-- Insertar Usuarios del Sistema (Relacionados con Pacientes o Médicos)
-- id_persona debe coincidir con una cedula de PACIENTE o id_medico de PERSONAL_MEDICO
INSERT INTO USUARIO_SISTEMA (id_usuario, nombre_usuario, rol, id_persona, contrasena) VALUES 
(500, 'cvargas', 'Médico', 100, 'password'),
(501, 'rsoto', 'Médico', 101, 'password'),
(502, 'jandres', 'Archivista', 4040404040, 'password'),
(503, 'admin', 'Administrador', 999, 'admin');

-- Insertar Episodios Clínicos
INSERT INTO EPISODIO_CLINICO (num_episodio, cedula, id_medico, fecha_apertura, motivo_consulta, anamnesis, examen_fisico, plan_manejo, estado) VALUES 
(1001, 1010101010, 100, '2025-10-15 09:30:00', 'Control de crecimiento', 'Paciente refiere buen estado general. Padres reportan alimentación adecuada.', 'Peso y talla en percentil 50. Auscultación normal.', 'Continuar vitaminas. Cita de control en 6 meses.', 'Cerrado'),
(1002, 2020202020, 101, '2025-10-16 14:00:00', 'Dolor torácico', 'Inicio súbito de dolor opresivo, irradiado a brazo izquierdo.', 'TA 130/85, FC 85. Pulmonar y abdominal normal.', 'Solicitar ECG y Troponinas. Dejar en observación.', 'Abierto'),
(1003, 3030303030, 102, '2025-10-17 11:45:00', 'Gripe y fiebre', 'Fiebre de 38.5°C por 2 días, tos seca y congestión.', 'Faringe hiperémica. Resto sin hallazgos relevantes.', 'Acetaminofén PRN. Reposo en casa por 5 días.', 'Cerrado'),
(1004, 1010101010, 100, '2025-11-20 16:00:00', 'Revisión por caída', 'Caída de bicicleta sin pérdida de conciencia. Dolor en rodilla.', 'Leve edema en rodilla derecha. Movilidad conservada.', 'Aplicar hielo. Control radiológico si el dolor persiste.', 'Abierto');

-- Insertar Diagnósticos
INSERT INTO DIAGNOSTICO (id_diagnostico, num_episodio, codigo_cie, descripcion, tipo) VALUES 
(1, 1001, 'Z001', 'Control de salud de rutina del niño', 'Principal'),
(2, 1002, 'R074', 'Dolor en el pecho, no especificado', 'Presuntivo'),
(3, 1003, 'J00', 'Rinofaringitis aguda (resfriado común)', 'Confirmado'),
(4, 1004, 'S800', 'Contusión de rodilla', 'Principal');

-- Insertar Procedimientos
INSERT INTO PROCEDIMIENTO (id_procedimiento, num_episodio, codigo_cup, nombre_procedimiento, fecha_procedimiento) VALUES 
(1, 1001, '890201', 'Consulta de primera vez por medicina general', '2025-10-15'),
(2, 1002, '903801', 'Electrocardiograma de ritmo', '2025-10-16'),
(3, 1004, '873122', 'Radiografía de rodilla AP y Lateral', '2025-11-20');

-- Insertar Solicitudes
INSERT INTO SOLICITUD (num_solicitud, cedula, descripcion, fecha_solicitud) VALUES 
(1, 1010101010, 'Solicitud de copia de historial de vacunación', '2025-11-01'),
(2, 2020202020, 'Solicitud de rectificación de dirección', '2025-11-05'),
(3, 3030303030, 'Solicitud de copia completa de expediente', '2025-11-10');

-- Insertar Registros de Auditoría
INSERT INTO REGISTRO (num_registro, id_usuario, num_episodio, fecha_hora_registro, tipo_acceso) VALUES 
(1, 500, 1001, '2025-10-15 09:35:00', 'Creación'),
(2, 501, 1002, '2025-10-16 14:05:00', 'Creación'),
(3, 502, 1003, '2025-10-18 08:00:00', 'Consulta'),
(4, 500, 1004, '2025-11-20 16:10:00', 'Edición');