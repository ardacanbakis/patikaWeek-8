package View;

import Entity.Pension;

import javax.swing.*;

public class PensionView {
    private JPanel container;
    private JComboBox cmb_pension;

    public PensionView() {
    cmb_pension.setModel(new DefaultComboBoxModel<>(Pension.PensionType.values()));
    }
}
