import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Daniil on 08.01.2019.
 */
public class MatchesTaskForm extends JFrame {
    private JPanel MatchesPanel;
    private JTextField inputField;
    private JButton calculateButton;


    public MatchesTaskForm() {
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MatchesCalculator MatchesCalculator = new MatchesCalculator(inputField.getText());
            }
        });
    }

    public void init()
    {
        this.setTitle("D.Rekov: Matches Task");
        this.setContentPane(new MatchesTaskForm().MatchesPanel);
        this.setSize(400 , 250);
        this.setLocation(750,350);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
