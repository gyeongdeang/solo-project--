package com.example.soloproject.companytype.service;

import com.example.soloproject.advice.BusinessLogicException;
import com.example.soloproject.companytype.entity.CompanyType;
import com.example.soloproject.companytype.repository.CompanyTypeRepository;
import org.springframework.stereotype.Service;

import java.awt.color.CMMException;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyTypeService {

    private CompanyTypeRepository companyTypeRepository;

    public CompanyTypeService(CompanyTypeRepository companyTypeRepository){
        this.companyTypeRepository = companyTypeRepository;
    }

    public CompanyType createCompanyType (CompanyType companyType) {

        CompanyType createdCompanyType = companyType;

        return createdCompanyType;
    }

    public CompanyType updateCompanyType(CompanyType companyType) {
        CompanyType updatedCompanyType = companyType;
        return updatedCompanyType;
    }

//    public CompanyType findCompanyType(long companyTypeId) {
//
//        return findVerifiedCompanyType(companyTypeId);
//    }

    public List<CompanyType> findCompanyTypes() {

        return null;
    }

    public void deleteCompanyType(long CompanyTypeId) {

    }


//    public CompanyType findVerifiedCompanyType(long companyTypeId){
//        Optional<CompanyType> optionalCompanyType =
//                CompanyTypeRepository.findById(companyTypeId);
//        CompanyType findCompanyType =
//                optionalCompanyType.orElseThrow(()->new BusinessLogicException());
//    }


}
