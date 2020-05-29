import java.util.*;

/**
 * @program: 2020528
 * @description
 * @author: mrs.yang
 * @create: 2020 -05 -28 13 :37
 */
public class TestDemo{
    public List<String> topKFrequent(String[] words, int k){
        Map<String,Integer> map=new HashMap<>();
        for (String s:words) {
            if(!map.containsKey(s)){
                map.put(s,1);
            }else{
                int val=map.get(s);
                map.put(s,val+1);
            }
        }
        PriorityQueue<Map.Entry<String,Integer>> minHeap=new PriorityQueue<>
                (new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        return o1.getValue()==o2.getValue()?o2.getKey().compareTo(o1.getKey())
                        :o1.getValue().compareTo(o2.getValue());
                    }
        });
        //将map中元素放入小堆中
        for (Map.Entry<String,Integer> entry:map.entrySet()) {
            minHeap.offer(entry);
        }
        List<String> ret=new ArrayList<>();
        for (int i = 0; i < k; i++) {
           ret.add(minHeap.poll().getKey());
        }
        Collections.sort(ret,(o1,o2)-> map.get(o2)-map.get(o1)==0?
                o2.compareTo(o1):map.get(o1)-map.get(o2));
        return ret;
    }
    //前K个高频单词
    public List<String> topKFrequent1(String[] words, int k) {
        Map<String,Integer> map=new HashMap<>();
        for (String s:words) {
            if(!map.containsKey(s)){
                map.put(s,1);
            }else{
                int val=map.get(s);
                map.put(s,val+1);
            }
        }
        PriorityQueue<Map.Entry<String,Integer>> minHeap=new PriorityQueue<>
                (new Comparator<Map.Entry<String,Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        if(o1.getValue()==o2.getValue()){//如果出现次数相同,按单词顺序排序
                            return o2.getKey().compareTo(o1.getKey());
                        }else{//次数不同，按次数多的排序
                            return o1.getValue().compareTo(o2.getValue());
                        }
                    }
                });
        for (Map.Entry<String,Integer> entry:map.entrySet()) {
            minHeap.offer(entry);
            while(minHeap.size()>k){
                minHeap.poll();
            }
        }
        List<String> ret=new ArrayList<>();
        while(!minHeap.isEmpty()){
            ret.add(minHeap.poll().getKey());
        }
        Collections.sort(ret,(o1,o2)-> map.get(o2)-map.get(o1)==0?
                o1.compareTo(o2):map.get(o2)-map.get(o1));
        return ret;
    }
    /*public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ret=new ArrayList<>();
        if(arr.length==0||k==0){
            return ret;
        }
      /*PriorityQueue<Integer> maxHead=new PriorityQueue<>(new Comparator<Integer>() {
          @Override
          public int compare(Integer o1, Integer o2) {
              return Math.abs(o2)-Math.abs(o1) ;
          }
      });

    }
}*/
    //石头和宝石
    public int stones(String J,String S){
        Set<Character> set=new HashSet<>();
        for (char v:J.toCharArray()) {
            set.add(v);
        }
        int count=0;
        for (char s:S.toCharArray()) {
            if(set.contains(s)){
                count++;
            }
        }
        return count;
    }
    //坏键盘
    public static void main(String[] args){
     Scanner scan=new Scanner(System.in);
     String expected=scan.nextLine();
     String actual=scan.nextLine();
     Set<Character> set=new HashSet<>();
        for (char val:actual.toUpperCase().toCharArray()) {
            set.add(val);
        }
        for (char exc:expected.toUpperCase().toCharArray()) {
            Set<Character> set1=new HashSet<>();
            if(!set.contains(exc)&&!set1.contains(exc) ){
                System.out.print(exc);
                set.add(exc);
            }
        }
    }
}

