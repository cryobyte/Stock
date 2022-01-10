package a3;
/** 
*
* Stock
* Discription: Stock class 
*/
public class Stock extends Investment{

    final double commissionFee = 9.99;
    private double bookValue;
    /** 
     * 
     * Stock
     * Discription: constructor
     * @param symbol: symbol
     * @param name: name
     * @param quantity: quantity
     * @param price: price
     * @throws Exception - throws exception if conditions arent met
     */
    public Stock(String symbol, String name, int quantity, double price) throws Exception 
    {
        super(symbol, name, quantity, price);

        if(!(symbol.isEmpty() || name.isEmpty() || quantity <= 0 || price <= 0)){
            bookValue = (price * quantity + commissionFee);
        }
        else{
            throw new Exception("Fatal error: Information either not present or not within range.");
        }

    }
    
    /** 
   * 
   * getBookValue
   * Discription: This function checks if an investment exists
   * @return bookValue: value
   */
    public double getBookValue() {
	    return bookValue;
    }
    /** 
   * 
   * setBookValue
   * Discription: This function checks if an investment exists
   * @param newValue: value
   */
    public void setBookValue(double newValue) {
	    bookValue = newValue;
    }
    /** 
   * 
   * calcBookValue
   * Discription: This function checks if an investment exists
   * @param price: price
   * @param quantity: quantityt
   */
    public double calcBookValue(double price, int quantity) {
        return quantity * price + commissionFee;
    }
    /** 
   * 
   * calcBookValue
   * Discription: This function checks if an investment exists
   * @return stock
   */
    public String getType() {
        return "stock";
    } 

    public String toString()
    {
        return "type = \"stock\"\n" +
                "symbol = \"" + getSymbol() + "\"\n" + 
                "name = \"" + getName() + "\"\n" +
                "quantity = \"" + getQuantity() + "\"\n"+
                "price = \"" + getPrice() + "\"\n" +
                "bookValue = \"" + getBookValue()+"\"\n";
    }
}
