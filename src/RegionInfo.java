import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegionInfo extends JFrame {
    public RegionInfo(Region region, int width, int height) {
        RegionInfo panel = this;
        setSize(width, height);
        this.setBackground(Color.LIGHT_GRAY);
        this.setTitle("Region Information");
        JLabel topLabel = new JLabel(region.getName());
        topLabel.setHorizontalAlignment(JLabel.CENTER);
        JLabel label = new JLabel();
        JButton dismissButton = new JButton("Dismiss");
        dismissButton.addActionListener(ae -> panel.dispose());
        setLayout(new BorderLayout());
        panel.add(topLabel, BorderLayout.NORTH);
        panel.add(label, BorderLayout.CENTER);
        panel.add(dismissButton, BorderLayout.SOUTH);
        panel.setVisible(true);
        panel.setLocationRelativeTo(null);
        panel.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JCheckBox upgrade1 = new JCheckBox("Face Masks");
        upgrade1.setToolTipText("Decreases chance of infection by 20%");
        JCheckBox upgrade2 = new JCheckBox("Mechanical Respirators");
        upgrade2.setToolTipText("Doubles survivability of infected patients");
        JCheckBox upgrade3 = new JCheckBox("Media Campaign");
        upgrade3.setToolTipText("Increases funds gain by 50%");
        JCheckBox upgrade4 = new JCheckBox("Marine Air Filters");
        upgrade4.setToolTipText("Decreases chance of transiting disease to other countries by ship by 50%");
        JCheckBox upgrade5 = new JCheckBox("Port Swipe Tests");
        upgrade5.setToolTipText("Decreases threshold for closing seaports by 50%");
        JCheckBox upgrade6 = new JCheckBox("Aircraft Air Filters");
        upgrade6.setToolTipText("Decreases chance of transiting disease to other countries by airplane by 50%");
        JCheckBox upgrade7 = new JCheckBox("Airport Swipe Tests");
        upgrade7.setToolTipText("Decreases threshold for closing airports by 50%");
        JCheckBox upgrade8 = new JCheckBox("Border Controls");
        upgrade8.setToolTipText("Decreases chance of transiting disease to other countries by land by 50%");
        JCheckBox upgrade9 = new JCheckBox("Border Wall");
        upgrade9.setToolTipText("Decreases threshold for closing land borders by 50%");
        // icon
        // price
        label.add(new UpgradeLabel( "$500"));
        label.add(upgrade1);
        // icon
        // price
        label.add(new JLabel("$500"));
        label.add(upgrade3);
        label.add(new JLabel("$500"));
        label.add(upgrade2);
        label.add(new JLabel("$500"));
        label.add(upgrade4);
        label.add(new JLabel("$500"));
        label.add(upgrade5);
        label.add(new JLabel("$500"));
        label.add(upgrade6);
        label.add(new JLabel("$500"));
        label.add(upgrade7);
        label.add(new JLabel("$500"));
        label.add(upgrade8);
        label.add(new JLabel("$500"));
        label.add(upgrade9);
        label.setLayout(new GridLayout(9,2));
        if (region.getUpgrade1())
            lockUpgrade(upgrade1);
        if (region.getUpgrade5())
            lockUpgrade(upgrade5);

        upgrade1.addItemListener(new CheckOnceListener(region));
        upgrade2.addItemListener(new CheckOnceListener(region));
        upgrade3.addItemListener(new CheckOnceListener(region));
        upgrade4.addItemListener(new CheckOnceListener(region));
        upgrade5.addItemListener(new CheckOnceListener(region));
        upgrade6.addItemListener(new CheckOnceListener(region));
        upgrade7.addItemListener(new CheckOnceListener(region));
        upgrade8.addItemListener(new CheckOnceListener(region));
        upgrade9.addItemListener(new CheckOnceListener(region));
    }

    public class CheckOnceListener implements ItemListener {
        Region region;
        public CheckOnceListener(Region region) {
            this.region = region;
        }
        @Override
        public void itemStateChanged(ItemEvent e) {
            JCheckBox cb = (JCheckBox) e.getSource();
            if (e.getStateChange() == ItemEvent.SELECTED) {
                lockUpgrade(cb);
                region.setUpgrade9(true);
//                cb.setEnabled(false);
//                cb.setSelected(true);
            }
        }
    }
    public void lockUpgrade (JCheckBox cb) {
        cb.setSelected(true);
        cb.setEnabled(false);
    }
}
