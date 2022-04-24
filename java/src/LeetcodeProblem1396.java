import java.util.HashMap;

public class LeetcodeProblem1396 {
    class UndergroundSystem {

        HashMap<String, Integer> stationName;
        HashMap<Integer, Integer[]> customerTiming;
        HashMap<String, Double> totalTime;
        HashMap<String, Integer> count;

        public UndergroundSystem() {
            this.totalTime = new HashMap<>();
            this.stationName = new HashMap<>();
            this.customerTiming = new HashMap<>();
            this.count = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            this.stationName.put(stationName, this.stationName.getOrDefault(stationName, this.stationName.size() + 1));
            this.customerTiming.put(id, new Integer[] {
                    this.stationName.get(stationName), t,
            });
        }

        public void checkOut(int id, String stationName, int t) {
            Integer[] timing = this.customerTiming.get(id);
            this.stationName.put(stationName, this.stationName.getOrDefault(stationName, this.stationName.size() + 1));
            int travelTime = t - timing[1];
            String s = String.format("%d-%d", timing[0], this.stationName.get(stationName));
            this.totalTime.put(
                    s, this.totalTime.getOrDefault(s, 0.0) + travelTime);
            this.count.put(s, this.count.getOrDefault(s, 0) + 1);
            this.customerTiming.remove(id);
        }

        public double getAverageTime(String startStation, String endStation) {
            String s = String.format("%d-%d", this.stationName.get(startStation), this.stationName.get(endStation));
            return this.totalTime.get(s) / this.count.get(s);
        }
    }

    public static void main(String[] args) {
        LeetcodeProblem1396 l = new LeetcodeProblem1396();
        /*
         * UndergroundSystem undergroundSystem = l.new UndergroundSystem();
         * undergroundSystem.checkIn(45, "Leyton", 3);
         * undergroundSystem.checkIn(32, "Paradise", 8);
         * undergroundSystem.checkIn(27, "Leyton", 10);
         * undergroundSystem.checkOut(45, "Waterloo", 15); // Customer 45 "Leyton" ->
         * "Waterloo" in 15-3 = 12
         * undergroundSystem.checkOut(27, "Waterloo", 20); // Customer 27 "Leyton" ->
         * "Waterloo" in 20-10 = 10
         * undergroundSystem.checkOut(32, "Cambridge", 22); // Customer 32 "Paradise" ->
         * "Cambridge" in 22-8 = 14
         * System.out.println(undergroundSystem.getAverageTime("Paradise",
         * "Cambridge")); // return 14.00000. One trip
         * // "Paradise" -> "Cambridge",
         * // (14) / 1 = 14
         * System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
         * // return 11.00000. Two trips
         * // "Leyton" -> "Waterloo", (10 + 12)
         * // / 2 = 11
         * undergroundSystem.checkIn(10, "Leyton", 24);
         * System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
         * // return 11.00000
         * undergroundSystem.checkOut(10, "Waterloo", 38); // Customer 10 "Leyton" ->
         * "Waterloo" in 38-24 = 14
         * System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));
         * // return 12.00000. Three trips
         * // "Leyton" -> "Waterloo", (10 + 12
         * // + 14) / 3 = 12
         * 
         */

        UndergroundSystem undergroundSystem = l.new UndergroundSystem();
        undergroundSystem.checkIn(10, "Leyton", 3);
        undergroundSystem.checkOut(10, "Paradise", 8); // Customer 10 "Leyton" -> "Paradise" in 8-3 = 5
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise")); // return 5.00000, (5) / 1 = 5
        undergroundSystem.checkIn(5, "Leyton", 10);
        undergroundSystem.checkOut(5, "Paradise", 16); // Customer 5 "Leyton" -> "Paradise" in 16-10 = 6
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise")); // return 5.50000, (5 + 6) / 2 = 5.5
        undergroundSystem.checkIn(2, "Leyton", 21);
        undergroundSystem.checkOut(2, "Paradise", 30); // Customer 2 "Leyton" -> "Paradise" in 30-21 = 9
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Paradise")); // return 6.66667, (5 + 6 + 9) / 3 = 6.66667
    }
}
