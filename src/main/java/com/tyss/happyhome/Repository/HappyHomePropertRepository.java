package com.tyss.happyhome.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tyss.happyhome.entity.Property;

public interface HappyHomePropertRepository extends JpaRepository<Property, Integer> {

}
