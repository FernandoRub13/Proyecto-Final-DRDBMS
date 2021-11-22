ALTER TABLE estudios_laboratorio DROP CONSTRAINT fktpwnj2n10adb6fhriiatb7k8t;

ALTER TABLE estudios_laboratorio ADD CONSTRAINT fktpwnj2n10adb6fhriiatb7k8t 
FOREIGN KEY (paciente_id) REFERENCES paciente(id) ON DELETE CASCADE;
