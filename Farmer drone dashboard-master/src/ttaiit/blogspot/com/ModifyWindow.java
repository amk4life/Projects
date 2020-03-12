package ttaiit.blogspot.com;

import abstr.Node;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

public class ModifyWindow extends JFrame {

    public ModifyWindow(World parentWindow){
        initComponents();

        this.nodemap = parentWindow.getNodemap();
        this.logmap = parentWindow.getLogmap();
        this.log = parentWindow.getLog();
        treeWorld = parentWindow.getTreeWorld();
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treeWorld.getSelectionPath().getLastPathComponent();
        Node selectedObject = (Node) nodemap.get(selectedNode.toString());
        setSelelctedNode(selectedObject);

        // display node content
        tfName.setText(selectedObject.getName());
        tfLength.setText(String.valueOf(selectedObject.getLength()));
        tfPrice.setText(String.valueOf(selectedObject.getPrice()));
        tfWidth.setText(String.valueOf(selectedObject.getWidth()));
        tfX.setText(String.valueOf(selectedObject.getCoordinate_x()));
        tfY.setText(String.valueOf(selectedObject.getCoordinate_y()));
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        tfX = new javax.swing.JTextField();
        tfY = new javax.swing.JTextField();
        tfLength = new javax.swing.JTextField();
        tfWidth = new javax.swing.JTextField();
        tfPrice = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Name");

        jLabel2.setText("Price");

        jLabel3.setText("X-Axis");

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveModPerformed(evt);
            }
        });

        jLabel4.setText("Y-Axis");

        jLabel5.setText("Length");

        jLabel6.setText("Width");


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 161, Short.MAX_VALUE)
                                                .addComponent(jButton1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel5)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(1, 1, 1)
                                                                .addComponent(jLabel6)))
                                                .addGap(24, 24, 24)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(tfWidth)
                                                        .addComponent(tfLength)
                                                        .addComponent(tfY)
                                                        .addComponent(tfX)
                                                        .addComponent(tfName)
                                                        .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(tfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(tfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(tfX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(tfY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(tfLength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(tfWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(65, 65, 65)
                                .addComponent(jButton1))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean isDigitString(String s){
        return s.matches("-?[0-9]+\\.?[0-9]*");
    }

    private boolean checkInput(){
        if (!tfName.getText().equals("") &&
                !tfLength.getText().equals("") &&
                !tfPrice.getText().equals("") &&
                !tfWidth.getText().equals("") &&
                !tfX.getText().equals("") &&
                !tfY.getText().equals("")
        )
            if (isDigitString(tfLength.getText()) && isDigitString(tfPrice.getText()) && isDigitString(tfWidth.getText())
                    && isDigitString(tfX.getText()) && isDigitString(tfY.getText()))
                return true;

        return false;
    }

    private void saveModPerformed(ActionEvent evt){
        if (!checkInput())
            JOptionPane.showMessageDialog(null, "Illegal parameter!");
        else {
            //add to log before modification
            DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) treeWorld.getSelectionPath().getLastPathComponent();
            String logmes = "Mod " + selectedNode.getType() + " " + tfName.getText();
            log.addElement(logmes);
            logmap.put(logmes, new HashMap<>());
            logmap.get(logmes).put("treenode", treeNode);
            logmap.get(logmes).put("obj", selectedNode.clone());

            selectedNode.changeName(tfName.getText());
            selectedNode.changePrice(Double.parseDouble(tfPrice.getText()));
            selectedNode.changeWidth(Integer.parseInt(tfWidth.getText()));
            selectedNode.changeLength(Integer.parseInt(tfLength.getText()));
            selectedNode.changeXcoordinate(Integer.parseInt(tfX.getText()));
            selectedNode.changeYcoordinate(Integer.parseInt(tfY.getText()));
            DefaultMutableTreeNode selectedTreeobj = (DefaultMutableTreeNode) treeWorld.getSelectionPath().getLastPathComponent();
            selectedTreeobj.setUserObject(tfName.getText());
            DefaultTreeModel model = (DefaultTreeModel) treeWorld.getModel();
            model.reload();
            this.dispose();
        }
    }

    public void open(){
        this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField tfLength;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfPrice;
    private javax.swing.JTextField tfWidth;
    private javax.swing.JTextField tfX;
    private javax.swing.JTextField tfY;
    private javax.swing.JTree treeWorld;
    private Map<String, Object> nodemap;
    private Map<String, Map<String, Object>> logmap;
    private Node selectedNode;
    private DefaultListModel<String> log;

    public Node getNewnode() {
        return selectedNode;
    }

    public void setSelelctedNode(Node selelctedNode) {
        this.selectedNode = selelctedNode;
    }
// End of variables declaration//GEN-END:variables
}

