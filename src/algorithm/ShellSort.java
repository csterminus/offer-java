package algorithm;

public class ShellSort {
    /*
    时间复杂度n*log(n)
    希尔排序Shell Sort是基于插入排序的一种改进,同样分成两部分,
    第一部分,希尔排序介绍
    第二部分,如何选取关键字,选取关键字是希尔排序的关键
    第一块希尔排序介绍
    准备待排数组[6 2 4 1 5 9]
    首先需要选取关键字,例如关键是3和1(第一步分成三组,第二步分成一组),那么待排数组分成了以下三个虚拟组:
    [6 1]一组
    [2 5]二组
    [4 9]三组
    看仔细啊,不是临近的两个数字分组,而是3(分成了三组)的倍数的数字分成了一组,
    就是每隔3个数取一个,每隔三个再取一个,这样取出来的数字放到一组,
    把它们当成一组,但不实际分组,只是当成一组来看,所以上边的"组"实际上并不存在,只是为了说明分组关系
     */
    public static void sort(int[] array){
        int group,i,j,temp;
        //取增量
        for(group = array.length / 2; group > 0 ; group /= 2){
            //无序序列
            for(i = group; i < array.length; i++){
                for(j = i - group; j >= 0; j -= group){
                    if(array[j] > array[j + group]){
                        temp = array[j];
                        array[j] = array[j + group];
                        array[j + group] = temp;
                    }
                }
            }
        }

    }
}
