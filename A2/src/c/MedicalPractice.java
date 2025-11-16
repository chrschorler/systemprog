package c;

import shared.IMedicalPractice;
import shared.Patient;

public class MedicalPractice implements IMedicalPractice {

    private TreatmentRoom[] rooms;

    public MedicalPractice(int numberOfRooms) {
        rooms = new TreatmentRoom[numberOfRooms];
        for (int i = 0; i < numberOfRooms; i++) {
            rooms[i] = new TreatmentRoom(i + 1);
        }
    }

    @Override
    public void treatPatient(Patient patient) {
        TreatmentRoom room = rooms[patient.getTreatmentRoom() - 1];
        room.registerPatient(patient);
        room.startTreatment(patient);
    }
}
