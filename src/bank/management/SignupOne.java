package bank.management;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.util.regex.Pattern;
//import java.util.regex.Matcher;
public class SignupOne extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField,fnameTextField,emailTextField,addressTextField,countryTextField,cityTextField,stateTextField,pincodeTextField;
    JButton next;
    JRadioButton male,female,other,married,unmarried,others;
    JDateChooser DateChooser;
    
    
    
    SignupOne(){
        setLayout(null);
        setTitle("New Account application-PAGE 1");
        Random rn = new Random();
        random=Math.abs(rn.nextLong() % 9000L) + 1000L;
        JLabel formno = new JLabel("APPLICATION NO.:"+ random);
        formno.setFont(new Font("Arial",Font.BOLD,38));
        formno.setBounds(200,40,800,40);
        add(formno);
        
        JLabel personal= new JLabel("PAGE 1: PERSONAL DETAILS");
        personal.setFont(new Font("Arial",Font.PLAIN,22));
        personal.setBounds(200,100,450,30);
        add(personal);
        
        JLabel name = new JLabel("NAME :");
        name.setFont(new Font("Arial",Font.BOLD,20));
        name.setBounds(100,150,100,40);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Arial",Font.BOLD,18));
        nameTextField.setBounds(280,150,500,40);
        add(nameTextField);
                
              
        JLabel fname = new JLabel("FATHERS NAME:");
        fname.setFont(new Font("Arial",Font.BOLD,20));
        fname.setBounds(100,200,200,40);
        add(fname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Arial",Font.BOLD,18));
        fnameTextField.setBounds(280,200,500,40);
        add(fnameTextField);
        
        JLabel dob = new JLabel("DATE OF BIRTH:");
        dob.setFont(new Font("Arial",Font.BOLD,20));
        dob.setBounds(100,250,250,40);
        add(dob);
        
        DateChooser = new JDateChooser();
        DateChooser.setBounds(280,250,500,40);
        DateChooser.setFont(new Font("Arial",Font.BOLD,20));
        add(DateChooser);
        
        JLabel gender = new JLabel("GENDER:");
        gender.setFont(new Font("Arial",Font.BOLD,20));
        gender.setBounds(100,300,100,40);
        add(gender);
        
        male = new JRadioButton("MALE");
        male.setBounds(280,300,100,40);
        male.setBackground(Color.WHITE);
        add(male);
        
        female = new JRadioButton("FEMALE");
        female.setBounds(450,300,100,40);
        female.setBackground(Color.WHITE);
        add(female);
        
        other = new JRadioButton("OTHERS");
        other.setBounds(630,300,120,40);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(other);
        
        
       
        JLabel email = new JLabel("EMAIL ID:");
        email.setFont(new Font("Arial",Font.BOLD,20));
        email.setBounds(100,350,280,40);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Arial",Font.BOLD,20));
        emailTextField.setBounds(280,350,500,40);
        add(emailTextField);
        
        JLabel marital = new JLabel("MARITAL STATUS:");
        marital.setFont(new Font("Arial",Font.BOLD,20));
        marital.setBounds(70,400,280,40);
        add(marital);
        
        married = new JRadioButton("MARRIED");
        married.setBounds(300,400,100,40);
        married.setBackground(Color.WHITE);
        add(married);
        unmarried = new JRadioButton("UNMARRIED");
        unmarried.setBounds(450,400,100,40);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);
        others = new JRadioButton("OTHERS");
        others.setBounds(630,400,100,40);
        others.setBackground(Color.WHITE);
        add(others);
        
        ButtonGroup maritalgroup = new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(unmarried);
        maritalgroup.add(others);
       
                
        
        JLabel address = new JLabel("ADDRESS:");
        address.setFont(new Font("Arial",Font.BOLD,20));
        address.setBounds(100,450,200,40);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Arial",Font.BOLD,20));
        addressTextField.setBounds(280,450,500,40);
        add(addressTextField);
        
        JLabel city = new JLabel("CITY:");
        city.setFont(new Font("Arial",Font.BOLD,20));
        city.setBounds(100,500,200,40);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Arial",Font.BOLD,20));
        cityTextField.setBounds(280,500,500,40);
        add(cityTextField);
        
        JLabel state = new JLabel("STATE");
        state.setFont(new Font("Arial",Font.BOLD,20));
        state.setBounds(100,550,200,40);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("ARial",Font.BOLD,20));
        stateTextField.setBounds(280,550,500,40);
        add(stateTextField);
        
        JLabel country = new JLabel("COUNTRY:");
        country.setFont(new Font("Arial",Font.BOLD,20));
        country.setBounds(100,600,200,40);
        add(country);
        
        countryTextField = new JTextField();
        countryTextField.setFont(new Font("Arial",Font.BOLD,20));
        countryTextField.setBounds(280,600,500,40);
        add(countryTextField);
        
        
        JLabel pincode = new JLabel("PIN CODE:");
        pincode.setFont(new Font("Arial",Font.BOLD,20));
        pincode.setBounds(100,650,250,40);
        add(pincode);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Arial",Font.BOLD,20));
        pincodeTextField.setBounds(280,650,500,40);
        add(pincodeTextField);
        
        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Arial",Font.BOLD,20));
        next.setBounds(650,700,120,40);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);    
    }
    public void actionPerformed(ActionEvent ae){
//        
//         if(!(Pattern.matches("^[a-zA-z0-9]+[@]{1}+[a-zA-z0-9]+[.]{1}+[a-zA-z0-9]+$",emailTextField.getText()))){
//            JOptionPane.showMessageDialog(null,"Please enter a valid email id", "Error", JOptionPane.ERROR_MESSAGE);
//        }
       
        String formno = ""  + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField)DateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender="male";
        }else if(female.isSelected()){
            gender="female";
        }else if(other.isSelected()){
            gender="other";
        }
        String email=emailTextField.getText();
        String marital = null;
        if(married.isSelected()){
            marital="married";
        }else if(unmarried.isSelected()){
            marital="unmarried";   
        }else if(others.isSelected()){
            marital="others";
        }
        String address =addressTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String country=countryTextField.getText();
        String pincode=pincodeTextField.getText();
