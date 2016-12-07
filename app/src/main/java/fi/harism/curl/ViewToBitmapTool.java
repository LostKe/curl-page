package fi.harism.curl;

import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by zhangshuqing on 16/12/7.
 */
public class ViewToBitmapTool {

    public static Bitmap getViewBitmap(View sourceView,int width,int height,CalendarEntry entry){
        Bitmap bitmap=null;
        if(sourceView!=null){
            sourceView.clearFocus();
            sourceView.setPressed(false);

            boolean willNotCache=sourceView.willNotCacheDrawing();
            int color=sourceView.getDrawingCacheBackgroundColor();
            sourceView.setDrawingCacheBackgroundColor(0);
            float alpha=sourceView.getAlpha();
            sourceView.setAlpha(1.0f);

            if(color!=0){
                sourceView.destroyDrawingCache();
            }
            int widthSpec=View.MeasureSpec.makeMeasureSpec(width,View.MeasureSpec.EXACTLY);
            int heightSpec=View.MeasureSpec.makeMeasureSpec(height,View.MeasureSpec.EXACTLY);
            sourceView.measure(widthSpec,heightSpec);
            sourceView.layout(0,0,width,height);
            sourceView.buildDrawingCache();

            TextView tv_month= (TextView) sourceView.findViewById(R.id.item_month);
            tv_month.setText(entry.getMonth());
            TextView tv_day= (TextView) sourceView.findViewById(R.id.item_day);
            tv_day.setText(entry.getDay());
            TextView tv_week= (TextView) sourceView.findViewById(R.id.item_week);
            tv_week.setText(entry.getWeek());



            Bitmap cacheBitMap=sourceView.getDrawingCache();
            if(cacheBitMap==null){
                Log.e("ViewToBitmapTool","failed getViewBitmap");
                return null;
            }
            bitmap=Bitmap.createBitmap(cacheBitMap);
            //restore the view
            sourceView.setAlpha(alpha);
            sourceView.destroyDrawingCache();
            sourceView.setWillNotCacheDrawing(willNotCache);
            sourceView.setDrawingCacheBackgroundColor(color);
        }

        return bitmap;
    }
}
