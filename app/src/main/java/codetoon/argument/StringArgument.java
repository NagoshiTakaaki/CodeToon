package codetoon.argument;


import codetoon.system.Player;

public class StringArgument extends Argument<String, String> {
    private static final StringArgument instance= new StringArgument();
    private StringArgument(){}
    @Override
    public String indentification(String s) {
        StringBuilder builder = new StringBuilder().append(s);
        if(builder.charAt(0) == '\"'){
             return convertStringAll(builder);
        }else{
            return convertVariableTo(s);
        }
    }
    public String indentification(String s, Player p){
        host = p;
        return indentification(s);
    }

    public String convertStringAll(StringBuilder s){
        StringBuilder t = new StringBuilder();
        for(int i = 1; i < s.length(); i ++){
            if(s.charAt(i) != '\"'){
                t.append(s.charAt(i));
            }
        
        }
        return t.toString();
    }

    public static StringArgument getInstance() {
        return new StringArgument();
    }

    @Override
    public String getSample() {
        return "";
    }
}
