package pl.sda.programming1.datastructures.domain;

import java.util.Optional;

public interface PatientRegistry {

    void add(Patient patient);

    void update(Patient patient);

    boolean exist(Pesel pesel);

    Optional<Patient> get(Pesel pesel);

    int size();
}
