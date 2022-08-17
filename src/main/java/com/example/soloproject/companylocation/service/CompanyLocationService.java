package com.example.soloproject.companylocation.service;

import com.example.soloproject.advice.BusinessLogicException;
import com.example.soloproject.advice.ExceptionCode;
import com.example.soloproject.companylocation.entity.CompanyLocation;
import com.example.soloproject.companylocation.repository.CompanyLocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyLocationService {

    public CompanyLocation createCompanyLocation (CompanyLocation companyLocation) {
        return null;
    }

    public CompanyLocation updateCompanyLocation(CompanyLocation companyLocation) {
        return null;
    }

//    public CompanyLocation findCompanyLocation(long companyLocationId) {
//        return findVerifiedCompanyLocation(companyLocationId);
//    }

    public List<CompanyLocation> findCompanyLocations() {
        return null;
    }

    public void deleteMember(long companyLocationId) {

    }
//    public CompanyLocation findVerifiedCompanyLocation(long companyLocationId) {
//        Optional<CompanyLocation> optionalCompanyLocation =
//                CompanyLocationRepository.findById(companyLocationId);
//        CompanyLocation findCompanyLocation =
//                optionalCompanyLocation.orElseThrow(() ->
//                        new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
//        return findCompanyLocation;
//    }
}
