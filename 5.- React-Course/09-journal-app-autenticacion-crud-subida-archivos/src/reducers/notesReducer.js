
//ESTADO INICIAL DE LAS NOTES

/*
    {
        notes: [],
        active: null,
        active: {
            id: 'KASKLDJALKSDJ129387123',
            title: '',
            body: '',
            imageUrl: '',
            date: 12387612387126
        }
    }
*/

import { types } from '../types/types';

const initialState = {
    notes: [],
    active: null
}

//CREAMOS funcion reducer es una funcion pura
//recibe state y el action
export const notesReducer = ( state = initialState, action ) => {

    switch (action.type) {
        
        case types.notesActive:
            return {
                ...state, //clonacion del estado dela nota
                active: { // me reemplaze active por el nuevo payload
                    ...action.payload // sspread del action. payload para clonar
                }
            }
        
        case  types.notesAddNew:
            return {
                ...state,
                notes: [ action.payload, ...state.notes ]
            }

        case types.notesLoad:
            return {
                ...state,
                notes: [ ...action.payload ]
            }
    
        case types.notesUpdated:
            return {
                ...state,
                notes: state.notes.map(
                    note => note.id === action.payload.id// si coincide con el id de la nota que quiero modificar?
                        ? action.payload.note
                        : note
                )
            }

        case types.notesDelete:
            return {
                ...state,
                active: null,
                notes: state.notes.filter( note => note.id !== action.payload )
            } 

        case types.notesLogoutCleaning:
            return {
                ...state,
                active: null,
                notes: []
            }

        default:
            return state
    }


}