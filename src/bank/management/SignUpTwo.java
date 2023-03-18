
package bank.management;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;

class pTextField extends PlainDocument{
    private int limit;
    pTextField(int limit){
        super();
        this.limit=limit;
    }
    pTextField(int limit, boolean upper){
        super();
        this.limit=limit;
    }
    public void insertString(int offset,String str,AttributeSet attr) throws BadLocationException{
        if(str==null)
            return;
        if((getLength()+str.length()) <= limit){
            super.insertString(offset, str, attr);
        }
    }
}
public class SignUpTwo extends JFrame implements ActionListener {
     
    JTextField panTextField,aadharTextField;
    JComboBox religionComboBox,categoryComboBox,incomeComboBox,educationComboBox,occupationComboBox;
    JRadioButton yessenior,nosenior,yesacc,noacc;
    JButton next;
    String formno;
   SignUpTwo(String formno){
       this.formno=formno;
       setLayout(null);
       setTitle("New Account application-PAGE 2");
       JLabel additional = new JLabel("PAGE 2: ADDITIONAL DETAILS");
       additional.setFont(new Font("Arial",Font.BOLD,32));
       additional.setBounds(200,50,650,30);
       add(additional);
       
       JLabel religion = new JLabel("RELIGION:");
       religion.setFont(new Font("Arial",Font.BOLD,20));
       religion.setBounds(100,150,200,40);
       add(religion);
       
       String valreligion[]={"HINDU","MUSLIM","CHRISTIAN","OTHERS"};
       religionComboBox = new JComboBox(valreligion);
       religionComboBox.setFont(new Font("Arial",Font.BOLD,18));
       religionComboBox.setBounds(280,150,500,40);
       add(religionComboBox);
       
       JLabel category = new JLabel("CATEGORY:");
       category.setFont(new Font("Arial",Font.BOLD,20));
       category.setBounds(100,200,200,40);
       add(category);
       
       String valcategory[]={"OPEN","SC","ST","OTHERS"};
       categoryComboBox = new JComboBox(valcategory);
       categoryComboBox.setFont(new Font("Arial",Font.BOLD,18));
       categoryComboBox.setBounds(280,200,500,40);
       add(categoryComboBox);
       
       JLabel income = new JLabel("INCOME");
       income.setFont(new Font("Arial",Font.BOLD,20));
       income.setBounds(100,250,200,40);
       add(income);
       
       String valincome[] = {"NULL","<1,50,000",">1,50,000"};
       incomeComboBox = new JComboBox(valincome);
       incomeComboBox.setFont(new Font("Arial",Font.BOLD,18));
       incomeComboBox.setBounds(280,250,500,40);
       add(incomeComboBox);
       
       JLabel education = new JLabel("EDUCATION");
       education.setFont(new Font("Arial",Font.BOLD,20));
       education.setBounds(100,300,200,40);
       add(education);
       JLabel qualification = new JLabel("QUALIFICATION:");
       qualification.setFont(new Font("Arial",Font.BOLD,20));
       qualification.setBounds(100,320,200,40);
       add(qualification);
       
       String valeducation[] = {"SSC PASS","HSC PASS","GRADUATE","NON GRADUATE","DOCTRATE","DIPLOMA"};
       educationComboBox = new JComboBox(valeducation);
       educationComboBox.setFont(new Font("Arial",Font.BOLD,18));
       educationComboBox.setBounds(280,320,500,40);
       add(educationComboBox);
       
       JLabel occupation = new JLabel("OCCUPATION:");
       occupation.setFont(new Font("Arial",Font.BOLD,20));
       occupation.setBounds(100,370,200,40);
       add(occupation);
       String valoccupation[]={"SALARIED","STUDENT","SELF-EMPLOYED","RETIRED"};
       occupationComboBox = new JComboBox(valoccupation);
       occupationComboBox.setBounds(280,370,500,40);
       occupationComboBox.setFont(new Font("Arial",Font.BOLD,18));
       add(occupationComboBox);
       
       JLabel pan = new JLabel("PAN NUMBER:");
       pan.setFont(new Font("Arial",Font.BOLD,20));
       pan.setBounds(100,420,200,40);
       add(pan);
       panTextField = new JTextField(15);
       panTextField.setDocument(new pTextField(10));
       panTextField.setFont(new Font("Arial",Font.BOLD,18));
       panTextField.setBounds(280,420,500,40);
       add(panTextField);
       
       JLabel aadhar = new JLabel("AADHAR NUMBER:");
       aadhar.setFont(new Font("Arial",Font.BOLD,20));
       aadhar.setBounds(100,470,200,40);
       add(aadhar);
       aadharTextField = new JTextField(15);
       aadharTextField.setDocument(new pTextField(12));
       aadharTextField.setFont(new Font("Arial",Font.BOLD,18));
       aadharTextField.setBounds(290,470,500,40);
       add(aadharTextField);
       
       
       JLabel senior = new JLabel("SENIOR CITIZEN:");
       senior.setFont(new Font("Arial",Font.BOLD,20));
       senior.setBounds(100,520,200,40);
       add(senior);
       yessenior = new JRadioButton("Yes");
       yessenior.setFont(new Font("Arial",Font.BOLD,18));
       yessenior.setBounds(380,520,120,40);
       yessenior.setBackground(Color.WHITE);
       add(yessenior);
       nosenior= new JRadioButton("No");
       nosenior.setFont(new Font("Arial",Font.BOLD,18));
       nosenior.setBounds(520,520,120,40);
       nosenior.setBackground(Color.WHITE);
       add(nosenior);
       ButtonGroup seniorGroup = new ButtonGroup();
       seniorGroup.add(yessenior);
       seniorGroup.add(nosenior);
       
       
       JLabel existing = new JLabel("EXISTING ACCOUNT:");
       existing.setFont(new Font("Arial",Font.BOLD,20));
       existing.setBounds(100,570,240,40);
       add(existing);
       yesacc = new JRadioButton("Yes");
       yesacc.setFont(new Font("Arial",Font.BOLD,18));
       yesacc.setBounds(380,570,120,40);
       yesacc.setBackground(Color.WHITE);
       add(yesacc);
       noacc = new JRadioButton("No");
       noacc.setFont(new Font("Arial",Font.BOLD,18));
       noacc.setBounds(520,570,120,40);
       noacc.setBackground(Color.WHITE);
       add(noacc);
       ButtonGroup accountGroup = new ButtonGroup();
       accountGroup.add(yesacc);
       accountGroup.add(noacc);
       
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
       String religion = (String)religionComboBox.getSelectedItem();
       String category = (String)categoryComboBox.getSelectedItem();
       String income = (String)incomeComboBox.getSelectedItem();
       String education= (String)educationComboBox.getSelectedItem();
       String occupation= (String)occupationComboBox.getSelectedItem();
      
       String senior =null;
       if(yessenior.isSelected()){
           senior="Yes";
       }else if(nosenior.isSelected()){
           senior="No";
       }
       String existing = null;
       if(yesacc.isSelected()){
           existing="Yes";
       }else if(noacc.isSelected()){
           existing="No";
       }
        String pan = panTextField.getText();
        String aadhar = aadharTextField.getText();
       try{
           Conn c = new Conn();
           String query = "insert into signuptwo values('"+formno+"','"+religion+"' , '"+category+"' , '"+income+"' , '"+education+"' , '"+occupation+"' , '"+pan+"' , '"+aadhar+"' , '"+senior+"' , '"+existing+"')";
           c.s.executeUpdate(query);
           
           //SIGNUPTHREE OBJECT
           setVisible(false);
           new SignUpThree(formno).setVisible(true);
           }
           catch(Exception e){
               System.out.println(e);
           }
       
   }
   public static void main(String args[]){
       new SignUpTwo("");
   }
    
}
