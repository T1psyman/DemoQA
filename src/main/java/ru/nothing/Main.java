package ru.nothing;

public class Main {

    public static void main(String[] args) {
//        1) поупражняться с математическими и логическими операторами, добиться переполнения при вычислениях, посмотреть результаты (вывести в консоль)
        // 2. Математические + - * / %
        Integer summ = 5 + 2;
        System.out.println("summ : " + summ);

        int max = Integer.MAX_VALUE;
        System.out.println("max : " + max);
        int overMax = max / summ * 9;
        System.out.println("overMax : " + overMax);
        int anotherNumber = overMax % 7;
        System.out.println("anotherNumber : " + anotherNumber);
        long megaLong = overMax * overMax;
        System.out.println("megaLong : " + megaLong);
        long beLong2 = max;
        long beLong = max + beLong2;
        System.out.println("beLong : " + beLong);



        // 4. Логические операторы &(И) && (сокращенное И), | (ИЛИ)  || (сокращенное ИЛИ), отрицание (! НЕ)

        if (!(max < 0 && anotherNumber < 0 ) ) {
            System.out.println("Слишком отрицательные числа, для умножения положительных перменных," +
                    " Видимо так работает переполенние.");
        }else {
            System.out.println("Если это видно, то ктото сменил переменные");
        }
        long  along = 2147483648L;
        if (max + 1 == along){
            System.out.println("Не думаю что будет");
        }else {
            System.out.println("Прикольно, вышло");
        }
        boolean justBoolianFalse = false;

        if (justBoolianFalse || max + 1 < max){
            System.out.println("Успех");
        }else {
            System.out.println("Не будет");
        }

        //2) попробовать вычисления комбинаций типов данных (int и double)

        double adouble = 2.4d;
        int newSumm = (int) (summ + adouble);
        System.out.println("newSumm : " + newSumm);

        double adoubledouble = newSumm * adouble;
        System.out.println("adoubledouble  : " + adoubledouble  );

    }

}
