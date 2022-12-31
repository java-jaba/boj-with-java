package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 1018. 체스판 다시 칠하기
public class Boj1018 {

    public static boolean[][] arr;
    public static int min = 64; // 다시 칠해야 하는 개수의 최대를 지정 (8*8)

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        arr = new boolean[N][M];

        // 배열 입력 W : true, B : false
        for(int i=0; i<N; i++){
            String str = br.readLine();

            for(int j=0; j<M; j++){
                if(str.charAt(j) == 'W'){
                    arr[i][j] = true;
                }else{
                    arr[i][j] = false;
                }
            }
        }

        /**
         * 경우의 수 설정
         * 경우의 수 = 2 * (가로 칸 개수 -7) * (세로 칸 개수 -7)
         * 2를 곱해주는 이유는 첫 칸이 하얀색일 경우, 검정색일 경우를 나누기 위함이다.
         * 최소 크기가 8*8일 때가 경우의 수 1이기 때문에 각 가로 세로 별 길이에 7을 빼준다.
         */
        int nRow = N - 7;
        int mCol = M - 7;

        for(int i=0; i<nRow; i++){
            for(int j=0; j<mCol; j++){
                checkChessBoard(i, j);
            }
        }

        // 최소값 출력
        System.out.println(min);

    }

    public static void checkChessBoard(int x, int y){

        // chessboard 시작 지점을 x, y로 지정하고 시작한다.
        int endX = x + 8;
        int endY = y + 8;
        int count = 0;

        boolean bkColor = arr[x][y]; // chessboard 첫 번째 칸의 색

        for(int i=x; i<endX; i++){
            for(int j=y; j<endY; j++){

                // bkColor와 현재 체스판 색이 다를 경우에 count 1 증가
                if(arr[i][j] != bkColor){
                    count++;
                }

                //다음 칸은 색이 바뀌므로 true -> false, false -> true
                bkColor = (!bkColor);
            }
            bkColor = (!bkColor);
        }

        /**
         * @reason : 경우의 수를 구할 때 2를 곱해준 이유
         * 첫 번째 칸을 기준으로 할 때 색칠 할 개수(count)와
         * 첫 번째 칸과 반대되는 색을 기준으로 할 때 색칠 할 개수(64-count)
         * 중에서 최소값을 count 에 저장한다.
          */
        count = Math.min(count, 64-count);

        /**
         * 최소값 갱신하기
         */
        min = Math.min(min, count);

    }

}
