//package imastudio.id.co.androidcharexample.adapter;
//
//import android.content.Intent;
//import android.database.DataSetObserver;
//import android.support.v4.app.FragmentActivity;
//import android.support.v7.widget.CardView;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.ListAdapter;
//import android.widget.TextView;
//
//import java.util.List;
//
//import imastudio.id.co.androidcharexample.MainActivity2;
//import imastudio.id.co.androidcharexample.R;
//import imastudio.id.co.androidcharexample.model.RssJ273GetAllIndikator.DataItemJ54GetAllIndikator;
//
//
////ini class untuk memindahkan data ke recylerview dan juga custom recylerview
//public class AdapterTipeIndikator extends RecyclerView.Adapter<AdapterTipeIndikator.MyHolder> implements ListAdapter {
//
//    List<DataItemJ54GetAllIndikator> data;
//    FragmentActivity c;
//
//
//
//    public AdapterTipeIndikator(List<DataItemJ54GetAllIndikator> data, FragmentActivity c) {
//        this.data = data;
//        this.c = c;
//    }
//
//
//
//    @Override
//    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View inflater = LayoutInflater.from(c).inflate(R.layout.item_indikator, parent, false);
//
//        return new MyHolder(inflater);
//    }
//
//    @Override
//    public void onBindViewHolder(MyHolder holder, final int position) {
//        holder.txJudul.setText(data.get(position).getTipeIndikator());
//
//
//        holder.card.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent a1 = new Intent(c, MainActivity2.class);
//                a1.putExtra("posisi",position);
//                c.startActivity(a1);
//
//
//
//
////
//            }
//        });
//
//    }
//
//
//
//    @Override
//    public int getItemCount() {
//        return data.size();
//    }
//
//    @Override
//    public boolean areAllItemsEnabled() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled(int position) {
//        return false;
//    }
//
//    @Override
//    public void registerDataSetObserver(DataSetObserver observer) {
//
//    }
//
//    @Override
//    public void unregisterDataSetObserver(DataSetObserver observer) {
//
//    }
//
//    @Override
//    public int getCount() {
//        return 0;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        return null;
//    }
//
//    @Override
//    public int getViewTypeCount() {
//        return 0;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return false;
//    }
//
//    public class MyHolder extends RecyclerView.ViewHolder {
//
//
//        TextView txJudul, txHarga, tvAlamat;
//        CardView card ;
//        ImageView imgGambar;
//
//        public MyHolder(View itemView) {
//            super(itemView);
//
//            txJudul = (TextView) itemView.findViewById(R.id.txtNamaIndikator);
////
//            card = itemView.findViewById(R.id.cardHome);
//
//
//
//        }
//    }
//
//
//}
