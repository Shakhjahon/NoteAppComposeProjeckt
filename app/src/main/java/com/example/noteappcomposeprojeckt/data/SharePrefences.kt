package com.example.noteappcomposeprojeckt.data

import android.content.Context
import com.example.noteappcomposeprojeckt.data.model.NotesModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

private const val SHARED_PREFERENCES_KEY = "SHARED_PREFERENCES_KEY"
private const val NOTES_SHARED_PREF = "NOTES_SHARED_PREF"

class SharePrefences(
    context: Context
) {

    private val sharedPreferences = context.getSharedPreferences(
        SHARED_PREFERENCES_KEY, Context.MODE_PRIVATE
    )

    fun saveNote(notesModel: NotesModel) {
        val notes = getAllNotes().toMutableList()
        notes.add(0, notesModel)
        val notesGson = Gson().toJson(notes)
        sharedPreferences
            .edit()
            .putString(NOTES_SHARED_PREF, notesGson)
            .apply()
    }

    fun getAllNotes(): List<NotesModel> {
        val gson = Gson()
        val json = sharedPreferences.getString(NOTES_SHARED_PREF, null)
        val type: Type = object : TypeToken<ArrayList<NotesModel?>?>() {}.type
        val noteList = gson.fromJson<List<NotesModel>>(json, type)
        return noteList ?: emptyList()
    }
}