//        if(!(pincode.matches("^[0-9]*$")&&pincode.length()==7)){
//            JOptionPane.showMessageDialog(null,"Please enter a valid pin number", "Error", JOptionPane.ERROR_MESSAGE);
//        }
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"ENTER THE NAME");
            }else if(fname.equals("")){
                JOptionPane.showMessageDialog(null,"ENTER THE FATHERS NAME");
            }else if(dob.equals("")){
                JOptionPane.showMessageDialog(null,"ENTER YOUR DATE OF BIRTH");
            }else if(email.equals("")){
                JOptionPane.showMessageDialog(null,"PLEASE ENTER YOUR EMAIL");
            } else if(!(Pattern.matches("^[a-zA-z0-9]+[@]{1}+[a-zA-z0-9]+[.]{1}+[a-zA-z0-9]+$",emailTextField.getText()))){
                JOptionPane.showMessageDialog(null,"Please enter a valid email id", "Error", JOptionPane.ERROR_MESSAGE);
            } else if(!(pincode.matches("^[0-9]*$")&&pincode.length()==6)){
                JOptionPane.showMessageDialog(null,"Please enter a valid pin number", "Error", JOptionPane.ERROR_MESSAGE);
            }else if(address.equals("")){
                JOptionPane.showMessageDialog(null,"ENTER YOUR ADDRESS");
            }else if(city.equals("")){
                JOptionPane.showMessageDialog(null, "ENTER YOUR CITY");
            }else if(state.equals("")){
                JOptionPane.showMessageDialog(null,"ENTER THE STATE");
            }else if(country.equals("")){
                JOptionPane.showMessageDialog(null,"ENTER YOUR COUNTRY NAME");
            }else if(pincode.equals("")){
                JOptionPane.showMessageDialog(null,"ENTER THE PIN");
            }
            
            
            else{
                Conn c = new Conn();
                String query= "insert into signup values('"+formno+"' , '"+name+"' , '"+fname+"' , '"+dob+"' , '"+gender+"' , '"+email+"' , '"+marital+"' , '"+address+"' , '"+city+"' , '"+state+"' , '"+country+"' , '"+pincode+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignUpTwo(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
              
        }
        
    }
       
        
    public static void main(String args[]){
        new SignupOne();
    }
}
