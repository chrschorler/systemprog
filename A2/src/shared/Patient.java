package shared;

public class Patient {

    private String name;
    private int treatmentRoom;
    private int treatmentDuration;
    private long admissionTime;
    private long treatmentStart;

    public Patient(String name, int treatmentRoom, int treatmentDuration) {
        this.name = name;
        this.treatmentRoom = treatmentRoom;
        this.treatmentDuration = treatmentDuration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTreatmentRoom() {
        return treatmentRoom;
    }

    public void setTreatmentRoom(int treatmentRoom) {
        this.treatmentRoom = treatmentRoom;
    }

    public int getTreatmentDuration() {
        return treatmentDuration;
    }

    public void setTreatmentDuration(int treatmentDuration) {
        this.treatmentDuration = treatmentDuration;
    }

    public long getAdmissionTime() {
        return admissionTime;
    }

    public void setAdmissionTime(long admissionTime) {
        this.admissionTime = admissionTime;
    }

    public long getTreatmentStart() {
        return treatmentStart;
    }

    public void setTreatmentStart(long treatmentStart) {
        this.treatmentStart = treatmentStart;
    }

    public long getWaitingTime() {
        return (treatmentStart - admissionTime) / 1000;
    }
}