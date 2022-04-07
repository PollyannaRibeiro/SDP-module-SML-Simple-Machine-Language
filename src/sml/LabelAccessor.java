package sml;

public class LabelAccessor {
    String   label;
    LabelAccessor(String l){
        this.label = l;
    }

    public String getLabel(){
        return this.label;
    }
    public int getLabelIndexOf(Machine m){
        return m.getLabels().indexOf(this.label);
    }

}
