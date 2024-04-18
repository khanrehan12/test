package com.releationcombined.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.releationcombined.entity.Address;

public interface AddressRepo extends JpaRepository<Address,Integer> {

}
