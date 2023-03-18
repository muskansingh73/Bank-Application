package bank.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Transactions extends JFrame implements ActionListener{
    JButton deposit, withdrawl, fastcash, ministatement, pinchange, balanceenquiry, exit;
    String pinnumber;
    Transactions(String pinnumber){
       this.pinnumber= pinnumber;
       setLayout(null);
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Project Pictures/Img BA/atm.jpg"));
       Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(0,0,900,900);
       
       add(image);
       JLabel text = new JLabel("PLEASE SELECT YOUR TRANSACTION");
       text.setFont(new Font("Arial",Font.BOLD,18));
       text.setBounds(160,300,800,35);
       text.setForeground(Color.WHITE);
       image.add(text);
       
       deposit = new JButton("Deposit");
       deposit.setBounds(170,415,150,30);
       deposit.setFont(new Font("Arial",Font.BOLD,15));
       deposit.setForeground(Color.BLACK);
       deposit.addActionListener(this);
       image.add(deposit);
       
       withdrawl = new JButton("Cash Withdrawl");
       withdrawl.setBounds(355,415,150,30);
       withdrawl.setFont(new Font("Arial",Font.BOLD,15));
       withdrawl.setForeground(Color.BLACK);
       withdrawl.addActionListener(this);
       image.add(withdrawl);
       
       fastcash = new JButton("Fast Cash");
       fastcash.setBounds(170,450,150,30);
       fastcash.setFont(new Font("Arial",Font.BOLD,15));
       fastcash.setForeground(Color.BLACK);
       fastcash.addActionListener(this);
       image.add(fastcash);
       
       ministatement = new JButton("Mini Statement");
       ministatement.setBounds(355,450,150,30);
       ministatement.setFont(new Font("Arial",Font.BOLD,15));
       ministatement.setForeground(Color.BLACK);
       ministatement.addActionListener(this);
       image.add(ministatement);
       
       pinchange = new JButton("Pin Change");
       pinchange.setBounds(170,485,150,30);
       pinchange.setFont(new Font("Arial",Font.BOLD,15));
       pinchange.setForeground(Color.BLACK);
       pinchange.addActionListener(this);
       image.add(pinchange);
       
       balanceenquiry = new JButton("Balance Enquiry");
       balanceenquiry.setBounds(355,485,150,30);
       balanceenquiry.setFont(new Font("Arial",Font.BOLD,13));
       balanceenquiry.setForeground(Color.BLACK);
       balanceenquiry.addActionListener(this);
       image.add(balanceenquiry);
       
       exit = new JButton("Exit");
       exit.setBounds(355,520,150,30);
       exit.setFont(new Font("Arial",Font.BOLD,15));
       exit.setForeground(Color.BLACK);
       exit.addActionListener(this);
       image.add(exit);

//       getContentPane().setBackground(Color.BLACK);
       setSize(900,900);
       setLocation(350,10);
       setUndecorated(true);
       setVisible(true);
      }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        }else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource()==balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()==ministatement){
           
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new Transactions("");
    }
}
