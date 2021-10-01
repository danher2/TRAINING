import React, { useEffect, useRef } from 'react';
import { useSelector, useDispatch } from 'react-redux';

import { NotesAppBar } from './NotesAppBar';
import { useForm } from '../../hooks/useForm';
import { activeNote, startDeleting } from '../../actions/notes';


//simplemente edita la nota seleccionada y cuando click en el boton save lo guarda en fire base

export const NoteScreen = () => {

    const dispatch = useDispatch();

    const { active:note } = useSelector( state => state.notes ); // necesitamos la nota activa renombrando el active como note
    const [ formValues, handleInputChange, reset ] = useForm( note ); 
    const { body, title, id } = formValues; // extraemos  lo  que vienen en el formValues

    const activeId = useRef( note.id );

    useEffect(() => {
        
        if ( note.id !== activeId.current ) { //si cambia la nota
            reset( note );  // resteamos  valores
            activeId.current = note.id  // reemplazamos id
        }

    }, [note, reset])// cuando cambia el estado de note ( cuando se modifica la nota)y del reset

    useEffect(() => {
        
        dispatch( activeNote( formValues.id, { ...formValues } ) );

    }, [formValues, dispatch])


    const handleDelete = () => {
        dispatch( startDeleting( id ) );
    }


    return (
        <div className="notes__main-content">
            
            <NotesAppBar />

            <div className="notes__content">

                <input 
                    type="text"
                    placeholder="Some awesome title"
                    className="notes__title-input"
                    autoComplete="off"
                    name="title"
                    value={ title }
                    onChange={ handleInputChange }
                />

                <textarea
                    placeholder="What happened today"
                    className="notes__textarea"
                    name="body"
                    value={ body }
                    onChange={ handleInputChange }
                ></textarea>

                {
                    (note.url) // si el url esta en la nota, si eso existe, sie es true
                    && (
                        <div className="notes__image">
                            <img 
                                src={ note.url }
                                alt="imagen"
                            />
                        </div>
                    )
                }


            </div>


            <button 
                className="btn btn-danger"
                onClick={ handleDelete }
            >
                Delete
            </button>

        </div>
    )
}
