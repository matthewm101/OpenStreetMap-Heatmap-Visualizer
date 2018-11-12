/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matthewm101;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileNameExtensionFilter;
import matthewm101.HeatmapGenerator.HeatmapSetupHandler;

/**
 * A JFrame menu that handles the loading of an XML file and an optional image.
 * @author Matthew M
 */
public class LoadFileMenu extends javax.swing.JFrame
        implements HeatmapSetupHandler {

    /**
     * The current task that heatmapGen is executing.
     */
    private SwingWorker<Void, String> task;
    
    /**
     * The object used to generate heatmaps.
     */
    private HeatmapGenerator heatmapGen;
    
    /**
     * Whether POI data is currently being parsed.
     * This determines if buttons should be disabled or relabeled.
     */
    private boolean parsing;
    
    /**
     * Creates new form LoadFileMenu
     */
    public LoadFileMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        authorLabel = new javax.swing.JLabel();
        chooseDataPathLabel = new javax.swing.JLabel();
        dataPathTextField = new javax.swing.JTextField();
        openDataDialogButton = new javax.swing.JButton();
        chooseImagePathLabel1 = new javax.swing.JLabel();
        chooseImagePathLabel2 = new javax.swing.JLabel();
        imagePathTextField = new javax.swing.JTextField();
        openImageDialogButton = new javax.swing.JButton();
        generateHeatmapButton = new javax.swing.JButton();
        generateHeatmapLabel = new javax.swing.JLabel();
        loadingBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("OpenStreetMap Heatmap Visualizer");

        authorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        authorLabel.setText("Created By Matthew Musselman");

        chooseDataPathLabel.setText("Please input the path to an XML file that contains OpenStreetMap data.");

        openDataDialogButton.setText("Open Dialog");
        openDataDialogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openChooseDataDialog(evt);
            }
        });

        chooseImagePathLabel1.setText("Optionally, input the path to a background image.");

        chooseImagePathLabel2.setText("This image should ideally be a map bounded by the same bounding box as the data.");

        openImageDialogButton.setText("Open Dialog");
        openImageDialogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openChooseImageDialog(evt);
            }
        });

        generateHeatmapButton.setText("Generate Heatmap");
        generateHeatmapButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateHeatmapButtonActionPerformed(evt);
            }
        });

        generateHeatmapLabel.setText("After selecting a file and/or an image, click this button to generate the heatmap.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(generateHeatmapButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(authorLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dataPathTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(openDataDialogButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imagePathTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(openImageDialogButton))
                    .addComponent(generateHeatmapLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chooseDataPathLabel)
                            .addComponent(chooseImagePathLabel1)
                            .addComponent(chooseImagePathLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(loadingBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(authorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chooseDataPathLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataPathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openDataDialogButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chooseImagePathLabel1)
                .addGap(0, 0, 0)
                .addComponent(chooseImagePathLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imagePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openImageDialogButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(generateHeatmapLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(generateHeatmapButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loadingBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openChooseDataDialog(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openChooseDataDialog
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("XML", "xml"));
        int result = chooser.showOpenDialog(chooser);
        if (result == JFileChooser.APPROVE_OPTION) {
            dataPathTextField.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_openChooseDataDialog

    private void openChooseImageDialog(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openChooseImageDialog
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("Image Files", "png", "jpg"));
        int result = chooser.showOpenDialog(chooser);
        if (result == JFileChooser.APPROVE_OPTION) {
            imagePathTextField.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_openChooseImageDialog

    private void generateHeatmapButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateHeatmapButtonActionPerformed
        if (!parsing) {
            //If the button says "Parse File", the background image will be loaded and the xml file will be parsed.
            BufferedImage image = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
            if (!imagePathTextField.getText().equals("")) {
                try {
                    image = ImageIO.read(new File(imagePathTextField.getText()));
                } catch (IOException e) {
                    generateHeatmapLabel.setText("The image could not be loaded; please ensure the image path is correct.");
                    return;
                }
            }
            //To allow the loading to be cancelled, a SwingWorker is used to create a separate task that will
            //execute without freezing the GUI.
            try {
                File file = new File(dataPathTextField.getText());
                Dimension dim = new Dimension(image.getWidth(), image.getHeight());
                heatmapGen = new HeatmapGenerator(file, image, loadingBar);
                task = heatmapGen.getSetupTask(this);
                parsing = true;
                setInputStates();
                task.execute();
            } catch (IOException e) {
                generateHeatmapLabel.setText("The xml file could not be loaded; please ensure the file path is correct.");
            }
        } else {
            //If the button says "Cancel", the task will be cancelled.
            parsing = false;
            task.cancel(true);
            setInputStates();
        }
    }//GEN-LAST:event_generateHeatmapButtonActionPerformed

    /**
     * Enables or disables certain inputs depending on if the menu is
     * currently loading.
     */
    private void setInputStates() {
        dataPathTextField.setEnabled(!parsing);
        generateHeatmapButton.setText(parsing?"Cancel":"Parse File");
        imagePathTextField.setEnabled(!parsing);
        openDataDialogButton.setEnabled(!parsing);
        openImageDialogButton.setEnabled(!parsing);
        loadingBar.setStringPainted(parsing);
        loadingBar.setString("Parsing XML file");
        loadingBar.setIndeterminate(parsing);
        loadingBar.setValue(0);
    }

    /**
     * Called when the XML file is finished being parsed.
     * This will open a new window to show the heatmap.
     */
    public void handleSetup() {
        if (parsing) {
            HeatmapMenu menu = new HeatmapMenu(heatmapGen);
            menu.setVisible(true);
            this.setVisible(false);
            this.setEnabled(false);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoadFileMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoadFileMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoadFileMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoadFileMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoadFileMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorLabel;
    private javax.swing.JLabel chooseDataPathLabel;
    private javax.swing.JLabel chooseImagePathLabel1;
    private javax.swing.JLabel chooseImagePathLabel2;
    private javax.swing.JTextField dataPathTextField;
    private javax.swing.JButton generateHeatmapButton;
    private javax.swing.JLabel generateHeatmapLabel;
    private javax.swing.JTextField imagePathTextField;
    private javax.swing.JProgressBar loadingBar;
    private javax.swing.JButton openDataDialogButton;
    private javax.swing.JButton openImageDialogButton;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

}
