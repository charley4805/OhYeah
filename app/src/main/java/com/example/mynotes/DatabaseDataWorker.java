package com.example.mynotes;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;



public class DatabaseDataWorker {
    private SQLiteDatabase mDb;

    public DatabaseDataWorker(SQLiteDatabase db) {
        mDb = db;
    }

    public void insertCourses() {
        insertCourse("wheeler", "4 Wheeler");
        insertCourse("motorcycle", "Motorcycle");
        insertCourse("boat",  "Boat");
        insertCourse("auto",  "Auto");
        insertCourse("other", "Other");
    }

    public void insertSampleNotes() {
        insertNote("boat", "yacht", "name, engine");
        insertNote("auto", "Subaru Ascent", "Model, Engine, Tag, Vin,  ");

        insertNote("wheeler", "Yamaha", "Model, Engine, wheel size");
        insertNote("auto", "Lincoln", "Model, Engine, Tag, Vin,");
    }

    private void insertCourse(String courseId, String title) {
        ContentValues values = new ContentValues();
        values.put(NoteKeeperDatabaseContract.CourseInfoEntry.COLUMN_COURSE_ID, courseId);
        values.put(NoteKeeperDatabaseContract.CourseInfoEntry.COLUMN_COURSE_TITLE, title);

        long newRowId = mDb.insert(NoteKeeperDatabaseContract.CourseInfoEntry.TABLE_NAME, null, values);
    }

     private void insertNote(String courseId, String title, String text) {
        ContentValues values = new ContentValues();
        values.put(NoteKeeperDatabaseContract.NoteInfoEntry.COLUMN_COURSE_ID, courseId);
        values.put(NoteKeeperDatabaseContract.NoteInfoEntry.COLUMN_NOTE_TITLE, title);
        values.put(NoteKeeperDatabaseContract.NoteInfoEntry.COLUMN_NOTE_TEXT, text);

        long newRowId = mDb.insert(NoteKeeperDatabaseContract.NoteInfoEntry.TABLE_NAME, null, values);
    }

}
