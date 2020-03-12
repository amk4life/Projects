/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttaiit.blogspot.com;

import abstr.AbstractVisitor;
import abstr.Command;
import Command.*;
import abstr.Node;
import factory.TreeNodeFactory;
import model.CMVisitor;
import model.CPVisitor;
import model.Item;
import model.ItemContainer;
import observer.ConcreteSubject;
import observer.ItemObserver;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Fahad Khan
 */
public class World extends javax.swing.JFrame {


    public World() {
        initComponents();
        newnode = null;
        nodemap = new HashMap<>();
        logmap = new HashMap<>();
        logmap.put("tree", new HashMap<>());   // storing tree structure for undo/redo
        logmap.put("data", new HashMap<>());   // storing data for undo/redo

        conSub = new ConcreteSubject();
        ib = new ItemObserver(this);
        conSub.Attach(ib);


        //Default input
        TreeNodeFactory treeNodeFactory = new TreeNodeFactory();
        ItemContainer root = (ItemContainer) treeNodeFactory.getInstance("ItemContainer");
        root.initialize("root", 100.0, 0, 0, 0, 0);
        nodemap.put("root", root);
        ItemContainer container = (ItemContainer) treeNodeFactory.getInstance("ItemContainer");
        container.initialize("container", 100, 50, 50, 300, 300);
        nodemap.put("container", container);
        Item item1 = (Item) treeNodeFactory.getInstance("Item");
        item1.initialize("item1", 50, 70, 70, 100, 100);
        nodemap.put("item1", item1);
        Item item2 = (Item) treeNodeFactory.getInstance("Item");
        item2.initialize("item2", 50, 200, 70, 100, 100);
        nodemap.put("item2", item2);

        root.getItemList().add(container);
        container.getItemList().add(item1);
        container.getItemList().add(item2);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfRoot = new javax.swing.JTextField();
        bAAdRoot = new javax.swing.JButton();
        bAAdChild = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        treeWorld = new javax.swing.JTree();
        bDelete = new javax.swing.JButton();
        lMessage = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        log = new DefaultListModel<>();
        jList = new javax.swing.JList<>(log);
        Visualize = new javax.swing.JButton();
        Undo = new javax.swing.JButton();
        Redo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tfCMP = new javax.swing.JTextField();
        Update = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bAAdRoot.setText("Add");
        bAAdRoot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAAdRootActionPerformed(evt);
            }
        });

        bAAdChild.setText("Modify");
        bAAdChild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModifyActionPerformed(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("container");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("item1");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("item2");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeWorld.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        treeWorld.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                treeWorldMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(treeWorld);

        bDelete.setText("Delete");
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });

        lMessage.setForeground(new java.awt.Color(255, 0, 0));

        jLabel1.setText("Current Price");

        jLabel2.setText("Total Number of Items");

        jScrollPane3.setViewportView(jList);

        Visualize.setText("Visualize");
        Visualize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisualizeActionPerformed(evt);
            }
        });

        Undo.setText("Undo");
        Undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UndoActionPerformed(evt);
            }
        });

        Redo.setText("Redo");
        Redo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RedoActionPerformed(evt);
            }
        });

        jLabel4.setText("Current Market Price");

        Update.setText("Update");
        Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addComponent(Visualize))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(bDelete, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(bAAdChild, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(bAAdRoot, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfRoot, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Update)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Undo)
                                        .addGap(18, 18, 18)
                                        .addComponent(lMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Redo)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfCMP, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(tfCMP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(Update))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Undo))
                        .addGap(41, 41, 41)
                        .addComponent(Redo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bAAdRoot)
                                .addGap(17, 17, 17)
                                .addComponent(bAAdChild)
                                .addGap(18, 18, 18)
                                .addComponent(bDelete))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane3)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)))))
                .addGap(31, 31, 31)
                .addComponent(Visualize)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAAdRootActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAAdRootActionPerformed
        TreePath path = treeWorld.getSelectionPath();
        AddWindow nw = null;
        DefaultMutableTreeNode selectedNode = null;

        lMessage.setText("");
        if (path == null)
            lMessage.setText("Select a node!");
        else {
            selectedNode = (DefaultMutableTreeNode) path.getLastPathComponent();
            Object itemContainer = nodemap.get(selectedNode.toString());
            String name = itemContainer.getClass().getName();
            if (!selectedNode.toString().equals("root") && nodemap.get(selectedNode.toString()).getClass().getName().equals("model.Item"))
                lMessage.setText("Cannot add element to an item");
            else {
                nw = new AddWindow(this);
                nw.NewScreen();
            }
            conSub.notifyObservers();
        }
    }//GEN-LAST:event_bAAdRootActionPerformed

    private void bModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAAdChildActionPerformed
        ModifyWindow mw = new ModifyWindow(this);
        mw.open();
    }//GEN-LAST:event_bAAdChildActionPerformed

 
    private void VisualizeActionPerformed(java.awt.event.ActionEvent evt) {
       VisualizeWindow vw = VisualizeWindow.getInstance(this);
       vw.visualize();
    } 


    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed

        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treeWorld.getSelectionPath().getLastPathComponent();
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) selectedNode.getParent();
        ItemContainer parentobj = (ItemContainer) nodemap.get(parent.toString());
        Node childobj = (Node) nodemap.get(selectedNode.toString());
        lMessage.setText("");
        if (selectedNode.toString().equals("root"))
            lMessage.setText("You can't Delete Root");
        else {
            DefaultTreeModel model = (DefaultTreeModel) treeWorld.getModel();
            parentobj.getItemList().remove(childobj);   // delete from parent itemlist
            if (model.getChildCount(selectedNode) > 0)
                lMessage.setText("Can't delete non-empty container!");
            else {
                String logmes = "Del " + childobj.getType() + " " +childobj.getName();
                log.addElement(logmes);
                logmap.put(logmes, new HashMap<>());
                logmap.get(logmes).put("treenode", selectedNode);
                logmap.get(logmes).put("parentnode", selectedNode.getParent());
                logmap.get(logmes).put("obj", childobj);
                nodemap.remove(selectedNode.toString());
                model.removeNodeFromParent(selectedNode);
            }
            conSub.notifyObservers();
        }

    }//GEN-LAST:event_bDeleteActionPerformed

    private void treeWorldMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        TreeSelectionModel smd = treeWorld.getSelectionModel();
        if (smd.getSelectionCount() > 0) {

            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treeWorld.getSelectionPath().getLastPathComponent();
            Node selectedObj = (Node) nodemap.get(selectedNode.toString());
            AbstractVisitor cmVisitor = new CMVisitor();
            AbstractVisitor cpVisitor = new CPVisitor();
            double cmv = selectedObj.accept(cmVisitor);
            double cpv = selectedObj.accept(cpVisitor);
            tfRoot.setText(String.valueOf(cpv));
            tfCMP.setText(String.valueOf(cmv));

        }//GEN-LAST:event_treeWorldMouseClicked
    }

    private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
        // TODO add your handling code here:
        ib.update();
        int count = ib.getItemNumber();
        jTextField1.setText(Integer.toString(count));

    }//GEN-LAST:event_UpdateActionPerformed

    private void UndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UndoActionPerformed
        // TODO add your handling code here:
        String logmes = jList.getSelectedValue();
        if (logmes == null) {
            lMessage.setText("Choose a log record to undo!");
            return;
        }
        Command undoCommand = new UndoCommand(this, logmes);
        undoCommand.execute();
        ((DefaultTreeModel)treeWorld.getModel()).reload();
    }//GEN-LAST:event_UndoActionPerformed

    private void RedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RedoActionPerformed
        // TODO add your handling code here:
        String logmes = jList.getSelectedValue();
        if (logmes == null) {
            lMessage.setText("Choose a log record to redo!");
            return;
        }
        Command redoCommand = new RedoCommand(this, logmes);
        redoCommand.execute();
        log.removeElement(logmes);
        ((DefaultTreeModel)treeWorld.getModel()).reload();
    }//GEN-LAST:event_RedoActionPerformed

