import { db } from '../firebase/firebase-config';



export const loadNotes = async ( uid ) => {


    // se hace un get a la base de datos de firebase
    const notesSnap = await db.collection(`${ uid }/journal/notes`).get();
    const notes = [];

    notesSnap.forEach( snapHijo => {
        notes.push({
            id: snapHijo.id,
            ...snapHijo.data()
        })
    });
    
    return notes;
}



