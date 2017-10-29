package models;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;


public class Note {

	public  String id;
	public  String title;
	public  String description;
	
	
	public Note() {};
	
	public  Note( String id, String title, String description) {
		this.id = id;
		this.title = title;
		this.description = description;
	}

	public static List<Note> notes ;
		static { notes = new ArrayList<Note>();
		}
	
	
	public static List<Note> findAll() {
	    return new ArrayList<Note>(notes);
	  }
	
	  public static  Note findById(String id) {
	    for (Note note : notes) {
	      if (note.id.equals(id)) {
	        return note;
	      } 
	    }
	    return null;
	}
	 
	  public boolean remove(Note note) {
	    return notes.remove(note);
	}
	  public void save() {
	    notes.remove(findById(this.id));
	    notes.add(this);
	  } 
}
	