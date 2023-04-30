// best example of this pattern is Iterator in java library

// FM Radio Example for Iterator Design Pattern

import java.util.*;

class Channel {
    private double frequency;
    private String type;
    public Channel(double frequency, String type) {
        this.frequency = frequency;
        this.type = type;
    }
    public double getFrequency() {
        return frequency;
    }
    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    @Override
    public String toString() {
        return "Channel [frequency=" + frequency + ", type=" + type + "]";
    }
}
class ChannelIterator {
    LinkedList<Channel> collection = new LinkedList<Channel>(); 
    int currentIndex=0;
    public ChannelIterator(LinkedList<Channel> collection) {
        this.collection = collection;
    }
    public Channel getNext(){
        if(hasNext()){
            return collection.get(currentIndex++);
        }
        return null;
    }  //til hasNext is true return Channel
    public boolean hasNext(){
        return currentIndex < collection.size();
    }
}
class ChannelCollection {
    LinkedList<Channel> collection = new LinkedList<Channel>(); 
    public void addChannel(Channel c){
        collection.add(c);
    }
    public void removeChannel(Channel c){
        collection.remove(c);
    }
    public ChannelIterator getIterator(){
        ChannelIterator iterator = new ChannelIterator(collection);
        return iterator;
    }
}
public class IteratorDesignPatternDemo {
    public static void main(String[] args) {
        ChannelCollection cc = new ChannelCollection();
        cc.addChannel(new Channel(98.5, "Radio Mirchi"));
        cc.addChannel(new Channel(93.5, "RedFM"));
        cc.addChannel(new Channel(104.0, "Hangama Radio"));

        ChannelIterator iterator = cc.getIterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.getNext());
        }
    }
}