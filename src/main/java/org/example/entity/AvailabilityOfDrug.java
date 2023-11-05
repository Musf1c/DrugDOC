package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AvailabilityOfDrug { // наличие лекарств
    public String titleDrag;
    public int remains; //остаток
}
