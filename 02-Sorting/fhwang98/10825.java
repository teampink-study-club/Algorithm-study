import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        Student[] students = new Student[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            students[i] = new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(students, new Comparator<Student>() {
            /**
             * 국어 점수가 감소하는 순서로
             * 국어 점수가 같으면 영어 점수가 증가하는 순서로
             * 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
             * 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로
             */
            @Override
            public int compare(Student o1, Student o2) {
              if (o1.kr == o2.kr && o1.eng == o2.eng && o1.math == o2.math) {
                  return o1.name.compareTo(o2.name);
              }
              if (o1.kr == o2.kr && o1.eng == o2.eng) {
                  return o2.math - o1.math;
              }
              if (o1.kr == o2.kr) {
                  return o1.eng - o2.eng;
              }
              return o2.kr - o1.kr;
            }
        });

        for (int i = 0; i < N; i++) {
            bw.write(students[i].name);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class Student {
    String name;
    int kr;
    int eng;
    int math;

    Student(String name, int kr, int eng, int math) {
        this.name = name;
        this.kr = kr;
        this.eng = eng;
        this.math = math;
    }
}

