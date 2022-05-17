package domain;

import java.util.ArrayList;

public class BinaryMinHeap<E extends Comparable<E>> {
    private ArrayList<E> values;

    private boolean isEmpty() {
        return values == null || values.size() == 0;
    }

    public void print() {
        if (this.isEmpty())
            System.out.println("De heap is leeg");
        else
            System.out.println(values);
    }

    public E getMin() {
        if (this.isEmpty())
            throw new IllegalStateException("Kan niet zoeken in een lege heap");
        return values.get(0);
    }

    public boolean addValue(E value) {
        // geen null toevoegen aan de heap
        if (value == null) throw new IllegalArgumentException();
        // indien de heap leeg is: eerst initialiseren
        if (this.isEmpty())
            values = new ArrayList<E>();

        values.add(value);//achteraan toevoegen
        this.bubbleUp();//bubbleUp vanaf de laatste zie slides theorie
        return true;
    }

    private void bubbleUp() {
        //TO DO : oefening 4
        int index = this.values.size() - 1;
        E parent = values.get(((index-1)/2));
        E lastElement = values.get(index);
        while(values.get(index).compareTo(parent)<0){
            values.set(values.indexOf(parent), lastElement);
            values.set(index, parent);
            index = values.indexOf(lastElement);
            parent=values.get(((index-1)/2));
        }
    }

    public E removeSmallest() {
        if (this.isEmpty())
            throw new IllegalStateException("Kan niets verwijderen uit een lege boom");
        E res = this.getMin();// res bevat de kleinste = eerste element van de lijst
        this.values.set(0, this.values.get(this.values.size() - 1));// verwissel eerste met de laatste
        this.values.remove(this.values.size() - 1); // verwijder de laatste
        this.bubbleDown(); // bubble down van eerste naar beneden zie theorie
        return res;
    }

    private void bubbleDown() {
        // TODO zie oefening 5
        int index =0;
        boolean wisselOK = true;
        while(2*index+1<values.size() && wisselOK){
            int indexKleinste = 2*index+1;
            if(2*index+2<values.size() && values.get(indexKleinste).compareTo(values.get(2*index+2))>0){
                indexKleinste=2*index+2;
            }
            if(values.get(index).compareTo(values.get(indexKleinste))>0){
                this.wisselOm(index, indexKleinste);
            }
            else{
                wisselOK = false;
            }
            index = indexKleinste;
        }
    }

    private void wisselOm(int i, int j) {
    //wissel i-de en j-de element in de ArrayList om
        E hulp = this.values.get(i);
        this.values.set(i, this.values.get(j));
        this.values.set(j, hulp);
    }

    public ArrayList<E> getPath(E value) {
        // TODO zie oefening 6;
        return null;
    }
}
