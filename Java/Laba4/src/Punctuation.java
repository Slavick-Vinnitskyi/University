class Punctuation implements Lexema { // клас знаків пунктуації
    private char punct;

    public String getString()
    {
        return String.valueOf(punct); //  нічого не повертає(null), адже це не слово
    }
    Punctuation (char c)
    {
        punct = c; // зберігаємо знак пунктуації
    }
    private static final boolean flag = false; //завжди false, адже це не слово
    public boolean isWord()
    {
        return flag;
    }
}
