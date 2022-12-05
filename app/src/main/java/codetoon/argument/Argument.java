package codetoon.argument;

import java.util.HashMap;

import codetoon.main.Main;
import codetoon.map.PazzleStage;
import codetoon.method.*;
import codetoon.system.Player;
import codetoon.variable.*;

public abstract class Argument<T, I>  {
    public static final int NOT_ARGUMENT = -99999;
    protected final StringBuilder ERROR = new StringBuilder().append("sgsihgrgmkwrgtkrthhjthmmlghmghmls");
    protected Argument(){

    } 
    protected int serch(char n, StringBuilder obj){
        for(int i = 0; i < obj.length(); i ++){
            if(obj.charAt(i) == n){
                return i;
            }
        }
        return -1;
    } 
    protected MyMethod isMethod(StringBuilder data){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i< data.length(); i ++){
            if(data.charAt(i) != '('){
                builder.append(data.charAt(i));
                
            }else{
                break;
            }

        }

        return Methods.METHODS.get("method_" + builder.toString());
    }
    public T convertVariableTo(String s){
        Player p = ((PazzleStage) Main.getInstance().getMap()).getConsole().getHost();
        String variable_ID = p.getID() + "_" + s;
        System.out.println(variable_ID);
        if(Variables.VARIABLE.search("variable_" + variable_ID)){
            Variable<?> re =  Variables.VARIABLE.get("variable_" + variable_ID);
            return (T) re.action();
        }else{
            return null;
        }
    }
    protected Variable<?> isArgument(StringBuilder data){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < data.length(); i ++){
            if(data.charAt(i) != '['){
                builder.append(data.charAt(i));
            }else{
                break;
            }
        }
        return Variables.VARIABLE.get("variable_" +  builder.toString());
    }
    protected HashMap<Integer, String> getVariable(StringBuilder data, String percent){
        HashMap<Integer, String> t = getVariable(data);
        t.put(2, percent);
        return t;
    }
    protected HashMap<Integer, String> getVariable(StringBuilder data){
        StringBuilder v = new StringBuilder();
        HashMap<Integer, String> temp = new HashMap<>();
        boolean is = false;
        int c = 0;
        for(int i = 0; i < data.length(); i ++){
            
            if(data.charAt(i) == ']'){
                temp.put(c, v.toString());
                c ++;
                v = new StringBuilder();
                is = false;
            }

            if(is){
                v.append(data.charAt(i));
            }

            if(data.charAt(i) == '['){
                is = true;
            }

        }
        return temp.isEmpty() ? null : temp;
    }
    public abstract  T indentification(I i);
}
