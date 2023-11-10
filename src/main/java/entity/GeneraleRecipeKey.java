package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.codec.digest.HmacUtils;

import java.util.List;

import static org.apache.commons.codec.digest.HmacAlgorithms.HMAC_SHA_224;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class GeneraleRecipeKey {
    public String nameDoc;
    public String titleDrug;
    public String patient;
    public String dateOfAction;
    public int availableCount;
    public String keyWord;

   public static GeneraleRecipeKey getGeneraleRecipeKeyInList(List<GeneraleRecipeKey> generaleRecipeKeyList, String key) {
       GeneraleRecipeKey res = new GeneraleRecipeKey();
       for (GeneraleRecipeKey generale: generaleRecipeKeyList) {
           String hashedPassword = new HmacUtils(HMAC_SHA_224, "secret".getBytes()).hmacHex(generale.keyWord);
           if(hashedPassword.equals(key)) {
               res = generale;
               break;
           }
       }
       return res;
   }
}
