package Array.medium;

//TC=O(N) and SC=O(1)
public class ArrayRotation {
    static void rotateArr(int arr[], int d, int n)
    {
        // add your code here
        int c=0,temp=0,k=d,tem=arr[d];
        do{
            //store element at position c in temp.
            temp=arr[c];
            // store element at position c which was previously at d position.
            arr[c]=tem;
            // replace the d position value with current position c value.
            tem=temp;
            d=c;
            c=c-k;
            if(c<0) c=n+c;
        }while(c!=0);
    }
}
