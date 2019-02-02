INSERT INTO especialidades (id,nome) VALUES (1,'Acupuntura ');
INSERT INTO especialidades (id,nome) VALUES (2,'Anestesiologia ');
INSERT INTO especialidades (id,nome) VALUES (3,'Angiologia ');
INSERT INTO especialidades (id,nome) VALUES (4,'Cardiologia ');
INSERT INTO especialidades (id,nome) VALUES (5,'Cirurgia da mao');

INSERT INTO medicos (id,crm,nome) VALUES (1,'1010' ,'Pedro');
INSERT INTO medicos (id,crm,nome) VALUES (2,'1020' ,'Maria');
INSERT INTO medicos (id,crm,nome) VALUES (3,'1030' ,'Ana');
INSERT INTO medicos (id,crm,nome) VALUES (4,'1040' ,'Gustavo');
INSERT INTO medicos (id,crm,nome) VALUES (5,'1050' ,'Gabrieala');

INSERT INTO medico_especialidade (fk_medico,fk_especialidade) VALUES (1,5);
INSERT INTO medico_especialidade (fk_medico,fk_especialidade) VALUES (2,4);
INSERT INTO medico_especialidade (fk_medico,fk_especialidade) VALUES (3,3);
INSERT INTO medico_especialidade (fk_medico,fk_especialidade) VALUES (4,2);
INSERT INTO medico_especialidade (fk_medico,fk_especialidade) VALUES (5,1);
INSERT INTO medico_especialidade (fk_medico,fk_especialidade) VALUES (1,4);
