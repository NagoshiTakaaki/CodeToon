package codetoon.system;
import java.io.Serializable;
import java.util.ArrayList;
public class testClassWrapper implements Serializable{
    boolean valid = false;
    ArrayList <Memory> memory;
    testClassWrapper(boolean _valid, ArrayList <Memory> _memory){
        memory = _memory;
        valid = _valid;
    }
}
