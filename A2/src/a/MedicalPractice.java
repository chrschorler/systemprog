package a;

import shared.Patient;

public class MedicalPractice {
    private TreatmentRoom[] rooms;

    public MedicalPractice(int numberOfRooms) {
        rooms = new TreatmentRoom[numberOfRooms];
        for (int i = 0; i < numberOfRooms; i++) {
            rooms[i] = new TreatmentRoom(i + 1);
        }
    }

    public void treatPatient(Patient patient) {
        TreatmentRoom room = rooms[patient.getTreatmentRoom() - 1];
        room.registerPatient(patient);

        // Synchronized on the TreatmentRoom object
        synchronized (room) {
            room.startTreatment(patient);
        }
    }
}
