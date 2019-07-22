package com.raiyan.automate.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.raiyan.automate.Models.Rooms.Room;
import com.raiyan.automate.R;
import com.raiyan.automate.database.AppDatabase;

import java.util.List;

public class RoomRecyclerAdapter extends RecyclerView.Adapter<RoomRecyclerAdapter.RoomViewHolder> {

    private static final String TAG = RoomRecyclerAdapter.class.getSimpleName();
    private AppDatabase database;
    private List<Room> mRoomList;

    private Context context;
    private final ItemClickListener itemClickListener;

    public interface ItemClickListener {
        void onItemClickListener(int itemId);
    }

    public RoomRecyclerAdapter(Context context, ItemClickListener itemClickListener) {
        this.context = context;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public RoomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.room_recyclerview_item,parent,false);
        return new RoomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomViewHolder holder, int position) {
        Room room = mRoomList.get(position);
    }

    public void setRoomList(List<Room> roomList){
        mRoomList = roomList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mRoomList == null?0:mRoomList.size();
    }

    class RoomViewHolder extends RecyclerView.ViewHolder{
        TextView tvRoomName, tvRoomNumber;
        ImageView imgRoom;

        public RoomViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRoomName = itemView.findViewById(R.id.tv_room_name);
            tvRoomNumber = itemView.findViewById(R.id.tv_room_number);
            imgRoom = itemView.findViewById(R.id.room_photo);
        }
    }
}
