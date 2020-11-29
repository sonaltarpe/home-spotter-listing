package com.hsl.realestatelisitng.service;

import com.hsl.realestatelisitng.model.Listing;
import com.hsl.realestatelisitng.repository.ListingRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class ListingService {

   private ListingRepository listingRepository;

   public Listing getListingById(final Long id){
      return listingRepository.getOne(id);
   }

   public Listing create(final Listing listing){
      return listingRepository.saveAndFlush(listing);
   }

   public Listing update(final Listing listing){
      return listingRepository.saveAndFlush(listing);
   }

   public void delete(final Long id){
       listingRepository.deleteById(id);
   }

   public List<Listing> getAllListingByAgentId(Long agentId){
      return listingRepository.findByAgentId(agentId);
   }

}
