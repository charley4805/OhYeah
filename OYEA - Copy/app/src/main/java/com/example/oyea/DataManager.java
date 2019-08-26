package com.example.oyea;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jim.
 */

public class DataManager {
    private static DataManager ourInstance = null;

    private List<AutoInfo> mAuto = new ArrayList<>();
    private List<NoteInfo> mNotes = new ArrayList<>();

    public static DataManager getInstance() {
        if(ourInstance == null) {
            ourInstance = new DataManager();
            ourInstance.initializeAutos();
            ourInstance.initializeExampleNotes();
        }
        return ourInstance;
    }

    public String getCurrentUserName() {
        return "Jim Wilson";
    }

    public String getCurrentUserEmail() {
        return "jimw@jwhh.com";
    }

    public List<NoteInfo> getNotes() {
        return mNotes;
    }

    public int createNewNote() {
        NoteInfo note = new NoteInfo(null, null, null);
        mNotes.add(note);
        return mNotes.size() - 1;
    }

    public int findNote(NoteInfo note) {
        for(int index = 0; index < mNotes.size(); index++) {
            if(note.equals(mNotes.get(index)))
                return index;
        }

        return -1;
    }

    public void removeNote(int index) {
        mNotes.remove(index);
    }

    public List<AutoInfo> getAutos() {
        return mAuto;
    }

    public AutoInfo getAuto(String id) {
        for (AutoInfo auto: mAuto) {
            if (id.equals(auto.getAutoId()))
                return auto;
        }
        return null;
    }

    public List<NoteInfo> getNotes(AutoInfo auto) {
        ArrayList<NoteInfo> notes = new ArrayList<>();
        for(NoteInfo note:mNotes) {
            if(auto.equals(note.getAuto()))
                notes.add(note);
        }
        return notes;
    }

    public int getNoteCount(AutoInfo auto) {
        int count = 0;
        for(NoteInfo note:mNotes) {
            if(auto.equals(note.getAuto()))
                count++;
        }
        return count;
    }

    private DataManager() {
    }

    //region Initialization code

    private void initializeAutos() {
        mAuto.add(initializeAuto1());
        mAuto.add(initializeAuto2());
        mAuto.add(initializeAuto3());
        mAuto.add(initializeAuto4());
    }

    public void initializeExampleNotes() {
        final DataManager dm = getInstance();

        AutoInfo auto = dm.getAuto("android_intents");
        auto.getModule("android_intents_m01").setComplete(true);
        auto.getModule("android_intents_m02").setComplete(true);
        auto.getModule("android_intents_m03").setComplete(true);
        mNotes.add(new NoteInfo(auto, "Dynamic intent resolution",
                "Wow, intents allow components to be resolved at runtime"));
        mNotes.add(new NoteInfo(auto, "Delegating intents",
                "PendingIntents are powerful; they delegate much more than just a component invocation"));

        auto = dm.getAuto("android_async");
        auto.getModule("android_async_m01").setComplete(true);
        auto.getModule("android_async_m02").setComplete(true);
        mNotes.add(new NoteInfo(auto, "Service default threads",
                "Did you know that by default an Android Service will tie up the UI thread?"));
        mNotes.add(new NoteInfo(auto, "Long running operations",
                "Foreground Services can be tied to a notification icon"));

        auto = dm.getAuto("java_lang");
        auto.getModule("java_lang_m01").setComplete(true);
        auto.getModule("java_lang_m02").setComplete(true);
        auto.getModule("java_lang_m03").setComplete(true);
        auto.getModule("java_lang_m04").setComplete(true);
        auto.getModule("java_lang_m05").setComplete(true);
        auto.getModule("java_lang_m06").setComplete(true);
        auto.getModule("java_lang_m07").setComplete(true);
        mNotes.add(new NoteInfo(auto, "Parameters",
                "Leverage variable-length parameter lists"));
        mNotes.add(new NoteInfo(auto, "Anonymous classes",
                "Anonymous classes simplify implementing one-use types"));

        auto = dm.getAuto("java_core");
        auto.getModule("java_core_m01").setComplete(true);
        auto.getModule("java_core_m02").setComplete(true);
        auto.getModule("java_core_m03").setComplete(true);
        mNotes.add(new NoteInfo(auto, "Compiler options",
                "The -jar option isn't compatible with with the -cp optio   n"));
        mNotes.add(new NoteInfo(auto, "Serialization",
                "Remember to include SerialVersionUID to assure version compatibility"));
    }

