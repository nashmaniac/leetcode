package datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnionFind {

    int nodeCount;
    int[] id;
    int[] size;
    int numComponents;

    public UnionFind(int n) {
        this.nodeCount = this.numComponents = n;
        this.id = new int[n];
        this.size = new int[n];

        for (int i = 0; i < n; i++) {
            this.id[i] = i;
            this.size[i] = 1;
        }
    }

    public int find(int p) {
        int root = p;
        while (root != id[root]) {
            root = id[root];
        }

        while (p != root) {
            int next = id[p];
            id[p] = root;
            p = next;
        }

        return root;
    }

    public void unify(int i, int j) {
        int root1 = find(i);
        int root2 = find(j);

        if (size[root1] <= size[root2]) {
            size[root2] += size[root1];
            id[root1] = root2;
        } else {
            size[root1] += size[root2];
            id[root2] = root1;
        }
        this.numComponents--;
    }

    public boolean isConnected(int i, int j) {
        return find(i) == find(j);
    }

    public int componentCount() {
        return this.numComponents;
    }

    public int size(int i) {
        return this.size[find(i)];
    }

    public List<Integer> findMembers(int i) {
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < this.nodeCount; j++) {
            if(this.id[j] == i) {
                result.add(j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        char[] nodes = new char[] {
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
        };

        int n = nodes.length;
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hashMap.put(nodes[i], i);
        }

        UnionFind u = new UnionFind(n);
        u.unify(hashMap.get('a'), hashMap.get('b'));
        u.unify(hashMap.get('b'), hashMap.get('d'));
        u.unify(hashMap.get('c'), hashMap.get('f'));
        u.unify(hashMap.get('c'), hashMap.get('i'));
        u.unify(hashMap.get('j'), hashMap.get('e'));
        u.unify(hashMap.get('g'), hashMap.get('j'));

        int groupCount = u.componentCount();
        System.out.println(groupCount);

        for(int i=0;i<n;i++) {
            List<Integer> result = u.findMembers(i);
            if(result.size() > 0) {
                for(int j: result) {
                    System.out.printf("%c ", nodes[j]);
                }
                System.out.println();
            }
            
        }

        System.out.println(u.isConnected(hashMap.get('a'), hashMap.get('b')));
        System.out.println(u.isConnected(hashMap.get('a'), hashMap.get('h')));


    }
}
