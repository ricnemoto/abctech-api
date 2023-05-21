package br.com.fiap.abctechapi.application.dto;

import java.util.Date;

import javax.validation.constraints.Negative;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLocationDto {

   
    private  Double latitude;

  
    private Double longitude;

    @PastOrPresent
    @JsonProperty("dateTime")
    private Date date;
}
