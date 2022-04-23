package datastructures;

import java.util.ArrayList;
import java.util.List;

public class Union<T> {
    public int size;
    public List<T> members;

    public Union() {
        this.size = 0;
        this.members = new ArrayList<>();
    }

    public void addMember(T i) {
        if(!this.members.contains(i)) {
            this.size++;
            this.members.add(i);
        }
    }

    public Union<T> combine(Union<T> u1) {
        for(T member: u1.members) {
            this.addMember(member);
        }
        return this;
    }
}