package Command;

import abstr.Command;
import abstr.Node;
import ttaiit.blogspot.com.World;

import java.util.Map;

public class RedoCommand extends Command {
    private RedoHandler handler;
    private String[] logmes;
    private Map<String, Object> undoInfo;
    private Map<String, Object> nodemap;

    public RedoCommand(World parentwindow, String logmes){
        undoInfo = parentwindow.getLogmap().get(logmes);
        nodemap = parentwindow.getNodemap();
        this.logmes = logmes.split(" ");
        handler = new RedoHandler(undoInfo, nodemap, this.logmes);
    }

    public void execute(){
        if (excutable())
            handler.redo();
    }

    public boolean excutable(){
        return true;
    }
}
