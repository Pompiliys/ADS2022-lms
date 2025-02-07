package by.it.group151051.o_akhmerov.lesson01;

/*
 * Даны целые числа 1<=n<=1E18 и 2<=m<=1E5,
 * необходимо найти остаток от деления n-го числа Фибоначчи на m.
 * время расчета должно быть не более 2 секунд
 */

import java.math.BigInteger;

public class FiboC {

    private long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {
        FiboC fibo = new FiboC();
        int n = 1;
        int m = 2;
        System.out.printf("fasterC(%d)=%d \n\t time=%d \n\n", n, fibo.fasterC(n, m), fibo.time());
    }

    long fasterC(long n, int m) {
        //Решение сложно найти интуитивно
        //возможно потребуется дополнительный поиск информации
        //см. период Пизано
        long remnant = n % pisano(m);

        long prev = 0;
        long curr = 1;

        long res = remnant;

        for (int i = 1; i < remnant; i++) {
            res = (prev + curr) % m;
            prev = curr;
            curr = res;
        }

        return res % m;
    }

    long pisano(long m){
        long prev = 0, curr = 1, res = 0;
        for(int i = 0; i < m*m; i++){
            res = (prev+curr)%m;
            prev = curr;
            curr = res;
            if (prev == 0 && curr == 1) return i + 1;
        }
        return 0;
    }

}

