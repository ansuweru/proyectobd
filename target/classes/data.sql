-- =================================================================================
-- ARCHIVO SQL DE INSERCIÓN DE DATOS PARA EL ARCHIVO DE HISTORIAS CLÍNICAS (MOCK DATA)
-- Este script asume que la estructura de tablas ya fue creada (CREATE TABLE).
-- =================================================================================


-- =========================
--   PACIENTE
-- =========================
-- PK: cédula
INSERT INTO PACIENTE (cédula, nombre, fecha_nacimiento, genero, dirección) VALUES
 (1010101010, 'Ana María', '1995-08-21', 'F', 'Carrera 15 #50-10'),
 (2020202020, 'Luis Fernando', '1980-03-14', 'M', 'Calle 70 #3A-25'),
 (3030303030, 'Sofía Elena', '2005-11-05', 'F', 'Avenida 10 #12-30'),
 (4040404040, 'Javier Andrés', '1972-01-30', 'M', 'Transversal 8 #9-11');

-- =========================
--   PERSONAL_MEDICO
-- =========================
-- PK: id_medico
INSERT INTO PERSONAL_MEDICO (id_medico, nombre_completo, especialidad, num_colegiado) VALUES
 (100, 'Dra. Carolina Vargas', 'Pediatría', 55432),
 (101, 'Dr. Ricardo Soto', 'Medicina Interna', 88123),
 (102, 'Dra. Elena Gutiérrez', 'Medicina General', 77567),
 (103, 'Dr. Mario Casas', 'Cirugía', 99010);


-- =========================
--   USUARIO_SISTEMA
-- =========================
-- PK: id_usuario. Nota: id_persona FK puede ser cédula (PACIENTE) o id_medico (PERSONAL_MEDICO)
INSERT INTO USUARIO_SISTEMA (id_usuario, nombre_usuario, rol, id_persona) VALUES
 (500, 'cvargas', 'Médico', 100), -- Dra. Vargas (Médico)
 (501, 'rsoto', 'Médico', 101),   -- Dr. Soto (Médico)
 (502, 'jandres', 'Archivista', 4040404040), -- Javier Andrés (Podría ser un empleado administrativo con ID de persona que coincide con un paciente)
 (503, 'admin', 'Administrador', 999); -- Asumimos un ID_PERSONA genérico para el administrador

-- =========================
--   EPISODIO_CLINICO
-- =========================
-- PK: num_episodio | FKs: cédula, id_medico
INSERT INTO EPISODIO_CLINICO (num_episodio, cédula, id_medico, fecha_apertura, motivo_consulta, anamnesis, examen_fisico, plan_manejo, estado) VALUES
 (1001, 1010101010, 100, '2025-10-15 09:30:00', 'Control de crecimiento', 'Paciente refiere buen estado general. Padres reportan alimentación adecuada.', 'Peso y talla en percentil 50. Auscultación normal.', 'Continuar vitaminas. Cita de control en 6 meses.', 'Cerrado'),
 (1002, 2020202020, 101, '2025-10-16 14:00:00', 'Dolor torácico', 'Inicio súbito de dolor opresivo, irradiado a brazo izquierdo.', 'TA 130/85, FC 85. Pulmonar y abdominal normal.', 'Solicitar ECG y Troponinas. Dejar en observación.', 'Abierto'),
 (1003, 3030303030, 102, '2025-10-17 11:45:00', 'Gripe y fiebre', 'Fiebre de 38.5°C por 2 días, tos seca y congestión.', 'Faringe hiperémica. Resto sin hallazgos relevantes.', 'Acetaminofén PRN. Reposo en casa por 5 días.', 'Cerrado'),
 (1004, 1010101010, 100, '2025-11-20 16:00:00', 'Revisión por caída', 'Caída de bicicleta sin pérdida de conciencia. Dolor en rodilla.', 'Leve edema en rodilla derecha. Movilidad conservada.', 'Aplicar hielo. Control radiológico si el dolor persiste.', 'Abierto');


-- =========================
--   DIAGNOSTICO
-- =========================
-- PK: id_diagnostico | FK: num_episodio
INSERT INTO DIAGNOSTICO (id_diagnostico, num_episodio, codigo_cie, descripcion, tipo) VALUES
 (1, 1001, 'Z00.1', 'Examen de salud de rutina del niño', 'Principal'),
 (2, 1002, 'R07.4', 'Dolor en el pecho, sin especificar', 'Principal'),
 (3, 1003, 'J11.1', 'Influenza, virus no identificado', 'Principal'),
 (4, 1004, 'S80.0', 'Contusión de rodilla', 'Principal'),
 (5, 1003, 'J02.9', 'Faringitis aguda, no especificada', 'Secundario');


-- =========================
--   PROCEDIMIENTO
-- =========================
-- PK: id_procedimiento | FK: num_episodio
INSERT INTO PROCEDIMIENTO (id_procedimiento, num_episodio, codigo_cup, nombre_procedimiento, fecha_procedimiento) VALUES
 (10, 1001, '99.01', 'Toma de signos vitales', '2025-10-15 09:35:00'),
 (11, 1002, '89.52', 'Electrocardiograma (ECG)', '2025-10-16 14:15:00'),
 (12, 1003, '00.01', 'Examen físico completo', '2025-10-17 11:50:00'),
 (13, 1004, '90.59', 'Aplicación de vendaje', '2025-11-20 16:15:00');


-- =========================
--   SOLICITUD
-- =========================
-- PK: num_solicitud | FK: cédula
INSERT INTO SOLICITUD (num_solicitud, cédula, descripcion, fecha_solicitud) VALUES
 (1, 1010101010, 'Solicitud de copia de historial de vacunación', '2025-11-01'),
 (2, 2020202020, 'Solicitud de rectificación de dirección', '2025-11-05'),
 (3, 3030303030, 'Solicitud de copia completa de expediente', '2025-11-10');


-- =========================
--   REGISTRO (Log de Acceso/Auditoría)
-- =========================
-- PK: num_registro | FKs: id_usuario, num_episodio
INSERT INTO REGISTRO (num_registro, id_usuario, num_episodio, fecha_hora_registro, tipo_acceso) VALUES
 (100, 500, 1001, '2025-10-15 10:00:00', 'Modificación/Cierre'),
 (101, 502, 1001, '2025-10-18 15:30:00', 'Consulta'),
 (102, 503, 1002, '2025-10-20 08:05:00', 'Consulta'),
 (103, 501, 1002, '2025-10-27 12:00:00', 'Modificación'),
 (104, 502, 1004, '2025-11-20 17:00:00', 'Consulta');