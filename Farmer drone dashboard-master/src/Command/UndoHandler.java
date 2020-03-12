package Command;


import abstr.Node;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.Map;

public class UndoHandler {

    private Map<String, Object> undoInfo;
    private Map<String, Object> nodemap;
    private String[] logmes;

    public UndoHandler(Map<String, Object> undoInfo, Map<String, Object> nodemdap, String[] logmes){
        this.undoInfo = undoInfo;
        this.logmes = logmes;
        this.nodemap = nodemdap;
    }

    public void undo(){
        Node obj = (Node) undoInfo.get("obj");
        DefaultMutableTreeNode treenode = (DefaultMutableTreeNode) undoInfo.get("treenode");
        DefaultMutableTreeNode parentnode;
        if (logmes[0].equals("Add")) {
            nodemap.remove(obj.getName());
            treenode.removeFromParent();
        }
        else if (logmes[0].equals("Del")){
            parentnode = (DefaultMutableTreeNode) undoInfo.get("parentnode");
            nodemap.put(obj.getName(), obj);
            parentnode.add(treenode);
        }
        else{
            treenode.setUserObject(obj.getName());
            undoInfo.put("obj", nodemap.get(obj.getName()));
            nodemap.put(obj.getName(), obj);
        }
    }
}
