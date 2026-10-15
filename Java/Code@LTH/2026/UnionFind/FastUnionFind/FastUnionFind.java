/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fastunionfind;
import java.io.IOException;
import java.io.InputStream;

public class FastUnionFind {
    static int[] parent;

    // ---- fast input ----
    static final InputStream IN = System.in;
    static final byte[] buf = new byte[1 << 16];
    static int bufLen = 0, bufPtr = 0;

    static int readByte() throws IOException {
        if (bufPtr == bufLen) {
            bufLen = IN.read(buf, 0, buf.length);
            bufPtr = 0;
            if (bufLen <= 0) {
                bufLen = 0;
                return -1;
            }
        }
        return buf[bufPtr++];
    }

    static int readInt() throws IOException {
        int c = readByte();
        while (c != -1 && c <= ' ') {
            c = readByte();
        }
        boolean neg = false;
        if (c == '-') {
            neg = true;
            c = readByte();
        }
        int result = 0;
        while (c >= '0' && c <= '9') {
            result = result * 10 + (c - '0');
            c = readByte();
        }
        return neg ? -result : result;
    }

    static int readOperator() throws IOException {
        int c = readByte();
        while (c != -1 && c <= ' ') {
            c = readByte();
        }
        return c;
    }

    // ---- union-find: path halving, union by size, sizes stored as negatives at roots ----
    static int find(int x) {
        while (true) {
            int p = parent[x];
            if (p < 0) {
                return x;           // x is a root
            }
            int g = parent[p];
            if (g < 0) {
                return p;           // parent is the root
            }
            parent[x] = g;          // skip over the parent
            x = g;                  // jump to the grandparent
        }
    }

    static void merge(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return;
        }
        if (parent[a] > parent[b]) { // a's tree is smaller (less negative)
            int t = a;
            a = b;
            b = t;
        }
        parent[a] += parent[b];      // a is the larger root: add sizes
        parent[b] = a;
    }

    public static void main(String[] args) throws IOException {
        int n = readInt();
        int q = readInt();
        parent = new int[n + 1];     // supports both 0..n-1 and 1..n labelling
        java.util.Arrays.fill(parent, -1);

        byte[] out = new byte[4 * q + 4];
        int outLen = 0;

        for (int i = 0; i < q; i++) {
            int op = readOperator();
            int a = readInt();
            int b = readInt();
            if (op == '=') {
                merge(a, b);
            } else {
                if (find(a) == find(b)) {
                    out[outLen++] = 'y';
                    out[outLen++] = 'e';
                    out[outLen++] = 's';
                } else {
                    out[outLen++] = 'n';
                    out[outLen++] = 'o';
                }
                out[outLen++] = '\n';
            }
        }
        System.out.write(out, 0, outLen);
        System.out.flush();
    }
}

