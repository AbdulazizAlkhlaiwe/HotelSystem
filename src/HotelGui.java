import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;
import javax.swing.*;

public class HotelGui extends JFrame {
 private JTextArea outputArea; 
    private JTextField nameField;
    private JTextField dateField;
    private JTextField phoneField;
    private JTextField PaymentMethodField;
    private JTextField RoomType;
    private Hotel GrandBudapestHotel;
    
    public HotelGui() {
     super("GrandBudapestHotel"); 
    GrandBudapestHotel =new Hotel("GrandBudapestHotel");
    setupInputPanel();  
    setupViewPanel();
    setDefaultCloseOperation(EXIT_ON_CLOSE);  
    setSize(1300, 800);  
    setVisible(true); 
    }
    

    private void setupInputPanel() {
     JPanel inputPanel = new JPanel();  
        inputPanel.setLayout(new GridLayout(8, 2, 5, 5));  
        inputPanel.setBorder(BorderFactory.createTitledBorder("Add Reservation"));  
  
        inputPanel.add(new JLabel("Name:"));  
        nameField = new JTextField(10);  
        inputPanel.add(nameField);  
  
        inputPanel.add(new JLabel("Date:"));  
        dateField = new JTextField(10);  
        inputPanel.add(dateField);  
  
        inputPanel.add(new JLabel("Phone:"));  
        phoneField = new JTextField(10);  
        inputPanel.add(phoneField);  
  
        inputPanel.add(new JLabel("PaymentMethod :"));  
        PaymentMethodField = new JTextField(10);  
        inputPanel.add(PaymentMethodField);
        
        inputPanel.add(new JLabel("RoomType : ( StandardRoom or SuiteRoom )"));  
        RoomType = new JTextField(10);  
        inputPanel.add(RoomType);
        
        
        JButton addButton = new JButton("Add Reservation");  
        addButton.addActionListener(e -> {  
            try {  
             addReser(e);  
            } catch (ReservationExcpetion ex) {  
                 
            }  
        });  
        inputPanel.add(addButton);  
  
        JButton saveButton = new JButton("Save Reservation to File");  
        saveButton.addActionListener(e -> saveReservationToFile());  
        inputPanel.add(saveButton);  
  
        JButton loadButton = new JButton("Load Reservation from File");  
        loadButton.addActionListener(e -> loadReservationFromFile());  
        inputPanel.add(loadButton);  
  
        getContentPane().add(inputPanel, BorderLayout.WEST);  
          
       
    }  
   

   public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String date = dateField.getText();
                String phone = phoneField.getText();
                String PaymentMethod = PaymentMethodField.getText();
                if (name.isEmpty() || date.isEmpty()  || phone.isEmpty() || PaymentMethod.isEmpty()) {
                    throw new InvalidInputException("Please fill in all the fields.");
                }}
                
                private void setupViewPanel() {  
                    JPanel viewPanel = new JPanel();  
                    viewPanel.setLayout(new BorderLayout());  
                    viewPanel.setBorder(BorderFactory.createTitledBorder("Reservation List"));  
              
                    outputArea = new JTextArea();  
                    outputArea.setEditable(false);  
                    JScrollPane scrollPane = new JScrollPane(outputArea);  
                    viewPanel.add(scrollPane, BorderLayout.CENTER);  
              
                    getContentPane().add(viewPanel, BorderLayout.CENTER);  
                }  
    
    
 
    public static class InvalidInputException extends RuntimeException {
        public InvalidInputException(String message) {
            super(message);
        }
    }

    
    
    private void addReser(ActionEvent e) throws ReservationExcpetion{  
        try {  
            
             String name = nameField.getText().trim();  
            String Date = dateField.getText().trim();
            String phoneNum = phoneField.getText().trim();
            String paymentMethod = PaymentMethodField.getText().trim();
            String Room = RoomType.getText().trim(); 
              
            Reservation NewReservation =new Reservation(name, Date, phoneNum, paymentMethod);
            GrandBudapestHotel.addReser(NewReservation);
            if(Room.equalsIgnoreCase("SuiteRoom"))
             GrandBudapestHotel.getReservation2().addRoom(new SuiteRoom(2999));
            else if(Room.equalsIgnoreCase("StandardRoom"))
             GrandBudapestHotel.getReservation2().addRoom(new StandardRoom(1499));
            else {
                JOptionPane.showMessageDialog(this, "Please enter a StadnardRoom or suiteRoom.");  
                return;  
            }
  
              
            nameField.setText("");  
            dateField.setText("");  
            phoneField.setText("");  
           PaymentMethodField.setText("");  
           RoomType.setText("");
  
           displayReservation(); // Update the display area  
        } catch (ReservationExcpetion Res) {  
            JOptionPane.showMessageDialog(this, "Please enter valid name and phoneNumber .");  
        }  
    }  
    
    
 

 private void saveReservationToFile() {  
        JFileChooser fileChooser = new JFileChooser();  
        fileChooser.setDialogTitle("Specify a file to save");  
        int userSelection = fileChooser.showSaveDialog(this);  
  
        if (userSelection == JFileChooser.APPROVE_OPTION) {  
            File fileToSave = fileChooser.getSelectedFile();  
            try {  
             GrandBudapestHotel.savetofile(fileToSave.getAbsolutePath());
                JOptionPane.showMessageDialog(this, "Data saved to file: " + fileToSave.getAbsolutePath());  
            } catch (IOException ex) {  
                JOptionPane.showMessageDialog(this, "Error saving to file: " + ex.getMessage());  
            }  
        }  
    }  
    private void loadReservationFromFile() {  
        JFileChooser fileChooser = new JFileChooser();  
        fileChooser.setDialogTitle("Specify a file to load");  
        int userSelection = fileChooser.showOpenDialog(this);  
  
        if (userSelection == JFileChooser.APPROVE_OPTION) {  
            File fileToLoad = fileChooser.getSelectedFile();
            Reservation[] loadedReservation =new Reservation[GrandBudapestHotel.getReservation().length];
            try {  
             GrandBudapestHotel.LoadFromfile(fileToLoad.getAbsolutePath());  
                for (Reservation res : loadedReservation) {  
                    if (res != null) GrandBudapestHotel.addReser(res);  
                }  
                displayReservation();  
                JOptionPane.showMessageDialog(this, "Data loaded from file: " + fileToLoad.getAbsolutePath());  
            } catch (IOException ex) {  
                JOptionPane.showMessageDialog(this, "Error loading from file: " + ex.getMessage());  
            }  
        }  
    }  
   private void displayReservation() {
StringBuilder sb = new StringBuilder();  
        for ( Reservation RES : GrandBudapestHotel.getReservation()) {  
            if (RES != null) sb.append(RES).append("\n");  
        }  
        outputArea.setText(sb.toString());  
    }
    
    
 public static void main(String[] args) {
     SwingUtilities.invokeLater(HotelGui::new); 
        System.out.println();
    }
}