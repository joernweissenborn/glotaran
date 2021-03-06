/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.glotaran.options;

import org.openide.util.NbPreferences;

final class ColorScalePanel extends javax.swing.JPanel {

    private final ColorScaleOptionsPanelController controller;

    ColorScalePanel(ColorScaleOptionsPanelController controller) {
        this.controller = controller;
        initComponents();
        // TODO listen to changes in form fields and call controller.changed()
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        buttonGroup1.add(jRadioButton1);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton1, org.openide.util.NbBundle.getMessage(ColorScalePanel.class, "ColorScalePanel.jRadioButton1.text")); // NOI18N

        buttonGroup1.add(jRadioButton2);
        org.openide.awt.Mnemonics.setLocalizedText(jRadioButton2, org.openide.util.NbBundle.getMessage(ColorScalePanel.class, "ColorScalePanel.jRadioButton2.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2)
                .addContainerGap(10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    void load() {
        // TODO read settings and initialize GUI
        // Example:        
        // someCheckBox.setSelected(Preferences.userNodeForPackage(ColorScalePanel.class).getBoolean("someFlag", false));
        // or for org.openide.util with API spec. version >= 7.4:   
        switch (NbPreferences.forModule(ColorScalePanel.class).getInt("selectedColorScale", 0)) {
            case 0:
                jRadioButton1.setSelected(true);
                break;
            case 1:
                jRadioButton2.setSelected(true);
                break;
                      
        }
        //someCheckBox.setSelected();
        // or:
        // someTextField.setText(SomeSystemOption.getDefault().getSomeStringProperty());
    }

    void store() {
        // TODO store modified settings
        // Example:
        // Preferences.userNodeForPackage(ColorScalePanel.class).putBoolean("someFlag", someCheckBox.isSelected());
        // or for org.openide.util with API spec. version >= 7.4:
        NbPreferences.forModule(ColorScalePanel.class).putBoolean("defaultColorScale", jRadioButton1.isSelected());        
        if(jRadioButton1.isSelected()) {
            NbPreferences.forModule(ColorScalePanel.class).putInt("selectedColorScale", 0);
        } else if(jRadioButton2.isSelected()) {
            NbPreferences.forModule(ColorScalePanel.class).putInt("selectedColorScale", 1);
        }
        // or:
        // SomeSystemOption.getDefault().setSomeStringProperty(someTextField.getText());
    }

    boolean valid() {
        // TODO check whether form is consistent and complete
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    // End of variables declaration//GEN-END:variables
}
