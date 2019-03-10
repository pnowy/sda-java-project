package pl.sda.programming1.datastructures.domain;

import java.util.Objects;

public class Patient {

    private final Pesel pesel;
    private final String name;

    public Patient(Pesel pesel, String name) {
        this.pesel = Objects.requireNonNull(pesel, "Pesel cannot be null!");
        this.name = name;
    }

    public Pesel getPesel() {
        return pesel;
    }

    public String countSomething() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "CountingResult";
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return pesel.equals(patient.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pesel);
    }
}
