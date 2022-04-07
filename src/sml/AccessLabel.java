package sml;

public class AccessLabel{
    String   label;
    public AccessLabel(String l){
        this.label = l;
    }
    public int getLabelIndexOf(Machine m){
        return m.getLabels().indexOf(this.label);
    }

}
