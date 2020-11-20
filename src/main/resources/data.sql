-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

INSERT INTO USER
(ID, USERNAME, PASSWORD, NAME, EMAIL, ROLE)
VALUES
(nextval('USER_SEQ'), 'marc_docent', '$2a$10$jwHSeW.gbG5SUEuN9XmnweGobyQFj.vZU0xwVf0jrrE1t7jYwy2Hy', 'Marc Decaluwe', 'marc.decaluwe@thomasmore.be', 'TEACHER'),
(nextval('USER_SEQ'), 'vera_docent', '$2a$10$jwHSeW.gbG5SUEuN9XmnweGobyQFj.vZU0xwVf0jrrE1t7jYwy2Hy', 'Vera Peeters', 'vera.peeters@thomasmore.be', 'TEACHER'),
(nextval('USER_SEQ'), 'Talha_docent', '$2a$10$jwHSeW.gbG5SUEuN9XmnweGobyQFj.vZU0xwVf0jrrE1t7jYwy2Hy', 'Talha Bayansar', 'talha.bayansar@thomasmore.be', 'TEACHER')
;

insert into Cursus
(ID, NAAM, BESCHRIJVING, DOCENT_ID)
values
(nextval ('cursus_seq'), 'Nederlands voor beginners', 'In deze cursus leer je de basis van het Nederlands, niveau A1.', 0),
(nextval ('cursus_seq'), 'Nederlands voor gevorderden', 'In deze cursus leer je meer gevorderde technieken van het Nederlands, niveau A2.', 2),
(nextval ('cursus_seq'), 'Nederlands voor geavanceerden', 'In deze cursus leer je de geavanceerde en meer ingewikkelde gesprekken voeren in het Nederlands, niveau B1.', 1)
;

INSERT INTO USER
(ID, USERNAME, PASSWORD, NAME, EMAIL, ROLE, CURSUS_ID)
VALUES
(nextval('USER_SEQ'), 'marc_student', '$2a$10$jwHSeW.gbG5SUEuN9XmnweGobyQFj.vZU0xwVf0jrrE1t7jYwy2Hy', 'Marc Decaluwe', 'marc.decaluwe@student.thomasmore.be', 'STUDENT', 0),
(nextval('USER_SEQ'), 'vera_student', '$2a$10$jwHSeW.gbG5SUEuN9XmnweGobyQFj.vZU0xwVf0jrrE1t7jYwy2Hy', 'Vera Peeters', 'vera.peeters@student.thomasmore.be', 'STUDENT',2),
(nextval('USER_SEQ'), 'Tom', '$2a$10$jwHSeW.gbG5SUEuN9XmnweGobyQFj.vZU0xwVf0jrrE1t7jYwy2Hy', 'Tom De Boeck', 'Tom@Tom.be', 'STUDENT', null),
(nextval('USER_SEQ'), 'Sara', '$2a$10$jwHSeW.gbG5SUEuN9XmnweGobyQFj.vZU0xwVf0jrrE1t7jYwy2Hy', 'Sara van der Heyden', 'saravdh@hotmail.be', 'STUDENT', 2),
(nextval('USER_SEQ'), 'Koen', '$2a$10$jwHSeW.gbG5SUEuN9XmnweGobyQFj.vZU0xwVf0jrrE1t7jYwy2Hy', 'Koen Vercammen', 'koen.vercammen@hotmail.be', 'STUDENT', 0),
(nextval('USER_SEQ'), 'Peter', '$2a$10$jwHSeW.gbG5SUEuN9XmnweGobyQFj.vZU0xwVf0jrrE1t7jYwy2Hy', 'Peter Coenen', 'petercoenen@hotmail.be', 'STUDENT', 1),
(nextval('USER_SEQ'), 'Ben', '$2a$10$jwHSeW.gbG5SUEuN9XmnweGobyQFj.vZU0xwVf0jrrE1t7jYwy2Hy', 'Ben Vancraenendonck', 'ben@hotmail.be', 'STUDENT', null),
(nextval('USER_SEQ'), 'Said', '$2a$10$jwHSeW.gbG5SUEuN9XmnweGobyQFj.vZU0xwVf0jrrE1t7jYwy2Hy', 'Said el Rabin', 'said@hotmail.be', 'STUDENT', 2),
(nextval('USER_SEQ'), 'Ahmed', '$2a$10$jwHSeW.gbG5SUEuN9XmnweGobyQFj.vZU0xwVf0jrrE1t7jYwy2Hy', 'Ahmed Marcouch', 'Ahmend@hotmail.be', 'STUDENT', 0),
(nextval('USER_SEQ'), 'Najib', '$2a$10$jwHSeW.gbG5SUEuN9XmnweGobyQFj.vZU0xwVf0jrrE1t7jYwy2Hy', 'Najib Ahmhali', 'Najib@hotmail.be', 'STUDENT', 1),
(nextval('USER_SEQ'), 'Niama', '$2a$10$jwHSeW.gbG5SUEuN9XmnweGobyQFj.vZU0xwVf0jrrE1t7jYwy2Hy', 'Niama Le Boudoir', 'naima@hotmail.be', 'STUDENT', null),
(nextval('USER_SEQ'), 'Khalid', '$2a$10$jwHSeW.gbG5SUEuN9XmnweGobyQFj.vZU0xwVf0jrrE1t7jYwy2Hy', 'Khalid Boulahrous', 'saravdh@hotmail.be', 'STUDENT', 2),
(nextval('USER_SEQ'), 'Noureddine', '$2a$10$jwHSeW.gbG5SUEuN9XmnweGobyQFj.vZU0xwVf0jrrE1t7jYwy2Hy', 'Noureddine Farihi', 'noureddine@hotmail.be', 'STUDENT', 0),
(nextval('USER_SEQ'), 'Ibrahim', '$2a$10$jwHSeW.gbG5SUEuN9XmnweGobyQFj.vZU0xwVf0jrrE1t7jYwy2Hy', 'Ibrahim Musa', 'ibrahim@hotmail.be', 'STUDENT', 1),
(nextval('USER_SEQ'), 'Guney', '$2a$10$jwHSeW.gbG5SUEuN9XmnweGobyQFj.vZU0xwVf0jrrE1t7jYwy2Hy', 'Guney Meysam', 'saravdh@hotmail.be', 'STUDENT', null),
(nextval('USER_SEQ'), 'Rayen', '$2a$10$jwHSeW.gbG5SUEuN9XmnweGobyQFj.vZU0xwVf0jrrE1t7jYwy2Hy', 'Rayen Safouan', 'rayen@hotmail.be', 'STUDENT', 2),
(nextval('USER_SEQ'), 'Enes', '$2a$10$jwHSeW.gbG5SUEuN9XmnweGobyQFj.vZU0xwVf0jrrE1t7jYwy2Hy', 'Enes Anass', 'enes@hotmail.be', 'STUDENT', 2),
(nextval('USER_SEQ'), 'Aymen', '$2a$10$jwHSeW.gbG5SUEuN9XmnweGobyQFj.vZU0xwVf0jrrE1t7jYwy2Hy', 'Aymlen Ayoub', 'aymen@hotmail.be', 'STUDENT', null),
(nextval('USER_SEQ'), 'Ilyas', '$2a$10$jwHSeW.gbG5SUEuN9XmnweGobyQFj.vZU0xwVf0jrrE1t7jYwy2Hy', 'Ilyas Bilal', 'ilyas@hotmail.be', 'STUDENT', 0),
(nextval('USER_SEQ'), 'Lies', '$2a$10$jwHSeW.gbG5SUEuN9XmnweGobyQFj.vZU0xwVf0jrrE1t7jYwy2Hy', 'Lies Spruyt', 'liespruyt@hotmail.be', 'STUDENT', 1)
;

