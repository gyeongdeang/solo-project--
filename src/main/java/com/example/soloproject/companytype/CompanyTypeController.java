package com.example.soloproject.companytype;

import com.example.soloproject.companylocation.service.CompanyLocationService;
//import com.example.soloproject.companytype.Dto.CompanyTypeDto;
import com.example.soloproject.companytype.Dto.TypePostDto;
import com.example.soloproject.companytype.entity.CompanyType;
import com.example.soloproject.companytype.service.CompanyTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/companyTypes")
@Slf4j
@Validated
public class CompanyTypeController {

//    private CompanyTypeService companyTypeService;
//
//    private CompanyTypeMapper typeMapper;
//
//    public CompanyTypeController(CompanyTypeService companyTypeService,CompanyTypeMapper typeMapper) {
//
//        this.companyTypeService = companyTypeService;
//        this.typeMapper = typeMapper;
//    }

   @PostMapping
    public ResponseEntity postCompanyType(@Valid @RequestBody TypePostDto typePostDto){
//        CompanyType companyType =
//                companyTypeService.createCompanyType(typeMapper.TypePostDtoToCompanyType(typePostDto));
//
//                return new ResponseEntity<>(
//                new SingleResponseDto<>(mapper.companyToCompanyRespenseDto(companyType)), HttpStatus.OK);
//    }

       return new ResponseEntity<>(typePostDto, HttpStatus.CREATED);
    }

//
    @GetMapping("/{company-id}")
    public ResponseEntity getCompanyType(@PathVariable("company-id")long companyTypeId){
//        CompanyType companyType = CompanyTypeService.findCompanyType(companyTypeId);
//
//        return new ResponseEntity<>(
//                new SingleResponseDto<>(mapper.companyToCompanyRespenseDto(companyType)), HttpStatus.OK);
//    }

    System.out.println("# companyTypeId: " +companyTypeId);

    // not implementation

    return new ResponseEntity<>(HttpStatus.OK);
}

    @GetMapping
    public ResponseEntity getCompanyTypes(){
//        List<CompanyType> response = CompanyLocationService.findCompanyTypes();
//
//        System.out.println("get CompanyLocations");
//
//        return new ResponseEntity<>(
//                new StringleResponseDto<>(mapper.CompanyLocationsToCompanyLocationResponseDtos(CompanyTypes),
//    pageMembers),
//    HttpStatus.OK);
    System.out.println("# CompanyLocations");

    // not implementation

    return new ResponseEntity<>(HttpStatus.OK);
}


}

