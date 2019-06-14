package android.example.holidays;

import android.content.Context;
import android.content.Intent;
import android.example.holidays.Data.HolidaysEntity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class HolidaysAdapter extends RecyclerView.Adapter<HolidaysAdapter.HolidaysViewHolder> {

    private List<HolidaysEntity> holidaysEntities;

    public HolidaysAdapter(List<HolidaysEntity> holidaysEntities1) {
        holidaysEntities = holidaysEntities1;
    }

    public void func(List<HolidaysEntity> holidaysEntityList) {
        holidaysEntities = holidaysEntityList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HolidaysAdapter.HolidaysViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.weather_item;

        // perevodim xml v java
        LayoutInflater inflater = LayoutInflater.from(context);

        // dolzhen znat iz kakogo xml delaem/ znay roditelya / neobhodimo li pomeshat sozdanniu component vnytr roditelya, no ono i tak bydet sdelano
        View view = inflater.inflate(layoutIdForListItem,parent,false);

        HolidaysViewHolder viewHolder = new HolidaysViewHolder(view);
        //  viewHolder.viewHolderIndex.setText("ViewHolder index: " + viewHolderCount);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolidaysViewHolder holder, int position) {
        // у созданных холдеров меняем их значения, во время прокрутки списка
        holder.bind(holidaysEntities,position);

    }

    // вернуть общее кол-во елементов в списке
    @Override
    public int getItemCount() {
        return holidaysEntities.size();
    }

    class HolidaysViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        TextView textView2;
        ImageView share;
        private HolidaysEntity holidaysEntities11;



        public HolidaysViewHolder(final View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.text_view_weather_item_1);
            textView2 = itemView.findViewById(R.id.text_view_weather_item_2);
            share = itemView.findViewById(R.id.id12);

            share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_SUBJECT,"Did you forgot about this holiday?");
                    sendIntent.putExtra(Intent.EXTRA_TEXT, holidaysEntities11.name + ". Date: " + holidaysEntities11.date);
                    sendIntent.setType("text/plain");
                    itemView.getContext().startActivity(Intent.createChooser(sendIntent,"Поделиться"));

                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClass(itemView.getContext(),RecycleViewItemActivity.class);
                    intent.putExtra("descriptions",holidaysEntities11.description);
                    intent.putExtra("name",holidaysEntities11.name);
                    intent.putExtra("date",holidaysEntities11.date);
                    itemView.getContext().startActivity(intent);
                }
            });
        }

        void bind(List<HolidaysEntity> holidaysEntities1,int listIndex) {
            textView1.setText(holidaysEntities1.get(listIndex).name);
            textView2.setText(holidaysEntities1.get(listIndex).date);
            holidaysEntities11 = holidaysEntities1.get(listIndex);


        }
    }
}
