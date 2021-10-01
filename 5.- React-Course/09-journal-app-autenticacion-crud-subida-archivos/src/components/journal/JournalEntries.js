import React from 'react'
import { useSelector } from 'react-redux';
import { JournalEntry } from './JournalEntry';

export const JournalEntries = () => {

    // obtenemos el arreglo de las notas
    const { notes } = useSelector( state => state.notes );

    return (
        <div className="journal__entries">
            
            {
                notes.map( note => (
                    <JournalEntry 
                        key={ note.id }  //le mandamos a los entri la key que es el id
                        { ...note } //extramenos cada una de las propiedades que tenga cada nota
                    />
                ))
            }

        </div>
    )
}
