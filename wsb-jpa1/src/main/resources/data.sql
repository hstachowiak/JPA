-- Wstawianie adresów
INSERT INTO ADDRESS (id, city, addressLine1, addressLine2, postalCode) VALUES
(1, 'Warszawa', 'ul. Polna 1', 'ul. Krakowska 10', '00-001'),
(2, 'Kraków', 'ul. Krakowska 2', 'ul. Polna 111', '30-002');

-- Wstawianie lekarzy
INSERT INTO DOCTOR (id, firstName, lastName, telephoneNumber, email, doctorNumber, specialization, address_id) VALUES
(1, 'Jan', 'Kowalski', '123456789', 'jan.kowalski@example.com', '123', 'CARDIOLOGIST', 1),
(2, 'Anna', 'Nowak', '987654321', 'anna.nowak@example.com', '456', 'DERMATOLOGIST', 2);

-- Wstawianie pacjentów
INSERT INTO PATIENT (id, firstName, lastName, patientNumber, dateOfBirth, address_id, insurance_type) VALUES
(1, 'Mateusz', 'Zięba', 'P123', '1990-05-15', 1, 'BASIC'),
(2, 'Karolina', 'Kowalczyk', 'P456', '1985-10-20', 2, 'PREMIUM');

-- Wstawianie wizyt
INSERT INTO VISIT (id, description, time, patient_id, doctor_id) VALUES
(1, 'Konsultacja ogólna', '2024-05-25 10:00:00', 1, 1),
(2, 'Badanie skóry', '2024-05-26 14:30:00', 2, 2);

-- Wstawianie zabiegów medycznych
INSERT INTO MEDICAL_TREATMENT (id, description, type) VALUES
(1, 'Przepisanie leków', 'PHARMACOLOGICAL'),
(2, 'Zakładanie opatrunku', 'PROCEDURAL');

-- Mapowanie wizyt i zabiegów medycznych
INSERT INTO VISIT_MEDICAL_TREATMENT (visit_id, medical_treatment_id) VALUES
(1, 1),
(2, 2);

-- Znajdz pacjentow po nazwisku
SELECT * FROM PATIENT WHERE lastName = 'Zięba';

-- Znajdz wszystkie wizyty pacjenta po jego ID
SELECT * FROM VISIT WHERE patient_id = 2;

-- Znajdz pacjentow ktorzy mieli wiecej niz X wizyt (X jest parametrem wejsciowym)
SELECT PATIENT.id, PATIENT.firstName, PATIENT.lastName
FROM PATIENT
JOIN (SELECT patient_id, COUNT(*) AS visit_count FROM VISIT GROUP BY patient_id) AS visits
ON PATIENT.id = visits.patient_id
WHERE visits.visit_count > 1;

-- Znajdz pacjentow po dodanym przez Ciebie polu - nie wyszukuj wprost po wartosci, uzyj zapytania typu wieksze/mniejsze/pozniej/wczesniej/zawiera, w zaleznosci od wybranego typu zmiennej.
SELECT * FROM PATIENT WHERE firstName LIKE '%a%';
