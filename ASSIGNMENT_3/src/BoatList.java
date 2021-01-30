public class BoatList implements Iterator{
    private Ships[] bl;
    int position = 0;

    public BoatList(Ships[] bl){
        this.bl = bl; }

    public Ships next(){
        Ships output = bl[position];
        position = position+1;
        return output;
    }

    public void setCounter(){
        this.position = 0;
    }

    public boolean hasNext(){
         /*if(position<10){
            return true;
        }else {
            return false;
        }*/

        if(position >= bl.length || bl[position] == null){
            return false;
        }else{
            return true;}

    }
}
