package com.example.soloproject.companylocation.repository;

import com.example.soloproject.companylocation.entity.CompanyLocation;
import com.example.soloproject.companytype.entity.CompanyType;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CompanyLocationRepository extends CrudRepository<CompanyLocation, Long> {

    CompanyLocation save(CompanyLocation companyLocation);
    Optional<CompanyLocation> findById(long companyLocationId);
    Optional<CompanyLocation> findByName(String location);


    //    Optional<Coffee> findByCoffeeCode(String coffeeCode);
//
//    // (2) 수정된 부분
////    @Query(value = "FROM Coffee c WHERE c.coffeeId = :coffeeId")  // (2-1)
////    @Query(value = "SELECT * FROM COFFEE WHERE coffee_Id = :coffeeId", (2-2)
////																																	nativeQuery = true)
//    @Query(value = "SELECT c FROM Coffee c WHERE c.coffeeId = :coffeeId")  // (2-3)
//    Optional<Coffee> findByCoffee(long coffeeId);
}
