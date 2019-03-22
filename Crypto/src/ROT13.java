import static java.lang.Character.*;

public class ROT13  {

    private Character cs;
    private Character cf;
    private String alphabet;
    private String cryptString;

    ROT13(Character cs, Character cf) {
        this.cs = cs;
        this.cf = cf;
        this.alphabet = rotate("ABCDEFGHIJKLMNOPQRSTUVWXYZ", cs);
        this.cryptString = rotate(alphabet,cf);
    }

    ROT13() {
        this.cs = 'a';
        this.cf = 'n';
    }


    public String crypt(String text) throws UnsupportedOperationException {
        String result = "";
        for (Character c : text.toCharArray()) {
            if(isLetter(c)) {
                int index = this.alphabet.indexOf(toUpperCase(c));
                if(isUpperCase(c)){
                    result += cryptString.charAt(index);
                }
                else {
                    result += cryptString.toLowerCase().charAt(index);
                }
            } else {
                result += c;
            }
        }
        return result;
    }

    public String encrypt(String text) {
        return crypt(text);
    }

    public String decrypt(String text) {
        return crypt(text);
    }

    public static String rotate(String s, Character c) {
        String result = "";
        int index = s.indexOf(toUpperCase(c));

        for(int i = index; i < s.length(); i++){
            result += s.charAt(i);
        }
        for(int i = 0; i < index; i++){
            result += s.charAt(i);
        }
        return result;
    }

    public static void main(String[] args) {
    }

}
