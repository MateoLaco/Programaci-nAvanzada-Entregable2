package lugares;

import config.Config;

import java.util.ArrayList;
import java.util.List;

public class Local {
    private List<Mesa> mesas;

    Local(){
        mesas = new ArrayList<>(Config.M);
    }
}
