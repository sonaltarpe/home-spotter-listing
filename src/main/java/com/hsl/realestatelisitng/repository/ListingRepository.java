package com.hsl.realestatelisitng.repository;

import com.hsl.realestatelisitng.model.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {
    List<Listing> findByAgentId(Long agentId);
}
