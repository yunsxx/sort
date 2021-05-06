public class ShellSort {
    public void sort(int a[]) { // shell sort 를 실행하는 함수
        int size = a.length;
        int gap = size / 2;
        int i, j;

        for(; gap > 0; gap /= 2) { //gap 의 크기를 점점 줄여 나가면서 부분리스트가 다르게 구성됨
            for(i = gap; i < size; i++) {
                int temp = a[i]; //현재 gap 이 가리키는 인덱스의 요소를 temp 에 넣고

                for(j = i; (j >= gap)&&(a[j-gap]>temp); j -= gap) //같은 gap 을 가진 인덱스의 요소들의 크기를 비교해서
                    a[j] = a[j-gap]; //오름차순으로 정렬시키고

                a[j] = temp; //정렬이 완료되면 temp 에 넣었던 값을 현재 j가 가리키는 인덱스 위치에 넣어줌
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

    public static void main(String[] args) {
        ShellSort shell = new ShellSort();
        int a[] = {29,11,18,32,45,67,89,201,72,3,21,51,153,264,289}; //랜덤
        int b[] = {1,2,3,4,34,66,84,32,19,51,72,38,41,92,100}; //일부 정렬
        int c[] = {59,58,57,56,55,54,53,52,51,50,40,30,29,21,10}; //내림차순

        shell.sort(a);
        shell.sort(b);
        shell.sort(c);
    }
}
