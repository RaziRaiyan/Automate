package com.raiyan.automate.Fragments;

import android.os.Bundle;
import android.os.ParcelFormatException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.raiyan.automate.Activities.Homectivity;
import com.raiyan.automate.Adapters.RoomRecyclerAdapter;
import com.raiyan.automate.BackgroundTaskAndServices.AppExecutors;
import com.raiyan.automate.Dialogs.AddRoomDialog;
import com.raiyan.automate.Models.Rooms.Room;
import com.raiyan.automate.R;
import com.raiyan.automate.ViewModels.RoomsViewModel;
import com.raiyan.automate.database.AppDatabase;

public class RoomFragment extends Fragment implements AddRoomDialog.OnAddDialogClickListener,RoomRecyclerAdapter.ItemClickListener{

    private static final String TAG = RoomFragment.class.getSimpleName();

    private FloatingActionButton addRoomFab;
    private AddRoomDialog addRoomDialog;

    private RecyclerView roomRecyclerView;
    private RoomRecyclerAdapter roomRecyclerAdapter;

    private AppDatabase mDb;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDb = AppDatabase.getInstance(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rooms_fragment,container,false);
        addRoomFab = view.findViewById(R.id.add_room_fab);
        addRoomFab.setOnClickListener(view1 -> {
            addRoomDialog  = AddRoomDialog.getInstance(RoomFragment.this);
            addRoomDialog.show(getFragmentManager(),"addRoomDialog");
        });
        roomRecyclerView = view.findViewById(R.id.room_recycler_view);
        roomRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        roomRecyclerAdapter = new RoomRecyclerAdapter(getActivity(),this::onItemClickListener);
        roomRecyclerView.setAdapter(roomRecyclerAdapter);
        setUpViewModel();
        return view;
    }

    private void setUpViewModel(){
        RoomsViewModel roomsViewModel = ViewModelProviders.of(getActivity()).get(RoomsViewModel.class);
        roomsViewModel.getRooms().observe(this, rooms -> {
            Log.d(TAG, "Updating list of rooms from Livedata in ViewModel");
            roomRecyclerAdapter.setRoomList(rooms);
        });
    }



    @Override
    public void onItemClickListener(int itemId) {

    }

    @Override
    public void onAddDialogClickListener(String roomNumber, String roomName) {
        try {
            Log.d(TAG, "onAddDialogClickListener: roomName: "+roomName+" , roomNumber: "+roomNumber);
            if(roomNumber!= null && roomNumber.trim().equals("") &&
                    roomName!=null && roomName.trim().equals("") ){
                Room room = new Room(roomName,Integer.parseInt(roomNumber),null);
                AppExecutors.getInstance().diskIO().execute(() -> {
                    mDb.roomDao().insertRoom(room);
                });
                addRoomDialog.dismiss();
            }else {
                Toast.makeText(getActivity(),"Please fill all the fields correctly",Toast.LENGTH_SHORT).show();
            }
        }catch (Exception e){

        }
    }
}











