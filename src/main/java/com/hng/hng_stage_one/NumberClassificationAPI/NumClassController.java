package com.hng.hng_stage_one.NumberClassificationAPI;

import com.hng.hng_stage_one.NumberClassificationAPI.exceptions.NumClassException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/")
public class NumClassController {

    private final NumClassService numClassService;

    public NumClassController(NumClassService numClassService) {
        this.numClassService = numClassService;
    }

    @GetMapping(value = "classify-number")
    public ResponseEntity<?> getAccessToken(@RequestParam(value="number") String number) throws NumClassException {
        return numClassService.classifyNumber(number);
    }
}
