package shu_ju_liu_zhong_de_zhong_wei_shu;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
    Queue<Integer> minHeap;
    Queue<Integer> maxHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
    }

    public void addNum(int num) {
        if(minHeap.size() == maxHeap.size()){
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }else{
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        double ans = 0 ;
        if(maxHeap.size() == minHeap.size()){
            ans = (maxHeap.peek() + minHeap.peek() + 0.0) / 2;
        }else{
            ans = maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
        }
        return ans;
    }
    
    public static void main(String [] args) {
    	String ss = "shu-ju-liu-zhong-de-zhong-wei-shu";
    	System.out.println(ss.replace('-', '_'));
    	
    	MedianFinder s = new MedianFinder();
    	//System.out.println("main : "+s.isNumber("6e6.5"));
	}
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */