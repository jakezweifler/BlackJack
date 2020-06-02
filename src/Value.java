public enum Value {
    Ace("A"),
    Two("2"),
    Three("3"),
    Four("4"),
    Five("5"),
    Six("6"),
    Seven("7"),
    Eight("8"),
    Nine("9"),
    Ten("T"),
    Jack("J"),
    Queen("Q"),
    King("K");

    private String v_str;

    Value(String v_str){
        this.v_str = v_str;
    }

    public String getV_str() {
        return v_str;
    }

}
