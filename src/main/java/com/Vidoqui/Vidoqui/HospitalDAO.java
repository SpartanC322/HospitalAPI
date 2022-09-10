package com.Vidoqui.Vidoqui;

import org.springframework.stereotype.Repository;

import java.awt.*;

@Repository

public class HospitalDAO {
    private static HospitalStorage hospitals = new HospitalStorage();

    static
    {
        hospitals.getHospitals().add(
                new Hospital("Laughing Democritus Hospital", 35,51));

        hospitals.getHospitals().add(
                new Hospital("Crying Heraclitus Hospital", -40,12));

        hospitals.getHospitals().add(
                new Hospital("Seven Sages Hospital", 0,-33));
    }

    public HospitalStorage getAllHospitals()
    {
        return hospitals;
    }

    public void addHospital(Hospital hospital)
    {
        hospitals.getHospitals().add(hospital);
    }
}