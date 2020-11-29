package com.hsl.realestatelisitng.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity(name="listings")
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Listing {
    @Id
    @JsonProperty("listing_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="listing_id")
    private Long listingId;

    @NotNull(message = "Agent id can not be empty.")
    @Min(value = 1)
    @JsonProperty("agent_id")
    private Long agentId;

    @NotEmpty(message = "City cannot be empty.")
    @Size(min = 1)
    @Column(name="city")
    @JsonProperty("city")
    private String city;

    @NotEmpty(message = "Street Address cannot be empty.")
    @Column(name="street_address")
    @Pattern(regexp = "^\\d+\\s[A-z]+\\s[A-z]+", message = "Please enter valid US Street Address.")
    @JsonProperty("street_address")
    private String streetAddress;

    @NotEmpty(message = "State cannot be empty.")
    @Column(name="state")
    @Pattern(regexp = "^(?:(A[KLRZ]|C[AOT]|D[CE]|FL|GA|HI|I[ADLN]|K[SY]|LA|M[ADEINOST]|N[CDEHJMVY]|O[HKR]|P[AR]|RI|S[CD]|T[NX]|UT|V[AIT]|W[AIVY]))$",message = "Please enter valid USA State.")
    @JsonProperty("state")
    private String state;

    @NotEmpty(message = "Postal Code cannot be empty.")
    @Pattern(regexp = "^[0-9]{5}(?:-[0-9]{4})?$",message = "Enter valid US postal code.")
    @JsonProperty("postal_code")
    @Column(name="postal_code")
    private String postalCode;

    @NotNull(message = "Asking Price cannot be empty.")
    @Min(value = 1,message = "Please provide valid asking price.")
    @JsonProperty("asking_price")
    @Column(name="asking_price")
    private float askingPrice;

    @JsonProperty("listing_date")
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name="listing_date")
    private Date listingDate;

    @UpdateTimestamp
    @JsonProperty("listing_modified_date")
    @Temporal(TemporalType.DATE)
    @Column(name = "listing_modified_date")
    private Date listingModifiedDate;

}
