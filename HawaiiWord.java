package NiukeAcm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Administrator on 2017/5/9.
 */
public class HawaiiWord {
    public static void main(String[] args) {
        new HawaiiWord().run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        String pa = "aeiouhklmnpw";
        String tmp;
        int i, j;
        boolean is;
        String tmp_low;
        List<String> list = new ArrayList<>();
        for (i = 0; i < strs.length; i++) {
            tmp = strs[i];
            tmp_low = tmp.toLowerCase();
            is = true;
            for (j = 0; j < tmp_low.length(); j++) {
                if (pa.indexOf(tmp_low.charAt(j)) == -1) {
                    is = false;
                    break;
                }
            }
            if (is) {
                list.add(tmp);
            }
        }

        for (String temp : list) {
            System.out.println(temp);
        }

        System.out.println(list.toString());
    }

}
