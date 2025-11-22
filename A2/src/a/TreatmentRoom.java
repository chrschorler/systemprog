package a;

import shared.Patient;

class TreatmentRoom {

    private int roomNumber;

    public TreatmentRoom(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void registerPatient(Patient patient) {
        System.out.println(patient.getName() + " wartet auf Behandlung in Zimmer " + roomNumber + ".");
        patient.setAdmissionTime(System.currentTimeMillis());
    }

    public void startTreatment(Patient patient) {
        patient.setTreatmentStart(System.currentTimeMillis());
        System.out.println("Behandlung von " + patient.getName() + " in Zimmer " + roomNumber +
                " gestarted. Behandlungszeit " + patient.getTreatmentDuration() + " Sekunden.");

        try {
            Thread.sleep(patient.getTreatmentDuration() * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        System.out.println("Patient " + patient.getName() + " hatte eine Wartezeit von " +
                patient.getWaitingTime() + " Sekunden.");
    }
}

