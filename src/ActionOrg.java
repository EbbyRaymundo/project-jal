public class ActionOrg {
    public static void start(){
        
    }
    public static  void action1(){

    }
    public static void action2(){
        
    }
    public static void action3(){
        
    }
    public static void action4(){
        
    }
    public static void dispSet(String text){
        GUI.prompt.setText(text);
    }

    public static void choiceSet(int i, String text){
        if(i == 0){
            GUI.label1.setText(text);
        }
        else if(i == 1){
            GUI.label2.setText(text);
        }
        else if(i ==2){
            GUI.label3.setText(text);
        }
        else if(i==3){
            GUI.label4.setText(text);
        }
    }
}