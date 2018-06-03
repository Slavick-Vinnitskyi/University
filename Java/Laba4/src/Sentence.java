import java.util.Scanner;
import java.util.Vector;

class Sentence {
    String str;
    Vector<Lexema> lexems = new Vector<>();

    public Sentence(String str) {
        Scanner input = new Scanner(System.in);
        String symbol = input.nextLine().toLowerCase();
        int del_start = str.toLowerCase().indexOf(symbol.toString());
        int del_end = str.toLowerCase().lastIndexOf(symbol.toString());
        StringBuilder temp = new StringBuilder(str);
        temp.delete(del_start,del_end + 1);
        this.str = temp.toString();

    }

    public void Split(){

        String Delim = ("[:\";'()*+,-./'<=>?@[\\\\]^_`{|}~, -.#$%&'?!]");
        int currentPos = 0;
        int i = 0;
        while( i < str.length()) {
            if(Delim.indexOf(str.charAt(i)) >= 0) {
                lexems.add(new Punctuation(str.charAt(i)));
                i++;
                continue;
            }
            currentPos = i;
            i++;
            while(i != (str.length()) && Delim.indexOf(str.charAt(i-1)) < 0) {
                i++;
            }

            lexems.add(new Word(str.substring(currentPos, i)));
        }

        for (int k = 0; k < lexems.size(); k++) {
            System.out.print(lexems.elementAt(k).getString());
        }
    }
}