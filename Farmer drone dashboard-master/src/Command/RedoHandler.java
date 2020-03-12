package Command;

import abstr.Node;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.Map;

public class RedoHandler {

    private Map<String, Object> undoInfo;
    private Map<String, Object> nodemap;
    private String[] logmes;

    public RedoHandler(Map<String, Object> undoInfo, Map<String, Object> nodemdap, String[] logmes){
        this.undoInfo = undoInfo;
        this.logmes = logmes;
        this.nodemap = nodemdap;
    }

    public void redo(){
        Node obj = (Node) undoInfo.get("obj");
        DefaultMutableTreeNode treenode  = (DefaultMutableTreeNode) undoInfo.get("treenode");
        DefaultMutableTreeNode parentnode = (DefaultMutableTreeNode) undoInfo.get("parentnode");
        if (logmes[0].equals("Add")) {
            nodemap.put(obj.getName(), obj);
            parentnode.add(new DefaultMutableTreeNode(obj.getName()));
        }
        else if (logmes[0].equals("Del")){
            nodemap.remove(obj.getName());
            treenode.removeFromParent();
        }
        else{
            treenode.setUserObject(obj.getName());
            undoInfo.put("obj", nodemap.get(obj.getName()));
            nodemap.put(obj.getName(), obj);
        }
    }
}
