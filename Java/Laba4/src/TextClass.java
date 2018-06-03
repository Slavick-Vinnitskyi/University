import java.util.Vector;
class TextClass {
    String str;
    Vector<Sentence> sentence = new Vector<Sentence>();
    public  TextClass(String str) {
        this.str = str;
    }

    public void DoStuff() {
        final String sentenceDelimeters = ("[?.!]");
        int currentPos = 0;
        int i = 0;
        while(i < str.length()) {
            currentPos = i;
            while(sentenceDelimeters.indexOf(str.charAt(i)) < 0 && i != str.length() - 1)
                i++;

            sentence.add(new Sentence( str.substring(currentPos, i + 1 )));
//            System.out.println(str.substring(currentPos, i + 1));
            i++;

        }
//        System.out.println(sentence.size());
        for (int k = 0; k < sentence.size(); k++)
            sentence.elementAt(k).Split();
    }

}