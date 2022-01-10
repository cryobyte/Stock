package a3;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/** 
*
* gui
* Discription: Gui class hold everything
*/
public class gui extends JFrame {

   //declaring variables
   /** 
   * headerLabel
   */
   private JLabel headerLabel;
   /** 
   * statusLabel
   */
   private JLabel statusLabel = new JLabel();
   /** 
   * controlPanel
   */
   private JPanel controlPanel;
   /** 
   * mainPanel
   */
   private JPanel mainPanel;
   /** 
   * menuBar
   */
   JMenuBar menuBar;
   /** 
   * menu
   */
   JMenu menu;
   /** 
   * menu2
   */
   JMenu menu2;
   /** 
   * buy
   */
   JMenuItem buy;
   /** 
   * sell
   */
   JMenuItem sell;
   /** 
   * update
   */
   JMenuItem update; 
   /** 
   * gain
   */
   JMenuItem gain;
   /** 
   * search
   */
   JMenuItem search;
   /** 
   * exit
   */
   JMenuItem exit;
   /** 
   * stock
   */
   JMenuItem stock;
   /** 
   * mutualfund
   */
   JMenuItem mutualfund;
   static String filename;
   /** 
   * index
   */
   int index;

   // private JButton submit;
   private static JTextArea outputLabel;
   private static ArrayList<Investment> investments = new ArrayList<Investment>();
   private static HashMap<String, Integer[]> keywordsMap = new HashMap<String, Integer[]>();

   /**
   *
   * gui
   * Discription: constructor
   */
   public gui() {
      super();
      prepareGUI();
      showBorderLayout();
   }

   private class MyListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {

         remove(headerLabel);
         remove(statusLabel);

         JPanel textPanel = new JPanel();
         textPanel.setLayout(new FlowLayout()); 

         JPanel textPanel2 = new JPanel();
         textPanel2.setLayout(new FlowLayout()); 
 
         JPanel textPanel3 = new JPanel();
         textPanel3.setLayout(new FlowLayout()); 
         
         JPanel textPanel4 = new JPanel();
         textPanel4.setLayout(new FlowLayout()); 
 
         JPanel textPanel5 = new JPanel();
         textPanel5.setLayout(new FlowLayout()); 

         String gainChange = "";
         String searchChange = "";

         if(e.getSource() == buy){

            controlPanel.removeAll();
            mainPanel.removeAll();

            JPanel msgPanel = new JPanel();
            msgPanel.setLayout(new FlowLayout()); 
            JLabel msg = new JLabel("Buying an Investment");
            msg.setFont(new Font("Verdana", Font.PLAIN, 17));
            msgPanel.add(msg);

            JPanel containerPanel = new JPanel(new GridLayout(2, 1));
            
            // controlPanel.removeAll();
            String[] choices = {"Stock", "Mutual Fund"};
            final JComboBox<String> cb = new JComboBox<String>(choices);
            cb.setMaximumSize(cb.getPreferredSize()); // added code
            cb.setAlignmentX(Component.LEFT_ALIGNMENT);// added code
            // cb.setVisible(true); // Not needed

            JLabel type = new JLabel("Type");
            cb.setPreferredSize(new Dimension(150,20));
            type.setPreferredSize(new Dimension(100,20));

            JLabel symbol = new JLabel("Symbol");
            JTextField symb = new JTextField();
            symb.setPreferredSize(new Dimension(150,20));
            symbol.setPreferredSize(new Dimension(100,20));

            JLabel name = new JLabel("Name");
            JTextField nme = new JTextField();
            nme.setPreferredSize(new Dimension(250,20));
            name.setPreferredSize(new Dimension(100,20));

            JLabel quantity = new JLabel("Quantity");
            JTextField qnt = new JTextField();
            qnt.setPreferredSize(new Dimension(150,20));
            quantity.setPreferredSize(new Dimension(100,20));

            JLabel price = new JLabel("Price   ");
            JTextField prce = new JTextField();
            prce.setPreferredSize(new Dimension(150,20));
            price.setPreferredSize(new Dimension(100,20));

            msg.setFont(new Font("Verdana", Font.PLAIN, 17));

            type.setFont(new Font("Verdana", Font.PLAIN, 15));
            cb.setFont(new Font("Verdana", Font.PLAIN, 15));

            symbol.setFont(new Font("Verdana", Font.PLAIN, 15));

            name.setFont(new Font("Verdana", Font.PLAIN, 15));

            quantity.setFont(new Font("Verdana", Font.PLAIN, 15));

            price.setFont(new Font("Verdana", Font.PLAIN, 15));
            // price.setPreferredSize(new Dimension(20,20));
            // type.setHorizontalAlignment(JLabel.LEFT);

            controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
            controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

            textPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            textPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            textPanel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            textPanel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            textPanel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));

            textPanel.add(type);
            textPanel.add(cb);
            textPanel2.add(symbol);
            textPanel2.add(symb);
            textPanel3.add(name);
            textPanel3.add(nme);
            textPanel4.add(quantity);
            textPanel4.add(qnt);
            textPanel5.add(price);
            textPanel5.add(prce);

            // textPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
            // textPanel2.setAlignmentX(Component.LEFT_ALIGNMENT);
            // textPanel3.setAlignmentX(Component.LEFT_ALIGNMENT);
            // textPanel4.setAlignmentX(Component.LEFT_ALIGNMENT);
            // textPanel5.setAlignmentX(Component.LEFT_ALIGNMENT);

            controlPanel.add(msgPanel);
            controlPanel.add(textPanel);
            controlPanel.add(textPanel2);
            controlPanel.add(textPanel3);
            controlPanel.add(textPanel4);
            controlPanel.add(textPanel5);

            containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
            JButton reset = new JButton("Reset");
            JButton buy = new JButton("Buy");

            addAButton(reset, containerPanel);
            reset.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                  symb.setText("");
                  nme.setText("");
                  qnt.setText("");
                  prce.setText("");
                  outputLabel.setText("");
               }
            });

            addAButton(buy, containerPanel);
            
            // containerPanel.setLayout(new FlowLayout());

            JPanel parent_panel = new JPanel();
            parent_panel.setLayout(new GridBagLayout());
            parent_panel.add(containerPanel, new GridBagConstraints());

            mainPanel.add(controlPanel);
            mainPanel.add(parent_panel);

            buy.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                  try{
                     String type = String.valueOf(cb.getSelectedItem()); 
                     String symbol = symb.getText(); 
                     String name = nme.getText(); 
                     int quantity = Integer.parseInt(qnt.getText()); 
                     Double price = Double.parseDouble(prce.getText()); 
                     // if(symbol.isEmpty() || name.isEmpty()){
                     //    outputLabel.setText("You must enter a value. Try Again.");
                     //    return;
                     // }
                     // if(price < 0 || quantity < 0){
                     //    outputLabel.setText("Quantity/Price cannot be negative. Try Again.");
                     //    return;
                     // }

                     int investCheck=0;
                     investCheck = sysExists(1, symbol);
                     if(type.equalsIgnoreCase("Stock")){
                        if(investCheck == -1)//new investment
                        {
                              addInvestment(new Stock(symbol, name, quantity, price));
                              // Double BVTemp = (quantity * price + 9.99);
                              // System.out.println("BookValue = " + quantity + " * " + price + " + " + 9.99 + " = " + BVTemp+"\n");
                              outputLabel.setText("New Stock has been added.\n");
                              // stocks.get().setBookValue(BVTemp);
                        } 
                        else //add to existing investment
                        {
                              if(investments.get(investCheck) instanceof MutualFund){
                                 outputLabel.setText("You entered an existing Mutual Fund's name insted of a stock. Try again.\n");
                                 // continue;
                              }
                              investments.get(investCheck).setPrice(price);
                              investments.get(investCheck).setQuantity(quantity + investments.get(investCheck).getQuantity());
                              Double BVTemp = (quantity * price + 9.99);
                              // System.out.println("BookValue = " + quantity + " * " + price + " + " + 9.99 + " = " + BVTemp+"\n");
                              investments.get(investCheck).setBookValue(BVTemp + investments.get(investCheck).getBookValue());
                              // paymentt += BVTemp + investments.get(investCheck).getBookValue(); 
                        }
                     }
                     else if(type.equalsIgnoreCase("Mutual Fund")){
                        investCheck = sysExists(2, symbol);
                        if (investCheck == -1) //new investment
                        {
                           addInvestment(new MutualFund(symbol, name, quantity, price));
                           //  System.out.println("BookValue = " + quantity + " * " + price + " + " + 45.00 + " = " + BVTemp+"\n");
                           outputLabel.setText("New Fund has been added.\n");
                           //mutualFunds.get(investCheck).setBookValue(BVTemp);
                        } 
                        else //add to existing investment
                        {
                           if(investments.get(investCheck) instanceof Stock){
                              outputLabel.setText("You entered an existing stock's name insted of a mutual fund. Try again.\n");
                           //   continue;
                           }
                           investments.get(investCheck).setPrice(price);
                           investments.get(investCheck).setQuantity(quantity + investments.get(investCheck).getQuantity());
                           //  System.out.println("BookValue = " + quantity + " * " + price + " + " + 45.00 + " = " + BVTemp+"\n");
                           investments.get(investCheck).setBookValue((investments.get(investCheck).getPrice() * investments.get(investCheck).getQuantity()) - investments.get(investCheck).redemptionFee + investments.get(investCheck).getBookValue());
                           //paymentt += (investments.get(investCheck).getPrice() * investments.get(investCheck).getQuantity()) - investments.get(investCheck).redemptionFee + investments.get(investCheck).getBookValue();
                        }
                     }
                  }catch (Exception e1) {
                     // e1.printStackTrace();
                     outputLabel.setText("Exception Thrown. Values cannot be empty or out of range.");
                  }
                  revalidate();
                  repaint();
               }
            });
         }
         else if(e.getSource() == sell){
            controlPanel.removeAll();
            mainPanel.removeAll();

            JPanel msgPanel = new JPanel();
            msgPanel.setLayout(new FlowLayout()); 
            JLabel msg = new JLabel("Selling an Investment");
            msg.setFont(new Font("Verdana", Font.PLAIN, 17));
            msgPanel.add(msg);

            JPanel containerPanel = new JPanel(new GridLayout(2, 1));

            JLabel symbol = new JLabel("Symbol");
            JTextField symb = new JTextField();
            symb.setPreferredSize(new Dimension(150,20));
            symbol.setPreferredSize(new Dimension(100,20));

            JLabel quantity = new JLabel("Quantity");
            JTextField qnt = new JTextField();
            qnt.setPreferredSize(new Dimension(150,20));
            quantity.setPreferredSize(new Dimension(100,20));

            JLabel price = new JLabel("Price");
            JTextField prce = new JTextField();
            prce.setPreferredSize(new Dimension(150,20));
            price.setPreferredSize(new Dimension(100,20));

            msg.setFont(new Font("Verdana", Font.PLAIN, 17));

            symbol.setFont(new Font("Verdana", Font.PLAIN, 15));

            quantity.setFont(new Font("Verdana", Font.PLAIN, 15));

            price.setFont(new Font("Verdana", Font.PLAIN, 15));

            // controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
            controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            symb.setHorizontalAlignment(JTextField.LEFT);
            qnt.setHorizontalAlignment(JTextField.LEFT);
            prce.setHorizontalAlignment(JTextField.LEFT);

            textPanel2.add(symbol);
            textPanel2.add(symb);
            textPanel4.add(quantity);
            textPanel4.add(qnt);
            textPanel5.add(price);
            textPanel5.add(prce);

            controlPanel.add(msgPanel);
            controlPanel.add(textPanel2);
            controlPanel.add(textPanel4);
            controlPanel.add(textPanel5);

            // textPanel2.setAlignmentX(Component.LEFT_ALIGNMENT);
            // textPanel4.setAlignmentX(Component.LEFT_ALIGNMENT);
            // textPanel5.setAlignmentX(Component.LEFT_ALIGNMENT);

            containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
            JButton reset = new JButton("Reset");
            JButton sell = new JButton("Sell");

            addAButton(reset, containerPanel);
            reset.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                   symb.setText("");
                   qnt.setText("");
                   prce.setText("");
                  outputLabel.setText("");
               }
            });
            addAButton(sell, containerPanel);
            // containerPanel.setLayout(new FlowLayout());

            JPanel parent_panel = new JPanel();
            parent_panel.setLayout(new GridBagLayout());
            parent_panel.add(containerPanel, new GridBagConstraints());

            mainPanel.add(controlPanel);
            mainPanel.add(parent_panel);

            sell.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                  try{
                     String symbol = symb.getText(); 
                     int quantity = Integer.parseInt(qnt.getText()); 
                     Double price = Double.parseDouble(prce.getText()); 
                     if(price < 0 || quantity < 0){
                        outputLabel.setText("Quantity/Price cannot be negative. Try Again.");
                        return;
                     }

                     if(!(investments.isEmpty())){
                        for(Investment s : investments){
                           if(s.getSymbol().equalsIgnoreCase(symbol)){
                              if(s.getQuantity() < quantity){
                                 outputLabel.setText("Number of shares owned is less than quantity. Error.");
                                 // System.exit(-1);
                              }
                              //fully selling
                              else if(quantity == s.getQuantity()){
                                 s.setBookValue(s.getBookValue() - (s.getPrice() * s.getQuantity()) - s.commissionFee );
                                 //paymentt += (s.getBookValue() - (s.getPrice() * s.getQuantity()) - s.commissionFee );
                                 s.setPrice(price);
                                 investments.remove(s);
                                 outputLabel.setText("Stock has been sold.\n");
                                 //System.out.println("Gain = " + (s.getPrice() * s.getQuantity() - s.commissionFee - s.getBookValue()));
                              }
                              //partially selling
                              else{
                                 Double BVsell = (s.getBookValue() * quantity / s.getQuantity());
                                 // Double payment = ((s.getPrice() * s.getQuantity()) - s.commissionFee );
                                 s.setBookValue(s.getBookValue() - BVsell);
                                 // += (s.getBookValue() - BVsell);
                                 s.setQuantity(s.getQuantity() - quantity);
                                 s.setPrice(price);
                                 outputLabel.append(s.toString());
                                 outputLabel.append("Stock/Fund has been sold.\n");
                              }
      
                              if(s.getQuantity() == 0)
                                 removeInvestment(s);
                           }
                        }
                     }
                  }catch (Exception e1) {
                     // e1.printStackTrace();
                     outputLabel.setText("Exception Thrown. Values cannot be empty or out of range.");
                  }
                  revalidate();
                  repaint();
               }
            });
         }
         else if(e.getSource() == update){
            controlPanel.removeAll();
            mainPanel.removeAll();

            JPanel msgPanel = new JPanel();
            msgPanel.setLayout(new FlowLayout()); 
            JLabel msg = new JLabel("Updating Investments");
            msg.setFont(new Font("Verdana", Font.PLAIN, 17));

            msgPanel.add(msg);

            JPanel containerPanel = new JPanel(new GridLayout(2, 1));

            JLabel symbol = new JLabel("Symbol");
            JTextField symb = new JTextField();
            symb.setBackground(Color.white);
            symb.setPreferredSize(new Dimension(150,20));
            symbol.setPreferredSize(new Dimension(100,20));
            symb.setEditable(false);

            JLabel name = new JLabel("Name");
            JTextField nme = new JTextField();
            nme.setEditable(false);
            nme.setBackground(Color.white);
            nme.setPreferredSize(new Dimension(250,20));
            name.setPreferredSize(new Dimension(100,20));

            JLabel price = new JLabel("Price");
            JTextField prce = new JTextField();
            prce.setPreferredSize(new Dimension(150,20));
            price.setPreferredSize(new Dimension(100,20));

            msg.setFont(new Font("Verdana", Font.PLAIN, 17));

            symbol.setFont(new Font("Verdana", Font.PLAIN, 15));

            name.setFont(new Font("Verdana", Font.PLAIN, 15));

            price.setFont(new Font("Verdana", Font.PLAIN, 15));

            controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            symb.setHorizontalAlignment(JTextField.LEFT);
            name.setHorizontalAlignment(JTextField.LEFT);
            prce.setHorizontalAlignment(JTextField.LEFT);

            for(int k = 0; k < investments.size()-1; k++)
            {
               if(investments.get(k).getType().equalsIgnoreCase("stock")){
                  symb.setText(investments.get(0).getSymbol());
                  nme.setText(investments.get(0).getName());

               }
               else{
                  symb.setText(investments.get(0).getSymbol());
                  nme.setText(investments.get(0).getName());
               }
            }
            
            textPanel2.add(symbol);
            textPanel2.add(symb);
            textPanel4.add(name);
            textPanel4.add(nme);
            textPanel5.add(price);
            textPanel5.add(prce);

            controlPanel.add(msgPanel);
            controlPanel.add(textPanel2);
            controlPanel.add(textPanel4);
            controlPanel.add(textPanel5);

            containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
            JButton prev = new JButton("Prev");
            JButton next = new JButton("Next");
            JButton save = new JButton("Save");

            addAButton(prev, containerPanel);
            addAButton(next, containerPanel);
            addAButton(save, containerPanel);
            // containerPanel.setLayout(new FlowLayout());

            JPanel parent_panel = new JPanel();
            parent_panel.setLayout(new GridBagLayout());
            parent_panel.add(containerPanel, new GridBagConstraints());
            // containerPanel.add(panel1);

            // containerPanel.add(panel2);
            // containerPanel.add(panel3);

            mainPanel.add(controlPanel, BorderLayout.NORTH);
            mainPanel.add(parent_panel);

            index = investments.size() - investments.size()-1;
            prev.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                  prev.setEnabled(true);
                  next.setEnabled(true);

                  index--;
                  if(index < 0){
                     outputLabel.setText("This is the first investment.");
                     prev.setEnabled(false);
                     return;
                  }
                  symb.setText(investments.get(index).getSymbol());
                  nme.setText(investments.get(index).getName());
               }
            });
            next.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                  next.setEnabled(true);
                  prev.setEnabled(true);

                  index++;
                  
                  if(index > investments.size()-1){
                     outputLabel.setText("This is the last investment.");
                     next.setEnabled(false);
                     return;

                  }
                  symb.setText(investments.get(index).getSymbol());
                  nme.setText(investments.get(index).getName());
               }
            });

            save.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                  try{
                     String symbol = symb.getText();
                     String name = nme.getText();

                     for(int k = 0; k < investments.size(); k++)
                     {
                        if(investments.get(k).getType().equalsIgnoreCase("stock")){
                           if(investments.get(k).getSymbol().equalsIgnoreCase(symbol) && investments.get(k).getSymbol().equalsIgnoreCase(name)){
                              Double updateStock = Double.parseDouble(prce.getText());
                              if(updateStock <= 0){
                                 outputLabel.setText("Price cannot be less than or equal to 0. Try Again.");
                                 return;
                              }
                              investments.get(k).setPrice(updateStock);

                              outputLabel.setText(investments.get(k).toString());
                           }
                        }
                        else{
                           if(investments.get(k).getSymbol().equalsIgnoreCase(symbol) && investments.get(k).getSymbol().equalsIgnoreCase(name)){
                              Double updateMF = Double.parseDouble(prce.getText());
                              if(updateMF <= 0){
                                 outputLabel.setText("Price cannot be less than or equal to 0. Try Again.");
                                 return;
                              }
                              investments.get(k).setPrice(updateMF);
   
                              outputLabel.setText(investments.get(k).toString());
                           }
                        }
                     }
                  } catch (Exception e1) {
                     // e1.printStackTrace();
                     outputLabel.setText("Exception Thrown. Values cannot be empty or out of range.");
                  }
               }
            });
         }
         else if(e.getSource() == gain){
            controlPanel.removeAll();
            mainPanel.removeAll();
            statusLabel.removeAll();

            gainChange = "Individual gains";
            statusLabel = new JLabel("", JLabel.CENTER);
            outputLabel = new JTextArea();
            outputLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
            outputLabel.setEditable(false);

            statusLabel.setLayout(new GridLayout(1,2));
            statusLabel.setBorder(BorderFactory.createTitledBorder("Individual gains"));
            statusLabel.setBackground(Color.white);
            statusLabel.add(outputLabel, BorderLayout.CENTER);
            JScrollPane hbar=new JScrollPane(outputLabel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
   
            statusLabel.add(hbar);

            JPanel msgPanel = new JPanel();
            msgPanel.setLayout(new FlowLayout()); 
            JLabel msg = new JLabel("Getting total gain");
            msg.setPreferredSize(new Dimension(2000,20));
            
            msg.setFont(new Font("Verdana", Font.PLAIN, 17));

            msgPanel.add(msg);

            // JPanel containerPanel = new JPanel(new GridLayout(2, 1));

            JLabel gain = new JLabel("Total Gain");
            JTextField showGain = new JTextField();
            Double gain2=0.0;
            Double commissionFee2 = 9.99;
            Double redemptionFee2 = 45.00;
            Double gainTemp=0.0;

            //stock
            for(int k = 0; k < investments.size(); k++){

               if(investments.get(k).getType().equalsIgnoreCase("stock")){
                  gain2 += ((investments.get(k).getPrice() * investments.get(k).getQuantity() - commissionFee2) - investments.get(k).getBookValue());
                  gainTemp = ((investments.get(k).getPrice() * investments.get(k).getQuantity() - commissionFee2) - investments.get(k).getBookValue());
               }
               else{
                  gain2 += ((investments.get(k).getPrice() * investments.get(k).getQuantity() - redemptionFee2) - investments.get(k).getBookValue());
                  gainTemp = ((investments.get(k).getPrice() * investments.get(k).getQuantity() - redemptionFee2) - investments.get(k).getBookValue());
               }
               double roundDbl = Math.round(gainTemp*100.0)/100.0;
               outputLabel.append("Gain for investment \"" + investments.get(k).getSymbol() + "\": "+ roundDbl + "\n");
            }

            double roundDbl = Math.round(gain2*100.0)/100.0;

            showGain.setText(String.valueOf(roundDbl));
            
            showGain.setPreferredSize(new Dimension(200,25));
            gain.setPreferredSize(new Dimension(100,20));

            gain.setFont(new Font("Verdana", Font.PLAIN, 17));
            showGain.setFont(new Font("Verdana", Font.PLAIN, 15));
            showGain.setEditable(false);
            showGain.setBackground(Color.white);
            
            controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            gain.setHorizontalAlignment(JTextField.LEFT);

            textPanel.add(gain);
            textPanel.add(showGain);

            controlPanel.add(msgPanel);
            controlPanel.add(textPanel);

            mainPanel.add(controlPanel);
         }
         else if(e.getSource() == search){
            controlPanel.removeAll();
            mainPanel.removeAll();
            statusLabel.removeAll();

            searchChange ="Search results";
            statusLabel = new JLabel("The status Label", JLabel.CENTER);
            statusLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
            outputLabel = new JTextArea();
            outputLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
            outputLabel.setEditable(false);
   
            statusLabel.setLayout(new GridLayout(1,1));
            statusLabel.setSize(300,200);
            statusLabel.setBorder(BorderFactory.createTitledBorder("Search results"));
            statusLabel.setBackground(Color.white);
            statusLabel.add(outputLabel, BorderLayout.CENTER);
            JScrollPane hbar=new JScrollPane(outputLabel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    
            statusLabel.add(hbar);

            JPanel msgPanel = new JPanel();
            msgPanel.setLayout(new FlowLayout()); 
            JLabel msg = new JLabel("Searching Investments");
            msg.setFont(new Font("Verdana", Font.PLAIN, 17));
            msgPanel.add(msg);

            JPanel containerPanel = new JPanel(new GridLayout(2, 1));

            JLabel symbol = new JLabel("Symbol");
            JTextField symb = new JTextField();
            symb.setPreferredSize(new Dimension(150,20));
            symbol.setPreferredSize(new Dimension(150,20));

            JLabel nameKey = new JLabel("Name Keywords");
            JTextField nameKey2 = new JTextField();
            nameKey2.setPreferredSize(new Dimension(225,20));
            nameKey.setPreferredSize(new Dimension(150,20));

            JLabel price = new JLabel("Low Price");
            JTextField prce = new JTextField();
            prce.setPreferredSize(new Dimension(150,20));
            price.setPreferredSize(new Dimension(150,20));

            JLabel price2 = new JLabel("High Price");
            JTextField prce2 = new JTextField();
            prce2.setPreferredSize(new Dimension(150,20));
            price2.setPreferredSize(new Dimension(150,20));

            msg.setFont(new Font("Verdana", Font.PLAIN, 17));

            symbol.setFont(new Font("Verdana", Font.PLAIN, 15));

            nameKey.setFont(new Font("Verdana", Font.PLAIN, 15));

            price.setFont(new Font("Verdana", Font.PLAIN, 15));

            price2.setFont(new Font("Verdana", Font.PLAIN, 15));

            // controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
            controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            symb.setHorizontalAlignment(JTextField.LEFT);
            nameKey2.setHorizontalAlignment(JTextField.LEFT);
            prce.setHorizontalAlignment(JTextField.LEFT);
            prce2.setHorizontalAlignment(JTextField.LEFT);

            textPanel.add(symbol);
            textPanel.add(symb);
            textPanel2.add(nameKey);
            textPanel2.add(nameKey2);
            textPanel3.add(price);
            textPanel3.add(prce);
            textPanel4.add(price2);
            textPanel4.add(prce2);

            controlPanel.add(msgPanel);
            controlPanel.add(textPanel);
            controlPanel.add(textPanel2);
            controlPanel.add(textPanel3);
            controlPanel.add(textPanel4);

            // textPanel2.setAlignmentX(Component.LEFT_ALIGNMENT);
            // textPanel4.setAlignmentX(Component.LEFT_ALIGNMENT);
            // textPanel5.setAlignmentX(Component.LEFT_ALIGNMENT);

            containerPanel.setLayout(new BoxLayout(containerPanel, BoxLayout.Y_AXIS));
            JButton reset = new JButton("Reset");
            JButton search = new JButton("Search");

            addAButton(reset, containerPanel);
            reset.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                  symb.setText("");
                  nameKey2.setText("");
                  prce.setText("");
                  prce2.setText("");
                  outputLabel.setText("");
               }
            });
            
            addAButton(search, containerPanel);

            // containerPanel.setLayout(new FlowLayout());

            JPanel parent_panel = new JPanel();
            parent_panel.setLayout(new GridBagLayout());
            parent_panel.add(containerPanel, new GridBagConstraints());

            mainPanel.add(controlPanel);
            mainPanel.add(parent_panel);
            search.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                  try{
                     outputLabel.removeAll();
                     String symbol = symb.getText();
                     String nameKeywords = nameKey2.getText();
                     String priceLow = prce.getText();
                     String priceHigh = prce2.getText();
                     // if(priceLow.isEmpty() || priceHigh.isEmpty() || symbol.isEmpty() || nameKeywords.isEmpty()){
                     //    outputLabel.setText("You must enter a value. Try Again.");
                     //    return;
                     // }
                     // if(symbol.isEmpty() || nameKeywords.isEmpty() || Double.parseDouble(priceLow) < 0 || Double.parseDouble(priceHigh) < 0 || Double.parseDouble(priceLow) <= Double.parseDouble(priceHigh) ){
                     //    outputLabel.setText("You must enter a value. Try Again.");
                     //    return;
                     // }
                     // if(Double.parseDouble(priceLow) < 0 || Double.parseDouble(priceHigh) < 0 || Double.parseDouble(priceLow) <= Double.parseDouble(priceHigh)){
                     //    outputLabel.setText("You entered an invalid input or an input out of range. Try Again.");
                     //    return;
                     // }  
                     search(symbol, nameKeywords, priceLow, priceHigh);
                  } catch (Exception e1) {
                     outputLabel.setText("Exception Thrown. Values cannot be empty or out of range.");
                  }
               }
            });
         }
         else if(e.getSource() == exit){
            // String filename = main();
            try {
               PrintWriter fileWriter= new PrintWriter(filename, "UTF-8");

               for(int i =0; i<investments.size();i++){
                  if(investments.get(i) instanceof Stock){
                     fileWriter.println(investments.get(i).toString());
                  }
                  else{
                     fileWriter.println(investments.get(i).toString());
                  }
               }
               fileWriter.close();
            } catch (Exception e2) {
                  System.out.println("Failed to write.");
            }
            System.exit(-1);
         }
         
         if(!(searchChange.equals("Search results") || gainChange.equals("Individual gains"))){
            statusLabel = new JLabel("The status Label", JLabel.CENTER);
            statusLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
            outputLabel = new JTextArea();
            outputLabel.setFont(new Font("Verdana", Font.PLAIN, 15));
            outputLabel.setEditable(false);

            statusLabel.setLayout(new GridLayout(1,1));
            statusLabel.setSize(300,200);
            statusLabel.setBorder(BorderFactory.createTitledBorder("Messages"));
            
            statusLabel.setBackground(Color.white);
            statusLabel.add(outputLabel, BorderLayout.CENTER);
            JScrollPane hbar=new JScrollPane(outputLabel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
   
            statusLabel.add(hbar);
         }
         add(mainPanel);
         add(statusLabel);
         revalidate();
         repaint();
      }
   }

   private void prepareGUI() {
      setTitle("Portfolio");
      setResizable(false);
      setSize(800, 600);
      setLayout(new GridLayout(2,0));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      // JFrame frame = new JFrame();
      headerLabel = new JLabel("<html>Welcome to ePortfolio. <br/><br/><br/>Choose a command from the \"Commands\" menu to buy or sell an investment, update prices for all investments, get gain for the portfolio, search for relevant investments, or quit the program.<html>", JLabel.CENTER);
      headerLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
      headerLabel.setBackground(Color.GRAY);
      headerLabel.setHorizontalAlignment(JLabel.CENTER);

      mainPanel = new JPanel(new GridLayout(1,2));
      // mainPanel.setLayout(new FlowLayout()); 

      controlPanel = new JPanel(new GridLayout(5,1));
      // controlPanel.setLayout(new FlowLayout()); 

      // Flowlayout simply lays out components in a single row
      add(headerLabel);

      addWindowListener( new WindowAdapter()
      {
         public void windowClosing(WindowEvent e)
         {
            
            try {
               PrintWriter fileWriter= new PrintWriter(filename, "UTF-8");

               for(int i =0; i<investments.size();i++){
                  if(investments.get(i) instanceof Stock){
                     fileWriter.println(investments.get(i).toString());
                  }
                  else{
                     fileWriter.println(investments.get(i).toString());
                  }
               }
               fileWriter.close();
            } catch (Exception e2) {
                  System.out.println("Failed to write.");
            }

            // int result = JOptionPane.showConfirmDialog(
            //       frame,
            //       "Are you sure you want to exit the application?",
            //       "Exit Application",
            //       JOptionPane.YES_NO_OPTION);
      
            // if (result == JOptionPane.YES_OPTION)
            //       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         }
      });
   }

   private void showBorderLayout() {
      MyListener s = new MyListener();

      JPanel panel = new JPanel();
      panel.setSize(1000, 1000);
      
      // cb.setVisible(true);
      // panel.add(cb);

      //Create the menu bar.
      menuBar = new JMenuBar();

      //Build the first menu.
      menu = new JMenu("Commands");
      menu.setFont(new Font("Verdana", Font.PLAIN, 13));
      menu.setMnemonic(KeyEvent.VK_A);
      menu.getAccessibleContext().setAccessibleDescription(
            "The only menu in this program that has menu items");
      menuBar.add(menu);

      buy = new JMenuItem("Buy");
      buy.setFont(new Font("Verdana", Font.PLAIN, 13));

      buy.addActionListener(s);

      sell = new JMenuItem("Sell");
      sell.setFont(new Font("Verdana", Font.PLAIN, 13));
      sell.addActionListener(s);

      update = new JMenuItem("Update");
      update.setFont(new Font("Verdana", Font.PLAIN, 13));
      update.addActionListener(s);

      gain = new JMenuItem("Gain");
      gain.setFont(new Font("Verdana", Font.PLAIN, 13));
      gain.addActionListener(s);

      search = new JMenuItem("Search");
      search.setFont(new Font("Verdana", Font.PLAIN, 13));
      search.addActionListener(s);

      exit = new JMenuItem("Quit");
      exit.setFont(new Font("Verdana", Font.PLAIN, 13));
      exit.addActionListener(s);

      menu.add(buy);
      menu.add(sell);
      menu.add(update);
      menu.add(gain);
      menu.add(search);
      menu.add(exit);

      //Creating an instance of the action perfomed when button is clicked
      //Adding action to the button

      // controlPanel.add(panel);
      setJMenuBar(menuBar);
   }
   private static void addAButton(JButton button, Container container) {
      // JButton button = new JButton(text);
      button.setFont(new Font("Verdana", Font.PLAIN, 15));
      button.setAlignmentX(Component.CENTER_ALIGNMENT);
      // container box;
      // container.add(Box.createRigidArea(new Dimension(5, 0)));
      // container.add(Box.createHorizontalGlue());
      Dimension minSize = new Dimension(5, 30);
      Dimension prefSize = new Dimension(5, 30);
      Dimension maxSize = new Dimension(Short.MAX_VALUE, 100);
      container.add(new Box.Filler(minSize, prefSize, maxSize));

      container.add(button);
   }
   /**
   *
   * main
   * Discription: main
   * @param args  String [] args
   */
   public static void main(String[] args)
   {
      String[] array = {};
      filename = "a";

      if (Arrays.equals(args, array)) {
          System.out.println("No filename supplied");
      } else {
          filename = args[0];
      }
      
      if(!(filename.isBlank())){
          File f = new File(filename);
          String []split;
          String type, name, symbol;
          int quantity;
          double price, bookValue;
          try{
              Scanner scanner = new Scanner(f);
              while (scanner.hasNextLine()){
                  String temp = scanner.nextLine();
                  if(temp.isEmpty()){
                      continue;
                  }
                  //System.out.println(scanner.nextLine());
                  split = temp.split("\"");
                  //split = scanner.nextLine().split("\"");
                  type=split[1];

                  split = scanner.nextLine().split("\"");
                  symbol=split[1];

                  split = scanner.nextLine().split("\"");
                  name=split[1];

                  split = scanner.nextLine().split("\"");
                  quantity=Integer.parseInt(split[1]);

                  split = scanner.nextLine().split("\"");
                  price=Double.parseDouble(split[1]);
                  double roundDbl = Math.round(price*100.0)/100.0;

                  split = scanner.nextLine().split("\"");
                  bookValue=Double.parseDouble(split[1]);

                  if(type.equalsIgnoreCase("stock")){
                      Investment newInvStck = new Stock(symbol, name, quantity, roundDbl);
                      newInvStck.setBookValue(bookValue);
                      addInvestment(newInvStck);
                  } 
                  else {
                      Investment newInvMF = new MutualFund(symbol, name, quantity, roundDbl);
                      newInvMF.setBookValue(bookValue);
                      addInvestment(newInvMF);
                  }
              }
              scanner.close();
          } catch (Exception e) {
              System.out.println("Could not open file.\n");
          }
      }
      gui GUI = new gui();
      GUI.setVisible(true);
      
   }
   /**
   *
   * addInvestment
   * Discription: adds investments
   * @param inv  investment inv
   */
   public static void addInvestment(Investment inv){
      investments.add(inv);
      computeKeywords(inv);
   }
   /**
   *
   * computeKeywords
   * Discription: This function computes the keywords in name investments 
   * @param inv  investment inv
   */
   public static void computeKeywords(Investment inv){
   String[] keywrds = inv.getName().split(" ");
      for(String key : keywrds){
         Integer[] mapValue = keywordsMap.get(key);

         if(mapValue == null){//there is no key yet
            keywordsMap.put(key.toLowerCase(), new Integer[] {investments.size()-1});
         }else{
            Integer newArr[] = new Integer[mapValue.length + 1];
            
            for(int i = 0; i < mapValue.length;i++){
               newArr[i] = mapValue[i];
            }

            newArr[newArr.length - 1] = investments.size()-1;
            keywordsMap.put(key.toLowerCase(),newArr);
         }
      }
   }
   /** 
   * 
   * sysExists
   * Discription: This function checks if an investment exists
   * @param investment  int investment
   * @param symbol  String symbol
   * @return Integer: -1
   */
   public static int sysExists(int investment, String symbol)
   {
      if (investment == 1){
            for(int i = 0; i < investments.size(); i++){
               if (investments.get(i).getSymbol().equalsIgnoreCase(symbol))
                  return i;
            }
      }
      else if(investment == 2){
            for(int i = 0; i < investments.size(); i++){
               if (investments.get(i).getSymbol().equalsIgnoreCase(symbol))
                  return i;
            }
      }
      return -1;
   }
   /** 
   *
   * removeInvestment
   * Discription: This function removes investments when sold at full quantity
   * @param inv  investment inv
   */
   public static void removeInvestment(Investment inv){
      investments.remove(inv);

      keywordsMap = new HashMap<String,Integer[]>();

      for(Investment i : investments){
            computeKeywords(i);
      }
   }
   /** 
   *
   * findInterstection
   * Discription: This function finds the intersection in hash map using hash set
   * @param array1  Integer[] array1
   * @param array2  Integer[] array2
   * @return array 
   */
   public static Integer[] findInterstection(Integer[] array1, Integer[] array2){
      Set<Integer> s1 = new HashSet<Integer>(Arrays.asList(array1));
      Set<Integer> s2 = new HashSet<Integer>(Arrays.asList(array2));
      s1.retainAll(s2);
      
      return s1.toArray(new Integer[s1.size()]);
   }
   /** 
   *
   * search
   * Discription: This function searches for investments depending on user input
   * @param symbol  String symbol
   * @param name  String name
   * @param priceLow  String priceLow
   * @param priceHigh  String price
   */
   public static void search(String symbol, String name, String priceLow, String priceHigh){
      double lowest=0, highest=0;
      if(!(priceLow.isEmpty())){
         lowest = Double.parseDouble(priceLow);
      }
      if(!priceHigh.isEmpty()){
         highest = Double.parseDouble(priceHigh);
      }
      String [] keyWords = name.toLowerCase().split(" ");
      Integer[] invs = null;
      
      if(keyWords.length > 0){

            boolean keyFound = true;
      
            for(String s : keyWords){
               Integer[] mapValue = keywordsMap.get(s);
      
               if(mapValue == null){
                  keyFound = false;
                  break;
               }
      
               invs = invs == null ? mapValue : findInterstection(mapValue,invs);
            }
      }

      for(int i = 0; i < (invs == null ? investments.size() : invs.length); i++){

            Investment s = invs == null ? investments.get(i) : investments.get(invs[i]);

            if(symbol.isBlank() == false && symbol.equals(s.getSymbol()) == false)
               continue;
            

            if(symbol.isBlank() == false && (s.getPrice() < lowest || s.getPrice() > highest))
               continue;
      
            outputLabel.setText(s.toString());
      }
   }
}
