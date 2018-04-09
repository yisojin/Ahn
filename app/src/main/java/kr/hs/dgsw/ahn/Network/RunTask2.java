package kr.hs.dgsw.ahn.Network;

import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import org.hyunjun.school.School;
import org.hyunjun.school.SchoolException;

import java.lang.ref.WeakReference;
import java.util.List;

import kr.hs.dgsw.ahn.R;

/**
 * Created by leesojin on 2018. 3. 27..
 */

public class RunTask2 extends AsyncTask<Void,Void,String> {

    private WeakReference<View> view;
    private List lists;

    public RunTask2(View view, List lists) {
        this.view = new WeakReference<View>(view);
        this.lists = lists;
    }

    @Override
    protected String doInBackground(Void... voids) {
        School api = new School(School.Type.HIGH, School.Region.DAEGU, "D100000282");
        String breakfast = null;
        String lunch = null;
        String dinner = null;


        try {
            breakfast = api.getMonthlyMenu((Integer) lists.get(0), (Integer) lists.get(1)).get((Integer) lists.get(2) - 1).breakfast;
            lunch = api.getMonthlyMenu((Integer) lists.get(0), (Integer) lists.get(1)).get((Integer) lists.get(2) - 1).lunch;
            dinner = api.getMonthlyMenu((Integer) lists.get(0), (Integer) lists.get(1)).get((Integer) lists.get(2) - 1).dinner;


        } catch (SchoolException e1) {
            e1.printStackTrace();
        }

        return lists.get(0)+" 년 "+lists.get(1)+" 월 "+lists.get(2)+" 일 식단입니다\n\n"+"아침\n\n"+breakfast+"\n\n점심\n\n"+lunch+"\n\n저녁\n\n"+dinner;
    }

    @Override
    protected void onPostExecute(String s) {
        TextView textView = view.get().findViewById(R.id.tvMealInfo);
        textView.setText(s);
    }
}
