package com.raiyan.automate.database;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile ACDao _aCDao;

  private volatile BulbDao _bulbDao;

  private volatile CoolerDao _coolerDao;

  private volatile FanDao _fanDao;

  private volatile LockDao _lockDao;

  private volatile OvenDao _ovenDao;

  private volatile SurvellianceDao _survellianceDao;

  private volatile TelevisionDao _televisionDao;

  private volatile RoomDao _roomDao;

  private volatile CurrentUserDao _currentUserDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `ac` (`roomNumber` INTEGER NOT NULL, `PIN` TEXT, `energyConsumed` REAL NOT NULL, `device_number` INTEGER NOT NULL, `device_name` TEXT, `state` INTEGER NOT NULL, `onTime` INTEGER, `offTime` INTEGER, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `temperature` INTEGER NOT NULL, `swing` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `bulb` (`roomNumber` INTEGER NOT NULL, `PIN` TEXT, `energyConsumed` REAL NOT NULL, `device_number` INTEGER NOT NULL, `device_name` TEXT, `state` INTEGER NOT NULL, `onTime` INTEGER, `offTime` INTEGER, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `cooler` (`roomNumber` INTEGER NOT NULL, `PIN` TEXT, `energyConsumed` REAL NOT NULL, `device_number` INTEGER NOT NULL, `device_name` TEXT, `state` INTEGER NOT NULL, `onTime` INTEGER, `offTime` INTEGER, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `speed` INTEGER, `swing` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `fan` (`roomNumber` INTEGER NOT NULL, `PIN` TEXT, `energyConsumed` REAL NOT NULL, `device_number` INTEGER NOT NULL, `device_name` TEXT, `state` INTEGER NOT NULL, `onTime` INTEGER, `offTime` INTEGER, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `speed` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `lock` (`roomNumber` INTEGER NOT NULL, `PIN` TEXT, `energyConsumed` REAL NOT NULL, `device_number` INTEGER NOT NULL, `device_name` TEXT, `state` INTEGER NOT NULL, `onTime` INTEGER, `offTime` INTEGER, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `password` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `oven` (`roomNumber` INTEGER NOT NULL, `PIN` TEXT, `energyConsumed` REAL NOT NULL, `device_number` INTEGER NOT NULL, `device_name` TEXT, `state` INTEGER NOT NULL, `onTime` INTEGER, `offTime` INTEGER, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `temperature` INTEGER NOT NULL, `timLeftMinutes` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `surveillance` (`roomNumber` INTEGER NOT NULL, `PIN` TEXT, `energyConsumed` REAL NOT NULL, `device_number` INTEGER NOT NULL, `device_name` TEXT, `state` INTEGER NOT NULL, `onTime` INTEGER, `offTime` INTEGER, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `privacy` INTEGER, `videoUrl` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `television` (`roomNumber` INTEGER NOT NULL, `PIN` TEXT, `energyConsumed` REAL NOT NULL, `device_number` INTEGER NOT NULL, `device_name` TEXT, `state` INTEGER NOT NULL, `onTime` INTEGER, `offTime` INTEGER, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `volume` INTEGER NOT NULL, `channel_no` INTEGER NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `room` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `roomName` TEXT, `roomNumber` INTEGER NOT NULL, `photoUrl` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `current_user` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `userName` TEXT, `photoUrl` TEXT, `email` TEXT, `phoneNumber` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c6aa1cf67dbb42489cbdcbed2fb4c175')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `ac`");
        _db.execSQL("DROP TABLE IF EXISTS `bulb`");
        _db.execSQL("DROP TABLE IF EXISTS `cooler`");
        _db.execSQL("DROP TABLE IF EXISTS `fan`");
        _db.execSQL("DROP TABLE IF EXISTS `lock`");
        _db.execSQL("DROP TABLE IF EXISTS `oven`");
        _db.execSQL("DROP TABLE IF EXISTS `surveillance`");
        _db.execSQL("DROP TABLE IF EXISTS `television`");
        _db.execSQL("DROP TABLE IF EXISTS `room`");
        _db.execSQL("DROP TABLE IF EXISTS `current_user`");
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected void validateMigration(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsAc = new HashMap<String, TableInfo.Column>(11);
        _columnsAc.put("roomNumber", new TableInfo.Column("roomNumber", "INTEGER", true, 0));
        _columnsAc.put("PIN", new TableInfo.Column("PIN", "TEXT", false, 0));
        _columnsAc.put("energyConsumed", new TableInfo.Column("energyConsumed", "REAL", true, 0));
        _columnsAc.put("device_number", new TableInfo.Column("device_number", "INTEGER", true, 0));
        _columnsAc.put("device_name", new TableInfo.Column("device_name", "TEXT", false, 0));
        _columnsAc.put("state", new TableInfo.Column("state", "INTEGER", true, 0));
        _columnsAc.put("onTime", new TableInfo.Column("onTime", "INTEGER", false, 0));
        _columnsAc.put("offTime", new TableInfo.Column("offTime", "INTEGER", false, 0));
        _columnsAc.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsAc.put("temperature", new TableInfo.Column("temperature", "INTEGER", true, 0));
        _columnsAc.put("swing", new TableInfo.Column("swing", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAc = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesAc = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoAc = new TableInfo("ac", _columnsAc, _foreignKeysAc, _indicesAc);
        final TableInfo _existingAc = TableInfo.read(_db, "ac");
        if (! _infoAc.equals(_existingAc)) {
          throw new IllegalStateException("Migration didn't properly handle ac(com.raiyan.automate.Models.Devices.AC).\n"
                  + " Expected:\n" + _infoAc + "\n"
                  + " Found:\n" + _existingAc);
        }
        final HashMap<String, TableInfo.Column> _columnsBulb = new HashMap<String, TableInfo.Column>(9);
        _columnsBulb.put("roomNumber", new TableInfo.Column("roomNumber", "INTEGER", true, 0));
        _columnsBulb.put("PIN", new TableInfo.Column("PIN", "TEXT", false, 0));
        _columnsBulb.put("energyConsumed", new TableInfo.Column("energyConsumed", "REAL", true, 0));
        _columnsBulb.put("device_number", new TableInfo.Column("device_number", "INTEGER", true, 0));
        _columnsBulb.put("device_name", new TableInfo.Column("device_name", "TEXT", false, 0));
        _columnsBulb.put("state", new TableInfo.Column("state", "INTEGER", true, 0));
        _columnsBulb.put("onTime", new TableInfo.Column("onTime", "INTEGER", false, 0));
        _columnsBulb.put("offTime", new TableInfo.Column("offTime", "INTEGER", false, 0));
        _columnsBulb.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBulb = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBulb = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBulb = new TableInfo("bulb", _columnsBulb, _foreignKeysBulb, _indicesBulb);
        final TableInfo _existingBulb = TableInfo.read(_db, "bulb");
        if (! _infoBulb.equals(_existingBulb)) {
          throw new IllegalStateException("Migration didn't properly handle bulb(com.raiyan.automate.Models.Devices.Bulb).\n"
                  + " Expected:\n" + _infoBulb + "\n"
                  + " Found:\n" + _existingBulb);
        }
        final HashMap<String, TableInfo.Column> _columnsCooler = new HashMap<String, TableInfo.Column>(11);
        _columnsCooler.put("roomNumber", new TableInfo.Column("roomNumber", "INTEGER", true, 0));
        _columnsCooler.put("PIN", new TableInfo.Column("PIN", "TEXT", false, 0));
        _columnsCooler.put("energyConsumed", new TableInfo.Column("energyConsumed", "REAL", true, 0));
        _columnsCooler.put("device_number", new TableInfo.Column("device_number", "INTEGER", true, 0));
        _columnsCooler.put("device_name", new TableInfo.Column("device_name", "TEXT", false, 0));
        _columnsCooler.put("state", new TableInfo.Column("state", "INTEGER", true, 0));
        _columnsCooler.put("onTime", new TableInfo.Column("onTime", "INTEGER", false, 0));
        _columnsCooler.put("offTime", new TableInfo.Column("offTime", "INTEGER", false, 0));
        _columnsCooler.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsCooler.put("speed", new TableInfo.Column("speed", "INTEGER", false, 0));
        _columnsCooler.put("swing", new TableInfo.Column("swing", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCooler = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCooler = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCooler = new TableInfo("cooler", _columnsCooler, _foreignKeysCooler, _indicesCooler);
        final TableInfo _existingCooler = TableInfo.read(_db, "cooler");
        if (! _infoCooler.equals(_existingCooler)) {
          throw new IllegalStateException("Migration didn't properly handle cooler(com.raiyan.automate.Models.Devices.Cooler).\n"
                  + " Expected:\n" + _infoCooler + "\n"
                  + " Found:\n" + _existingCooler);
        }
        final HashMap<String, TableInfo.Column> _columnsFan = new HashMap<String, TableInfo.Column>(10);
        _columnsFan.put("roomNumber", new TableInfo.Column("roomNumber", "INTEGER", true, 0));
        _columnsFan.put("PIN", new TableInfo.Column("PIN", "TEXT", false, 0));
        _columnsFan.put("energyConsumed", new TableInfo.Column("energyConsumed", "REAL", true, 0));
        _columnsFan.put("device_number", new TableInfo.Column("device_number", "INTEGER", true, 0));
        _columnsFan.put("device_name", new TableInfo.Column("device_name", "TEXT", false, 0));
        _columnsFan.put("state", new TableInfo.Column("state", "INTEGER", true, 0));
        _columnsFan.put("onTime", new TableInfo.Column("onTime", "INTEGER", false, 0));
        _columnsFan.put("offTime", new TableInfo.Column("offTime", "INTEGER", false, 0));
        _columnsFan.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsFan.put("speed", new TableInfo.Column("speed", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFan = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFan = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFan = new TableInfo("fan", _columnsFan, _foreignKeysFan, _indicesFan);
        final TableInfo _existingFan = TableInfo.read(_db, "fan");
        if (! _infoFan.equals(_existingFan)) {
          throw new IllegalStateException("Migration didn't properly handle fan(com.raiyan.automate.Models.Devices.Fan).\n"
                  + " Expected:\n" + _infoFan + "\n"
                  + " Found:\n" + _existingFan);
        }
        final HashMap<String, TableInfo.Column> _columnsLock = new HashMap<String, TableInfo.Column>(10);
        _columnsLock.put("roomNumber", new TableInfo.Column("roomNumber", "INTEGER", true, 0));
        _columnsLock.put("PIN", new TableInfo.Column("PIN", "TEXT", false, 0));
        _columnsLock.put("energyConsumed", new TableInfo.Column("energyConsumed", "REAL", true, 0));
        _columnsLock.put("device_number", new TableInfo.Column("device_number", "INTEGER", true, 0));
        _columnsLock.put("device_name", new TableInfo.Column("device_name", "TEXT", false, 0));
        _columnsLock.put("state", new TableInfo.Column("state", "INTEGER", true, 0));
        _columnsLock.put("onTime", new TableInfo.Column("onTime", "INTEGER", false, 0));
        _columnsLock.put("offTime", new TableInfo.Column("offTime", "INTEGER", false, 0));
        _columnsLock.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsLock.put("password", new TableInfo.Column("password", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLock = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLock = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoLock = new TableInfo("lock", _columnsLock, _foreignKeysLock, _indicesLock);
        final TableInfo _existingLock = TableInfo.read(_db, "lock");
        if (! _infoLock.equals(_existingLock)) {
          throw new IllegalStateException("Migration didn't properly handle lock(com.raiyan.automate.Models.Devices.Lock).\n"
                  + " Expected:\n" + _infoLock + "\n"
                  + " Found:\n" + _existingLock);
        }
        final HashMap<String, TableInfo.Column> _columnsOven = new HashMap<String, TableInfo.Column>(11);
        _columnsOven.put("roomNumber", new TableInfo.Column("roomNumber", "INTEGER", true, 0));
        _columnsOven.put("PIN", new TableInfo.Column("PIN", "TEXT", false, 0));
        _columnsOven.put("energyConsumed", new TableInfo.Column("energyConsumed", "REAL", true, 0));
        _columnsOven.put("device_number", new TableInfo.Column("device_number", "INTEGER", true, 0));
        _columnsOven.put("device_name", new TableInfo.Column("device_name", "TEXT", false, 0));
        _columnsOven.put("state", new TableInfo.Column("state", "INTEGER", true, 0));
        _columnsOven.put("onTime", new TableInfo.Column("onTime", "INTEGER", false, 0));
        _columnsOven.put("offTime", new TableInfo.Column("offTime", "INTEGER", false, 0));
        _columnsOven.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsOven.put("temperature", new TableInfo.Column("temperature", "INTEGER", true, 0));
        _columnsOven.put("timLeftMinutes", new TableInfo.Column("timLeftMinutes", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysOven = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesOven = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoOven = new TableInfo("oven", _columnsOven, _foreignKeysOven, _indicesOven);
        final TableInfo _existingOven = TableInfo.read(_db, "oven");
        if (! _infoOven.equals(_existingOven)) {
          throw new IllegalStateException("Migration didn't properly handle oven(com.raiyan.automate.Models.Devices.Oven).\n"
                  + " Expected:\n" + _infoOven + "\n"
                  + " Found:\n" + _existingOven);
        }
        final HashMap<String, TableInfo.Column> _columnsSurveillance = new HashMap<String, TableInfo.Column>(11);
        _columnsSurveillance.put("roomNumber", new TableInfo.Column("roomNumber", "INTEGER", true, 0));
        _columnsSurveillance.put("PIN", new TableInfo.Column("PIN", "TEXT", false, 0));
        _columnsSurveillance.put("energyConsumed", new TableInfo.Column("energyConsumed", "REAL", true, 0));
        _columnsSurveillance.put("device_number", new TableInfo.Column("device_number", "INTEGER", true, 0));
        _columnsSurveillance.put("device_name", new TableInfo.Column("device_name", "TEXT", false, 0));
        _columnsSurveillance.put("state", new TableInfo.Column("state", "INTEGER", true, 0));
        _columnsSurveillance.put("onTime", new TableInfo.Column("onTime", "INTEGER", false, 0));
        _columnsSurveillance.put("offTime", new TableInfo.Column("offTime", "INTEGER", false, 0));
        _columnsSurveillance.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsSurveillance.put("privacy", new TableInfo.Column("privacy", "INTEGER", false, 0));
        _columnsSurveillance.put("videoUrl", new TableInfo.Column("videoUrl", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysSurveillance = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesSurveillance = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoSurveillance = new TableInfo("surveillance", _columnsSurveillance, _foreignKeysSurveillance, _indicesSurveillance);
        final TableInfo _existingSurveillance = TableInfo.read(_db, "surveillance");
        if (! _infoSurveillance.equals(_existingSurveillance)) {
          throw new IllegalStateException("Migration didn't properly handle surveillance(com.raiyan.automate.Models.Devices.Surveillance).\n"
                  + " Expected:\n" + _infoSurveillance + "\n"
                  + " Found:\n" + _existingSurveillance);
        }
        final HashMap<String, TableInfo.Column> _columnsTelevision = new HashMap<String, TableInfo.Column>(11);
        _columnsTelevision.put("roomNumber", new TableInfo.Column("roomNumber", "INTEGER", true, 0));
        _columnsTelevision.put("PIN", new TableInfo.Column("PIN", "TEXT", false, 0));
        _columnsTelevision.put("energyConsumed", new TableInfo.Column("energyConsumed", "REAL", true, 0));
        _columnsTelevision.put("device_number", new TableInfo.Column("device_number", "INTEGER", true, 0));
        _columnsTelevision.put("device_name", new TableInfo.Column("device_name", "TEXT", false, 0));
        _columnsTelevision.put("state", new TableInfo.Column("state", "INTEGER", true, 0));
        _columnsTelevision.put("onTime", new TableInfo.Column("onTime", "INTEGER", false, 0));
        _columnsTelevision.put("offTime", new TableInfo.Column("offTime", "INTEGER", false, 0));
        _columnsTelevision.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsTelevision.put("volume", new TableInfo.Column("volume", "INTEGER", true, 0));
        _columnsTelevision.put("channel_no", new TableInfo.Column("channel_no", "INTEGER", true, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTelevision = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTelevision = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTelevision = new TableInfo("television", _columnsTelevision, _foreignKeysTelevision, _indicesTelevision);
        final TableInfo _existingTelevision = TableInfo.read(_db, "television");
        if (! _infoTelevision.equals(_existingTelevision)) {
          throw new IllegalStateException("Migration didn't properly handle television(com.raiyan.automate.Models.Devices.Television).\n"
                  + " Expected:\n" + _infoTelevision + "\n"
                  + " Found:\n" + _existingTelevision);
        }
        final HashMap<String, TableInfo.Column> _columnsRoom = new HashMap<String, TableInfo.Column>(4);
        _columnsRoom.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsRoom.put("roomName", new TableInfo.Column("roomName", "TEXT", false, 0));
        _columnsRoom.put("roomNumber", new TableInfo.Column("roomNumber", "INTEGER", true, 0));
        _columnsRoom.put("photoUrl", new TableInfo.Column("photoUrl", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysRoom = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesRoom = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoRoom = new TableInfo("room", _columnsRoom, _foreignKeysRoom, _indicesRoom);
        final TableInfo _existingRoom = TableInfo.read(_db, "room");
        if (! _infoRoom.equals(_existingRoom)) {
          throw new IllegalStateException("Migration didn't properly handle room(com.raiyan.automate.Models.Rooms.Room).\n"
                  + " Expected:\n" + _infoRoom + "\n"
                  + " Found:\n" + _existingRoom);
        }
        final HashMap<String, TableInfo.Column> _columnsCurrentUser = new HashMap<String, TableInfo.Column>(5);
        _columnsCurrentUser.put("id", new TableInfo.Column("id", "INTEGER", true, 1));
        _columnsCurrentUser.put("userName", new TableInfo.Column("userName", "TEXT", false, 0));
        _columnsCurrentUser.put("photoUrl", new TableInfo.Column("photoUrl", "TEXT", false, 0));
        _columnsCurrentUser.put("email", new TableInfo.Column("email", "TEXT", false, 0));
        _columnsCurrentUser.put("phoneNumber", new TableInfo.Column("phoneNumber", "TEXT", false, 0));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCurrentUser = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesCurrentUser = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoCurrentUser = new TableInfo("current_user", _columnsCurrentUser, _foreignKeysCurrentUser, _indicesCurrentUser);
        final TableInfo _existingCurrentUser = TableInfo.read(_db, "current_user");
        if (! _infoCurrentUser.equals(_existingCurrentUser)) {
          throw new IllegalStateException("Migration didn't properly handle current_user(com.raiyan.automate.Models.CurrentUser).\n"
                  + " Expected:\n" + _infoCurrentUser + "\n"
                  + " Found:\n" + _existingCurrentUser);
        }
      }
    }, "c6aa1cf67dbb42489cbdcbed2fb4c175", "10099acacf70c6177ab2d36c90dc35e3");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "ac","bulb","cooler","fan","lock","oven","surveillance","television","room","current_user");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `ac`");
      _db.execSQL("DELETE FROM `bulb`");
      _db.execSQL("DELETE FROM `cooler`");
      _db.execSQL("DELETE FROM `fan`");
      _db.execSQL("DELETE FROM `lock`");
      _db.execSQL("DELETE FROM `oven`");
      _db.execSQL("DELETE FROM `surveillance`");
      _db.execSQL("DELETE FROM `television`");
      _db.execSQL("DELETE FROM `room`");
      _db.execSQL("DELETE FROM `current_user`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public ACDao acDao() {
    if (_aCDao != null) {
      return _aCDao;
    } else {
      synchronized(this) {
        if(_aCDao == null) {
          _aCDao = new ACDao_Impl(this);
        }
        return _aCDao;
      }
    }
  }

  @Override
  public BulbDao bulbDao() {
    if (_bulbDao != null) {
      return _bulbDao;
    } else {
      synchronized(this) {
        if(_bulbDao == null) {
          _bulbDao = new BulbDao_Impl(this);
        }
        return _bulbDao;
      }
    }
  }

  @Override
  public CoolerDao coolerDao() {
    if (_coolerDao != null) {
      return _coolerDao;
    } else {
      synchronized(this) {
        if(_coolerDao == null) {
          _coolerDao = new CoolerDao_Impl(this);
        }
        return _coolerDao;
      }
    }
  }

  @Override
  public FanDao fanDao() {
    if (_fanDao != null) {
      return _fanDao;
    } else {
      synchronized(this) {
        if(_fanDao == null) {
          _fanDao = new FanDao_Impl(this);
        }
        return _fanDao;
      }
    }
  }

  @Override
  public LockDao lockDao() {
    if (_lockDao != null) {
      return _lockDao;
    } else {
      synchronized(this) {
        if(_lockDao == null) {
          _lockDao = new LockDao_Impl(this);
        }
        return _lockDao;
      }
    }
  }

  @Override
  public OvenDao ovenDao() {
    if (_ovenDao != null) {
      return _ovenDao;
    } else {
      synchronized(this) {
        if(_ovenDao == null) {
          _ovenDao = new OvenDao_Impl(this);
        }
        return _ovenDao;
      }
    }
  }

  @Override
  public SurvellianceDao survellianceDao() {
    if (_survellianceDao != null) {
      return _survellianceDao;
    } else {
      synchronized(this) {
        if(_survellianceDao == null) {
          _survellianceDao = new SurvellianceDao_Impl(this);
        }
        return _survellianceDao;
      }
    }
  }

  @Override
  public TelevisionDao televisionDao() {
    if (_televisionDao != null) {
      return _televisionDao;
    } else {
      synchronized(this) {
        if(_televisionDao == null) {
          _televisionDao = new TelevisionDao_Impl(this);
        }
        return _televisionDao;
      }
    }
  }

  @Override
  public RoomDao roomDao() {
    if (_roomDao != null) {
      return _roomDao;
    } else {
      synchronized(this) {
        if(_roomDao == null) {
          _roomDao = new RoomDao_Impl(this);
        }
        return _roomDao;
      }
    }
  }

  @Override
  public CurrentUserDao currentUserDao() {
    if (_currentUserDao != null) {
      return _currentUserDao;
    } else {
      synchronized(this) {
        if(_currentUserDao == null) {
          _currentUserDao = new CurrentUserDao_Impl(this);
        }
        return _currentUserDao;
      }
    }
  }
}
