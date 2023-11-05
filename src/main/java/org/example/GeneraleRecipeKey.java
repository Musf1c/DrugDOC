package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class GeneraleRecipeKey {
    public String nameDoc;
    public String titleDrug;
    public String patient;
    public Date dateOfAction;
    public String keyWord;
}
