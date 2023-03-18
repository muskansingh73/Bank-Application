package bank.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;

class changeTextField extends PlainDocument{
    private int limit;
    changeTextField(int limit){
        super();
        this.limit=limit;
    }
    changeTextField(int limit, boolean upper){
        super();
        this.limit=limit;
    }
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException{
        if(str==null)
            return;
        if((getLength()+str.length())<=limit){
            super.insertString(offset,str,attr);
        }
        
    }
    
}
public class PinChange extends JFrame implements ActionListener{
    JPasswordField pin, repin;
    JButton change, back;
    String pinnumber;
    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Project Pictures/Img BA/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.WHITE);
        text.setBounds(220,290,400,20);
        text.setFont(new Font("System",Font.BOLD,20));
        image.add(text);
        
        JLabel pintext = new JLabel("NEW PIN");
        pintext.setForeground(Color.WHITE);
        pintext.setBounds(165,320,180,35);
        pintext.setFont(new Font("System",Font.BOLD,18));
        image.add(pintext);
        
        pin = new JPasswordField(15);
        pin.setDocument(new changeTextField(4));
        pin.setFont(new Font("Raleway",Font.BOLD,18));
        pin.setBounds(330,320,180,35);
        image.add(pin);
        
        JLabel repintext = new JLabel("Re-Enter New PIN");
        repintext.setForeground(Color.WHITE);
        repintext.setBounds(165,360,180,35);
        repintext.setFont(new Font("System",Font.BOLD,18));
        image.add(repintext);
        
        repin = new JPasswordField(15);
        repin.setDocument(new changeTextField(4));
        repin.setFont(new Font("Raleway",Font.BOLD,18));
        repin.setBounds(330,360,180,35);
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(350,10);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
            try{
                String npin = pin.getText();
                String rpin = repin.getText();
                
                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                
                 if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter new PIN");
                    return;
                }
                 
                 if(rpin.equals("")){
                     JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                     return;
                 }
                 
                 Conn conn = new Conn();
                 String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                 String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                 String query3 = "update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
                 
                 conn.s.executeUpdate(query1);
                 conn.s.executeUpdate(query2);
                 conn.s.executeUpdate(query3);
                 
                 JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
                 
                 setVisible(false);
                 new Transactions(rpin).setVisible(true);
                 
                
            }catch(Exception e){
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new PinChange("").setVisible(true);
    }
}
