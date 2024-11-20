import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameOne extends JFrame {
    private JLabel keysLabel;
    private JLabel barLabel;
    private JButton Generate;
    private JComboBox<String> keySelector;
    private JComboBox<String> generateTimes;
    private JComboBox<String> barSelector;
    private JLabel gtLabel;
    private String selectedKey = "A";
    private String selectedBars = "4";
    private String selectedGenerateTimes = "1";

    public JFrameOne(String[] keys) {
        initialize(keys);
        setUpButtonListeners();
        setUpComboBoxListeners();
    }

    public void initialize(String[] keys) {
        Container ct = getContentPane();
        GroupLayout group = new GroupLayout(ct);
        ct.setLayout(group);
        group.setAutoCreateGaps(true);
        group.setAutoCreateContainerGaps(true);

        setTitle("Random Chord Progression Generator");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 700);
        setLocationRelativeTo(null);

        // Key selector setup
        keySelector = new JComboBox<>(keys);
        keysLabel = new JLabel("Select Key");

        // Generate button setup
        Generate = new JButton("Generate");

        // Number of MIDI files to generate setup
        String[] generateTimesList = {"1","2","3","4","5","6","7","8","9","10"};
        generateTimes = new JComboBox<>(generateTimesList);
        gtLabel = new JLabel("How many MIDI files to generate");

        // Bar selector setup
        String[] bars = {"4", "8"};
        barSelector = new JComboBox<>(bars);
        barLabel = new JLabel("Select number of bars per progression");

        // Horizontal group
        group.setHorizontalGroup(
                group.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(group.createSequentialGroup()
                                .addComponent(keysLabel)
                                .addComponent(keySelector))
                        .addGroup(group.createSequentialGroup()
                                .addComponent(gtLabel)
                                .addComponent(generateTimes))
                        .addGroup(group.createSequentialGroup()
                                .addComponent(barLabel)
                                .addComponent(barSelector))
                        .addComponent(Generate)
        );

        // Vertical group
        group.setVerticalGroup(
                group.createSequentialGroup()
                        .addGroup(group.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(keysLabel)
                                .addComponent(keySelector))
                        .addGap(20)
                        .addGroup(group.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(barLabel)
                                .addComponent(barSelector))
                        .addGap(20)
                        .addGroup(group.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(gtLabel)
                                .addComponent(generateTimes))
                        .addGap(20)
                        .addComponent(Generate)
        );

        setVisible(true);
    }

    public void setUpButtonListeners(){
        ActionListener generateButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Generate!");
                System.out.println("Key = " + selectedKey);
                System.out.println("Bars = " + selectedBars);
                System.out.println("Number of times to generate = " + selectedGenerateTimes);
                // call MidiChordGenerator
            }
        };
        Generate.addActionListener(generateButton);

    }

    public void setUpComboBoxListeners(){
        keySelector.addActionListener(e -> {
            selectedKey = (String) keySelector.getSelectedItem(); // Update selectedKey
            System.out.println("Selected Key Updated: " + selectedKey); // Print the updated key
        });

        barSelector.addActionListener(e -> {
            selectedBars = (String) barSelector.getSelectedItem(); // Update selectedBars
            System.out.println("Selected Bars Updated: " + selectedBars); // Print the updated bars
        });

        generateTimes.addActionListener(e -> {
            selectedGenerateTimes = (String) generateTimes.getSelectedItem(); // Update selectedKey
            System.out.println("Selected Key Updated: " + selectedGenerateTimes); // Print the updated key
        });
    }
}