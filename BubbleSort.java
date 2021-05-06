public class BubbleSort {

    public void sort(int[] a) { //bubble sort 를 실행하는 함수
        int temp, i, j = 0;

        for (i = 0; i < a.length-1; i++) {
            for(j = 0; j < a.length-1-i; j++) {
                if (a[j] > a[j+1]) {
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }

        printArray(a);
    }

    public void printArray(int a[]) {
        for(int i = 0; i<a.length;i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void main (String[]args) {
        BubbleSort bubble = new BubbleSort(); //클래스 생성
        int a[] = {29,11,18,32,45,67,89,201,72,3,21,51,153,264,289}; //랜덤
        int b[] = {1,2,3,4,34,66,84,32,19,51,72,38,41,92,100}; //일부 정렬
        int c[] = {59,58,57,56,55,54,53,52,51,50,40,30,29,21,10}; //내림차순

        bubble.sort(a);
        bubble.sort(b);
        bubble.sort(c);
    }
}
