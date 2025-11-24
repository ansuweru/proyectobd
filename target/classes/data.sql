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
(4, 500, 1004, '2025-11-20 16:10:00', 'Edición'),
(5, 503, 1001, '2025-11-21 10:00:00', 'Consulta'),
(6, 502, 2020202020, '2025-11-22 09:15:00', 'Consulta');

-- Insertar Más Pacientes
INSERT INTO PACIENTE (cedula, nombre, fecha_nacimiento, genero, direccion) VALUES
(5050505050, 'Carlos Eduardo', '1990-12-12', 'M', 'Calle 100 #15-20'),
(6060606060, 'Maria Fernanda', '1985-05-05', 'F', 'Carrera 7 #45-30'),
(7070707070, 'Jorge Luis', '1978-09-09', 'M', 'Avenida 19 #10-10');

-- Insertar Más Personal Médico
INSERT INTO PERSONAL_MEDICO (id_medico, nombre_completo, especialidad, num_colegiado) VALUES
(103, 'Dra. Laura Martinez', 'Dermatología', 223344),
(104, 'Dr. Pedro Perez', 'Ortopedia', 556677);

-- Insertar Más Usuarios
INSERT INTO USUARIO_SISTEMA (id_usuario, nombre_usuario, rol, id_persona, contrasena) VALUES
(504, 'lmartinez', 'Médico', 103, 'password'),
(505, 'pperez', 'Médico', 104, 'password');

-- Insertar Más Episodios
INSERT INTO EPISODIO_CLINICO (num_episodio, cedula, id_medico, fecha_apertura, motivo_consulta, anamnesis, examen_fisico, plan_manejo, estado) VALUES
(1005, 5050505050, 103, '2025-11-21 08:00:00', 'Manchas en la piel', 'Paciente presenta manchas rojas en brazos.', 'Lesiones eritematosas descamativas.', 'Crema corticoide tópica.', 'Cerrado'),
(1006, 6060606060, 104, '2025-11-22 10:00:00', 'Dolor de espalda', 'Dolor lumbar crónico que empeora al estar de pie.', 'Dolor a la palpación lumbar. Lasegue negativo.', 'Radiografía de columna lumbar. Analgésicos.', 'Abierto'),
(1007, 7070707070, 102, '2025-11-23 11:00:00', 'Chequeo general', 'Paciente asintomático desea chequeo.', 'Examen físico normal.', 'Exámenes de laboratorio de rutina.', 'Cerrado');

-- Insertar Más Diagnósticos
INSERT INTO DIAGNOSTICO (id_diagnostico, num_episodio, codigo_cie, descripcion, tipo) VALUES
(5, 1005, 'L20', 'Dermatitis atópica', 'Confirmado'),
(6, 1006, 'M545', 'Lumbago no especificado', 'Presuntivo'),
(7, 1007, 'Z000', 'Examen médico general', 'Principal');

-- Insertar Más Procedimientos
INSERT INTO PROCEDIMIENTO (id_procedimiento, num_episodio, codigo_cup, nombre_procedimiento, fecha_procedimiento) VALUES
(4, 1006, '873204', 'Radiografía de columna lumbosacra', '2025-11-22'),
(5, 1007, '902213', 'Hemograma IV', '2025-11-23'),
(6, 1003, '902213', 'Hemograma IV', '2025-10-17'),
(7, 1005, '890201', 'Consulta dermatológica', '2025-11-21');

-- Insertar Más Solicitudes
INSERT INTO SOLICITUD (num_solicitud, cedula, descripcion, fecha_solicitud) VALUES
(4, 5050505050, 'Solicitud de historia clínica para especialista', '2025-11-21'),
(5, 6060606060, 'Certificado de incapacidad', '2025-11-22');