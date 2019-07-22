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
import com.raiyan.automate.Models.Devices.DateConverter;
import com.raiyan.automate.Models.Devices.Oven;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class OvenDao_Impl implements OvenDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter __insertionAdapterOfOven;

  private final EntityDeletionOrUpdateAdapter __deletionAdapterOfOven;

  private final EntityDeletionOrUpdateAdapter __updateAdapterOfOven;

  public OvenDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfOven = new EntityInsertionAdapter<Oven>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `oven`(`roomNumber`,`PIN`,`energyConsumed`,`device_number`,`device_name`,`state`,`onTime`,`offTime`,`id`,`temperature`,`timLeftMinutes`) VALUES (?,?,?,?,?,?,?,?,nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Oven value) {
        stmt.bindLong(1, value.getRoomNumber());
        if (value.getPIN() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPIN());
        }
        stmt.bindDouble(3, value.getEnergyConsumed());
        stmt.bindLong(4, value.getDevice_number());
        if (value.getDevice_name() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDevice_name());
        }
        final int _tmp;
        _tmp = value.isState() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        final Long _tmp_1;
        _tmp_1 = DateConverter.toTimestamp(value.getOnTime());
        if (_tmp_1 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, _tmp_1);
        }
        final Long _tmp_2;
        _tmp_2 = DateConverter.toTimestamp(value.getOffTime());
        if (_tmp_2 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, _tmp_2);
        }
        stmt.bindLong(9, value.getId());
        stmt.bindLong(10, value.getTemperature());
        stmt.bindLong(11, value.getTimLeftMinutes());
      }
    };
    this.__deletionAdapterOfOven = new EntityDeletionOrUpdateAdapter<Oven>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `oven` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Oven value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfOven = new EntityDeletionOrUpdateAdapter<Oven>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `oven` SET `roomNumber` = ?,`PIN` = ?,`energyConsumed` = ?,`device_number` = ?,`device_name` = ?,`state` = ?,`onTime` = ?,`offTime` = ?,`id` = ?,`temperature` = ?,`timLeftMinutes` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Oven value) {
        stmt.bindLong(1, value.getRoomNumber());
        if (value.getPIN() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPIN());
        }
        stmt.bindDouble(3, value.getEnergyConsumed());
        stmt.bindLong(4, value.getDevice_number());
        if (value.getDevice_name() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDevice_name());
        }
        final int _tmp;
        _tmp = value.isState() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        final Long _tmp_1;
        _tmp_1 = DateConverter.toTimestamp(value.getOnTime());
        if (_tmp_1 == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, _tmp_1);
        }
        final Long _tmp_2;
        _tmp_2 = DateConverter.toTimestamp(value.getOffTime());
        if (_tmp_2 == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, _tmp_2);
        }
        stmt.bindLong(9, value.getId());
        stmt.bindLong(10, value.getTemperature());
        stmt.bindLong(11, value.getTimLeftMinutes());
        stmt.bindLong(12, value.getId());
      }
    };
  }

  @Override
  public void insertOven(final Oven oven) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfOven.insert(oven);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteOven(final Oven oven) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfOven.handle(oven);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateOven(final Oven oven) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfOven.handle(oven);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Oven>> loadAllOvens() {
    final String _sql = "SELECT * FROM oven";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"oven"}, false, new Callable<List<Oven>>() {
      @Override
      public List<Oven> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false);
        try {
          final int _cursorIndexOfRoomNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "roomNumber");
          final int _cursorIndexOfPIN = CursorUtil.getColumnIndexOrThrow(_cursor, "PIN");
          final int _cursorIndexOfEnergyConsumed = CursorUtil.getColumnIndexOrThrow(_cursor, "energyConsumed");
          final int _cursorIndexOfDeviceNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "device_number");
          final int _cursorIndexOfDeviceName = CursorUtil.getColumnIndexOrThrow(_cursor, "device_name");
          final int _cursorIndexOfState = CursorUtil.getColumnIndexOrThrow(_cursor, "state");
          final int _cursorIndexOfOnTime = CursorUtil.getColumnIndexOrThrow(_cursor, "onTime");
          final int _cursorIndexOfOffTime = CursorUtil.getColumnIndexOrThrow(_cursor, "offTime");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTemperature = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature");
          final int _cursorIndexOfTimLeftMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "timLeftMinutes");
          final List<Oven> _result = new ArrayList<Oven>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Oven _item;
            final int _tmpRoomNumber;
            _tmpRoomNumber = _cursor.getInt(_cursorIndexOfRoomNumber);
            final String _tmpPIN;
            _tmpPIN = _cursor.getString(_cursorIndexOfPIN);
            final float _tmpEnergyConsumed;
            _tmpEnergyConsumed = _cursor.getFloat(_cursorIndexOfEnergyConsumed);
            final int _tmpDevice_number;
            _tmpDevice_number = _cursor.getInt(_cursorIndexOfDeviceNumber);
            final String _tmpDevice_name;
            _tmpDevice_name = _cursor.getString(_cursorIndexOfDeviceName);
            final boolean _tmpState;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfState);
            _tmpState = _tmp != 0;
            final Date _tmpOnTime;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfOnTime)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfOnTime);
            }
            _tmpOnTime = DateConverter.toDate(_tmp_1);
            final Date _tmpOffTime;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfOffTime)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfOffTime);
            }
            _tmpOffTime = DateConverter.toDate(_tmp_2);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpTemperature;
            _tmpTemperature = _cursor.getInt(_cursorIndexOfTemperature);
            final int _tmpTimLeftMinutes;
            _tmpTimLeftMinutes = _cursor.getInt(_cursorIndexOfTimLeftMinutes);
            _item = new Oven(_tmpId,_tmpRoomNumber,_tmpPIN,_tmpEnergyConsumed,_tmpDevice_number,_tmpDevice_name,_tmpState,_tmpOnTime,_tmpOffTime,_tmpTemperature,_tmpTimLeftMinutes);
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

  @Override
  public LiveData<List<Oven>> loadAllOvensByRoom(final int roomNumber) {
    final String _sql = "SELECT * FROM oven WHERE roomNumber = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, roomNumber);
    return __db.getInvalidationTracker().createLiveData(new String[]{"oven"}, false, new Callable<List<Oven>>() {
      @Override
      public List<Oven> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false);
        try {
          final int _cursorIndexOfRoomNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "roomNumber");
          final int _cursorIndexOfPIN = CursorUtil.getColumnIndexOrThrow(_cursor, "PIN");
          final int _cursorIndexOfEnergyConsumed = CursorUtil.getColumnIndexOrThrow(_cursor, "energyConsumed");
          final int _cursorIndexOfDeviceNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "device_number");
          final int _cursorIndexOfDeviceName = CursorUtil.getColumnIndexOrThrow(_cursor, "device_name");
          final int _cursorIndexOfState = CursorUtil.getColumnIndexOrThrow(_cursor, "state");
          final int _cursorIndexOfOnTime = CursorUtil.getColumnIndexOrThrow(_cursor, "onTime");
          final int _cursorIndexOfOffTime = CursorUtil.getColumnIndexOrThrow(_cursor, "offTime");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTemperature = CursorUtil.getColumnIndexOrThrow(_cursor, "temperature");
          final int _cursorIndexOfTimLeftMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "timLeftMinutes");
          final List<Oven> _result = new ArrayList<Oven>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Oven _item;
            final int _tmpRoomNumber;
            _tmpRoomNumber = _cursor.getInt(_cursorIndexOfRoomNumber);
            final String _tmpPIN;
            _tmpPIN = _cursor.getString(_cursorIndexOfPIN);
            final float _tmpEnergyConsumed;
            _tmpEnergyConsumed = _cursor.getFloat(_cursorIndexOfEnergyConsumed);
            final int _tmpDevice_number;
            _tmpDevice_number = _cursor.getInt(_cursorIndexOfDeviceNumber);
            final String _tmpDevice_name;
            _tmpDevice_name = _cursor.getString(_cursorIndexOfDeviceName);
            final boolean _tmpState;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfState);
            _tmpState = _tmp != 0;
            final Date _tmpOnTime;
            final Long _tmp_1;
            if (_cursor.isNull(_cursorIndexOfOnTime)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getLong(_cursorIndexOfOnTime);
            }
            _tmpOnTime = DateConverter.toDate(_tmp_1);
            final Date _tmpOffTime;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfOffTime)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfOffTime);
            }
            _tmpOffTime = DateConverter.toDate(_tmp_2);
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpTemperature;
            _tmpTemperature = _cursor.getInt(_cursorIndexOfTemperature);
            final int _tmpTimLeftMinutes;
            _tmpTimLeftMinutes = _cursor.getInt(_cursorIndexOfTimLeftMinutes);
            _item = new Oven(_tmpId,_tmpRoomNumber,_tmpPIN,_tmpEnergyConsumed,_tmpDevice_number,_tmpDevice_name,_tmpState,_tmpOnTime,_tmpOffTime,_tmpTemperature,_tmpTimLeftMinutes);
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
