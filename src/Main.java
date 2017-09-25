import java.io.*;

/**
 * Created by noble on 2017-09-14.
 *
 * 실행전 인자로 정렬하고싶은 txt 파일 이름을 인자로 넘겨준다. ex ) programArgument = "10000.txt"
 */
public class Main {
    public static void main(String argv[]) {
        String fileName = argv[0];
        String path = Main.class.getResource("").getPath();
        File inFile = new File(path+fileName);
        File outFile = new File(path+"201100964_output.txt");
        BufferedWriter bw = null;
        BufferedReader br = null;
        long start;     // 측정 시작 시간
        long end;       // 측정 종료 시간

        InsertionSort insert;
        MergeSort merge;
        try {
            br = new BufferedReader(new FileReader(inFile));
            bw = new BufferedWriter(new FileWriter(outFile));
            String line;
            if ((line = br.readLine()) != null) {
                merge = new MergeSort(line);
                insert = new InsertionSort(line);

                /*시간 기록*/
                start = System.currentTimeMillis();
                merge.sort();
                end = System.currentTimeMillis();
                System.out.println("merge.sort() 실행 시간 : " + (end - start)/1000.0);

                start = System.currentTimeMillis();
                insert.sort();
                end = System.currentTimeMillis();
                System.out.println("insert.sort() 실행 시간 : " + (end - start)/1000.0);

                /* output.txt에 기록할 방식을 설정하세요*/
                /* runtime이 30분을 넘어가서 주석처리했습니다.*/
//                if(insert.isSorted()) {
//                    bw.write(insert.toString());
//                }
//                if (merge.isSorted()) {
//                    bw.write(merge.toString());
//                }


                /* Insertion Sort 에 구현한 Binary Search 예시*/
//                System.out.println("찾는 숫자: 45,  서치 결과 : " + insert.search(45) );
            }
            bw.flush();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br != null) try {br.close(); } catch (IOException e) {}
            if(bw != null) try {bw.close(); } catch (IOException e) {}
        }
    }
}
