package passphrase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;
import java.util.List;

public class PassphraseGeneratorTests {

    private final List<String> lowers;
    private final List<String> uppers;
    private final List<String> numbers;

    PassphraseGeneratorTests() {
        this.lowers = Arrays.asList("a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".split(","));
        this.uppers = Arrays.asList("A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z".split(","));
        this.numbers = Arrays.asList("1,2,3,4,5,6,7,8,9,0".split(","));
    }

    @RepeatedTest(10000)
    public void testPassphrase() {
        generatePassphraseNotContainUppers();
        generatePassphraseBySpecifiedLength();
        generateEmptyWhenAllConfigIsFalse();
    }


    public void generatePassphraseNotContainUppers(){
        var passphraseGenerator = new PassphraseGenerator(true,false,true);
        var passphrase = passphraseGenerator.generate(1024);

        if(passphrase == passphrase.toLowerCase()){
            System.out.println("大文字は含まれていません。");
        } else {
            System.out.println("大文字が含まれています。");
        }
    }


    public void generatePassphraseBySpecifiedLength() {
        var passphraseGenerator = new PassphraseGenerator(true,true,true);
        var passphrase = passphraseGenerator.generate(1024);

        if (passphrase.length() == 1024) {
            System.out.println("1024文字で適切な長さです。");
        } else {
            System.out.println("不適切な長さです。");
        }

    }

   public void generateEmptyWhenAllConfigIsFalse(){
       var passphraseGenerator = new PassphraseGenerator(false,false,false);
       var passphrase = passphraseGenerator.generate(1024);

       if(passphrase == ""){
           System.out.println("passphraseは空白です。");
       } else {
           System.out.println("passphraseは空白ではありません。");
       }
    }
}
