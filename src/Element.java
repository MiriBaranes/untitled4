public class Element {
    private char letter;
    private int amount;

    public Element(char letter,int amount){
        if (amount>0) {
            this.letter = letter;
            this.amount = amount;
        }
        else System.out.println("invalid");
    }
    public int getAmount(){
        return amount;
    }
    public void setAmount(int amount){
        if (amount>0){
            this.amount=amount;
        }
    }
    public char getLetter(){
        return letter;
    }
    public String toString (){
        String output= "("+this.amount+","+this.letter+")";
        return output;
    }
}
