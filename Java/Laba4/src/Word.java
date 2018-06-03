class Word implements Lexema { // клас для слова
    Word(String str) {
        wordS = new Letter [str.length()];  // створюємо масив знаків
        for (int i = 0; i < str.length(); i++)
        {
            wordS[i] = new Letter(str.charAt(i));  // зберігаємо всі знаки слова у масив знаків
        }
    }

    private Letter[] wordS; // збережене слово

    private static final boolean flag = true; // флаг того, що це слово
    public boolean isWord()
    {
        return flag; // перевірка на, що це слово
    }
    public String getString() // перетворює масив знаків на слово-стрінг
    {
        char[] arrayChar = new char[wordS.length];
        for(int i = 0; i < wordS.length; i++)
        {
            arrayChar[i] = wordS[i].character;
        }
        return new String(arrayChar);
    }
}