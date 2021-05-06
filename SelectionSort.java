public class SelectionSort {

    public void sort(int a[]) { //selection sort 를 실행하는 함수
        int index, temp, i, j;

        for(i = 0; i < a.length-1; i++) {
            index = i;
            for(j = i + 1; j < a.length; j++) {
                if(a[index] > a[j]) index = j;
            }
            temp = a[index];
            a[index] = a[i];
            a[i] = temp;
        }

        printArray(a);
    }

    public void printArray(int a[]) {
        for(int i = 0; i<a.length;i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SelectionSort select = new SelectionSort();
        int a[] = {29,11,18,32,45,67,89,201,72,3,21,51,153,264,289}; //랜덤
        int b[] = {1,2,3,4,34,66,84,32,19,51,72,38,41,92,100}; //일부 정렬
        int c[] = {59,58,57,56,55,54,53,52,51,50,40,30,29,21,10}; //내림차순

        select.sort(a);
        select.sort(b);
        select.sort(c);
    }
}
