package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import project.gui.Login;
import project.service.MySqlService;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class Main {

    
    /**
     * @param args the command line arguments
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Starting");
        System.out.println(Main.class.getResource("/images/train_sets.jpg"));
        MySqlService.getInstance();
        Login LoginFrame = new Login();
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        LoginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add a WindowListener to handle the window closing event
        LoginFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Window is closing");
                MySqlService.closeConnection();
            }
            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("Window closed");
                MySqlService.closeConnection();
            }
        });
    }
}
