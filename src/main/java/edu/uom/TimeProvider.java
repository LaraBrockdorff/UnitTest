package edu.uom;

public interface TimeProvider {
    public final static int MORNING =0;
    public final static int AFTERNOON =1 ;
    public final static int EVENING =2 ;

    public int getTimeSegment();
}
