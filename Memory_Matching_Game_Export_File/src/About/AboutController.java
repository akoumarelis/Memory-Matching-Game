package About;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Tasos
 */
public class AboutController {
    private AboutView v;
    private AboutModel m;
    
    public AboutController(AboutModel m1,AboutView v1) { //Constructor for Controller with model and view objects   
        v = v1;
        m = m1;
    }
    
    public void initController() { //Set history frame invisible
        m.setAbout("<html> <br> This project was a project for the course: <br> Advanced Software Engineering & <br> Big Data Modeling <br> at the Hellenic Mediterranean University. <br> Please email me with any questions or concerns. <br> Made by Anastasios Koumarelis. <br> Email : akoumarelis@gmail.com </html>");
        v.getTextInfo().setText(m.getAbout()); //Set the info text in the jlabel
        
        v.getClose().addActionListener(new ActionListener() { //If close button pressed
            public void actionPerformed(ActionEvent e) { 
                v.getFrame().setVisible(false);
            } 
        } ); 
    }   
    
    public void showAbout() { //Set history frame visible
       v.getFrame().setVisible(true);
    }   
     
    public void hideAbout() { //Set history frame invisible
       v.getFrame().setVisible(false);  
    }   
}