package models;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import java.util.UUID;


public class Note {

	public  String id;
	public  String title;
	public  String description;
	
	
	public Note() {};
	
	public  Note( String id, String title, String description) {
		id = UUID.randomUUID().toString();
		this.id = id;
		this.title = title;
		this.description = description;
	}

	public static List<Note> notes ;
		static { notes = new ArrayList<Note>();
		//notes.add(new Note("","Jogging in park", "At least 10 miles is the goal"));
		//notes.add(new Note("","Pick-up posters from post-office", "They are only open from 9 am to 3 pm"));
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
	