    private AutoInfo initializeAuto1() {
        List<ModuleInfo> modules = new ArrayList<>();
        modules.add(new ModuleInfo("android_intents_m01", "Android Late Binding and Intents"));
        modules.add(new ModuleInfo("android_intents_m02", "Component activation with intents"));
        modules.add(new ModuleInfo("android_intents_m03", "Delegation and Callbacks through PendingIntents"));
        modules.add(new ModuleInfo("android_intents_m04", "IntentFilter data tests"));
        modules.add(new ModuleInfo("android_intents_m05", "Working with Platform Features Through Intents"));

        return new AutoInfo("android_intents", "Android Programming with Intents", modules);
    }

    private AutoInfo initializeAuto2() {
        List<ModuleInfo> modules = new ArrayList<>();
        modules.add(new ModuleInfo("android_async_m01", "Challenges to a responsive user experience"));
        modules.add(new ModuleInfo("android_async_m02", "Implementing long-running operations as a service"));
        modules.add(new ModuleInfo("android_async_m03", "Service lifecycle management"));
        modules.add(new ModuleInfo("android_async_m04", "Interacting with services"));

        return new AutoInfo("android_async", "Android Async Programming and Services", modules);
    }

    private AutoInfo initializeAuto3() {
        List<ModuleInfo> modules = new ArrayList<>();
        modules.add(new ModuleInfo("java_lang_m01", "Introduction and Setting up Your Environment"));
        modules.add(new ModuleInfo("java_lang_m02", "Creating a Simple App"));
        modules.add(new ModuleInfo("java_lang_m03", "Variables, Data Types, and Math Operators"));
        modules.add(new ModuleInfo("java_lang_m04", "Conditional Logic, Looping, and Arrays"));
        modules.add(new ModuleInfo("java_lang_m05", "Representing Complex Types with Classes"));
        modules.add(new ModuleInfo("java_lang_m06", "Class Initializers and Constructors"));
        modules.add(new ModuleInfo("java_lang_m07", "A Closer Look at Parameters"));
        modules.add(new ModuleInfo("java_lang_m08", "Class Inheritance"));
        modules.add(new ModuleInfo("java_lang_m09", "More About Data Types"));
        modules.add(new ModuleInfo("java_lang_m10", "Exceptions and Error Handling"));
        modules.add(new ModuleInfo("java_lang_m11", "Working with Packages"));
        modules.add(new ModuleInfo("java_lang_m12", "Creating Abstract Relationships with Interfaces"));
        modules.add(new ModuleInfo("java_lang_m13", "Static Members, Nested Types, and Anonymous Classes"));

        return new AutoInfo("java_lang", "Java Fundamentals: The Java Language", modules);
    }

    private AutoInfo initializeAuto4() {
        List<ModuleInfo> modules = new ArrayList<>();
        modules.add(new ModuleInfo("java_core_m01", "Introduction"));
        modules.add(new ModuleInfo("java_core_m02", "Input and Output with Streams and Files"));
        modules.add(new ModuleInfo("java_core_m03", "String Formatting and Regular Expressions"));
        modules.add(new ModuleInfo("java_core_m04", "Working with Collections"));
        modules.add(new ModuleInfo("java_core_m05", "Controlling App Execution and Environment"));
        modules.add(new ModuleInfo("java_core_m06", "Capturing Application Activity with the Java Log System"));
        modules.add(new ModuleInfo("java_core_m07", "Multithreading and Concurrency"));
        modules.add(new ModuleInfo("java_core_m08", "Runtime Type Information and Reflection"));
        modules.add(new ModuleInfo("java_core_m09", "Adding Type Metadata with Annotations"));
        modules.add(new ModuleInfo("java_core_m10", "Persisting Objects with Serialization"));

        return new AutoInfo("java_core", "Java Fundamentals: The Core Platform", modules);
    }

    public int createNewNote(AutoInfo auto, String noteTitle, String noteText) {
        int index = createNewNote();
        NoteInfo note = getNotes().get(index);
        note.setAuto(auto);
        note.setTitle(noteTitle);
        note.setText(noteText);

        return index;
    }
    //endregion

}
