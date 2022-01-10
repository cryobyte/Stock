package a3;
/** 
*
* MutualFund
* Discription: MutualFund class 
*/
public class MutualFund extends Investment{

    final double redemptionFee = 45;
    private double bookValue;
    /** 
     * 
     * MutualFund
     * Discription: constructor
     * @param symbol: String symbol
     * @param name: String name
     * @param quantity: int quantity
     * @param price: double price
     * @throws Exception - throws exception if conditions arent met
     */
    public MutualFund(String symbol, String name, int quantity, double price) throws Exception
    {
        super(symbol, name, quantity, price);

        if(!(symbol.isEmpty() || name.isEmpty() || quantity <= 0 || price <= 0)){
            bookValue = (price * quantity) + redemptionFee;
        }
        else{
            throw new Exception("Fatal error: Information either not present or not within range.");
        }
    }

    public double getBookValue() {
	    return bookValue;
    }

    public void setBookValue(double newValue) {
	    bookValue = newValue;
    }

    public double calcBookValue(double price, int quantity) {
        return (price * quantity) + redemptionFee;
    }

    public String getType() {
        return "mutualfund";
    }

    public String toString()
    {
        return "type = \"mutualFund\"\n" +
                "symbol = \"" + getSymbol() + "\"\n" + 
                "name = \"" + getName() + "\"\n" +
                "quantity = \"" + getQuantity() + "\"\n"+
                "price = \"" + getPrice() + "\"\n" +
                "bookValue = \"" + getBookValue()+"\"\n";
    }
}