//    private void deleteDir(DefaultTreeModel model, DefaultMutableTreeNode sel) {
//        int total = model.getChildCount(sel);
//        DefaultMutableTreeNode child;
//        Node childobj;
//        nodemap.remove(sel.toString());
//
//        while (total > 0) {
//            child = (DefaultMutableTreeNode) model.getChild(sel, 0);
//            childobj = (Node) nodemap.get(child.toString());
//            if (childobj.getType().equals("ItemContainer")) {
//                deleteDir(model, child);
//            }
//            nodemap.remove(child.toString());
//            model.removeNodeFromParent(child);
//            total--;
//        }
//        model.removeNodeFromParent(sel);
//    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(World.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(World.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(World.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(World.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                World.getInstance().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Redo;
    private javax.swing.JButton Undo;
    private javax.swing.JButton Update;
    private javax.swing.JButton Visualize;
    private javax.swing.JButton bAAdChild;
    private javax.swing.JButton bAAdRoot;
    private javax.swing.JButton bDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList;
    private javax.swing.DefaultListModel<String> log;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lMessage;
    private javax.swing.JTextField tfCMP;
    private javax.swing.JTextField tfRoot;
    private javax.swing.JTree treeWorld;
    // End of variables declaration//GEN-END:variables

    private  Map<String, Object> nodemap;
    private Map<String, Map<String, Object>> logmap;
    private Node newnode;
    private static World instance;
    private ConcreteSubject conSub;
    private ItemObserver ib;


    // singleton implementation
    public static World getInstance() {
        if (instance == null)
            instance = new World();
        return instance;
    }

    public Map<String, Map<String, Object>> getLogmap() {
        return logmap;
    }

    public Map<String, Object> getNodemap() {
        return nodemap;
    }

    public void setNodemap(Map<String, Object> nodemap) {
        this.nodemap = nodemap;
    }

    public Node getNewnode() {
        return newnode;
    }

    public void setNewnode(Node newnode) {
        this.newnode = newnode;
    }

    public JTree getTreeWorld() {
        return treeWorld;
    }

    public DefaultListModel<String> getLog() {
        return log;
    }

    public void setLog(DefaultListModel<String> log) {
        this.log = log;
    }

    // End of variables declaration//GEN-END:variables
}
//end
