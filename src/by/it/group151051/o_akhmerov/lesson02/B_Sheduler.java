package by.it.group151051.o_akhmerov.lesson02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
даны интервальные события events
реализуйте метод calcStartTimes, так, чтобы число принятых к выполнению
непересекающихся событий было максимально.
Алгоритм жадный. Для реализации обдумайте надежный шаг.
*/

public class B_Sheduler {
    //событие у аудитории(два поля: начало и конец)
    static class Event implements Comparable<Event>{
        int start;
        int stop;

        Event(int start, int stop) {
            this.start = start;
            this.stop = stop;
        }

        @Override
        public String toString() {
            return "("+ start +":" + stop + ")";
        }

        @Override
        public int compareTo(Event event) {
            if (this.start == event.start) {
                return Integer.compare(this.stop, event.stop);
            }
            else {
                return Integer.compare(this.start, event.start);
            }
        }
    }

    public static void main(String[] args) {
        B_Sheduler instance = new B_Sheduler();
        Event[] events = {  new Event(-1, 0), new Event(0, 3),  new Event(0, 1), new Event(1, 2), new Event(3, 5),
                new Event(1, 3),  new Event(1, 3), new Event(1, 3), new Event(3, 6),
                new Event(2, 7),  new Event(2, 3), new Event(2, 7), new Event(7, 9),
                new Event(3, 5),  new Event(2, 4), new Event(2, 3), new Event(3, 7),
                new Event(4, 5),  new Event(6, 7), new Event(6, 9), new Event(7, 9),
                new Event(8, 9),  new Event(4, 6), new Event(8, 10), new Event(7, 10), new Event(9, 11)
        };

        List<Event> starts = instance.calcStartTimes(events,0,11);  //рассчитаем оптимальное заполнение аудитории
        System.out.println(starts);                                 //покажем рассчитанный график занятий
    }

    List<Event> calcStartTimes(Event[] events, int from, int to) {
        //events - события которые нужно распределить в аудитории
        //в период [from, int] (включительно).
        //оптимизация проводится по наибольшему числу непересекающихся событий.
        //начало и конец событий могут совпадать.
        List<Event> result;
        result = new ArrayList<>();
        int i = 0, arrayLengt = events.length;
        int stopT;

        Arrays.sort(events);

        stopT = events[0].stop;
        //ваше решение.
        while(i < arrayLengt){
            if(events[i].start >= from && events[i].stop <= to){
                result.add(events[i]);
                stopT = events[i].stop;
                i++;

                while(i < arrayLengt && events[i].start < stopT)
                    i++;
            }else i++;
        }

        return result;                       //вернем итог
    }
}