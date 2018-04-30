package kr.hs.dgsw.flow.Network;

import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import org.hyunjun.school.School;
import org.hyunjun.school.SchoolException;

import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.List;

import kr.hs.dgsw.flow.R;

/**
 * Created by leesojin on 2018. 3. 27..
 */

public class RunTask extends AsyncTask<Void,Void,String> {

    private WeakReference<View> view;
    private List lists;

    public RunTask(View view, List lists) {

        this.view = new WeakReference<View>(view);
        this.lists = lists;
    }

    @Override
    protected String doInBackground(Void... voids) {
        School api = new School(School.Type.HIGH, School.Region.DAEGU, "D100000282");
        String menu = null;

        int year = (int)lists.get(0);
        int month = (int)lists.get(1);
        int day = (int)lists.get(2);
        String mealName = "점심";

        Calendar cal = Calendar.getInstance();

        cal.get(month);
        int lastDay = cal.getMaximum(Calendar.DAY_OF_MONTH);



        int meal = (Integer) lists.get(3);

        try {

            switch (meal) {
                case 0:
                    menu = api.getMonthlyMenu((Integer) lists.get(0), (Integer) lists.get(1)).get((Integer) lists.get(2) - 1).breakfast;
                    mealName = "아침";
                    break;
                case 1:
                    menu = api.getMonthlyMenu((Integer) lists.get(0), (Integer) lists.get(1)).get((Integer) lists.get(2) - 1).lunch;
                    mealName = "점심";
                    break;
                case 2:
                    menu = api.getMonthlyMenu((Integer) lists.get(0), (Integer) lists.get(1)).get((Integer) lists.get(2) - 1).dinner;
                    mealName = "저녁";
                    break;
                case 3:
                    if(lastDay == day){
                        month = month+1;
                        day = 1;
                    }
                    menu = api.getMonthlyMenu(((Integer)lists.get(0)), month).get(day).breakfast;
                    mealName = "아침";
                    break;
            }




        } catch (SchoolException e1) {
            e1.printStackTrace();
        }


        return year+" 년 "+month+" 월 "+day+" 일 "+mealName+" 식단입니다\n\n"+menu;
    }

    @Override
    protected void onPostExecute(String s) {
        TextView textView = view.get().findViewById(R.id.tvMealInfo);
        textView.setText(s);
    }
}
