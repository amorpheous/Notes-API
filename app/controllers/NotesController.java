package controllers;

import java.util.List;

import models.Note;
import play.mvc.Controller;
import play.mvc.Http.RequestBody;
import play.mvc.Result;
import play.mvc.Results;
import play.data.FormFactory;
import play.data.Form;
import views.html.*;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class NotesController extends Controller {

	public FormFactory formFactory;
	
	@Inject
	public NotesController(FormFactory formFactory) {
		this.formFactory = formFactory;
	}
	
	//new note
	
	public Result newNote() {
		Form<Note> noteForm = formFactory.form(Note.class);
		return ok(noteform.render(noteForm));
	}
	
	//save
	
		
		public Result save()  {
			Form<Note> noteForm = formFactory.form(Note.class);
			Form<Note> boundForm = noteForm.bindFromRequest();
			Note note = boundForm.get();
			note.save();
			return redirect(routes.NotesController.list());
		}
			

	//get
	
	public Result get(String id) {
		Form<Note> noteForm = formFactory.form(Note.class);
		    Note note = Note.findById(id);
		    if (note == null) {
		      return notFound(String.format("Product %s doesn't exist.", id));
		    }
		    List<Note> listNote = new ArrayList();
		    listNote.add(note);
		    return ok(list.render(listNote));
			}

	//update
	
 
	public Result update(String id) {
		Form<Note> noteForm = formFactory.form(Note.class);
	    Note note = Note.findById(id);
	    Form<Note> filledForm = noteForm.fill(note);
	    return ok(noteform.render(filledForm));
		}
				

	//list
	
	public Result list() {
			List<Note> notes = Note.findAll();
				return ok(list.render(notes));
			} 
	
	//delete
	
	public Result delete(String id) {
		Note note = Note.findById(id);
        note.remove(note);
        return redirect(routes.NotesController.list());
		} 
}