insert into opdracht
(ID, TITEL, OPGAVE, VOORBEELD,  CURSUS_ID)
values
(nextval ('opdracht_seq'), 'Bakker', 'Ga naar de bakker in jouw buurt en koop een brood en iets lekkers voor jezelf of jouw gezin', 'Voor mij een groot grof brood alstublieft.', 0),
(nextval ('opdracht_seq'), 'Supermarkt', 'Ga naar een supermarkt in je beurt en vraag meer uitleg over een product dat je wil kopen.', 'Hoeveel is het totaalbedrag?', 1),
(nextval ('opdracht_seq'), 'Corona', 'Spreek met iemand uit je omgeving over het coronavirus.', 'Wat heb jij gedaan tijdens de lockdown?', 2),
(nextval ('opdracht_seq'), 'Slager', 'Ga naar de slager en koopt iets van je lekker vindt.', 'Dag slager, mag ik 100gr salami alsjebieft?', 0),
(nextval ('opdracht_seq'), 'Bibliotheek', 'Ga naar een bibliotheek en vraag uitleg over een boek dat je zoekt.', 'Excuseer, weet u waat ik het boek ... kan vinden?', 1),
(nextval ('opdracht_seq'), 'Kledingwinkel', 'Ga naar een kledingwinkel in je buurt en vraag aan de verkoopster om je helpen.', 'Hallo kan u me helpen met het uitkiezen van een nieuw jas?', 2),
(nextval ('opdracht_seq'), 'Café', 'Ga naar een café en probeer met iemand een gesprek aan te knopen', 'Hallo, mijn naam is..... kom je hier vaak?', 2),
(nextval ('opdracht_seq'), 'Restaurant', 'Ga met een vriend/vriendin een avondje uit en spreek over iets leuks', 'Hallo, fijn je te zien! Wist je al dat...?', 0),
(nextval ('opdracht_seq'), 'Meetup', 'Zoek op internet een leuke meetup op internet en ga er naar toe', 'Hallo, ik heb een vraag over het onderwerp van deze meetup?', 1),
(nextval ('opdracht_seq'), 'Gemeente', 'Ga naar het gemeentehuis in je gemeente en vraag uitleg over iets', 'Hallo, bestaat er in deze gemeente een praatgroep Nederlands?', 2),
(nextval ('opdracht_seq'), 'Sportwedstrijd', 'Ga mee naar een sportwedstrijd van je kinderen en praat met iemand van de andere ouders.', 'Hallo, speelt jouw kind ook in deze club?', 1),
(nextval ('opdracht_seq'), 'Buren', 'Probeer een leuk gesprek te hebben met je buren', 'Hallo, we hebben elkaar al lang niet meer gezien. Hoe is het met je', 1),
(nextval ('opdracht_seq'), 'BBQ', 'Nodig je vrieden uit voor een BBQ bij je thuis', 'Hallo, wil je graag komen BBQen bij ons?', 1)
;



