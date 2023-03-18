
package bank.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener{
    JButton hundred, fivehundred, thousand, twothousand, fivethousand, tenthousand, exit;
    String pinnumber;
    FastCash(String pinnumber){
       this.pinnumber= pinnumber;
       setLayout(null);
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Project Pictures/Img BA/atm.jpg"));
       Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel image = new JLabel(i3);
       image.setBounds(0,0,900,900);
       
       add(image);
       JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
       text.setFont(new Font("Arial",Font.BOLD,18));
       text.setBounds(160,300,800,35);
       text.setForeground(Color.WHITE);
       image.add(text);
       
       hundred = new JButton("Rs 100");
       hundred.setBounds(170,415,150,30);
       hundred.setFont(new Font("Arial",Font.BOLD,15));
       hundred.setForeground(Color.BLACK);
       hundred.addActionListener(this);
       image.add(hundred);
       
       fivehundred = new JButton("Rs 500");
       fivehundred.setBounds(355,415,150,30);
       fivehundred.setFont(new Font("Arial",Font.BOLD,15));
       fivehundred.setForeground(Color.BLACK);
       fivehundred.addActionListener(this);
       image.add(fivehundred);
       
       thousand = new JButton("Rs 1000");
       thousand.setBounds(170,450,150,30);
       thousand.setFont(new Font("Arial",Font.BOLD,15));
       thousand.setForeground(Color.BLACK);
       thousand.addActionListener(this);
       image.add(thousand);
       
       twothousand = new JButton("Rs 2000");
       twothousand.setBounds(355,450,150,30);
       twothousand.setFont(new Font("Arial",Font.BOLD,15));
       twothousand.setForeground(Color.BLACK);
       twothousand.addActionListener(this);
       image.add(twothousand);
       
       fivethousand = new JButton("Rs 5000");
       fivethousand.setBounds(170,485,150,30);
       fivethousand.setFont(new Font("Arial",Font.BOLD,15));
       fivethousand.setForeground(Color.BLACK);
       fivethousand.addActionListener(this);
       image.add(fivethousand);
       
       tenthousand = new JButton("Rs 10000");
       tenthousand.setBounds(355,485,150,30);
       tenthousand.setFont(new Font("Arial",Font.BOLD,13));
       tenthousand.setForeground(Color.BLACK);
       tenthousand.addActionListener(this);
       image.add(tenthousand);
       
       exit = new JButton("BACK");
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
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance =0;
                while(rs.next()){ //rs.next() is used to loop the rows
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"' , '"+date+"' , 'Withdrawl' , '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " +amount+ " Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    public static void main(String args[]){
        new FastCash("");
    }
}
