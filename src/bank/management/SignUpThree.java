package bank.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignUpThree extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit, cancel;
    String formno;
    SignUpThree(String formno){
        this.formno = formno;
        setLayout(null);
        setTitle("ACCOUNT DETAILS");
        JLabel l1 = new JLabel("PAGE 3: ACCOUNT DETAILS");
        l1.setFont(new Font("Arial",Font.BOLD,32));
        l1.setBounds(200,50,650,30);
        add(l1);
        
        JLabel type = new JLabel("ACCOUNT TYPE:");
        type.setFont(new Font("Arial", Font.BOLD,22));
        type.setBounds(100,150,200,40);
        add(type);
        
        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Arial",Font.BOLD,18));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,190,200,40);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Arial",Font.BOLD,18));
        r2.setBackground(Color.WHITE);
        r2.setBounds(400,190,280,40);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Arial",Font.BOLD,18));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,230,280,40);
        add(r3);
        
        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Arial",Font.BOLD,18));
        r4.setBackground(Color.WHITE);
        r4.setBounds(400,230,350,40);
        add(r4);
        
        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(r1);
        typeGroup.add(r2);
        typeGroup.add(r3);
        typeGroup.add(r4);
        
        JLabel card = new JLabel("CARD NUMBER:");
        card.setFont(new Font("Arial",Font.BOLD,22));
        card.setBounds(100,280,200,40);
        add(card);
        JLabel carddetail = new JLabel("Your 16 Digit Card Number");
        carddetail.setFont(new Font("Arial",Font.PLAIN,15));
        carddetail.setBounds(100,300,400,40);
        add(carddetail);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Arial",Font.BOLD,18));
        number.setBounds(380,280,280,40);
        add(number);
        
        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Arial",Font.BOLD,22));
        pin.setBounds(100,350,200,40);
        add(pin);
        JLabel pindetail = new JLabel("Your 4 Digit Password");
        pindetail.setFont(new Font("Arial",Font.PLAIN,15));
        pindetail.setBounds(100,370,280,40);
        add(pindetail);
        
        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Arial",Font.BOLD,18));
        pnumber.setBounds(380,350,200,40);
        add(pnumber);
        
        JLabel service = new JLabel("SERVICE REQUIRED:");
        service.setFont(new Font("Arial",Font.BOLD,22));
        service.setBounds(100,420,280,40);
        add(service);
        
        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Arial",Font.BOLD,18));
        c1.setBounds(100,450,280,40);
        c1.setBackground(Color.WHITE);
        add(c1);
        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Arial",Font.BOLD,18));
        c2.setBounds(400,450,280,40);
        c2.setBackground(Color.WHITE);
        add(c2);
        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Arial",Font.BOLD,18));
        c3.setBounds(100,480,280,40);
        c3.setBackground(Color.WHITE);
        add(c3);
        c4 = new JCheckBox("Email and SMS Alerts");
        c4.setFont(new Font("Arial",Font.BOLD,18));
        c4.setBounds(400,480,280,40);
        c4.setBackground(Color.WHITE);
        add(c4);
        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Arial",Font.BOLD,18));
        c5.setBounds(100,510,280,40);
        c5.setBackground(Color.WHITE);
        add(c5);
        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Arial",Font.BOLD,18));
        c6.setBounds(400,510,280,40);
        c6.setBackground(Color.WHITE);
        add(c6);
        
        c7 = new JCheckBox("I HEREBY DECLARES THAT THE ABOVE ENTERED DETAILS ARE CORRECT TO THE BEST OF MY KNOWLEDGE");
        c7.setFont(new Font("Arial",Font.BOLD,13));
        c7.setBounds(20,600,800,40);
        c7.setBackground(Color.WHITE);
        add(c7);
        
        submit = new JButton("SUBMIT");
        submit.setFont(new Font("Arial",Font.BOLD,20));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(100,680,200,40);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("CANCEL");
        cancel.setFont(new Font("Arial",Font.BOLD,20));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(450,680,200,40);
        cancel.addActionListener(this);
        add(cancel);  
      
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accountType = null;
            if(r1.isSelected()){
                accountType="Saving Account";
            }else if(r2.isSelected()){
                accountType = "Fixed Deposit Account";
            }else if(r3.isSelected()){
                accountType= "Current Account";
            }else if(r4.isSelected()){
                accountType= "Recurring Deposit Account";
            }
            Random random = new Random();
            String cardnumber = "" +Math.abs((random.nextLong()%90000000L) + 5040936000000000L);
            String pinnumber = "" +Math.abs((random.nextLong()%9000L)+ 1000L); 
            String facility = "";
            if(c1.isSelected()){
                facility=facility + "ATM Card";
            }else if(c2.isSelected()){
                facility=facility + "Internet Banking";
            }else if(c3.isSelected()){
                facility =facility+"Mobile Banking";
            }else if(c4.isSelected()){
                facility =facility+ "Email and SMS Alert";
            }else if(c5.isSelected()){
                facility=facility+ "Cheque Book";
            }
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is required");
                }else if(c7.equals("")){
                    JOptionPane.showMessageDialog(null, "Declare the Instruction");    
                }
                else {
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"', '"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"')";
                     String query2 = "insert into login values('"+formno+"', '"+cardnumber+"', '"+pinnumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Card Number:" +cardnumber +"\n Pin:" +pinnumber);
                    
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }
            }catch(Exception e){
                System.out.println(e);
            }            

        }else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    public static void main(String args[]){
        new SignUpThree("");
    }
}
