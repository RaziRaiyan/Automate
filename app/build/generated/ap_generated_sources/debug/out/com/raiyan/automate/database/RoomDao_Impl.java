package com.raiyan.automate.database;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.raiyan.automate.Models.Rooms.Room;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class RoomDao_Impl implements RoomDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfRoom;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfRoom;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfRoom;

  public RoomDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRoom = new EntityInsertionAdapter<Room>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `room`(`id`,`roomName`,`roomNumber`,`photoUrl`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Room value) {
        stmt.bindLong(1, value.getId());
        if (value.getRoomName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getRoomName());
        }
        stmt.bindLong(3, value.getRoomNumber());
        if (value.getPhotoUrl() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPhotoUrl());
        }
      }
    };
    this.__deletionAdapterOfRoom = new EntityDeletionOrUpdateAdapter<Room>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `room` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Room value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfRoom = new EntityDeletionOrUpdateAdapter<Room>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR REPLACE `room` SET `id` = ?,`roomName` = ?,`roomNumber` = ?,`photoUrl` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Room value) {
        stmt.bindLong(1, value.getId());
        if (value.getRoomName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getRoomName());
        }
        stmt.bindLong(3, value.getRoomNumber());
        if (value.getPhotoUrl() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPhotoUrl());
        }
        stmt.bindLong(5, value.getId());
      }
    };
  }

  @Override
  public void insertRoom(final Room room) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfRoom.insert(room);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteRoom(final Room room) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfRoom.handle(room);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateRoom(final Room room) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfRoom.handle(room);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Room>> loaddAllRooms() {
    final String _sql = "SELECT * FROM room";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"room"}, false, new Callable<List<Room>>() {
      @Override
      public List<Room> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfRoomName = CursorUtil.getColumnIndexOrThrow(_cursor, "roomName");
          final int _cursorIndexOfRoomNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "roomNumber");
          final int _cursorIndexOfPhotoUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "photoUrl");
          final List<Room> _result = new ArrayList<Room>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Room _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpRoomName;
            _tmpRoomName = _cursor.getString(_cursorIndexOfRoomName);
            final int _tmpRoomNumber;
            _tmpRoomNumber = _cursor.getInt(_cursorIndexOfRoomNumber);
            final String _tmpPhotoUrl;
            _tmpPhotoUrl = _cursor.getString(_cursorIndexOfPhotoUrl);
            _item = new Room(_tmpId,_tmpRoomName,_tmpRoomNumber,_tmpPhotoUrl);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
