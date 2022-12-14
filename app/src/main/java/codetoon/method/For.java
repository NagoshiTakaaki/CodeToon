package codetoon.method;

import codetoon.argument.BooleanArgumet;
import codetoon.argument.IntegerArgument;
import codetoon.argument.ObjectArgument;
import codetoon.argument.StringArgument;
import codetoon.system.CodeToon;
import codetoon.system.Message;
import codetoon.system.Player;
import codetoon.util.converter.ConvertSource;
import codetoon.util.converter.ConvertVariable;
import codetoon.variable.Variables;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;

public class For extends MyMethod{
    String bool;
    String integer;
    String lamda;
    public String inside;

    @Override
    public Object newInstance() {
        return new For();
    }

    @Override
    public String set(@NotNull HashMap<Integer, String> map) {
        integer = map.get(0);
        bool = map.get(1);
        lamda = map.get(2);
        inside = map.get(CodeToon.INSIDE_METHODS);
        return null;
    }

    @Override
    public void action(Player host) {
        PrivateNewVariable p = (PrivateNewVariable) ConvertVariable.convert(integer, host);
        p.action(host);
        //System.out.println(Variables.VARIABLE.getThis(p.id).action());
        ArrayList<MyMethod> methods = ConvertSource.convert(inside, host);
        Message.popMessage(methods);
        while (BooleanArgumet.getInstance().indentification(bool, host)){

            methods = ConvertSource.convert(inside, host);
            if(!methods.isEmpty()){
                for(int l = 0; l < methods.size(); l ++){
                    methods.get(l).action(host);
                }
            }
            ConvertVariable.convert(lamda, host).action(host);
        }
        Message.pushMessage();
    }
}
