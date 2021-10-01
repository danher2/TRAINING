import { db } from '../firebase/firebase-config';



export const loadNotes = async ( uid ) => {

    // se guarda el resultado de la promesa en noteSnap
    const notesSnap = await db.collection(`${ uid }/journal/notes`).get(); // get devuelve una promesa por lo tanto el await (para que lo haga de forma secuencial) que debe ir dentro de un async
    const notes = [];

    //recorremos el notesSnap que recorre a sus elementos hijos recorre la informacion de collection en el notesSanap
    notesSnap.forEach( snapHijo => {
        notes.push({ //anadir un nuevo elemento
            id: snapHijo.id,
            ...snapHijo.data() //clonamos demas elementos
        })
    });
    
    return notes;
}



