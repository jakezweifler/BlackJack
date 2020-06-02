public enum Suit {
    Spades("S"),
    Hearts("H"),
    Diamonds("D"),
    Clubs("C");

    private String s_str;

    Suit(String s_str){
        this.s_str = s_str;
    }

    public String getS_str() {
        return s_str;
    }

}
