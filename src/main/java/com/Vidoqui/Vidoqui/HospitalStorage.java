package com.Vidoqui.Vidoqui;

import java.util.ArrayList;
import java.util.List;

public class HospitalStorage {
    private List<Hospital> hospitalList;

    public List<Hospital> getHospitals()
    {
        if(hospitalList == null)
        {
            hospitalList = new ArrayList<>();
        }

        return hospitalList;
    }

    public void setHospitalList(List<Hospital> hospitalList)
    {
        this.hospitalList = hospitalList;
    }
}
