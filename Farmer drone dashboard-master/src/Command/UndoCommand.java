package Command;

import abstr.Command;
import abstr.Node;
import ttaiit.blogspot.com.World;

import java.util.Map;

public class UndoCommand extends Command {
    private UndoHandler handler;
    private String[] logmes;
    private Map<String, Object> undoInfo;
    private Map<String, Object> nodemap;



    public UndoCommand(World parentwindow, String logmes){
        undoInfo = parentwindow.getLogmap().get(logmes);
        nodemap = parentwindow.getNodemap();
        this.logmes = logmes.split(" ");
        handler = new UndoHandler(undoInfo, nodemap, this.logmes);
    }


    public void execute(){
        if (excutable())
            handler.undo();
    }

    public boolean excutable(){
        Node obj = (Node) undoInfo.get("obj");
        if (logmes[0].equals("Add") && !nodemap.containsKey(obj.getName()))
            return false;
        else return !logmes[0].equals("Del") || !nodemap.containsKey(obj.getName());
    }
}
