package com.hsl.realestatelisitng.controller;

import com.hsl.realestatelisitng.model.Listing;
import com.hsl.realestatelisitng.service.ListingService;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Validated
@RequestMapping(path = {"/api/v1/listings"}, produces = APPLICATION_JSON_VALUE)
public class ListingController {

    private final ListingService listingService;

    @Autowired
    public ListingController(ListingService listingService) {
        this.listingService = listingService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Listing> getListingById(@PathVariable @Min(1) Long id) {

        Listing listing = listingService.getListingById(id);
        return new ResponseEntity<>(listing, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Listing>> getAllListingByAgentId(@RequestParam(name="agent_id") @Min(1)  Long agentId ){
        System.out.println(agentId);
        List<Listing> listings = listingService.getAllListingByAgentId(agentId);
        return new ResponseEntity<>(listings, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Listing> createListing(@Valid @RequestBody final Listing listing){
        Listing newListing = listingService.create(listing);
        return new ResponseEntity<>(newListing, HttpStatus.CREATED);
    }

    @PutMapping("/{listingId}")
    public ResponseEntity<Listing> updateListing(@PathVariable(name = "listingId") Long listingId,
                                                 @RequestBody Listing listing){
        Listing originalListing = listingService.getListingById(listingId);
        if(originalListing==null){
           return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
       }
        listingService.update(listing);
        return new ResponseEntity<>(listing, HttpStatus.OK);
    }


    @DeleteMapping("/{listingId}")
    public ResponseEntity<Listing> deleteListing(@PathVariable(value = "listingId") @Min(1)  Long listingId){
       listingService.delete(listingId);
       return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
