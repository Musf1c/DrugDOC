package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Recipe {
    public String titleDrug;
    public String nameDoc;
    public String patient;
    public String dateOfAction;
    public int totalQuantity;
    public String uniqueKey;
}
