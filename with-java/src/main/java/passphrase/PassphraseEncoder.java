package passphrase;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassphraseEncoder {

    @Test
    void encodePassphrase() {
        var rawPassphrase1 = "IntelCorei54440";
        var rawPassphrase2 = "Ryzen53600X";
        var encodedPassphrase1 = PassphraseEncoder.encode(rawPassphrase1);
        var encodedPassphrase2 = PassphraseEncoder.encode(rawPassphrase2);
        assertEquals("iNTELcOREI54440", encodedPassphrase1);
        assertEquals("rYZEN53600x", encodedPassphrase2);
    }

    @Test
    void decodePassphrase() {
        var encodedPassphrase1 = "jAVA11iSaVAILABLEvAR";
        var encodedPassphrase2 = "pYTHON3iSaVAILABLEtYPEiNFERENCE";
        var decodedPassphrase1 = PassphraseEncoder.decode(encodedPassphrase1);
        var decodedPassphrase2 = PassphraseEncoder.decode(encodedPassphrase2);
        assertEquals("Java11IsAvailableVar", decodedPassphrase1);
        assertEquals("Python3IsAvailableTypeInference", decodedPassphrase2);
    }

    public static String encode(String passphrase){
        char [] csen = passphrase.toCharArray();
        for(int i=0; i<csen.length; ++i){
            if (Character.isUpperCase(csen[i])){
                csen[i]=Character.toLowerCase(csen[i]);
            }else{
                csen[i]=Character.toUpperCase(csen[i]);
            }
        }
        String str = new String(csen);
        return String.join("",str);
    }

    public static String decode(String passphrase){
        char [] csen = passphrase.toCharArray();
        for(int i=0; i<csen.length; ++i){
            if (Character.isLowerCase(csen[i])){
                csen[i]=Character.toUpperCase(csen[i]);
            }else{
                csen[i]=Character.toLowerCase(csen[i]);
            }
        }
        String str = new String(csen);
        return String.join("",str);
    }

}
