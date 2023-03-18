
package bank.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {//JFrame is the class of swing framework
    JButton login,clear,signup; //FOR GLOBALLY DECLARATION OF BUTTON
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setLayout(null);
        setTitle("Bank application");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Project Pictures/Img BA/Logo.png"));
        Image i2 = i1.getImage().getScaledInstance(150,150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Label = new JLabel(i3);
        Label.setBounds(20, 10, 150, 150);
        add(Label);
        JLabel text = new JLabel("WELCOME TO SKY BANK");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200,40,800,40);
        add(text);
        
        JLabel cardno = new JLabel("Card no.:");
        cardno.setFont(new Font("Arial", Font.BOLD,28));
        cardno.setBounds(120,180,200,40);
        add(cardno);
        cardTextField = new JTextField();
        cardTextField.setBounds(320,180,250,40);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 22));
        add(cardTextField);
        
        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("Arial", Font.BOLD,28));
        pin.setBounds(120,250,200,40);
        add(pin);
        pinTextField = new JPasswordField();
        pinTextField.setBounds(320,250,250,40);
        pinTextField.setFont(new Font("Arial",Font.BOLD,22));
        add(pinTextField);
        //FOR BUTTONS
        login = new JButton("SIGN IN");
        login.setBounds(250,320,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        clear = new JButton("CLEAR");
        clear.setBounds(450,320,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        signup = new JButton("SIGN UP");
        signup.setBounds(250,380,300,40);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
           

      
        getContentPane().setBackground(Color.pink);
        setSize(800,480);//Use to define the size i.e the lenghth and breadth of the desktop application
        setVisible(true);//TO define visibility 
        setLocation(350,200);
    }
    public void actionPerformed(ActionEvent ae){//OVERRIDEN METHOD FOR INTERFACE
        if(ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
            
        }
        else if(ae.getSource()==login){
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber =pinTextField.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            try{
                ResultSet rs =conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
        }
        else if(ae.getSource()==signup){
            setVisible(false);
            new SignupOne().setVisible(true);
            
        }
    }
    public static void main(String args[]){
        Login l =new Login();
        
    }
    
}
