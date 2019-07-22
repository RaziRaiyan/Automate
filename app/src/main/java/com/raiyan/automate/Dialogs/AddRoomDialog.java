package com.raiyan.automate.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.raiyan.automate.R;

public class AddRoomDialog extends DialogFragment {

    private static final String TAG = AddRoomDialog.class.getSimpleName();

    private ImageView closeButton;
    private EditText etRoomName;
    private EditText etRoomNumber;
    private Button btnAddRoom;

    public static int NEGATIVE_BUTTON_ID = 0;
    public static int POSITIVE_BUTTON_ID = 1;

    private static OnAddDialogClickListener mCallback;

    public interface OnAddDialogClickListener{
        public void onAddDialogClickListener(String roomNumber, String roomName);
    }

    private AddRoomDialog() {
    }

    private static AddRoomDialog mInstance;

    public static AddRoomDialog getInstance(OnAddDialogClickListener callback) {
        mCallback = callback;
        if(mInstance == null){
            mInstance = new AddRoomDialog();
        }
        return mInstance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(getDialog() != null && getDialog().getWindow() != null){
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.MyDialog);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_add_room,null);
        builder.setView(view);
        closeButton = view.findViewById(R.id.close_dialog_btn);
        btnAddRoom = view.findViewById(R.id.add_room_btn_dialog);
        etRoomName = view.findViewById(R.id.et_room_name);
        etRoomNumber = view.findViewById(R.id.et_room_number);

        btnAddRoom.setOnClickListener(view1 -> { mCallback.onAddDialogClickListener(
                etRoomNumber.getText().toString(),etRoomName.getText().toString()); });
        closeButton.setOnClickListener(v -> mInstance.dismiss());
        return builder.create();
    }
}
