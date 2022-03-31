import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
  class Inventory {
    String city;
    int jCount;
    int hCount;
    int sCount;

    public Inventory(String c, int j, int h, int s) {
      this.city = c;
      this.jCount = j;
      this.hCount = h;
      this.sCount = s;
    }

    public boolean matchInventory(Map<Character, Integer> map) {
      for (Map.Entry<Character, Integer> entry : map.entrySet()) {

        if (entry.getKey() == 'J') {
          if (entry.getValue() > this.jCount) {
            return false;
          }
        }

        if (entry.getKey() == 'H') {
          if (entry.getValue() > this.hCount) {
            return false;
          }
        }

        if (entry.getKey() == 'S') {
          if (entry.getValue() > this.sCount) {
            return false;
          }
        }

      }
      return true;
    }

    public static void main(String[] args) {
      List<Inventory> inventory = new ArrayList<>();

      HashMap<Character, Integer> sampleOrder = (HashMap<Character, Integer>) Map.of('J', 3, 'H', 2, 'S', 4);
      List<String> output = new ArrayList<String>();

      for (Inventory i : inventory) {
        if (i.matchInventory(sampleOrder)) {
          output.add(i.city);
        }
      }

      System.out.println(output.toString());
    }
  }
}