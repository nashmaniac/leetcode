import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class UniqueEmailAddress {
    public int numUniqueEmails(String[] emails) {
        int count = 0;

        HashMap<String, ArrayList<String>> emailList = new HashMap<>();

        for (String s: emails) {
            String[] arr = s.split("\\@");
            String email = arr[0].split("\\+")[0].replace(".", "").trim();
            String domaing = arr[1].trim();

            if (emailList.containsKey(domaing)) {
                ArrayList<String> e = emailList.get(domaing);
                if (!e.contains(email)) {
                    e.add(email);
                }
                emailList.put(domaing, e);
            } else {
                emailList.put(domaing, new ArrayList<>(List.of(email)));
            }
        }

        for(ArrayList<String> arr: emailList.values()) {
            count += arr.size();
        }

        return count;    
    }

    public static void main(String[] aStrings) {
        UniqueEmailAddress u = new UniqueEmailAddress();
        u.numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"});
    }
}
