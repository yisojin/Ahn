package kr.hs.dgsw.ahn.DateTime;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by leesojin on 2018. 3. 27..
 */

public class FindDate {
    public FindDate() {

    }

    public List dates() {
        SimpleDateFormat yyyy = new SimpleDateFormat("yyyy");
        SimpleDateFormat MM = new SimpleDateFormat("MM");
        SimpleDateFormat dd = new SimpleDateFormat("dd");
        SimpleDateFormat HH = new SimpleDateFormat("kk");
        SimpleDateFormat mm = new SimpleDateFormat("mm");

        Date currentTime = new Date(System.currentTimeMillis());
        int year = Integer.parseInt(yyyy.format(currentTime));
        int month = Integer.parseInt(MM.format(currentTime));
        int day = Integer.parseInt(dd.format(currentTime)); //매달의 끝을 알아야 함
        int hour = Integer.parseInt(HH.format(currentTime)); // 1:00 ->dinner 19:00 ->breakfast 8:00 ->lunch
        int miniute = Integer.parseInt(mm.format(currentTime));

        int meal = 1;
        switch (hour) {
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                meal = 2; //dinner
                break;

            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                meal = 0; //breakfast
                break;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                meal = 1; //lunch
                break;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
                meal = 3; //next day breakfast
                break;
        }

        List<Integer> lst = new ArrayList();

        lst.add(year);
        lst.add(month);
        lst.add(day);
        lst.add(meal);


        return lst;
    }
}
