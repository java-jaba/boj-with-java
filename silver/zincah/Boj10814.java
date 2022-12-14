package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// 백준 10814. 나이순 정렬
public class Boj10814 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Member> list = new ArrayList<>();

        // 입력된 나이와 이름을 Member class에 저장하고 가입한 순서 역시 join에 저장한다.
        for(int i=0; i<N; i++){
            String[] arr = br.readLine().split(" ");
            int age = Integer.parseInt(arr[0]);
            String name = arr[1];
            int join = i;
            Member member = new Member(age, name, join);
            list.add(member);
        }

        // Collections.sort를 활용해서 나이가 같을 경우에는 가입날짜를 오름차순,
        // 나이가 같지 않을 경우에는 나이를 오름차순으로 정렬한다.
        Collections.sort(list, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                if(o1.age == o2.age){
                    return o1.join - o2.join;
                }else{
                    return o1.age - o2.age;
                }
            }
        });

        // 리스트 출력
        for(int i=0; i<list.size(); i++){
            Member member = list.get(i);
            System.out.println(member.age + " " + member.name);
        }
    }
}

class Member{
    public int age; // 나이
    public String name; // 이름
    public int join; // 가입한 날짜

    public Member(int age, String name, int join){
        this.age = age;
        this.name = name;
        this.join = join;
    }

}