# --- !Ups
INSERT INTO user ( prename , surname, right_handed) VALUES
  ('Lars', 'Badde', true),
  ('Testuser', '--', true);

INSERT INTO device( name , description) VALUES
  ('S323A049374', 'LeapMotion -- 1'),
  ('S324A000314', 'Leapmotion -- 2'),
  ('S3456F1221', 'Testobjekt (nicht existent)');



INSERT INTO gesture ( id, name, description) VALUES
  (1,'UP', 'Im zweidimensionalen Menu nach oben'),
  (2,'DOWN', 'Im zweidimensionalen Menu nach unten'),
  (3,'RIGHT', 'Im zweidimensionalen Menu nach rechts, und einen Arbeitsschritt weiter schalten im Workflow-Modell'),
  (4,'LEFT', 'Im zweidimensionalen Menu nach links, und einen Arbeitsschritt zurück schalten im Workflow-Modell'),
  (5,'UnDo', 'Die letzte Aktion rückgängig machen'),
  (6,'OPEN MENU', 'Das Menu öffnen. Das Menu kann kontextabhängig sein.'),
  (7,'GET INFO', 'zusätzliche Informationen (kontextabhängig) anfordern.'),
  (8,'MISTAKE/ERROR', 'Fehler im Arbeitsschritt oder in Teilen etc. melden. Öffnet im Normalfall ein seperates Fehler-Melde-Menu.'),
  (9,'ACCEPT', 'Eine spezifische Meldung oder einen ausgewählten Eintrag bestätigen/auswählen.'),
  (10,'DENY', 'Eine spezifische Meldung oder einen ausgewählten Eintrag ablehnen/verneinen/verweigern.'),
  (11,'NO GESTURE', 'Die Negativklasse');
# --- !Downs
