(1) The general  problem  you  are  trying  to  solve:
This assignment consists of tons of user inputs and array list managment. The general problem is being able to keep up with what each function does, and how it does what it's supposed to do. I also struggled with implementing hash maps in my 

To Compile and Build: 
-javac a3/*.java
-java a3/gui "test.txt"

(2) What  are  the  assumptions  and  limitations  of  your solution:
For the initial menu the user is required to enter the name of the command they would like to run so if they enter anything the program won't run. In additon. I assumed Stock symbols are NOT case sensitive. I also did NOT round any doubles. I also assumed that the book value gets updated when updating the price for an investment.

(3) How can a user build and test your program (also called the user guide):

    1. User is given a menu of commands. User must enter one of the commands.
    2. Buy: If user chooses to buy they are required to enter the;
        - Symbol of the Stock/Mutual Fund
        - Name of the Stock/Mutual Fund
        - Quantity of the Stock/Mutual Fund
        - Price of the Stock/Mutual Fund
    3. Sell: If the user chooses to sell they are required to enter the;
        - Symbol of the Stock/Mutual Fund
        - Quantity of the Stock/Mutual Fund
        - Price of the Stock/Mutual Fund
    4. Update: If the user chooses to update the are required to enter the new prices for all the stocks/Mutual Funds one by one.
    5. Gain: If the user chooses gain the program will show the total gain across funds and stocks.
    6. Search: If the user chooses search the program they are required to enter the symbol, key words for the name and the price range.
    The program will then search for the stock with the corresponding symbol, key words in the name, as well as the price range. In addition, using the Hashmap, search will break down the name input using keys and values.
    7. Quit: If the user chooses to quit the application closes.

(4) How is the program tested for correctness (i.e., the test plan should be part of the README file):
Test Plan: 

Buy
-Stock
-Symbol: a | Name: a | Quantity: 1 | Price: 55.5

Buy
-Stock
-Symbol: b | Name: b | Quantity: 2 | Price: 150

Buy
-Stock
-Symbol: c | Name: c | Quantity: 3 | Price: 150

Buy
-Stock
-Symbol: d | Name: d | Quantity: 4 | Price: 150

Buy
-Stock
-Symbol: e | Name: f | Quantity: 5 | Price: 150

Buy
-Stock
-Symbol: f | Name: f | Quantity: 6 | Price: 150

Buy
-Stock
-Symbol: g | Name: g | Quantity: 7 | Price: 150

Buy
-Stock
-Symbol: h | Name: h | Quantity: 8 | Price: 150

Buy
-Stock
-Symbol: i | Name: i | Quantity: 9 | Price: 150

Buy
-Stock
-Symbol: j | Name: j | Quantity: 10 | Price: 150

Buy
-Stock
-Symbol: k | Name: k | Quantity: 11 | Price: 150

Buy
-Stock
-Symbol: l | Name: l | Quantity: 12 | Price: 150

Buy
-Stock
-Symbol: m | Name: m | Quantity: 13 | Price: 150

Buy
-Stock
-Symbol: n | Name: n | Quantity: 14 | Price: 150

getGain

Update
-Update for b = 100
-Update for d = 200

getGain
s
Buy
-Stock
-Symbol: o | Name: o | Quantity: 15 | Price: 150

Buy
-Stock
-Symbol: p | Name: p | Quantity: 16 | Price: 150

Sell
-Symbol: p | Name: p | Quantity: 4 | Price: 100

getGain

Sell
-Symbol: a | Name: a | Quantity: 1 | Price: 100

getGain

Sell
-Symbol: b | Name: b | Quantity: 2 | Price: 100

getGain

Update
-Update for c = 100
-Update for e = 20
-Update for k = 320
-Update for i = 40
-Update for o = 50
-Update for p = 60

getGain

Search
-Symbol:  | Name: n | Low Price: | High Price: 

Quit

Check if investments update in text file.

(5) What  possible  improvements  could  be  done  if  you  were  to  do  it  again  or  have  extra  time available:
Since A1 I have improved my code slightly however, I feel like my code is still not optimized to the fullest and there is still room for improvments.

![image](https://user-images.githubusercontent.com/55255451/148811843-54a88bef-85c7-4702-92e1-ad7176d38243.png)

![image](https://user-images.githubusercontent.com/55255451/148811864-b3e8fd5c-6f96-4469-bd37-6686190bcd42.png)

![image](https://user-images.githubusercontent.com/55255451/148811885-38f49035-e547-4ab7-bbfd-a08d215c42a6.png)

![image](https://user-images.githubusercontent.com/55255451/148811934-f8e273fc-22ed-471b-a63c-62cb029be329.png)
