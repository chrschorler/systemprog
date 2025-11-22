package c;

import shared.Patient;

public class TreatmentRoom {

    private int roomNumber;
    private Semaphore semaphore;

    public TreatmentRoom(int roomNumber) {
        this.roomNumber = roomNumber;
        this.semaphore = new Semaphore(1); // only one patient at a time per room
    }

    public void registerPatient(Patient patient) {
        System.out.println(patient.getName() + " wartet auf Behandlung in Zimmer " + roomNumber + ".");
        patient.setAdmissionTime(System.currentTimeMillis());
    }

    public void startTreatment(Patient patient) {
        semaphore.p(); // acquire the semaphore

        try {
            patient.setTreatmentStart(System.currentTimeMillis());
            System.out.println("Behandlung von " + patient.getName() + " in Zimmer " + roomNumber +
                    " gestarted. Behandlungszeit " + patient.getTreatmentDuration() + " Sekunden.");

            Thread.sleep(patient.getTreatmentDuration() * 1000L);

            System.out.println("Patient " + patient.getName() + " hatte eine Wartezeit von " +
                    patient.getWaitingTime() + " Sekunden.");
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            semaphore.v(); // release the semaphore
        }
    }
}
