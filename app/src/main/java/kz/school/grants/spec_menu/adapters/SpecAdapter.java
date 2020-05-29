package kz.school.grants.spec_menu.adapters;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import kz.school.grants.R;
import kz.school.grants.spec_menu.SubjectPair;

public class SpecAdapter extends RecyclerView.Adapter<SpecAdapter.MyTViewHolder> {

    private Context context;
    private List<SubjectPair> dataList;
    TypedArray colorStore;

    public class MyTViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

        @BindView(R.id.sTitle)
        TextView sTitle;

        ItemClickListener clickListener;

        public MyTViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }


        @Override
        public void onClick(View view) {
            this.clickListener.onItemClick(view,getLayoutPosition());
        }

        public void setOnClick(ItemClickListener clickListener){
            this.clickListener = clickListener;
        }
    }

    public SpecAdapter(Context context, List<SubjectPair> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public MyTViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_spec, parent, false);

        return new MyTViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyTViewHolder holder, int position) {

        final SubjectPair subjectPair = dataList.get(position);

        holder.sTitle.setText(subjectPair.getPair());
//        holder.sCount.setText(""+subjectPair.getCount());

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}