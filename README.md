---
layout: single
title: "Sort"
date: 2021-05-06 15:14
categorise: jekyll update

---

### sort(bubble, insertion, selection, shell)

1. Bubble Sort 

:: 배열의 i번 째 요소 i+1번 째 요소를 비교하여 i번 째 요소가 i+1번 째요소보다 크다면 둘의 위치를 바꿔가면서 오름차순으로 정리하는 sort.

:: 한 번 cycle을 진행했을 때 배열의 **마지막 인덱스에는 배열 안의 숫자들 중 가장 큰 값이 위치하게 된다.**

:: (두 번째 for문에 의해서) cycle이 한 번 진행될 때 요소들을 비교하는 횟수가 1씩 감소하게 된다. 

-> 마지막 인덱스부터 차례대로 큰 수가 위치하게 되기 때문에 그 부분을 시키기 위해서 

![bubble sort](https://user-images.githubusercontent.com/80511175/117262110-df998700-ae8b-11eb-9bfe-de302f6dd968.png)

------------------------------

**bubble sort**의 전체적인 코드

```
public class BubbleSort {

    public void sort(int[] a) { //bubble sort를 실행하는 함수
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
```

![bubble결과](https://user-images.githubusercontent.com/80511175/117254667-9f360b00-ae83-11eb-9bad-d01b523cae46.png)





2. Selection Sort

:: 가장 작은 수를 찾아서 지정된 인덱스의 요소와 위치를 바꾸는 sort.

:: 정렬이 된 부분을 제외한 맨 왼쪽의 요소가 자리를 바꾸고, 

위치를 바꿀 요소의 인덱스를 오른쪽 리스트에서 찾아서 결과적으로 서로의 위치를 바꿔준다. 

(여기서 위치를 바꿀 요소는 남아있는 오른쪽 리스트에서 가장 작은 수가 된다.)

:: 왼쪽은 정렬이 된 상태가 되고, 오른쪽은 정렬리 이루어지지 않은 상태로 남아있게 된다. 

![20210506_170150](https://user-images.githubusercontent.com/80511175/117263006-cd6c1880-ae8c-11eb-88be-6b4bade8f184.png)

------------------------

**Selection Sort**의 전체적인 코드

```
public class SelectionSort {

    public void sort(int a[]) { //selection sort 를 실행하는 함수
        int index, temp, i, j;

        for(i = 0; i < a.length-1; i++) {
            index = i;
            for(j = i + 1; j < a.length; j++) {
                if(a[index] > a[j]) index = j;//작은 수의 인덱스를 index에 저장
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
```

![selection 결과](https://user-images.githubusercontent.com/80511175/117254750-bffe6080-ae83-11eb-875e-301ea0f3a282.png)





3. Insertion Sort

:: 정렬 시키고자 하는 요소가 들어갈 위치를 선정하여 그 위치에 요소를 넣어주는 개념의 sort.

:: 왼쪽과 오른쪽으로 나눠 정렬이 된, 정렬이 되지 않은 리스트 부분으로 분리한다. (진짜로 나누는 건 아님)

:: 따라서 인덱스 1에서부터 비교를 시작한다.

![20210506_170650](https://user-images.githubusercontent.com/80511175/117263685-7b77c280-ae8d-11eb-9f1a-53e266c7011f.png)

----------------

**Insertion Sort**의 전체적인 코드

```
public class InsertionSort {

    public void sort(int a[]) { //insertion sort 를 실행하는 함수
        int i, j, current;

        for(i = 1; i < a.length; i++) {
            current = a[i];
            j = i-1;
            while( (j>=0) && (current < a[j]) ) {
                a[j+1] = a[j];
                j = j - 1;
            }
            a[j+1] = current;
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
       InsertionSort insert = new InsertionSort();
        int a[] = {29,11,18,32,45,67,89,201,72,3,21,51,153,264,289}; //랜덤
        int b[] = {1,2,3,4,34,66,84,32,19,51,72,38,41,92,100}; //일부 정렬
        int c[] = {59,58,57,56,55,54,53,52,51,50,40,30,29,21,10}; //내림차순

        insert.sort(a);
        insert.sort(b);
        insert.sort(c);
    }
}

```

![insertion 결과](https://user-images.githubusercontent.com/80511175/117254714-b1b04480-ae83-11eb-9d3f-2a8fee30fd76.png)





4. Shell Sort

:: 다른 sort들과 다르게 **gap**이 존재한다. 

:: gap에 따라서 부분 리스트가 만들어지고, 부분 리스트에 있는 요소들을 정렬시킨다. 

gap의 값은 점차적으로 줄어들게 되면서 부분리스트도 그에 따라 바뀌게 된다.

:: **부분적으로 정렬이 이루어지면서** 결과적으로 전체적인 정렬이 이루어지게 되는 sort

![20210506_171110](https://user-images.githubusercontent.com/80511175/117264348-1b355080-ae8e-11eb-8539-d6229821200a.png)

---------------------

**Shell Sort**의 전체적인 코드

```
public class ShellSort {
    public void sort(int a[]) { // shell sort 를 실행하는 함수
        int size = a.length;
        int gap = size / 2;
        int i, j;

        for(; gap > 0; gap /= 2) { //gap 의 크기를 점점 줄여 나가면서 부분리스트가 다르게 구성됨
            for(i = gap; i < size; i++) {
                int temp = a[i]; //현재 gap 이 가리키는 인덱스의 요소를 temp 에 넣고

                for(j = i; (j >= gap)&&(a[j-gap]>temp); j -= gap) 
                //같은 gap 을 가진 인덱스의 요소들의 크기를 비교해서
                    a[j] = a[j-gap]; //오름차순으로 정렬시키고

                a[j] = temp; 
                //정렬이 완료되면 temp 에 넣었던 값을 현재 j가 가리키는 인덱스 위치에 넣어줌
            }
        }

        printArray(a);
    }

    public void printArray(int a[]) {
        for(int i = 0; i<a.length;i++) {
            System.out.print(a[i]+" ");
        }
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
```

![shell 결과](https://user-images.githubusercontent.com/80511175/117254794-d1e00380-ae83-11eb-9a31-905a78531176.png)



------------------------------------------------------

### <성능분석>

#### Bubble sort

:: 시간복잡도는 (n-1) + (n-2) + (n-3) + ... + 2 + 1 = n(n-1) / 2 이므로

O(N^2) x O(1) = **O(N^2)**가 된다.

:: 어느 정도 정렬이 되어있는 상태에서도 모든 요소들을 비교하는 횟수는 같지만, 

요소의 위치를 바꾸는 데에 시간은 상수값만큼 줄어들게 된다. 

따라서 실행 과정에 차이점은 있어도 시간 복잡도의 큰 차이점은 나타나지 않는다.



#### Selection sort

:: 두 번째 for문에서 요소들의 크기를 비교하고 위치를 바꾸는 부분에서 

점자척으로 정렬이 되면서 비교하는 횟수가 줄어들게 된다. 

(n-1) + (n-2) + (n-3) + ... + 3 + 2 + 1 = n(n-1)/2

따라서 시간복잡도는 O(N^2) x O(1) = **O(N^2)**가 된다.

:: 자신보다 작은 요소를 찾기 위해서 비교하는 횟수는 변화없지만, 

요소의 위치를 바꾸는 데에 걸리는 상수시간 만큼의 변화가 일어난다. 

ex) 일부 정렬이 되어있거나, 완전히 정렬이 되어있거나... 하면 위치를 바꾸는 데에 시간이 덜 소요된다. 



#### Insertion sort

:: while문에서 실행될 때, 실행 횟수는 점차 증가하게 된다. 최대 실행 횟수는 

1 + 2 + 3 + ... + (n-2) + (n-1) = n(n-1)/2 

시간 복잡도는 **O(N^2)**가 된다.

:: 배열이 정렬되어있는 경우, 요소 이동에 대한 시간이 할당되지 않고 

(배열의 크기 -1)번만 비교하면 되기 때문에 

시간 복잡도는 **O(n)**이 된다. 

![20210506_164814](https://user-images.githubusercontent.com/80511175/117261343-00151180-ae8b-11eb-9532-475b46177c20.png)

#### Shell sort

:: shell 에서 최대 실행되는 시간복잡도는 **O(N^2)**이고 

gap에 따라서 시간복잡도가 달라질 수 있다.

지금까지 최적화된 시간복잡도는 **O(N^1.25)**이라고 한다. 

![20210506_164841](https://user-images.githubusercontent.com/80511175/117261449-1ae78600-ae8b-11eb-89b9-ca6c97ed769b.png)
