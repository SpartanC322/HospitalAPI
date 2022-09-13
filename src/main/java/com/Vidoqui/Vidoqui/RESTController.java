package com.Vidoqui.Vidoqui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/hospitalstorage")
public class RESTController {

    @Autowired
    private  HospitalDAO hospitalDAO;

    @GetMapping(
            path = "/",
            produces = "application/json"
    )

    //Show all hospitals
    public HospitalStorage getHospitals()
    {
        return hospitalDAO.getAllHospitals();
    }

    @PostMapping(
            path = "/",
            consumes = "application/json",
            produces = "application/json"
    )

    //Adds hospital
    public ResponseEntity<Object> addHospital(@RequestBody Hospital hospital)
    {
        hospitalDAO.addHospital(hospital);

        URI location
                = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{name}")
                .buildAndExpand(
                        hospital.getLocation())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @PutMapping(
            path = "/",
            consumes = "application/json",
            produces = "application/json"
    )

    //Find the closest Hospital using x, y coordinates of given ambulance and hospitals
    public Hospital findClosestHospital(@RequestBody Ambulance ambulance)
    {
        Hospital closest = new Hospital();
        double distance = 0;
        List<Hospital> hospitals = hospitalDAO.getAllHospitals().getHospitals();
        for (Hospital hospital : hospitals)
        {
            distance = Math.sqrt((hospital.getLocation().x - ambulance.getLocation().x) * (hospital.getLocation().x - ambulance.getLocation().x)
                    + (hospital.getLocation().y - ambulance.getLocation().y) * (hospital.getLocation().y - ambulance.getLocation().y));
            if (distance < closest.getDistance() || closest.getDistance() == 0)
            {
                closest.setName(hospital.getName());
                closest.setLocation(hospital.getLocation());
                closest.setDistance(distance);
            }
        }

        return closest;
    }
}