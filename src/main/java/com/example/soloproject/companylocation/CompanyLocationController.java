package com.example.soloproject.companylocation;

import com.example.soloproject.companylocation.Dto.LPostDto;
import com.example.soloproject.companylocation.entity.CompanyLocation;
import com.example.soloproject.companylocation.service.CompanyLocationService;
import com.example.soloproject.companytype.entity.CompanyType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/v1/CompanyLocations")
@Slf4j
@Validated
public class CompanyLocationController {

//    private CompanyLocationService companyLocationService;
//
//    private CompanyLocationMapper locationMapper;
//
//    public CompanyLocationController(CompanyLocationService companyLocationService, CompanyLocationMapper locationMapper) {
//        this.companyLocationService = companyLocationService;
//        this.locationMapper = locationMapper;
//    }

    @PostMapping
    public ResponseEntity postCompanyLocation(@Valid @RequestBody LPostDto lPostDto) {
//      CompanyLocation companyLocation = companyLocationService.createCompanyLocation(locationMapper.LPostDtoToCompanyLocation(LPostDto));
//
//              return new ResponseEntity<>(
//                      new SingleResponseDto<>(locationMapper.companyLocationToCompanyLocationResponseDto(companyLocation)),
//                      HttpStatus.CREATED);
//
//    }
        return new ResponseEntity<>(lPostDto, HttpStatus.CREATED);
    }

    //
//
    @GetMapping("/{company-id}")
    public ResponseEntity getCompanyLocation(@PathVariable("company-id") long companyLocationId) {
//        CompanyLocation companyLocation = CompanyLocationService.findCompanyLocation(companyLocationId);
//
//        return new ResponseEntity<>(
//                new SingleResponseDto<>(mapper.companyLoccaionToCompanyLocationResponseDto(companyLocation)), HttpStatus.OK);
//    }

        {
            System.out.println("# companyLocationId: " + companyLocationId);

            // not implementation

            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity getCompanyLocations() {
        System.out.println("# get CompanyLocations");

        // not implementation

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
//
//    @GetMapping
//    System.out.println("get CompanyLocations");
//
//        return new ResponseEntity<>(
//                new StringleResponseDto<>(mapper.membersToMemberResponseDtos(members),
//    pageMembers),
//    HttpStatus.OK);




