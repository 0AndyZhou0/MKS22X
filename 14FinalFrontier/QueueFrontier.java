public class QueueFrontier implements Frontier{
    MyDeque<Location> locs;

    public QueueFrontier{
	locs = new MyDeque();
    }
    
    public void add(Location loc){
	locs.addLast(loc);
    }

    public Location next(){
	locs.getFirst();
    }
}
