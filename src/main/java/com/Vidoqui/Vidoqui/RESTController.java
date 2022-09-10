package com.Vidoqui.Vidoqui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Vidoqui.Vidoqui.Hospital;
import com.Vidoqui.Vidoqui.HospitalDAO;
import com.Vidoqui.Vidoqui.HospitalStorage;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path = "/hospitalstorage")
public class RESTController {

    @Autowired
    private  HospitalDAO hospitalDAO;

    @GetMapping(
            path = "/",
            produces = "application/json"
    )

    public HospitalStorage getHospitals()
    {
        return hospitalDAO.getAllHospitals();
    }

    @PostMapping(
            path = "/",
            consumes = "application/json",
            produces = "application/json"
    )

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
}