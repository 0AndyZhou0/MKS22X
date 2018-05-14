public class StackFrontier implements Frontier{
    MyDeque<Location> locs;

    public StackFrontier{
	locs = new MyDeque();
    }
    
    public void add(Location loc){
	locs.addFirst(loc);
    }

    public Location next(){
	locs.getFirst();
    }
}
