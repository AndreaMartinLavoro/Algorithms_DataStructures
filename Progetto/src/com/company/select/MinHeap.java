package com.company.select;

import java.util.ArrayList;
import java.util.Collections;

public class MinHeap {
    private ArrayList<Integer> heap;
    private int heapsize;

    public int getHeapsize() {
        return heapsize;
    }

    public MinHeap() {
        this.heapsize = 0;
        this.heap = new ArrayList<>();
    }

    public MinHeap(ArrayList<Integer> vett) {
        this.heapsize = vett.size();
        this.heap = new ArrayList<>();

        this.heap.addAll(vett);
        this.buildMinHeap();
    }

    public void eraseHeap(){
        heap.clear();
    }

    private int parent(int pos) {
        return (pos - 1) / 2;
    }

    public int leftChild(int pos) {
        return 2 * pos + 1;
    }

    public int rightChild(int pos) {
        return 2 * pos + 2;
    }

    //Restituisce la radice della minHeap(che corrisponde al minimo)
    public int getRoot(){
        return this.heap.get(0);
    }

    private void swap(int fpos, int spos) {
        Collections.swap(this.heap, fpos, spos);
    }

    // Function to heapify the node at pos
    private void heapify(int pos) {
        int sx = leftChild(pos);
        int dx = rightChild(pos);
        int m;

        if(sx < this.heapsize && this.heap.get(sx) < this.heap.get(pos)){
            m = sx;
        }else{
            m = pos;
        }

        if(dx < this.heapsize && this.heap.get(dx) < this.heap.get(m)){
            m = dx;
        }

        if(m != pos){
            swap(pos, m);
            heapify(m);
        }
    }

    public void insert(int element) {
        int i;

        this.heapsize += 1;
        this.heap.add(element);

        i = this.heapsize - 1;

        while(i >= 0 && this.heap.get(i) < this.heap.get(parent(i))){
           swap(i, parent(i));
           i = parent(i);
       }
    }

    public void printVett() {
        for (int i = 0; i < this.heapsize; i++) {
            System.out.print(this.heap.get(i));
        }
        System.out.println("\n");
    }

    public void buildMinHeap() {
        for (int pos = (this.heapsize / 2) - 1; pos >= 0; pos--)
            this.heapify(pos);
    }

    public void deleteMin() {
        swap(0, this.heapsize - 1);
        this.heapsize -= 1;
        heapify(0);
        int min = this.heap.get(heapsize);
        //System.out.println("Minimo: " + min);
        this.heap.remove(this.heapsize);
    }

    public Integer ithElem(int index){
        if(index < this.heapsize)
            return this.heap.get(index);
        else
            return null;
    }

    public int getMinIndex(int elem, int index_min) {
        for(int i = 0; i<this.heapsize; i++){
            if((index_min!=-1)&&(elem!=this.heap.get(index_min))){
                index_min = 0;
            }
            if((this.heap.get(i)==elem)&&(i>index_min)){
                return i;
            }
        }
        return -1;
        //return this.heap.indexOf(elem);
    }
}