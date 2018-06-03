public class Main {

        public static void main(String[] args) {
            String str = "Inhabiting discretion the her dispatched decisively boisterous joy. "+
                         "So form were wish open is able of mile of.";
            str =  str.replaceAll("\\s+", " ");
            System.out.println(str);
            TextClass text = new TextClass(str);
            text.DoStuff();
        }
}


