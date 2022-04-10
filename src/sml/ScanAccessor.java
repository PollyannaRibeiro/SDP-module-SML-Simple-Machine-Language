package sml;

interface ScanInt {
    int scan();
};

interface ScanString {
    String scan();
};

public class ScanAccessor {

    private ScanInt scanInt;
    private ScanString scanString;

    ScanAccessor(ScanInt scanInt, ScanString scanString){
        this.scanInt = scanInt;
        this.scanString = scanString;
    }

    public <T> Object resolve(Class<T> klass) throws RuntimeException {
        if (klass.getTypeName() == "java.lang.String") {
            return this.scanString.scan();
        } else if (klass.getTypeName() == "int") {
            return this.scanInt.scan();
        } else if (klass.getTypeName() == "sml.LabelAccessor") {
            String s = this.scanString.scan();
            return new LabelAccessor(s);
        } else {
            throw new RuntimeException("Type not found");
        }
    }
}
