# --- !Ups

INSERT INTO Team VALUES (nextval('team_id_seq1'),'F.C. Barcelona', 'El Fútbol Club Barcelona es el mejor equipo del Mundo.');
INSERT INTO Team VALUES (nextval('team_id_seq1'),'R. Madrid', 'El Real Madrid es el eterno rival del mejor equipo del Mundo.');
INSERT INTO Team VALUES (nextval('team_id_seq1'),'At. Madrid', 'El Atlético de Madrid, es el eterno aspirante.');

# --- !Downs

DELETE FROM Team;
