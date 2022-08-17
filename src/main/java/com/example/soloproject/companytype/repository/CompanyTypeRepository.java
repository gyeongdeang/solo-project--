package com.example.soloproject.companytype.repository;

import com.example.soloproject.companylocation.entity.CompanyLocation;
import com.example.soloproject.companytype.entity.CompanyType;
import com.example.soloproject.member.entity.Member;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CompanyTypeRepository extends CrudRepository<CompanyLocation, Long> {
    CompanyType save(CompanyType companyType);
    Optional<CompanyType> findById(long companyTypeId);
    Optional<CompanyType> findByName(String  workType);
}

