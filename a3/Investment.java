package a3;
/** 
*
* Investment
* Discription: Investment class 
*/
public abstract class Investment {
    final double commissionFee = 9.99;
    final double redemptionFee = 45;

    private String symbol;
    private String name;
    private int quantity;
    private double price;
    private double bookValue;
    /** 
     * 
     * calcBookValue
     * Discription: abstract class
     * @param price: double price
     * @param quantity: int quantity
     * @return double
     */
    abstract public double calcBookValue(double price, int quantity);
    /** 
     * 
     * toString
     * Discription: abstract class
     * @return String
     */
    abstract public String toString();
    /** 
     * 
     * getType
     * Discription: abstract class
     * @return String
     */
    abstract public String getType();
    /** 
     * 
     * Investment
     * Discription: constructor
     * @param symbol: String symbol
     * @param name: String name
     * @param quantity: int quantity
     * @param price: double price
     * @throws Exception - throws exception if conditions arent met
     */
    public Investment(String symbol, String name, int quantity, double price) throws Exception {

        if(!(symbol.isEmpty() || name.isEmpty() || quantity <= 0 || price <= 0)){
            setSymbol(symbol);
            setName(name);
            setQuantity(quantity);
            setPrice(price);
        }
        else{
            throw new Exception("Fatal error: Information either not present or not within range.");
        }
        
    }
    /** 
     * 
     * getBookValue
     * Discription: gets bookValue
     * @return bookValue
     */
    public double getBookValue() {
	    return bookValue;
    }
    /** 
     * 
     * setBookValue
     * Discription: sets the book value
     * @param newValue: double newValue
     */
    public void setBookValue(double newValue) {
	    bookValue = newValue;
    }
    /** 
     * 
     * getSymbol
     * Discription: returns symbol
     * @return symbol
     */
    public String getSymbol() {
	    return symbol;
    }
    /** 
     * 
     * setSymbol
     * Discription: sets the symbol
     * @param symbol: String symbol
     */
    public void setSymbol(String symbol) {
	    this.symbol = symbol;
    }
    /** 
     * 
     * getSymbol
     * Discription: returns the name
     * @return symbol
     */
    public String getName() {
	    return name;
    }
    /** 
     * 
     * setName
     * Discription: sets the name
     * @param name: String name
     */
    public void setName(String name) {
	    this.name = name;
    }
    /** 
     * 
     * getQuantity
     * Discription: returns quantity
     * @return symbol
     */
    public int getQuantity() {
	    return quantity;
    }
    /** 
     * 
     * setName
     * Discription: sets the quantity
     * @param quantity: int quantity
     */
    public void setQuantity(int quantity) {
	    this.quantity = quantity;
    }
    /** 
     * 
     * getSymbol
     * Discription: returns the price
     * @return symbol
     */
    public double getPrice() {
	    return price;
    }
    /** 
     * 
     * setPrice
     * Discription: sets the price
     * @param price: double price
     */
    public void setPrice(double price) {
	    this.price = price;
    }
}
